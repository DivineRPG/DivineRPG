package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGTameable;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.IMob;
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

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.bunnyHealth);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.bunnySpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.bunnyFollowRange);
	}

	@Override
	protected boolean canDespawn() {
		return !this.isTamed();
	}

	@Override
	public void onDeath(DamageSource var1) {
		super.onDeath(var1);
		if(!this.worldObj.isRemote && !this.isTamed()) {
			Entity var3 = var1.getEntity();
			if(var3 instanceof EntityPlayer) {
				((EntityPlayer)var3).addStat(DivineRPGAchievements.friendOrFoe, 1);
			}
			this.transform(false, var3);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity target) {
		double i = EntityStats.bunnyDamage;
		if(this.isTamed()) {
			this.transform(true, target);
			return false;
		}
		return target.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
	}

	private void transform(boolean tamed, Entity target)  {
		if(!this.worldObj.isRemote) {
			EntityAngryBunny bunny = new EntityAngryBunny(this.worldObj, target);
			bunny.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			this.worldObj.spawnEntityInWorld(bunny);
			if(target instanceof EntityLiving) 
				bunny.setAttackTarget((EntityLiving) target);
			this.setDead();
		}
	}

	@Override
	public boolean interact(EntityPlayer player) {
		ItemStack stack = player.inventory.getCurrentItem();

		if(this.isTamed()) {
			if(stack != null && stack.getItem() instanceof ItemFood) {
				ItemFood food = (ItemFood)stack.getItem();

				//Crashes when getting dataWatcher
				/*if(food.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 20.0F) {
					if(!player.capabilities.isCreativeMode) {
						--stack.stackSize;
					}
					this.heal((float)food.getHealAmount(stack));
					if(stack.stackSize <= 0) {
						player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
					}
					return true;
				}*/
			}
			//It's not even going in this function
			if(player.getDisplayName().equalsIgnoreCase(this.func_152113_b()) && !this.worldObj.isRemote) {
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity)null);
			}
		}
		else if(stack != null && stack.getItem() == TwilightItemsOther.edenSparkles) {
			if(!player.capabilities.isCreativeMode) {
				--stack.stackSize;
			}

			if(stack.stackSize <= 0) {
				player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
			}

			if(!this.worldObj.isRemote) {
				if(this.rand.nextInt(3) == 0) {
					this.setTamed(true);
					this.setPathToEntity((PathEntity)null);
					this.setAttackTarget((EntityLiving)null);
					this.aiSit.setSitting(true);
					this.setHealth(20);
					this.func_152115_b(player.getUniqueID().toString());
					this.playTameEffect(true);
					this.worldObj.setEntityState(this, (byte)7);
				} else {
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte)6);
				}
			}
			return true;
		}
		return super.interact(player);
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
	protected void dropFewItems(boolean beenHit, int lootingLevel) {
		if(this.rand.nextInt(2) == 0) this.dropItem(TwilightItemsOther.edenSoul, 1+lootingLevel);
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