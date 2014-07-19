package net.divinerpg.entities.arcana;

import java.util.Calendar;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.api.entity.EntityDivineRPGTameable;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityParatiku extends EntityDivineRPGTameable {

	private ChunkCoordinates currentFlightTarget;
	public EntityParatiku(World par1World) {
		super(par1World);
		this.setSize(0.9F, 0.9F);
		this.setIsBatHanging(true);
		//this.tasks.addTask(4, new EntityAIParatikuFollowOwner(this, (float) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue(), 10.0F, 2.0F));
		addBasicAI();
		// this.targetTasks.addTask(1, new EntityAIParatikuOwnerHurtByTarget(this));
		//this.targetTasks.addTask(2, new EntityAIParatikuOwnerHurtTarget(this));
	}
	
	public EntityParatiku(World w, EntityPlayer p) {
		this(w);
		setTamed(true);
		func_152115_b(p.getDisplayName());
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.paratikuHealth);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.paratikuSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.paratikuFollowRange);
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		int var2 = 9;

		if (this.isPotionActive(Potion.damageBoost)) {
			var2 += 3 << this.getActivePotionEffect(Potion.damageBoost).getAmplifier();
		}

		if (this.isPotionActive(Potion.weakness)) {
			var2 -= 2 << this.getActivePotionEffect(Potion.weakness).getAmplifier();
		}

		int var3 = 0;

		if (par1Entity instanceof EntityLiving) {
			var2 += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLiving)par1Entity);
			var3 += EnchantmentHelper.getKnockbackModifier(this, (EntityLiving)par1Entity);
		}

		boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);

		if (var4) {
			if (var3 > 0) {
				par1Entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * var3 * 0.5F, 0.1D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * var3 * 0.5F);
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}

			int var5 = EnchantmentHelper.getFireAspectModifier(this);

			if (var5 > 0) {
				par1Entity.setFire(var5 * 4);
			}
		}

		return var4;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);

		if (this.func_152113_b() == null) {
			par1NBTTagCompound.setString("Owner", "");
		} else {
			par1NBTTagCompound.setString("Owner", this.func_152113_b());
		}

		par1NBTTagCompound.setBoolean("Sitting", this.isSitting());
		par1NBTTagCompound.setByte("BatFlags", this.dataWatcher.getWatchableObjectByte(16));
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		String var2 = par1NBTTagCompound.getString("Owner");

		if (var2.length() > 0) {
			this.func_152115_b(var2);
			this.setTamed(true);
		}

		this.dataWatcher.updateObject(16, Byte.valueOf(par1NBTTagCompound.getByte("BatFlags")));
	}

	protected void playTameEffect(boolean par1) {
		String var2 = "heart";

		if (!par1) {
			var2 = "smoke";
		}

		for (int var3 = 0; var3 < 7; ++var3) {
			double var4 = this.rand.nextGaussian() * 0.02D;
			double var6 = this.rand.nextGaussian() * 0.02D;
			double var8 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle(var2, this.posX + this.rand.nextFloat() * this.width * 2.0F - this.width, this.posY + 0.5D + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0F - this.width, var4, var6, var8);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte par1) {
		if (par1 == 7) {
			this.playTameEffect(true);
		}
		else if (par1 == 6) {
			this.playTameEffect(false);
		} else {
			super.handleHealthUpdate(par1);
		}
	}

	public EntityLivingBase getOwner() {
		return this.worldObj.getPlayerEntityByName(this.func_152113_b());
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
	protected String getLivingSound() {
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
	protected void collideWithEntity(Entity par1Entity) {}

	public boolean getIsBatHanging() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	public void setIsBatHanging(boolean par1) {
		byte var2 = this.dataWatcher.getWatchableObjectByte(16);

		if (par1) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 1)));
		} else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -2)));
		}
	}
 
	@Override
	public void onUpdate() {
		super.onUpdate();

		if (this.getIsBatHanging()) {
			this.motionX = this.motionY = this.motionZ = 0.0D;
			this.posY = MathHelper.floor_double(this.posY) + 1.0D - this.height;
		} else {
			this.motionY *= 0.6000000238418579D;
		}
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();

		if (this.getAttackTarget() != null) {
			int var1 = (int) this.getAttackTarget().posX;
			int var2 = (int) this.getAttackTarget().posY;
			int var3 = (int) this.getAttackTarget().posZ;
			this.currentFlightTarget = new ChunkCoordinates(var1, var2, var3);
		}
		else if (this.getOwner() != null) {
			this.currentFlightTarget = this.worldObj.getPlayerEntityByName(this.func_152113_b()).getPlayerCoordinates();
		} else {
			if (this.rand.nextInt(200) == 0) {
				this.rotationYawHead = this.rand.nextInt(360);
			}

			if (this.worldObj.getClosestPlayerToEntity(this, 4.0D) != null) {
				this.setIsBatHanging(false);
				this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1015, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
			}
		}

		if (this.currentFlightTarget != null) {
			double var1 = this.currentFlightTarget.posX - this.posX;
			double var3 = this.currentFlightTarget.posY - this.posY;
			double var5 = this.currentFlightTarget.posZ - this.posZ;

			if (Math.signum(var1) != 0 || Math.signum(var3) != 0 || Math.signum(var5) != 0) {
				this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.10000000149011612D;
				this.motionY += (Math.signum(var3) * 1.699999988079071D - this.motionY) * 0.10000000149011612D;
				this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.10000000149011612D;
				float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
				float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
				this.moveForward = 0.5F;
				this.rotationYaw += var8;
			}
		}
	}
 
	@Override
	protected void fall(float par1) {}
 
	@Override
	protected void updateFallState(double par1, boolean par3) {}

	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if (this.isEntityInvulnerable())
			return false;
		else if (!this.worldObj.isRemote && this.getIsBatHanging()) {
			this.setIsBatHanging(false);
		}

		return super.attackEntityFrom(par1DamageSource, par2);
	}

	@Override
	public String mobName() {
		return "Paratiku";
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}
}