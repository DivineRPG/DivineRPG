package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityCyclops extends EntityPeacefulUntilAttacked {

	public EntityCyclops(World var1) {
		super(var1);
		this.setSize(1.5F, 3.9F);
		this.experienceValue = 40;
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.cyclopsHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.cyclopsDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.cyclopsSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.cyclopsFollowRange);
	}
	
	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.cyclops);
	}

	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.cyclopsHurt);
	}

	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.cyclopsHurt);
	}

	@Override
	protected void dropFewItems(boolean var1, int loot) {
		dropItem(VanillaItemsOther.cyclopsEye, rand.nextInt(2 + loot));
		dropItem(Items.gold_ingot, rand.nextInt(2 + loot));
		if(rand.nextInt(40) == 0)
		    dropItem(VanillaItemsOther.bloodgem, 1);
	}

	@Override
	public String mobName() {
		return "Cyclops";
	}
}
