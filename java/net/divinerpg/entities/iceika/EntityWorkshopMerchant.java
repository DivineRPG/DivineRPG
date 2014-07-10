package net.divinerpg.entities.iceika;

import net.divinerpg.DivineRPG;
import net.divinerpg.api.entity.EntityDivineRPGVillager;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.items.IceikaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityWorkshopMerchant extends EntityDivineRPGVillager {

	public EntityWorkshopMerchant(World var1) {
		super(var1);
	}

	@Override
	public void interact(Util api, EntityPlayer p) {
		switch(this.rand.nextInt(4)) {
		case 0:
			p.addChatMessage(Util.addChatMessage("Merchent: Hohoho."));
			break;
		case 1:
			p.addChatMessage(Util.addChatMessage("Merchent: It's cold outside."));
			break;
		case 2:
			p.addChatMessage(Util.addChatMessage("Merchent: It's cold inside."));
			break;
		case 3:
			p.addChatMessage(Util.addChatMessage("Merchent: Burr!"));
			break;
		}
	}
	
	@Override
	public boolean interact(EntityPlayer var1) {
		if(!this.worldObj.isRemote) {
			interact(new Util(), var1);
			var1.openGui(DivineRPG.instance, guiID(), this.worldObj, getEntityId(), 0, 0);
			var1.triggerAchievement(DivineRPGAchievements.lilTinkerin);
			return true;
		} else {
			return super.interact(var1);
		}
	}

	@Override
	public int guiID() {
		return GuiHandler.merchent;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 4, 0), new ItemStack(IceikaItems.santaHead, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 4, 0), new ItemStack(IceikaItems.santaBody, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 4, 0), new ItemStack(IceikaItems.santaLegs, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 4, 0), new ItemStack(IceikaItems.santaBoots, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 1, 0), new ItemStack(IceikaItems.eggNog, 2, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 1, 0), new ItemStack(IceikaItems.chocolateLog, 5, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 1, 0), new ItemStack(IceikaItems.peppermints, 15, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 1, 0), new ItemStack(IceikaItems.fruitCake, 3, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 15, 0), new ItemStack(IceikaItems.icicleBane, 1, 0)));
		//Lights are not needed
		//list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowFlake, 3, 0), new ItemStack(IceikaBlockHelper.giftBox, 1, 0)));
	}

	@Override
	public String mobName() {
		return "Workshop Merchent";
	}
}