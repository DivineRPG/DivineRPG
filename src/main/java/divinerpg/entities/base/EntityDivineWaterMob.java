package divinerpg.entities.base;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.fish.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.particles.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityDivineWaterMob extends AbstractFishEntity {


    public EntityDivineWaterMob(EntityType<? extends EntityDivineWaterMob> type, World worldIn) {
        super(type, worldIn);
        this.random.setSeed(1 + this.getId());
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }

    public boolean checkSpawnObstruction(IWorldReader worldIn) {
        return worldIn.containsAnyLiquid(this.getBoundingBox()) && worldIn.noCollision(this);
    }


    @Override
    public CreatureAttribute getMobType() {
        return CreatureAttribute.WATER;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public void tick() {
        if (level.isClientSide) {
            if (isInWater()) {
                Vector3d vec3d = getEyePosition(0.0F);
                for (int i = 0; i < 2; ++i)
                    level.addParticle(ParticleTypes.BUBBLE, getX() + (this.random.nextDouble() - 0.5D) * (double) this.getBbWidth() - vec3d.x * 1.5D, getY() + this.random.nextDouble() * (double) this.getBbHeight() - vec3d.y * 1.5D, getZ() + (this.random.nextDouble() - 0.5D) * (double) this.getBbWidth() - vec3d.z * 1.5D, 0.0D, 0.0D, 0.0D);
            }
        }

        if (isInWater()) {
            setAirSupply(300);
        } else if (onGround) {
            setDeltaMovement(this.getDeltaMovement().add((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F, 0.5D, (this.random.nextFloat() * 2.0F - 1.0F) * 0.4F));
            xRot = random.nextFloat() * 360.0F;
            onGround = false;
            this.jumping = true;
            if (level.getGameTime() % 5 == 0)
                level.playSound(null, getX(), getY(), getZ(), SoundEvents.GUARDIAN_FLOP, SoundCategory.HOSTILE, 1F, 1F);
            this.hurt(DamageSource.DROWN, 0.5F);
        }

        super.tick();
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 80.0D).add(Attributes.ATTACK_DAMAGE, 8F).add(Attributes.MOVEMENT_SPEED, 0.29D);
    }

    @Override
    protected ItemStack getBucketItemStack() {
        return null;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }


    protected static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(EntityDivineWaterMob mob) {
            super(mob, 0.4D, true);
        }

        @Override
        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return 0.5F + attackTarget.getBbWidth();
        }
    }

    protected static class TargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
        public TargetGoal(EntityDivineWaterMob mob, Class<T> classTarget) {
            super(mob, classTarget, true);
        }
    }

    @Override
    protected void registerGoals() {
        if(!needsSpecialAI()){
            addBasicAI();
        }
    }
    public boolean needsSpecialAI() {
        return false;
    }

    protected void addBasicAI() {
        this.goalSelector.addGoal(0, new EntityDivineWaterMob.SwimGoal(this));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));

    }

    protected void addAttackingAI() {
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }
    static class SwimGoal extends RandomSwimmingGoal {
        private final EntityDivineWaterMob mob;

        public SwimGoal(EntityDivineWaterMob mob) {
            super(mob, 1.0D, 40);
            this.mob = mob;
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return this.mob.canRandomSwim() && super.canUse();
        }
    }
}