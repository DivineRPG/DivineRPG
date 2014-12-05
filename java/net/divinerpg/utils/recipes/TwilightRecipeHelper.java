package net.divinerpg.utils.recipes;

import net.divinerpg.DivineRPG;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.items.TwilightItemsTools;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class TwilightRecipeHelper extends RecipeUtil {
	
	public static void init() {
		addShapelessRecipe(TwilightItemsOther.edenFragments, TwilightItemsOther.edenSoul);
		addShapelessRecipe(TwilightItemsOther.wildwoodFragments, TwilightItemsOther.wildwoodSoul);
		addShapelessRecipe(TwilightItemsOther.apalachiaFragments, TwilightItemsOther.apalachiaSoul);
		addShapelessRecipe(TwilightItemsOther.skythernFragments, TwilightItemsOther.skythernSoul);
		addShapelessRecipe(TwilightItemsOther.mortumFragments, TwilightItemsOther.mortumSoul);
		
		addRecipe(IS.edenGem, "GGG", 'G', TwilightItemsOther.edenFragments);
		addRecipe(IS.wildwoodGem, "GGG", 'G', TwilightItemsOther.wildwoodFragments);
		addRecipe(IS.apalachiaGem, "GGG", 'G', TwilightItemsOther.apalachiaFragments);
		addRecipe(IS.skythernGem, "GGG", 'G', TwilightItemsOther.skythernFragments);
		addRecipe(IS.mortumGem, "GGG", 'G', TwilightItemsOther.mortumFragments);
		
		addRecipe(IS.edenChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.edenGem);
		addRecipe(IS.wildwoodChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.wildwoodGem);
		addRecipe(IS.apalachiaChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.apalachiaGem);
		addRecipe(IS.skythernChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.skythernGem);
		addRecipe(IS.mortumChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.mortumGem);
		
		addShapelessRecipe(VanillaBlocks.divineRock, VanillaItemsOther.divineShards, Blocks.stone);
		addRecipe(TwilightBlocks.edenBlock, "III", "III", "III", 'I', TwilightItemsOther.edenFragments);
		addRecipe(TwilightBlocks.wildwoodBlock, "III", "III", "III", 'I', TwilightItemsOther.wildwoodFragments);
		addRecipe(TwilightBlocks.apalachiaBlock, "III", "III", "III", 'I', TwilightItemsOther.apalachiaFragments);
		addRecipe(TwilightBlocks.skythernBlock, "III", "III", "III", 'I', TwilightItemsOther.skythernFragments);
		addRecipe(TwilightBlocks.mortumBlock, "III", "III", "III", 'I', TwilightItemsOther.mortumFragments);

		//Eden (Dravite)
		addRecipe(IS.edenHead, "III", "III", "I I", 'I', TwilightItemsOther.edenChunk);
		addRecipe(IS.edenBody, "III", "III", " I ", 'I', TwilightItemsOther.edenChunk);
		addRecipe(IS.edenLegs, "III", "I I", "I I", 'I', TwilightItemsOther.edenChunk);
		addRecipe(IS.edenFeet, "   ", "I I", "I I", 'I', TwilightItemsOther.edenChunk);

		//wildwood (Azurite)
		addRecipe(IS.wildwoodHead, "III", "III", "I I", 'I', TwilightItemsOther.wildwoodChunk);
		addRecipe(IS.wildwoodBody, "III", "III", " I ", 'I', TwilightItemsOther.wildwoodChunk);
		addRecipe(IS.wildwoodLegs, "III", "I I", "I I", 'I', TwilightItemsOther.wildwoodChunk);
		addRecipe(IS.wildwoodFeet, "   ", "I I", "I I", 'I', TwilightItemsOther.wildwoodChunk);

		//Apalachia (Uvite)
		addRecipe(IS.apalachiaHead, "III", "III", "I I", 'I', TwilightItemsOther.apalachiaChunk);
		addRecipe(IS.apalachiaBody, "III", "III", " I ", 'I', TwilightItemsOther.apalachiaChunk);
		addRecipe(IS.apalachiaLegs, "III", "I I", "I I", 'I', TwilightItemsOther.apalachiaChunk);
		addRecipe(IS.apalachiaFeet, "   ", "I I", "I I", 'I', TwilightItemsOther.apalachiaChunk);

		//Skythern (Mythril)
		addRecipe(IS.skythernHead, "III", "III", "I I", 'I', TwilightItemsOther.skythernChunk);	
		addRecipe(IS.skythernBody, "III", "III", " I ", 'I', TwilightItemsOther.skythernChunk);
		addRecipe(IS.skythernLegs, "III", "I I", "I I", 'I', TwilightItemsOther.skythernChunk);
		addRecipe(IS.skythernFeet, "   ", "I I", "I I", 'I', TwilightItemsOther.skythernChunk);

		//Mortum (Augite)
		addRecipe(IS.mortumHead, "III", "III", "I I", 'I', TwilightItemsOther.mortumChunk);
		addRecipe(IS.mortumBody, "III", "III", " I ", 'I', TwilightItemsOther.mortumChunk);
		addRecipe(IS.mortumLegs, "III", "I I", "I I", 'I', TwilightItemsOther.mortumChunk);
		addRecipe(IS.mortumFeet, "   ", "I I", "I I", 'I', TwilightItemsOther.mortumChunk);

		/* Weapons and other Stuff */

		//Eden
		addRecipe(IS.edenBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.edenChunk, 'S', Items.stick);
		addRecipe(IS.edenBow, " IX", "I X", " IX", 'I', TwilightItemsOther.edenChunk, 'X', Items.string);
		addRecipe(IS.edenPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.edenChunk, 'S', Items.stick);
		addRecipe(IS.edenBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.edenChunk);
		addShapelessRecipe(IS.edenSlicer, TwilightItemsOther.edenGem);
		addRecipe(IS.edenArrow, " I ", " S ", " Z ", 'I', TwilightItemsOther.edenFragments, 'S', Items.stick, 'Z', Items.feather);

		//wildwood
		addRecipe(IS.wildwoodBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.wildwoodChunk, 'S', Items.stick);
		addRecipe(IS.wildwoodBow, " IX", "I X", " IX", 'I', TwilightItemsOther.wildwoodChunk, 'X', Items.string);
		addRecipe(IS.wildwoodPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.wildwoodChunk, 'S', Items.stick);
		addRecipe(IS.wildwoodBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.wildwoodChunk);
		addShapelessRecipe(IS.wildwoodSlicer, TwilightItemsOther.wildwoodGem);
		addRecipe(IS.wildwoodArrow, " I ", " S ", " Z ", 'I', TwilightItemsOther.wildwoodFragments, 'S', Items.stick, 'Z', Items.feather);
		//Apalachia
		addRecipe(IS.apalachiaBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.apalachiaChunk, 'S', Items.stick);
		addRecipe(IS.apalachiaBow, " IX", "I X", " IX", 'I', TwilightItemsOther.apalachiaChunk, 'X', Items.string);
		addRecipe(IS.apalachiaPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.apalachiaChunk, 'S', Items.stick);
		addRecipe(IS.apalachiaBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.apalachiaChunk);
		addShapelessRecipe(IS.apalachiaSlicer, TwilightItemsOther.apalachiaGem);

		//Skythern
		addRecipe(IS.skythernBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.skythernChunk, 'S', Items.stick);
		addRecipe(IS.skythernBow, " IX", "I X", " IX", 'I', TwilightItemsOther.skythernChunk, 'X', Items.string);
		addRecipe(IS.skythernPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.skythernChunk, 'S', Items.stick);
		addRecipe(IS.skythernBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.skythernChunk);
		addShapelessRecipe(IS.skythernSlicer, TwilightItemsOther.skythernGem);

		//Mortum
		addRecipe(IS.mortumBlade, " I ", " I ", " S ", 'I', TwilightItemsOther.mortumChunk, 'S', Items.stick);
		addRecipe(IS.mortumBow, " IX", "I X", " IX", 'I', TwilightItemsOther.mortumChunk, 'X', Items.string);
		addRecipe(IS.mortumPhaser, " X ", "XXX", " S ", 'X', TwilightItemsOther.mortumChunk, 'S', Items.stick);
		addRecipe(IS.mortumBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.mortumChunk);
		addShapelessRecipe(IS.mortumSlicer, TwilightItemsOther.mortumGem);
		addRecipe(IS.furyArrow, " I ", " S ", " Z ", 'I', TwilightItemsOther.mortumFragments, 'S', Items.stick, 'Z', Items.feather);
		
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
		
		

	}
}

