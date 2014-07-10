package net.divinerpg.entities.vanilla;

import java.util.List;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.api.entity.EntityPeacefullUntillAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityCyclops extends EntityPeacefullUntillAttacked {

	public EntityCyclops(World var1) {
		super(var1);
		this.setSize(2.0F, 3.9F);
		this.experienceValue = 40;
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.cyclopsHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.cyclopsDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.cyclopsSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.cyclopsFollowRange);
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
	protected void dropFewItems(boolean var1, int var2) {
		int var3 = this.rand.nextInt(2 + var2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(VanillaItemsOther.cyclopsEye, 1);
		}
	}

	@Override
	protected void dropRareDrop(int var1) {
		this.dropItem(VanillaItemsOther.healingStone, 1);
	}

	@Override
	protected Item getDropItem() {
		return VanillaItemsOther.cyclopsEye;
	}

	@Override
	public String mobName() {
		return "Cyclops";
	}
}