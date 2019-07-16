package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSeeds;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class Leorna extends EntityDivineRPGVillager {

	public Leorna(World Util) {
		super(Util);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.world.checkNoEntityCollision(this.getEntityBoundingBox()) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
	}

	@Override
	public void extraInteract(EntityPlayer var2) {
		switch (this.rand.nextInt(5)) {
		case 0:
			var2.sendMessage(Utils.getChatComponent("Leorna: Could you imagine if the whole world was covered in plants?"));
			break;
		case 1:
			var2.sendMessage(Utils.getChatComponent("Leorna: Embracing nature is part of the importance of life."));
			break;
		case 2:
			var2.sendMessage(Utils.getChatComponent("Leorna: Have you tried throwing Lamona? It is mighty handy for finding my way."));
			break;
		case 3:
			var2.sendMessage(Utils.getChatComponent("Leorna: Hitchak sure is tasty."));
			break;
		case 4:
			var2.sendMessage(Utils.getChatComponent("Leorna: Zelus won't stop looking at me."));
			break;
		}
	}
//FIXME - Leorna GUI
//	@Override
//	public int guiID() {
//		return GuiHandler.leorna;
//	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public void addRecipies(MerchantRecipeList var2) {
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 1, 1), new ItemStack(ModSeeds.eucalyptusSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2, 1), new ItemStack(ModSeeds.marsineSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2, 1), new ItemStack(ModSeeds.firestockSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3, 1), new ItemStack(ModSeeds.pinflySeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 4, 1), new ItemStack(ModSeeds.aquamarineSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 5, 1), new ItemStack(ModSeeds.hitchakSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 7, 1), new ItemStack(ModSeeds.veiloSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 9, 1), new ItemStack(ModSeeds.lamonaSeeds, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2, 1), new ItemStack(ModBlocks.arcanaDirt, 9, 0)));
	}


}