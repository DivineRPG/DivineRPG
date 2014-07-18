
package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.api.entity.EntityStats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityZone extends EntityDivineRPGMob implements IRangedAttackMob {

	private static final double spawnLayer = 4;
	private int special;

	public EntityZone(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize(0.8F, 1.0F);
	}
	
	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.zoneHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.zoneDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.zoneSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.zoneFollowRange);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
	}

	@Override
	protected void updateAITasks() {	
		if (this.special > 0 && this.getAttackTarget() != null) {
			this.special--;
			if (this.special % 2 == 0) {
				this.shootEntity(this.getAttackTarget());
				this.rotationYaw += 360 / (25 / 2);
			}
		} else {
			super.updateAITasks();
		}
	}

	@Override
	protected String getLivingSound() {
		return Sounds.zone.getPrefixedName();
	}

	@Override

	protected String getHurtSound() {
		return Sounds.zoneHurt.getPrefixedName();
	}

	@Override
	protected String getDeathSound() {
		return getHurtSound();
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase par1, float par2) {
		this.special = 25;
	}

	private void shootEntity (EntityLivingBase par1) {
		//EntityVetheanArrow var1 = new EntityVetheanArrow(this.worldObj, this, 15F);
		// this.worldObj.spawnEntityInWorld(var1);
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		int var2 = (int)EntityStats.zoneDamage;
		if (this.isPotionActive(Potion.damageBoost)) 
			var2 += 3 << this.getActivePotionEffect(Potion.damageBoost).getAmplifier();       
		if (this.isPotionActive(Potion.weakness)) 
			var2 -= 2 << this.getActivePotionEffect(Potion.weakness).getAmplifier();
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
			if (var5 > 0)
				par1Entity.setFire(var5 * 4); 
		}
		return var4;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(VetheaItems.shinyPearls, 1);
	}

	@Override
	public String mobName() {
		return "Zone";
	}
}