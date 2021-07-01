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

public class EntityFyracryx extends EntityDivineTameable implements IRangedAttackMob{
	
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
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (this.isTame()) {
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
        return super.mobInteract(player, hand);
    }
    
    @Override
    public void tick() {
        super.tick();
        if (this.getTarget() != null && !this.level.isClientSide && this.tickCount % 20 == 0)
            this.performRangedAttack(this.getTarget(), 0);
    }

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		double tx = target.xo - this.xo;
        double ty = target.getBoundingBox().minY - this.xo;
        double tz = target.zo - this.zo;
        float dist = MathHelper.sqrt(this.distanceTo(this)) * 0.5F;
        this.level.levelEvent(null, 1018, new BlockPos((int) this.blockPosition().getX(), (int) this.blockPosition().getY(), (int) this.blockPosition().getZ()),
                0);

        EntityFyracryxFireball shot = new EntityFyracryxFireball(this.level, this, tx + this.random.nextGaussian() * dist,
                ty, tz + this.random.nextGaussian() * dist);
        shot.yo = this.blockPosition().getX() + this.getEyeHeight() / 2.0F + 0.5D;
        this.level.addFreshEntity(shot);
	}
}
