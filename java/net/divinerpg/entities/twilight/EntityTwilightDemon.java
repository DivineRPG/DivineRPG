package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGBoss;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityTwilightDemon extends EntityDivineRPGBoss {

	public EntityTwilightDemon(World var1) {
		super(var1);
		this.setSize(2.0F, 4.0F);
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.twilightDemonHealth);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.twilightDemonDamage);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.twilightDemonSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.twilightDemonFollowRange);
	}

	@Override
	public int getTotalArmorValue() {
		return 10;
	}

	@Override
	public boolean attackEntityAsMob(Entity var1) {
		if(super.attackEntityAsMob(var1)) {
			if(var1 instanceof EntityLivingBase) {
				((EntityLivingBase)var1).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20, 50));
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.insect);
	}

	@Override
	protected String getHurtSound() {
		return getLivingSound();
	}

	@Override
	protected Item getDropItem() {
		return TwilightItemsWeapons.haliteBow;
	}

	@Override
	public void dropFewItems(boolean par1, int par2)  {
		this.dropItem(this.getDropItem(), 1);
		if(this.rand.nextInt(2) == 0)this.dropItem(Item.getItemFromBlock(VanillaBlocks.twilightDemonStatue), 1);
	}

	@Override
	public String mobName() {
		return "Twilight Demon";
	}

	@Override
	public String name() {
		return "Twilight Demon";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}