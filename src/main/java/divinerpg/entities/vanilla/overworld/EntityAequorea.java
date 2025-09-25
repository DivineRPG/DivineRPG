package divinerpg.entities.vanilla.overworld;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;

import java.util.EnumSet;

import static divinerpg.registries.AttachmentRegistry.VARIANT;
import static net.minecraft.core.particles.ParticleTypes.SPLASH;
import static net.minecraft.world.effect.MobEffects.POISON;
import static net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED;

public class EntityAequorea extends Squid {
	public EntityAequorea(EntityType<? extends EntityAequorea> type, Level level) {
		super(type, level);
        if(!level.isClientSide) setData(VARIANT.attachment, (byte)getRandom().nextInt(6));
	}
    @Override public void onAddedToLevel() {
        super.onAddedToLevel();
        if(level().isClientSide) VARIANT.requestAttachment(this, null);
    }
    @Override protected void registerGoals() {
	    super.registerGoals();
	    goalSelector.addGoal(1, new StingAttack(this, getAttributeBaseValue(MOVEMENT_SPEED), false));
	    targetSelector.addGoal(1, new HurtByTargetGoal(this));
	    targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}
	public byte getColor() {return VARIANT.get(this);}
	@Override protected ParticleOptions getInkParticle() {return SPLASH;}
    static class StingAttack extends Goal {
        protected final PathfinderMob mob;
        private final double speedModifier;
        private final boolean followingTargetEvenIfNotSeen;
        private Path path;
        private double pathedTargetX;
        private double pathedTargetY;
        private double pathedTargetZ;
        private int ticksUntilNextPathRecalculation;
        private int ticksUntilNextAttack;
        private long lastCanUseCheck;
        public StingAttack(PathfinderMob aequorea, double speed, boolean followAtAllCosts) {
            mob = aequorea;
            speedModifier = speed;
            followingTargetEvenIfNotSeen = followAtAllCosts;
            setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }
        @Override public boolean canUse() {
            long i = mob.level().getGameTime();
            if(i - lastCanUseCheck < 20) return false;
            else {
                lastCanUseCheck = i;
                LivingEntity livingentity = mob.getTarget();
                if(livingentity == null) return false;
                else if(!livingentity.isAlive()) return false;
                else {
                    path = mob.getNavigation().createPath(livingentity, 0);
                    if(path != null) return true;
                    else return getAttackReachSqr(livingentity) >= mob.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
                }
            }
        }
        @Override public boolean canContinueToUse() {
            LivingEntity livingentity = mob.getTarget();
            if(livingentity == null) return false;
            else if(!livingentity.isAlive()) return false;
            else if(!followingTargetEvenIfNotSeen) return !mob.getNavigation().isDone();
            else if(!mob.isWithinRestriction(livingentity.blockPosition())) return false;
            else return !(livingentity instanceof Player) || !livingentity.isSpectator() && !((Player)livingentity).isCreative();
        }
        @Override public void start() {
            mob.getNavigation().moveTo(path, speedModifier);
            mob.setAggressive(true);
            ticksUntilNextPathRecalculation = 0;
            ticksUntilNextAttack = 0;
        }
        @Override public void stop() {
            LivingEntity livingentity = mob.getTarget();
            if(!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) mob.setTarget(null);
            mob.setAggressive(false);
            mob.getNavigation().stop();
        }
        @Override public void tick() {
            LivingEntity livingentity = mob.getTarget();
            mob.getLookControl().setLookAt(livingentity, 30, 30);
            double d0 = mob.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
            ticksUntilNextPathRecalculation = Math.max(ticksUntilNextPathRecalculation - 1, 0);
            if((followingTargetEvenIfNotSeen || mob.getSensing().hasLineOfSight(livingentity)) && ticksUntilNextPathRecalculation <= 0 && (pathedTargetX == 0 && pathedTargetY == 0 && pathedTargetZ == 0 || livingentity.distanceToSqr(pathedTargetX, pathedTargetY, pathedTargetZ) >= 1 || mob.getRandom().nextFloat() < .05)) {
                pathedTargetX = livingentity.getX();
                pathedTargetY = livingentity.getY();
                pathedTargetZ = livingentity.getZ();
                ticksUntilNextPathRecalculation = 4 + mob.getRandom().nextInt(7);
                if(d0 > 1024) ticksUntilNextPathRecalculation += 10;
                else if(d0 > 256) ticksUntilNextPathRecalculation += 5;
                if(!mob.getNavigation().moveTo(livingentity, speedModifier)) ticksUntilNextPathRecalculation += 15;
            } ticksUntilNextAttack = Math.max(ticksUntilNextAttack - 1, 0);
            checkAndPerformAttack(livingentity, d0);
        }
        protected void checkAndPerformAttack(LivingEntity entity, double range) {
            double d0 = getAttackReachSqr(entity);
            if(range <= d0 && ticksUntilNextAttack <= 0) {
                resetAttackCooldown();
                mob.swing(InteractionHand.MAIN_HAND);
                mob.doHurtTarget(entity);
                entity.addEffect(new MobEffectInstance(POISON, 3 * 20));
            }
        }
        protected void resetAttackCooldown() {ticksUntilNextAttack = 20;}
        protected double getAttackReachSqr(LivingEntity entity) { return mob.getBbWidth() * 2 * mob.getBbWidth() * 2 + entity.getBbWidth();
        }
    }
}