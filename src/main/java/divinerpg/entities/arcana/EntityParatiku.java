package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.util.EntityStats;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

public class EntityParatiku extends EntityDivineTameable {
	
	private static final DataParameter<Byte> HANGING = EntityDataManager.defineId(EntityParatiku.class, DataSerializers.BYTE);
    private static final EntityPredicate RESTING_TARGETING = (new EntityPredicate()).range(4.0D).allowSameTeam();

	private BlockPos spawnPosition;
	
	public EntityParatiku(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
        this.setIsParatikuHanging(true);
    }
	
	public <T extends Entity> EntityParatiku(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
        this.setIsParatikuHanging(true);
    }
	
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.getBbHeight() / 2.0F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return TameableEntity.createMobAttributes().add(Attributes.MAX_HEALTH, EntityStats.paratikuHealth).add(Attributes.MOVEMENT_SPEED, EntityStats.paratikuSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.paratikuFollowRange);
    }
    
    protected void defineSynchedData()
    {
        super.defineSynchedData();
        this.entityData.define(HANGING, Byte.valueOf((byte)0));
    }

    public boolean isPushable() {
        return false;
    }

    protected void doPush(Entity ent) {
    }

    protected void pushEntities() {
    }
    protected boolean isMovementNoisy() {
        return false;
    }

    public boolean causeFallDamage(float damage, float multiplier) {
        return false;
    }

    protected void checkFallDamage(double p_184231_1_, boolean p_184231_3_, BlockState p_184231_4_, BlockPos p_184231_5_) {
    }

    @Override
    public boolean isIgnoringBlockTriggers() {
        return true;
    }
    
    protected float getSoundVolume()
    {
        return 0.1F;
    }
    
    protected float getVoicePitch()
    {
        return super.getVoicePitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
    	return this.getIsParatikuHanging() && this.random.nextInt(4) != 0 ? null : SoundEvents.BAT_AMBIENT;
    }
    
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.BAT_HURT;
    }
    
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.BAT_DEATH;
    }


    public boolean getIsParatikuHanging() {
        return (this.entityData.get(HANGING).byteValue() & 1) != 0;
    }
    
    public void setIsParatikuHanging(boolean isHanging) {
        byte b0 = this.entityData.get(HANGING).byteValue();

        if (isHanging) {
            this.entityData.set(HANGING, Byte.valueOf((byte) (b0 | 1)));
        } else {
            this.entityData.set(HANGING, Byte.valueOf((byte) (b0 & -2)));
        }
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
    
    public void tick()
    {
        super.tick();

        if (this.getIsParatikuHanging())
        {
            this.setDeltaMovement(0.0D, 0.0D, 0.0D);
            this.setPosRaw(this.getX(), (double)MathHelper.floor(this.getY()) + 1.0D - (double)this.getBbHeight(), this.getZ());
        }
        else
        {
            this.setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y * 0.6000000238418579D, getDeltaMovement().z);
        }
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        BlockPos blockpos = this.blockPosition();
        BlockPos blockpos1 = blockpos.above();
        if (this.getIsParatikuHanging()) {
            boolean flag = this.isSilent();
            if (this.level.getBlockState(blockpos1).isRedstoneConductor(this.level, blockpos)) {
                if (this.random.nextInt(200) == 0) {
                    this.yHeadRot = (float)this.random.nextInt(360);
                }

                if (this.level.getNearestPlayer(RESTING_TARGETING, this) != null) {
                    this.setIsParatikuHanging(false);
                    if (!flag) {
                        this.level.levelEvent((PlayerEntity)null, 1025, blockpos, 0);
                    }
                }
            } else {
                this.setIsParatikuHanging(false);
                if (!flag) {
                    this.level.levelEvent((PlayerEntity)null, 1025, blockpos, 0);
                }
            }
        } else {
            if (this.getTarget().blockPosition() != null && (!this.level.isEmptyBlock(this.getTarget().blockPosition()) || this.getTarget().blockPosition().getY() < 1)) {
            }

            if (this.getTarget().blockPosition() == null || this.random.nextInt(30) == 0 || this.getTarget().blockPosition().closerThan(this.position(), 2.0D)) {
                this.moveTo(this.getX() + (double)this.random.nextInt(7) - (double)this.random.nextInt(7), this.getY() + (double)this.random.nextInt(6) - 2.0D, this.getZ() + (double)this.random.nextInt(7) - (double)this.random.nextInt(7));
            }

            double d2 = (double)this.getTarget().blockPosition().getX() + 0.5D - this.getX();
            double d0 = (double)this.getTarget().blockPosition().getY() + 0.1D - this.getY();
            double d1 = (double)this.getTarget().blockPosition().getZ() + 0.5D - this.getZ();
            Vector3d vector3d = this.getDeltaMovement();
            Vector3d vector3d1 = vector3d.add((Math.signum(d2) * 0.5D - vector3d.x) * (double)0.1F, (Math.signum(d0) * (double)0.7F - vector3d.y) * (double)0.1F, (Math.signum(d1) * 0.5D - vector3d.z) * (double)0.1F);
            this.setDeltaMovement(vector3d1);
            float f = (float)(MathHelper.atan2(vector3d1.z, vector3d1.x) * (double)(180F / (float)Math.PI)) - 90.0F;
            float f1 = MathHelper.wrapDegrees(f - this.yRot);
            this.zza = 0.5F;
            this.yRot += f1;
            if (this.random.nextInt(100) == 0 && this.level.getBlockState(blockpos1).isRedstoneConductor(this.level, blockpos1)) {
                this.setIsParatikuHanging(true);
            }
        }

    }


    public boolean hurt(DamageSource source, float amount)
    {
        if (source.isCreativePlayer())
        {
            return false;
        }
        else
        {
            if (!this.level.isClientSide && this.getIsParatikuHanging())
            {
                this.setIsParatikuHanging(false);
            }

            return super.hurt(source, amount);
        }
    }
    
    public void readAdditionalSaveData(CompoundNBT compound)
    {
        super.readAdditionalSaveData(compound);
        this.entityData.set(HANGING, Byte.valueOf(compound.getByte("ParatikuFlags")));
    }
    
    public void addAdditionalSaveData(CompoundNBT compound)
    {
        super.addAdditionalSaveData(compound);
        if (this.getOwnerUUID() == null) {
            compound.putString("Owner", "");
        } else {
            compound.putString("Owner", this.getOwnerUUID().toString());
        }
        compound.putByte("ParatikuFlags", this.entityData.get(HANGING).byteValue());
    }
}
