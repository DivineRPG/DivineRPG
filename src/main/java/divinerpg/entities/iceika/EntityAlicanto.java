package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.boss.EntityKitra;
import divinerpg.registries.SoundRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityAlicanto extends EntityDivineFlyingMob {
    private int attackTick;

    public EntityAlicanto(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {
        super(type, worldIn, 18F);
        this.fallDistance = 0;
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
    }
    @Override
    public void setTarget(LivingEntity entity) {
    	super.setTarget(entity != null && entity instanceof EntityKitra ? null : entity);
    }

    @Override
    public boolean isAggressive() {
        return true;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.05F;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_33353_) {
        super.addAdditionalSaveData(p_33353_);
        p_33353_.putInt("AttackTick", this.attackTick);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_33344_) {
        super.readAdditionalSaveData(p_33344_);
        this.attackTick = p_33344_.getInt("AttackTick");
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
            if (this.attackTick > 0) {
                --this.attackTick;
            }
        }
    }

    @Override
    public void handleEntityEvent(byte p_33335_) {
        if (p_33335_ == 4) {
            this.attackTick = 10;
        }

        super.handleEntityEvent(p_33335_);
    }

    public int getAttackTick() {
        return this.attackTick;
    }

    @Override
    public boolean doHurtTarget(Entity p_33328_) {
        this.attackTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(p_33328_);
    }

    @Override
    public int getMaxSpawnClusterSize() {
    	return 2;
    }

    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 2;
    }

    @Override
    public float getVoicePitch() {
        return super.getVoicePitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.random.nextInt(4) != 0 ? null : SoundRegistry.ALICANTO.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ALICANTO_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ALICANTO_HURT.get();
    }
}
