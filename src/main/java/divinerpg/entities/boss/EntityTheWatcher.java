package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.controller.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import java.util.*;

public class EntityTheWatcher extends EntityDivineFlyingMob {
    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.defineId(EntityTheWatcher.class, DataSerializers.BOOLEAN);
    private int explosionStrength = 1;

    public EntityTheWatcher(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 5000;
        this.moveControl = new EntityTheWatcher.MoveHelperController(this);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.theWatcherHealth).add(Attributes.ATTACK_DAMAGE, 0)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.theWatcherSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.theWatcherFollowRange);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.6F;
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == World.OVERWORLD;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new EntityTheWatcher.RandomFlyGoal(this));
        this.goalSelector.addGoal(7, new EntityTheWatcher.LookAroundGoal(this));
        this.goalSelector.addGoal(7, new EntityTheWatcher.FireballAttackGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, (p_213812_1_) -> {
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

    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (source.getEntity() instanceof FireballEntity && source.getDirectEntity() instanceof PlayerEntity) {
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

    public SoundCategory getSoundSource() {
        return SoundCategory.HOSTILE;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.GHAST_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.GHAST_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.GHAST_DEATH;
    }

    protected float getSoundVolume() {
        return 5.0F;
    }

    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("ExplosionPower", this.explosionStrength);
    }

    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("ExplosionPower", 99)) {
            this.explosionStrength = compound.getInt("ExplosionPower");
        }

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
            double d0 = 64.0D;
            if (livingentity.distanceToSqr(this.mob) < 4096.0D && this.mob.canSee(livingentity)) {
                World world = this.mob.level;
                ++this.chargeTime;
                if (this.chargeTime == 10 && !this.mob.isSilent()) {
                    world.levelEvent((PlayerEntity)null, 1015, this.mob.blockPosition(), 0);
                }

                if (this.chargeTime == 20) {
                    double d1 = 4.0D;
                    Vector3d vector3d = this.mob.getViewVector(1.0F);
                    double d2 = livingentity.getX() - (this.mob.getX() + vector3d.x * 4.0D);
                    double d3 = livingentity.getY(0.5D) - (0.5D + this.mob.getY(0.5D));
                    double d4 = livingentity.getZ() - (this.mob.getZ() + vector3d.z * 4.0D);
                    if (!this.mob.isSilent()) {
                        world.levelEvent((PlayerEntity)null, 1016, this.mob.blockPosition(), 0);
                    }

                    FireballEntity fireballentity = new FireballEntity(world, this.mob, d2, d3, d4);
                    fireballentity.explosionPower = this.mob.explosionStrength;
                    fireballentity.setPos(this.mob.getX() + vector3d.x * 4.0D, this.mob.getY(0.5D) + 0.5D, fireballentity.getZ() + vector3d.z * 4.0D);
                    world.addFreshEntity(fireballentity);
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
                Vector3d vector3d = this.mob.getDeltaMovement();
                this.mob.yRot = -((float)MathHelper.atan2(vector3d.x, vector3d.z)) * (180F / (float)Math.PI);
                this.mob.yBodyRot = this.mob.yRot;
            } else {
                LivingEntity livingentity = this.mob.getTarget();
                double d0 = 64.0D;
                if (livingentity.distanceToSqr(this.mob) < 4096.0D) {
                    double d1 = livingentity.getX() - this.mob.getX();
                    double d2 = livingentity.getZ() - this.mob.getZ();
                    this.mob.yRot = -((float)MathHelper.atan2(d1, d2)) * (180F / (float)Math.PI);
                    this.mob.yBodyRot = this.mob.yRot;
                }
            }

        }
    }

    static class MoveHelperController extends MovementController {
        private final EntityTheWatcher mob;
        private int floatDuration;

        public MoveHelperController(EntityTheWatcher ent) {
            super(ent);
            this.mob = ent;
        }

        public void tick() {
            if (this.operation == MovementController.Action.MOVE_TO) {
                if (this.floatDuration-- <= 0) {
                    this.floatDuration += this.mob.getRandom().nextInt(5) + 2;
                    Vector3d vector3d = new Vector3d(this.wantedX - this.mob.getX(), this.wantedY - this.mob.getY(), this.wantedZ - this.mob.getZ());
                    double d0 = vector3d.length();
                    vector3d = vector3d.normalize();
                    if (this.canReach(vector3d, MathHelper.ceil(d0))) {
                        this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(vector3d.scale(0.1D)));
                    } else {
                        this.operation = MovementController.Action.WAIT;
                    }
                }

            }
        }

        private boolean canReach(Vector3d vec, int ticks) {
            AxisAlignedBB axisalignedbb = this.mob.getBoundingBox();

            for(int i = 1; i < ticks; ++i) {
                axisalignedbb = axisalignedbb.move(vec);
                if (!this.mob.level.noCollision(this.mob, axisalignedbb)) {
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
            MovementController movementcontroller = this.mob.getMoveControl();
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
            Random random = this.mob.getRandom();
            double d0 = this.mob.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.mob.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.mob.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.mob.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
        }
    }
}
