
package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityDivineArrow;
import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityZone extends VetheaMob {

	public EntityZone(World par1World) {
		super(par1World);
		this.setSize(0.8F, 1.0F);
	}
	
	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.zoneHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.zoneDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.zoneSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.zoneFollowRange);
	}

	@Override
    public int getSpawnLayer() {
    	return 4;
    }

	@Override
	public void onUpdate() {	
		super.onUpdate();
		this.entityToAttack=this.worldObj.getClosestVulnerablePlayerToEntity(this, 32);
		if(!this.worldObj.isRemote && this.ticksExisted % 40 == 0 && this.getEntityToAttack() != null && this.getEntityToAttack() instanceof EntityLivingBase) this.shootEntity((EntityLivingBase)this.getEntityToAttack());
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

	private void shootEntity(EntityLivingBase e) {
		EntityDivineArrow arrow = new EntityDivineArrow(this.worldObj, this, e, 1.6f, 12, 20, "karosArrow");
		this.worldObj.spawnEntityInWorld(arrow);
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