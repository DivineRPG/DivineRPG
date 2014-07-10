package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityScorcher extends EntityDivineRPGMob {
	
	private float heightOffset = 0.5F;
	private int heightOffsetUpdateTime;
	private int anger;

	public EntityScorcher(World var1) {
		super(var1);
		this.isImmuneToFire = true;
		this.experienceValue = 20;
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.scorcherHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.scorcherDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.scorcherSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.scorcherFollowRange);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.scorcher);
	}

	@Override
	protected String getHurtSound() {
		return "mob.blaze.hit";
	}

	@Override
	protected String getDeathSound() {
		return "mob.blaze.death";
	}

	@Override
	public int getBrightnessForRender(float var1) {
		return 15728880;
	}

	@Override
	public float getBrightness(float var1) {
		return 1.0F;
	}

	@Override
	public void onLivingUpdate() {
		if (!this.worldObj.isRemote) {
			if (this.isWet()) {
				this.attackEntityFrom(DamageSource.drown, 1);
			}

			--this.heightOffsetUpdateTime;

			if (this.heightOffsetUpdateTime <= 0) {
				this.heightOffsetUpdateTime = 100;
				this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
			}

			if (this.getEntityToAttack() != null && this.getEntityToAttack().posY + (double)this.getEntityToAttack().getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset) {
				this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
			}
		}

		if (this.rand.nextInt(24) == 0) {
			this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "fire.fire", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
		}

		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}

		for (int var1 = 0; var1 < 2; ++var1) {
			this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		}

		super.onLivingUpdate();
	}

	@Override
	protected void attackEntity(Entity var1, float var2) {
		if (this.attackTime <= 0 && var2 < 2.0F && var1.boundingBox.maxY > this.boundingBox.minY && var1.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 0;
			this.attackEntityAsMob(var1);
		}
		else if (var2 < 30.0F) {
			double var3 = var1.posX - this.posX;
			double var5 = var1.boundingBox.minY + (double)(var1.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
			double var7 = var1.posZ - this.posZ;

			if (this.attackTime == 0) {
				++this.anger;

				if (this.anger == 1) {
					this.attackTime = 0;
					this.idk(true);
				}
				else if (this.anger <= 4) {
					this.attackTime = 6;
				} else {
					this.attackTime = 0;
					this.anger = 0;
					this.idk(false);
				}

				if (this.anger > 1) {
					float var9 = MathHelper.sqrt_float(var2) * 0.5F;
					this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

					for (int var10 = 0; var10 < 1; ++var10) {
						//TODO EntityPurpleFireball var11 = new EntityPurpleFireball(this.worldObj, this, var3 + this.rand.nextGaussian() * (double)var9, var5, var7 + this.rand.nextGaussian() * (double)var9);
						EntitySmallFireball var11 = new EntitySmallFireball(this.worldObj, this, var3 + this.rand.nextGaussian() * (double)var9, var5, var7 + this.rand.nextGaussian() * (double)var9);
						var11.posY = this.posY + (double)(this.height / 2.0F) + 1.5D;
						this.worldObj.spawnEntityInWorld(var11);
					}
				}
			}

			this.rotationYaw = (float)(Math.atan2(var7, var3) * 180.0D / Math.PI) - 90.0F;
			this.hasAttacked = true;
		}
	}

	@Override
	protected void fall(float var1) {}

	protected Item getDropItem() {
		return VanillaItemsOther.purpleBlaze;
	}

	@Override
	public boolean isBurning() {
		return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	@Override
	protected void dropFewItems(boolean var1, int var2) {
		int var3 = this.rand.nextInt(2 + var2);
		for (int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(VanillaItemsOther.purpleBlaze, 1);
		}
	}

	public void idk(boolean var1) {
		byte var2 = this.dataWatcher.getWatchableObjectByte(16);
		if(var1) {
			var2 = (byte)(var2 | 1);
		} else {
			var2 &= -2;
		}
		this.dataWatcher.updateObject(16, Byte.valueOf(var2));
	}

	@Override
	public String mobName() {
		return "Scorcher";
	}
}