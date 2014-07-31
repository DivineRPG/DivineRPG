package net.divinerpg.entities.twilight;

import java.util.List;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.api.entity.EntityPeacefullUntillAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityWildWoodCadillion extends EntityPeacefullUntillAttacked {

	public EntityWildWoodCadillion(World var1) {
		super(var1);
		this.setSize(1.0F, 1.3F);
		this.experienceValue = 40;
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.wildWoodCadillionHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.wildWoodCadillionDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.wildWoodCadillionSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.wildWoodCadillionFollowRange);
	}

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.cadillion);
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
		int var3 = this.rand.nextInt(2 + var2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(TwilightItemsOther.wildwoodSoul, 1);
		}
	}

	@Override
	protected void dropRareDrop(int var1) {
		this.dropItem(TwilightItemsOther.wildwoodSoul, 2);
	}

	@Override
	protected Item getDropItem() {
		return TwilightItemsOther.wildwoodSoul;
	}

	@Override
	protected boolean isValidLightLevel() {
		return true;
	}

	@Override
	public String mobName() {
		return "Wild Wood Cadillion";
	}
}
