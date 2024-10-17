package net.divinerpg.entities.arcana;

import net.divinerpg.client.GuiHandler;
import net.divinerpg.entities.base.EntityDivineRPGVillager;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.divinerpg.utils.MessageLocalizer;

public class EntityDatticon extends EntityDivineRPGVillager {

	public EntityDatticon(World Util) {
		super(Util);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	@Override
	public void extraInteract(EntityPlayer var2) {
		switch (this.rand.nextInt(5)) {
		case 0:
			var2.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.datticon.1")));
			break;
		case 1:
			var2.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.datticon.2")));
			break;
		case 2:
			var2.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.datticon.3")));
			break;
		case 3:
			var2.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.datticon.4")));
			break;
		case 4:
			var2.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.datticon.5")));
			break;
		}
	}

	@Override
	public int guiID() {
		return GuiHandler.datticon;
	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public void addRecipies(MerchantRecipeList var2) {
		//var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 1, 0), new ItemStack(ArcanaItems.arcaniumBucket, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 5, 0), new ItemStack(ArcanaBlocks.arcaniteRails, 8, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 8, 0), new ItemStack(ArcanaBlocks.starBridge, 16, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 3, 0), new ItemStack(ArcanaBlocks.arcanitetubes, 16, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 2, 0), new ItemStack(ArcanaBlocks.moltenFurnace, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 3, 0), new ItemStack(ArcanaBlocks.greenlightFurnace, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 4, 0), new ItemStack(ArcanaBlocks.oceanfireFurnace, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 5, 0), new ItemStack(ArcanaBlocks.moonlightFurnace, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 7, 0), new ItemStack(ArcanaBlocks.whitefireFurnace, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 9, 0), new ItemStack(ArcanaBlocks.demonFurnace, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 3, 0), new ItemStack(ArcanaBlocks.elevantium, 9, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 3, 0), new ItemStack(ArcanaBlocks.acceleron, 3, 0)));
	}

	@Override
	public String mobName() {
		return "Datticon";
	}
}
