package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.objects.entities.entity.projectiles.EntityFrostShot;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityFrost extends EntityDivineMob {

    private float heightOffset = 0.5F;
    private int heightOffsetUpdateTime;

    public EntityFrost(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
        this.experienceValue = 20;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
    }

    @Override
    public float getEyeHeight() {
        return 0.6F;
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(4, new EntityFrost.AIFrostShotAttack(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D, 0.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
    }

    @Override
    public void onLivingUpdate() {
        if (!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.6D;
        }
        if (!this.world.isRemote) {
            this.setAttackTarget(this.world.getNearestAttackablePlayer(this, 22.0D, 22.0D));
        }
        super.onLivingUpdate();
    }

    @Override
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

    static class AIFrostShotAttack extends EntityAIBase {
        private EntityFrost frost;
        private int attackStep;
        private int attackTime;

        public AIFrostShotAttack(EntityFrost frostIn) {
            this.frost = frostIn;
            this.setMutexBits(3);
        }

        public boolean shouldExecute() {
            EntityLivingBase entitylivingbase = this.frost.getAttackTarget();
            return entitylivingbase != null && entitylivingbase.isEntityAlive();
        }

        public void startExecuting() {
            this.attackStep = 0;
        }

        public void updateTask() {
            --this.attackTime;
            EntityLivingBase entitylivingbase = this.frost.getAttackTarget();
            double d0 = this.frost.getDistanceSq(entitylivingbase);

            if (d0 < 4.0D) {
                if (this.attackTime <= 0) {
                    this.attackTime = 20;
                    this.frost.attackEntityAsMob(entitylivingbase);
                }

                this.frost.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY,
                        entitylivingbase.posZ, 1.0D);
            } else if (d0 < this.getFollowDistance() * this.getFollowDistance()) {
                double d1 = entitylivingbase.posX - this.frost.posX;
                double d2 = entitylivingbase.getEntityBoundingBox().minY + (double) (entitylivingbase.height / 2.0F)
                        - (this.frost.posY + (double) (this.frost.height / 2.0F));
                double d3 = entitylivingbase.posZ - this.frost.posZ;

                if (this.attackTime <= 0) {
                    ++this.attackStep;

                    this.attackTime = 10;
                    if (this.attackStep == 3) {
                        this.attackTime = 40;
                        this.attackStep = 0;
                    }

                    float f = MathHelper.sqrt(MathHelper.sqrt(d0)) * 0.5F;
                    this.frost.world.playEvent(null, 1018,
                            new BlockPos((int) this.frost.posX, (int) this.frost.posY, (int) this.frost.posZ), 0);

                    EntityFrostShot entityShot = new EntityFrostShot(this.frost.world, this.frost,
                            d1 + this.frost.getRNG().nextGaussian() * (double) f, d2,
                            d3 + this.frost.getRNG().nextGaussian() * (double) f);
                    entityShot.posY = this.frost.posY + (double) (this.frost.height / 2.0F);
                    this.frost.world.spawnEntity(entityShot);
                }

                this.frost.getLookHelper().setLookPositionWithEntity(entitylivingbase, 10.0F, 10.0F);
            } else {
                this.frost.getNavigator().clearPath();
                this.frost.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY,
                        entitylivingbase.posZ, 1.0D);
            }

            super.updateTask();
        }

        private double getFollowDistance() {
            IAttributeInstance iattributeinstance = this.frost.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
            return iattributeinstance == null ? 16.0D : iattributeinstance.getAttributeValue();
        }
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.FROST;
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
        return LootTableRegistry.ENTITIES_FROST;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && super.getCanSpawnHere();
    }
}
