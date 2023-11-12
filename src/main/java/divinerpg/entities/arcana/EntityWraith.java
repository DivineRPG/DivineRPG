package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import javax.annotation.Nullable;
import java.util.EnumSet;

public class EntityWraith extends EntityDivineTameable {
	public EntityWraith(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        this(type, worldIn);
        tame(player);
    }
	public EntityWraith(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
        moveControl = new EntityWraith.MoveHelperController(this);
    }
    protected void registerGoals() {
        goalSelector.addGoal(5, new EntityWraith.RandomFlyGoal(this));
        goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 64.0F));
        goalSelector.addGoal(6, new EntityWraith.LookAroundGoal(this));
    }
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.15625F;}
    @Override
    protected float getSoundVolume() {
        return .1F;
    }
    @Override
	public float getVoicePitch() {
        return super.getVoicePitch() * 0.95F;
    }
    @Nullable
    @Override
    public SoundEvent getAmbientSound() {
        return SoundRegistry.WRAITH.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundRegistry.WRAITH_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.WRAITH_HURT.get();
    }
    static class LookAroundGoal extends Goal {
        private final EntityWraith parentEntity;

        public LookAroundGoal(EntityWraith ent) {
            this.parentEntity = ent;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        @Override
        public boolean canUse() {
            return true;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        @Override
        public void tick() {
            if (this.parentEntity.getTarget() == null) {
                Vec3 vector3d = this.parentEntity.getDeltaMovement();
                this.parentEntity.xRot = -((float) Mth.atan2(vector3d.x, vector3d.z)) * (180F / (float)Math.PI);
                this.parentEntity.xRotO = this.parentEntity.xRot;
            } else {
                LivingEntity livingentity = this.parentEntity.getTarget();
//                double d0 = 64.0D;
                if (livingentity.distanceToSqr(this.parentEntity) < 4096.0D) {
                    double d1 = livingentity.getX() - this.parentEntity.getX();
                    double d2 = livingentity.getZ() - this.parentEntity.getZ();
                    this.parentEntity.xRot = -((float)Mth.atan2(d1, d2)) * (180F / (float)Math.PI);
                    this.parentEntity.xRotO = this.parentEntity.xRot;
                }
            }

        }
    }
    static class MoveHelperController extends MoveControl {
        private final EntityWraith parentEntity;
        private int courseChangeCooldown;

        public MoveHelperController(EntityWraith ent) {
            super(ent);
            this.parentEntity = ent;
        }

        @Override
        public void tick() {
            if (this.operation == MoveControl.Operation.MOVE_TO) {

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

                float f = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                this.mob.yRot = this.rotlerp(this.mob.yRot, f, 90.0F);
                float f1;
                if (this.mob.onGround()) {
                    f1 = (float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED));
                } else {
                    f1 = (float)(this.speedModifier * this.mob.getAttributeValue(Attributes.FLYING_SPEED));
                }

                this.mob.setSpeed(f1);
                double d4 = (double)Mth.sqrt((float) (d0 * d0 + d2 * d2));
                float f2 = (float)(-(Mth.atan2(d1, d4) * (double)(180F / (float)Math.PI)));
                this.mob.xRot = this.rotlerp(this.mob.xRot, f2, (float)20);
                this.mob.setYya(d1 > 0.0D ? f1 : -f1);



                if (this.courseChangeCooldown-- <= 0) {
                    this.courseChangeCooldown += this.parentEntity.getRandom().nextInt(5) + 2;
                    Vec3 vector3d = new Vec3(this.wantedX - this.parentEntity.getX(), this.wantedY - this.parentEntity.getY(), this.wantedZ - this.parentEntity.getZ());
                    double d5 = vector3d.length();
                    vector3d = vector3d.normalize();
                    if (this.canReach(vector3d, Mth.ceil(d5))) {
                        this.parentEntity.setDeltaMovement(this.parentEntity.getDeltaMovement().add(vector3d.scale(0.1D)));
                    } else {
                        this.operation = MoveControl.Operation.WAIT;
                    }
                }

            }
        }

        private boolean canReach(Vec3 p_220673_1_, int p_220673_2_) {
            AABB axisalignedbb = this.parentEntity.getBoundingBox();

            for(int i = 1; i < p_220673_2_; ++i) {
                axisalignedbb = axisalignedbb.move(p_220673_1_);
                if (!this.parentEntity.level().noCollision(this.parentEntity, axisalignedbb)) {
                    return false;
                }
            }

            return true;
        }
    }

    static class RandomFlyGoal extends Goal {
        private final EntityWraith parentEntity;

        public RandomFlyGoal(EntityWraith ent) {
            this.parentEntity = ent;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            if(parentEntity.getTarget() != null){
                return false;
            }
            MoveControl movementcontroller = this.parentEntity.getMoveControl();
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
        @Override
        public boolean canContinueToUse() {
            return false;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        @Override
        public void start() {
            RandomSource random = this.parentEntity.getRandom();
            double d0 = this.parentEntity.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.parentEntity.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.parentEntity.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.parentEntity.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
        }
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }
}
