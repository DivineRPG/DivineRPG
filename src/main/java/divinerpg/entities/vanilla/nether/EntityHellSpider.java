package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.syncher.*;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.ai.navigation.*;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class EntityHellSpider extends EntityDivineMonster {
    private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(EntityHellSpider.class, EntityDataSerializers.BYTE);

    public EntityHellSpider(EntityType<? extends EntityHellSpider> type, Level worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new EntityHellSpider.AttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new EntityHellSpider.TargetGoal<>(this, Player.class));
        this.targetSelector.addGoal(3, new EntityHellSpider.TargetGoal<>(this, IronGolem.class));
    }

    public double getMyRidingOffset() {return (double)(this.getBbHeight() * 0.5F);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new WallClimberNavigation(this, worldIn);
    }
    @Override
    public boolean fireImmune() {
        return true;
    }
    @Override protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(CLIMBING, (byte)0);
    }
    @Override public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            this.setBesideClimbableBlock(this.horizontalCollision);
        }

    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if (super.doHurtTarget(entityIn)) {
            if (entityIn instanceof LivingEntity) {
                entityIn.setRemainingFireTicks(3);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.JUNGLE_SPIDER.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SPIDER_HURT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SPIDER_DEATH;
    }
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
    }

    public boolean isSuppressingSlidingDownLadder() {return this.isBesideClimbableBlock();
    }

    public void makeStuckInBlock(BlockState state, Vec3 motionMultiplierIn) {
        if (!state.is(Blocks.COBWEB)) {
            super.makeStuckInBlock(state, motionMultiplierIn);
        }
    }
    public boolean canBeAffected(MobEffectInstance potioneffectIn) {
        if (potioneffectIn.getEffect() == MobEffects.POISON) {

            return false;
        }
        return super.canBeAffected(potioneffectIn);
    }
    public boolean isBesideClimbableBlock() {
        return (this.entityData.get(CLIMBING) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = this.entityData.get(CLIMBING);
        if (climbing) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(CLIMBING, b0);
    }
    static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(EntityHellSpider p_i46676_1_) {
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
        public Holder<MobEffect> effect;
        public void setRandomEffect(RandomSource p_111104_1_) {
            int i = p_111104_1_.nextInt(5);
            if (i <= 1) {
                this.effect = MobEffects.MOVEMENT_SPEED;
            } else if (i == 2) {
                this.effect = MobEffects.DAMAGE_BOOST;
            } else if (i == 3) {
                this.effect = MobEffects.REGENERATION;
            } else if (i == 4) {
                this.effect = MobEffects.INVISIBILITY;
            }

        }
    }

    static class TargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
        public TargetGoal(EntityHellSpider p_i45818_1_, Class<T> p_i45818_2_) {
            super(p_i45818_1_, p_i45818_2_, true);
        }

        public boolean canUse() {
            float f = this.mob.level().getLightEmission(mob.blockPosition());
            return f >= 0.5F ? false : super.canUse();
        }
    }
}
