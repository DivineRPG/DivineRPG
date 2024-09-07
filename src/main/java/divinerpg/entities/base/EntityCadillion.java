package divinerpg.entities.base;

import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;

public class EntityCadillion extends EntityDivineMonster {
    private int chargeTime, ramCooldown;
    private boolean isCharging;

    public EntityCadillion(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        chargeTime = 0;
        isCharging = false;
        ramCooldown = 0;
    }
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.3625F;}
    @Override public boolean isAggressive() {return true;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.CADILLION.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GROWL_HURT.get();}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override public void aiStep() {
        super.aiStep();
        if(level().isClientSide()) return;
        if(ramCooldown > 0) ramCooldown--;

        Entity target = getTarget();
        if(target != null) {
            if(isCharging) {
                chargeTime++;
                lookAt(target, 30.0F, 30.0F);
                if(chargeTime >= 20) {
                    double targetX = target.getX();
                    double targetZ = target.getZ();
                    double dx = targetX - getX();
                    double dz = targetZ - getZ();
                    double distance = Math.sqrt(dx * dx + dz * dz);
                    if(distance > 0) {
                        double speed = 1.75 * getAttributeValue(Attributes.MOVEMENT_SPEED);
                        double motionX = (dx / distance) * speed;
                        double motionZ = (dz / distance) * speed;
                        setDeltaMovement(motionX, 0, motionZ);
                    }
                    chargeTime = 0;
                    isCharging = false;
                    ramCooldown = 1200;
                }
            } else if(ramCooldown == 0) {
                getNavigation().stop();
                chargeTime++;
                if(chargeTime == 1) {
                    playSound(SoundRegistry.GROWL_HURT.get(), 1.0F, 1.0F);
                }
                if(chargeTime >= 40) {
                    isCharging = true;
                    chargeTime = 0;
                }
            }
        } else {
            Player nearestPlayer = level().getNearestPlayer(this, getAttributeValue(Attributes.FOLLOW_RANGE));
            if(nearestPlayer != null && !nearestPlayer.isCreative()) getNavigation().moveTo(nearestPlayer, 1);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new MeleeAttackGoal(this, 1, false));
    }
}
