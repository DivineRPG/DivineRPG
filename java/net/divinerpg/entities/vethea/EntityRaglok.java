package net.divinerpg.entities.vethea;

import java.util.List;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.api.entity.EntityStats;
import net.divinerpg.entities.vethea.projectile.EntityRaglokBomb;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityRaglok extends EntityDivineRPGBoss implements IRangedAttackMob {

	private static int ability;
	private final int DEFAULT = 0, LIGHTNING = 1, BLIND = 2, BOMBS = 3, SLOW = 4;

	private int abilityCoolDown;

	private EntityAIBase meleeAI;
	private EntityAIBase rangedAI = new EntityAIArrowAttack(this, 0.25F, 20, 64.0F);
	private int rangedAttackCounter;
	private int deathTicks;

	public EntityRaglok(World par1) {
		super(par1);
		meleeAI = new EntityAIAttackOnCollide(this, EntityPlayer.class, this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue(), false);
		meleeAI.setMutexBits(2);
		rangedAI.setMutexBits(2);
		this.tasks.addTask(2, meleeAI);
		this.tasks.addTask(2, rangedAI);
		addAttackingAI();
		this.isImmuneToFire = true;
		ability = DEFAULT;
		this.setSize(1.5F, 4.0F);
		if(!this.worldObj.isRemote)
			Util.sendMessageToAll("Raglok: You dare wake me from my slumber?!");
		this.playSound(Sounds.raglokAwaken.getPrefixedName(), 1.0F, 1.0F);
	}

	@Override
	protected void updateAITasks() {
		this.manageAbilities();
		super.updateAITasks();
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.raglokHealth);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.raglokDamage);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.raglokSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.raglokFollowRange);
	}

	public void manageAbilities() {
		EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);
		if (ability == DEFAULT && abilityCoolDown == 0) {
			abilityCoolDown = 40;
			switch(this.rand.nextInt(4)) {
			case 0:
				ability = LIGHTNING;
				this.rangedAttackCounter = 100;
				this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0);
				break;
			case 1:
				ability = BLIND;
				this.rangedAttackCounter = -1;
				break;
			case 2:
				ability = BOMBS;
				this.rangedAttackCounter = 100;
				break;
			case 3:
				ability = SLOW;
				this.rangedAttackCounter = -1;
				break;
			default: break;
			}
			this.message();
		}
		else if (ability == DEFAULT && abilityCoolDown > 0) {
			abilityCoolDown--;
		}
		else if (ability != 0 && abilityCoolDown == 0) {
			abilityCoolDown = 40;
		}

		if(ability == BLIND) {
			if (var1 != null) {
				var1.addPotionEffect(new PotionEffect(Potion.blindness.id, 1, 0));
				this.rangedAttackCounter--;
			}

			if (this.rangedAttackCounter == -200) {
				ability = DEFAULT;
				this.rangedAttackCounter = -1;
			}
		}
		if(ability == SLOW) {
			if (var1 != null) {
				var1.addPotionEffect(new PotionEffect(Potion.blindness.id, 1, 0));
				this.rangedAttackCounter--;
			}

			if (this.rangedAttackCounter == -100) {
				ability = DEFAULT;
				this.rangedAttackCounter = -1;
			}
		}
	}

	private void message() {
		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(64.0D, 64.0D, 64.0D));
		for (int var1 = 0; var1 < list.size(); ++var1) {
			if (list.get(var1) instanceof EntityPlayer) {
				EntityPlayer var2 = (EntityPlayer) list.get(var1);
				switch (ability) {
				case LIGHTNING:
					this.playSound(Sounds.raglokGuardian.getPrefixedName(), 1.0F, 1.0F);
					if(!this.worldObj.isRemote){
						Util.sendMessageToAll("Raglok: You think you can fight me?");
						Util.sendMessageToAll("Raglok: I am the great guardian of Heliosis!");
					}
					break;
				case BLIND:
					this.playSound(Sounds.raglokDark.getPrefixedName(), 1.0F, 1.0F);
					if(!this.worldObj.isRemote)
						Util.sendMessageToAll("Raglok: Your future is dark.");
					break;
				case BOMBS:
					this.playSound(Sounds.raglokRain.getPrefixedName(), 1.0F, 1.0F);
					if(!this.worldObj.isRemote){
						Util.sendMessageToAll("Raglok: Rain rain come my way");
						Util.sendMessageToAll("Raglok: Kill this human, kill him today!");
					}
					break;
				case SLOW:
					this.playSound(Sounds.raglokNothing.getPrefixedName(), 1.0F, 1.0F); 
					if(!this.worldObj.isRemote)
						Util.sendMessageToAll("Raglok: You're nothing compared to me! Nothing!");
					break;
				default:
					break;
				}
			}
		}
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Integer(100));
	}

	@Override
	protected float getSoundVolume() {
		return 0.7F;
	}

	@Override
	protected String getDeathSound() {
		if(!this.worldObj.isRemote)
			Util.sendMessageToAll("Raglok: Heliosis! Avenge me!");
		return Sounds.raglokAvenge.getPrefixedName();
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		int var2 = (int)EntityStats.raglokDamage;

		if (this.isPotionActive(Potion.damageBoost)) 
			var2 += 3 << this.getActivePotionEffect(Potion.damageBoost).getAmplifier();

		if (this.isPotionActive(Potion.weakness)) 
			var2 -= 2 << this.getActivePotionEffect(Potion.weakness).getAmplifier();      

		int var3 = 0;

		if (par1Entity instanceof EntityLiving) {
			var2 += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLiving)par1Entity);
			var3 += EnchantmentHelper.getKnockbackModifier(this, (EntityLiving)par1Entity);
			((EntityLiving) par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, 16 * 5, 1));
		}

		boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
		if (var4) {
			if (ability == SLOW)
				var3 = 5;          
			if (var3 > 0) {
				par1Entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * var3 * 0.5F, 0.1D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * var3 * 0.5F);
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}
			int var5 = EnchantmentHelper.getFireAspectModifier(this);
			if (var5 > 0) 
				par1Entity.setFire(var5 * 4);            
		}
		return var4;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase par1, float par2)  {
		switch(ability) {
		case LIGHTNING:
			this.worldObj.spawnEntityInWorld(new EntityLightningBolt(this.worldObj, par1.lastTickPosX, par1.lastTickPosY, par1.lastTickPosZ));
			this.rangedAttackCounter++;
			if (this.rangedAttackCounter == 10) {
				ability = DEFAULT;
			}
			break;
		case BOMBS:
			EntityRaglokBomb var2 = new EntityRaglokBomb(this.worldObj);
                var2.setPosition(par1.posX, par1.posY + 5, par1.posZ);
                var2.setVelocity(0, -2, 0);
                this.worldObj.spawnEntityInWorld(var2);
                ++this.rangedAttackCounter;
			if (this.rangedAttackCounter == 5) {
				ability = DEFAULT;
			}
			break;
		default: break;
		}
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(VetheaItems.heliosisLump, 25);
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
				this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D).attackEntityFrom(DamageSource.magic, 16);
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

	@Override
	public String mobName() {
		return "Raglok";
	}

	@Override
	public String name() {
		return "Raglok";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}