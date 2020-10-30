package divinerpg.entities.vanilla;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.LootTableRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.*;
import net.minecraft.pathfinding.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityPumpkinSpider extends EntityDivineMob {
    private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(EntityPumpkinSpider.class, DataSerializers.BYTE);
    private static final DataParameter<Boolean> PROVOKED = EntityDataManager.createKey(EntityPumpkinSpider.class, DataSerializers.BOOLEAN);

    public EntityPumpkinSpider(EntityType<? extends EntityPumpkinSpider> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
    }
    @Override
    public boolean needsSpecialAI() {
        return true;
    }
    public double getMountedYOffset() {
        return (double)(this.getHeight() * 0.5F);
    }
    protected PathNavigator createNavigator(World worldIn) {
        return new ClimberPathNavigator(this, worldIn);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(CLIMBING, (byte)0);
        this.dataManager.register(PROVOKED, false);
    }
    public void tick() {
        super.tick();
        if (!this.world.isRemote) {
            this.setBesideClimbableBlock(this.collidedHorizontally);
        }

    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.pumpkinSpiderHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.pumpkinSpiderDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.pumpkinSpiderSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.pumpkinSpiderFollowRange);
    }
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SPIDER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_PUMPKIN_SPIDER;
    }
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
    }
    public boolean isOnLadder() {
        return this.isBesideClimbableBlock();
    }
    public void setMotionMultiplier(BlockState state, Vector3d motionMultiplierIn) {
        if (!state.isIn(Blocks.COBWEB)) {
            super.setMotionMultiplier(state, motionMultiplierIn);
        }
    }
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.ARTHROPOD;
    }
    public boolean isPotionApplicable(EffectInstance potioneffectIn) {
        if (potioneffectIn.getPotion() == Effects.POISON) {
            net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent event = new net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent(this, potioneffectIn);
            net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
            return event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW;
        }
        return super.isPotionApplicable(potioneffectIn);
    }
    public boolean isBesideClimbableBlock() {
        return (this.dataManager.get(CLIMBING) & 1) != 0;
    }
    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = this.dataManager.get(CLIMBING);
        if (climbing) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.dataManager.set(CLIMBING, b0);
    }
    public boolean getProvoked() {
        return dataManager.get(PROVOKED).booleanValue();
    }
    public void readAdditional(CompoundNBT tag) {
        super.readAdditional(tag);
        if (tag.getBoolean("Provoked"))
            setProvoked(null);
    }
    public void writeAdditional(CompoundNBT tag) {
        super.writeAdditional(tag);
        tag.putBoolean("Provoked", this.getProvoked());
    }
    @Nullable
    public void setProvoked(PlayerEntity player) {
        dataManager.set(PROVOKED, Boolean.valueOf(true));
        addBasicAI();
        addAttackingAI();
        if (player != null && !player.isCreative()) {
            this.setAttackTarget(player);
        }
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new EntityPumpkinSpider.AttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new EntityPumpkinSpider.TargetGoal<>(this, PlayerEntity.class));
        this.targetSelector.addGoal(3, new EntityPumpkinSpider.TargetGoal<>(this, IronGolemEntity.class));
    }
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        Entity entity = source.getTrueSource();
        if (entity instanceof PlayerEntity && !getProvoked()) {
            PlayerEntity player = (PlayerEntity) entity;
            this.setProvoked(player);
            this.addVelocity(0, 0.6, 0);
        }
        return super.attackEntityFrom(source, amount);
    }
    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        if (worldIn.getRandom().nextInt(100) == 0) {
            SkeletonEntity skeletonentity = EntityType.SKELETON.create(this.world);
            skeletonentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
            skeletonentity.onInitialSpawn(worldIn, difficultyIn, reason, (ILivingEntityData)null, (CompoundNBT)null);
            skeletonentity.startRiding(this);
        }
        if (spawnDataIn == null) {
            spawnDataIn = new EntityPumpkinSpider.GroupData();
            if (worldIn.getDifficulty() == Difficulty.HARD && worldIn.getRandom().nextFloat() < 0.1F * difficultyIn.getClampedAdditionalDifficulty()) {
                ((EntityPumpkinSpider.GroupData)spawnDataIn).setRandomEffect(worldIn.getRandom());
            }
        }
        if (spawnDataIn instanceof EntityPumpkinSpider.GroupData) {
            Effect effect = ((EntityPumpkinSpider.GroupData)spawnDataIn).effect;
            if (effect != null) {
                this.addPotionEffect(new EffectInstance(effect, Integer.MAX_VALUE));
            }
        }
        return spawnDataIn;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.65F;
    }
    static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(EntityPumpkinSpider spider) {
            super(spider, 1.0D, true);
        }
        public boolean shouldExecute() {
            return super.shouldExecute() && !this.attacker.isBeingRidden();
        }
        public boolean shouldContinueExecuting() {
            float f = this.attacker.getBrightness();
            if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0) {
                this.attacker.setAttackTarget((LivingEntity)null);
                return false;
            } else {
                return super.shouldContinueExecuting();
            }
        }
        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return (double)(4.0F + attackTarget.getWidth());
        }
    }
    public static class GroupData implements ILivingEntityData {
        public Effect effect;
        public void setRandomEffect(Random rand) {
            int i = rand.nextInt(5);
            if (i <= 1) {
                this.effect = Effects.SPEED;
            } else if (i <= 2) {
                this.effect = Effects.STRENGTH;
            } else if (i <= 3) {
                this.effect = Effects.REGENERATION;
            } else if (i <= 4) {
                this.effect = Effects.INVISIBILITY;
            }

        }
    }
    static class TargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
        public TargetGoal(EntityPumpkinSpider spider, Class<T> classTarget) {
            super(spider, classTarget, true);
        }
        public boolean shouldExecute() {
            float f = this.goalOwner.getBrightness();
            return f >= 0.5F ? false : super.shouldExecute();
        }
    }
}