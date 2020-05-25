package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.objects.entities.entity.projectiles.EntityScorcherShot;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityScorcher extends EntityDivineMob {
    private float heightOffset = 0.5F;
    private int heightOffsetUpdateTime;
    private int anger;

    public EntityScorcher(World worldIn) {
        super(worldIn);
        this.setSize(1.2F, 2F);
        this.isImmuneToFire = true;
        this.experienceValue = 20;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
    }

    @Override
    public float getEyeHeight() {
        return 1.6F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(4, new EntityScorcher.AIScorcherShotAttack(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D, 0.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
    }

    public void onLivingUpdate() {
        if (!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.6D;
        }

        if (this.world.isRemote) {
            if (this.rand.nextInt(24) == 0 && !this.isSilent()) {
                this.world.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D,
                        SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 1.0F + this.rand.nextFloat(),
                        this.rand.nextFloat() * 0.7F + 0.3F, false);
            }

            for (int i = 0; i < 2; ++i) {
                this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE,
                        this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width,
                        this.posY + this.rand.nextDouble() * (double) this.height,
                        this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
            }
        } else {
            this.setAttackTarget(this.world.getNearestAttackablePlayer(this, 22.0D, 22.0D));
        }

        super.onLivingUpdate();
    }

    protected void updateAITasks() {
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.DROWN, 1.0F);
        }

        --this.heightOffsetUpdateTime;

        if (this.heightOffsetUpdateTime <= 0) {
            this.heightOffsetUpdateTime = 100;
            this.heightOffset = 0.5F + (float) this.rand.nextGaussian() * 3.0F;
        }

        EntityLivingBase entitylivingbase = this.getAttackTarget();

        if (entitylivingbase != null && entitylivingbase.posY + (double) entitylivingbase.getEyeHeight() > this.posY
                + (double) this.getEyeHeight() + (double) this.heightOffset) {
            this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
            this.isAirBorne = true;
        }

        super.updateAITasks();
    }

    static class AIScorcherShotAttack extends EntityAIBase {
        private final EntityScorcher scorcher;
        private int attackStep;
        private int attackTime;

        public AIScorcherShotAttack(EntityScorcher scorcherIn) {
            this.scorcher = scorcherIn;
            this.setMutexBits(3);
        }

        public boolean shouldExecute() {
            EntityLivingBase entitylivingbase = this.scorcher.getAttackTarget();
            return entitylivingbase != null && entitylivingbase.isEntityAlive();
        }

        public void startExecuting() {
            this.attackStep = 0;
        }

        public void updateTask() {
            --this.attackTime;
            EntityLivingBase entitylivingbase = this.scorcher.getAttackTarget();
            double d0 = this.scorcher.getDistanceSq(entitylivingbase);

            if (d0 < 4.0D) {
                if (this.attackTime <= 0) {
                    this.attackTime = 20;
                    this.scorcher.attackEntityAsMob(entitylivingbase);
                }

                this.scorcher.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY,
                        entitylivingbase.posZ, 1.0D);
            } else if (d0 < this.getFollowDistance() * this.getFollowDistance()) {
                double d1 = entitylivingbase.posX - this.scorcher.posX;
                double d2 = entitylivingbase.getEntityBoundingBox().minY + (double) (entitylivingbase.height / 2.0F)
                        - (this.scorcher.posY + (double) (this.scorcher.height / 2.0F));
                double d3 = entitylivingbase.posZ - this.scorcher.posZ;

                if (this.attackTime <= 0) {
                    ++this.attackStep;

                    if (this.attackStep == 1) {
                        this.attackTime = 0;
                    } else if (this.attackStep <= 4) {
                        this.attackTime = 6;
                    } else {
                        this.attackTime = 0;
                        this.attackStep = 0;
                    }

                    if (this.attackStep > 1) {
                        float f = MathHelper.sqrt(MathHelper.sqrt(d0)) * 0.5F;
                        this.scorcher.world.playEvent(null, 1018, new BlockPos((int) this.scorcher.posX,
                                (int) this.scorcher.posY, (int) this.scorcher.posZ), 0);

                        for (int i = 0; i < 1; ++i) {
                            EntityScorcherShot scorcherShot = new EntityScorcherShot(this.scorcher.world, this.scorcher,
                                    d1 + this.scorcher.getRNG().nextGaussian() * (double) f, d2,
                                    d3 + this.scorcher.getRNG().nextGaussian() * (double) f);
                            scorcherShot.posY = this.scorcher.posY + (double) (this.scorcher.height / 2.0F) + 0.5D;
                            this.scorcher.world.spawnEntity(scorcherShot);
                        }
                    }
                }

                this.scorcher.getLookHelper().setLookPositionWithEntity(entitylivingbase, 10.0F, 10.0F);
            } else {
                this.scorcher.getNavigator().clearPath();
                this.scorcher.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY,
                        entitylivingbase.posZ, 1.0D);
            }

            super.updateTask();
        }

        private double getFollowDistance() {
            IAttributeInstance iattributeinstance = this.scorcher
                    .getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
            return iattributeinstance == null ? 16.0D : iattributeinstance.getAttributeValue();
        }
    }

    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    public int getBrightnessForRender() {
        return 15728880;
    }

    @Override
    public float getBrightness() {
        return 1.0F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SCORCHER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_BLAZE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BLAZE_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SCORCHER;
    }
}
