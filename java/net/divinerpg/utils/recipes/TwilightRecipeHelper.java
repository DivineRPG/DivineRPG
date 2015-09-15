package net.divinerpg.utils.recipes;

import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.items.TwilightItemsTools;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TwilightRecipeHelper extends RecipeUtil {
	
	public static void init() {

		/* Dust, Fragments, Gems and Souls */

		addShapelessRecipe(TwilightItemsOther.edenFragments, TwilightItemsOther.edenSoul);
		addShapelessRecipe(TwilightItemsOther.wildwoodFragments, TwilightItemsOther.wildwoodSoul);
		addShapelessRecipe(TwilightItemsOther.apalachiaFragments, TwilightItemsOther.apalachiaSoul);
		addShapelessRecipe(TwilightItemsOther.skythernFragments, TwilightItemsOther.skythernSoul);
		addShapelessRecipe(TwilightItemsOther.mortumFragments, TwilightItemsOther.mortumSoul);
		
		addRecipe(TwilightItemsOther.edenGem, "GGG", 'G', TwilightItemsOther.edenFragments);
		addRecipe(TwilightItemsOther.wildwoodGem, "GGG", 'G', TwilightItemsOther.wildwoodFragments);
		addRecipe(TwilightItemsOther.apalachiaGem, "GGG", 'G', TwilightItemsOther.apalachiaFragments);
		addRecipe(TwilightItemsOther.skythernGem, "GGG", 'G', TwilightItemsOther.skythernFragments);
		addRecipe(TwilightItemsOther.mortumGem, "GGG", 'G', TwilightItemsOther.mortumFragments);
		
		addSmelting(TwilightItemsOther.edenFragments, TwilightItemsOther.edenSparkles, 1);
		
		addRecipe(TwilightItemsOther.edenChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.edenGem);
		addRecipe(TwilightItemsOther.wildwoodChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.wildwoodGem);
		addRecipe(TwilightItemsOther.apalachiaChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.apalachiaGem);
		addRecipe(TwilightItemsOther.skythernChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.skythernGem);
		addRecipe(TwilightItemsOther.mortumChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.mortumGem);
		
		addShapelessRecipe(VanillaBlocks.divineRock, VanillaItemsOther.divineShards, Blocks.stone);
		addRecipe(TwilightBlocks.edenBlock, "III", "III", "III", 'I', TwilightItemsOther.edenFragments);
		addRecipe(TwilightBlocks.wildwoodBlock, "III", "III", "III", 'I', TwilightItemsOther.wildwoodFragments);
		addRecipe(TwilightBlocks.apalachiaBlock, "III", "III", "III", 'I', TwilightItemsOther.apalachiaFragments);
		addRecipe(TwilightBlocks.skythernBlock, "III", "III", "III", 'I', TwilightItemsOther.skythernFragments);
		addRecipe(TwilightBlocks.mortumBlock, "III", "III", "III", 'I', TwilightItemsOther.mortumFragments);
		
		addSmelting(TwilightBlocks.edenOre, TwilightItemsOther.edenFragments, 0.7F);
		addSmelting(TwilightBlocks.wildwoodOre, TwilightItemsOther.wildwoodFragments, 1.0F);
		addSmelting(TwilightBlocks.apalachiaOre, TwilightItemsOther.apalachiaFragments, 1.3F);
		addSmelting(TwilightBlocks.skythernOre, TwilightItemsOther.skythernFragments, 1.7F);
		addSmelting(TwilightBlocks.mortumOre, TwilightItemsOther.mortumFragments, 2.0F);
		
		addShapelessRecipe(TwilightItemsOther.edenDust, TwilightBlocks.sunbloom);
		addShapelessRecipe(TwilightItemsOther.edenDust, TwilightBlocks.edenBrush);
		addShapelessRecipe(TwilightItemsOther.edenDust, TwilightBlocks.sunBlossom);
		addShapelessRecipe(TwilightItemsOther.wildwoodDust, TwilightBlocks.moonlightFern);
		addShapelessRecipe(TwilightItemsOther.wildwoodDust, TwilightBlocks.moonBud);
		addShapelessRecipe(TwilightItemsOther.wildwoodDust, TwilightBlocks.wildwoodTallgrass);
		addShapelessRecipe(TwilightItemsOther.apalachiaDust, TwilightBlocks.duskFlower);
		addShapelessRecipe(TwilightItemsOther.apalachiaDust, TwilightBlocks.apalachiaTallgrass);
		addShapelessRecipe(TwilightItemsOther.skythernDust, TwilightBlocks.skythernBrush);
		addShapelessRecipe(TwilightItemsOther.skythernDust, TwilightBlocks.dustBrambles);
		addShapelessRecipe(TwilightItemsOther.skythernDust, TwilightBlocks.dustLily);
		addShapelessRecipe(TwilightItemsOther.mortumDust, TwilightBlocks.eyePlant);
		addShapelessRecipe(TwilightItemsOther.mortumDust, TwilightBlocks.mortumBrush);
		addShapelessRecipe(TwilightItemsOther.mortumDust, TwilightBlocks.demonBrambles);
		
		addShapelessRecipe(new ItemStack(TwilightBlocks.edenPlanks, 4), TwilightBlocks.edenLogs);
		addShapelessRecipe(new ItemStack(TwilightBlocks.wildwoodPlanks, 4), TwilightBlocks.wildwoodLogs);
		addShapelessRecipe(new ItemStack(TwilightBlocks.apalachiaPlanks, 4), TwilightBlocks.apalachiaLogs);
		addShapelessRecipe(new ItemStack(TwilightBlocks.skythernPlanks, 4), TwilightBlocks.skythernLogs);
		addShapelessRecipe(new ItemStack(TwilightBlocks.mortumPlanks, 4), TwilightBlocks.mortumLogs);
		
		addStairRecipe(TwilightBlocks.edenPlanks, TwilightBlocks.edenStairs);
		addStairRecipe(TwilightBlocks.wildwoodPlanks, TwilightBlocks.wildwoodStairs);
		addStairRecipe(TwilightBlocks.apalachiaPlanks, TwilightBlocks.apalachiaStairs);
		addStairRecipe(TwilightBlocks.skythernPlanks, TwilightBlocks.skythernStairs);
		addStairRecipe(TwilightBlocks.mortumPlanks, TwilightBlocks.mortumStairs);
		
		addSlabRecipe(TwilightBlocks.edenPlanks, TwilightBlocks.edenSlab);
        addSlabRecipe(TwilightBlocks.wildwoodPlanks, TwilightBlocks.wildwoodSlab);
        addSlabRecipe(TwilightBlocks.apalachiaPlanks, TwilightBlocks.apalachiaSlab);
        addSlabRecipe(TwilightBlocks.skythernPlanks, TwilightBlocks.skythernSlab);
        addSlabRecipe(TwilightBlocks.mortumPlanks, TwilightBlocks.mortumSlab);
		
		/* Armor */

		//Eden (Dravite)
		addRecipe(TwilightItemsArmor.edenHelmet, "III", "I I", 'I', TwilightItemsOther.edenChunk);
		addRecipe(TwilightItemsArmor.edenChestplate, "I I", "III", "III", 'I', TwilightItemsOther.edenChunk);
		addRecipe(TwilightItemsArmor.edenLeggings, "III", "I I", "I I", 'I', TwilightItemsOther.edenChunk);
		addRecipe(TwilightItemsArmor.edenBoots, "   ", "I I", "I I", 'I', TwilightItemsOther.edenChunk);

		//wildwood (Azurite)
		addRecipe(TwilightItemsArmor.wildwoodHelmet, "III", "I I", 'I', TwilightItemsOther.wildwoodChunk);
		addRecipe(TwilightItemsArmor.wildwoodChestplate, "I I", "III", "III", 'I', TwilightItemsOther.wildwoodChunk);
		addRecipe(TwilightItemsArmor.wildwoodLeggings, "III", "I I", "I I", 'I', TwilightItemsOther.wildwoodChunk);
		addRecipe(TwilightItemsArmor.wildwoodBoots, "   ", "I I", "I I", 'I', TwilightItemsOther.wildwoodChunk);

		//Apalachia (Uvite)
		addRecipe(TwilightItemsArmor.apalachiaHelmet, "III", "I I", 'I', TwilightItemsOther.apalachiaChunk);
		addRecipe(TwilightItemsArmor.apalachiaChestplate, "I I", "III", "III", 'I', TwilightItemsOther.apalachiaChunk);
		addRecipe(TwilightItemsArmor.apalachiaLeggings, "III", "I I", "I I", 'I', TwilightItemsOther.apalachiaChunk);
		addRecipe(TwilightItemsArmor.apalachiaBoots, "   ", "I I", "I I", 'I', TwilightItemsOther.apalachiaChunk);

		//Skythern (Mythril)
		addRecipe(TwilightItemsArmor.skythernHelmet, "III", "I I", 'I', TwilightItemsOther.skythernChunk);	
		addRecipe(TwilightItemsArmor.skythernChestplate, "I I", "III", "III", 'I', TwilightItemsOther.skythernChunk);
		addRecipe(TwilightItemsArmor.skythernLeggings, "III", "I I", "I I", 'I', TwilightItemsOther.skythernChunk);
		addRecipe(TwilightItemsArmor.skythernBoots, "   ", "I I", "I I", 'I', TwilightItemsOther.skythernChunk);

		//Mortum (Augite)
		addRecipe(TwilightItemsArmor.mortumHelmet, "III", "I I", 'I', TwilightItemsOther.mortumChunk);
		addRecipe(TwilightItemsArmor.mortumChestplate, "I I", "III", "III", 'I', TwilightItemsOther.mortumChunk);
		addRecipe(TwilightItemsArmor.mortumLeggings, "III", "I I", "I I", 'I', TwilightItemsOther.mortumChunk);
		addRecipe(TwilightItemsArmor.mortumBoots, "   ", "I I", "I I", 'I', TwilightItemsOther.mortumChunk);

		/* Weapons and Tools */

		//Eden
		addOredictRecipe(TwilightItemsWeapons.edenBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.edenChunk, 'S', "stickWood");
		addRecipe(TwilightItemsWeapons.edenBow, " IX", "I X", " IX", 'I', TwilightItemsOther.edenChunk, 'X', Items.string);
		addOredictRecipe(TwilightItemsWeapons.edenPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.edenChunk, 'S', "stickWood");
		addRecipe(TwilightItemsWeapons.edenBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.edenChunk);
		addShapelessRecipe(new ItemStack(TwilightItemsWeapons.edenSlicer, 20), TwilightItemsOther.edenGem);
		addOredictRecipe(new ItemStack(TwilightItemsWeapons.edenArrow, 4), " I ", " S ", " Z ", 'I', TwilightItemsOther.edenFragments, 'S', "stickWood", 'Z', Items.feather);

		//wildwood
		addOredictRecipe(TwilightItemsWeapons.wildwoodBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.wildwoodChunk, 'S', "stickWood");
		addRecipe(TwilightItemsWeapons.wildwoodBow, " IX", "I X", " IX", 'I', TwilightItemsOther.wildwoodChunk, 'X', Items.string);
		addOredictRecipe(TwilightItemsWeapons.wildwoodPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.wildwoodChunk, 'S', "stickWood");
		addRecipe(TwilightItemsWeapons.wildwoodBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.wildwoodChunk);
		addShapelessRecipe(new ItemStack(TwilightItemsWeapons.wildwoodSlicer, 20), TwilightItemsOther.wildwoodGem);
		addOredictRecipe(new ItemStack(TwilightItemsWeapons.wildwoodArrow, 4), " I ", " S ", " Z ", 'I', TwilightItemsOther.wildwoodFragments, 'S', "stickWood", 'Z', Items.feather);

		//Apalachia
		addOredictRecipe(TwilightItemsWeapons.apalachiaBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.apalachiaChunk, 'S', "stickWood");
		addRecipe(TwilightItemsWeapons.apalachiaBow, " IX", "I X", " IX", 'I', TwilightItemsOther.apalachiaChunk, 'X', Items.string);
		addOredictRecipe(TwilightItemsWeapons.apalachiaPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.apalachiaChunk, 'S', "stickWood");
		addRecipe(TwilightItemsWeapons.apalachiaBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.apalachiaChunk);
		addShapelessRecipe(new ItemStack(TwilightItemsWeapons.apalachiaSlicer, 20), TwilightItemsOther.apalachiaGem);

		//Skythern
		addOredictRecipe(TwilightItemsWeapons.skythernBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.skythernChunk, 'S', "stickWood");
		addRecipe(TwilightItemsWeapons.skythernBow, " IX", "I X", " IX", 'I', TwilightItemsOther.skythernChunk, 'X', Items.string);
		addOredictRecipe(TwilightItemsWeapons.skythernPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.skythernChunk, 'S', "stickWood");
		addRecipe(TwilightItemsWeapons.skythernBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.skythernChunk);
		addShapelessRecipe(new ItemStack(TwilightItemsWeapons.skythernSlicer, 20), TwilightItemsOther.skythernGem);

		//Mortum
		addOredictRecipe(TwilightItemsWeapons.mortumBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.mortumChunk, 'S', "stickWood");
		addRecipe(TwilightItemsWeapons.mortumBow, " IX", "I X", " IX", 'I', TwilightItemsOther.mortumChunk, 'X', Items.string);
		addOredictRecipe(TwilightItemsWeapons.mortumPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.mortumChunk, 'S', "stickWood");
		addRecipe(TwilightItemsWeapons.mortumBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.mortumChunk);
		addShapelessRecipe(new ItemStack(TwilightItemsWeapons.mortumSlicer, 20), TwilightItemsOther.mortumGem);
		addOredictRecipe(new ItemStack(TwilightItemsWeapons.furyArrow, 4), " I ", " S ", " Z ", 'I', TwilightItemsOther.mortumFragments, 'S', "stickWood", 'Z', Items.feather);
		
		//Tools
		addOredictRecipe(TwilightItemsTools.edenPickaxe, "III", " S ", " S ", 'I', TwilightItemsOther.edenChunk, 'S', "stickWood");
		addOredictRecipe(TwilightItemsTools.edenShovel, " I ", " S ", " S ", 'I', TwilightItemsOther.edenChunk, 'S', "stickWood");
		addOredictRecipe(TwilightItemsTools.edenAxe, "II ", "IS ", " S ", 'I', TwilightItemsOther.edenChunk, 'S', "stickWood");
		
		addOredictRecipe(TwilightItemsTools.wildwoodPickaxe, "III", " S ", " S ", 'I', TwilightItemsOther.wildwoodChunk, 'S', "stickWood");
		addOredictRecipe(TwilightItemsTools.wildwoodShovel, " I ", " S " , " S ", 'I', TwilightItemsOther.wildwoodChunk, 'S', "stickWood");
		addOredictRecipe(TwilightItemsTools.wildwoodAxe, "II ", "IS ", " S ", 'I', TwilightItemsOther.wildwoodChunk, 'S', "stickWood");
		
		addOredictRecipe(TwilightItemsTools.apalachiaPickaxe, "III", " S ", " S ", 'I', TwilightItemsOther.apalachiaChunk, 'S', "stickWood");
		addOredictRecipe(TwilightItemsTools.apalachiaShovel, " I ", " S ", " S ", 'I', TwilightItemsOther.apalachiaChunk, 'S', "stickWood");
		addOredictRecipe(TwilightItemsTools.apalachiaAxe, "II ", "IS ", " S ", 'I', TwilightItemsOther.apalachiaChunk, 'S', "stickWood");
		
		addOredictRecipe(TwilightItemsTools.skythernPickaxe, "III", " S ", " S ", 'I', TwilightItemsOther.skythernChunk, 'S', "stickWood");
		addOredictRecipe(TwilightItemsTools.skythernShovel, " I ", " S ", " S ", 'I', TwilightItemsOther.skythernChunk, 'S', "stickWood");
		addOredictRecipe(TwilightItemsTools.skythernAxe, "II ", "IS ", " S ", 'I', TwilightItemsOther.skythernChunk, 'S', "stickWood");
		
		addOredictRecipe(TwilightItemsTools.mortumPickaxe, "III", " S ", " S ", 'I', TwilightItemsOther.mortumChunk, 'S', "stickWood");
		addOredictRecipe(TwilightItemsTools.mortumShovel, " I ", " S ", " S ", 'I', TwilightItemsOther.mortumChunk, 'S', "stickWood");
		addOredictRecipe(TwilightItemsTools.mortumAxe, "II ", "IS ", " S ", 'I', TwilightItemsOther.mortumChunk, 'S', "stickWood");
		
		/* Spawners and other stuff */
		addShapelessRecipe(TwilightItemsOther.baseSpawnCrystal, TwilightItemsOther.skythernSoul, TwilightItemsOther.skythernSoul, TwilightItemsOther.skythernSoul, TwilightItemsOther.skythernSoul, TwilightItemsOther.skythernSoul);
		addShapelessRecipe(TwilightItemsOther.reyvorCrystal, TwilightItemsOther.baseSpawnCrystal, TwilightItemsOther.mortumSoul, TwilightItemsOther.mortumSoul, TwilightItemsOther.edenSoul, TwilightItemsOther.wildwoodSoul);
		addShapelessRecipe(TwilightItemsOther.eternalArcherCrystal, TwilightItemsOther.baseSpawnCrystal, TwilightItemsOther.edenSoul, TwilightItemsOther.mortumSoul, TwilightItemsOther.edenSoul, TwilightItemsOther.wildwoodSoul);
		addShapelessRecipe(TwilightItemsOther.soulFiendCrystal, TwilightItemsOther.baseSpawnCrystal, TwilightItemsOther.apalachiaSoul, TwilightItemsOther.skythernSoul, TwilightItemsOther.wildwoodSoul, TwilightItemsOther.edenSoul);
		addShapelessRecipe(TwilightItemsOther.twilightDemonCrystal, TwilightItemsOther.baseSpawnCrystal, TwilightItemsOther.mortumSoul, TwilightItemsOther.mortumSoul, TwilightItemsOther.wildwoodSoul, TwilightItemsOther.skythernSoul);
		addShapelessRecipe(TwilightItemsOther.densosCrystal, TwilightItemsOther.baseSpawnCrystal, TwilightItemsOther.apalachiaSoul, TwilightItemsOther.mortumSoul, TwilightItemsOther.wildwoodSoul, TwilightItemsOther.skythernSoul);
		addShapelessRecipe(TwilightItemsOther.vamacheronCrystal, TwilightItemsOther.baseSpawnCrystal, TwilightItemsOther.mortumSoul, TwilightItemsOther.mortumSoul, TwilightItemsOther.mortumSoul, TwilightItemsOther.mortumSoul);
		addShapelessRecipe(TwilightItemsOther.karotCrystal, TwilightItemsOther.baseSpawnCrystal, TwilightItemsOther.apalachiaSoul, TwilightItemsOther.mortumSoul, TwilightItemsOther.mortumSoul, TwilightItemsOther.skythernSoul);

		addRecipe(TwilightBlocks.edenChest, "bbb", "b b", "bbb", 'b', TwilightItemsOther.edenFragments);
		addRecipe(VetheaItems.nightmareBed, "MMM", "WWW", 'M', TwilightBlocks.mortumBlock, 'W', TwilightBlocks.mortumLogs);
		addRecipe(new ItemStack(TwilightBlocks.apalachiaRails, 8), "F F", "FFF", "F F", 'F', TwilightItemsOther.apalachiaFragments);
	}
}

