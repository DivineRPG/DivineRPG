package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityFyracryx extends EntityDivineTameable implements IRangedAttackMob{
	
	public EntityFyracryx(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        setTamedBy(player);
    }
	
	public <T extends Entity> EntityFyracryx(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }
	
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.85F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return TameableEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.fyracryxHealth).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.fyracryxSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.fyracryxFollowRange);
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
    
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item item = itemstack.getItem();
        if (this.isTamed()) {
            if (item.getFood().isMeat() && this.getHealth() < this.getMaxHealth()) {
                if (!player.abilities.isCreativeMode) {
                    itemstack.shrink(1);
                }
                this.heal((float) item.getFood().getHealing());
                return ActionResultType.PASS;
            } else {
                setTamedBy(player);
                this.playTameEffect(true);
            }
        }
        return super.func_230254_b_(player, hand);
    }
    
    @Override
    public void tick() {
        super.tick();
        if (this.getAttackTarget() != null && !this.world.isRemote && this.ticksExisted % 20 == 0)
            this.attackEntityWithRangedAttack(this.getAttackTarget(), 0);
    }

	@Override
	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
		// TODO EntityFyracryxFireball
		/*
		double tx = target.getPosX() - this.getPosX();
        double ty = target.getBoundingBox().minY - this.getPosX();
        double tz = target.getPosZ() - this.getPosZ();
        float dist = MathHelper.sqrt(this.getDistance(this)) * 0.5F;
        this.world.playEvent(null, 1018, new BlockPos((int) this.getPosX(), (int) this.getPosY(), (int) this.getPosZ()),
                0);

        EntityFyracryxFireball shot = new EntityFyracryxFireball(this.world, this, tx + this.rand.nextGaussian() * dist,
                ty, tz + this.rand.nextGaussian() * dist);
        shot.posY = this.getPosX() + this.getHeight() / 2.0F + 0.5D;
        this.world.spawnEntity(shot);
        */
	}
}
