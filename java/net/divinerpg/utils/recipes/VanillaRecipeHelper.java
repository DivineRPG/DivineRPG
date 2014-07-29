package net.divinerpg.utils.recipes;

import net.divinerpg.DivineRPG;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class VanillaRecipeHelper extends DivineRPG {

	public static void init(){
		addRecipe(IS.slimeSword, "SDS", "SDS", "SDS", 'D', Items.diamond_sword, 'S', Items.slime_ball);
		addRecipe(IS.enderSword, " L ", " L ", " S ", 'L', VanillaItemsOther.legendaryEnderEye, 'S', VanillaItemsOther.shadowBar);
		addRecipe(IS.arlemiteSword, " I ", " I ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		addRecipe(IS.rupeeSword, " I ", " I ", " S ", 'I', VanillaItemsWeapons.rupeeSword, 'S', Items.stick);
		addRecipe(IS.realmiteSword, " I ", " I ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', Items.stick);
		addRecipe(IS.shuriken, " I ", "III", " I ", 'I', Items.iron_ingot);
		addShapelessRecipe(IS.vile, VanillaItemsOther.jungleShards, VanillaItemsWeapons.vileStorm);
		addBigRecipe(IS.slimeSword, "SDS", "SDS", "SDS", 'D', Items.diamond_sword, 'S', Items.slime_ball);
		addBigRecipe(IS.longsword, " I ", " I ", " I ", "III", " S ", 'I', Items.iron_ingot, 'S', Items.stick);
		addRecipe(IS.oceanKnife, " I ", " I ", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		addRecipe(IS.aquaticMaul, "III", "III", "ISI", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		addRecipe(IS.bedrockSword, " B ", " B ", " S ", 'B', Blocks.bedrock, 'S', Items.stick);
		addRecipe(IS.divineSword, " s ", "sss", " S ", 's', VanillaItemsOther.divineStone, 'S', Items.stick);
		addRecipe(IS.bedrockMaul, " B ", "BBB", " B ", 'I', Blocks.bedrock);
		addRecipe(IS.aquaticTrident, " I ", "III", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		
		addRecipe(IS.realHead, "III", "I I", "  ", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(IS.realBody, "I I", "III", "III", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(IS.realLegs, "III", "I I", "I I", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(IS.realFeet, "   ", "I I", "I I", 'I', VanillaItemsOther.realmiteIngot);
		
		addRecipe(IS.eliteHead, "III", "I I", "  ", 'I', VanillaBlocks.realmiteBlock);
		addRecipe(IS.eliteBody, "I I", "III", "III", 'I', VanillaBlocks.realmiteBlock);
		addRecipe(IS.eliteLegs, "III", "I I", "I I", 'I', VanillaBlocks.realmiteBlock);
		addRecipe(IS.eliteFeet, "   ", "I I", "I I", 'I', VanillaBlocks.realmiteBlock);

		addRecipe(IS.netherChuck, " I ", "III", " I ", 'I', VanillaItemsOther.netheriteIngot);

		addRecipe(IS.arlemiteBlock, "III", "III", "III", 'I', VanillaItemsOther.arlemiteIngot);
		addRecipe(IS.rupeeBlock, "III", "III", "III", 'I', VanillaItemsOther.rupeeIngot);
		addRecipe(IS.realBlock, "III", "III", "III", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(IS.netherBlock, "III", "III", "III", 'I', VanillaItemsOther.netheriteIngot);
		addRecipe(IS.bloodBlock, "III", "III", "III", 'I', VanillaItemsOther.bloodgem);

		addShapelessRecipe(IS.arlemiteIngot, VanillaBlocks.arlemiteBlock);
		addShapelessRecipe(IS.rupeeIngot, VanillaBlocks.rupeeBlock);
		addShapelessRecipe(IS.realIngot, VanillaBlocks.realmiteBlock);
		addShapelessRecipe(IS.netherIngot, VanillaBlocks.netheriteBlock);
		addShapelessRecipe(IS.bloodgem, VanillaBlocks.bloodgemBlock);
		addShapelessRecipe(IS.shadow, VanillaItemsOther.rupeeIngot, VanillaItemsOther.arlemiteIngot);
		
		addRecipe(IS.corruptStone, "III", "III", "III", 'I', VanillaItemsOther.corruptedShards);
		addRecipe(IS.enderStone, "III", "III", "III", 'I', VanillaItemsOther.jungleShards);
		addRecipe(IS.iceStone, "III", "III", "III", 'I', IceikaItems.iceShards);
		addRecipe(IS.moltenStone, "III", "III", "III", 'I', VanillaItemsOther.moltenShards);
		addRecipe(IS.divineStone, "III", "III", "III", 'I', VanillaItemsOther.divineShards);
		addRecipe(IS.enderStone, "III", "III", "III", 'I', VanillaItemsOther.enderShard);

		addRecipe(IS.legEnderEye, "III", "III", "III", 'I', VanillaItemsOther.enderStone);
		
		addShapelessRecipe(IS.bacon, Items.porkchop);
		addRecipe(IS.cheese, "MMM", "MMM", "MMM", 'M', Items.milk_bucket);
		addSmelting(IS.egg, IS.boiledEgg, 0.3F);
		addShapelessRecipe(IS.advStew, ItemsFood.whiteMushroom, Items.mushroom_stew);
		addShapelessRecipe(IS.chickDinner, ItemsFood.advMushroomStew, Items.cooked_chicken, Items.bread);
	}
}