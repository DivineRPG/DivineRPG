package divinerpg.objects.entities.entity;

import divinerpg.objects.entities.ai.AISubmerge;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.init.MobEffects;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class EntityDivineWaterMob extends EntityPeacefulUntilAttacked {
	     public float mobPitch;
	     public float prevmobPitch;
	     public float mobYaw;
	     public float prevmobYaw;
	     public float mobRotation;
	     public float prevmobRotation;
	     public float randomMotionSpeed;
	     private float rotationVelocity;
	     private float rotateSpeed;
	     private float randomMotionVecX;
	     private float randomMotionVecY;
	     private float randomMotionVecZ;

	     public EntityDivineWaterMob(World worldIn)
	     {
	         super(worldIn);
	         this.setSize(0.8F, 0.8F);
	         this.rand.setSeed((long)(1 + this.getEntityId()));
	         this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
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
	     public static void registerFixesmob(DataFixer fixer)
	     {
	         EntityLiving.registerFixesMob(fixer, EntityDivineWaterMob.class);
	     }

	     protected void initEntityAI()
	     {
	         this.tasks.addTask(0, new EntityDivineWaterMob.AIMoveRandom(this));
	         this.tasks.addTask(1, new AISubmerge(this));
	         this.tasks.addTask(1, new EntityAIWander(this, 0.1D));
	     }

	     protected void applyEntityAttributes()
	     {
	         super.applyEntityAttributes();
	         this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
	     }

	     public float getEyeHeight()
	     {
	         return this.height * 0.5F;
	     }

	     public void onLivingUpdate()
	     {
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

	     public void travel(float strafe, float vertical, float forward)
	     {
	         this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	     }

	     /**
	      * Checks if the entity's current position is a valid location to spawn this entity.
	      */
	     public boolean getCanSpawnHere()
	     {
	         return this.posY > 45.0D && this.posY < (double)this.world.getSeaLevel() && super.getCanSpawnHere();
	     }

	     /**
	      * Handler for {@link World#setEntityState}
	      */
	     @SideOnly(Side.CLIENT)
	     public void handleStatusUpdate(byte id)
	     {
	         if (id == 19)
	         {
	             this.mobRotation = 0.0F;
	         }
	         else
	         {
	             super.handleStatusUpdate(id);
	         }
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

	             public AIMoveRandom(EntityDivineWaterMob p_i45859_1_)
	             {
	                 this.mob = p_i45859_1_;
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