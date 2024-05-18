package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;
import net.minecraftforge.api.distmarker.*;

import java.util.EnumSet;

public class EntityTheWatcher extends EntityDivineFlyingMob implements RangedAttackMob {
    private ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE,
            BossEvent.BossBarOverlay.PROGRESS));
    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(EntityTheWatcher.class, EntityDataSerializers.BOOLEAN);
    private int explosionStrength = 1;

    public EntityTheWatcher(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {
        super(type, worldIn, 6F, 10F, 25F);
        this.xpReward = 5000;
        this.moveControl = new EntityTheWatcher.MoveHelperController(this);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 3.0F;
    }
    public boolean canSpawn(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
        return level().dimension() == Level.OVERWORLD;
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
        this.goalSelector.addGoal(5, new EntityTheWatcher.RandomFlyGoal(this));
        this.goalSelector.addGoal(7, new EntityTheWatcher.LookAroundGoal(this));
        this.goalSelector.addGoal(7, new EntityTheWatcher.FireballAttackGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (p_213812_1_) -> {
            return Math.abs(p_213812_1_.getY() - this.getY()) <= 4.0D;
        }));
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public int getFireballStrength() {
        return this.explosionStrength;
    }

    protected boolean isDespawnPeaceful() {
        return true;
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        if (this.isAlive() && getTarget() != null) {
            ThrowableProjectile projectile = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.THE_WATCHER_SHOT);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = (double) Math.sqrt(d0 * d0 + d2 * d2);
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level().getDifficulty().getId() * 4));
            this.level().addFreshEntity(projectile);
        }
    }

    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (source.getEntity() instanceof LargeFireball && source.getDirectEntity() instanceof Player) {
            super.hurt(source, 1000.0F);
            return true;
        } else {
            return super.hurt(source, amount);
        }
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundRegistry.GROWL_HURT.get();
    }

    protected SoundEvent getDeathSound() {
    	return SoundRegistry.GROWL_HURT.get();
    }

    protected float getSoundVolume() {
        return 5.0F;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("ExplosionPower", this.explosionStrength);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("ExplosionPower", 99)) {
            this.explosionStrength = compound.getInt("ExplosionPower");
        }

    }


    public BossEvent.BossBarColor getBarColor() {
        return BossEvent.BossBarColor.YELLOW;
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
    static class FireballAttackGoal extends Goal {
        private final EntityTheWatcher mob;
        public int chargeTime;

        public FireballAttackGoal(EntityTheWatcher ent) {
            this.mob = ent;
        }

        public boolean canUse() {
            return this.mob.getTarget() != null;
        }

        public void start() {
            this.chargeTime = 0;
        }

        public void stop() {
            this.mob.setAttacking(false);
        }

        public void tick() {
            LivingEntity livingentity = this.mob.getTarget();
//            double d0 = 64.0D;
            if (livingentity.distanceToSqr(this.mob) < 4096.0D && this.mob.hasLineOfSight(livingentity)) {
                Level world = this.mob.level();
                ++this.chargeTime;
                if (this.chargeTime == 10 && !this.mob.isSilent()) {
                    world.levelEvent(null, 1015, this.mob.blockPosition(), 0);
                }

                if (this.chargeTime == 20) {
//                    float d1 = 4.0F;
                    Vec3 vector3d = this.mob.getViewVector(1.0F);
                    double d2 = livingentity.getX() - (this.mob.getX() + vector3d.x * 4.0D);
                    double d3 = livingentity.getY(0.5D) - (0.5D + this.mob.getY(0.5D));
                    double d4 = livingentity.getZ() - (this.mob.getZ() + vector3d.z * 4.0D);
                    if (!this.mob.isSilent()) {
                        world.levelEvent(null, 1016, this.mob.blockPosition(), 0);
                    }

                    ThrowableProjectile shot = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), livingentity, world, BulletType.THE_WATCHER_SHOT);
                    shot.shoot(d2, d3, d4, 1, 1);
                    shot.setPos(this.mob.getX() + vector3d.x * 4.0D, this.mob.getY(0.5D) + 0.5D, shot.getZ() + vector3d.z * 4.0D);
                    world.addFreshEntity(shot);
                    this.chargeTime = -40;
                }
            } else if (this.chargeTime > 0) {
                --this.chargeTime;
            }

            this.mob.setAttacking(this.chargeTime > 10);
        }
    }

    static class LookAroundGoal extends Goal {
        private final EntityTheWatcher mob;

        public LookAroundGoal(EntityTheWatcher ent) {
            this.mob = ent;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        public boolean canUse() {
            return true;
        }

        public void tick() {
            if (this.mob.getTarget() == null) {
                Vec3 vector3d = this.mob.getDeltaMovement();
                this.mob.yRot = -((float)Math.atan2(vector3d.x, vector3d.z)) * (180F / (float)Math.PI);
                this.mob.yBodyRot = this.mob.yRot;
            } else {
                LivingEntity livingentity = this.mob.getTarget();
//                double d0 = 64.0D;
                if (livingentity.distanceToSqr(this.mob) < 4096.0D) {
                    double d1 = livingentity.getX() - this.mob.getX();
                    double d2 = livingentity.getZ() - this.mob.getZ();
                    this.mob.yRot = -((float)Math.atan2(d1, d2)) * (180F / (float)Math.PI);
                    this.mob.yBodyRot = this.mob.yRot;
                }
            }

        }
    }

    static class MoveHelperController extends MoveControl {
        private final EntityTheWatcher mob;
        private int floatDuration;

        public MoveHelperController(EntityTheWatcher ent) {
            super(ent);
            this.mob = ent;
        }

        public void tick() {
            if (this.operation == MoveControl.Operation.MOVE_TO) {
                if (this.floatDuration-- <= 0) {
                    this.floatDuration += this.mob.getRandom().nextInt(5) + 2;
                    Vec3 vector3d = new Vec3(this.wantedX - this.mob.getX(), this.wantedY - this.mob.getY(), this.wantedZ - this.mob.getZ());
                    double d0 = vector3d.length();
                    vector3d = vector3d.normalize();
                    if (this.canReach(vector3d, (int) Math.ceil(d0))) {
                        this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(vector3d.scale(0.1D)));
                    } else {
                        this.operation = MoveControl.Operation.WAIT;
                    }
                }

            }
        }

        private boolean canReach(Vec3 vec, int ticks) {
            AABB axisalignedbb = this.mob.getBoundingBox();

            for(int i = 1; i < ticks; ++i) {
                axisalignedbb = axisalignedbb.move(vec);
                if (!this.mob.level().noCollision(this.mob, axisalignedbb)) {
                    return false;
                }
            }

            return true;
        }
    }

    static class RandomFlyGoal extends Goal {
        private final EntityTheWatcher mob;

        public RandomFlyGoal(EntityTheWatcher entity) {
            this.mob = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            MoveControl movementcontroller = this.mob.getMoveControl();
            if (!movementcontroller.hasWanted()) {
                return true;
            } else {
                double d0 = movementcontroller.getWantedX() - this.mob.getX();
                double d1 = movementcontroller.getWantedY() - this.mob.getY();
                double d2 = movementcontroller.getWantedZ() - this.mob.getZ();
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }
        }

        public boolean canContinueToUse() {
            return false;
        }

        public void start() {
            RandomSource random = this.mob.getRandom();
            double d0 = this.mob.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.mob.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.mob.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.mob.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
        }
    }
}