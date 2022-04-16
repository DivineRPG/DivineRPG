package divinerpg.entities.base;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.controller.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

import java.util.*;
import java.util.function.*;

public abstract class EntityDivineFlyingMob extends FlyingEntity implements IMob, IRangedAttackMob {


    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_213797_0_) -> {
        return p_213797_0_.getMobType() != CreatureAttribute.UNDEAD && p_213797_0_.attackable();
    };

    protected EntityDivineFlyingMob(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveControl = new EntityDivineFlyingMob.MoveHelperController(this);
    }
    protected void registerGoals() {
        this.goalSelector.addGoal(5, new EntityDivineFlyingMob.RandomFlyGoal(this));
        this.goalSelector.addGoal(7, new EntityDivineFlyingMob.LookAroundGoal(this));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));

    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return true;
    }


    static class LookAroundGoal extends Goal {
        private final EntityDivineFlyingMob parentEntity;

        public LookAroundGoal(EntityDivineFlyingMob ent) {
            this.parentEntity = ent;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            return true;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (this.parentEntity.getTarget() == null) {
                Vector3d vector3d = this.parentEntity.getDeltaMovement();
                this.parentEntity.xRot = -((float)MathHelper.atan2(vector3d.x, vector3d.z)) * (180F / (float)Math.PI);
                this.parentEntity.xRotO = this.parentEntity.xRot;
            } else {
                LivingEntity livingentity = this.parentEntity.getTarget();
                double d0 = 64.0D;
                if (livingentity.distanceToSqr(this.parentEntity) < 4096.0D) {
                    double d1 = livingentity.getX() - this.parentEntity.getX();
                    double d2 = livingentity.getZ() - this.parentEntity.getZ();
                    this.parentEntity.xRot = -((float)MathHelper.atan2(d1, d2)) * (180F / (float)Math.PI);
                    this.parentEntity.xRotO = this.parentEntity.xRot;
                }
            }

        }
    }
    static class MoveHelperController extends MovementController {
        private final EntityDivineFlyingMob parentEntity;
        private int courseChangeCooldown;

        public MoveHelperController(EntityDivineFlyingMob ent) {
            super(ent);
            this.parentEntity = ent;
        }

        public void tick() {
            if (this.operation == MovementController.Action.MOVE_TO) {

                this.mob.setNoGravity(true);
                double d0 = this.wantedX - this.mob.getX();
                double d1 = this.wantedY - this.mob.getY();
                double d2 = this.wantedZ - this.mob.getZ();
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                if (d3 < (double)2.5000003E-7F) {
                    this.mob.setYya(0.0F);
                    this.mob.setZza(0.0F);
                    return;
                }

                float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                this.mob.yRot = this.rotlerp(this.mob.yRot, f, 90.0F);
                float f1;
                if (this.mob.isOnGround()) {
                    f1 = (float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED));
                } else {
                    f1 = (float)(this.speedModifier * this.mob.getAttributeValue(Attributes.FLYING_SPEED));
                }

                this.mob.setSpeed(f1);
                double d4 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);
                float f2 = (float)(-(MathHelper.atan2(d1, d4) * (double)(180F / (float)Math.PI)));
                this.mob.xRot = this.rotlerp(this.mob.xRot, f2, (float)20);
                this.mob.setYya(d1 > 0.0D ? f1 : -f1);



                if (this.courseChangeCooldown-- <= 0) {
                    this.courseChangeCooldown += this.parentEntity.getRandom().nextInt(5) + 2;
                    Vector3d vector3d = new Vector3d(this.wantedX - this.parentEntity.getX(), this.wantedY - this.parentEntity.getY(), this.wantedZ - this.parentEntity.getZ());
                    double d5 = vector3d.length();
                    vector3d = vector3d.normalize();
                    if (this.canReach(vector3d, MathHelper.ceil(d5))) {
                        this.parentEntity.setDeltaMovement(this.parentEntity.getDeltaMovement().add(vector3d.scale(0.1D)));
                    } else {
                        this.operation = MovementController.Action.WAIT;
                    }
                }

            }
        }

        private boolean canReach(Vector3d p_220673_1_, int p_220673_2_) {
            AxisAlignedBB axisalignedbb = this.parentEntity.getBoundingBox();

            for(int i = 1; i < p_220673_2_; ++i) {
                axisalignedbb = axisalignedbb.move(p_220673_1_);
                if (!this.parentEntity.level.noCollision(this.parentEntity, axisalignedbb)) {
                    return false;
                }
            }

            return true;
        }
    }

    static class RandomFlyGoal extends Goal {
        private final EntityDivineFlyingMob parentEntity;

        public RandomFlyGoal(EntityDivineFlyingMob ent) {
            this.parentEntity = ent;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            MovementController movementcontroller = this.parentEntity.getMoveControl();
            if (!movementcontroller.hasWanted()) {
                return true;
            } else {
                double d0 = movementcontroller.getWantedX() - this.parentEntity.getX();
                double d1 = movementcontroller.getWantedY() - this.parentEntity.getY();
                double d2 = movementcontroller.getWantedZ() - this.parentEntity.getZ();
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean canContinueToUse() {
            return false;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            Random random = this.parentEntity.getRandom();
            double d0 = this.parentEntity.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.parentEntity.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.parentEntity.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.parentEntity.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
        }
    }
    protected void addAttackingAI() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {

    }
}
