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

public class EntityLeorna extends EntityDivineRPGVillager {

	public EntityLeorna(World Util) {
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
			var2.addChatMessage(Util.getChatComponent("Leorna: Could you imagine if the whole world was covered in plants?"));
			break;
		case 1:
			var2.addChatMessage(Util.getChatComponent("Leorna: Embracing nature is part of the importance of life."));
			break;
		case 2:
			var2.addChatMessage(Util.getChatComponent("Leorna: Have you tried throwing Lamona? It is mighty handy for finding my way."));
			break;
		case 3:
			var2.addChatMessage(Util.getChatComponent("Leorna: Hitchak sure is tasty."));
			break;
		case 4:
			var2.addChatMessage(Util.getChatComponent("Leorna: Zelus won't stop looking at me."));
			break;
		}
	}

	@Override
	public int guiID() {
		return GuiHandler.leorna;
	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public void addRecipies(MerchantRecipeList var2) {
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 1, 1), new ItemStack(ArcanaItems.eucalyptusSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 2, 1), new ItemStack(ArcanaItems.marsineSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 2, 1), new ItemStack(ArcanaItems.firestockSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 3, 1), new ItemStack(ArcanaItems.pinflySeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 4, 1), new ItemStack(ArcanaItems.aquamarineSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 5, 1), new ItemStack(ArcanaItems.hitchakSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 7, 1), new ItemStack(ArcanaItems.veiloSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 9, 1), new ItemStack(ArcanaItems.lamonaSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 2, 1), new ItemStack(ArcanaBlocks.arcanaDirt, 9, 0)));
	}

	@Override
	public String mobName() {
		return "Leorna";
	}
}