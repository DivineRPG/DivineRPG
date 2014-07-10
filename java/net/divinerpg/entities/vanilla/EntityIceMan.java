package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.ItemsFood;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityIceMan extends EntityDivineRPGMob {

	public EntityIceMan(World var1) {
		super(var1);
		this.getNavigator().setBreakDoors(true);
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.iceManHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.iceManDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.iceManSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.iceManFollowRange);
	}

	@Override
	public int getTotalArmorValue() {
		return 6;
	}

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.iceman);
	}

	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.iceman);
	}

	@Override
	protected String getDeathSound() {
		return "mob.zombie.death";
	}

	@Override
	protected Item getDropItem() {
		return IceikaItems.iceShards;
	}

	@Override
	protected void dropFewItems(boolean var1, int var2) {
		int var3 = this.rand.nextInt(2 + var2);
		int var4;
		for(var4 = 0; var4 < var3; ++var4) 
			this.dropItem(ItemsFood.whiteMushroom, 1);

		for(var4 = 0; var4 < var3; ++var4) 
			this.dropItem(IceikaItems.iceShards, 3);
	}

	@Override
	public String mobName() {
		return "Ice Man";
	}
}