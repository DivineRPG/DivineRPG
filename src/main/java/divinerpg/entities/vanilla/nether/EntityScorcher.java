package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.entities.projectile.EntityScorcherShot;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.Random;

public class EntityScorcher extends EntityDivineMob {
    private float allowedHeightOffset = 0.5F;
    private int nextHeightOffsetChangeTick;
    private static final DataParameter<Byte> DATA_FLAGS_ID = EntityDataManager.defineId(EntityScorcher.class, DataSerializers.BYTE);

    public EntityScorcher(EntityType<? extends EntityScorcher> type, World level) {
        super(type, level);
        this.setPathfindingMalus(PathNodeType.WATER, -1.0F);
        this.setPathfindingMalus(PathNodeType.LAVA, 8.0F);
        this.setPathfindingMalus(PathNodeType.DANGER_FIRE, 0.0F);
        this.setPathfindingMalus(PathNodeType.DAMAGE_FIRE, 0.0F);
        this.xpReward = 20;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(4, new EntityScorcher.FireballAttackGoal(this));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 0.0F));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SCORCHER;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLAZE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }

    public float getBrightness() {
        return 1.0F;
    }

    public void aiStep() {
        if (!this.onGround && this.getDeltaMovement().y < 0.0D) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }

        if (this.level.isClientSide) {
            if (this.random.nextInt(24) == 0 && !this.isSilent()) {
                this.level.playLocalSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, SoundEvents.BLAZE_BURN, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
            }

            for(int i = 0; i < 2; ++i) {
                this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
            }
        }

        super.aiStep();
    }

    public boolean isSensitiveToWater() {
        return true;
    }

    protected void customServerAiStep() {
        --this.nextHeightOffsetChangeTick;
        if (this.nextHeightOffsetChangeTick <= 0) {
            this.nextHeightOffsetChangeTick = 100;
            this.allowedHeightOffset = 0.5F + (float)this.random.nextGaussian() * 3.0F;
        }

        LivingEntity livingentity = this.getTarget();
        if (livingentity != null && livingentity.getEyeY() > this.getEyeY() + (double)this.allowedHeightOffset && this.canAttack(livingentity)) {
            Vector3d vector3d = this.getDeltaMovement();
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, ((double)0.3F - vector3d.y) * (double)0.3F, 0.0D));
            this.hasImpulse = true;
        }

        super.customServerAiStep();
    }

    public boolean causeFallDamage(float i, float y) {
        return false;
    }


    static class FireballAttackGoal extends Goal {
        private final EntityScorcher scorcher;
        private int attackStep;
        private int attackTime;
        private int lastSeen;

        public FireballAttackGoal(EntityScorcher scorcher) {
            this.scorcher = scorcher;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingentity = this.scorcher.getTarget();
            return livingentity != null && livingentity.isAlive() && this.scorcher.canAttack(livingentity);
        }

        public void start() {
            this.attackStep = 0;
        }

        public void stop() {
            this.lastSeen = 0;
        }

        public void tick() {
            --this.attackTime;
            LivingEntity livingentity = this.scorcher.getTarget();
            if (livingentity != null) {
                boolean flag = this.scorcher.getSensing().canSee(livingentity);
                if (flag) {
                    this.lastSeen = 0;
                } else {
                    ++this.lastSeen;
                }

                double d0 = this.scorcher.distanceToSqr(livingentity);
                if (d0 < 4.0D) {
                    if (!flag) {
                        return;
                    }

                    if (this.attackTime <= 0) {
                        this.attackTime = 20;
                        this.scorcher.doHurtTarget(livingentity);
                    }

                    this.scorcher.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                } else if (d0 < this.getFollowDistance() * this.getFollowDistance() && flag) {
                    double d1 = livingentity.getX() - this.scorcher.getX();
                    double d2 = livingentity.getY(0.5D) - this.scorcher.getY(0.5D);
                    double d3 = livingentity.getZ() - this.scorcher.getZ();
                    if (this.attackTime <= 0) {
                        ++this.attackStep;
                        if (this.attackStep == 1) {
                            this.attackTime = 60;
                        } else if (this.attackStep <= 4) {
                            this.attackTime = 6;
                        } else {
                            this.attackTime = 100;
                            this.attackStep = 0;
                        }

                        if (this.attackStep > 1) {
                            float f = MathHelper.sqrt(MathHelper.sqrt(d0)) * 0.5F;
                            if (!this.scorcher.isSilent()) {
                                this.scorcher.level.levelEvent((PlayerEntity)null, 1018, this.scorcher.blockPosition(), 0);
                            }

                            for(int i = 0; i < 1; ++i) {
                                if (scorcher.isAlive()) {
                                    ProjectileEntity projectile = new EntityScorcherShot(scorcher.level, scorcher, 1.4D, 1.4D, 1.4D);
                                    double livingX = livingentity.getX() - scorcher.getX();
                                    double livingY = livingentity.getY(0.3333333333333333D) - projectile.getY() - 0.4;
                                    double livingZ = livingentity.getZ() - scorcher.getZ();
                                    double randomness = (double) MathHelper.sqrt(livingX * livingX + livingZ * livingZ);
                                    projectile.shoot(livingX, livingY + randomness * (double) 0.2F, livingZ, 1.6F, (float) (14 - scorcher.level.getDifficulty().getId() * 4));
                                    scorcher.level.addFreshEntity(projectile);
                                }
                            }
                        }
                    }

                    this.scorcher.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
                } else if (this.lastSeen < 5) {
                    this.scorcher.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                }

                super.tick();
            }
        }

        private double getFollowDistance() {
            return this.scorcher.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.ATTACK_DAMAGE, EntityStats.scorcherDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.scorcherSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.scorcherFollowRange).add(Attributes.MAX_HEALTH, EntityStats.scorcherHealth);
    }
}