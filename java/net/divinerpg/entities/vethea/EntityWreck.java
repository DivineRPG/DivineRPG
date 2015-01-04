package net.divinerpg.entities.vethea;

import java.util.List;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.api.entity.EntityStats;
import net.divinerpg.entities.vethea.projectile.EntityBouncingProjectile;
import net.divinerpg.entities.vethea.projectile.EntityVetheanCannonShot;
import net.divinerpg.entities.vethea.projectile.EntityWreckExplosiveShot;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityWreck extends EntityDivineRPGBoss {
	
	public int ability;
	private final int MELEE = 0, ARCANA = 1, RANGED = 2;
	private final int DEFAULT = 0, CHARGE = 1, PULL = 2, FIRE = 3, BOUNCE = 4, FREEZE = 5, SPEED = 6, EXPLOSIONS = 7, STRENGTH = 8;
	private int waitTick;
	private int abilityCoolDown;
	private EntityAIBase meleeAI = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0F, false);
	private int deathTicks;

	public EntityWreck(World par1) {
		super(par1);
		this.tasks.addTask(2, meleeAI);
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 0));
		ability = DEFAULT;
		if(!this.worldObj.isRemote){
			Util.sendMessageToAll("Wreck: You should run while you still have the chance to live.");
			Util.sendMessageToAll("I do love the smell of death!");
		}
		this.playSound(Sounds.wreckIntro.getPrefixedName(), 1.0F, 1.0F);
		this.setAbilityType(MELEE);
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.wreckHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.wreckDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.wreckSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.wreckFollowRange);
	}
	
	@Override
	public void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(17, MELEE);
	}

	@Override
	protected void updateAITasks() {
		this.manageAbilities();
		super.updateAITasks();
	}

	public void manageAbilities() {
		EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);
		if (getHealth() < 5000 / 3) {
			this.setAbilityType(RANGED);
			this.tasks.removeTask(meleeAI);
		}
		else if (getHealth() < 5000 * 2 / 3 && getHealth() > 5000 / 3) {
			this.setAbilityType(ARCANA);
		}
		
		if (abilityCoolDown > 0) {
			abilityCoolDown--;
		}
		
		if((this.getAbilityType() == 1 && (ability == CHARGE || ability == PULL)) || (this.getAbilityType() == 2 && (ability == FIRE || ability == BOUNCE || ability == FREEZE))) ability = DEFAULT;
		
		if (ability == DEFAULT && abilityCoolDown == 0) {
			abilityCoolDown = 200;
			switch (this.getAbilityType()) {
			case MELEE:
				switch(this.rand.nextInt(2)) {
				case 0:
					ability = PULL;
					this.setAIMoveSpeed((float)EntityStats.wreckSpeed);
					this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(EntityStats.wreckSpeed);
					break;
				case 1:
					ability = CHARGE;
					this.setAIMoveSpeed((float)EntityStats.wreckSpeedFast);
					break;
				default: 
					break;
				}
				break;
			case ARCANA:
				switch(this.rand.nextInt(3)) {
				case 0:
					ability = FIRE;
					break;
				case 1:
					ability = BOUNCE;
					break;
				case 2:
					ability = FREEZE;
					break;
				default: 
					break;
				}
				break;
			case RANGED:
				switch(this.rand.nextInt(3)) {
				case 0:
					ability = SPEED;
					break;
				case 1:
					ability = EXPLOSIONS;
					break;
				case 2:
					ability = STRENGTH;
					break;
				default: 
					break;
				}
				break;
			default: 
				break;
			}

			this.message();
		}
				
		if (ability == PULL) {
			EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);
			if (var1 == null || var1.getDistanceToEntity(this) > 64) return;
			else var1.addVelocity(Math.signum(this.posX - var1.posX) * 0.069, 0, Math.signum(this.posZ - var1.posZ) * 0.069);
		}

		if(ability == FIRE) {
			if (player != null) {
				for (int i = 1; i < 20; ++i) {
					int var2 = (int) (((this.posX - player.posX)) * i)/5;
					int var3 = (int) (((this.posZ - player.posZ)) * i)/5;
					if(this.worldObj.getBlock((int)this.posX - var2, (int)this.posY, (int)this.posZ - var3) == Blocks.air)this.worldObj.setBlock((int)this.posX - var2, (int)this.posY, (int)this.posZ - var3, Blocks.fire);
				}
				ability = DEFAULT;
			}
		}
		if(ability == FREEZE) {
			if (player != null) {
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 5));
				ability = DEFAULT;
				abilityCoolDown = 100;
			}
		}
		this.attackEntityWithRangedAttack(player);
	}

	private void message() {
		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(64.0D, 64.0D, 64.0D));
		for (int var1 = 0; var1 < list.size(); ++var1) {
			if (list.get(var1) instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) list.get(var1);
				switch (ability) {
				case CHARGE:
					Util.sendMessageToAll("Wreck: CHARRGEE!");
					break;
				case PULL:
					this.playSound(Sounds.feelSoulArksiane.getPrefixedName(), 1.0F, 1.0F);
					if(!this.worldObj.isRemote)
						Util.sendMessageToAll("Wreck: Come Feel the Soul of Arksiane.");
					break;
				case FIRE:
					Util.sendMessageToAll("Wreck: Arksiane, give me fire!");
					break;
				case FREEZE:
					this.playSound(Sounds.stopAtOnce.getPrefixedName(), 1.0F, 1.0F);
					if(!this.worldObj.isRemote){
						Util.sendMessageToAll("Wreck: Stop at once in the name of the great Arksiane!");
					}
					break;
				case SPEED:
					this.playSound(Sounds.wreckSpeed.getPrefixedName(), 1.0F, 1.0F);
					if(!this.worldObj.isRemote)
						Util.sendMessageToAll("Wreck: Speed!");
					break;
				case EXPLOSIONS:
					this.playSound(Sounds.explosions.getPrefixedName(), 1.0F, 1.0F);
					if(!this.worldObj.isRemote)
						Util.sendMessageToAll("Wreck: Explosions!");
					break;
				case STRENGTH:
					this.playSound(Sounds.wreckStrength.getPrefixedName(), 1.0F, 1.0F);
					if(!this.worldObj.isRemote)
						Util.sendMessageToAll("Wreck: Strength!");
					break;
				default:
					break;
				}
			}
		}


	}

	@Override
	protected float getSoundVolume() {
		return 0.7F;
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		int var2 = 0;

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
			//((EntityLiving) par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, 16 * 5, 1));
		}

		boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);

		if (var4) {
			if (ability == PULL) {
				ability = DEFAULT;
				this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
				this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
				var3 = 2;
			}
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

	public void attackEntityWithRangedAttack(EntityLivingBase entity) {
		if(entity == null)return;
		switch(ability) {
			case BOUNCE:
				EntityBouncingProjectile projectile = new EntityBouncingProjectile(this.worldObj, this, 30);
				this.worldObj.spawnEntityInWorld(projectile);
				ability = DEFAULT;
			break;
			case SPEED:
				if(this.abilityCoolDown%5 == 0) {
					EntityVetheanCannonShot shot = new EntityVetheanCannonShot(this.worldObj, this, 15);
					this.worldObj.spawnEntityInWorld(shot);
				}
                if (this.abilityCoolDown == 100) {
                    ability = DEFAULT;
                }
                break;
            case EXPLOSIONS:
                if ((this.abilityCoolDown % 40) == 0) {
                    EntityWreckExplosiveShot shot = new EntityWreckExplosiveShot(this.worldObj, this);
                    this.worldObj.spawnEntityInWorld(shot);
                }
                if(this.abilityCoolDown==0)ability = DEFAULT;
                break;
            case STRENGTH:
                if ((this.abilityCoolDown % 40) == 0) {
                	EntityVetheanCannonShot var4 = new EntityVetheanCannonShot(this.worldObj, this, 40);
                    this.worldObj.spawnEntityInWorld(var4);
                }
                if(this.abilityCoolDown==0)ability = DEFAULT;
                break;
		default:
			break;
		}
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(VetheaItems.arksianeLump, 25);
	}

	@Override
	protected void onDeathUpdate() {
		++this.deathTicks;

		if (this.deathTicks >= 180 && this.deathTicks <= 200) {
			float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.worldObj.spawnParticle("hugeexplosion", this.posX + var1, this.posY + 2.0D + var2, this.posZ + var3, 0.0D, 0.0D, 0.0D);
		}

		int var4;
		int var5;

		if (!this.worldObj.isRemote) {
			if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
				var4 = 1000;

				while (var4 > 0) {
					var5 = EntityXPOrb.getXPSplit(var4);
					var4 -= var5;
					this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
				}
			}

			if (this.deathTicks == 1) {
				this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
			}
		}

		this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
		this.renderYawOffset = this.rotationYaw += 20.0F;

		if (this.deathTicks == 200 && !this.worldObj.isRemote) {
			var4 = 2000;

			while (var4 > 0) {
				var5 = EntityXPOrb.getXPSplit(var4);
				var4 -= var5;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
			}
			this.setDead();
		}
	}
	
	public int getAbilityType() {
		return this.dataWatcher.getWatchableObjectInt(17);
	}
	
	public void setAbilityType(int type) {
		this.dataWatcher.updateObject(17, type);
	}

	@Override
	public String mobName() {
		return "Wreck";
	}

	@Override
	public String name() {
		return "Wreck";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}