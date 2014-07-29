package net.divinerpg.utils.recipes;

import net.divinerpg.DivineRPG;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.items.VanillaItemsOther;

public class TwilightRecipeHelper extends DivineRPG {
	
	public static void init() {
		addShapelessRecipe(IS.edenFragments, TwilightItemsOther.edenSoul);
		addShapelessRecipe(IS.wildWoodFragments, TwilightItemsOther.wildWoodSoul);
		addShapelessRecipe(IS.apalachiaFragments, TwilightItemsOther.apalachiaSoul);
		addShapelessRecipe(IS.skythernFragments, TwilightItemsOther.skythernSoul);
		addShapelessRecipe(IS.mortumFragments, TwilightItemsOther.mortumSoul);
		
		addRecipe(IS.edenGem, "GGG", 'G', TwilightItemsOther.edenFragments);
		addRecipe(IS.wildWoodGem, "GGG", 'G', TwilightItemsOther.wildWoodFragments);
		addRecipe(IS.apalachiaGem, "GGG", 'G', TwilightItemsOther.apalachiaFragments);
		addRecipe(IS.skythernGem, "GGG", 'G', TwilightItemsOther.skythernFragments);
		addRecipe(IS.mortumGem, "GGG", 'G', TwilightItemsOther.mortumFragments);
		
		addRecipe(IS.edenChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.edenGem);
		addRecipe(IS.wildWoodChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.wildWoodGem);
		addRecipe(IS.apalachiaChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.apalachiaGem);
		addRecipe(IS.skythernChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.skythernGem);
		addRecipe(IS.mortumChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.mortumGem);
		
		addRecipe(IS.edenHead, "III", "I I", "  ", 'I', TwilightItemsOther.edenGem);
		addRecipe(IS.edenBody, "I I", "III", "III", 'I', TwilightItemsOther.edenGem);
		addRecipe(IS.edenLegs, "III", "I I", "I I", 'I', TwilightItemsOther.edenGem);
		addRecipe(IS.edenFeet, "   ", "I I", "I I", 'I', TwilightItemsOther.edenGem);
	}
}