package net.divinerpg.entities.twilight;

import java.util.List;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityWildwoodCadillion extends EntityDivineRPGMob {

	public EntityWildwoodCadillion(World var1) {
		super(var1);
		this.setSize(1.0F, 1.3F);
		addAttackingAI();
		this.experienceValue = 40;
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.wildwoodCadillionHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.wildwoodCadillionDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.wildwoodCadillionSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.wildwoodCadillionFollowRange);
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
		this.dropItem(ItemsFood.magicMeat, 1);
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
    public boolean isValidLightLevel() {
        return true;
    }

	@Override
	public String mobName() {
		return "Wildwood Cadillion";
	}
}
