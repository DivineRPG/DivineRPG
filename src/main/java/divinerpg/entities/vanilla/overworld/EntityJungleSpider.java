package divinerpg.entities.vanilla.overworld;

import java.util.Random;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;

public class EntityJungleSpider extends EntityDivineMob {
    private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(EntityJungleSpider.class, DataSerializers.BYTE);

    public EntityJungleSpider(EntityType<? extends EntityJungleSpider> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new EntityJungleSpider.AttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new EntityJungleSpider.TargetGoal<>(this, PlayerEntity.class));
        this.targetSelector.addGoal(3, new EntityJungleSpider.TargetGoal<>(this, IronGolemEntity.class));
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
    }
    public void tick() {
        super.tick();
        if (!this.world.isRemote) {
            this.setBesideClimbableBlock(this.collidedHorizontally);
        }

    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.jungleSpiderHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.jungleSpiderDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.jungleSpiderSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.follow);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.JUNGLE_SPIDER;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_JUNGLE_SPIDER;
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

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.65F;
    }

    static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(EntityJungleSpider spider) {
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
        public TargetGoal(EntityJungleSpider spider, Class<T> classTarget) {
            super(spider, classTarget, true);
        }

        public boolean shouldExecute() {
            float f = this.goalOwner.getBrightness();
            return f >= 0.5F ? false : super.shouldExecute();
        }
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return world.getDimensionKey() == World.OVERWORLD && super.canSpawn(worldIn, spawnReasonIn);
    }
}