package net.divinerpg.entities.arcana;

import net.divinerpg.client.GuiHandler;
import net.divinerpg.entities.base.EntityDivineRPGVillager;
import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityVatticus extends EntityDivineRPGVillager {
	
	private static final String[] MESSAGE = {"message.vatticus.feel", "message.vatticus.noend", "message.vatticus.strength", "message.vatticus.discover", "message.vatticus.magic"};

	public EntityVatticus(World Util) {
		super(Util);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	@Override
	public void extraInteract(EntityPlayer p) {
		p.addChatMessage(Util.getChatComponent("Lord Vatticus: " + MessageLocalizer.normal(MESSAGE[rand.nextInt(5)])));
	}

	@Override
	public int guiID() {
		return GuiHandler.vatticus;
	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public void addRecipies(MerchantRecipeList var2) {
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.collector, 16, 0), new ItemStack(ArcanaItems.chargedCollector, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 8, 0), new ItemStack(ArcanaItems.kormaHelmet, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 8, 0), new ItemStack(ArcanaItems.kormaBody, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 8, 0), new ItemStack(ArcanaItems.kormaLegs, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 8, 0), new ItemStack(ArcanaItems.kormaBoots, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 10, 0), new ItemStack(ArcanaItems.vemosHelmet, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 10, 0), new ItemStack(ArcanaItems.vemosBody, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 10, 0), new ItemStack(ArcanaItems.vemosLegs, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 10, 0), new ItemStack(ArcanaItems.vemosBoots, 1, 0)));

		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 2, 0), new ItemStack(ArcanaItems.staffOfEnrichment, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 2, 0), new ItemStack(ArcanaItems.wizardBook, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 1, 0), new ItemStack(ArcanaItems.weakArcanaPotion, 4, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 2, 0), new ItemStack(ArcanaItems.strongArcanaPotion, 4, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 20, 0), new ItemStack(ArcanaItems.orbOfLight, 1, 0)));
	}

	@Override
	public String mobName() {
		return "Lord Vatticus";
	}
}