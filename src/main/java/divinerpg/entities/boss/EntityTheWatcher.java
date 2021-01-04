package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import java.util.*;

public class EntityTheWatcher extends EntityDivineBoss {

    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.createKey(EntityTheWatcher.class, DataSerializers.BOOLEAN);
    private int explosionStrength = 1;

    public EntityTheWatcher(EntityType<? extends EntityTheWatcher> type, World worldIn) {
        super(type, worldIn);
        this.experienceValue = 5;
        this.moveController = new EntityTheWatcher.MoveHelperController(this);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new EntityTheWatcher.RandomFlyGoal(this));
        this.goalSelector.addGoal(7, new EntityTheWatcher.LookAroundGoal(this));
        this.goalSelector.addGoal(7, new EntityTheWatcher.FireballAttackGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, (p_213812_1_) -> {
            return Math.abs(p_213812_1_.getPosY() - this.getPosY()) <= 4.0D;
        }));
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isAttacking() {
        return this.dataManager.get(ATTACKING);
    }

    public void setAttacking(boolean attacking) {
        this.dataManager.set(ATTACKING, attacking);
    }

    public int getFireballStrength() {
        return this.explosionStrength;
    }

    protected boolean isDespawnPeaceful() {
        return true;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (source.getImmediateSource() instanceof FireballEntity && source.getTrueSource() instanceof PlayerEntity) {
            super.attackEntityFrom(source, 1000.0F);
            return true;
        } else {
            return super.attackEntityFrom(source, amount);
        }
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(ATTACKING, false);
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.theWatcherHealth).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.theWatcherFollowRange).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.theWatcherSpeed);
    }

    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }

    protected float getSoundVolume() {
        return 5.0F;
    }

    public static boolean func_223368_b(EntityType<EntityTheWatcher> p_223368_0_, IWorld p_223368_1_, SpawnReason reason, BlockPos p_223368_3_, Random p_223368_4_) {
        return p_223368_1_.getDifficulty() != Difficulty.PEACEFUL && p_223368_4_.nextInt(20) == 0 && canSpawnOn(p_223368_0_, p_223368_1_, reason, p_223368_3_, p_223368_4_);
    }

    public int getMaxSpawnedInChunk() {
        return 1;
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("ExplosionPower", this.explosionStrength);
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("ExplosionPower", 99)) {
            this.explosionStrength = compound.getInt("ExplosionPower");
        }

    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.6F;
    }

    static class FireballAttackGoal extends Goal {
        private final EntityTheWatcher parentEntity;
        public int attackTimer;

        public FireballAttackGoal(EntityTheWatcher ghast) {
            this.parentEntity = ghast;
        }

        public boolean shouldExecute() {
            return this.parentEntity.getAttackTarget() != null;
        }

        public void startExecuting() {
            this.attackTimer = 0;
        }

        public void resetTask() {
            this.parentEntity.setAttacking(false);
        }

        public void tick() {
            LivingEntity livingentity = this.parentEntity.getAttackTarget();
            double d0 = 64.0D;
            if (livingentity.getDistanceSq(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(livingentity)) {
                World world = this.parentEntity.world;
                ++this.attackTimer;
                if (this.attackTimer == 10 && !this.parentEntity.isSilent()) {
                    world.playEvent((PlayerEntity)null, 1015, this.parentEntity.getPosition(), 0);
                }

                if (this.attackTimer == 20) {
                    double d1 = 4.0D;
                    Vector3d vector3d = this.parentEntity.getLook(1.0F);
                    double d2 = livingentity.getPosX() - (this.parentEntity.getPosX() + vector3d.x * 4.0D);
                    double d3 = livingentity.getPosYHeight(0.5D) - (0.5D + this.parentEntity.getPosYHeight(0.5D));
                    double d4 = livingentity.getPosZ() - (this.parentEntity.getPosZ() + vector3d.z * 4.0D);
                    if (!this.parentEntity.isSilent()) {
                        world.playEvent((PlayerEntity)null, 1016, this.parentEntity.getPosition(), 0);
                    }

                    FireballEntity fireballentity = new FireballEntity(world, this.parentEntity, d2, d3, d4);
                    fireballentity.explosionPower = this.parentEntity.getFireballStrength();
                    fireballentity.setPosition(this.parentEntity.getPosX() + vector3d.x * 4.0D, this.parentEntity.getPosYHeight(0.5D) + 0.5D, fireballentity.getPosZ() + vector3d.z * 4.0D);
                    world.addEntity(fireballentity);
                    this.attackTimer = -40;
                }
            } else if (this.attackTimer > 0) {
                --this.attackTimer;
            }

            this.parentEntity.setAttacking(this.attackTimer > 10);
        }
    }

    static class LookAroundGoal extends Goal {
        private final EntityTheWatcher parentEntity;

        public LookAroundGoal(EntityTheWatcher ghast) {
            this.parentEntity = ghast;
            this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        public boolean shouldExecute() {
            return true;
        }

        public void tick() {
            if (this.parentEntity.getAttackTarget() == null) {
                Vector3d vector3d = this.parentEntity.getMotion();
                this.parentEntity.rotationYaw = -((float)MathHelper.atan2(vector3d.x, vector3d.z)) * (180F / (float)Math.PI);
                this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
            } else {
                LivingEntity livingentity = this.parentEntity.getAttackTarget();
                double d0 = 64.0D;
                if (livingentity.getDistanceSq(this.parentEntity) < 4096.0D) {
                    double d1 = livingentity.getPosX() - this.parentEntity.getPosX();
                    double d2 = livingentity.getPosZ() - this.parentEntity.getPosZ();
                    this.parentEntity.rotationYaw = -((float)MathHelper.atan2(d1, d2)) * (180F / (float)Math.PI);
                    this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
                }
            }

        }
    }

    static class MoveHelperController extends MovementController {
        private final EntityTheWatcher parentEntity;
        private int courseChangeCooldown;

        public MoveHelperController(EntityTheWatcher ghast) {
            super(ghast);
            this.parentEntity = ghast;
        }

        public void tick() {
            if (this.action == MovementController.Action.MOVE_TO) {
                if (this.courseChangeCooldown-- <= 0) {
                    this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
                    Vector3d vector3d = new Vector3d(this.posX - this.parentEntity.getPosX(), this.posY - this.parentEntity.getPosY(), this.posZ - this.parentEntity.getPosZ());
                    double d0 = vector3d.length();
                    vector3d = vector3d.normalize();
                    if (this.func_220673_a(vector3d, MathHelper.ceil(d0))) {
                        this.parentEntity.setMotion(this.parentEntity.getMotion().add(vector3d.scale(0.1D)));
                    } else {
                        this.action = MovementController.Action.WAIT;
                    }
                }

            }
        }

        private boolean func_220673_a(Vector3d p_220673_1_, int p_220673_2_) {
            AxisAlignedBB axisalignedbb = this.parentEntity.getBoundingBox();

            for(int i = 1; i < p_220673_2_; ++i) {
                axisalignedbb = axisalignedbb.offset(p_220673_1_);
                if (!this.parentEntity.world.hasNoCollisions(this.parentEntity, axisalignedbb)) {
                    return false;
                }
            }

            return true;
        }
    }

    static class RandomFlyGoal extends Goal {
        private final EntityTheWatcher parentEntity;

        public RandomFlyGoal(EntityTheWatcher ghast) {
            this.parentEntity = ghast;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean shouldExecute() {
            MovementController movementcontroller = this.parentEntity.getMoveHelper();
            if (!movementcontroller.isUpdating()) {
                return true;
            } else {
                double d0 = movementcontroller.getX() - this.parentEntity.getPosX();
                double d1 = movementcontroller.getY() - this.parentEntity.getPosY();
                double d2 = movementcontroller.getZ() - this.parentEntity.getPosZ();
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }
        }

        public boolean shouldContinueExecuting() {
            return false;
        }

        public void startExecuting() {
            Random random = this.parentEntity.getRNG();
            double d0 = this.parentEntity.getPosX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.parentEntity.getPosY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.parentEntity.getPosZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ROAR;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ROAR;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_THE_WATCHER;
    }


    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    public void travel(Vector3d travelVector) {
        if (this.isInWater()) {
            this.moveRelative(0.02F, travelVector);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().scale((double)0.8F));
        } else if (this.isInLava()) {
            this.moveRelative(0.02F, travelVector);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().scale(0.5D));
        } else {
            BlockPos ground = new BlockPos(this.getPosX(), this.getPosY() - 1.0D, this.getPosZ());
            float f = 0.91F;
            if (this.onGround) {
                f = this.world.getBlockState(ground).getSlipperiness(this.world, ground, this) * 0.91F;
            }

            float f1 = 0.16277137F / (f * f * f);
            f = 0.91F;
            if (this.onGround) {
                f = this.world.getBlockState(ground).getSlipperiness(this.world, ground, this) * 0.91F;
            }

            this.moveRelative(this.onGround ? 0.1F * f1 : 0.02F, travelVector);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().scale((double)f));
        }

        this.func_233629_a_(this, false);
    }

    public boolean isOnLadder() {
        return false;
    }
}