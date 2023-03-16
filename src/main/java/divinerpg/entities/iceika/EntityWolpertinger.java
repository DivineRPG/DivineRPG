package divinerpg.entities.iceika;

import com.mojang.serialization.Codec;
import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.*;
import net.minecraft.util.*;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.function.IntFunction;

public class EntityWolpertinger extends EntityDivineMonster {
    private int jumpTicks, jumpDuration, jumpDelayTicks;
    private boolean wasOnGround;

    public EntityWolpertinger(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.jumpControl = new EntityWolpertinger.WolpertingerJumpControl(this);
        this.moveControl = new EntityWolpertinger.WolpertingerMoveControl(this);
        this.setSpeedModifier(0.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new ClimbOnTopOfPowderSnowGoal(this, this.level));
        this.goalSelector.addGoal(1, new EntityWolpertinger.WolpertingerPanicGoal(this, 2.2D));
        this.goalSelector.addGoal(4, new EntityWolpertinger.WolpertingerAvoidEntityGoal<>(this, Player.class, 8.0F, 2.2D, 2.2D));
        this.goalSelector.addGoal(4, new EntityWolpertinger.WolpertingerAvoidEntityGoal<>(this, Wolf.class, 10.0F, 2.2D, 2.2D));
        this.goalSelector.addGoal(4, new EntityWolpertinger.WolpertingerAvoidEntityGoal<>(this, Monster.class, 4.0F, 2.2D, 2.2D));
        this.goalSelector.addGoal(5, new EntityWolpertinger.RaidGardenGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(11, new LookAtPlayerGoal(this, Player.class, 10.0F));
    }

    protected float getJumpPower() {
        if (!this.horizontalCollision && (!this.moveControl.hasWanted() || !(this.moveControl.getWantedY() > this.getY() + 0.5D))) {
            Path path = this.navigation.getPath();
            if (path != null && !path.isDone()) {
                Vec3 vec3 = path.getNextEntityPos(this);
                if (vec3.y > this.getY() + 0.5D) {
                    return 0.5F;
                }
            }

            return this.moveControl.getSpeedModifier() <= 0.6D ? 0.2F : 0.3F;
        } else {
            return 0.5F;
        }
    }

    protected void jumpFromGround() {
        super.jumpFromGround();
        double d0 = this.moveControl.getSpeedModifier();
        if (d0 > 0.0D) {
            double d1 = this.getDeltaMovement().horizontalDistanceSqr();
            if (d1 < 0.01D) {
                this.moveRelative(0.1F, new Vec3(0.0D, 0.0D, 1.0D));
            }
        }

        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)1);
        }

    }

    public float getJumpCompletion(float p_29736_) {
        return this.jumpDuration == 0 ? 0.0F : ((float)this.jumpTicks + p_29736_) / (float)this.jumpDuration;
    }

    public void setSpeedModifier(double p_29726_) {
        this.getNavigation().setSpeedModifier(p_29726_);
        this.moveControl.setWantedPosition(this.moveControl.getWantedX(), this.moveControl.getWantedY(), this.moveControl.getWantedZ(), p_29726_);
    }

    public void setJumping(boolean p_29732_) {
        super.setJumping(p_29732_);
        if (p_29732_) {
            this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * 0.8F);
        }

    }

    public void startJumping() {
        this.setJumping(true);
        this.jumpDuration = 10;
        this.jumpTicks = 0;
    }

    public void customServerAiStep() {
        if (this.jumpDelayTicks > 0) {
            --this.jumpDelayTicks;
        }

        if (this.onGround) {
            if (!this.wasOnGround) {
                this.setJumping(false);
                this.checkLandingDelay();
            }

            EntityWolpertinger.WolpertingerJumpControl Wolpertinger$Wolpertingerjumpcontrol = (EntityWolpertinger.WolpertingerJumpControl)this.jumpControl;
            if (!Wolpertinger$Wolpertingerjumpcontrol.wantJump()) {
                if (this.moveControl.hasWanted() && this.jumpDelayTicks == 0) {
                    Path path = this.navigation.getPath();
                    Vec3 vec3 = new Vec3(this.moveControl.getWantedX(), this.moveControl.getWantedY(), this.moveControl.getWantedZ());
                    if (path != null && !path.isDone()) {
                        vec3 = path.getNextEntityPos(this);
                    }

                    this.facePoint(vec3.x, vec3.z);
                    this.startJumping();
                }
            } else if (!Wolpertinger$Wolpertingerjumpcontrol.canJump()) {
                this.enableJumpControl();
            }
        }

        this.wasOnGround = this.onGround;
    }

    public boolean canSpawnSprintParticle() {
        return false;
    }

    private void facePoint(double p_29687_, double p_29688_) {
        this.setYRot((float)(Mth.atan2(p_29688_ - this.getZ(), p_29687_ - this.getX()) * (double)(180F / (float)Math.PI)) - 90.0F);
    }

    private void enableJumpControl() {
        ((EntityWolpertinger.WolpertingerJumpControl)this.jumpControl).setCanJump(true);
    }

    private void disableJumpControl() {
        ((EntityWolpertinger.WolpertingerJumpControl)this.jumpControl).setCanJump(false);
    }

    private void setLandingDelay() {
        if (this.moveControl.getSpeedModifier() < 2.2D) {
            this.jumpDelayTicks = 10;
        } else {
            this.jumpDelayTicks = 1;
        }

    }

    private void checkLandingDelay() {
        this.setLandingDelay();
        this.disableJumpControl();
    }

    public void aiStep() {
        super.aiStep();
        if (this.jumpTicks != this.jumpDuration) {
            ++this.jumpTicks;
        } else if (this.jumpDuration != 0) {
            this.jumpTicks = 0;
            this.jumpDuration = 0;
            this.setJumping(false);
        }

    }

    public void addAdditionalSaveData(CompoundTag p_29697_) {
        super.addAdditionalSaveData(p_29697_);
    }

    public void readAdditionalSaveData(CompoundTag p_29684_) {
        super.readAdditionalSaveData(p_29684_);
    }

    protected SoundEvent getJumpSound() {
        return SoundEvents.RABBIT_JUMP;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.RABBIT_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_29715_) {
        return SoundEvents.RABBIT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.RABBIT_DEATH;
    }

    public boolean doHurtTarget(Entity p_29659_) {
            return p_29659_.hurt(p_29659_.level.damageSources().mobAttack(this), 3.0F);
    }

    public SoundSource getSoundSource() {
        return SoundSource.NEUTRAL;
    }




    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @Nullable SpawnGroupData p_29681_, @Nullable CompoundTag p_29682_) {
        EntityWolpertinger.Variant Wolpertinger$variant = getRandomWolpertingerVariant(p_29678_, this.blockPosition());
            p_29681_ = new EntityWolpertinger.WolpertingerGroupData(Wolpertinger$variant);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    private static EntityWolpertinger.Variant getRandomWolpertingerVariant(LevelAccessor p_262699_, BlockPos p_262700_) {
        Holder<Biome> holder = p_262699_.getBiome(p_262700_);
        int i = p_262699_.getRandom().nextInt(100);
            return i < 50 ? EntityWolpertinger.Variant.BROWN : (i < 90 ? EntityWolpertinger.Variant.SALT : EntityWolpertinger.Variant.BLACK);
    }


    public void handleEntityEvent(byte p_29663_) {
        if (p_29663_ == 1) {
            this.spawnSprintParticle();
            this.jumpDuration = 10;
            this.jumpTicks = 0;
        } else {
            super.handleEntityEvent(p_29663_);
        }

    }

    public Vec3 getLeashOffset() {
        return new Vec3(0.0D, (double)(0.6F * this.getEyeHeight()), (double)(this.getBbWidth() * 0.4F));
    }

    static class WolpertingerAvoidEntityGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {
        private final EntityWolpertinger Wolpertinger;

        public WolpertingerAvoidEntityGoal(EntityWolpertinger p_29743_, Class<T> p_29744_, float p_29745_, double p_29746_, double p_29747_) {
            super(p_29743_, p_29744_, p_29745_, p_29746_, p_29747_);
            this.Wolpertinger = p_29743_;
        }

        public boolean canUse() {
            return super.canUse();
        }
    }

    public static class WolpertingerGroupData extends AgeableMob.AgeableMobGroupData {
        public final EntityWolpertinger.Variant variant;

        public WolpertingerGroupData(EntityWolpertinger.Variant p_262662_) {
            super(1.0F);
            this.variant = p_262662_;
        }
    }

    public static class WolpertingerJumpControl extends JumpControl {
        private final EntityWolpertinger Wolpertinger;
        private boolean canJump;

        public WolpertingerJumpControl(EntityWolpertinger p_186229_) {
            super(p_186229_);
            this.Wolpertinger = p_186229_;
        }

        public boolean wantJump() {
            return this.jump;
        }

        public boolean canJump() {
            return this.canJump;
        }

        public void setCanJump(boolean p_29759_) {
            this.canJump = p_29759_;
        }

        public void tick() {
            if (this.jump) {
                this.Wolpertinger.startJumping();
                this.jump = false;
            }

        }
    }

    static class WolpertingerMoveControl extends MoveControl {
        private final EntityWolpertinger Wolpertinger;
        private double nextJumpSpeed;

        public WolpertingerMoveControl(EntityWolpertinger p_29766_) {
            super(p_29766_);
            this.Wolpertinger = p_29766_;
        }

        public void tick() {
            if (this.Wolpertinger.onGround && !this.Wolpertinger.jumping && !((EntityWolpertinger.WolpertingerJumpControl)this.Wolpertinger.jumpControl).wantJump()) {
                this.Wolpertinger.setSpeedModifier(0.0D);
            } else if (this.hasWanted()) {
                this.Wolpertinger.setSpeedModifier(this.nextJumpSpeed);
            }

            super.tick();
        }

        public void setWantedPosition(double p_29769_, double p_29770_, double p_29771_, double p_29772_) {
            if (this.Wolpertinger.isInWater()) {
                p_29772_ = 1.5D;
            }

            super.setWantedPosition(p_29769_, p_29770_, p_29771_, p_29772_);
            if (p_29772_ > 0.0D) {
                this.nextJumpSpeed = p_29772_;
            }

        }
    }

    static class WolpertingerPanicGoal extends PanicGoal {
        private final EntityWolpertinger Wolpertinger;

        public WolpertingerPanicGoal(EntityWolpertinger p_29775_, double p_29776_) {
            super(p_29775_, p_29776_);
            this.Wolpertinger = p_29775_;
        }

        public void tick() {
            super.tick();
            this.Wolpertinger.setSpeedModifier(this.speedModifier);
        }
    }

    static class RaidGardenGoal extends MoveToBlockGoal {
        private final EntityWolpertinger Wolpertinger;
        private boolean wantsToRaid;
        private boolean canRaid;

        public RaidGardenGoal(EntityWolpertinger p_29782_) {
            super(p_29782_, (double)0.7F, 16);
            this.Wolpertinger = p_29782_;
        }

        public boolean canUse() {
            if (this.nextStartTick <= 0) {
                if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.Wolpertinger.level, this.Wolpertinger)) {
                    return false;
                }

                this.canRaid = false;
            }

            return super.canUse();
        }

        public boolean canContinueToUse() {
            return this.canRaid && super.canContinueToUse();
        }

        public void tick() {
            super.tick();
            this.Wolpertinger.getLookControl().setLookAt((double)this.blockPos.getX() + 0.5D, (double)(this.blockPos.getY() + 1), (double)this.blockPos.getZ() + 0.5D, 10.0F, (float)this.Wolpertinger.getMaxHeadXRot());
            if (this.isReachedTarget()) {
                Level level = this.Wolpertinger.level;
                BlockPos blockpos = this.blockPos.above();
                BlockState blockstate = level.getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (this.canRaid && block instanceof CarrotBlock) {
                    int i = blockstate.getValue(CarrotBlock.AGE);
                    if (i == 0) {
                        level.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 2);
                        level.destroyBlock(blockpos, true, this.Wolpertinger);
                    } else {
                        level.setBlock(blockpos, blockstate.setValue(CarrotBlock.AGE, Integer.valueOf(i - 1)), 2);
                        level.levelEvent(2001, blockpos, Block.getId(blockstate));
                    }

                }

                this.canRaid = false;
                this.nextStartTick = 10;
            }

        }

        protected boolean isValidTarget(LevelReader p_29785_, BlockPos p_29786_) {
            BlockState blockstate = p_29785_.getBlockState(p_29786_);
            if (blockstate.is(Blocks.FARMLAND) && this.wantsToRaid && !this.canRaid) {
                blockstate = p_29785_.getBlockState(p_29786_.above());
                if (blockstate.getBlock() instanceof CarrotBlock && ((CarrotBlock)blockstate.getBlock()).isMaxAge(blockstate)) {
                    this.canRaid = true;
                    return true;
                }
            }

            return false;
        }
    }

    public static enum Variant implements StringRepresentable {
        BROWN(0, "brown"),
        WHITE(1, "white"),
        BLACK(2, "black"),
        WHITE_SPLOTCHED(3, "white_splotched"),
        GOLD(4, "gold"),
        SALT(5, "salt"),
        EVIL(99, "evil");

        private static final IntFunction<EntityWolpertinger.Variant> BY_ID = ByIdMap.sparse(EntityWolpertinger.Variant::id, values(), BROWN);
        public static final Codec<EntityWolpertinger.Variant> CODEC = StringRepresentable.fromEnum(EntityWolpertinger.Variant::values);
        final int id;
        private final String name;

        private Variant(int p_262657_, String p_262679_) {
            this.id = p_262657_;
            this.name = p_262679_;
        }

        public String getSerializedName() {
            return this.name;
        }

        public int id() {
            return this.id;
        }

        public static EntityWolpertinger.Variant byId(int p_262665_) {
            return BY_ID.apply(p_262665_);
        }
    }
}