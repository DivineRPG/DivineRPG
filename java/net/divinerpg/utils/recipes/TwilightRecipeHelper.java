package net.divinerpg.utils.recipes;

import net.divinerpg.DivineRPG;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.init.Items;

public class TwilightRecipeHelper extends RecipeUtil {
	
	public static void init() {
		addShapelessRecipe(IS.edenFragments, TwilightItemsOther.edenSoul);
		addShapelessRecipe(IS.wildwoodFragments, TwilightItemsOther.wildwoodSoul);
		addShapelessRecipe(IS.apalachiaFragments, TwilightItemsOther.apalachiaSoul);
		addShapelessRecipe(IS.skythernFragments, TwilightItemsOther.skythernSoul);
		addShapelessRecipe(IS.mortumFragments, TwilightItemsOther.mortumSoul);
		
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

		//Eden (Dravite)
		addRecipe(IS.edenHead, "III", "I I", "  ", 'I', TwilightItemsOther.edenChunk);
		addRecipe(IS.edenBody, "I I", "III", "III", 'I', TwilightItemsOther.edenChunk);
		addRecipe(IS.edenLegs, "III", "I I", "I I", 'I', TwilightItemsOther.edenChunk);
		addRecipe(IS.edenFeet, "   ", "I I", "I I", 'I', TwilightItemsOther.edenChunk);

		//wildwood (Azurite)
		addRecipe(IS.wildwoodHead, "III", "I I", "   ", 'I', TwilightItemsOther.wildwoodChunk);
		addRecipe(IS.wildwoodBody, "I I", "III", "III", 'I', TwilightItemsOther.wildwoodChunk);
		addRecipe(IS.wildwoodLegs, "III", "I I", "I I", 'I', TwilightItemsOther.wildwoodChunk);
		addRecipe(IS.wildwoodFeet, "   ", "I I", "I I", 'I', TwilightItemsOther.wildwoodChunk);

		//Apalachia (Uvite)
		addRecipe(IS.apalachiaHead, "III", "I I", "   ", 'I', TwilightItemsOther.apalachiaChunk);
		addRecipe(IS.apalachiaBody, "I I", "III", "III", 'I', TwilightItemsOther.apalachiaChunk);
		addRecipe(IS.apalachiaLegs, "III", "I I", "I I", 'I', TwilightItemsOther.apalachiaChunk);
		addRecipe(IS.apalachiaFeet, "   ", "I I", "I I", 'I', TwilightItemsOther.apalachiaChunk);

		//Skythern (Mythril)
		addRecipe(IS.skythernHead, "III", "I I", "   ", 'I', TwilightItemsOther.skythernChunk);	
		addRecipe(IS.skythernBody, "I I", "III", "III", 'I', TwilightItemsOther.skythernChunk);
		addRecipe(IS.skythernLegs, "III", "I I", "I I", 'I', TwilightItemsOther.skythernChunk);
		addRecipe(IS.skythernFeet, "   ", "I I", "I I", 'I', TwilightItemsOther.skythernChunk);

		//Mortum (Augite)
		addRecipe(IS.mortumHead, "III", "I I", "I I", 'I', TwilightItemsOther.mortumChunk);
		addRecipe(IS.mortumBody, "I I", "III", "III", 'I', TwilightItemsOther.mortumChunk);
		addRecipe(IS.mortumLegs, "III", "I I", "I I", 'I', TwilightItemsOther.mortumChunk);
		addRecipe(IS.mortumFeet, "   ", "I I", "I I", 'I', TwilightItemsOther.mortumChunk);

		/* Weapons and other Stuff */

		//Eden
		addRecipe(IS.edenBlade, " I ", "III", " S ", 'I', TwilightItemsOther.edenChunk, 'S', Items.stick);
		addRecipe(IS.edenBow, " IX", "I X", " IX", 'I', TwilightItemsOther.edenChunk, 'X', Items.string);
		addRecipe(IS.edenPhaser, " X ", "XXX", " X ", 'X', TwilightItemsOther.edenChunk);
		addRecipe(IS.edenBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.edenChunk);
		addShapelessRecipe(IS.edenSlicer, TwilightItemsOther.edenGem);
		addRecipe(IS.edenArrow, " I ", " S ", " Z ", 'I', TwilightItemsOther.edenFragments, 'S', Items.stick, 'Z', Items.feather);

		//wildwood
		addRecipe(IS.wildwoodBlade, " I ", "III", " S ", 'I', TwilightItemsOther.wildwoodChunk, 'S', Items.stick);
		addRecipe(IS.wildwoodBow, " IX", "I X", " IX", 'I', TwilightItemsOther.wildwoodChunk, 'X', Items.string);
		addRecipe(IS.wildwoodPhaser, " X ", "XXX", " X ", 'X', TwilightItemsOther.wildwoodChunk);
		addRecipe(IS.wildwoodBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.wildwoodChunk);
		addShapelessRecipe(IS.wildwoodSlicer, TwilightItemsOther.wildwoodGem);
		addRecipe(IS.wildwoodArrow, " I ", " S ", " Z ", 'I', TwilightItemsOther.wildwoodFragments, 'S', Items.stick, 'Z', Items.feather);
		//Apalachia
		addRecipe(IS.apalachiaBlade, " I ", "III", " S ", 'I', TwilightItemsOther.apalachiaChunk, 'S', Items.stick);
		addRecipe(IS.apalachiaBow, " IX", "I X", " IX", 'I', TwilightItemsOther.apalachiaChunk, 'X', Items.string);
		addRecipe(IS.apalachiaPhaser, " X ", "XXX", " X ", 'X', TwilightItemsOther.apalachiaChunk);
		addRecipe(IS.apalachiaBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.apalachiaChunk);
		addShapelessRecipe(IS.apalachiaSlicer, TwilightItemsOther.apalachiaGem);
		addRecipe(IS.apalachiaArrow, " I ", " S ", " Z ", 'I', TwilightItemsOther.wildwoodFragments, 'S', Items.stick, 'Z', Items.feather);

		//Skythern
		addRecipe(IS.skythernBlade, " I ", "III", " S ", 'I', TwilightItemsOther.skythernChunk, 'S', Items.stick);
		addRecipe(IS.skythernBow, " IX", "I X", " IX", 'I', TwilightItemsOther.skythernChunk, 'X', Items.string);
		addRecipe(IS.skythernPhaser, " X ", "XXX", " X ", 'X', TwilightItemsOther.skythernChunk);
		addRecipe(IS.skythernBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.skythernChunk);
		addShapelessRecipe(IS.skythernSlicer, TwilightItemsOther.skythernGem);
		addRecipe(IS.skythernArrow, " I ", " S ", " Z ", 'I', TwilightItemsOther.skythernFragments, 'S', Items.stick, 'Z', Items.feather);

		//Mortum
		addRecipe(IS.mortumBlade, " I ", "III", " S ", 'I', TwilightItemsOther.mortumChunk, 'S', Items.stick);
		addRecipe(IS.mortumBow, " IX", "I X", " IX", 'I', TwilightItemsOther.mortumChunk, 'X', Items.string);
		addRecipe(IS.mortumPhaser, " X ", "XXX", " X ", 'X', TwilightItemsOther.mortumChunk);
		addRecipe(IS.mortumBlitz, "X X", "X X", "XXX", 'X', TwilightItemsOther.mortumChunk);
		addShapelessRecipe(IS.mortumSlicer, TwilightItemsOther.mortumGem);
		addRecipe(IS.mortumArrow, " I ", " S ", " Z ", 'I', TwilightItemsOther.mortumFragments, 'S', Items.stick, 'Z', Items.feather);


	}
}

