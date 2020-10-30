package divinerpg.entities.base;

import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;

import java.util.Random;

public class EntityDivineWaterMob extends AbstractFishEntity {


    public EntityDivineWaterMob(EntityType<? extends EntityDivineWaterMob> type, World worldIn) {
        super(type, worldIn);
        this.rand.setSeed(1 + this.getEntityId());
    }
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        BlockPos blockpos = pos.down();
        return reason == SpawnReason.NATURAL || worldIn.getBlockState(blockpos).canEntitySpawn(worldIn, blockpos, typeIn);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return true;
    }

    public boolean isNotColliding(IWorldReader worldIn) {
        return worldIn.containsAnyLiquid(this.getBoundingBox()) && worldIn.checkNoEntityCollision(this);
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.WATER;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public void livingTick() {
        if (getEntityWorld().isRemote) {
            if (isInWater()) {
                Vector3d vec3d = getLook(0.0F);
                for (int i = 0; i < 2; ++i)
                    getEntityWorld().addParticle(ParticleTypes.BUBBLE, getPosX() + (this.rand.nextDouble() - 0.5D) * (double) this.getWidth() - vec3d.x * 1.5D, getPosY() + this.rand.nextDouble() * (double) this.getHeight() - vec3d.y * 1.5D, getPosZ() + (this.rand.nextDouble() - 0.5D) * (double) this.getWidth() - vec3d.z * 1.5D, 0.0D, 0.0D, 0.0D);
            }
        }

        if (inWater) {
            setAir(300);
        } else if (onGround) {
            setMotion(this.getMotion().add((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F, 0.5D, (this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F));
            rotationYaw = rand.nextFloat() * 360.0F;
            onGround = false;
            isAirBorne = true;
            if (getEntityWorld().getGameTime() % 5 == 0)
                getEntityWorld().playSound(null, getPosX(), getPosY(), getPosZ(), SoundEvents.ENTITY_GUARDIAN_FLOP, SoundCategory.HOSTILE, 1F, 1F);
            this.damageEntity(DamageSource.DROWN, 0.5F);
        }

        super.livingTick();
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 80.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 8F).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.29D);
    }

    @Override
    protected ItemStack getFishBucket() {
        return null;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }

    @Override
    public void travel(Vector3d travel_vector) {
        if (isServerWorld()) {
            if (isInWater()) {
                moveRelative(0.1F, travel_vector);
                move(MoverType.SELF, getMotion());
                setMotion(getMotion().scale(0.8999999761581421D));
                if (getAttackTarget() == null) {
                    setMotion(getMotion().add(0.0D, -0.005D, 0.0D));
                }
            } else {
                super.travel(travel_vector);
            }
        } else {
            super.travel(travel_vector);
        }
    }

    @Override
    public void tick() {
        if (!getEntityWorld().isRemote) {
            if (getAttackTarget() != null && !getEntityWorld().containsAnyLiquid(getAttackTarget().getBoundingBox())) {
                Double distance = (double) getDistance(getAttackTarget());
                if (distance > 1.0F && distance < 6.0F) // && getAttackTarget().getEntityBoundingBox().maxY >= getEntityBoundingBox().minY && getAttackTarget().getEntityBoundingBox().minY <= getEntityBoundingBox().maxY && rand.nextInt(3) == 0)
                    if (isInWater() && getEntityWorld().isAirBlock(new BlockPos((int) getPosX(), (int) getPosY() + 1, (int) getPosZ()))) {

                        double distanceX = getAttackTarget().getPosX() - getPosX();
                        double distanceY = getAttackTarget().getPosY() + (double) (getAttackTarget().getHeight() * 0.5F) - (this.getPosY() + (double) this.getEyeHeight());
                        double distanceZ = getAttackTarget().getPosZ() - getPosZ();
                        float distanceSqrRoot = MathHelper.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
                        double motionX = distanceX / distanceSqrRoot * 0.5D * 0.900000011920929D + getMotion().getX() * 0.70000000298023224D;
                        double motionY = 0.125D;
                        double motionZ = distanceZ / distanceSqrRoot * 0.5D * 0.900000011920929D + getMotion().getZ() * 0.70000000298023224D;
                        setMotion(getMotion().add(motionX * 0.25D, motionY, motionZ * 0.25D));
                    }
            }
        }
        super.tick();
    }

    protected static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(EntityDivineWaterMob mob) {
            super(mob, 0.4D, true);
        }

        @Override
        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return 0.5F + attackTarget.getWidth();
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
            return this.mob.func_212800_dy() && super.shouldExecute();
        }
    }
}