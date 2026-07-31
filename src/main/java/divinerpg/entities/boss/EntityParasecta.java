package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class EntityParasecta extends EntityDivineBoss {
    private BlockPos currentFlightTarget;
    public EntityParasecta(EntityType<? extends EntityParasecta> type, Level worldIn) {super(type, worldIn);}
    @Override protected void customServerAiStep(ServerLevel level) {
        super.customServerAiStep(level);
        if(getTarget() != null) {
            int x = (int) getTarget().getX();
            int y = (int) getTarget().getY();
            int z = (int) getTarget().getZ();
            currentFlightTarget = new BlockPos(x, y, z);
        } setDeltaMovement(getDeltaMovement().multiply(1, .6, 1));
        if(currentFlightTarget != null) {
            double x = currentFlightTarget.getX() - getX();
            double y = currentFlightTarget.getY() - getY();
            double z = currentFlightTarget.getZ() - getZ();
            if(Math.signum(x) != 0 || Math.signum(y) != 0 || Math.signum(z) != 0) {
                setDeltaMovement(getDeltaMovement().x + (Math.signum(x) * .5 - getDeltaMovement().x) * .1, getDeltaMovement().y + (Math.signum(y) * 1.7 - getDeltaMovement().y) * .1, getDeltaMovement().z + (Math.signum(z) * .5 - getDeltaMovement().z) * .1);
                float var7 = (float) (Math.atan2(getDeltaMovement().z, getDeltaMovement().x) * Mth.RAD_TO_DEG) - 90;
                float var8 = Mth.wrapDegrees(var7 - getXRot());
                moveDist = .5F;
                xRotO += var8;
            }
        }
    }
    @Override protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {}
    @Override protected SoundEvent getAmbientSound() {return random.nextInt(4) != 0 ? null : SoundRegistry.PARASECTA.get();}
    @Override protected SoundEvent getHurtSound(DamageSource s) {return SoundRegistry.PARASECTA_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.PARASECTA_HURT.get();}
    @Override protected float getSoundVolume() {return .1F;}
    @Override public float getVoicePitch() {return super.getVoicePitch() * .95F;}
}