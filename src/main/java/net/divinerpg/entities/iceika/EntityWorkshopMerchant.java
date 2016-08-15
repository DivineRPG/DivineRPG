package net.divinerpg.entities.iceika;

import net.divinerpg.DivineRPG;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.entities.base.EntityDivineRPGVillager;
import net.divinerpg.entities.base.InfiniteTrade;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.items.IceikaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityWorkshopMerchant extends EntityDivineRPGVillager {
	
	private static final String[] MESSAGE = {"message.merchant.ho", "message.merchant.out", "message.merchant.in", "message.merchant.burr"};

	public EntityWorkshopMerchant(World var1) {
		super(var1);
	}

	@Override
	public void extraInteract(EntityPlayer p) {
		p.addChatMessage(Util.getChatComponent("Merchant: " + MessageLocalizer.normal(MESSAGE[rand.nextInt(4)])));
	}
	
	@Override
	public boolean interact(EntityPlayer var1) {
		if(!this.worldObj.isRemote) {
			extraInteract(var1);
			var1.openGui(DivineRPG.instance, guiID(), this.worldObj, getEntityId(), 0, 0);
			var1.triggerAchievement(DivineRPGAchievements.lilGift);
			return true;
		} else {
			return super.interact(var1);
		}
	}

	@Override
	public int guiID() {
		return GuiHandler.merchant;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 4), new ItemStack(IceikaItems.santaCap, 1, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 4), new ItemStack(IceikaItems.santaTunic, 1, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 4), new ItemStack(IceikaItems.santaPants, 1, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 4), new ItemStack(IceikaItems.santaBoots, 1, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaItems.eggNog, 2, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaItems.chocolateLog, 5, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaItems.peppermints, 15, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaItems.fruitCake, 3, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 20), new ItemStack(IceikaItems.icicleBane, 1, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.greenXmasLights, 16, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.redXmasLights, 16, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.blueXmasLights, 16, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.yellowXmasLights, 16, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.purpleXmasLights, 16, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 3), new ItemStack(IceikaBlocks.presentBox, 1)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.candyCane, 4, 0)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.candyCane, 4, 1)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.candyCane, 4, 2)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.candyCane, 4, 3)));
		list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.candyCane, 4, 4)));
	}

	@Override
	public String mobName() {
		return "Workshop Merchent";
	}
}