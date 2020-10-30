package divinerpg.entities.base;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.*;

public class EntityDivineFlyingMob extends FlyingEntity implements IMob {
    protected EntityDivineFlyingMob(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new EntityDivineFlyingMob.MoveHelperController(this);
    }
    protected void registerGoals() {
        this.goalSelector.addGoal(5, new EntityDivineFlyingMob.RandomFlyGoal(this));
        this.goalSelector.addGoal(7, new EntityDivineFlyingMob.LookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, (p_213812_1_) -> {
            return Math.abs(p_213812_1_.getPosY() - this.getPosY()) <= 4.0D;
        }));

        //TODO - Ranged fly mob attacks
    }

    protected boolean isDespawnPeaceful() {
        return true;
    }



    static class LookAroundGoal extends Goal {
        private final EntityDivineFlyingMob parentEntity;

        public LookAroundGoal(EntityDivineFlyingMob ent) {
            this.parentEntity = ent;
            this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return true;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
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
        private final EntityDivineFlyingMob parentEntity;
        private int courseChangeCooldown;

        public MoveHelperController(EntityDivineFlyingMob ent) {
            super(ent);
            this.parentEntity = ent;
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
        private final EntityDivineFlyingMob parentEntity;

        public RandomFlyGoal(EntityDivineFlyingMob ent) {
            this.parentEntity = ent;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
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

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            return false;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            Random random = this.parentEntity.getRNG();
            double d0 = this.parentEntity.getPosX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.parentEntity.getPosY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.parentEntity.getPosZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
        }
    }
}
