package divinerpg.objects.entities.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.MobEffects;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class EntityDivineWaterMob extends EntityPeacefulUntilAttacked {
	public float mobPitch, prevmobPitch, mobYaw, prevmobYaw, mobRotation, prevmobRotation, randomMotionSpeed, 
	rotationVelocity, rotateSpeed, randomMotionVecX, randomMotionVecY, randomMotionVecZ;
    
    public EntityDivineWaterMob(World par1World) {
        super(par1World);
        this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
    }
    
    @Override
    protected void initEntityAI()
    {
    	super.initEntityAI();
        this.tasks.addTask(0, new EntityDivineWaterMob.AIMoveRandom(this));
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
    public void onLivingUpdate() {
    	super.onLivingUpdate();
        this.prevmobPitch = this.mobPitch;
        this.prevmobYaw = this.mobYaw;
        this.prevmobRotation = this.mobRotation;
        this.mobRotation += this.rotationVelocity;

        if ((double)this.mobRotation > (Math.PI * 2D))
        {
            if (this.world.isRemote)
            {
                this.mobRotation = ((float)Math.PI * 2F);
            }
            else
            {
                this.mobRotation = (float)((double)this.mobRotation - (Math.PI * 2D));

                if (this.rand.nextInt(10) == 0)
                {
                    this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
                }

                this.world.setEntityState(this, (byte)19);
            }
        }

        if (this.inWater)
        {
            if (this.mobRotation < (float)Math.PI)
            {
                float f = this.mobRotation / (float)Math.PI;

                if ((double)f > 0.75D)
                {
                    this.randomMotionSpeed = 1.0F;
                    this.rotateSpeed = 1.0F;
                }
                else
                {
                    this.rotateSpeed *= 0.8F;
                }
            }
            else
            {
                this.randomMotionSpeed *= 0.9F;
                this.rotateSpeed *= 0.99F;
            }

            if (!this.world.isRemote)
            {
                this.motionX = (double)(this.randomMotionVecX * this.randomMotionSpeed);
                this.motionY = (double)(this.randomMotionVecY * this.randomMotionSpeed);
                this.motionZ = (double)(this.randomMotionVecZ * this.randomMotionSpeed);
            }

            float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.renderYawOffset += (-((float)MathHelper.atan2(this.motionX, this.motionZ)) * (180F / (float)Math.PI) - this.renderYawOffset) * 0.1F;
            this.rotationYaw = this.renderYawOffset;
            this.mobYaw = (float)((double)this.mobYaw + Math.PI * (double)this.rotateSpeed * 1.5D);
            this.mobPitch += (-((float)MathHelper.atan2((double)f1, this.motionY)) * (180F / (float)Math.PI) - this.mobPitch) * 0.1F;
        }
        else
        {
            if (!this.world.isRemote)
            {
                this.motionX = 0.0D;
                this.motionZ = 0.0D;

                if (this.isPotionActive(MobEffects.LEVITATION))
                {
                    this.motionY += 0.05D * (double)(this.getActivePotionEffect(MobEffects.LEVITATION).getAmplifier() + 1) - this.motionY;
                }
                else if (!this.hasNoGravity())
                {
                    this.motionY -= 0.08D;
                }

                this.motionY *= 0.9800000190734863D;
            }

            this.mobPitch = (float)((double)this.mobPitch + (double)(-90.0F - this.mobPitch) * 0.02D);
        }
    }
    
    public static void registerFixesSquid(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityDivineWaterMob.class);
    }
    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    public boolean isInWater() {
        return this.world.getBlockState(new BlockPos((int) this.posX, MathHelper.floor(this.posY), (int) this.posZ))
                .getMaterial() == Material.WATER;
    }

    @Override
    public boolean isValidLightLevel() {
        return true;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && this.posY > 45.0D && this.posY < (double) this.world.getSeaLevel()
                && isInWater();
    }
    @Override
    protected boolean canDespawn()
    {
        return true;
    }
    public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn)
    {
        this.randomMotionVecX = randomMotionVecXIn;
        this.randomMotionVecY = randomMotionVecYIn;
        this.randomMotionVecZ = randomMotionVecZIn;
    }

    public boolean hasMovementVector()
    {
        return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
    }
    static class AIMoveRandom extends EntityAIBase
    {
        private final EntityDivineWaterMob mob;

        public AIMoveRandom(EntityDivineWaterMob mob)
        {
            this.mob = mob;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return true;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            int i = this.mob.getIdleTime();

            if (i > 100)
            {
                this.mob.setMovementVector(0.0F, 0.0F, 0.0F);
            }
            else if (this.mob.getRNG().nextInt(50) == 0 || !this.mob.inWater || !this.mob.hasMovementVector())
            {
                float f = this.mob.getRNG().nextFloat() * ((float)Math.PI * 2F);
                float f1 = MathHelper.cos(f) * 0.2F;
                float f2 = -0.1F + this.mob.getRNG().nextFloat() * 0.2F;
                float f3 = MathHelper.sin(f) * 0.2F;
                this.mob.setMovementVector(f1, f2, f3);
            }
        }
    }
}