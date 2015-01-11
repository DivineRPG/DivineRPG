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
		
		addShapelessRecipe(TwilightItemsOther.edenDust, TwilightBlocks.sunbloom);
		addShapelessRecipe(TwilightItemsOther.edenDust, TwilightBlocks.edenBrush);
		addShapelessRecipe(TwilightItemsOther.edenDust, TwilightBlocks.sunBlossom);
		addShapelessRecipe(TwilightItemsOther.wildwoodDust, TwilightBlocks.moonlightFern);
		addShapelessRecipe(TwilightItemsOther.wildwoodDust, TwilightBlocks.moonBud);
		addShapelessRecipe(TwilightItemsOther.wildwoodDust, TwilightBlocks.wildwoodTallgrass);
		addShapelessRecipe(TwilightItemsOther.skythernDust, TwilightBlocks.skythernBrush);
		addShapelessRecipe(TwilightItemsOther.skythernDust, TwilightBlocks.dustBrambles);
		addShapelessRecipe(TwilightItemsOther.mortumDust, TwilightBlocks.eyePlant);
		addShapelessRecipe(TwilightItemsOther.mortumDust, TwilightBlocks.mortumBrush);
		addShapelessRecipe(TwilightItemsOther.mortumDust, TwilightBlocks.demonBrambles);
		
		addRecipe(TwilightBlocks.edenChest, "bbb", "b b", "bbb", 'b', TwilightItemsOther.edenFragments);

		//Eden (Dravite)
		addRecipe(TwilightItemsArmor.edenHelmet, "III", "III", "I I", 'I', TwilightItemsOther.edenChunk);
		addRecipe(TwilightItemsArmor.edenBody, "III", "III", " I ", 'I', TwilightItemsOther.edenChunk);
		addRecipe(TwilightItemsArmor.edenLegs, "III", "I I", "I I", 'I', TwilightItemsOther.edenChunk);
		addRecipe(TwilightItemsArmor.edenBoots, "   ", "I I", "I I", 'I', TwilightItemsOther.edenChunk);

		//wildwood (Azurite)
		addRecipe(TwilightItemsArmor.wildwoodHelmet, "III", "III", "I I", 'I', TwilightItemsOther.wildwoodChunk);
		addRecipe(TwilightItemsArmor.wildwoodBody, "III", "III", " I ", 'I', TwilightItemsOther.wildwoodChunk);
		addRecipe(TwilightItemsArmor.wildwoodLegs, "III", "I I", "I I", 'I', TwilightItemsOther.wildwoodChunk);
		addRecipe(TwilightItemsArmor.wildwoodBoots, "   ", "I I", "I I", 'I', TwilightItemsOther.wildwoodChunk);

		//Apalachia (Uvite)
		addRecipe(TwilightItemsArmor.apalachiaHelmet, "III", "III", "I I", 'I', TwilightItemsOther.apalachiaChunk);
		addRecipe(TwilightItemsArmor.apalachiaBody, "III", "III", " I ", 'I', TwilightItemsOther.apalachiaChunk);
		addRecipe(TwilightItemsArmor.apalachiaLegs, "III", "I I", "I I", 'I', TwilightItemsOther.apalachiaChunk);
		addRecipe(TwilightItemsArmor.apalachiaBoots, "   ", "I I", "I I", 'I', TwilightItemsOther.apalachiaChunk);

		//Skythern (Mythril)
		addRecipe(TwilightItemsArmor.skythernHelmet, "III", "III", "I I", 'I', TwilightItemsOther.skythernChunk);	
		addRecipe(TwilightItemsArmor.skythernBody, "III", "III", " I ", 'I', TwilightItemsOther.skythernChunk);
		addRecipe(TwilightItemsArmor.skythernLegs, "III", "I I", "I I", 'I', TwilightItemsOther.skythernChunk);
		addRecipe(TwilightItemsArmor.skythernBoots, "   ", "I I", "I I", 'I', TwilightItemsOther.skythernChunk);

		//Mortum (Augite)
		addRecipe(TwilightItemsArmor.mortumHelmet, "III", "III", "I I", 'I', TwilightItemsOther.mortumChunk);
		addRecipe(TwilightItemsArmor.mortumBody, "III", "III", " I ", 'I', TwilightItemsOther.mortumChunk);
		addRecipe(TwilightItemsArmor.mortumLegs, "III", "I I", "I I", 'I', TwilightItemsOther.mortumChunk);
		addRecipe(TwilightItemsArmor.mortumBoots, "   ", "I I", "I I", 'I', TwilightItemsOther.mortumChunk);

		/* Weapons and other Stuff */

		//Eden
		addRecipe(TwilightItemsWeapons.edenBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.edenChunk, 'S', Items.stick);
		addRecipe(TwilightItemsWeapons.edenBow, " IX", "I X", " IX", 'I', TwilightItemsOther.edenChunk, 'X', Items.string);
		addRecipe(TwilightItemsWeapons.edenPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.edenChunk, 'S', Items.stick);
		addRecipe(TwilightItemsWeapons.edenBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.edenChunk);
		addShapelessRecipe(TwilightItemsWeapons.edenSlicer, TwilightItemsOther.edenGem);
		addRecipe(TwilightItemsWeapons.edenArrow, " I ", " S ", " Z ", 'I', TwilightItemsOther.edenFragments, 'S', Items.stick, 'Z', Items.feather);

		//wildwood
		addRecipe(TwilightItemsWeapons.wildwoodBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.wildwoodChunk, 'S', Items.stick);
		addRecipe(TwilightItemsWeapons.wildwoodBow, " IX", "I X", " IX", 'I', TwilightItemsOther.wildwoodChunk, 'X', Items.string);
		addRecipe(TwilightItemsWeapons.wildwoodPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.wildwoodChunk, 'S', Items.stick);
		addRecipe(TwilightItemsWeapons.wildwoodBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.wildwoodChunk);
		addShapelessRecipe(TwilightItemsWeapons.wildwoodSlicer, TwilightItemsOther.wildwoodGem);
		addRecipe(TwilightItemsWeapons.wildwoodArrow, " I ", " S ", " Z ", 'I', TwilightItemsOther.wildwoodFragments, 'S', Items.stick, 'Z', Items.feather);
		//Apalachia
		addRecipe(TwilightItemsWeapons.apalachiaBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.apalachiaChunk, 'S', Items.stick);
		addRecipe(TwilightItemsWeapons.apalachiaBow, " IX", "I X", " IX", 'I', TwilightItemsOther.apalachiaChunk, 'X', Items.string);
		addRecipe(TwilightItemsWeapons.apalachiaPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.apalachiaChunk, 'S', Items.stick);
		addRecipe(TwilightItemsWeapons.apalachiaBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.apalachiaChunk);
		addShapelessRecipe(TwilightItemsWeapons.apalachiaSlicer, TwilightItemsOther.apalachiaGem);

		//Skythern
		addRecipe(TwilightItemsWeapons.skythernBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.skythernChunk, 'S', Items.stick);
		addRecipe(TwilightItemsWeapons.skythernBow, " IX", "I X", " IX", 'I', TwilightItemsOther.skythernChunk, 'X', Items.string);
		addRecipe(TwilightItemsWeapons.skythernPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.skythernChunk, 'S', Items.stick);
		addRecipe(TwilightItemsWeapons.skythernBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.skythernChunk);
		addShapelessRecipe(TwilightItemsWeapons.skythernSlicer, TwilightItemsOther.skythernGem);

		//Mortum
		addRecipe(TwilightItemsWeapons.mortumBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.mortumChunk, 'S', Items.stick);
		addRecipe(TwilightItemsWeapons.mortumBow, " IX", "I X", " IX", 'I', TwilightItemsOther.mortumChunk, 'X', Items.string);
		addRecipe(TwilightItemsWeapons.mortumPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.mortumChunk, 'S', Items.stick);
		addRecipe(TwilightItemsWeapons.mortumBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.mortumChunk);
		addShapelessRecipe(TwilightItemsWeapons.mortumSlicer, TwilightItemsOther.mortumGem);
		addRecipe(TwilightItemsWeapons.furyArrow, " I ", " S ", " Z ", 'I', TwilightItemsOther.mortumFragments, 'S', Items.stick, 'Z', Items.feather);
		
		//Tools
		addRecipe(TwilightItemsTools.edenPickaxe, "III", " S ", " S ", 'I', TwilightItemsOther.edenChunk, 'S', Items.stick);
		addRecipe(TwilightItemsTools.edenShovel, " I ", " S ", " S ", 'I', TwilightItemsOther.edenChunk, 'S', Items.stick);
		addRecipe(TwilightItemsTools.edenAxe, "II ", "IS ", " S ", 'I', TwilightItemsOther.edenChunk, 'S', Items.stick);
		addShapelessRecipe(TwilightItemsTools.edenShickaxe, TwilightItemsTools.edenPickaxe, TwilightItemsTools.edenShovel, TwilightItemsTools.edenAxe);
		
		addRecipe(TwilightItemsTools.wildwoodPickaxe, "III", " S ", " S ", 'I', TwilightItemsOther.wildwoodChunk, 'S', Items.stick);
		addRecipe(TwilightItemsTools.wildwoodShovel, " I ", " S " , " S ", 'I', TwilightItemsOther.wildwoodChunk, 'S', Items.stick);
		addRecipe(TwilightItemsTools.wildwoodAxe, "II ", "IS ", " S ", 'I', TwilightItemsOther.wildwoodChunk, 'S', Items.stick);
		addShapelessRecipe(TwilightItemsTools.wildwoodShickaxe, TwilightItemsTools.wildwoodPickaxe, TwilightItemsTools.wildwoodShovel, TwilightItemsTools.wildwoodAxe);
		
		addRecipe(TwilightItemsTools.apalachiaPickaxe, "III", " S ", " S ", 'I', TwilightItemsOther.apalachiaChunk, 'S', Items.stick);
		addRecipe(TwilightItemsTools.apalachiaShovel, " I ", " S ", " S ", 'I', TwilightItemsOther.apalachiaChunk, 'S', Items.stick);
		addRecipe(TwilightItemsTools.apalachiaAxe, "II ", "IS ", " S ", 'I', TwilightItemsOther.apalachiaChunk, 'S', Items.stick);
		addShapelessRecipe(TwilightItemsTools.apalachiaShickaxe, TwilightItemsTools.apalachiaPickaxe, TwilightItemsTools.apalachiaShovel, TwilightItemsTools.apalachiaAxe);
		
		addRecipe(TwilightItemsTools.skythernPickaxe, "III", " S ", " S ", 'I', TwilightItemsOther.skythernChunk, 'S', Items.stick);
		addRecipe(TwilightItemsTools.skythernShovel, " I ", " S ", " S ", 'I', TwilightItemsOther.skythernChunk, 'S', Items.stick);
		addRecipe(TwilightItemsTools.skythernAxe, "II ", "IS ", " S ", 'I', TwilightItemsOther.skythernChunk, 'S', Items.stick);
		addShapelessRecipe(TwilightItemsTools.skythernShickaxe, TwilightItemsTools.skythernPickaxe, TwilightItemsTools.skythernShovel, TwilightItemsTools.skythernAxe);
		
		addRecipe(TwilightItemsTools.mortumPickaxe, "III", " S ", " S ", 'I', TwilightItemsOther.mortumChunk, 'S', Items.stick);
		addRecipe(TwilightItemsTools.mortumShovel, " I ", " S ", " S ", 'I', TwilightItemsOther.mortumChunk, 'S', Items.stick);
		addRecipe(TwilightItemsTools.mortumAxe, "II ", "IS ", " S ", 'I', TwilightItemsOther.mortumChunk, 'S', Items.stick);
		addShapelessRecipe(TwilightItemsTools.mortumShickaxe, TwilightItemsTools.mortumPickaxe, TwilightItemsTools.mortumShovel, TwilightItemsTools.mortumAxe);
		
		addRecipe(VetheaItems.nightmareBed, "MMM", "WWW", 'M', TwilightBlocks.mortumBlock, 'W', TwilightBlocks.mortumLogs);

	}
}

