package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGBoss;
import net.divinerpg.utils.blocks.VanillaBlocks;
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
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.ancientEntityHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.ancientEntityDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.ancientEntitySpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.ancientEntityFollowRange);
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
		this.dropItem(VanillaItemsOther.divineShards, this.rand.nextInt(4) + 3);
		this.dropItem(VanillaItemsWeapons.sandslash, 1);
		this.dropItem(Item.getItemFromBlock(VanillaBlocks.ancientEntityStatue), 1);
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