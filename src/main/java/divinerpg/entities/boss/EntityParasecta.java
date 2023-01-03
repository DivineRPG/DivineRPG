package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.registries.*;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class EntityParasecta extends EntityDivineBoss {

    private BlockPos currentFlightTarget;

    public EntityParasecta(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 2.7F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public BossBarColor getBarColor() {
        return BossBarColor.YELLOW;
    }

    @Override
    protected float getSoundVolume() {
        return 0.1F;
    }

    @Override
	public float getVoicePitch() {
        return super.getVoicePitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.random.nextInt(4) != 0 ? null : SoundRegistry.PARASECTA.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return SoundRegistry.PARASECTA_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.PARASECTA_HURT.get();
    }

    @Override
    public void tick() {
        super.tick();
        this.setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y*0.6000000238418579D, getDeltaMovement().z);
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();

        if (this.getTarget() != null) {
            int x = (int) this.getTarget().getX();
            int y = (int) this.getTarget().getY();
            int z = (int) this.getTarget().getZ();
            this.currentFlightTarget = new BlockPos(x, y, z);
        }

        setDeltaMovement(getDeltaMovement().x, 0, getDeltaMovement().z);

        if (this.currentFlightTarget != null) {
            double x = this.currentFlightTarget.getX() - this.getX();
            double y = this.currentFlightTarget.getY() - this.getY();
            double z = this.currentFlightTarget.getZ() - this.getZ();

            if (Math.signum(x) != 0 || Math.signum(y) != 0 || Math.signum(z) != 0) {
                setDeltaMovement(getDeltaMovement().x + (Math.signum(x) * 0.5D - this.getDeltaMovement().x) * 0.10000000149011612D, getDeltaMovement().y + (Math.signum(y) * 1.699999988079071D - this.getDeltaMovement().y) * 0.10000000149011612D, getDeltaMovement().z + (Math.signum(z) * 0.5D - this.getDeltaMovement().z) * 0.10000000149011612D);
                float var7 = (float) (Math.atan2(this.getDeltaMovement().z, this.getDeltaMovement().x) * 180.0D / Math.PI) - 90.0F;
                float var8 = Mth.wrapDegrees(var7 - this.xRot);
                this.moveDist = 0.5F;
                this.xRot += var8;
            }
        }
    }

    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        return false;
    }

    protected void checkFallDamage(double p_184231_1_, boolean p_184231_3_, BlockState p_184231_4_, BlockPos p_184231_5_) {
    }

}