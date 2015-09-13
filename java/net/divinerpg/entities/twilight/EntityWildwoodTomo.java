package net.divinerpg.entities.twilight;

import java.util.List;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityWildwoodTomo extends EntityPeacefulUntilAttacked {

	public EntityWildwoodTomo(World var1) {
		super(var1);
		this.setSize(1.1F, 1.0F);
		this.experienceValue = 40;
	}

	@Override
	protected boolean isAIEnabled() {
		return true;
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.wildwoodTomoHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.wildwoodTomoDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.wildwoodTomoSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.wildwoodTomoFollowRange);
	}

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.croak);
	}

	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.growlHurt);
	}

	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.growlHurt);
	}

	@Override
	protected void dropFewItems(boolean var1, int var2) {
		super.dropFewItems(var1, var2);
		this.dropItem(ItemsFood.magicMeat, 1);
	}

	@Override
	protected Item getDropItem() {
		return TwilightItemsOther.wildwoodSoul;
	}

	@Override
	public String mobName() {
		return "Wildwood Tomo";
	}
}