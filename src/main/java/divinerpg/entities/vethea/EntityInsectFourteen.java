package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import divinerpg.utils.UniversalPosition;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.*;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class EntityInsectFourteen extends EntityDivineMonster {
    public EntityInsectFourteen(EntityType<? extends EntityDivineMonster> type, Level worldIn) {super(type, worldIn);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.ENDIKU.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.INSECT_FOURTEEN_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.INSECT_FOURTEEN_HURT.get();}
    @Override protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new FloatEnemyGoal(this));
        goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6));
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        targetSelector.addGoal(0, new HurtByTargetGoal(this));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    public static class FloatEnemyGoal extends Goal {
        protected final Mob mob;
        protected Path path;
        protected double pathedTargetX, pathedTargetY, pathedTargetZ;
        protected long lastCanUseCheck;
        protected int ticksUntilNextPathRecalculation, ticksUntilNextAttack, failedPathFindingPenalty, attackTimer;
        protected boolean canPenalize = false;
        public FloatEnemyGoal(Mob entity) {
            mob = entity;
            setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }
        @Override public boolean canUse() {
            long i = mob.level().getGameTime();
            if(i - lastCanUseCheck < 20L) return false;
            else {
                lastCanUseCheck = i;
                LivingEntity livingentity = mob.getTarget();
                if(livingentity == null) return false;
                else if(!livingentity.isAlive()) return false;
                else if(canPenalize) {
                    if(--ticksUntilNextPathRecalculation <= 0) {
                        path = mob.getNavigation().createPath(UniversalPosition.toBlockPos(livingentity.position().offsetRandom(mob.getRandom(), 3F)), 0);
                        ticksUntilNextPathRecalculation = 4 + mob.getRandom().nextInt(7);
                        return path != null;
                    } else return true;
                } else {
                    path = mob.getNavigation().createPath(UniversalPosition.toBlockPos(livingentity.position().offsetRandom(mob.getRandom(), 3F)), 0);
                    return path != null || mob.distanceToSqr(livingentity) < 25D;
                }
            }
        }
        @Override public boolean canContinueToUse() {
            LivingEntity livingentity = mob.getTarget();
            if(livingentity == null) return false;
            else if(!livingentity.isAlive()) return false;
            else return !(livingentity instanceof Player player) || (!player.isSpectator() && !player.isCreative());
        }
        public void start() {
            mob.getNavigation().moveTo(path, 1);
            ticksUntilNextPathRecalculation = 0;
            ticksUntilNextAttack = 0;
        }
        public void stop() {
            LivingEntity livingentity = mob.getTarget();
            if(!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) mob.setTarget(null);
            mob.setAggressive(false);
            mob.getNavigation().stop();
        }
        public boolean requiresUpdateEveryTick() {
            return true;
        }
        public void tick() {
            LivingEntity livingentity = mob.getTarget();
            if(livingentity == null) return;
            mob.getLookControl().setLookAt(livingentity, 30F, 30F);
            if(ticksUntilNextPathRecalculation > 0) ticksUntilNextPathRecalculation--;
            else if(pathedTargetX == 0D && pathedTargetY == 0D && pathedTargetZ == 0D || livingentity.distanceToSqr(pathedTargetX, pathedTargetY, pathedTargetZ) >= 1D || mob.getRandom().nextFloat() < .05F) {
                pathedTargetX = livingentity.getX(); pathedTargetY = livingentity.getY(); pathedTargetZ = livingentity.getZ();
                ticksUntilNextPathRecalculation = 4 + mob.getRandom().nextInt(7);
                double d0 = mob.distanceToSqr(livingentity);
                if(canPenalize) {
                    ticksUntilNextPathRecalculation += failedPathFindingPenalty;
                    if(mob.getNavigation().getPath() != null) {
                        Node finalPathPoint = mob.getNavigation().getPath().getEndNode();
                        if(finalPathPoint != null && livingentity.distanceToSqr(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1D) failedPathFindingPenalty = 0;
                        else failedPathFindingPenalty += 10;
                    } else failedPathFindingPenalty += 10;
                } if(d0 > 1024D) ticksUntilNextPathRecalculation += 10;
                else if(d0 > 256D) ticksUntilNextPathRecalculation += 5;
                if(!mob.getNavigation().moveTo(livingentity, 1)) ticksUntilNextPathRecalculation += 15;
                ticksUntilNextPathRecalculation = adjustedTickDelay(ticksUntilNextPathRecalculation);
            } if(ticksUntilNextAttack > 0) ticksUntilNextAttack--;
            else checkAndPerformAttack(livingentity);
        }
        protected void checkAndPerformAttack(LivingEntity target) {
            if(mob.isAggressive()) {
                if((mob.tickCount & 1) == 0) {
                    Vec3 v = target.position().subtract(mob.position());
                    double distancesquared = v.lengthSqr();
                    if(distancesquared < 25D) {
                        v = v.scale(9D / v.lengthSqr());
                        target.setDeltaMovement(mob.position().add(v.x, 4.2, v.y).subtract(target.position()).scale(0.1).add(target.getDeltaMovement()));
//                        target.hasImpulse = true;
                        if(target instanceof ServerPlayer serverplayer) serverplayer.connection.send(new ClientboundSetEntityMotionPacket(serverplayer));
                    }
                } if(attackTimer < 1) {
                    mob.setAggressive(false);
                    ticksUntilNextAttack = adjustedTickDelay(20);
                } else attackTimer--;
            } else if(mob.getSensing().hasLineOfSight(target)) {
                attackTimer = 40;
                mob.setAggressive(true);
            }
        }
    }
}