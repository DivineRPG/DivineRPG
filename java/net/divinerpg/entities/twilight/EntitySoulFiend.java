package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntitySoulFiend extends EntityDivineRPGBoss {

	public EntitySoulFiend(World var1) {
		super(var1); 
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.soulFiendHealth);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.soulFiendDamage);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.soulFiendSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.soulFiendFollowRange);
	}

	@Override
	public int getTotalArmorValue() {
		return 10;
	}

	@Override
	public boolean attackEntityAsMob(Entity var1) {
		if(super.attackEntityAsMob(var1)) {
			if(var1 instanceof EntityLiving) {
				((EntityLiving)var1).addPotionEffect(new PotionEffect(Potion.confusion.id, 12 * 20, 0));
				((EntityLiving)var1).addPotionEffect(new PotionEffect(Potion.blindness.id, 12 * 20, 0));
			}
			return true;
		} else {
			return false;
		}
	}


	@Override
	protected Item getDropItem() {
		return TwilightItemsWeapons.haliteBlade;
	}

	@Override
	public void dropFewItems(boolean par1, int par2) {
		this.dropItem(this.getDropItem(), 1);
	}

	@Override
	public String mobName() {
		return "Soul Fiend";
	}

	@Override
	public String name() {
		return "Soul Fiend";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}