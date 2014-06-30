package net.divinerpg.helper.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.divinerpg.helper.items.VetheanItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesInfusionTable {

	public static HashMap<List<Integer>, ItemStack> recipes = new HashMap<List<Integer>, ItemStack>();
	public static HashMap<List<Integer>, Integer> number = new HashMap<List<Integer>, Integer>();

	public RecipesInfusionTable() {
		this.recipes();
	}

	public static void recipes() {
		/*addRecipe(VetheanItems.teakerLump, VetheanItems.bowTemplate, 4, new ItemStack(VetheanItems.teakerBow));
		addRecipe(VetheanItems.amthrimisLump, VetheanItems.bowTemplate, 5, new ItemStack(VetheanItems.amthrimisBow));
		addRecipe(VetheanItems.darvenLump, VetheanItems.bowTemplate, 6, new ItemStack(VetheanItems.darvenBow));
		addRecipe(VetheanItems.cermileLump, VetheanItems.bowTemplate, 8, new ItemStack(VetheanItems.cermileBow));
		addRecipe(VetheanItems.pardimalLump, VetheanItems.bowTemplate, 11, new ItemStack(VetheanItems.pardimalBow));
		addRecipe(VetheanItems.quadroticLump, VetheanItems.bowTemplate, 13, new ItemStack(VetheanItems.quadroticBow));
		addRecipe(VetheanItems.karosLump, VetheanItems.bowTemplate, 18, new ItemStack(VetheanItems.karosBow));
		addRecipe(VetheanItems.heliosisLump, VetheanItems.bowTemplate, 20, new ItemStack(VetheanItems.heliosisBow));
		addRecipe(VetheanItems.arksianeLump, VetheanItems.bowTemplate, 24, new ItemStack(VetheanItems.arksianeBow));*/

		addRecipe(VetheanItems.teakerLump, VetheanItems.clawTemplate, 2, new ItemStack(VetheanItems.teakerClaw));
		addRecipe(VetheanItems.amthrimisLump, VetheanItems.clawTemplate, 3, new ItemStack(VetheanItems.amthrimisClaw));
		addRecipe(VetheanItems.darvenLump, VetheanItems.clawTemplate, 4, new ItemStack(VetheanItems.darvenClaw));
		addRecipe(VetheanItems.cermileLump, VetheanItems.clawTemplate, 6, new ItemStack(VetheanItems.cermileClaw));
		addRecipe(VetheanItems.pardimalLump, VetheanItems.clawTemplate, 8, new ItemStack(VetheanItems.pardimalClaw));
		addRecipe(VetheanItems.quadroticLump, VetheanItems.clawTemplate, 10, new ItemStack(VetheanItems.quadroticClaw));
		addRecipe(VetheanItems.karosLump, VetheanItems.clawTemplate, 16, new ItemStack(VetheanItems.karosClaw));
		addRecipe(VetheanItems.heliosisLump, VetheanItems.clawTemplate, 17, new ItemStack(VetheanItems.heliosisClaw));
		addRecipe(VetheanItems.arksianeLump, VetheanItems.clawTemplate, 21, new ItemStack(VetheanItems.arksianeClaw));

		addRecipe(VetheanItems.teakerLump, VetheanItems.staffTemplate, 2, new ItemStack(VetheanItems.teakerStaff));
		addRecipe(VetheanItems.amthrimisLump, VetheanItems.staffTemplate, 3, new ItemStack(VetheanItems.amthrimisStaff));
		addRecipe(VetheanItems.darvenLump, VetheanItems.staffTemplate, 4, new ItemStack(VetheanItems.darvenStaff));
		addRecipe(VetheanItems.cermileLump, VetheanItems.staffTemplate, 6, new ItemStack(VetheanItems.cermileStaff));
		addRecipe(VetheanItems.pardimalLump, VetheanItems.staffTemplate, 8, new ItemStack(VetheanItems.pardimalStaff));
		addRecipe(VetheanItems.quadroticLump, VetheanItems.staffTemplate, 10, new ItemStack(VetheanItems.quadroticStaff));
		addRecipe(VetheanItems.karosLump, VetheanItems.staffTemplate, 16, new ItemStack(VetheanItems.karosStaff));
		addRecipe(VetheanItems.heliosisLump, VetheanItems.staffTemplate, 17, new ItemStack(VetheanItems.heliosisStaff));
		addRecipe(VetheanItems.arksianeLump, VetheanItems.staffTemplate, 21, new ItemStack(VetheanItems.arksianeStaff));

		addRecipe(VetheanItems.teakerLump, VetheanItems.diskTemplate, 4, new ItemStack(VetheanItems.teakerDisk));
		addRecipe(VetheanItems.amthrimisLump, VetheanItems.diskTemplate, 5, new ItemStack(VetheanItems.amthrimisDisk));
		addRecipe(VetheanItems.darvenLump, VetheanItems.diskTemplate, 6, new ItemStack(VetheanItems.darvenDisk));
		addRecipe(VetheanItems.cermileLump, VetheanItems.diskTemplate, 8, new ItemStack(VetheanItems.cermileDisk));
		addRecipe(VetheanItems.pardimalLump, VetheanItems.diskTemplate, 11, new ItemStack(VetheanItems.pardimalDisk));
		addRecipe(VetheanItems.quadroticLump, VetheanItems.diskTemplate, 13, new ItemStack(VetheanItems.quadroticDisk));
		addRecipe(VetheanItems.karosLump, VetheanItems.diskTemplate, 18, new ItemStack(VetheanItems.karosDisk));
		addRecipe(VetheanItems.heliosisLump, VetheanItems.diskTemplate, 20, new ItemStack(VetheanItems.heliosisDisk));
		addRecipe(VetheanItems.arksianeLump, VetheanItems.diskTemplate, 24, new ItemStack(VetheanItems.arksianeDisk));

		addRecipe(VetheanItems.teakerLump, VetheanItems.backswordTemplate, 4, new ItemStack(VetheanItems.teakerSword));
		addRecipe(VetheanItems.amthrimisLump, VetheanItems.backswordTemplate, 5, new ItemStack(VetheanItems.amthrimisSword));
		addRecipe(VetheanItems.darvenLump, VetheanItems.backswordTemplate, 6, new ItemStack(VetheanItems.darvenSword));
		addRecipe(VetheanItems.cermileLump, VetheanItems.backswordTemplate, 8, new ItemStack(VetheanItems.cermileSword));
		addRecipe(VetheanItems.pardimalLump, VetheanItems.backswordTemplate, 11, new ItemStack(VetheanItems.pardimalSword));
		addRecipe(VetheanItems.quadroticLump, VetheanItems.backswordTemplate, 13, new ItemStack(VetheanItems.quadroticSword));
		addRecipe(VetheanItems.karosLump, VetheanItems.backswordTemplate, 18, new ItemStack(VetheanItems.karosSword));
		addRecipe(VetheanItems.heliosisLump, VetheanItems.backswordTemplate, 20, new ItemStack(VetheanItems.heliosisSword));
		addRecipe(VetheanItems.arksianeLump, VetheanItems.backswordTemplate, 24, new ItemStack(VetheanItems.arksianeSword));

		addRecipe(VetheanItems.teakerLump, VetheanItems.hammerTemplate, 7, new ItemStack(VetheanItems.teakerHammer));
		addRecipe(VetheanItems.amthrimisLump, VetheanItems.hammerTemplate, 9, new ItemStack(VetheanItems.amthrimisHammer));
		addRecipe(VetheanItems.darvenLump, VetheanItems.hammerTemplate, 11, new ItemStack(VetheanItems.darvenHammer));
		addRecipe(VetheanItems.cermileLump, VetheanItems.hammerTemplate, 14, new ItemStack(VetheanItems.cermileHammer));
		addRecipe(VetheanItems.pardimalLump, VetheanItems.hammerTemplate, 17, new ItemStack(VetheanItems.pardimalHammer));
		addRecipe(VetheanItems.quadroticLump, VetheanItems.hammerTemplate, 19, new ItemStack(VetheanItems.quadroticHammer));
		addRecipe(VetheanItems.karosLump, VetheanItems.hammerTemplate, 22, new ItemStack(VetheanItems.karosHammer));
		addRecipe(VetheanItems.heliosisLump, VetheanItems.hammerTemplate, 27, new ItemStack(VetheanItems.heliosisHammer));
		addRecipe(VetheanItems.arksianeLump, VetheanItems.hammerTemplate, 31, new ItemStack(VetheanItems.arksianeHammer));

		addRecipe(VetheanItems.teakerLump, VetheanItems.cannonTemplate, 7, new ItemStack(VetheanItems.teakerCannon));
		addRecipe(VetheanItems.amthrimisLump, VetheanItems.cannonTemplate, 9, new ItemStack(VetheanItems.amthrimisCannon));
		addRecipe(VetheanItems.darvenLump, VetheanItems.cannonTemplate, 11, new ItemStack(VetheanItems.darvenCannon));
		addRecipe(VetheanItems.cermileLump, VetheanItems.cannonTemplate, 14, new ItemStack(VetheanItems.cermileCannon));
		addRecipe(VetheanItems.pardimalLump, VetheanItems.cannonTemplate, 17, new ItemStack(VetheanItems.pardimalCannon));
		addRecipe(VetheanItems.quadroticLump, VetheanItems.cannonTemplate, 19, new ItemStack(VetheanItems.quadroticCannon));
		addRecipe(VetheanItems.karosLump, VetheanItems.cannonTemplate, 22, new ItemStack(VetheanItems.karosCannonItem));
		addRecipe(VetheanItems.heliosisLump, VetheanItems.cannonTemplate, 27, new ItemStack(VetheanItems.heliosisCannon));
		addRecipe(VetheanItems.arksianeLump, VetheanItems.cannonTemplate, 31, new ItemStack(VetheanItems.arksianeCannon));

		/*addRecipe(VetheanItems.amthrimisLump, VetheanItems.DegradedTemplate, 8, new ItemStack(VetheanItems.degradedHelmetMelee));
		addRecipe(VetheanItems.amthrimisLump, VetheanItems.DegradedTemplate, 6, new ItemStack(VetheanItems.degradedHelmetArcana));
		addRecipe(VetheanItems.amthrimisLump, VetheanItems.DegradedTemplate, 9, new ItemStack(VetheanItems.degradedHelmetRanged));
		addRecipe(VetheanItems.amthrimisLump, VetheanItems.DegradedTemplate, 5, new ItemStack(VetheanItems.degradedBoots));
		addRecipe(VetheanItems.amthrimisLump, VetheanItems.DegradedTemplate, 8, new ItemStack(VetheanItems.degradedLegs));
		addRecipe(VetheanItems.amthrimisLump, VetheanItems.DegradedTemplate, 10, new ItemStack(VetheanItems.degradedChest));

		addRecipe(VetheanItems.cermileLump, VetheanItems.FinishedTemplate, 12, new ItemStack(VetheanItems.finishedHelmetMelee));
		addRecipe(VetheanItems.cermileLump, VetheanItems.FinishedTemplate, 9, new ItemStack(VetheanItems.finishedHelmetArcana));
		addRecipe(VetheanItems.cermileLump, VetheanItems.FinishedTemplate, 13, new ItemStack(VetheanItems.finishedHelmetRanged));
		addRecipe(VetheanItems.cermileLump, VetheanItems.FinishedTemplate, 8, new ItemStack(VetheanItems.finishedBoots));
		addRecipe(VetheanItems.cermileLump, VetheanItems.FinishedTemplate, 12, new ItemStack(VetheanItems.finishedLegs));
		addRecipe(VetheanItems.cermileLump, VetheanItems.FinishedTemplate, 14, new ItemStack(VetheanItems.finishedChest));

		addRecipe(VetheanItems.pardimalLump, VetheanItems.GlisteningTemplate, 16, new ItemStack(VetheanItems.glisteningHelmetMelee));
		addRecipe(VetheanItems.pardimalLump, VetheanItems.GlisteningTemplate, 14, new ItemStack(VetheanItems.glisteningHelmetArcana));
		addRecipe(VetheanItems.pardimalLump, VetheanItems.GlisteningTemplate, 18, new ItemStack(VetheanItems.glisteningHelmetRanged));
		addRecipe(VetheanItems.pardimalLump, VetheanItems.GlisteningTemplate, 12, new ItemStack(VetheanItems.glisteningBoots));
		addRecipe(VetheanItems.pardimalLump, VetheanItems.GlisteningTemplate, 16, new ItemStack(VetheanItems.glisteningLegs));
		addRecipe(VetheanItems.pardimalLump, VetheanItems.GlisteningTemplate, 20, new ItemStack(VetheanItems.glisteningChest));

		addRecipe(VetheanItems.karosLump, VetheanItems.DemonizedTemplate, 20, new ItemStack(VetheanItems.demonizedHelmetMelee));
		addRecipe(VetheanItems.karosLump, VetheanItems.DemonizedTemplate, 16, new ItemStack(VetheanItems.demonizedHelmetArcana));
		addRecipe(VetheanItems.karosLump, VetheanItems.DemonizedTemplate, 22, new ItemStack(VetheanItems.demonizedHelmetRanged));
		addRecipe(VetheanItems.karosLump, VetheanItems.DemonizedTemplate, 14, new ItemStack(VetheanItems.demonizedBoots));
		addRecipe(VetheanItems.karosLump, VetheanItems.DemonizedTemplate, 20, new ItemStack(VetheanItems.demonizedLegs));
		addRecipe(VetheanItems.karosLump, VetheanItems.DemonizedTemplate, 26, new ItemStack(VetheanItems.demonizedChest));

		addRecipe(VetheanItems.arksianeLump, VetheanItems.TormentedTemplate, 24, new ItemStack(VetheanItems.tormentedHelmetMelee));
		addRecipe(VetheanItems.arksianeLump, VetheanItems.TormentedTemplate, 22, new ItemStack(VetheanItems.tormentedHelmetArcana));
		addRecipe(VetheanItems.arksianeLump, VetheanItems.TormentedTemplate, 26, new ItemStack(VetheanItems.tormentedHelmetRanged));
		addRecipe(VetheanItems.arksianeLump, VetheanItems.TormentedTemplate, 20, new ItemStack(VetheanItems.tormentedBoots));
		addRecipe(VetheanItems.arksianeLump, VetheanItems.TormentedTemplate, 24, new ItemStack(VetheanItems.tormentedLegs));
		addRecipe(VetheanItems.arksianeLump, VetheanItems.TormentedTemplate, 35, new ItemStack(VetheanItems.tormentedChest));*/
	}

	public static void addRecipe(Item Item1, Item Item2, int i, ItemStack item) {
		int i1 = Item.getIdFromItem(Item1);
		int i2 = Item.getIdFromItem(Item2);
		if(i1 != 0 && item != null) 
			recipes.put(Arrays.asList(i1, i2, number.put(Arrays.asList(i1, i2), i)), item);

	}

	public static ItemStack getResult(Item Item1, Item Item2) {
		int i1 = Item.getIdFromItem(Item1);
		int i2 = Item.getIdFromItem(Item2);
		ItemStack item = (ItemStack)recipes.get(Arrays.asList(i1, i2, number.get(Arrays.asList(i1, i2))));
		if(item != null)
			return item;
		else
			return null;
	}

	public static int getStackSize(Item Item1, Item Item2) {
		int i1 = Item.getIdFromItem(Item1);
		int i2 = Item.getIdFromItem(Item2);
		int i = number.get(Arrays.asList(i1, i2));
		if(i != 0)
			return i;
		else
			return 0;
	}
}
