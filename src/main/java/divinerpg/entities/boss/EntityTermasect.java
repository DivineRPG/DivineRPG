package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.projectile.EntityWildwoodLog;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.util.Mth;
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
        super(type, worldIn);
        this.xpReward = 1500;
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<Player>(this, Player.class, false));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 64.0F));
        goalSelector.addGoal(1, new FlyToPlayer(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        if (isAlive() && getTarget() != null && !level.isClientSide) {
            EntityWildwoodLog shot = new EntityWildwoodLog(EntityRegistry.WILDWOOD_LOG.get(), this, this.level);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - shot.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            shot.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.5F);
            this.level.addFreshEntity(shot);
        }
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
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
        if (this.isAlive() && this.random.nextInt(1000) < this.ambientSoundTime++)
        {
            this.playAmbientSound();
            if(!this.level.isClientSide) {
                if (random.nextInt(10) == 1) {
                    BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(blockPosition().getX() + random.nextInt(8), blockPosition().getY(), blockPosition().getZ() + random.nextInt(8));
                    EntityRegistry.TERMID.get().spawn((ServerLevel) level, ItemStack.EMPTY, null, pos, MobSpawnType.MOB_SUMMONED, true, false);
                }
            }
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