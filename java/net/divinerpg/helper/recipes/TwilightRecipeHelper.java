package net.divinerpg.helper.recipes;

import net.divinerpg.helper.Util;
import net.divinerpg.helper.items.TwilightItemsArmor;
import net.divinerpg.helper.items.TwilightItemsOther;
import net.divinerpg.helper.items.VanillaItemsOther;

public class TwilightRecipeHelper {
	

	public static void init(){
		
		Util.addShapelessRecipe(IS.edenFragments, TwilightItemsOther.edenSoul);
		Util.addShapelessRecipe(IS.wildWoodFragments, TwilightItemsOther.wildWoodSoul);
		Util.addShapelessRecipe(IS.apalachiaFragments, TwilightItemsOther.apalachiaSoul);
		Util.addShapelessRecipe(IS.skythernFragments, TwilightItemsOther.skythernSoul);
		Util.addShapelessRecipe(IS.mortumFragments, TwilightItemsOther.mortumSoul);
		
		Util.addRecipe(IS.edenGem, "GGG", 'G', TwilightItemsOther.edenFragments);
		Util.addRecipe(IS.wildWoodGem, "GGG", 'G', TwilightItemsOther.wildWoodFragments);
		Util.addRecipe(IS.apalachiaGem, "GGG", 'G', TwilightItemsOther.apalachiaFragments);
		Util.addRecipe(IS.skythernGem, "GGG", 'G', TwilightItemsOther.skythernFragments);
		Util.addRecipe(IS.mortumGem, "GGG", 'G', TwilightItemsOther.mortumFragments);
		
		Util.addRecipe(IS.edenChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.edenGem);
		Util.addRecipe(IS.wildWoodChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.wildWoodGem);
		Util.addRecipe(IS.apalachiaChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.apalachiaGem);
		Util.addRecipe(IS.skythernChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.skythernGem);
		Util.addRecipe(IS.mortumChunk, "GGG", "G G", "G G", 'G', TwilightItemsOther.mortumGem);
		
		Util.addRecipe(IS.edenHead, "III", "I I", "  ", 'I', TwilightItemsOther.edenGem);
		Util.addRecipe(IS.edenBody, "I I", "III", "III", 'I', TwilightItemsOther.edenGem);
		Util.addRecipe(IS.edenLegs, "III", "I I", "I I", 'I', TwilightItemsOther.edenGem);
		Util.addRecipe(IS.edenFeet, "   ", "I I", "I I", 'I', TwilightItemsOther.edenGem);

	}
}