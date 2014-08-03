package net.divinerpg.utils.recipes;

import net.divinerpg.DivineRPG;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.VanillaItemsArmor;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class VanillaRecipeHelper extends RecipeUtil {

	public static void init(){
		//weapons
		addRecipe(IS.frostSword, " I ", " I ", " S ", 'I', IceikaItems.iceStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.bloodgemSword, " I ", " I", " S", 'I', VanillaItemsOther.bloodgem, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.infernoSword, "BOB", "BOB", "BSB", 'B', Items.blaze_powder, 'O', Blocks.redstone_ore, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.moltenSword, " I ", " I ", " S ", 'I', VanillaItemsOther.moltenStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.scorchingSword, " I ", " I ", " S ", 'I', VanillaItemsOther.purpleBlaze, 'S', VanillaItemsOther.netheriteIngot);
		addRecipe(VanillaItemsWeapons.bluefireSword, " I ", " I ", " S ", 'I', VanillaItemsOther.bluefireStone, 'S', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsWeapons.poisonSaber, " R ", "BRB", "BSB", 'R', VanillaItemsOther.jungleStone, 'B', VanillaItemsOther.shadowBar, 'S', Items.stick);
		addRecipe(IS.slimeSword, "SDS", "SDS", "SDS", 'D', Items.diamond_sword, 'S', Items.slime_ball);
		addRecipe(IS.enderSword, " L ", " L ", " S ", 'L', VanillaItemsOther.legendaryEnderEye, 'S', VanillaItemsOther.shadowBar);
		addRecipe(IS.arlemiteSword, " I ", " I ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		addRecipe(IS.rupeeSword, " I ", " I ", " S ", 'I', VanillaItemsOther.rupeeIngot, 'S', Items.stick);
		addRecipe(IS.realmiteSword, " I ", " I ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', Items.stick);
		addRecipe(IS.shuriken, " I ", "III", " I ", 'I', Items.iron_ingot);
		addShapelessRecipe(IS.vile, VanillaItemsOther.jungleShards, VanillaItemsWeapons.vileStorm);
		addBigRecipe(VanillaItemsWeapons.slimeSword, "SDS", "SDS", "SDS", 'D', Items.diamond_sword, 'S', Items.slime_ball);
		addBigRecipe(IS.longsword, " I ", " I ", " I ", "III", " S ", 'I', Items.iron_ingot, 'S', Items.stick);
		addRecipe(IS.oceanKnife, " I ", " I ", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.aquaticDagger, "   ", " I ", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		addRecipe(IS.aquaticMaul, "III", "III", "ISI", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		addRecipe(IS.aquaticTrident, " I ", "III", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.aquaton, "III", "III", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.sharkSword, " I ", " I ", " S ", 'I', VanillaItemsOther.sharkFin, 'S', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.crabclawMaul, "III", "ISI", " S ", 'I', VanillaItemsOther.crabClaw, 'S', Items.stick);
		addRecipe(IS.bedrockSword, " B ", " B ", " S ", 'B', Blocks.bedrock, 'S', Items.stick);
		addRecipe(IS.divineSword, " I ", "III", " S ", 'I', VanillaItemsOther.divineStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.furyMaul, "OBO", "BBB", "OBO", 'O', Blocks.bedrock, 'S', Blocks.diamond_ore);
		addRecipe(VanillaItemsWeapons.deathBringer, " I ", "ISI", " S ", 'I', VanillaItemsOther.corruptedStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.corruptedMaul, "III", "ISI", " S ", 'I', VanillaItemsOther.corruptedStone, 'S', Items.stick);
		addRecipe(IS.divineSword, " s ", "sss", " S ", 's', VanillaItemsOther.divineStone, 'S', Items.stick);
		addRecipe(IS.bedrockMaul, " B ", "BBB", " B ", 'I', Blocks.bedrock, 'I', Items.stick);
		addRecipe(VanillaItemsWeapons.jungleKnife, " I ", " I ", " S ", 'I', VanillaItemsOther.jungleStone, 'S', Items.stick);
		
		//armor 
		addRecipe(IS.realHead, "III", "I I", "   ", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(IS.realBody, "I I", "III", "III", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(IS.realLegs, "III", "I I", "I I", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(IS.realFeet, "   ", "I I", "I I", 'I', VanillaItemsOther.realmiteIngot);
		
		addRecipe(IS.eliteHead, "III", "I I", "   ", 'I', VanillaBlocks.realmiteBlock);
		addRecipe(IS.eliteBody, "I I", "III", "III", 'I', VanillaBlocks.realmiteBlock);
		addRecipe(IS.eliteLegs, "III", "I I", "I I", 'I', VanillaBlocks.realmiteBlock);
		addRecipe(IS.eliteFeet, "   ", "I I", "I I", 'I', VanillaBlocks.realmiteBlock);
		
		addRecipe(IS.bedrockHead, "III", "I I", "   ", 'I', Blocks.bedrock);
		addRecipe(IS.bedrockBody, "I I", "III", "III", 'I', Blocks.bedrock);
		addRecipe(IS.bedrockLegs, "III", "I I", "I I", 'I', Blocks.bedrock);
		addRecipe(IS.bedrockFeet, "   ", "I I", "I I", 'I', Blocks.bedrock);
		
		addRecipe(IS.rupeeHead, "III", "I I", "   ", 'I', VanillaItemsOther.rupeeIngot);
		addRecipe(IS.rupeeBody, "I I", "III", "   ", 'I', VanillaItemsOther.rupeeIngot);
		addRecipe(IS.rupeeLegs, "III", "I I", "I I", 'I', VanillaItemsOther.rupeeIngot);
		addRecipe(IS.rupeeFeet, "   ", "I I", "I I", 'I', VanillaItemsOther.rupeeIngot);
		
		addRecipe(IS.arlemiteHead, "III", "X X", "   ", 'I', VanillaItemsOther.arlemiteIngot ,'X', Items.iron_ingot);
		addRecipe(IS.arlemiteBody, "X X", "XIX", "III", 'I', VanillaItemsOther.arlemiteIngot, 'X', Items.iron_ingot);
		addRecipe(IS.arlemiteLegs, "XIX", "I I", "X X", 'I', VanillaItemsOther.arlemiteIngot, 'X', Items.iron_ingot);
		addRecipe(IS.arlemiteFeet, "   ", "X X", "I I", 'I', VanillaItemsOther.arlemiteIngot, 'X', Items.iron_ingot);
		
		addRecipe(IS.infernoHead, "III", "I I", "   ", 'I', VanillaItemsOther.moltenStone);
		addRecipe(IS.infernoBody, "I I", "III", "III", 'I', VanillaItemsOther.moltenStone);
		addRecipe(IS.infernoLegs ,"III", "I I", "I I", 'I', VanillaItemsOther.moltenStone);
		addRecipe(IS.infernoFeet, "   ", "I I", "I I", 'I', VanillaItemsOther.moltenStone);
		
		addRecipe(IS.netherHead, "III", "I I", "   ", 'I', VanillaItemsOther.netheriteIngot);
		addRecipe(IS.netherBody, "I I", "III", "III", 'I', VanillaItemsOther.netheriteIngot);
		addRecipe(IS.netherLegs, "III", "I I", "I I", 'I', VanillaItemsOther.netheriteIngot);
		addRecipe(IS.netherFeet, "   ", "I I", "I I", 'I', VanillaItemsOther.netheriteIngot);
		
		addRecipe(IS.enderHead, "III", "I I", "   ", 'I', VanillaItemsOther.enderStone);
		addRecipe(IS.enderBody, "I I", "III", "III", 'I', VanillaItemsOther.enderStone);
		addRecipe(IS.enderLegs, "III", "I I", "I I", 'I', VanillaItemsOther.enderStone);
		addRecipe(IS.enderFeet, "   ", "I I", "I I", 'I', VanillaItemsOther.enderStone);
		
		addRecipe(IS.divineHead, "III", "I I", "   ", 'I', VanillaItemsOther.divineStone);
		addRecipe(IS.divineBody, "I I", "III", "III", 'I', VanillaItemsOther.divineStone);
		addRecipe(IS.divineLegs, "III", "I I", "I I", 'I', VanillaItemsOther.divineStone);
		addRecipe(IS.divineFeet, "   ", "I I", "I I", 'I', VanillaItemsOther.divineStone);
		
		addRecipe(IS.angelicHead, "III", "X X", "   ", 'I', VanillaItemsOther.bluefireStone, 'X', IceikaItems.iceStone);
		addRecipe(IS.angelicBody, "I I", "XIX", "XXX", 'I', VanillaItemsOther.bluefireStone, 'X', IceikaItems.iceStone);
		addRecipe(IS.angelicLegs, "III", "X X", "X X", 'I', VanillaItemsOther.bluefireStone, 'X', IceikaItems.iceStone);
		addRecipe(IS.angelicFeet, "   ", "I I", "X X", 'I', VanillaItemsOther.bluefireStone, 'X', IceikaItems.iceStone);
		
		addRecipe(IS.shadowHead, "III", "I I", "   ", 'I', VanillaItemsOther.shadowBar);
		addRecipe(IS.shadowBody, "I I", "III", "III", 'I', VanillaItemsOther.shadowBar);
		addRecipe(IS.shadowLegs, "III", "I I", "I I", 'I', VanillaItemsOther.shadowBar);
		addRecipe(IS.shadowFeet, "   ", "I I", "I I", 'I', VanillaItemsOther.shadowBar);
		
		addRecipe(IS.aquastriveHead, "III", "I I", "   ", 'I', VanillaItemsOther.aquaticIngot);
		addRecipe(IS.aquastriveBody, "I I", "III", "III", 'I', VanillaItemsOther.aquaticIngot);
		addRecipe(IS.aquastriveLegs, "III", "I I", "I I", 'I', VanillaItemsOther.aquaticIngot);
		addRecipe(IS.aquastriveFeet, "   ", "I I", "I I", 'I', VanillaItemsOther.aquaticIngot);
		
		addRecipe(VanillaItemsArmor.krakenHelmet, "III", "I I", "   ", 'I', VanillaItemsOther.krakenSkin);
		addRecipe(VanillaItemsArmor.krakenBody, "I I", "III", "III", 'I', VanillaItemsOther.krakenSkin);
		addRecipe(VanillaItemsArmor.krakenLegs, "III", "I I", "I I", 'I', VanillaItemsOther.krakenSkin);
		addRecipe(VanillaItemsArmor.krakenBoots, "   ", "I I", "I I", 'I', VanillaItemsOther.krakenSkin);
		
		//misc
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
		addRecipe(IS.jungleStone, "III", "III", "III", 'I', VanillaItemsOther.jungleShards);
		addRecipe(IS.iceStone, "III", "III", "III", 'I', IceikaItems.iceShards);
		addRecipe(IS.moltenStone, "III", "III", "III", 'I', VanillaItemsOther.moltenShards);
		addRecipe(IS.divineStone, "III", "III", "III", 'I', VanillaItemsOther.divineShards);
		addRecipe(IS.enderStone, "III", "III", "III", 'I', VanillaItemsOther.enderShard);

		addRecipe(IS.legEnderEye, "III", "III", "III", 'I', VanillaItemsOther.enderStone);
		
		addRecipe(IS.krakenScale, "K K", "K K", "KKK", 'K', new ItemStack(Items.dye, 1, 0));
		addShapelessRecipe(IS.krakenSkin, VanillaItemsOther.krakenScale, VanillaItemsOther.krakenScale);
		
		addShapelessRecipe(IS.bacon, Items.porkchop);
		addRecipe(IS.cheese, "MMM", "MMM", "MMM", 'M', Items.milk_bucket);
		addSmelting(IS.egg, IS.boiledEgg, 0.3F);
		addShapelessRecipe(IS.advStew, ItemsFood.whiteMushroom, Items.mushroom_stew);
		addShapelessRecipe(IS.chickDinner, ItemsFood.advMushroomStew, Items.cooked_chicken, Items.bread);
		
		Util.removeCraftingRecipe(Items.diamond_chestplate);
		Util.removeCraftingRecipe(Items.diamond_leggings);
		Util.removeCraftingRecipe(Items.diamond_boots);
		Util.removeCraftingRecipe(Items.diamond_helmet);
		
		Util.removeCraftingRecipe(Items.golden_chestplate);
		Util.removeCraftingRecipe(Items.golden_leggings);
		Util.removeCraftingRecipe(Items.golden_boots);
		Util.removeCraftingRecipe(Items.golden_helmet);
		
		Util.removeCraftingRecipe(Items.iron_chestplate);
		Util.removeCraftingRecipe(Items.iron_leggings);
		Util.removeCraftingRecipe(Items.iron_boots);
		Util.removeCraftingRecipe(Items.iron_helmet);
		
		Util.removeCraftingRecipe(Items.leather_chestplate);
		Util.removeCraftingRecipe(Items.leather_leggings);
		Util.removeCraftingRecipe(Items.leather_boots);
		Util.removeCraftingRecipe(Items.leather_helmet);
	}
}
