package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;

public class EntityApalachiaCadillion extends EntityPeacefulUntilAttacked {

	public EntityApalachiaCadillion(World var1) {
		super(var1);
		this.setSize(1.0F, 1.3F);
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
		int var3 = this.rand.nextInt(2 + var2);
		int var4;

		for (var4 = 0; var4 < var3; ++var4) {
			this.dropItem(getDropItem(), 1);
		}
		this.dropItem(ItemsFood.rawEmpoweredMeat, 1);
	}

	@Override
	protected Item getDropItem() {
		return TwilightItemsOther.apalachiaSoul;
	}

	@Override
	public String mobName() {
		return "Apalachia Cadillion";
	}
}