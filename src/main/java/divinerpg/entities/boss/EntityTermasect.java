package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineFlyingMonster;
import divinerpg.entities.projectile.DivineThrownItem;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.scores.PlayerTeam;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class EntityTermasect extends EntityDivineFlyingMonster implements RangedAttackMob {
    private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS);

    public EntityTermasect(EntityType<? extends EntityDivineFlyingMonster> type, Level worldIn) {
        super(type, worldIn, 25);
        xpReward = XP_REWARD_BOSS;
    }
    @Override
    public Component getDisplayName() {
        return PlayerTeam.formatNameForTeam(getTeam(), getName()).withStyle((s) -> s.withHoverEvent(createHoverEvent()).withInsertion(getStringUUID()).withBold(true));
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 64.0F));
        goalSelector.addGoal(1, new FlyToPlayer(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        if (isAlive() && getTarget() != null && !level().isClientSide) {
            DivineThrownItem shot = EntityRegistry.THROWN_ITEM.get().create(level());
            shot.setItem(BlockRegistry.wildwoodLog.asItem().getDefaultInstance());
            shot.setOwner(this);
            shot.setPos(getEyePosition());
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - shot.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            shot.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.5F);
            this.level().addFreshEntity(shot);
        }
    }

    @Override
    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        bossInfo.setName(getDisplayName());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if(hasCustomName()) bossInfo.setName(getDisplayName());
    }
    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }
    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
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
        bossInfo.setProgress(getHealth() / getMaxHealth());
        if (getTarget() != null && this.isAlive() && this.ambientSoundTime % (20 * (10 + random.nextInt(10))) == 0) {
            double tx = getTarget().getX() - this.getX();
            double ty = getTarget().getEyeY() - this.getEyeY();
            double tz = getTarget().getZ() - this.getZ();
            DivineThrownItem e = EntityRegistry.THROWN_ITEM.get().create(level());
            e.setItem(BlockRegistry.wildwoodLog.asItem().getDefaultInstance());
            e.setOwner(this);
            e.setPos(getEyePosition());
            double horizontalDistance = Math.sqrt(tx * tx + tz * tz);
            e.shoot(tx, ty, tz, 2.6f, 0);
            e.setDeltaMovement(tx / horizontalDistance * 1.6f, ty / horizontalDistance * 1.6f, tz / horizontalDistance * 1.6f);
            this.level().addFreshEntity(e);
        }
        if (this.isAlive() && this.ambientSoundTime % (20 * (15 + random.nextInt(5))) == 0) {
            BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(getX() + random.nextInt(8), getY(), getZ() + random.nextInt(8));
            EntityRegistry.TERMID.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, pos, MobSpawnType.MOB_SUMMONED, true, false);
        }

        if (this.level().isRaining() && this.level().canSeeSky(blockPosition()) && level().getRandom().nextInt(50) == 3) {
            this.heal(5.0f);
        }
    }

    @Override
    public void playerTouch(Player player) {
        super.playerTouch(player);
        player.hurt(damageSources().flyIntoWall(), 4);
        player.knockback(2.1, 2.1, 2.1);
    }
    static class FlyToPlayer extends Goal {
        private final EntityDivineFlyingMonster parentEntity;
        private final double followDistanceSq;

        public FlyToPlayer(EntityDivineFlyingMonster ent) {
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
