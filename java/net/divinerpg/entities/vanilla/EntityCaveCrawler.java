package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCaveCrawler extends EntityDivineRPGMob {

	public EntityCaveCrawler(World par1World) {
		super(par1World);
		this.setSize(1.5F, 2.0F);
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.caveCrawlerHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.caveCrawlerDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.caveCrawlerSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.caveCrawlerFollowRange);
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

	@Override
	protected Item getDropItem() {
		return VanillaItemsOther.realmiteIngot;
	}

	@Override
	protected void dropRareDrop(int par1) {
		switch(this.rand.nextInt(1)) {
		case 0:
			this.entityDropItem(new ItemStack(Items.potionitem, 1, 8196), 0.0F);
			break;
		}
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 35.0D && super.getCanSpawnHere();
	}

	@Override
	public String mobName() {
		return "Cave Crawler";
	}
}