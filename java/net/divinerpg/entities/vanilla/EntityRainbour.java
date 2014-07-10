package net.divinerpg.entities.vanilla;

import java.util.Calendar;

import net.divinerpg.api.entity.EntityDivineRPGFlying;
import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.api.entity.EntityPeacefullUntillAttacked;
import net.divinerpg.entities.vanilla.projectile.EntitySparklerFX;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityRainbour extends EntityPeacefullUntillAttacked {

	private ChunkCoordinates spawnPosition;

	public EntityRainbour(World par1World) {
		super(par1World);
		this.setSize(0.9F, 0.9F);
		this.setIsBatHanging(true);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.rainbourHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.rainbourDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.rainbourSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.rainbourFollowRange);
	}

	@Override
	protected void collideWithEntity(Entity par1Entity) {}

	@Override
	protected void collideWithNearbyEntities() {}

	public boolean getIsBatHanging() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	public void setIsBatHanging(boolean par1) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if(par1) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
		} else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -2)));
		}
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
			if(this.spawnPosition != null && (!this.worldObj.isAirBlock(this.spawnPosition.posX, this.spawnPosition.posY, this.spawnPosition.posZ) || this.spawnPosition.posY < 1)) {
				this.spawnPosition = null;
			}

			if(this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0F) {
				this.spawnPosition = new ChunkCoordinates((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
			}

			double d0 = (double)this.spawnPosition.posX + 0.5D - this.posX;
			double d1 = (double)this.spawnPosition.posY + 0.1D - this.posY;
			double d2 = (double)this.spawnPosition.posZ + 0.5D - this.posZ;
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
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.rainbour);
	}

	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.rainbourHurt);
	}

	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.rainbourHurt);
	}

	@Override
	protected void dropFewItems(boolean var1, int var2) {
		this.dropItem(VanillaItemsOther.healingStone, 1);
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

		if(!this.worldObj.isRemote && this.getIsBatHanging()) {
			this.setIsBatHanging(false);
		}
		return super.attackEntityFrom(par1DamageSource, par2);
	}

	@Override
	public boolean getCanSpawnHere() {
		int var1 = MathHelper.floor_double(this.boundingBox.minY);

		if(var1 >= 63) {
			return false;
		} else {
			int var2 = MathHelper.floor_double(this.posX);
			int var3 = MathHelper.floor_double(this.posZ);
			int var4 = this.worldObj.getBlockLightValue(var2, var1, var3);
			byte var5 = 4;
			Calendar var6 = this.worldObj.getCurrentDate();

			if((var6.get(2) + 1 != 10 || var6.get(5) < 20) && (var6.get(2) + 1 != 11 || var6.get(5) > 3)) {
				if(this.rand.nextBoolean()) {
					return false;
				}
			} else {
				var5 = 7;
			}
			return var4 > this.rand.nextInt(var5) ? false : super.getCanSpawnHere();
		}
	}

	@SideOnly(Side.CLIENT)
	public void onLivingUpdate() {
		super.onLivingUpdate();
		for(int var3 = 0; var3 < 8; ++var3) {
			EntitySparklerFX var20 = new EntitySparklerFX(this.worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
		}
	}

	@Override
	public String mobName() {
		return "Rainbour";
	}
}