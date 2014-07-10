package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityAncientEntity extends EntityDivineRPGBoss {

	public EntityAncientEntity(World par1World) {
		super(par1World);
		this.setSize(4.0F, 6.5F);
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.ancientEntityHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.ancientEntityDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.ancientEntitySpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.ancientEntityFollowRange);
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		super.attackEntityAsMob(par1Entity);
		if(this.entityToAttack != null) {
			this.entityToAttack.addVelocity(this.motionX * 10.0D, 3.0D, this.motionZ * 10.0D);
			if(this.entityToAttack instanceof EntityLiving) {
				((EntityLivingBase)entityToAttack).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0));
				playSound("mob.irongolem.throw", 1.0F, 1.0F);
			}
			return true;
		}
		return false;
	}

	@Override
	protected String getHurtSound() {
		return "mob.irongolem.hit";
	}

	@Override
	protected String getDeathSound() {
		return "mob.irongolem.death";
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {   	
		Item i = getDropItem();
		Item i2 = VanillaItemsWeapons.sandslash;
		int var3, var4;
		var3 = this.rand.nextInt(6) + 4;
		for(var4 = 0; var4 < var3; var4++) 
			this.dropItem(i, 1);
		for(var4 = 0; var4 < 1; var4++) 
			this.dropItem(i2, 1);
	}

	@Override
	protected Item getDropItem() {
		return VanillaItemsOther.divineShards;
	}

	@Override
	public String mobName() {
		return "Ancient Entity";
	}

	@Override
	public String name() {
		return "Ancient Entity";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}