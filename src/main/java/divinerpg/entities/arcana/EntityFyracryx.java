package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.entities.projectile.EntityFyracryxFireball;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class EntityFyracryx extends EntityDivineTameable implements RangedAttackMob {

    public EntityFyracryx(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }

    public EntityFyracryx(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn);
        setHealth(getMaxHealth());
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.85F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DEATHCRYX.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DEATHCRYX_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DEATHCRYX.get();
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.level().isClientSide) {
            ItemStack itemstack = player.getItemInHand(hand);
            Item item = itemstack.getItem();
            if (this.isTame()) {
                if (item.getFoodProperties(itemstack, null) != null) {
                    if (item.getFoodProperties(itemstack, null).isMeat() && this.getHealth() < this.getMaxHealth()) {
                        if (!player.isCreative()) {
                            itemstack.shrink(1);
                        }
                        this.heal((float) item.getFoodProperties(itemstack, null).getNutrition());
                        return InteractionResult.PASS;
                    } else {
                        tame(player);
                        this.setTame(true);
                    }
                }
            }
            return super.mobInteract(player, hand);
        }
        return InteractionResult.PASS;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getTarget() != null && !this.level().isClientSide && this.tickCount % 20 == 0)
            this.performRangedAttack(this.getTarget(), 0);
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (isAlive() && getTarget() != null && !level().isClientSide) {
            EntityFyracryxFireball projectile = new EntityFyracryxFireball(level(), this, target.xo - xo + random.nextGaussian() * Mth.sqrt(this.distanceTo(this)) * 0.5F, target.getBoundingBox().minY - this.xo,
                target.zo - zo + random.nextGaussian() * Mth.sqrt(distanceTo(this)) * 0.5F);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.8F);
            this.level().addFreshEntity(projectile);
        }
    }
}
