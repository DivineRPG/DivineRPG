package net.divinerpg.utils.recipes;

import net.divinerpg.DivineRPG;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsTools;
import net.divinerpg.utils.items.VanillaItemsArmor;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.items.VanillaItemsTools;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class VanillaRecipeHelper extends RecipeUtil {

	public static void init(){
		//weapons
		addRecipe(VanillaItemsWeapons.palavence, "I I", "III", " I ", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(VanillaItemsWeapons.massivence, "X X", "III", " I ", 'I', VanillaItemsOther.netheriteIngot, 'X', VanillaItemsOther.bloodgem);
		
		addRecipe(IS.frostSword, " I ", " I ", " S ", 'I', IceikaItems.iceStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.bloodgemSword, " I ", " I", " S", 'I', VanillaItemsOther.bloodgem, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.infernoSword, "BOB", "BOB", "BSB", 'B', Items.blaze_powder, 'O', Blocks.redstone_ore, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.moltenSword, " I ", " I ", " S ", 'I', VanillaItemsOther.moltenStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.scorchingSword, " I ", " I ", " S ", 'I', VanillaItemsOther.purpleBlaze, 'S', VanillaItemsOther.netheriteIngot);
		addRecipe(VanillaItemsWeapons.bluefireSword, " I ", " I ", " S ", 'I', VanillaItemsOther.bluefireStone, 'S', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsWeapons.flamingFury, "XIX", "XIX", "XOX", 'I', VanillaItemsOther.furyFire, 'X', VanillaItemsWeapons.infernoSword, 'O', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsWeapons.poisonSaber, " R ", "BRB", "BSB", 'R', VanillaItemsOther.jungleStone, 'B', VanillaItemsOther.shadowBar, 'S', Items.stick);
		addRecipe(IS.slimeSword, "SDS", "SDS", "SDS", 'D', Items.diamond_sword, 'S', Items.slime_ball);
		addRecipe(IS.enderSword, " L ", " L ", " S ", 'L', VanillaItemsOther.legendaryEnderEye, 'S', VanillaItemsOther.shadowBar);
		addRecipe(IS.arlemiteSword, " I ", " I ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		addRecipe(IS.rupeeSword, " I ", " I ", " S ", 'I', VanillaItemsOther.rupeeIngot, 'S', Items.stick);
		addRecipe(IS.realmiteSword, " I ", " I ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', Items.stick);
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
		addRecipe(IS.bedrockMaul, " B ", "BBB", " I ", 'B', Blocks.bedrock, 'I', Items.stick);
		addRecipe(VanillaItemsWeapons.jungleKnife, " I ", " I ", " S ", 'I', VanillaItemsOther.jungleStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.cyclopsianSword, " E ", " E ", " S ", 'E', VanillaItemsOther.cyclopsEye, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.cyclopsianStaff, " E ", " S ", " S ", 'E', VanillaItemsOther.cyclopsEye, 'S', Items.stick);
		
		//ranged weapons
		addRecipe(IS.shuriken, " I ", "III", " I ", 'I', Items.iron_ingot);
		addShapelessRecipe(IS.vile, VanillaItemsOther.jungleShards, VanillaItemsWeapons.vileStorm);
		addRecipe(IceikaItems.soundOfMusic, "III", "IXI", "III", 'I', VanillaItemsOther.purpleBlaze, 'X', Items.string);
		/*addRecipe(VanillaItemsWeapons.maelstorm, "III", "IXI", "III", 'I', VanillaItemsOther.purpleBlaze, 'X', Items.book);
		addRecipe(VanillaItemsWeapons.ghastCannon, "I I", "I I", "XXX", 'I', VanillaItemsOther.shadowBar, 'X', VanillaItemsOther.hellstoneIngot);
		addRecipe(VanillaItemsWeapons.bowheadAnchor, "III", "IXI", " X ", 'I', VanillaItemsOther.whaleFin, 'X', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.sharkAnchor, "III", "IXI", " X ", 'I', VanillaItemsOther.sharkFin, 'X', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.crabAnchor, "III", "IXI", " X ", 'I', VanillaItemsOther.crabClaw, 'X', VanillaItemsOther.aquaticIngot);*/
		
		addRecipe(VanillaItemsWeapons.hunterBow, " IX", "I X", " IX", 'I', VanillaItemsOther.jungleStone, 'X', Items.string);
		addRecipe(VanillaItemsWeapons.shadowBow, " IX", "I X", " IX", 'I', VanillaItemsOther.shadowBar, 'X', Items.string);
		addRecipe(VanillaItemsWeapons.enderBow, " IX", "I X", " IX", 'I', VanillaItemsOther.enderStone, 'X', Items.string);
		/*addRecipe(VanillaItemsWeapons.bluefireBow, " IX", "I S", " IX", 'I', VanillaItemsOther.aquaticBlazeRod, 'X', VanillaItemsOther.bluefireStone, 'S', Items.string);
		addRecipe(VanillaItemsWeapons.infernoBow, " IX", "I X", " IX", 'I', VanillaItemsOther.moltenStone, 'X', Items.blaze_powder);*/
		
		addRecipe(VanillaItemsWeapons.frostCannon, "I I", "I I", "XXX", 'I', VanillaItemsOther.shadowBar, 'X', IceikaItems.iceStone);
		/*addRecipe(VanillaItemsWeapons.bowheadCannon, " I ", " I ", " X ", 'I', VanillaItemsOther.whaleFin, 'X', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.crabclawCannon, " I ", " I ", " X ", 'I', VanillaItemsOther.crabClaw, 'X', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.corruptedCannon, "III", "S S", 'I', VanillaItemsOther.corruptedStone, 'S', Items.stick);*/
		
		//addRecipe(VanillaItemsWeapons.goldenFury, "III", "IXI", "III", 'I', Items.gold_ingot, 'X', TwilightItemsWeapons.mortumBlitz);
		
		//Tools (finally! You have waited a long time for this c:)
		addRecipe(VanillaItemsTools.realmitePickaxe, "III", " S ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', Items.stick);
		addRecipe(VanillaItemsTools.realmiteShovel, " I ", " S ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', Items.stick);
		addRecipe(VanillaItemsTools.realmiteAxe, "II ", "IS ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', Items.stick);
		
		addRecipe(VanillaItemsTools.corruptedPickaxe, "III", " S ", " S ", 'I', VanillaItemsOther.corruptedStone, 'S', Items.stick);
		addRecipe(VanillaItemsTools.corruptedShovel, " I ", " S ", " S ", 'I', VanillaItemsOther.corruptedStone, 'S', Items.stick);
		addRecipe(VanillaItemsTools.corruptedAxe, "II ", "IS ", " S ", 'I', VanillaItemsOther.corruptedStone, 'S', Items.stick);
		
		addRecipe(VanillaItemsTools.bedrockPickaxe, "III", " S ", " S ", 'I', Blocks.bedrock, 'S', Items.stick);
		addRecipe(VanillaItemsTools.bedrockShovel, " I ", " S ", " S ", 'I', Blocks.bedrock, 'S', Items.stick);
		addRecipe(VanillaItemsTools.bedrockAxe, "II ", "IS ", " S ", 'I', Blocks.bedrock, 'S', Items.stick);
		
		addRecipe(VanillaItemsTools.arlemitePickaxe, "III", " S ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		addRecipe(VanillaItemsTools.arlemiteShovel, " I ", " S ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		addRecipe(VanillaItemsTools.arlemiteAxe, "II ", "IS ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		addShapelessRecipe(VanillaItemsTools.arlemiteShickaxe, VanillaItemsTools.arlemitePickaxe, VanillaItemsTools.arlemiteShovel, VanillaItemsTools.arlemiteAxe);
		
		addRecipe(VanillaItemsTools.arlemitePickaxe, "III", " S ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		addRecipe(VanillaItemsTools.arlemiteShovel, " I ", " S ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		addRecipe(VanillaItemsTools.arlemiteAxe, "II ", "IS ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		addShapelessRecipe(VanillaItemsTools.rupeeShickaxe, VanillaItemsTools.rupeePickaxe, VanillaItemsTools.rupeeShovel, VanillaItemsTools.rupeeAxe);
		
		addRecipe(VanillaItemsTools.divinePickaxe, "III", " S ", " S ", 'I', VanillaItemsOther.divineStone, 'S', Items.stick);
		addRecipe(VanillaItemsTools.divineShovel, " I ", " S ", " S ", 'I', VanillaItemsOther.divineStone, 'S', Items.stick);
		addRecipe(VanillaItemsTools.divineAxe, "II ", "IS ", " S ", 'I', VanillaItemsOther.divineStone, 'S', Items.stick);
		addShapelessRecipe(VanillaItemsTools.divineShickaxe, VanillaItemsTools.divinePickaxe, VanillaItemsTools.divineShovel, VanillaItemsTools.divineAxe);
		
		//serenades
		addRecipe(VanillaItemsWeapons.serenadeStriker, "I  ", "III", "  I", 'I', Items.diamond);
		addRecipe(VanillaItemsWeapons.serenadeOfHealth, "I  ", "III", "  I", 'I', VanillaItemsOther.netheriteChunk);
		addRecipe(VanillaItemsWeapons.serenadeOfDeath, "I  ", "III", "  I", 'I', VanillaItemsOther.shadowBar);
		
		//armor 
		removeCraftingRecipe(Items.diamond_chestplate);
		removeCraftingRecipe(Items.diamond_leggings);
		removeCraftingRecipe(Items.diamond_boots);
		removeCraftingRecipe(Items.diamond_helmet);
		removeCraftingRecipe(Items.golden_chestplate);
		removeCraftingRecipe(Items.golden_leggings);
		removeCraftingRecipe(Items.golden_boots);
		removeCraftingRecipe(Items.golden_helmet);
		removeCraftingRecipe(Items.iron_chestplate);
		removeCraftingRecipe(Items.iron_leggings);
		removeCraftingRecipe(Items.iron_boots);
		removeCraftingRecipe(Items.iron_helmet);
		removeCraftingRecipe(Items.leather_chestplate);
		removeCraftingRecipe(Items.leather_leggings);
		removeCraftingRecipe(Items.leather_boots);
		removeCraftingRecipe(Items.leather_helmet);
		
		addRecipe(VanillaItemsArmor.diamondHelmet, "III", "I I", "   ", 'I', Items.diamond);
		addRecipe(VanillaItemsArmor.diamondBody, "I I", "III", "III", 'I', Items.diamond);
		addRecipe(VanillaItemsArmor.diamondLegs, "III", "I I", "I I", 'I', Items.diamond);
		addRecipe(VanillaItemsArmor.diamondBoots, "   ", "I I", "I I", 'I', Items.diamond);
		
		addRecipe(VanillaItemsArmor.ironHelmet, "III", "I I", "   ", 'I', Items.iron_ingot);
		addRecipe(VanillaItemsArmor.ironBody, "I I", "III", "III", 'I', Items.iron_ingot);
		addRecipe(VanillaItemsArmor.ironLegs, "III", "I I", "I I", 'I', Items.iron_ingot);
		addRecipe(VanillaItemsArmor.ironBoots, "   ", "I I", "I I", 'I', Items.iron_ingot);
		
		addRecipe(VanillaItemsArmor.goldHelmet, "III", "I I", "   ", 'I', Items.gold_ingot);
		addRecipe(VanillaItemsArmor.goldBody, "I I", "III", "III", 'I', Items.gold_ingot);
		addRecipe(VanillaItemsArmor.goldLegs, "III", "I I", "I I", 'I', Items.gold_ingot);
		addRecipe(VanillaItemsArmor.goldBoots, "   ", "I I", "I I", 'I', Items.gold_ingot);
		
		addRecipe(VanillaItemsArmor.leatherHelmet, "III", "I I", "   ", 'I', Items.leather);
		addRecipe(VanillaItemsArmor.leatherBody, "I I", "III", "III", 'I', Items.leather);
		addRecipe(VanillaItemsArmor.leatherLegs, "III", "I I", "I I", 'I', Items.leather);
		addRecipe(VanillaItemsArmor.leatherBoots, "   ", "I I", "I I", 'I', Items.leather);
		
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
		addShapelessRecipe(IS.eyeShards, VanillaItemsOther.cyclopsEye);

		addRecipe(IS.arlemiteBlock, "III", "III", "III", 'I', VanillaItemsOther.arlemiteIngot);
		addRecipe(IS.rupeeBlock, "III", "III", "III", 'I', VanillaItemsOther.rupeeIngot);
		addRecipe(IS.realBlock, "III", "III", "III", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(IS.netherBlock, "III", "III", "III", 'I', VanillaItemsOther.netheriteIngot);
		addRecipe(IS.bloodBlock, "III", "III", "III", 'I', VanillaItemsOther.bloodgem);
		
		addRecipe(IS.bedrock, "OOO", "OBO", " OO", 'O', Blocks.obsidian, 'B', VanillaBlocks.rupeeBlock);
		addSmelting(VanillaBlocks.realmiteOre, VanillaItemsOther.realmiteIngot, 0.7F);
		addSmelting(VanillaBlocks.arlemiteOre, VanillaItemsOther.arlemiteIngot, 1.0F);
		addSmelting(VanillaBlocks.rupeeOre, VanillaItemsOther.rupeeIngot, 1.0F);
		addSmelting(VanillaBlocks.netheriteOre, VanillaItemsOther.netheriteIngot, 1.1F);
		addSmelting(VanillaBlocks.bloodgemOre, VanillaItemsOther.bloodgem, 1.2F);
		addSmelting(VanillaItemsOther.pureAquaticPellets, VanillaItemsOther.aquaticIngot, 0.6F);
		addShapelessRecipe(VanillaItemsOther.hellstoneIngot, VanillaItemsOther.shadowBar, VanillaItemsOther.netheriteChunk);

		addShapelessRecipe(IS.arlemiteIngot, VanillaBlocks.arlemiteBlock);
		addShapelessRecipe(IS.rupeeIngot, VanillaBlocks.rupeeBlock);
		addShapelessRecipe(IS.realIngot, VanillaBlocks.realmiteBlock);
		addShapelessRecipe(IS.netherIngot, VanillaBlocks.netheriteBlock);
		addShapelessRecipe(IS.bloodgem, VanillaBlocks.bloodgemBlock);
		addShapelessRecipe(IS.shadow, VanillaItemsOther.rupeeIngot, VanillaItemsOther.arlemiteIngot);
		
		addRecipe(VanillaItemsOther.pureAquaticPellets, "PPP", "PPP", "PPP", 'P', VanillaItemsOther.aquaticPellets);
		
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
		
		addShapelessRecipe(IS.divinePlanks, VanillaBlocks.divineWood);
	}
}
