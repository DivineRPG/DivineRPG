package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineFlyingMonster;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.scores.PlayerTeam;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class EntityTheWatcher extends EntityDivineFlyingMonster implements RangedAttackMob {
    private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE,
            BossEvent.BossBarOverlay.PROGRESS);
    private int explosionStrength = 1;

    public EntityTheWatcher(EntityType<? extends EntityDivineFlyingMonster> type, Level worldIn) {
        super(type, worldIn, 6F, 10F, 25F);
        this.xpReward = 5000;
        this.moveControl = new EntityTheWatcher.MoveHelperController(this);
    }
    @Override
    public Component getDisplayName() {
        return PlayerTeam.formatNameForTeam(getTeam(), getName()).withStyle((s) -> s.withHoverEvent(createHoverEvent()).withInsertion(getStringUUID()).withBold(true));
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
        this.goalSelector.addGoal(5, new EntityTheWatcher.RandomFlyGoal(this));
        this.goalSelector.addGoal(7, new EntityTheWatcher.LookAroundGoal(this));
        this.goalSelector.addGoal(7, new EntityTheWatcher.FireballAttackGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (p_213812_1_) -> Math.abs(p_213812_1_.getY() - this.getY()) <= 4.0D));
    }

//    @OnlyIn(Dist.CLIENT)
//    public boolean isAttacking() {
//        return this.entityData.get(ATTACKING);
//    }

//    public void setAttacking(boolean attacking) {
//        this.entityData.set(ATTACKING, attacking);
//    }

//    public int getFireballStrength() {
//        return this.explosionStrength;
//    }

//    protected boolean isDespawnPeaceful() {
//        return true;
//    }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        if (this.isAlive() && getTarget() != null) {
            ThrowableProjectile projectile = EntityRegistry.WATCHER_SHOT.get().create(level());
            projectile.setPos(getEyePosition());
            projectile.setOwner(this);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
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
        if(compound.contains("ExplosionPower", 99)) explosionStrength = compound.getInt("ExplosionPower");
        if(hasCustomName()) bossInfo.setName(getDisplayName());

    }
    @Override
    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        bossInfo.setName(getDisplayName());
    }
    @Override
    protected void customServerAiStep() {
        bossInfo.setProgress(getHealth() / getMaxHealth());
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
        //    this.mob.setAttacking(false);
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

                    ThrowableProjectile shot = EntityRegistry.WATCHER_SHOT.get().create(world);
                    shot.setOwner(mob);
                    shot.shoot(d2, d3, d4, 1, 1);
                    shot.setPos(this.mob.getX() + vector3d.x * 4.0D, this.mob.getY(0.5D) + 0.5D, shot.getZ() + vector3d.z * 4.0D);
                    world.addFreshEntity(shot);
                    this.chargeTime = -40;
                }
            } else if (this.chargeTime > 0) {
                --this.chargeTime;
            }

            //this.mob.setAttacking(this.chargeTime > 10);
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
                this.mob.yHeadRot = -((float)Math.atan2(vector3d.x, vector3d.z)) * (180F / (float)Math.PI);
                this.mob.yBodyRot = this.mob.getYRot();
            } else {
                LivingEntity livingentity = this.mob.getTarget();
//                double d0 = 64.0D;
                if (livingentity.distanceToSqr(this.mob) < 4096.0D) {
                    double d1 = livingentity.getX() - this.mob.getX();
                    double d2 = livingentity.getZ() - this.mob.getZ();
                    this.mob.yHeadRot = -((float)Math.atan2(d1, d2)) * (180F / (float)Math.PI);
                    this.mob.yBodyRot = this.mob.getYRot();
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