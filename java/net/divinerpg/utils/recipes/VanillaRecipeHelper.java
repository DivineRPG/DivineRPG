package net.divinerpg.utils.recipes;

import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
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
		
		addRecipe(VanillaItemsWeapons.frostSword, " I ", " I ", " S ", 'I', IceikaItems.iceStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.bloodgemSword, " I ", " I", " S", 'I', VanillaItemsOther.bloodgem, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.infernoSword, "BOB", "BOB", "BSB", 'B', Items.blaze_powder, 'O', Blocks.redstone_ore, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.moltenSword, " I ", " I ", " S ", 'I', VanillaItemsOther.moltenStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.scorchingSword, " I ", " I ", " S ", 'I', VanillaItemsOther.purpleBlaze, 'S', VanillaItemsOther.netheriteIngot);
		addRecipe(VanillaItemsWeapons.bluefireSword, " I ", " I ", " S ", 'I', VanillaItemsOther.bluefireStone, 'S', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsWeapons.flamingFury, "XIX", "XIX", "XOX", 'I', VanillaItemsOther.furyFire, 'X', VanillaItemsWeapons.infernoSword, 'O', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsWeapons.poisonSaber, " R ", "BRB", "BSB", 'R', VanillaItemsOther.jungleStone, 'B', VanillaItemsOther.shadowBar, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.slimeSword, "SDS", "SDS", "SDS", 'D', Items.diamond_sword, 'S', Items.slime_ball);
		addRecipe(VanillaItemsWeapons.enderSword, " L ", " L ", " S ", 'L', VanillaItemsOther.legendaryEnderEye, 'S', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsWeapons.arlemiteSword, " I ", " I ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.rupeeSword, " I ", " I ", " S ", 'I', VanillaItemsOther.rupeeIngot, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.realmiteSword, " I ", " I ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.slimeSword, "SDS", "SDS", "SDS", 'D', Items.diamond_sword, 'S', Items.slime_ball);
		addRecipe(VanillaItemsWeapons.oceanKnife, " I ", " I ", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.aquaticDagger, "   ", " I ", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.aquaticMaul, "III", "III", "ISI", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.aquaticTrident, " I ", "III", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.aquaton, "III", "III", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.sharkSword, " I ", " I ", " S ", 'I', VanillaItemsOther.sharkFin, 'S', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.crabclawMaul, "III", "ISI", " S ", 'I', VanillaItemsOther.crabClaw, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.bedrockSword, " B ", " B ", " S ", 'B', Blocks.bedrock, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.divineSword, " I ", "III", " S ", 'I', VanillaItemsOther.divineStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.furyMaul, "OBO", "BBB", "OBO", 'B', Blocks.bedrock, 'O', Blocks.diamond_ore);
		addRecipe(VanillaItemsWeapons.deathBringer, " I ", "ISI", " S ", 'I', VanillaItemsOther.corruptedStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.corruptedMaul, "III", "ISI", " S ", 'I', VanillaItemsOther.corruptedStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.bedrockMaul, " B ", "BBB", " I ", 'B', Blocks.bedrock, 'I', Items.stick);
		addRecipe(VanillaItemsWeapons.jungleKnife, " I ", " I ", " S ", 'I', VanillaItemsOther.jungleStone, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.cyclopsianSword, " E ", " E ", " S ", 'E', VanillaItemsOther.cyclopsEye, 'S', Items.stick);
		addRecipe(VanillaItemsWeapons.cyclopsianStaff, " E ", " S ", " S ", 'E', VanillaItemsOther.cyclopsEye, 'S', Items.stick);
		
		//ranged weapons
		addRecipe(IS.shuriken, " I ", "III", " I ", 'I', Items.iron_ingot);
		addShapelessRecipe(VanillaItemsWeapons.vileStorm, VanillaItemsOther.jungleShards, VanillaItemsWeapons.vileStorm);
		addRecipe(IceikaItems.soundOfMusic, "III", "IXI", "III", 'I', VanillaItemsOther.purpleBlaze, 'X', Items.string);
		addRecipe(VanillaItemsWeapons.maelstorm, "III", "IXI", "III", 'I', VanillaItemsOther.purpleBlaze, 'X', Items.book);
		addRecipe(VanillaItemsWeapons.ghastCannon, "I I", "I I", "XXX", 'I', VanillaItemsOther.shadowBar, 'X', VanillaItemsOther.hellstoneIngot);
		addRecipe(VanillaItemsWeapons.bowheadAnchor, "III", "IXI", " X ", 'I', VanillaItemsOther.whaleFin, 'X', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.sharkAnchor, "III", "IXI", " X ", 'I', VanillaItemsOther.sharkFin, 'X', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.crabAnchor, "III", "IXI", " X ", 'I', VanillaItemsOther.crabClaw, 'X', VanillaItemsOther.aquaticIngot);
		
		addRecipe(VanillaItemsWeapons.hunterBow, " IX", "I X", " IX", 'I', VanillaItemsOther.jungleStone, 'X', Items.string);
		addRecipe(VanillaItemsWeapons.shadowBow, " IX", "I X", " IX", 'I', VanillaItemsOther.shadowBar, 'X', Items.string);
		addRecipe(VanillaItemsWeapons.enderBow, " IX", "I X", " IX", 'I', VanillaItemsOther.enderStone, 'X', Items.string);
		addRecipe(VanillaItemsWeapons.bluefireBow, " IX", "I X", " IX", 'I', VanillaItemsOther.aquaticBlazeRod, 'X', VanillaItemsOther.bluefireStone);
		addRecipe(VanillaItemsWeapons.infernoBow, " IX", "I X", " IX", 'I', VanillaItemsOther.moltenStone, 'X', Items.blaze_powder);
		
		addRecipe(VanillaItemsWeapons.frostCannon, "I I", "I I", "XXX", 'I', VanillaItemsOther.shadowBar, 'X', IceikaItems.iceStone);
		addRecipe(VanillaItemsWeapons.bowheadCannon, " I ", " I ", " X ", 'I', VanillaItemsOther.whaleFin, 'X', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.crabclawCannon, " I ", " I ", " X ", 'I', VanillaItemsOther.crabClaw, 'X', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.corruptedCannon, "III", "S S", 'I', VanillaItemsOther.corruptedStone, 'S', Items.stick);
		
		addRecipe(VanillaItemsWeapons.goldenFury, "III", "IXI", "IXI", 'I', VanillaItemsOther.furyFire, 'X', Blocks.gold_block);
		
		//Tools
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
		addRecipe(VanillaItemsTools.arlemiteHoe, "II ", " S ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', Items.stick);
		addShapelessRecipe(VanillaItemsTools.arlemiteShickaxe, VanillaItemsTools.arlemitePickaxe, VanillaItemsTools.arlemiteShovel, VanillaItemsTools.arlemiteAxe, VanillaItemsTools.arlemiteHoe);
		
		addRecipe(VanillaItemsTools.rupeePickaxe, "III", " S ", " S ", 'I', VanillaItemsOther.rupeeIngot, 'S', Items.stick);
		addRecipe(VanillaItemsTools.rupeeShovel, " I ", " S ", " S ", 'I', VanillaItemsOther.rupeeIngot, 'S', Items.stick);
		addRecipe(VanillaItemsTools.rupeeAxe, "II ", "IS ", " S ", 'I', VanillaItemsOther.rupeeIngot, 'S', Items.stick);
		addRecipe(VanillaItemsTools.rupeeHoe, "II ", " S ", " S ", 'I', VanillaItemsOther.rupeeIngot, 'S', Items.stick);
		addShapelessRecipe(VanillaItemsTools.rupeeShickaxe, VanillaItemsTools.rupeePickaxe, VanillaItemsTools.rupeeShovel, VanillaItemsTools.rupeeAxe, VanillaItemsTools.rupeeHoe);
		
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
		
		addRecipe(VanillaItemsArmor.diamondHelmet, "III", "I I",  'I', Items.diamond);
		addRecipe(VanillaItemsArmor.diamondBody, "I I", "III", "III", 'I', Items.diamond);
		addRecipe(VanillaItemsArmor.diamondLegs, "III", "I I", "I I", 'I', Items.diamond);
		addRecipe(VanillaItemsArmor.diamondBoots,  "I I", "I I", 'I', Items.diamond);
		
		addRecipe(VanillaItemsArmor.ironHelmet, "III", "I I",  'I', Items.iron_ingot);
		addRecipe(VanillaItemsArmor.ironBody, "I I", "III", "III", 'I', Items.iron_ingot);
		addRecipe(VanillaItemsArmor.ironLegs, "III", "I I", "I I", 'I', Items.iron_ingot);
		addRecipe(VanillaItemsArmor.ironBoots,  "I I", "I I", 'I', Items.iron_ingot);
		
		addRecipe(VanillaItemsArmor.goldHelmet, "III", "I I",  'I', Items.gold_ingot);
		addRecipe(VanillaItemsArmor.goldBody, "I I", "III", "III", 'I', Items.gold_ingot);
		addRecipe(VanillaItemsArmor.goldLegs, "III", "I I", "I I", 'I', Items.gold_ingot);
		addRecipe(VanillaItemsArmor.goldBoots,  "I I", "I I", 'I', Items.gold_ingot);
		
		addRecipe(VanillaItemsArmor.leatherHelmet, "III", "I I",  'I', Items.leather);
		addRecipe(VanillaItemsArmor.leatherBody, "I I", "III", "III", 'I', Items.leather);
		addRecipe(VanillaItemsArmor.leatherLegs, "III", "I I", "I I", 'I', Items.leather);
		addRecipe(VanillaItemsArmor.leatherBoots,  "I I", "I I", 'I', Items.leather);
		
		addRecipe(VanillaItemsArmor.realmiteHelmet, "III", "I I",  'I', VanillaItemsOther.realmiteIngot);
		addRecipe(VanillaItemsArmor.realmiteBody, "I I", "III", "III", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(VanillaItemsArmor.realmiteLegs, "III", "I I", "I I", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(VanillaItemsArmor.realmiteBoots,  "I I", "I I", 'I', VanillaItemsOther.realmiteIngot);
		
		addRecipe(VanillaItemsArmor.eliteRealmiteHelmet, "III", "I I", 'I', VanillaBlocks.realmiteBlock);
		addRecipe(VanillaItemsArmor.eliteRealmiteBody, "I I", "III", "III", 'I', VanillaBlocks.realmiteBlock);
		addRecipe(VanillaItemsArmor.eliteRealmiteLegs, "III", "I I", "I I", 'I', VanillaBlocks.realmiteBlock);
		addRecipe(VanillaItemsArmor.eliteRealmiteBoots,  "I I", "I I", 'I', VanillaBlocks.realmiteBlock);
		
		addRecipe(VanillaItemsArmor.bedrockHelmet, "III", "I I", 'I', Blocks.bedrock);
		addRecipe(VanillaItemsArmor.bedrockBody, "I I", "III", "III", 'I', Blocks.bedrock);
		addRecipe(VanillaItemsArmor.bedrockLegs, "III", "I I", "I I", 'I', Blocks.bedrock);
		addRecipe(VanillaItemsArmor.bedrockBoots,  "I I", "I I", 'I', Blocks.bedrock);
		
		addRecipe(VanillaItemsArmor.rupeeHelmet, "III", "I I", 'I', VanillaItemsOther.rupeeIngot);
		addRecipe(VanillaItemsArmor.rupeeBody, "I I", "III", "III", 'I', VanillaItemsOther.rupeeIngot);
		addRecipe(VanillaItemsArmor.rupeeLegs, "III", "I I", "I I", 'I', VanillaItemsOther.rupeeIngot);
		addRecipe(VanillaItemsArmor.rupeeBoots,  "I I", "I I", 'I', VanillaItemsOther.rupeeIngot);
		
		addRecipe(VanillaItemsArmor.arlemiteHelmet, "III", "X X", 'I', VanillaItemsOther.arlemiteIngot ,'X', Items.iron_ingot);
		addRecipe(VanillaItemsArmor.arlemiteBody, "I I", "XIX", "IXI", 'I', VanillaItemsOther.arlemiteIngot, 'X', Items.iron_ingot);
		addRecipe(VanillaItemsArmor.arlemiteLegs, "XXX", "I I", "S S", 'I', VanillaItemsOther.arlemiteIngot, 'X', Items.iron_ingot, 'S', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsArmor.arlemiteBoots,  "X X", "I I", 'I', VanillaItemsOther.arlemiteIngot, 'X', Items.iron_ingot);
		
		addRecipe(VanillaItemsArmor.infernoHelmet, "III", "I I", 'I', VanillaItemsOther.moltenStone);
		addRecipe(VanillaItemsArmor.infernoBody, "I I", "III", "III", 'I', VanillaItemsOther.moltenStone);
		addRecipe(VanillaItemsArmor.infernoLegs ,"III", "I I", "I I", 'I', VanillaItemsOther.moltenStone);
		addRecipe(VanillaItemsArmor.infernoBoots,  "I I", "I I", 'I', VanillaItemsOther.moltenStone);
		
		addRecipe(VanillaItemsArmor.netheriteHelmet, "SIS", "I I", 'I', VanillaItemsOther.netheriteChunk, 'S', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsArmor.netheriteBody, "I I", "ISI", "ISI", 'I', VanillaItemsOther.netheriteChunk, 'S', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsArmor.netheriteLegs, "SSS", "I I", "S S", 'I', VanillaItemsOther.netheriteChunk, 'S', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsArmor.netheriteBoots,  "S S", "I I", 'I', VanillaItemsOther.netheriteChunk, 'S', VanillaItemsOther.shadowBar);
		
		addRecipe(VanillaItemsArmor.enderHelmet, "III", "I I", 'I', VanillaItemsOther.enderStone);
		addRecipe(VanillaItemsArmor.enderBody, "I I", "III", "III", 'I', VanillaItemsOther.enderStone);
		addRecipe(VanillaItemsArmor.enderLegs, "III", "I I", "I I", 'I', VanillaItemsOther.enderStone);
		addRecipe(VanillaItemsArmor.enderBoots,  "I I", "I I", 'I', VanillaItemsOther.enderStone);
		
		addRecipe(VanillaItemsArmor.divineHelmet, "III", "I I", 'I', VanillaItemsOther.divineStone);
		addRecipe(VanillaItemsArmor.divineBody, "I I", "III", "III", 'I', VanillaItemsOther.divineStone);
		addRecipe(VanillaItemsArmor.divineLegs, "III", "I I", "I I", 'I', VanillaItemsOther.divineStone);
		addRecipe(VanillaItemsArmor.divineBoots,  "I I", "I I", 'I', VanillaItemsOther.divineStone);
		
		addRecipe(VanillaItemsArmor.angelicHelmet, "XXX", "I I", 'I', VanillaItemsOther.bluefireStone, 'X', IceikaItems.iceStone);
		addRecipe(VanillaItemsArmor.angelicBody, "I I", "XIX", "XXX", 'I', VanillaItemsOther.bluefireStone, 'X', IceikaItems.iceStone);
		addRecipe(VanillaItemsArmor.angelicLegs, "III", "X X", "X X", 'I', VanillaItemsOther.bluefireStone, 'X', IceikaItems.iceStone);
		addRecipe(VanillaItemsArmor.angelicBoots,  "I I", "X X", 'I', VanillaItemsOther.bluefireStone, 'X', IceikaItems.iceStone);
		
		addRecipe(VanillaItemsArmor.shadowHelmet, "III", "I I", 'I', VanillaItemsOther.shadowBar);//TODO: use shadow stones somehow.
		addRecipe(VanillaItemsArmor.shadowBody, "I I", "III", "III", 'I', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsArmor.shadowLegs, "III", "I I", "I I", 'I', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsArmor.shadowBoots,  "I I", "I I", 'I', VanillaItemsOther.shadowBar);
		
		addRecipe(VanillaItemsArmor.aquastriveHelmet, "III", "I I", 'I', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsArmor.aquastriveBody, "I I", "III", "III", 'I', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsArmor.aquastriveLegs, "III", "I I", "I I", 'I', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsArmor.aquastriveBoots,  "I I", "I I", 'I', VanillaItemsOther.aquaticIngot);
		
		addRecipe(VanillaItemsArmor.krakenHelmet, "III", "I I", 'I', VanillaItemsOther.krakenSkin);
		addRecipe(VanillaItemsArmor.krakenBody, "I I", "III", "III", 'I', VanillaItemsOther.krakenSkin);
		addRecipe(VanillaItemsArmor.krakenLegs, "III", "I I", "I I", 'I', VanillaItemsOther.krakenSkin);
		addRecipe(VanillaItemsArmor.krakenBoots,  "I I", "I I", 'I', VanillaItemsOther.krakenSkin);
		
		addRecipe(VanillaItemsArmor.jungleHelmet, "III", "I I", 'I', VanillaItemsOther.jungleStone);
		addRecipe(VanillaItemsArmor.jungleBody, "I I", "III", "III", 'I', VanillaItemsOther.jungleStone);
		addRecipe(VanillaItemsArmor.jungleLegs, "III", "I I", "I I", 'I', VanillaItemsOther.jungleStone);
		addRecipe(VanillaItemsArmor.jungleBoots,  "I I", "I I", 'I', VanillaItemsOther.jungleStone);
		
		addRecipe(VanillaItemsArmor.frozenHelmet, "III", "I I", 'I', IceikaItems.iceStone);
		addRecipe(VanillaItemsArmor.frozenBody, "I I", "III", "III", 'I', IceikaItems.iceStone);
		addRecipe(VanillaItemsArmor.frozenLegs, "III", "I I", "I I", 'I', IceikaItems.iceStone);
		addRecipe(VanillaItemsArmor.frozenBoots,  "I I", "I I", 'I', IceikaItems.iceStone);
		
		addRecipe(VanillaItemsArmor.corruptedHelmet, "III", "I I", 'I', VanillaItemsOther.corruptedStone);
		addRecipe(VanillaItemsArmor.corruptedBody, "I I", "III", "III", 'I', VanillaItemsOther.corruptedStone);
		addRecipe(VanillaItemsArmor.corruptedLegs, "III", "I I", "I I", 'I', VanillaItemsOther.corruptedStone);
		addRecipe(VanillaItemsArmor.corruptedBoots,  "I I", "I I", 'I', VanillaItemsOther.corruptedStone);
		
		//Armor Dye
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.redRupeeHelmet), VanillaItemsArmor.rupeeHelmet, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.redRupeeBody), VanillaItemsArmor.rupeeBody, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.redRupeeLegs), VanillaItemsArmor.rupeeLegs, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.redRupeeBoots), VanillaItemsArmor.rupeeBoots, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.greenRupeeHelmet), VanillaItemsArmor.rupeeHelmet, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.greenRupeeBody), VanillaItemsArmor.rupeeBody, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.greenRupeeLegs), VanillaItemsArmor.rupeeLegs, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.greenRupeeBoots), VanillaItemsArmor.rupeeBoots, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.blueRupeeHelmet), VanillaItemsArmor.rupeeHelmet, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.blueRupeeBody), VanillaItemsArmor.rupeeBody, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.blueRupeeLegs), VanillaItemsArmor.rupeeLegs, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.blueRupeeBoots), VanillaItemsArmor.rupeeBoots, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.yellowRupeeHelmet), VanillaItemsArmor.rupeeHelmet, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.yellowRupeeBody), VanillaItemsArmor.rupeeBody, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.yellowRupeeLegs), VanillaItemsArmor.rupeeLegs, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.yellowRupeeBoots), VanillaItemsArmor.rupeeBoots, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.grayRupeeHelmet), VanillaItemsArmor.rupeeHelmet, VanillaItemsOther.grayDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.grayRupeeBody), VanillaItemsArmor.rupeeBody, VanillaItemsOther.grayDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.grayRupeeLegs), VanillaItemsArmor.rupeeLegs, VanillaItemsOther.grayDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.grayRupeeBoots), VanillaItemsArmor.rupeeBoots, VanillaItemsOther.grayDiamondChunk);
		
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.redEnderHelmet), VanillaItemsArmor.enderHelmet, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.redEnderBody), VanillaItemsArmor.enderBody, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.redEnderLegs), VanillaItemsArmor.enderLegs, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.redEnderBoots), VanillaItemsArmor.enderBoots, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.greenEnderHelmet), VanillaItemsArmor.enderHelmet, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.greenEnderBody), VanillaItemsArmor.enderBody, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.greenEnderLegs), VanillaItemsArmor.enderLegs, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.greenEnderBoots), VanillaItemsArmor.enderBoots, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.blueEnderHelmet), VanillaItemsArmor.enderHelmet, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.blueEnderBody), VanillaItemsArmor.enderBody, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.blueEnderLegs), VanillaItemsArmor.enderLegs, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.blueEnderBoots), VanillaItemsArmor.enderBoots, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.yellowEnderHelmet), VanillaItemsArmor.enderHelmet, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.yellowEnderBody), VanillaItemsArmor.enderBody, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.yellowEnderLegs), VanillaItemsArmor.enderLegs, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.yellowEnderBoots), VanillaItemsArmor.enderBoots, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.grayEnderHelmet), VanillaItemsArmor.enderHelmet, VanillaItemsOther.grayDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.grayEnderBody), VanillaItemsArmor.enderBody, VanillaItemsOther.grayDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.grayEnderLegs), VanillaItemsArmor.enderLegs, VanillaItemsOther.grayDiamondChunk);
		addShapelessRecipe(new ItemStack(VanillaItemsArmor.grayEnderBoots), VanillaItemsArmor.enderBoots, VanillaItemsOther.grayDiamondChunk);
		
		//misc
		addRecipe(VanillaItemsOther.netheriteChunk, " I ", "III", " I ", 'I', VanillaItemsOther.netheriteIngot);
		addShapelessRecipe(IS.eyeShards, VanillaItemsOther.cyclopsEye);

		addRecipe(VanillaBlocks.arlemiteBlock, "III", "III", "III", 'I', VanillaItemsOther.arlemiteIngot);
		addRecipe(VanillaBlocks.rupeeBlock, "III", "III", "III", 'I', VanillaItemsOther.rupeeIngot);
		addRecipe(VanillaBlocks.realmiteBlock, "III", "III", "III", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(VanillaBlocks.netheriteBlock, "III", "III", "III", 'I', VanillaItemsOther.netheriteIngot);
		addRecipe(VanillaBlocks.bloodgemBlock, "III", "III", "III", 'I', VanillaItemsOther.bloodgem);
		
		addRecipe(new ItemStack(VanillaBlocks.steel, 1, 0),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', new ItemStack(Items.dye, 1, 6));
		addRecipe(new ItemStack(VanillaBlocks.steel, 1, 1),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', new ItemStack(Items.dye, 1, 1));
		addRecipe(new ItemStack(VanillaBlocks.steel, 1, 2),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', new ItemStack(Items.dye, 1, 5));
		addRecipe(new ItemStack(VanillaBlocks.steel, 1, 3),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', new ItemStack(Items.dye, 1, 2));
		addRecipe(new ItemStack(VanillaBlocks.steel, 1, 4),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', new ItemStack(Items.dye, 1, 11));
		addRecipe(new ItemStack(VanillaBlocks.steel, 1, 5),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', new ItemStack(Items.dye, 1, 4));
		addRecipe(new ItemStack(VanillaBlocks.steel, 1, 6),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', new ItemStack(Items.dye, 1, 15));
		addRecipe(new ItemStack(VanillaBlocks.steel, 1, 7),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', new ItemStack(Items.dye, 1, 0));
		addRecipe(new ItemStack(VanillaBlocks.steel, 1, 8),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', new ItemStack(Items.dye, 1, 14));
		addRecipe(new ItemStack(VanillaBlocks.steel, 1, 9),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', new ItemStack(Items.dye, 1, 13));
		
		addShapelessRecipe(new ItemStack(VanillaBlocks.milkStone, 4),  Blocks.stone, Blocks.stone, Blocks.stone, Items.milk_bucket);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 10),  Blocks.obsidian, Blocks.glowstone);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 13),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, Items.redstone);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 5),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, new ItemStack(Items.dye, 1, 2));
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 10),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, new ItemStack(Items.dye, 1, 9));
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 11),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, new ItemStack(Items.dye, 1, 5));
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 7),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, new ItemStack(Items.dye, 1, 4));
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 9),  VanillaItemsOther.netheriteIngot);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 12),  VanillaItemsOther.realmiteIngot, VanillaItemsOther.realmiteIngot, VanillaItemsOther.realmiteIngot, VanillaItemsOther.realmiteIngot, VanillaItemsOther.realmiteIngot);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 4),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, Items.gold_ingot);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 6),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, Items.iron_ingot);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 2),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, new ItemStack(Items.dye, 1, 0));
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 14),  VanillaBlocks.milkStone, VanillaBlocks.milkStone, VanillaBlocks.milkStone, VanillaBlocks.milkStone);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 0),  VanillaItemsOther.aquaBall, Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick);
		addRecipe(new ItemStack(VanillaBlocks.divineBricks, 10, 1),  "xyx", "yxy", "xyx", 'x', VanillaItemsOther.arlemiteIngot, 'y', Blocks.stonebrick);
		
		addRecipe(new ItemStack(VanillaBlocks.lamp2, 1, 10),  "xxx", "xyx", "xzx", 'x', Items.iron_ingot, 'y', VanillaItemsOther.rupeeIngot, 'z', Blocks.glowstone);
		addRecipe(new ItemStack(VanillaBlocks.lamp1, 1, 0),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', Items.water_bucket);
		addRecipe(new ItemStack(VanillaBlocks.lamp1, 1, 2),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', Items.blaze_rod);
		addRecipe(new ItemStack(VanillaBlocks.lamp1, 1, 6),  "xxx", "zyz", "xxx", 'x', Items.iron_ingot, 'y', Items.lava_bucket, 'z', Blocks.gold_block);
		addRecipe(new ItemStack(VanillaBlocks.lamp1, 1, 1),  "xxx", "xyx", "xzx", 'x', Items.iron_ingot, 'y', VanillaItemsOther.arlemiteIngot, 'z', Blocks.glowstone);
		addRecipe(new ItemStack(VanillaBlocks.lamp1, 1, 8),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', Items.ender_eye);
		addRecipe(new ItemStack(VanillaBlocks.lamp2, 1, 2),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', VanillaItemsOther.krakenSkin);
		addRecipe(new ItemStack(VanillaBlocks.lamp2, 1, 4),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', Items.lava_bucket);
		addRecipe(new ItemStack(VanillaBlocks.lamp2, 1, 5),  "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', Items.milk_bucket);
		addRecipe(new ItemStack(VanillaBlocks.lamp2, 1, 8),  "xxx", "xyx", "xzx", 'x', Items.iron_ingot, 'y', VanillaItemsOther.realmiteIngot, 'z', Blocks.glowstone);
		addRecipe(new ItemStack(VanillaBlocks.lamp1, 1, 4),  "xxx", "xyx", "xzx", 'x', Items.iron_ingot, 'y', Items.diamond, 'z', Blocks.glowstone);
		addRecipe(new ItemStack(VanillaBlocks.lamp1, 1, 10),  "xxx", "xyx", "xzx", 'x', Items.iron_ingot, 'y', Items.gold_ingot, 'z', Blocks.glowstone);
		addRecipe(new ItemStack(VanillaBlocks.lamp2, 1, 9),  "xxx", "xyx", "xzx", 'x', Items.iron_ingot, 'y', Items.redstone, 'z', Blocks.glowstone);
		addRecipe(new ItemStack(VanillaBlocks.lamp2, 1, 3),  "xxx", "xyx", "xzx", 'x', Items.iron_ingot, 'y', new ItemStack(Items.dye, 1, 4), 'z', Blocks.glowstone);
		addRecipe(new ItemStack(VanillaBlocks.lamp2, 1, 7),  "xxx", "xyx", "xzx", 'x', Items.iron_ingot, 'y', VanillaItemsOther.netheriteIngot, 'z', Blocks.glowstone);
		addRecipe(new ItemStack(VanillaBlocks.lamp1, 1, 7),  "xxx", "xyx", "xxx", 'y', TwilightItemsOther.edenFragments, 'x', Items.iron_ingot);
		addShapelessRecipe(new ItemStack(VanillaBlocks.lamp1, 2, 5),  Blocks.glowstone, VanillaItemsOther.divineStone);
		addShapelessRecipe(new ItemStack(VanillaBlocks.lamp2, 2, 1),  Blocks.glowstone, VanillaItemsOther.jungleStone);
		addShapelessRecipe(new ItemStack(VanillaBlocks.lamp2, 2, 0),  Blocks.glowstone, IceikaItems.iceStone);
		addShapelessRecipe(new ItemStack(VanillaBlocks.lamp1, 2, 9),  Blocks.glowstone, VanillaItemsOther.enderStone);
		addShapelessRecipe(new ItemStack(VanillaBlocks.lamp2, 2, 6),  Blocks.glowstone, VanillaItemsOther.moltenStone);
		addShapelessRecipe(new ItemStack(VanillaBlocks.lamp1, 2, 3),  Blocks.glowstone, VanillaItemsOther.bluefireStone);
		
		addRecipe(VanillaBlocks.boneChest, "bbb", "b b", "bbb", 'b', Items.bone);
		
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
		addShapelessRecipe(VanillaItemsOther.shadowBar, VanillaItemsOther.rupeeIngot, VanillaItemsOther.arlemiteIngot);
		
		addRecipe(VanillaItemsOther.pureAquaticPellets, "PPP", "PPP", "PPP", 'P', VanillaItemsOther.aquaticPellets);
		addRecipe(VanillaItemsOther.aquaBall,"wsw", "wkw", "wsw", 'w', Items.water_bucket, 's', Items.slime_ball, 'k', VanillaItemsOther.krakenSkin);
		
		addRecipe(VanillaItemsOther.corruptedStone, "III", "III", "III", 'I', VanillaItemsOther.corruptedShards);
		addRecipe(VanillaItemsOther.jungleStone, "III", "III", "III", 'I', VanillaItemsOther.jungleShards);
		addRecipe(IceikaItems.iceStone, "III", "III", "III", 'I', IceikaItems.iceShards);
		addRecipe(VanillaItemsOther.moltenStone, "III", "III", "III", 'I', VanillaItemsOther.moltenShards);
		addRecipe(VanillaItemsOther.divineStone, "III", "III", "III", 'I', VanillaItemsOther.divineShards);
		addRecipe(VanillaItemsOther.enderStone, "III", "III", "III", 'I', VanillaItemsOther.enderShard);

		addRecipe(VanillaItemsOther.legendaryEnderEye, "III", "III", "III", 'I', VanillaItemsOther.enderStone);
		
		addRecipe(VanillaItemsOther.krakenScale, "K K", "K K", "KKK", 'K', new ItemStack(Items.dye, 1, 0));
		addShapelessRecipe(VanillaItemsOther.krakenSkin, VanillaItemsOther.krakenScale, VanillaItemsOther.krakenScale);
		
		addShapelessRecipe(IS.bacon, Items.porkchop);
		addRecipe(IS.cheese, "MMM", "MMM", "MMM", 'M', Items.milk_bucket);
		addSmelting(Items.egg, ItemsFood.boiledEgg, 0.3F);
		addShapelessRecipe(ItemsFood.advMushroomStew, ItemsFood.whiteMushroom, Items.mushroom_stew);
		addShapelessRecipe(ItemsFood.chickenDinner, ItemsFood.advMushroomStew, Items.cooked_chicken, Items.bread);
		
		addShapelessRecipe(new ItemStack(VanillaBlocks.divinePlank, 4), VanillaBlocks.divineWood);
	}
}
