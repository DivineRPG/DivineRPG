package divinerpg.entities.arcana;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityFyracryx extends EntityDivineTameable implements IRangedAttackMob {

    public EntityFyracryx(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }

    public <T extends Entity> EntityFyracryx(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.85F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return TameableEntity.createMobAttributes().add(Attributes.MAX_HEALTH, EntityStats.fyracryxHealth).add(Attributes.MOVEMENT_SPEED, EntityStats.fyracryxSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.fyracryxFollowRange);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DEATHCRYX;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DEATHCRYX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DEATHCRYX;
    }

    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        if (!this.level.isClientSide) {
            ItemStack itemstack = player.getItemInHand(hand);
            Item item = itemstack.getItem();
            if (this.isTame()) {
                if (item.getFoodProperties() != null) {
                    if (item.getFoodProperties().isMeat() && this.getHealth() < this.getMaxHealth()) {
                        if (!player.isCreative()) {
                            itemstack.shrink(1);
                        }
                        this.heal((float) item.getFoodProperties().getNutrition());
                        return ActionResultType.PASS;
                    } else {
                        tame(player);
                        this.setTame(true);
                    }
                }
            }
            return super.mobInteract(player, hand);
        }
        return ActionResultType.PASS;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getTarget() != null && !this.level.isClientSide && this.tickCount % 20 == 0)
            this.performRangedAttack(this.getTarget(), 0);
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (getTarget() != null && this.isAlive()) {
            EntityFyracryxFireball projectile = new EntityFyracryxFireball(level, this, target.xo - xo + random.nextGaussian() * MathHelper.sqrt(this.distanceTo(this)) * 0.5F, target.getBoundingBox().minY - this.xo,
                    target.zo - zo + random.nextGaussian() * MathHelper.sqrt(distanceTo(this)) * 0.5F);
            double d0 = target.getX() - this.getX();
            double d1 = target.getY(0.3333333333333333D) - projectile.getY();
            double d2 = target.getZ() - this.getZ();
            double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
            this.level.addFreshEntity(projectile);
        }
    }
}
