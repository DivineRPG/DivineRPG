package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityJungleBat extends EntityDivineRPGMob {

	private ChunkCoordinates currentFlightTarget;

	public EntityJungleBat(World par1World) {
		super(par1World);
		this.setSize(0.5F, 0.9F);
		this.setIsBatHanging(true);
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.jungleBatHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.jungleBatDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.jungleBatSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.jungleBatFollowRange);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	@Override
	protected float getSoundVolume() {
		return 0.1F;
	}

	@Override
	protected float getSoundPitch() {
		return super.getSoundPitch() * 0.95F;
	}

	@Override
	protected String getLivingSound()  {
		return this.getIsBatHanging() && this.rand.nextInt(4) != 0 ? null : "mob.bat.idle";
	}

	@Override
	protected String getHurtSound() {
		return "mob.bat.hurt";
	}

	@Override
	protected String getDeathSound() {
		return "mob.bat.death";
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	protected void collideWithEntity(Entity par1Entity) {}

	public boolean getIsBatHanging() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	public void setIsBatHanging(boolean par1) {
		byte var2 = this.dataWatcher.getWatchableObjectByte(16);
		if(par1) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 1)));
		} else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -2)));
		}
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if(this.getIsBatHanging()) {
			this.motionX = this.motionY = this.motionZ = 0.0D;
			this.posY = (double)MathHelper.floor_double(this.posY) + 1.0D - (double)this.height;
		} else {
			this.motionY *= 0.6000000238418579D;
		}
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();

		if(this.getIsBatHanging()) {
			if(!this.worldObj.getBlock(MathHelper.floor_double(this.posX), (int)this.posY + 1, MathHelper.floor_double(this.posZ)).isNormalCube()) {
				this.setIsBatHanging(false);
				this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1015, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
			} else {
				if(this.rand.nextInt(200) == 0) {
					this.rotationYawHead = (float)this.rand.nextInt(360);
				}

				if(this.worldObj.getClosestPlayerToEntity(this, 4.0D) != null) {
					this.setIsBatHanging(false);
					this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1015, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
				}
			}
		} else {
			if(this.currentFlightTarget != null && (!this.worldObj.isAirBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ) || this.currentFlightTarget.posY < 1)) {
				this.currentFlightTarget = null;
			}

			if(this.currentFlightTarget == null || this.rand.nextInt(30) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0F) {
				this.currentFlightTarget = new ChunkCoordinates((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
			}

			double d0 = (double)this.currentFlightTarget.posX + 0.5D - this.posX;
			double d1 = (double)this.currentFlightTarget.posY + 0.1D - this.posY;
			double d2 = (double)this.currentFlightTarget.posZ + 0.5D - this.posZ;
			this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
			this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
			this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
			float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
			float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
			this.moveForward = 0.5F;
			this.rotationYaw += f1;

			if(this.rand.nextInt(100) == 0 && this.worldObj.getBlock(MathHelper.floor_double(this.posX), (int)this.posY + 1, MathHelper.floor_double(this.posZ)).isNormalCube()) {
				this.setIsBatHanging(true);
			}
		}
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void fall(float par1) {}

	@Override
	protected void updateFallState(double par1, boolean par3) {}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return true;
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if(!this.worldObj.isRemote && this.getIsBatHanging()) 
			this.setIsBatHanging(false);

		return super.attackEntityFrom(par1DamageSource, par2);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.dataWatcher.updateObject(16, Byte.valueOf(par1NBTTagCompound.getByte("BatFlags")));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("BatFlags", this.dataWatcher.getWatchableObjectByte(16));
	}

	@Override
	protected Item getDropItem() {
		return VanillaItemsOther.jungleShards;
	}

	@Override
	public String mobName() {
		return "Jungle Bat";
	}
}