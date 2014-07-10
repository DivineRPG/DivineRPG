package net.divinerpg.entities.arcana;

import net.divinerpg.DivineRPG;
import net.divinerpg.api.entity.EntityDivineRPGVillager;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityVatticus extends EntityDivineRPGVillager {

	public EntityVatticus(World var1) {
		super(var1);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	@Override
	public void interact(Util var1, EntityPlayer p) {
		switch (this.rand.nextInt(5)) {
		case 0:
			p.addChatMessage(var1.addChatMessage("Lord Vatticus: Can you feel the empowerment of the arcanium around you?"));
			break;
		case 1:
			p.addChatMessage(var1.addChatMessage("Lord Vatticus: I hear there's no end to this place, there's no end to me either."));
			break;
		case 2:
			p.addChatMessage(var1.addChatMessage("Lord Vatticus: Arcana come upon me, give me the ultimate strength!"));
			break;
		case 3:
			p.addChatMessage(var1.addChatMessage("Lord Vatticus: I've discovered how to awake the ancient leader of the dungeon."));
			break;
		case 4:
			p.addChatMessage(var1.addChatMessage("Lord Vatticus: Hurr drah drah, magic."));
			break;
		}
	}

	@Override
	public int guiID() {
		return GuiHandler.vatticus;
	}

	@Override
	public void addRecipies(MerchantRecipeList var2) {
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.collector, 16, 0), new ItemStack(ArcanaItems.chargedCollector, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 6, 0), new ItemStack(ArcanaItems.kormaHelmet, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 6, 0), new ItemStack(ArcanaItems.kormaBody, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 6, 0), new ItemStack(ArcanaItems.kormaLegs, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 6, 0), new ItemStack(ArcanaItems.kormaBoots, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 8, 0), new ItemStack(ArcanaItems.vemosHelmet, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 8, 0), new ItemStack(ArcanaItems.vemosBody, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 8, 0), new ItemStack(ArcanaItems.vemosLegs, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 8, 0), new ItemStack(ArcanaItems.vemosBoots, 1, 0)));

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