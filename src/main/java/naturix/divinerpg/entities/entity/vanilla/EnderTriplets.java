package naturix.divinerpg.entities.entity.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EnderTriplets extends EntityMob implements IRangedAttackMob {

    public EnderTriplets(World worldIn) {
		super(worldIn);
		this.setSize(1.4F, 2f);
		this.setHealth(this.getMaxHealth());

	}
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/ender_triplets");

    @Override
    protected boolean canDespawn() {
        return true;
    }

    private ResourceLocation deathLootTable = LOOT;

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
    }

    protected void initEntityAI()
    {
    	this.tasks.addTask(2, new EnderTriplets.AIFireballAttack(this));
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(8, new EntityAIFollow(this, 1, 1, 1));
        this.applyEntityAI();
    }

    private void applyEntityAI() {
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[]{EntityPigZombie.class}));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 3;
    }

    @Override
    public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn) {
        super.setAttackTarget(entitylivingbaseIn);
        if (entitylivingbaseIn instanceof EntityPlayer) {
            
        }
    }

    @Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_GHAST_SCREAM;
	}

    @Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_GHAST_DEATH;
    }

    @Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;

	}
    private int explosionStrength = 1;

    public int getFireballStrength()
    {
        return this.explosionStrength;
    }
    static EnderTriplets parentEntity;
    static EntityPlayer player;

    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;
    	@Override
    	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor)
        {
    		if(target instanceof EntityPlayer) {
    			BlockPos targPos = target.getPosition();
//    			BlockPos parPos = parentEntity.getPosition();
    			EntityLargeFireball EntityLargeFireball = new EntityLargeFireball(world);
				world.spawnEntity(EntityLargeFireball);
		        this.setSize(1.0F, 1.0F);
		        this.setLocationAndAngles(target.posX, target.posY, target.posZ, target.rotationYaw, target.rotationPitch);
		        this.setPosition(this.posX, this.posY, this.posZ);
		        this.motionX = 0.0D;
		        this.motionY = 0.0D;
		        this.motionZ = 0.0D;
		        double accelX = targPos.getX();
		        double accelY = targPos.getY();
		        double accelZ = targPos.getZ();
		        accelX = accelX + this.rand.nextGaussian() * 0.4D;
		        accelY = accelY + this.rand.nextGaussian() * 0.4D;
		        accelZ = accelZ + this.rand.nextGaussian() * 0.4D;
		        double d0 = (double)MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
		        this.accelerationX = accelX / d0 * 0.1D;
		        this.accelerationY = accelY / d0 * 0.1D;
		        this.accelerationZ = accelZ / d0 * 0.1D;
		    }
        }

		@Override
		public void setSwingingArms(boolean swingingArms) {

		}
		static class AIFireballAttack extends EntityAIBase
	    {
	        private final EnderTriplets blaze;
	        private int attackStep;
	        private int attackTime;

	        public AIFireballAttack(EnderTriplets blazeIn)
	        {
	            this.blaze = blazeIn;
	            this.setMutexBits(3);
	        }

	        /**
	         * Returns whether the EntityAIBase should begin execution.
	         */
	        public boolean shouldExecute()
	        {
	            EntityLivingBase entitylivingbase = this.blaze.getAttackTarget();
	            return entitylivingbase != null && entitylivingbase.isEntityAlive();
	        }

	        /**
	         * Execute a one shot task or start executing a continuous task
	         */
	        public void startExecuting()
	        {
	            this.attackStep = 0;
	        }

	        /**
	         * Reset the task's internal state. Called when this task is interrupted by another one
	         */
	        public void resetTask()
	        {
	            this.blaze.setOnFire(false);
	        }

	        /**
	         * Keep ticking a continuous task that has already been started
	         */
	        public void updateTask()
	        {
	            --this.attackTime;
	            EntityLivingBase entitylivingbase = this.blaze.getAttackTarget();
	            double d0 = this.blaze.getDistanceSq(entitylivingbase);

	            if (d0 < 4.0D)
	            {
	                if (this.attackTime <= 0)
	                {
	                    this.attackTime = 20;
	                    this.blaze.attackEntityAsMob(entitylivingbase);
	                }

	                this.blaze.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
	            }
	            else if (d0 < this.getFollowDistance() * this.getFollowDistance())
	            {
	                double d1 = entitylivingbase.posX - this.blaze.posX;
	                double d2 = entitylivingbase.getEntityBoundingBox().minY + (double)(entitylivingbase.height / 2.0F) - (this.blaze.posY + (double)(this.blaze.height / 2.0F));
	                double d3 = entitylivingbase.posZ - this.blaze.posZ;

	                if (this.attackTime <= 0)
	                {
	                    ++this.attackStep;

	                    if (this.attackStep == 1)
	                    {
	                        this.attackTime = 60;
	                        this.blaze.setOnFire(true);
	                    }
	                    else if (this.attackStep <= 4)
	                    {
	                        this.attackTime = 6;
	                    }
	                    else
	                    {
	                        this.attackTime = 100;
	                        this.attackStep = 0;
	                        this.blaze.setOnFire(false);
	                    }

	                    if (this.attackStep > 1)
	                    {
	                        float f = MathHelper.sqrt(MathHelper.sqrt(d0)) * 0.5F;
	                        this.blaze.world.playEvent((EntityPlayer)null, 1018, new BlockPos((int)this.blaze.posX, (int)this.blaze.posY, (int)this.blaze.posZ), 0);

	                        for (int i = 0; i < 1; ++i)
	                        {
	                            EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.blaze.world, this.blaze, d1 + this.blaze.getRNG().nextGaussian() * (double)f, d2, d3 + this.blaze.getRNG().nextGaussian() * (double)f);
	                            entitysmallfireball.posY = this.blaze.posY + (double)(this.blaze.height / 2.0F) + 0.5D;
	                            this.blaze.world.spawnEntity(entitysmallfireball);
	                        }
	                    }
	                }

	                this.blaze.getLookHelper().setLookPositionWithEntity(entitylivingbase, 10.0F, 10.0F);
	            }
	            else
	            {
	                this.blaze.getNavigator().clearPath();
	                this.blaze.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
	            }

	            super.updateTask();
	        }

	        private double getFollowDistance()
	        {
	            IAttributeInstance iattributeinstance = this.blaze.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
	            return iattributeinstance == null ? 32.0D : iattributeinstance.getAttributeValue();
	        }
	    }
		private static final DataParameter<Byte> ON_FIRE = EntityDataManager.<Byte>createKey(EnderTriplets.class, DataSerializers.BYTE);

		public void setOnFire(boolean onFire)
	    {
			if(player instanceof EntityPlayer) {
				onFire = true;
			}else {
				onFire = false;
	    }
    }
}