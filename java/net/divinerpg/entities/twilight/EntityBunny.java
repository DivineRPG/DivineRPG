package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGTameable;
import net.divinerpg.api.entity.EntityStats;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityBunny extends EntityDivineRPGTameable {

	public EntityBunny(World var1) {
		super(var1);
		this.setSize(0.5F, 0.5F);
		this.experienceValue = 40;
	}

	public EntityBunny(World w, boolean tamed, String owner) {
		this(w);
		this.setTamed(tamed);
		this.func_152115_b(owner);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.bunnyHealth);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.bunnySpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.bunnyFollowRange);
	}

	@Override
	protected boolean canDespawn() {
		return !this.isTamed();
	}

	@Override
	public void onDeath(DamageSource var1) {
		super.onDeath(var1);
		if(!this.worldObj.isRemote && !this.isTamed() && !(this instanceof EntityAngryBunny)) {
			Entity var3 = var1.getEntity();
			if(var3 instanceof EntityPlayer) {
				((EntityPlayer)var3).addStat(DivineRPGAchievements.friendOrFoe, 1);
			}
			this.transform(false, var3);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		double i = EntityStats.bunnyDamage;
		if(this.isTamed()) {
			this.transform(true, par1Entity);
			return false;
		}
		return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
	}

	private void transform(boolean tamed, Entity var3)  {
		if(!this.worldObj.isRemote) {
			EntityAngryBunny var2 = new EntityAngryBunny(this.worldObj, tamed, this.func_152113_b());
			var2.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			this.worldObj.spawnEntityInWorld(var2);
			if(var3 instanceof EntityLiving) 
				var2.setAttackTarget((EntityLiving) var3);
			this.setDead();
		}
	}

	@Override
	public boolean interact(EntityPlayer var1) {
		ItemStack var2 = var1.inventory.getCurrentItem();

		if(this.isTamed()) {
			if(var2 != null && var2.getItem() instanceof ItemFood) {
				ItemFood var3 = (ItemFood)var2.getItem();

				if(var3.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectInt(18) < 20) {
					if(!var1.capabilities.isCreativeMode) {
						--var2.stackSize;
					}
					this.heal((float)var3.func_150905_g(var2));
					if(var2.stackSize <= 0) {
						var1.inventory.setInventorySlotContents(var1.inventory.currentItem, (ItemStack)null);
					}
					return true;
				}
			}
			if(var1.getDisplayName().equalsIgnoreCase(this.func_152113_b()) && !this.worldObj.isRemote) {
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity)null);
			}
		}
		else if(var2 != null && var2.getItem() == TwilightItemsOther.edenSparkles) {
			if(!var1.capabilities.isCreativeMode) {
				--var2.stackSize;
			}

			if(var2.stackSize <= 0) {
				var1.inventory.setInventorySlotContents(var1.inventory.currentItem, (ItemStack)null);
			}

			if(!this.worldObj.isRemote) {
				if(this.rand.nextInt(3) == 0) {
					this.setTamed(true);
					this.setPathToEntity((PathEntity)null);
					this.setAttackTarget((EntityLiving)null);
					this.aiSit.setSitting(true);
					this.setHealth(20);
					this.func_152115_b(var1.getDisplayName());
					this.playTameEffect(true);
					this.worldObj.setEntityState(this, (byte)7);
				} else {
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte)6);
				}
			}
			return true;
		}
		return super.interact(var1);
	}

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.bunny);
	}

	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.bunnyHurt);
	}

	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.bunnyHurt);
	}

	@Override
	public String mobName() {
		return "Bunny";
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}
}