package naturix.divinerpg.objects.entities.entity.arcana;

import moze_intel.projecte.utils.GuiHandler;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.MessageLocalizer;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class Vatticus extends EntityDivineRPGVillager {
	
	private static final String[] MESSAGE = {"message.vatticus.feel", "message.vatticus.noend", "message.vatticus.strength", "message.vatticus.discover", "message.vatticus.magic"};

	public Vatticus(World Util) {
		super(Util);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.world.checkNoEntityCollision(this.getEntityBoundingBox()) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
	}

	@Override
	public void extraInteract(EntityPlayer p) {
		p.sendMessage(Utils.getChatComponent("Lord Vatticus: " + MessageLocalizer.normal(MESSAGE[rand.nextInt(5)])));
	}

	//FIXME - vatticus gui
//	@Override
//	public int guiID() {
//		return GuiHandler.vatticus;
//	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public void addRecipies(MerchantRecipeList var2) {
		var2.add(new MerchantRecipe(new ItemStack(ModItems.collector, 16, 0), new ItemStack(ModItems.chargedCollector, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 8, 0), new ItemStack(ModItems.kormaHelmet, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 8, 0), new ItemStack(ModItems.kormaBody, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 8, 0), new ItemStack(ModItems.kormaLegs, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 8, 0), new ItemStack(ModItems.kormaBoots, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 10, 0), new ItemStack(ModItems.vemosHelmet, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 10, 0), new ItemStack(ModItems.vemosBody, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 10, 0), new ItemStack(ModItems.vemosLegs, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 10, 0), new ItemStack(ModItems.vemosBoots, 1, 0)));

		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2, 0), new ItemStack(ModItems.staffOfEnrichment, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2, 0), new ItemStack(ModItems.wizardBook, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 1, 0), new ItemStack(ModItems.weakArcanaPotion, 4, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2, 0), new ItemStack(ModItems.strongArcanaPotion, 4, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 20, 0), new ItemStack(ModItems.orbOfLight, 1, 0)));
	}

}