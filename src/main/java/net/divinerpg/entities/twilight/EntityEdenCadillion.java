package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityEdenCadillion extends EntityDivineRPGMob {

	public EntityEdenCadillion(World var1) {
		super(var1);
		this.setSize(1.0F, 1.3F);
		addAttackingAI();
		this.experienceValue = 40;
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.edenCadillionHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.edenCadillionDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.edenCadillionSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.edenCadillionFollowRange);
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
		if(this.isBurning()) this.dropItem(ItemsFood.empoweredMeat, 1);
        else this.dropItem(ItemsFood.rawEmpoweredMeat, 1);
		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(TwilightItemsOther.edenSoul, 1);
		}
	}

	@Override
	protected Item getDropItem() {
		return TwilightItemsOther.edenSoul;
	}
	
	@Override
	public boolean isValidLightLevel() {
	    return true;
	}

	@Override
	public String mobName() {
		return "Eden Cadillion";
	}
}
