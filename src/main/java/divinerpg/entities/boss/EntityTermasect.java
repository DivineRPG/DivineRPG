package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.projectile.EntityWildwoodLog;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.EnumSet;

public class EntityTermasect extends EntityDivineFlyingMob implements RangedAttackMob {
    private ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE,
            BossEvent.BossBarOverlay.PROGRESS));

    public EntityTermasect(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {
        super(type, worldIn, 25F);
        this.xpReward = 1500;
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        if (this.isAlive()) {
            if (getTarget() != null && !level.isClientSide) {
                EntityWildwoodLog projectile = new EntityWildwoodLog(EntityRegistry.WILDWOOD_LOG.get(), this, level);
                double tx = getTarget().getX() - this.getX();
                double ty = getTarget().getEyeY() - this.getEyeY();
                double tz = getTarget().getZ() - this.getZ();
                double horizontalDistance = Math.sqrt(tx * tx + tz * tz);
                projectile.shoot(tx, ty, tz, 1.6f, 0);
                projectile.setDeltaMovement(tx / horizontalDistance * 1.6f, ty / horizontalDistance * 1.6f, tz / horizontalDistance * 1.6f);
                this.level.addFreshEntity(projectile);
            }
        }
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<Player>(this, Player.class, false));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 64.0F));
        this.goalSelector.addGoal(1, new FlyToPlayer(this));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 64.0F));
    }
    public BossEvent.BossBarColor getBarColor() {
        return BossEvent.BossBarColor.BLUE;
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        bossInfo.setColor(getBarColor());
        this.bossInfo.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    @Override
    public void tick() {
        super.tick();
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public boolean removeWhenFarAway(double distance) {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WOOD_STEP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.WOOD_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOOD_BREAK;
    }
    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        if (getTarget() != null && this.isAlive() && this.ambientSoundTime % (20 * (10 + random.nextInt(10))) == 0) {
            double tx = getTarget().getX() - this.getX();
            double ty = getTarget().getEyeY() - this.getEyeY();
            double tz = getTarget().getZ() - this.getZ();
            EntityWildwoodLog e = new EntityWildwoodLog(EntityRegistry.WILDWOOD_LOG.get(), this, level);
            double horizontalDistance = Math.sqrt(tx * tx + tz * tz);
            e.shoot(tx, ty, tz, 2.6f, 0);
            e.setDeltaMovement(tx / horizontalDistance * 1.6f, ty / horizontalDistance * 1.6f, tz / horizontalDistance * 1.6f);
            this.level.addFreshEntity(e);
        }
        if (this.isAlive() && this.ambientSoundTime % (20 * (15 + random.nextInt(5))) == 0) {
            BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(getX() + random.nextInt(8), getY(), getZ() + random.nextInt(8));
                EntityRegistry.TERMID.get().spawn((ServerLevel) level, ItemStack.EMPTY, null, pos, MobSpawnType.MOB_SUMMONED, true, false);
        }

        if (this.level.isRaining() && this.level.canSeeSky(blockPosition()) && level.random.nextInt(50) == 3) {
           this.heal(5.0f);
        }
    }

    static class FlyToPlayer extends Goal {
        private final EntityDivineFlyingMob parentEntity;
        private final double followDistanceSq;

        public FlyToPlayer(EntityDivineFlyingMob ent) {
            this.parentEntity = ent;
            this.followDistanceSq = ent.getAttributeValue(Attributes.FOLLOW_RANGE) * ent.getAttributeValue(Attributes.FOLLOW_RANGE);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            return true;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            this.parentEntity.getNavigation().stop();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean canContinueToUse() {
            return this.parentEntity.getTarget() != null && this.parentEntity.distanceToSqr(this.parentEntity.getTarget()) > this.followDistanceSq;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            LivingEntity target = this.parentEntity.getTarget();
            if (target == null) {
                return;
            }
            double d0 = target.getX() - this.parentEntity.getX();
            double d1 = target.getY(0.3333333333333333D) - this.parentEntity.getY();
            double d2 = target.getZ() - this.parentEntity.getZ();
            double distSq = d0 * d0 + d1 * d1 + d2 * d2;
            if (distSq < this.followDistanceSq) {
                return;
            }
            double speed = parentEntity.getAttributeValue(Attributes.MOVEMENT_SPEED);
            this.parentEntity.setDeltaMovement(this.parentEntity.getDeltaMovement().add((Math.signum(d0) * 0.5D - this.parentEntity.getDeltaMovement().x) * 0.10000000149011612D * speed,
                    (Math.signum(d1) * 0.699999988079071D - this.parentEntity.getDeltaMovement().y) * 0.10000000149011612D * speed,
                    (Math.signum(d2) * 0.5D - this.parentEntity.getDeltaMovement().z) * 0.10000000149011612D * speed));
            this.parentEntity.lookAt(target, 30.0F, 30.0F);
        }
    }
}