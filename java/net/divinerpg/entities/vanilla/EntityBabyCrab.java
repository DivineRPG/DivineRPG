package net.divinerpg.entities.vanilla;

import java.util.List;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityBabyCrab extends EntityPeacefulUntilAttacked {
	
	public EntityBabyCrab(World var1) {
		super(var1);
		this.setSize(0.6F, 0.6F);
		this.experienceValue = 30;
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.babyCrabHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.babyCrabDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.babyCrabSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.babyCrabFollowRange);
	}
	
	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.crab);
	}
	
	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.crabHurt);
	}

	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.crabHurt);
	}

	@Override
	protected Item getDropItem() {
		return VanillaItemsOther.crabClaw;
	}
	
	@Override
	protected void dropFewItems(boolean var1, int var2) {
		int var3 = this.rand.nextInt(2 + var2);
		for (int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(getDropItem(), 1);
		}
	}

	@Override
	public String mobName() {
		return "Baby Crab";
	}
}