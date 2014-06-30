package net.divinerpg.helper.recipes;

import net.divinerpg.helper.Util;
import net.divinerpg.helper.blocks.VanillaBlocks;
import net.divinerpg.helper.items.IceikaItems;
import net.divinerpg.helper.items.ItemsFood;
import net.divinerpg.helper.items.VanillaItemsOther;
import net.divinerpg.helper.items.VanillaItemsWeapons;
import net.minecraft.init.Items;

public class VanillaRecipeHelper {

	public static void init(){
		Util.addRecipe(IS.slimeSword, "SDS", "SDS", "SDS", 'D', Items.diamond_sword, 'S', Items.slime_ball);
		Util.addRecipe(IS.enderSword, " L ", " L ", " S ", 'L', VanillaItemsOther.legendaryEnderEye, 'S', VanillaItemsOther.shadowBar);
		Util.addRecipe(IS.arlemiteSword, " I ", " I ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		Util.addRecipe(IS.rupeeSword, " I ", " I ", " S ", 'I', VanillaItemsWeapons.rupeeSword, 'S', Items.stick);
		Util.addRecipe(IS.realmiteSword, " I ", " I ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', Items.stick);
		Util.addRecipe(IS.shuriken, " I ", "III", " I ", 'I', Items.iron_ingot);
		Util.addShapelessRecipe(IS.vile, VanillaItemsOther.jungleShards, VanillaItemsWeapons.vileStorm);
		Util.addBigRecipe(IS.slimeSword, "SDS", "SDS", "SDS", 'D', Items.diamond_sword, 'S', Items.slime_ball);
		Util.addBigRecipe(IS.longsword, " I ", " I ", " I ", "III", " S ", 'I', Items.iron_ingot, 'S', Items.stick);
		
		Util.addRecipe(IS.arlemitePick, "III", " S ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		
		Util.addRecipe(IS.realHead, "III", "I I", "  ", 'I', VanillaItemsOther.realmiteIngot);
		Util.addRecipe(IS.realBody, "I I", "III", "III", 'I', VanillaItemsOther.realmiteIngot);
		Util.addRecipe(IS.realLegs, "III", "I I", "I I", 'I', VanillaItemsOther.realmiteIngot);
		Util.addRecipe(IS.realFeet, "   ", "I I", "I I", 'I', VanillaItemsOther.realmiteIngot);
		
		Util.addRecipe(IS.eliteHead, "III", "I I", "  ", 'I', VanillaBlocks.realmiteBlock);
		Util.addRecipe(IS.eliteBody, "I I", "III", "III", 'I', VanillaBlocks.realmiteBlock);
		Util.addRecipe(IS.eliteLegs, "III", "I I", "I I", 'I', VanillaBlocks.realmiteBlock);
		Util.addRecipe(IS.eliteFeet, "   ", "I I", "I I", 'I', VanillaBlocks.realmiteBlock);

		Util.addRecipe(IS.netherChuck, " I ", "III", " I ", 'I', VanillaItemsOther.netheriteIngot);

		Util.addRecipe(IS.arlemiteBlock, "III", "III", "III", 'I', VanillaItemsOther.arlemiteIngot);
		Util.addRecipe(IS.rupeeBlock, "III", "III", "III", 'I', VanillaItemsOther.rupeeIngot);
		Util.addRecipe(IS.realBlock, "III", "III", "III", 'I', VanillaItemsOther.realmiteIngot);
		Util.addRecipe(IS.netherBlock, "III", "III", "III", 'I', VanillaItemsOther.netheriteIngot);
		Util.addRecipe(IS.bloodBlock, "III", "III", "III", 'I', VanillaItemsOther.bloodgem);

		Util.addShapelessRecipe(IS.arlemiteIngot, VanillaBlocks.arlemiteBlock);
		Util.addShapelessRecipe(IS.rupeeIngot, VanillaBlocks.rupeeBlock);
		Util.addShapelessRecipe(IS.realIngot, VanillaBlocks.realmiteBlock);
		Util.addShapelessRecipe(IS.netherIngot, VanillaBlocks.netheriteBlock);
		Util.addShapelessRecipe(IS.bloodgem, VanillaBlocks.bloodgemBlock);
		Util.addShapelessRecipe(IS.shadow, VanillaItemsOther.rupeeIngot, VanillaItemsOther.arlemiteIngot);
		
		Util.addRecipe(IS.corruptStone, "III", "III", "III", 'I', VanillaItemsOther.corruptedShards);
		Util.addRecipe(IS.enderStone, "III", "III", "III", 'I', VanillaItemsOther.jungleShards);
		Util.addRecipe(IS.iceStone, "III", "III", "III", 'I', IceikaItems.iceShards);
		Util.addRecipe(IS.moltenStone, "III", "III", "III", 'I', VanillaItemsOther.moltenShards);
		Util.addRecipe(IS.divineStone, "III", "III", "III", 'I', VanillaItemsOther.divineShards);
		Util.addRecipe(IS.enderStone, "III", "III", "III", 'I', VanillaItemsOther.enderShard);

		Util.addRecipe(IS.legEnderEye, "III", "III", "III", 'I', VanillaItemsOther.enderStone);
		
		Util.addShapelessRecipe(IS.bacon, Items.porkchop);
		Util.addRecipe(IS.cheese, "MMM", "MMM", "MMM", 'M', Items.milk_bucket);
		Util.addSmelting(IS.egg, IS.boiledEgg, 0.3F);
		Util.addShapelessRecipe(IS.advStew, ItemsFood.whiteMushroom, Items.mushroom_stew);
		Util.addShapelessRecipe(IS.chickDinner, ItemsFood.advMushroomStew, Items.cooked_chicken, Items.bread);
	}
}