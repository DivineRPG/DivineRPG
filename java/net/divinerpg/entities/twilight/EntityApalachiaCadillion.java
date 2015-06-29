package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityApalachiaCadillion extends EntityDivineRPGMob {

	public EntityApalachiaCadillion(World var1) {
		super(var1);
		this.setSize(1.0F, 1.3F);
		addAttackingAI();
		this.experienceValue = 40;
	}

	@Override
	protected void applyEntityAttributes() { 
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.apalachiaCadillionHealth);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.apalachiaCadillionDamage);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.apalachiaCadillionSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.apalachiaCadillionFollowRange);
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
		this.dropItem(TwilightItemsOther.apalachiaSoul, this.rand.nextInt(2 + var2));
		this.dropItem(ItemsFood.enrichedMagicMeat, 1);
	}
	
	@Override
    public boolean isValidLightLevel() {
        return true;
    }

	@Override
	public String mobName() {
		return "Apalachia Cadillion";
	}
}