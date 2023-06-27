package divinerpg.entities.mortum;

import divinerpg.entities.base.*;
import divinerpg.registries.*;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;

public class EntityMortumCadillion extends EntityDivineMonster {
    private int chargeTime;
    private boolean isCharging;
    private int ramCooldown;

    public EntityMortumCadillion(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        xpReward=40;
        this.chargeTime = 0;
        this.isCharging = false;
        this.ramCooldown = 0;
    }
    @Override public boolean fireImmune() {return true;}
    @Override public boolean isAggressive() {return true;}
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.3625F;
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CADILLION.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT.get();
    }
    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader world) {
        return 0.0F;
    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide) {
            return;
        }
        if (this.ramCooldown > 0) {
            this.ramCooldown--;
        }
        if (this.getTarget() != null) {
            if (this.isCharging) {
                this.chargeTime++;

                if (this.chargeTime >= 20) {
                    Entity target = this.getTarget();
                    double targetX = target.getX();
                    double targetZ = target.getZ();
                    double dx = targetX - this.getX();
                    double dz = targetZ - this.getZ();
                    double distance = Math.sqrt(dx * dx + dz * dz);
                    if (distance > 0) {
                        double speed = 2.5;
                        double motionX = (dx / distance) * speed;
                        double motionZ = (dz / distance) * speed;

                        this.setDeltaMovement(motionX, 0, motionZ);
                    }
                    this.chargeTime = 0;
                    this.isCharging = false;
                    this.ramCooldown = 1200;
                }
            } else if (this.ramCooldown == 0) {
                this.getNavigation().stop();
                this.chargeTime++;
                if (this.chargeTime >= 40) {
                    this.isCharging = true;
                    this.chargeTime = 0;
                }
            }
        } else {
            Player nearestPlayer = this.level().getNearestPlayer(this, getAttributeValue(Attributes.FOLLOW_RANGE));
            if (nearestPlayer != null && !nearestPlayer.isCreative()) {
                this.getNavigation().moveTo(nearestPlayer, 1.0D);
            }
        }
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
    }
}