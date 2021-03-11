package divinerpg.entities.arcana;

import javax.annotation.Nullable;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.*;

public class EntityWraith extends EntityDivineTameable {
	
    private BlockPos currentFlightTarget;
	
	public EntityWraith(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        setTamedBy(player);
    }
	
	public <T extends Entity> EntityWraith(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }
	
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.5F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return TameableEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.seimerHealth).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.seimerSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.seimerFollowRange);
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
    public boolean attackEntityAsMob(Entity entity) {
        float damage = (float) getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();

        if (this.isPotionActive(Effects.STRENGTH)) {
            damage += 3 << this.getActivePotionEffect(Effects.STRENGTH).getAmplifier();
        }
        if (this.isPotionActive(Effects.WEAKNESS)) {
            damage -= 2 << this.getActivePotionEffect(Effects.WEAKNESS).getAmplifier();
        }

        int knockback = 0;
        if (entity instanceof LivingEntity) {
            damage += EnchantmentHelper.getEfficiencyModifier((LivingEntity) entity);
            knockback += EnchantmentHelper.getKnockbackModifier((LivingEntity) entity);
        }

        boolean attacked = entity.attackEntityFrom(DamageSource.causeMobDamage(this), damage);

        if (attacked) {
            if (knockback > 0) {
                entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * knockback * 0.5F,
                        0.1D, MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * knockback * 0.5F);
                this.setMotion(getMotion().x * 0.6D, getMotion().y, getMotion().z * 0.6D);
            }

            int fire = EnchantmentHelper.getFireAspectModifier(this);
            if (fire > 0) {
                entity.setFire(fire * 4);
            }
        }

        return attacked;
    }
    
    public void writeEntityToNBT(CompoundNBT compound) {
        super.writeAdditional(compound);
        if (this.getOwnerId() == null) {
            compound.putString("Owner", "");
        } else {
            compound.putString("Owner", this.getOwnerId().toString());
        }
        compound.putBoolean("Sitting", this.isSitting());
    }
    
    public void readEntityFromNBT(CompoundNBT compound) {
        super.readAdditional(compound);
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.1F;
    }
    
    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }
    
    @Nullable
    @Override
    public SoundEvent getAmbientSound() {
        return this.getIsBatHanging() && this.rand.nextInt(4) != 0 ? null : SoundRegistry.WRAITH;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundRegistry.WRAITH_HURT;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.WRAITH_HURT;
    }
    
    @Override
    public boolean canBePushed() {
        return false;
    }
    
    @Override
    protected void collideWithEntity(Entity entityIn) {
    }

    @Override
    protected void collideWithNearbyEntities() {
    }

    public boolean getIsBatHanging() {
        return false;
    }
    
    @Override
    public void tick() {
        super.tick();
        if (this.getIsBatHanging()) {
            this.setMotion(0.0D, 0.0D, 0.0D);
            this.setPosition(getPosX(), (double) MathHelper.floor(this.getPosY()) + 1.0D - (double) this.getHeight(), getPosZ());
        } else {
            this.setMotion(getMotion().x, getMotion().y * 0.6000000238418579D, getMotion().z);
        }
    }
    
    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        if (this.getAttackTarget() != null) {
            int x = (int) this.getAttackTarget().getPosX();
            int y = (int) this.getAttackTarget().getPosY();
            int z = (int) this.getAttackTarget().getPosZ();
            this.currentFlightTarget = new BlockPos(x, y, z);
        } else if (this.getOwner() != null) {
            this.currentFlightTarget = this.getOwner().getPosition();
        }

        if (this.getIsBatHanging()) {
            if (!this.world
                    .getBlockState(
                            new BlockPos(MathHelper.floor(this.getPosX()), (int) this.getPosY() + 1, MathHelper.floor(this.getPosZ())))
                    .isNormalCube(world, currentFlightTarget)) {
                this.world.playEvent(null, 1025,
                        new BlockPos((int) this.getPosX(), (int) this.getPosY(), (int) this.getPosZ()), 0);
            } else {
                if (this.rand.nextInt(200) == 0) {
                    this.rotationYawHead = this.rand.nextInt(360);
                }

                if (this.world.getClosestPlayer(this, 4.0D) != null) {
                    this.world.playEvent(null, 1025,
                            new BlockPos((int) this.getPosX(), (int) this.getPosY(), (int) this.getPosZ()), 0);
                }
            }
        } else {
            if (this.currentFlightTarget != null) {
                double x = this.currentFlightTarget.getX() - this.getPosX();
                double y = this.currentFlightTarget.getY() - this.getPosY();
                double z = this.currentFlightTarget.getZ() - this.getPosZ();

                if (Math.signum(x) != 0 || Math.signum(y) != 0 || Math.signum(z) != 0) {
                    this.setMotion(this.getMotion().x + (Math.signum(x) * 0.5D - this.getMotion().x) * 0.10000000149011612D, this.getMotion().y + (Math.signum(y) * 1.699999988079071D - this.getMotion().y) * 0.10000000149011612D, this.getMotion().z + (Math.signum(z) * 0.5D - this.getMotion().z) * 0.10000000149011612D);
                    float f = (float) (MathHelper.atan2(this.getMotion().z, this.getMotion().x) * (180D / Math.PI)) - 90.0F;
                    float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
                    this.moveForward = 0.5F;
                    this.rotationYaw += f1;
                }
            }
        }
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
    	return false;
    }
    
    @Override
    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }
    
    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (source.isCreativePlayer()) {
            return false;
        }
        	return super.attackEntityFrom(source, amount);
    }
}
