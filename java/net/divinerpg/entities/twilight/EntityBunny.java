package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGTameable;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
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
	
	@Override
	public void entityInit() {
	    super.entityInit();
	    this.dataWatcher.addObject(19, 0);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		if(!this.isTamed())this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.bunnyHealth);
		else this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
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
			this.transform();
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity target) {
		double i = EntityStats.bunnyDamage;
		if(this.isTamed()) {
			this.dataWatcher.updateObject(19, 1);
		}
		return target.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
	}
	
	@Override
	public void onUpdate() {
	    super.onUpdate();
	    if(!this.worldObj.isRemote) {
	        if(this.isTamed() && this.getAttackTarget() == null) this.dataWatcher.updateObject(19, 0);
	    }
	}

	private void transform()  {
		if(!this.worldObj.isRemote) {
			EntityAngryBunny e = new EntityAngryBunny(this.worldObj);
			e.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			this.worldObj.spawnEntityInWorld(e);
			this.setDead();
		}
	}

	@Override
	public boolean interact(EntityPlayer player) {
		ItemStack held = player.inventory.getCurrentItem();

		if(this.isTamed()) {
			if(held != null && held.getItem() instanceof ItemFood) {
				ItemFood food = (ItemFood)held.getItem();

				if(food.isWolfsFavoriteMeat() && this.getHealth() < 20) {
					if(!player.capabilities.isCreativeMode) {
						--held.stackSize;
					}
					this.heal((float)food.func_150905_g(held));
					if(held.stackSize <= 0) {
						player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
					}
					return true;
				}
			}
			if(player.getUniqueID().toString().equals(this.func_152113_b()) && !this.worldObj.isRemote) {
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity)null);
			}
		}
		else if(held != null && held.getItem() == TwilightItemsOther.edenSparkles) {
			if(!player.capabilities.isCreativeMode) {
				--held.stackSize;
			}

			if(held.stackSize <= 0) {
				player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
			}

			if(!this.worldObj.isRemote) {
				if(this.rand.nextInt(3) == 0) {
					this.setTamed(true);
					this.setPathToEntity((PathEntity)null);
					this.setAttackTarget((EntityLiving)null);
					this.aiSit.setSitting(true);
					this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
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
	
	@Override
	public EntityLivingBase getAttackTarget() {
	    EntityLivingBase e = super.getAttackTarget();
	    if(e != null && ((this.isTamed() && this.getDistanceSqToEntity(e) < 144) || !this.isTamed())) return e;
	    return null;
	}
}