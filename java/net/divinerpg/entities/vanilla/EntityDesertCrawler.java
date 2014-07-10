package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityDesertCrawler extends EntityDivineRPGMob {

	public EntityDesertCrawler(World par1World) {
		super(par1World);
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.desertCrawlerHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.desertCrawlerDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.desertCrawlerSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.desertCrawlerFollowRange);
	}

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.crawler);
	}

	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.crawlerHurt);
	}

	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.crawlerHurt);
	}

	protected Item getDropItem() {
		return Item.getItemFromBlock(Blocks.sandstone);
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		Item i = getDropItem();
		int var4;
		int var3 = this.rand.nextInt(3 + par2);

		for(var4 = 0; var4 < var3; ++var4) {
			this.dropItem(i, 20);
		}

		for(var4 = 0; var4 < var3; ++var4) {
			this.dropItem(i, 60);
		}
	}

	@Override
	public String mobName() {
		return "Desert Crawler";
	}
}