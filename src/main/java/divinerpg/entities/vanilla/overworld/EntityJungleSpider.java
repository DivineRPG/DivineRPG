package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.ai.navigation.*;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class EntityJungleSpider extends EntityDivineMonster {

    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(EntityJungleSpider.class, EntityDataSerializers.BYTE);

    public EntityJungleSpider(EntityType<? extends EntityJungleSpider> p_i48550_1_, Level p_i48550_2_) {
        super(p_i48550_1_, p_i48550_2_);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new EntityJungleSpider.AttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new EntityJungleSpider.TargetGoal<>(this, Player.class));
        this.targetSelector.addGoal(3, new EntityJungleSpider.TargetGoal<>(this, IronGolem.class));
    }

    public double getPassengersRidingOffset() {
        return (double)(this.getBbHeight() * 0.5F);
    }

    protected PathNavigation createNavigation(Level p_175447_1_) {
        return new WallClimberNavigation(this, p_175447_1_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.SPIDER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SPIDER_DEATH;
    }

    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
    }

    public boolean onClimbable() {
        return this.isClimbing();
    }

    public void makeStuckInBlock(BlockState p_213295_1_, Vec3 p_213295_2_) {
        if (!p_213295_1_.is(Blocks.COBWEB)) {
            super.makeStuckInBlock(p_213295_1_, p_213295_2_);
        }

    }

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    public boolean canBeAffected(MobEffectInstance effectInstance) {
        if (effectInstance.getEffect() == MobEffects.POISON) {
            return false;
        }
        return super.canBeAffected(effectInstance);
    }

    public boolean isClimbing() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setClimbing(boolean p_70839_1_) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_70839_1_) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_213386_1_, DifficultyInstance p_213386_2_, MobSpawnType p_213386_3_, @Nullable SpawnGroupData p_213386_4_, @Nullable CompoundTag p_213386_5_) {
        p_213386_4_ = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
        if (p_213386_1_.getRandom().nextInt(100) == 0) {
            Skeleton skeletonentity = EntityType.SKELETON.create(this.level());
            skeletonentity.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, 0.0F);
            skeletonentity.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, (SpawnGroupData)null, (CompoundTag)null);
            skeletonentity.startRiding(this);
        }

        if (p_213386_4_ == null) {
            p_213386_4_ = new EntityJungleSpider.GroupData();
            if (p_213386_1_.getDifficulty() == Difficulty.HARD && p_213386_1_.getRandom().nextFloat() < 0.1F * p_213386_2_.getSpecialMultiplier()) {
                ((EntityJungleSpider.GroupData)p_213386_4_).setRandomEffect(p_213386_1_.getRandom());
            }
        }

        if (p_213386_4_ instanceof EntityJungleSpider.GroupData) {
            MobEffect effect = ((EntityJungleSpider.GroupData)p_213386_4_).effect;
            if (effect != null) {
                this.addEffect(new MobEffectInstance(effect, Integer.MAX_VALUE));
            }
        }

        return p_213386_4_;
    }

    protected float getStandingEyeHeight(Pose p_213348_1_, EntityDimensions p_213348_2_) {
        return 0.65F;
    }

    static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(EntityJungleSpider p_i46676_1_) {
            super(p_i46676_1_, 1.0D, true);
        }

        public boolean canUse() {
            return super.canUse() && !this.mob.isVehicle();
        }

        public boolean canContinueToUse() {
            float f = this.mob.level().getLightEmission(mob.blockPosition());
            if (f >= 0.5F && this.mob.getRandom().nextInt(100) == 0) {
                this.mob.setTarget((LivingEntity)null);
                return false;
            } else {
                return super.canContinueToUse();
            }
        }

        protected double getAttackReachSqr(LivingEntity p_179512_1_) {
            return (double)(4.0F + p_179512_1_.getBbWidth());
        }
    }

    public static class GroupData implements SpawnGroupData {
        public MobEffect effect;

        public void setRandomEffect(RandomSource p_111104_1_) {
            int i = p_111104_1_.nextInt(5);
            if (i <= 1) {
                this.effect = MobEffects.MOVEMENT_SPEED;
            } else if (i <= 2) {
                this.effect = MobEffects.DAMAGE_BOOST;
            } else if (i <= 3) {
                this.effect = MobEffects.REGENERATION;
            } else if (i <= 4) {
                this.effect = MobEffects.INVISIBILITY;
            }

        }
    }

    static class TargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
        public TargetGoal(EntityJungleSpider p_i45818_1_, Class<T> p_i45818_2_) {
            super(p_i45818_1_, p_i45818_2_, true);
        }

        public boolean canUse() {
            float f = this.mob.level().getLightEmission(mob.blockPosition());
            return f >= 0.5F ? false : super.canUse();
        }
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.JUNGLE_SPIDER.get();
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return 0.0F;
    }
}