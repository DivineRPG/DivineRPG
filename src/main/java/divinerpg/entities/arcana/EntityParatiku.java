package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.sounds.*;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class EntityParatiku extends EntityDivineTameable {
    private static final EntityDataAccessor<Byte> HANGING = SynchedEntityData.defineId(EntityParatiku.class, EntityDataSerializers.BYTE);
    private static final TargetingConditions RESTING_TARGETING = TargetingConditions.forCombat().range(4.0D)/*.allowSameTeam()*/;
    //private BlockPos spawnPosition;
    public EntityParatiku(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
        setIsParatikuHanging(true);
    }
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.1875F;}
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(HANGING, (byte) 0);
    }
    @Override public boolean isPushable() {return false;}
    @Override protected void doPush(Entity ent) {}
    @Override protected void pushEntities() {}
    @Override protected void checkFallDamage(double d, boolean b, BlockState s, BlockPos p) {}
    @Override public boolean isIgnoringBlockTriggers() {return true;}
    @Override protected float getSoundVolume() {return .1F;}
    @Override public float getVoicePitch() {return super.getVoicePitch() * .95F;}
    @Override protected SoundEvent getAmbientSound() {return getIsParatikuHanging() && random.nextInt(4) != 0 ? null : SoundEvents.BAT_AMBIENT;}
    @Override protected SoundEvent getHurtSound(DamageSource damageSourceIn) {return SoundEvents.BAT_HURT;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.BAT_DEATH;}
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
    @Override
    public void tick() {
        super.tick();
        if(getIsParatikuHanging()) {
            setDeltaMovement(0D, 0D, 0D);
            setPosRaw(getX(), (double) Mth.floor(getY()) + 1D - getBbHeight(), getZ());
        } else setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y * 0.6000000238418579D, getDeltaMovement().z);
    }
    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        BlockPos blockpos = blockPosition();
        BlockPos blockpos1 = blockpos.above();
        if(getIsParatikuHanging()) {
            boolean flag = isSilent();
            if(level().getBlockState(blockpos1).isRedstoneConductor(level(), blockpos)) {
                if(random.nextInt(200) == 0) yHeadRot = (float) random.nextInt(360);
                if(level().getNearestPlayer(RESTING_TARGETING, this) != null) {
                    setIsParatikuHanging(false);
                    if(!flag) level().levelEvent(null, 1025, blockpos, 0);
                }
            } else {
                setIsParatikuHanging(false);
                if(!flag) level().levelEvent(null, 1025, blockpos, 0);
            }
        } else {
            if(getTarget() != null) {
                getTarget().blockPosition();
                if(random.nextInt(30) == 0 || getTarget().blockPosition().closerToCenterThan(position(), 2D))
                    moveTo(getX() + random.nextInt(7) - random.nextInt(7), getY() + random.nextInt(6) - 2D, getZ() + random.nextInt(7) - random.nextInt(7));
                double d2 = getTarget().blockPosition().getX() + .5D - getX();
                double d0 = getTarget().blockPosition().getY() + .1D - getY();
                double d1 = getTarget().blockPosition().getZ() + .5D - getZ();
                Vec3 vector3d = getDeltaMovement();
                Vec3 vector3d1 = vector3d.add((Math.signum(d2) * .5 - vector3d.x) * .1, (Math.signum(d0) * .7 - vector3d.y) * .1, (Math.signum(d1) * .5 - vector3d.z) * .1);
                setDeltaMovement(vector3d1);
                float f = (float) (Mth.atan2(vector3d1.z, vector3d1.x) * (180F / Math.PI)) - 90F;
                float f1 = Mth.wrapDegrees(f - yRot);
                zza = .5F;
                yRot += f1;
                if(random.nextInt(100) == 0 && level().getBlockState(blockpos1).isRedstoneConductor(level(), blockpos1)) setIsParatikuHanging(true);
            }
        }
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(source.isCreativePlayer()) return false;
        else {
            if(!level().isClientSide() && getIsParatikuHanging()) setIsParatikuHanging(false);
            return super.hurt(source, amount);
        }
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        entityData.set(HANGING, Byte.valueOf(compound.getByte("ParatikuFlags")));
    }
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        if(getOwnerUUID() == null) compound.putString("Owner", "");
        else compound.putString("Owner", getOwnerUUID().toString());
        compound.putByte("ParatikuFlags", entityData.get(HANGING).byteValue());
    }
}
