package net.divinerpg.utils.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.divinerpg.utils.items.VetheaItems;
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

		addRecipe(VetheaItems.teakerLump, VetheaItems.clawTemplate, 2, new ItemStack(VetheaItems.teakerClaw));
		addRecipe(VetheaItems.amthrimisLump, VetheaItems.clawTemplate, 3, new ItemStack(VetheaItems.amthrimisClaw));
		addRecipe(VetheaItems.darvenLump, VetheaItems.clawTemplate, 4, new ItemStack(VetheaItems.darvenClaw));
		addRecipe(VetheaItems.cermileLump, VetheaItems.clawTemplate, 6, new ItemStack(VetheaItems.cermileClaw));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.clawTemplate, 8, new ItemStack(VetheaItems.pardimalClaw));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.clawTemplate, 10, new ItemStack(VetheaItems.quadroticClaw));
		addRecipe(VetheaItems.karosLump, VetheaItems.clawTemplate, 16, new ItemStack(VetheaItems.karosClaw));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.clawTemplate, 17, new ItemStack(VetheaItems.heliosisClaw));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.clawTemplate, 21, new ItemStack(VetheaItems.arksianeClaw));

		addRecipe(VetheaItems.teakerLump, VetheaItems.staffTemplate, 2, new ItemStack(VetheaItems.teakerStaff));
		addRecipe(VetheaItems.amthrimisLump, VetheaItems.staffTemplate, 3, new ItemStack(VetheaItems.amthrimisStaff));
		addRecipe(VetheaItems.darvenLump, VetheaItems.staffTemplate, 4, new ItemStack(VetheaItems.darvenStaff));
		addRecipe(VetheaItems.cermileLump, VetheaItems.staffTemplate, 6, new ItemStack(VetheaItems.cermileStaff));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.staffTemplate, 8, new ItemStack(VetheaItems.pardimalStaff));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.staffTemplate, 10, new ItemStack(VetheaItems.quadroticStaff));
		addRecipe(VetheaItems.karosLump, VetheaItems.staffTemplate, 16, new ItemStack(VetheaItems.karosStaff));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.staffTemplate, 17, new ItemStack(VetheaItems.heliosisStaff));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.staffTemplate, 21, new ItemStack(VetheaItems.arksianeStaff));

		addRecipe(VetheaItems.teakerLump, VetheaItems.diskTemplate, 4, new ItemStack(VetheaItems.teakerDisk));
		addRecipe(VetheaItems.amthrimisLump, VetheaItems.diskTemplate, 5, new ItemStack(VetheaItems.amthrimisDisk));
		addRecipe(VetheaItems.darvenLump, VetheaItems.diskTemplate, 6, new ItemStack(VetheaItems.darvenDisk));
		addRecipe(VetheaItems.cermileLump, VetheaItems.diskTemplate, 8, new ItemStack(VetheaItems.cermileDisk));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.diskTemplate, 11, new ItemStack(VetheaItems.pardimalDisk));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.diskTemplate, 13, new ItemStack(VetheaItems.quadroticDisk));
		addRecipe(VetheaItems.karosLump, VetheaItems.diskTemplate, 18, new ItemStack(VetheaItems.karosDisk));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.diskTemplate, 20, new ItemStack(VetheaItems.heliosisDisk));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.diskTemplate, 24, new ItemStack(VetheaItems.arksianeDisk));

		addRecipe(VetheaItems.teakerLump, VetheaItems.backswordTemplate, 4, new ItemStack(VetheaItems.teakerSword));
		addRecipe(VetheaItems.amthrimisLump, VetheaItems.backswordTemplate, 5, new ItemStack(VetheaItems.amthrimisSword));
		addRecipe(VetheaItems.darvenLump, VetheaItems.backswordTemplate, 6, new ItemStack(VetheaItems.darvenSword));
		addRecipe(VetheaItems.cermileLump, VetheaItems.backswordTemplate, 8, new ItemStack(VetheaItems.cermileSword));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.backswordTemplate, 11, new ItemStack(VetheaItems.pardimalSword));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.backswordTemplate, 13, new ItemStack(VetheaItems.quadroticSword));
		addRecipe(VetheaItems.karosLump, VetheaItems.backswordTemplate, 18, new ItemStack(VetheaItems.karosSword));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.backswordTemplate, 20, new ItemStack(VetheaItems.heliosisSword));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.backswordTemplate, 24, new ItemStack(VetheaItems.arksianeSword));

		addRecipe(VetheaItems.teakerLump, VetheaItems.hammerTemplate, 7, new ItemStack(VetheaItems.teakerHammer));
		addRecipe(VetheaItems.amthrimisLump, VetheaItems.hammerTemplate, 9, new ItemStack(VetheaItems.amthrimisHammer));
		addRecipe(VetheaItems.darvenLump, VetheaItems.hammerTemplate, 11, new ItemStack(VetheaItems.darvenHammer));
		addRecipe(VetheaItems.cermileLump, VetheaItems.hammerTemplate, 14, new ItemStack(VetheaItems.cermileHammer));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.hammerTemplate, 17, new ItemStack(VetheaItems.pardimalHammer));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.hammerTemplate, 19, new ItemStack(VetheaItems.quadroticHammer));
		addRecipe(VetheaItems.karosLump, VetheaItems.hammerTemplate, 22, new ItemStack(VetheaItems.karosHammer));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.hammerTemplate, 27, new ItemStack(VetheaItems.heliosisHammer));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.hammerTemplate, 31, new ItemStack(VetheaItems.arksianeHammer));

		addRecipe(VetheaItems.teakerLump, VetheaItems.cannonTemplate, 7, new ItemStack(VetheaItems.teakerCannon));
		addRecipe(VetheaItems.amthrimisLump, VetheaItems.cannonTemplate, 9, new ItemStack(VetheaItems.amthrimisCannon));
		addRecipe(VetheaItems.darvenLump, VetheaItems.cannonTemplate, 11, new ItemStack(VetheaItems.darvenCannon));
		addRecipe(VetheaItems.cermileLump, VetheaItems.cannonTemplate, 14, new ItemStack(VetheaItems.cermileCannon));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.cannonTemplate, 17, new ItemStack(VetheaItems.pardimalCannon));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.cannonTemplate, 19, new ItemStack(VetheaItems.quadroticCannon));
		addRecipe(VetheaItems.karosLump, VetheaItems.cannonTemplate, 22, new ItemStack(VetheaItems.karosCannonItem));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.cannonTemplate, 27, new ItemStack(VetheaItems.heliosisCannon));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.cannonTemplate, 31, new ItemStack(VetheaItems.arksianeCannon));

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
