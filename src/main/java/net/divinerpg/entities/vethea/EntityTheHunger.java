package net.divinerpg.entities.vethea;

import net.divinerpg.client.GuiHandler;
import net.divinerpg.entities.base.EntityDivineRPGVillager;
import net.divinerpg.entities.base.InfiniteTrade;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityTheHunger extends EntityDivineRPGVillager {

	public EntityTheHunger(World var1) {
		super(var1);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	@Override
	public void extraInteract(EntityPlayer var2) {
		switch (this.rand.nextInt(4)) {
		case 0:
			var2.addChatMessage(Util.getChatComponent("The Hunger: Mmm. I'm hungry."));
			break;
		case 1:
			var2.addChatMessage(Util.getChatComponent("The Hunger: Can you come a little closer?"));
			break;
		case 2:
			var2.addChatMessage(Util.getChatComponent("The Hunger: You need to fatten yourself up."));
			break;
		case 3:
			var2.addChatMessage(Util.getChatComponent("The Hunger: Let's go out to dinner. You'll be cooking."));
			break;
		}
	}

	@Override
	public int guiID() {
		return GuiHandler.hunger;
	}

	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 1, 0), new ItemStack(VetheaItems.dreamCarrot, 2, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.dreamMelon, 4, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 5, 0), new ItemStack(VetheaItems.dreamPie, 5, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 10, 0), new ItemStack(VetheaItems.dreamCake, 8, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 5, 0), new ItemStack(VetheaItems.barredDoor, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.diskTemplate, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.cannonTemplate, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.backswordTemplate, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.hammerTemplate, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.bowTemplate, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.staffTemplate, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.clawTemplate, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 5, 0), new ItemStack(VetheaItems.degradedTemplate, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 1, 0), new ItemStack(VetheaBlocks.lightDreamBricks, 16, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 1, 0), new ItemStack(VetheaBlocks.darkDreamBricks, 16, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 1, 0), new ItemStack(VetheaBlocks.redDreamBricks, 16, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 2, 0), new ItemStack(VetheaBlocks.dreamDirt, 64, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 1, 0), new ItemStack(VetheaBlocks.smoothGlass, 16, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 4, 0), new ItemStack(VetheaBlocks.firelight, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 4, 0), new ItemStack(Blocks.chest, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.dirtyPearls, 2, 0), new ItemStack(VetheaItems.teakerArrow, 32, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.cleanPearls, 1, 0), new ItemStack(VetheaItems.dreamSweets, 4, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.cleanPearls, 5, 0), new ItemStack(VetheaItems.finishedTemplate, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.cleanPearls, 2, 0), new ItemStack(VetheaItems.darvenArrow, 32, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.cleanPearls, 4, 0), new ItemStack(VetheaItems.pardimalArrow, 32, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.cleanPearls, 6, 0), new ItemStack(VetheaItems.karosArrow, 32, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.cleanPearls, 15, 0), new ItemStack(VetheaItems.minersAmulet, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.polishedPearls, 20, 0), new ItemStack(VetheaItems.dreamFlint, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.polishedPearls, 5, 0), new ItemStack(VetheaItems.glisteningTemplate, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.polishedPearls, 5, 0), new ItemStack(VetheaItems.demonizedTemplate, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.shinyPearls, 40, 0), new ItemStack(VetheaItems.moonClock, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.shinyPearls, 25, 0), new ItemStack(VetheaItems.heivaBelt, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.shinyPearls, 1, 0), new ItemStack(VetheaItems.dreamSours, 4, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.shinyPearls, 5, 0), new ItemStack(VetheaItems.tormentedTemplate, 1, 0)));
		recipes.add(new InfiniteTrade(new ItemStack(VetheaItems.rockChunks, 25, 0), new ItemStack(VetheaItems.karosRockmaul, 1, 0)));
	}

	@Override
	public String mobName() {
		return "The Hunger";
	}
}