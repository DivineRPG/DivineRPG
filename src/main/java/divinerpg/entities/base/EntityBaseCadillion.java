package divinerpg.entities.base;

import divinerpg.registries.AttachmentRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;

public class EntityBaseCadillion extends EntityDivineMonster {
    private int chargeTime, ramCooldown;
    public EntityBaseCadillion(EntityType<? extends EntityBaseCadillion> type, Level worldIn) {
        super(type, worldIn);
        chargeTime = ramCooldown = 0;
    }
    @Override public void aiStep() {
        super.aiStep();
        if(level().isClientSide || !isAlive()) return;
        if(ramCooldown > 0) ramCooldown--;
        if(getTarget() != null) {
            if(AttachmentRegistry.ANGRY.get(this)) {
                chargeTime++;
                if(chargeTime >= 20) {
                    Entity target = getTarget();
                    double targetX = target.getX();
                    double targetZ = target.getZ();
                    double dx = targetX - getX();
                    double dz = targetZ - getZ();
                    double distance = Math.sqrt(dx * dx + dz * dz);
                    if(distance > 0) {
                        double speed = 3;
                        double motionX = (dx / distance) * speed;
                        double motionZ = (dz / distance) * speed;
                        setDeltaMovement(motionX, 0.1, motionZ);
                    } chargeTime = 0;
                    AttachmentRegistry.ANGRY.set(this, false);
                    ramCooldown = 1200;
                }
            } else if(ramCooldown == 0) {
                getNavigation().stop();
                chargeTime++;
                if(chargeTime >= 40) {
                    AttachmentRegistry.ANGRY.set(this, true);
                    chargeTime = 0;
                }
            }
        }
    }
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.CADILLION.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GROWL_HURT.get();}
}