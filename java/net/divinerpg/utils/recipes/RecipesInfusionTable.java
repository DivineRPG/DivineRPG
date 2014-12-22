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
		addRecipe(VetheaItems.teakerLump, VetheaItems.bowTemplate, 4, new ItemStack(VetheaItems.teakerBow));
		addRecipe(VetheaItems.amthirmisLump, VetheaItems.bowTemplate, 5, new ItemStack(VetheaItems.amthrimisBow));
		addRecipe(VetheaItems.darvenLump, VetheaItems.bowTemplate, 6, new ItemStack(VetheaItems.darvenBow));
		addRecipe(VetheaItems.cermileLump, VetheaItems.bowTemplate, 8, new ItemStack(VetheaItems.cermileBow));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.bowTemplate, 11, new ItemStack(VetheaItems.pardimalBow));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.bowTemplate, 13, new ItemStack(VetheaItems.quadroticBow));
		addRecipe(VetheaItems.karosLump, VetheaItems.bowTemplate, 18, new ItemStack(VetheaItems.karosBow));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.bowTemplate, 20, new ItemStack(VetheaItems.heliosisBow));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.bowTemplate, 24, new ItemStack(VetheaItems.arksianeBow));

		addRecipe(VetheaItems.teakerLump, VetheaItems.clawTemplate, 2, new ItemStack(VetheaItems.teakerClaw));
		addRecipe(VetheaItems.amthirmisLump, VetheaItems.clawTemplate, 3, new ItemStack(VetheaItems.amthrimisClaw));
		addRecipe(VetheaItems.darvenLump, VetheaItems.clawTemplate, 4, new ItemStack(VetheaItems.darvenClaw));
		addRecipe(VetheaItems.cermileLump, VetheaItems.clawTemplate, 6, new ItemStack(VetheaItems.cermileClaw));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.clawTemplate, 8, new ItemStack(VetheaItems.pardimalClaw));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.clawTemplate, 10, new ItemStack(VetheaItems.quadroticClaw));
		addRecipe(VetheaItems.karosLump, VetheaItems.clawTemplate, 16, new ItemStack(VetheaItems.karosClaw));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.clawTemplate, 17, new ItemStack(VetheaItems.heliosisClaw));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.clawTemplate, 21, new ItemStack(VetheaItems.arksianeClaw));

		addRecipe(VetheaItems.teakerLump, VetheaItems.staffTemplate, 2, new ItemStack(VetheaItems.teakerStaff));
		addRecipe(VetheaItems.amthirmisLump, VetheaItems.staffTemplate, 3, new ItemStack(VetheaItems.amthrimisStaff));
		addRecipe(VetheaItems.darvenLump, VetheaItems.staffTemplate, 4, new ItemStack(VetheaItems.darvenStaff));
		addRecipe(VetheaItems.cermileLump, VetheaItems.staffTemplate, 6, new ItemStack(VetheaItems.cermileStaff));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.staffTemplate, 8, new ItemStack(VetheaItems.pardimalStaff));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.staffTemplate, 10, new ItemStack(VetheaItems.quadroticStaff));
		addRecipe(VetheaItems.karosLump, VetheaItems.staffTemplate, 16, new ItemStack(VetheaItems.karosStaff));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.staffTemplate, 17, new ItemStack(VetheaItems.heliosisStaff));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.staffTemplate, 21, new ItemStack(VetheaItems.arksianeStaff));

		addRecipe(VetheaItems.teakerLump, VetheaItems.diskTemplate, 4, new ItemStack(VetheaItems.teakerDisk));
		addRecipe(VetheaItems.amthirmisLump, VetheaItems.diskTemplate, 5, new ItemStack(VetheaItems.amthrimisDisk));
		addRecipe(VetheaItems.darvenLump, VetheaItems.diskTemplate, 6, new ItemStack(VetheaItems.darvenDisk));
		addRecipe(VetheaItems.cermileLump, VetheaItems.diskTemplate, 8, new ItemStack(VetheaItems.cermileDisk));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.diskTemplate, 11, new ItemStack(VetheaItems.pardimalDisk));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.diskTemplate, 13, new ItemStack(VetheaItems.quadroticDisk));
		addRecipe(VetheaItems.karosLump, VetheaItems.diskTemplate, 18, new ItemStack(VetheaItems.karosDisk));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.diskTemplate, 20, new ItemStack(VetheaItems.heliosisDisk));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.diskTemplate, 24, new ItemStack(VetheaItems.arksianeDisk));

		addRecipe(VetheaItems.teakerLump, VetheaItems.backswordTemplate, 4, new ItemStack(VetheaItems.teakerSword));
		addRecipe(VetheaItems.amthirmisLump, VetheaItems.backswordTemplate, 5, new ItemStack(VetheaItems.amthrimisSword));
		addRecipe(VetheaItems.darvenLump, VetheaItems.backswordTemplate, 6, new ItemStack(VetheaItems.darvenSword));
		addRecipe(VetheaItems.cermileLump, VetheaItems.backswordTemplate, 8, new ItemStack(VetheaItems.cermileSword));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.backswordTemplate, 11, new ItemStack(VetheaItems.pardimalSword));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.backswordTemplate, 13, new ItemStack(VetheaItems.quadroticSword));
		addRecipe(VetheaItems.karosLump, VetheaItems.backswordTemplate, 18, new ItemStack(VetheaItems.karosSword));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.backswordTemplate, 20, new ItemStack(VetheaItems.heliosisSword));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.backswordTemplate, 24, new ItemStack(VetheaItems.arksianeSword));

		addRecipe(VetheaItems.teakerLump, VetheaItems.hammerTemplate, 7, new ItemStack(VetheaItems.teakerHammer));
		addRecipe(VetheaItems.amthirmisLump, VetheaItems.hammerTemplate, 9, new ItemStack(VetheaItems.amthrimisHammer));
		addRecipe(VetheaItems.darvenLump, VetheaItems.hammerTemplate, 11, new ItemStack(VetheaItems.darvenHammer));
		addRecipe(VetheaItems.cermileLump, VetheaItems.hammerTemplate, 14, new ItemStack(VetheaItems.cermileHammer));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.hammerTemplate, 17, new ItemStack(VetheaItems.pardimalHammer));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.hammerTemplate, 19, new ItemStack(VetheaItems.quadroticHammer));
		addRecipe(VetheaItems.karosLump, VetheaItems.hammerTemplate, 22, new ItemStack(VetheaItems.karosHammer));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.hammerTemplate, 27, new ItemStack(VetheaItems.heliosisHammer));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.hammerTemplate, 31, new ItemStack(VetheaItems.arksianeHammer));

		addRecipe(VetheaItems.teakerLump, VetheaItems.cannonTemplate, 7, new ItemStack(VetheaItems.teakerCannon));
		addRecipe(VetheaItems.amthirmisLump, VetheaItems.cannonTemplate, 9, new ItemStack(VetheaItems.amthrimisCannon));
		addRecipe(VetheaItems.darvenLump, VetheaItems.cannonTemplate, 11, new ItemStack(VetheaItems.darvenCannon));
		addRecipe(VetheaItems.cermileLump, VetheaItems.cannonTemplate, 14, new ItemStack(VetheaItems.cermileCannon));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.cannonTemplate, 17, new ItemStack(VetheaItems.pardimalCannon));
		addRecipe(VetheaItems.quadroticLump, VetheaItems.cannonTemplate, 19, new ItemStack(VetheaItems.quadroticCannon));
		addRecipe(VetheaItems.karosLump, VetheaItems.cannonTemplate, 22, new ItemStack(VetheaItems.karosCannon));
		addRecipe(VetheaItems.heliosisLump, VetheaItems.cannonTemplate, 27, new ItemStack(VetheaItems.heliosisCannon));
		addRecipe(VetheaItems.arksianeLump, VetheaItems.cannonTemplate, 31, new ItemStack(VetheaItems.arksianeCannon));

		addRecipe(VetheaItems.teakerLump, VetheaItems.degradedTemplate, 8, new ItemStack(VetheaItems.degradedHelmet));
		addRecipe(VetheaItems.teakerLump, VetheaItems.degradedTemplate, 6, new ItemStack(VetheaItems.degradedHood));
		addRecipe(VetheaItems.teakerLump, VetheaItems.degradedTemplate, 9, new ItemStack(VetheaItems.degradedMask));
		addRecipe(VetheaItems.teakerLump, VetheaItems.degradedTemplate, 5, new ItemStack(VetheaItems.degradedBoots));
		addRecipe(VetheaItems.teakerLump, VetheaItems.degradedTemplate, 8, new ItemStack(VetheaItems.degradedLegs));
		addRecipe(VetheaItems.teakerLump, VetheaItems.degradedTemplate, 10, new ItemStack(VetheaItems.degradedBody));

		addRecipe(VetheaItems.amthirmisLump, VetheaItems.finishedTemplate, 12, new ItemStack(VetheaItems.finishedHelmet));
		addRecipe(VetheaItems.amthirmisLump, VetheaItems.finishedTemplate, 9, new ItemStack(VetheaItems.finishedHood));
		addRecipe(VetheaItems.amthirmisLump, VetheaItems.finishedTemplate, 13, new ItemStack(VetheaItems.finishedMask));
		addRecipe(VetheaItems.amthirmisLump, VetheaItems.finishedTemplate, 8, new ItemStack(VetheaItems.finishedBoots));
		addRecipe(VetheaItems.amthirmisLump, VetheaItems.finishedTemplate, 12, new ItemStack(VetheaItems.finishedLegs));
		addRecipe(VetheaItems.amthirmisLump, VetheaItems.finishedTemplate, 14, new ItemStack(VetheaItems.finishedBody));

		addRecipe(VetheaItems.darvenLump, VetheaItems.glisteningTemplate, 10, new ItemStack(VetheaItems.glisteningHelmet));
		addRecipe(VetheaItems.darvenLump, VetheaItems.glisteningTemplate, 11, new ItemStack(VetheaItems.glisteningHood));
		addRecipe(VetheaItems.darvenLump, VetheaItems.glisteningTemplate, 9, new ItemStack(VetheaItems.glisteningMask));
		addRecipe(VetheaItems.darvenLump, VetheaItems.glisteningTemplate, 8, new ItemStack(VetheaItems.glisteningBoots));
		addRecipe(VetheaItems.darvenLump, VetheaItems.glisteningTemplate, 12, new ItemStack(VetheaItems.glisteningLegs));
		addRecipe(VetheaItems.darvenLump, VetheaItems.glisteningTemplate, 14, new ItemStack(VetheaItems.glisteningBody));

		addRecipe(VetheaItems.cermileLump, VetheaItems.demonizedTemplate, 10, new ItemStack(VetheaItems.demonizedHelmet));
		addRecipe(VetheaItems.cermileLump, VetheaItems.demonizedTemplate, 11, new ItemStack(VetheaItems.demonizedHood));
		addRecipe(VetheaItems.cermileLump, VetheaItems.demonizedTemplate, 9, new ItemStack(VetheaItems.demonizedMask));
		addRecipe(VetheaItems.cermileLump, VetheaItems.demonizedTemplate, 8, new ItemStack(VetheaItems.demonizedBoots));
		addRecipe(VetheaItems.cermileLump, VetheaItems.demonizedTemplate, 12, new ItemStack(VetheaItems.demonizedLegs));
		addRecipe(VetheaItems.cermileLump, VetheaItems.demonizedTemplate, 14, new ItemStack(VetheaItems.demonizedBody));

		addRecipe(VetheaItems.pardimalLump, VetheaItems.tormentedTemplate, 10, new ItemStack(VetheaItems.tormentedHelmet));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.tormentedTemplate, 11, new ItemStack(VetheaItems.tormentedHood));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.tormentedTemplate, 9, new ItemStack(VetheaItems.tormentedMask));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.tormentedTemplate, 8, new ItemStack(VetheaItems.tormentedBoots));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.tormentedTemplate, 12, new ItemStack(VetheaItems.tormentedLegs));
		addRecipe(VetheaItems.pardimalLump, VetheaItems.tormentedTemplate, 14, new ItemStack(VetheaItems.tormentedBody));
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
