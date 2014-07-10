package net.divinerpg.entities.vanilla;

import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class EntityEnderWatcher extends EntityEnderman {

	public EntityEnderWatcher(World par1World) {
		super(par1World);
		this.setSize(0.6F, 0.6F);
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.enderWatcherHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.enderWatcherDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.enderWatcherSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.enderWatcherFollowRange);
	}

	@Override
	protected Item getDropItem() {
		return VanillaItemsOther.enderShard;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		Item item = this.getDropItem();
		Item item2 = VanillaItemsOther.watchingEye;
		int j = this.rand.nextInt(2 + par2);

		for(int k = 0; k < j; ++k) {
			this.dropItem(item, 2);
			this.dropItem(item2, 1);
		}
	}
}