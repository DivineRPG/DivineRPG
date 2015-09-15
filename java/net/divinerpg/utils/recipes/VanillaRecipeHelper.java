package net.divinerpg.utils.recipes;

import net.divinerpg.DivineRPG;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.ArcanaItems;
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
		
		addOredictRecipe(VanillaItemsWeapons.frostSword, " I ", " I ", " S ", 'I', IceikaItems.iceStone, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.bloodgemSword, " I ", " I ", " S ", 'I', VanillaItemsOther.bloodgem, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.infernoSword, "BOB", "BOB", "BSB", 'B', Items.blaze_powder, 'O', Blocks.redstone_ore, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.moltenSword, " I ", " I ", " S ", 'I', VanillaItemsOther.moltenStone, 'S', "stickWood");
		addRecipe(VanillaItemsWeapons.scorchingSword, " I ", " I ", " S ", 'I', VanillaItemsOther.purpleBlaze, 'S', VanillaItemsOther.netheriteIngot);
		addRecipe(VanillaItemsWeapons.bluefireSword, " I ", " I ", " S ", 'I', VanillaItemsOther.bluefireStone, 'S', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsWeapons.flamingFury, "XIX", "XIX", "XOX", 'I', VanillaItemsOther.furyFire, 'X', VanillaItemsWeapons.infernoSword, 'O', VanillaItemsOther.shadowBar);
		addOredictRecipe(VanillaItemsWeapons.poisonSaber, " R ", "BRB", "BSB", 'R', VanillaItemsOther.jungleStone, 'B', VanillaItemsOther.shadowBar, 'S', "stickWood");
		addRecipe(VanillaItemsWeapons.enderSword, " L ", " L ", " S ", 'L', VanillaItemsOther.legendaryEnderEye, 'S', VanillaItemsOther.shadowBar);
		addOredictRecipe(VanillaItemsWeapons.arlemiteSword, " I ", " I ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.rupeeSword, " I ", " I ", " S ", 'I', VanillaItemsOther.rupeeIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.realmiteSword, " I ", " I ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', "stickWood");
		addRecipe(VanillaItemsWeapons.slimeSword, "SDS", "SDS", "SDS", 'D', Items.diamond_sword, 'S', Items.slime_ball);
		addOredictRecipe(VanillaItemsWeapons.oceanKnife, " I ", " I ", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.aquaticDagger, "   ", " I ", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.aquaticMaul, "III", "III", "ISI", 'I', VanillaItemsOther.aquaticIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.aquaticTrident, " I ", "III", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.aquaton, "III", "III", " S ", 'I', VanillaItemsOther.aquaticIngot, 'S', "stickWood");
		addRecipe(VanillaItemsWeapons.sharkSword, " I ", " I ", " S ", 'I', VanillaItemsOther.sharkFin, 'S', VanillaItemsOther.aquaticIngot);
		addOredictRecipe(VanillaItemsWeapons.crabclawMaul, "III", "ISI", " S ", 'I', VanillaItemsOther.crabClaw, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.bedrockSword, " B ", " B ", " S ", 'B', Blocks.bedrock, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.divineSword, " I ", "III", " S ", 'I', VanillaItemsOther.divineStone, 'S', "stickWood");
		addRecipe(VanillaItemsWeapons.furyMaul, "OBO", "BBB", "OBO", 'B', Blocks.bedrock, 'O', Blocks.diamond_ore);
		addOredictRecipe(VanillaItemsWeapons.deathBringer, " I ", "ISI", " S ", 'I', VanillaItemsOther.corruptedStone, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.corruptedMaul, "III", "ISI", " S ", 'I', VanillaItemsOther.corruptedStone, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.bedrockMaul, " B ", "BBB", " I ", 'B', Blocks.bedrock, 'I', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.jungleKnife, " I ", " I ", " S ", 'I', VanillaItemsOther.jungleStone, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.cyclopsianSword, " E ", " E ", " S ", 'E', VanillaItemsOther.cyclopsEye, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.cyclopsianStaff, " E ", " S ", " S ", 'E', VanillaItemsOther.cyclopsEye, 'S', "stickWood");
		addRecipe(new ItemStack(VanillaItemsWeapons.dualClaw), " C ", "AAA", " C ", 'C', VanillaItemsOther.crabClaw, 'A', VanillaItemsOther.aquaticIngot);
		addOredictRecipe(VanillaItemsWeapons.terranDagger, " T ", " S ", 'T', VanillaItemsOther.terranStone, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.terranKnife, " T ", " T ", " S ", 'T', VanillaItemsOther.terranStone, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.terranMaul, "TTT", " T ", " S ", 'T', VanillaItemsOther.terranStone, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.aquatoothSword, " T ", "TKT", " S ", 'T', VanillaItemsOther.liopleurodonTeeth, 'K', VanillaItemsOther.liopleurodonSkull, 'S', "stickWood");
		addOredictRecipe(VanillaItemsWeapons.aquatoothMaul, "TKT", "TKT", "KSK", 'T', VanillaItemsOther.liopleurodonTeeth, 'K', VanillaItemsOther.liopleurodonSkull, 'S', "stickWood");
		addRecipe(new ItemStack(VanillaItemsWeapons.jungleRapier), "S S", "SBS", " B ", 'S', VanillaItemsOther.jungleStone, 'B', VanillaItemsOther.shadowBar);
		
		//ranged weapons
		addRecipe(IS.shuriken, " I ", "III", " I ", 'I', Items.iron_ingot);
		addRecipe(new ItemStack(VanillaItemsWeapons.vileStorm, 8), "SSS", "SJS", "SSS", 'J', VanillaItemsOther.jungleShards, 'S', VanillaItemsWeapons.shuriken);
		addRecipe(IceikaItems.soundOfMusic, "III", "IXI", "III", 'I', VanillaItemsOther.purpleBlaze, 'X', Items.string);
		addRecipe(VanillaItemsWeapons.maelstrom, "III", "IXI", "III", 'I', VanillaItemsOther.purpleBlaze, 'X', Items.book);
		addRecipe(VanillaItemsWeapons.ghastCannon, "I I", "I I", "XXX", 'I', VanillaItemsOther.shadowBar, 'X', VanillaItemsOther.hellstoneIngot);
		addRecipe(VanillaItemsWeapons.liopleurodonAnchor, "SIS", "IXI", " X ", 'I', VanillaItemsOther.liopleurodonTeeth, 'X', VanillaItemsOther.aquaticIngot, 'S', VanillaItemsOther.liopleurodonSkull);
		addRecipe(VanillaItemsWeapons.bowheadAnchor, "III", "IXI", " X ", 'I', VanillaItemsOther.whaleFin, 'X', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.sharkAnchor, "III", "IXI", " X ", 'I', VanillaItemsOther.sharkFin, 'X', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.crabAnchor, "III", "IXI", " X ", 'I', VanillaItemsOther.crabClaw, 'X', VanillaItemsOther.aquaticIngot);
		
		addRecipe(VanillaItemsWeapons.hunterBow, " IX", "I X", " IX", 'I', VanillaItemsOther.jungleStone, 'X', Items.string);
		addRecipe(VanillaItemsWeapons.shadowBow, " IX", "I X", " IX", 'I', VanillaItemsOther.shadowBar, 'X', Items.string);
		addRecipe(VanillaItemsWeapons.enderBow, " IX", "E X", " IX", 'I', VanillaItemsOther.enderStone, 'X', Items.string, 'E', VanillaItemsOther.watchingEye);
		addRecipe(VanillaItemsWeapons.bluefireBow, " IX", "I X", " IX", 'I', VanillaItemsOther.aquaticBlazeRod, 'X', VanillaItemsOther.bluefireStone);
		addRecipe(VanillaItemsWeapons.infernoBow, " IX", "I X", " IX", 'I', VanillaItemsOther.moltenStone, 'X', Items.blaze_powder);
		
		addRecipe(VanillaItemsWeapons.frostCannon, "I I", "I I", "XXX", 'I', VanillaItemsOther.shadowBar, 'X', IceikaItems.iceStone);
		addRecipe(VanillaItemsWeapons.bowheadCannon, " I ", " I ", " X ", 'I', VanillaItemsOther.whaleFin, 'X', VanillaItemsOther.aquaticIngot);
		addRecipe(VanillaItemsWeapons.crabclawCannon, " I ", " I ", " X ", 'I', VanillaItemsOther.crabClaw, 'X', VanillaItemsOther.aquaticIngot);
		addOredictRecipe(VanillaItemsWeapons.corruptedCannon, "III", "S S", 'I', VanillaItemsOther.corruptedStone, 'S', "stickWood");
		
		addRecipe(VanillaItemsWeapons.goldenFury, "GGG", "GFG", "FFF", 'F', VanillaItemsOther.furyFire, 'G', Blocks.gold_block);
		
		//Tools
		addOredictRecipe(VanillaItemsTools.realmitePickaxe, "III", " S ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.realmiteShovel, " I ", " S ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.realmiteAxe, "II ", "IS ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.realmiteHoe, "II ", " S ", " S ", 'I', VanillaItemsOther.realmiteIngot, 'S', "stickWood");
		
		addOredictRecipe(VanillaItemsTools.corruptedPickaxe, "III", " S ", " S ", 'I', VanillaItemsOther.corruptedStone, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.corruptedShovel, " I ", " S ", " S ", 'I', VanillaItemsOther.corruptedStone, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.corruptedAxe, "II ", "IS ", " S ", 'I', VanillaItemsOther.corruptedStone, 'S', "stickWood");
		
		addOredictRecipe(VanillaItemsTools.bedrockPickaxe, "III", " S ", " S ", 'I', Blocks.bedrock, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.bedrockShovel, " I ", " S ", " S ", 'I', Blocks.bedrock, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.bedrockAxe, "II ", "IS ", " S ", 'I', Blocks.bedrock, 'S', "stickWood");
		
		addOredictRecipe(VanillaItemsTools.arlemitePickaxe, "III", " S ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.arlemiteShovel, " I ", " S ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.arlemiteAxe, "II ", "IS ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.arlemiteHoe, "II ", " S ", " S ", 'I', VanillaItemsOther.arlemiteIngot, 'S', "stickWood");
		addShapelessRecipe(VanillaItemsTools.arlemiteShickaxe, VanillaItemsTools.arlemitePickaxe, VanillaItemsTools.arlemiteShovel, VanillaItemsTools.arlemiteAxe, VanillaItemsTools.arlemiteHoe);
		
		addOredictRecipe(VanillaItemsTools.rupeePickaxe, "III", " S ", " S ", 'I', VanillaItemsOther.rupeeIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.rupeeShovel, " I ", " S ", " S ", 'I', VanillaItemsOther.rupeeIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.rupeeAxe, "II ", "IS ", " S ", 'I', VanillaItemsOther.rupeeIngot, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.rupeeHoe, "II ", " S ", " S ", 'I', VanillaItemsOther.rupeeIngot, 'S', "stickWood");
		addShapelessRecipe(VanillaItemsTools.rupeeShickaxe, VanillaItemsTools.rupeePickaxe, VanillaItemsTools.rupeeShovel, VanillaItemsTools.rupeeAxe, VanillaItemsTools.rupeeHoe);
		
		addOredictRecipe(VanillaItemsTools.divinePickaxe, "III", " S ", " S ", 'I', VanillaItemsOther.divineStone, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.divineShovel, " I ", " S ", " S ", 'I', VanillaItemsOther.divineStone, 'S', "stickWood");
		addOredictRecipe(VanillaItemsTools.divineAxe, "II ", "IS ", " S ", 'I', VanillaItemsOther.divineStone, 'S', "stickWood");
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
		addRecipe(VanillaItemsArmor.arlemiteLegs, "III", "X X", "I I", 'I', VanillaItemsOther.arlemiteIngot, 'X', Items.iron_ingot);
		addRecipe(VanillaItemsArmor.arlemiteBoots,  "X X", "I I", 'I', VanillaItemsOther.arlemiteIngot, 'X', Items.iron_ingot);
		
		addRecipe(VanillaItemsArmor.infernoHelmet, "III", "I I", 'I', VanillaItemsOther.moltenStone);
		addRecipe(VanillaItemsArmor.infernoBody, "I I", "III", "III", 'I', VanillaItemsOther.moltenStone);
		addRecipe(VanillaItemsArmor.infernoLegs ,"III", "I I", "I I", 'I', VanillaItemsOther.moltenStone);
		addRecipe(VanillaItemsArmor.infernoBoots,  "I I", "I I", 'I', VanillaItemsOther.moltenStone);
		
		addRecipe(VanillaItemsArmor.netheriteHelmet, "III", "S S", 'I', VanillaBlocks.netheriteBlock, 'S', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsArmor.netheriteBody, "S S", "III", "III", 'I', VanillaBlocks.netheriteBlock, 'S', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsArmor.netheriteLegs, "III", "S S", "I I", 'I', VanillaBlocks.netheriteBlock, 'S', VanillaItemsOther.shadowBar);
		addRecipe(VanillaItemsArmor.netheriteBoots,  "S S", "I I", 'I', VanillaBlocks.netheriteBlock, 'S', VanillaItemsOther.shadowBar);
		
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
		
		addRecipe(VanillaItemsArmor.shadowHelmet, "III", "I I", 'I', VanillaItemsOther.shadowStone);
		addRecipe(VanillaItemsArmor.shadowBody, "I I", "III", "III", 'I', VanillaItemsOther.shadowStone);
		addRecipe(VanillaItemsArmor.shadowLegs, "III", "I I", "I I", 'I', VanillaItemsOther.shadowStone);
		addRecipe(VanillaItemsArmor.shadowBoots,  "I I", "I I", 'I', VanillaItemsOther.shadowStone);
		
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
		
		addRecipe(VanillaItemsArmor.terranHelmet, "III", "I I", 'I', VanillaItemsOther.terranStone);
        addRecipe(VanillaItemsArmor.terranBody, "I I", "III", "III", 'I', VanillaItemsOther.terranStone);
        addRecipe(VanillaItemsArmor.terranLegs, "III", "I I", "I I", 'I', VanillaItemsOther.terranStone);
        addRecipe(VanillaItemsArmor.terranBoots,  "I I", "I I", 'I', VanillaItemsOther.terranStone);
		
		//Colorable Weapons / Armor
		addShapelessRecipe(VanillaItemsArmor.redRupeeHelmet, VanillaItemsArmor.rupeeHelmet, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.redRupeeBody, VanillaItemsArmor.rupeeBody, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.redRupeeLegs, VanillaItemsArmor.rupeeLegs, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.redRupeeBoots, VanillaItemsArmor.rupeeBoots, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.greenRupeeHelmet, VanillaItemsArmor.rupeeHelmet, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.greenRupeeBody, VanillaItemsArmor.rupeeBody, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.greenRupeeLegs, VanillaItemsArmor.rupeeLegs, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.greenRupeeBoots, VanillaItemsArmor.rupeeBoots, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.blueRupeeHelmet, VanillaItemsArmor.rupeeHelmet, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.blueRupeeBody, VanillaItemsArmor.rupeeBody, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.blueRupeeLegs, VanillaItemsArmor.rupeeLegs, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.blueRupeeBoots, VanillaItemsArmor.rupeeBoots, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.yellowRupeeHelmet, VanillaItemsArmor.rupeeHelmet, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.yellowRupeeBody, VanillaItemsArmor.rupeeBody, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.yellowRupeeLegs, VanillaItemsArmor.rupeeLegs, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.yellowRupeeBoots, VanillaItemsArmor.rupeeBoots, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.grayRupeeHelmet, VanillaItemsArmor.rupeeHelmet, VanillaItemsOther.grayDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.grayRupeeBody, VanillaItemsArmor.rupeeBody, VanillaItemsOther.grayDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.grayRupeeLegs, VanillaItemsArmor.rupeeLegs, VanillaItemsOther.grayDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.grayRupeeBoots, VanillaItemsArmor.rupeeBoots, VanillaItemsOther.grayDiamondChunk);
		
		addShapelessRecipe(VanillaItemsArmor.redEnderHelmet, VanillaItemsArmor.enderHelmet, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.redEnderBody, VanillaItemsArmor.enderBody, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.redEnderLegs, VanillaItemsArmor.enderLegs, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.redEnderBoots, VanillaItemsArmor.enderBoots, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.greenEnderHelmet, VanillaItemsArmor.enderHelmet, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.greenEnderBody, VanillaItemsArmor.enderBody, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.greenEnderLegs, VanillaItemsArmor.enderLegs, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.greenEnderBoots, VanillaItemsArmor.enderBoots, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.blueEnderHelmet, VanillaItemsArmor.enderHelmet, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.blueEnderBody, VanillaItemsArmor.enderBody, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.blueEnderLegs, VanillaItemsArmor.enderLegs, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.blueEnderBoots, VanillaItemsArmor.enderBoots, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.yellowEnderHelmet, VanillaItemsArmor.enderHelmet, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.yellowEnderBody, VanillaItemsArmor.enderBody, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.yellowEnderLegs, VanillaItemsArmor.enderLegs, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.yellowEnderBoots, VanillaItemsArmor.enderBoots, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.grayEnderHelmet, VanillaItemsArmor.enderHelmet, VanillaItemsOther.grayDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.grayEnderBody, VanillaItemsArmor.enderBody, VanillaItemsOther.grayDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.grayEnderLegs, VanillaItemsArmor.enderLegs, VanillaItemsOther.grayDiamondChunk);
		addShapelessRecipe(VanillaItemsArmor.grayEnderBoots, VanillaItemsArmor.enderBoots, VanillaItemsOther.grayDiamondChunk);
		
		addShapelessRecipe(VanillaItemsOther.redDiamondChunk, Items.diamond, VanillaItemsOther.netheriteChunk);
		addShapelessRecipe(VanillaItemsOther.greenDiamondChunk, Items.diamond, VanillaItemsOther.arlemiteIngot);
		addShapelessRecipe(VanillaItemsOther.blueDiamondChunk, Items.diamond, VanillaItemsOther.rupeeIngot);
		addShapelessRecipe(VanillaItemsOther.yellowDiamondChunk, Items.diamond, VanillaItemsOther.realmiteIngot);
		addShapelessRecipe(VanillaItemsOther.grayDiamondChunk, Items.diamond, VanillaItemsOther.shadowBar);
		
		addShapelessRecipe(VanillaItemsWeapons.redDivineSword, VanillaItemsWeapons.divineSword, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(VanillaItemsWeapons.yellowDivineSword, VanillaItemsWeapons.divineSword, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(VanillaItemsWeapons.greenDivineSword, VanillaItemsWeapons.divineSword, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(VanillaItemsWeapons.blueDivineSword, VanillaItemsWeapons.divineSword, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(VanillaItemsWeapons.grayDivineSword, VanillaItemsWeapons.divineSword, VanillaItemsOther.grayDiamondChunk);
		
		addShapelessRecipe(VanillaItemsWeapons.redEnderSword, VanillaItemsWeapons.enderSword, VanillaItemsOther.redDiamondChunk);
		addShapelessRecipe(VanillaItemsWeapons.yellowEnderSword, VanillaItemsWeapons.enderSword, VanillaItemsOther.yellowDiamondChunk);
		addShapelessRecipe(VanillaItemsWeapons.greenEnderSword, VanillaItemsWeapons.enderSword, VanillaItemsOther.greenDiamondChunk);
		addShapelessRecipe(VanillaItemsWeapons.blueEnderSword, VanillaItemsWeapons.enderSword, VanillaItemsOther.blueDiamondChunk);
		addShapelessRecipe(VanillaItemsWeapons.grayEnderSword, VanillaItemsWeapons.enderSword, VanillaItemsOther.grayDiamondChunk);
		
		//misc
		addRecipe(VanillaItemsOther.netheriteChunk, " I ", "III", " I ", 'I', VanillaItemsOther.netheriteIngot);
		addShapelessRecipe(IS.eyeShards, VanillaItemsOther.cyclopsEye);
		addShapelessRecipe(new ItemStack(VanillaItemsOther.corruptedBullet, 16), VanillaItemsOther.corruptedShards);

		addRecipe(VanillaBlocks.arlemiteBlock, "III", "III", "III", 'I', VanillaItemsOther.arlemiteIngot);
		addRecipe(VanillaBlocks.rupeeBlock, "III", "III", "III", 'I', VanillaItemsOther.rupeeIngot);
		addRecipe(VanillaBlocks.realmiteBlock, "III", "III", "III", 'I', VanillaItemsOther.realmiteIngot);
		addRecipe(VanillaBlocks.netheriteBlock, "III", "III", "III", 'I', VanillaItemsOther.netheriteIngot);
		addRecipe(VanillaBlocks.bloodgemBlock, "III", "III", "III", 'I', VanillaItemsOther.bloodgem);
		addRecipe(new ItemStack(ArcanaBlocks.arcanaPortalFrame, 12),  " c ", "iii", " c ", 'c', VanillaItemsOther.bluefireStone, 'i', Blocks.iron_block);
		
		addRecipe(TwilightItemsOther.twilightClock, "CCC", "CCC", "CCC", 'C', Items.clock);
		addRecipe(IceikaItems.snowGlobe, " G ", "GSG", "DBD", 'G', Blocks.glass, 'S', Blocks.snow, 'D', Items.diamond, 'B', VanillaItemsOther.shadowBar);
		
		addRecipe(VanillaItemsOther.mysteriousClock, " H ", "SCS", " S ", 'C', Items.clock, 'S', VanillaItemsOther.corruptedStone, 'H', VanillaItemsOther.hellstoneIngot);
		addRecipe(VanillaItemsOther.callWatcher, " H ", "SES", " S ", 'E', VanillaItemsOther.watchingEye, 'S', VanillaItemsOther.moltenStone, 'H', VanillaItemsOther.hellstoneIngot);
		addRecipe(VanillaItemsOther.hordeHorn, " H ", "SES", " S ", 'E', Items.ender_eye, 'S', VanillaItemsOther.enderStone, 'H', VanillaItemsOther.hellstoneIngot);
		addRecipe(VanillaItemsOther.infernalFlame, "BBB", "BSB", "BBB", 'B', VanillaItemsOther.purpleBlaze, 'S', VanillaItemsWeapons.infernoSword);
		
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
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 13),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, Items.redstone);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 5),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, new ItemStack(Items.dye, 1, 2));
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 10),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, new ItemStack(Items.dye, 1, 9));
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 11),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, new ItemStack(Items.dye, 1, 5));
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 7),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, new ItemStack(Items.dye, 1, 4));
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 3),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, Items.diamond);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 9),  VanillaItemsOther.netheriteIngot);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 12),  VanillaItemsOther.realmiteIngot, VanillaItemsOther.realmiteIngot, VanillaItemsOther.realmiteIngot, VanillaItemsOther.realmiteIngot, VanillaItemsOther.realmiteIngot);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 4),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, Items.gold_ingot);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 8),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, Items.lava_bucket);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 6),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, Items.iron_ingot);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 2),  Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick, new ItemStack(Items.dye, 1, 0));
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 14),  VanillaBlocks.milkStone, VanillaBlocks.milkStone, VanillaBlocks.milkStone, VanillaBlocks.milkStone);
		addShapelessRecipe(new ItemStack(VanillaBlocks.divineBricks, 4, 0),  VanillaItemsOther.aquaBall, Blocks.stonebrick, Blocks.stonebrick, Blocks.stonebrick);
		addRecipe(new ItemStack(VanillaBlocks.divineBricks, 10, 1),  "xyx", "yxy", "xyx", 'x', VanillaItemsOther.arlemiteIngot, 'y', Blocks.stonebrick);
		
		addRecipe(new ItemStack(VanillaBlocks.minibricks, 4, 3), "XXX", "XXX", "XXX", 'X', Blocks.stonebrick);
		addRecipe(new ItemStack(VanillaBlocks.minibricks, 8, 0), "XXX", "XCX", "XXX", 'X', new ItemStack(VanillaBlocks.minibricks, 1, 3), 'C', VanillaItemsOther.rupeeIngot);
		addRecipe(new ItemStack(VanillaBlocks.minibricks, 8, 1), "XXX", "XCX", "XXX", 'X', new ItemStack(VanillaBlocks.minibricks, 1, 3), 'C', VanillaItemsOther.realmiteIngot);
		addRecipe(new ItemStack(VanillaBlocks.minibricks, 8, 2), "XXX", "XCX", "XXX", 'X', new ItemStack(VanillaBlocks.minibricks, 1, 3), 'C', VanillaItemsOther.arlemiteIngot);
		addRecipe(new ItemStack(VanillaBlocks.minibricks, 8, 4), "XXX", "XCX", "XXX", 'X', new ItemStack(VanillaBlocks.minibricks, 1, 3), 'C', VanillaItemsOther.bloodgem);
		addRecipe(new ItemStack(VanillaBlocks.minibricks, 8, 5), "XXX", "XCX", "XXX", 'X', new ItemStack(VanillaBlocks.minibricks, 1, 3), 'C', VanillaItemsOther.netheriteIngot);
		addRecipe(new ItemStack(VanillaBlocks.minibricks, 8, 6), "XXX", "XCX", "XXX", 'X', new ItemStack(VanillaBlocks.minibricks, 1, 3), 'C', Blocks.bedrock);
		
		addShapelessRecipe(new ItemStack(VanillaBlocks.darkStone, 10),  Blocks.obsidian, Blocks.glowstone);
		
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
		addShapelessRecipe(new ItemStack(VanillaBlocks.lamp2, 2, 11),  Blocks.glowstone, VanillaItemsOther.terranStone);
		
		addRecipe(new ItemStack(ArcanaBlocks.stainedGlass, 1), "y  ", " x ", "   ", 'x', Blocks.glass, 'y', ArcanaItems.marsine);
		addRecipe(new ItemStack(ArcanaBlocks.stainedGlass2, 1), " y ", " x ", "   ", 'x', Blocks.glass, 'y', ArcanaItems.marsine);
		addRecipe(new ItemStack(ArcanaBlocks.stainedGlass3, 1), "  y", " x ", "   ", 'x', Blocks.glass, 'y', ArcanaItems.marsine);
		addRecipe(new ItemStack(ArcanaBlocks.stainedGlass4, 1), "   ", "yx ", "   ", 'x', Blocks.glass, 'y', ArcanaItems.marsine);
		addRecipe(new ItemStack(ArcanaBlocks.stainedGlass5, 1), "   ", " xy", "   ", 'x', Blocks.glass, 'y', ArcanaItems.marsine);
		addRecipe(new ItemStack(ArcanaBlocks.stainedGlass6, 1), "   ", " x ", "y  ", 'x', Blocks.glass, 'y', ArcanaItems.marsine);
		addRecipe(new ItemStack(ArcanaBlocks.stainedGlass7, 1), "   ", " x ", " y ", 'x', Blocks.glass, 'y', ArcanaItems.marsine);
		addRecipe(new ItemStack(ArcanaBlocks.stainedGlass8, 1), "   ", " x ", "  y", 'x', Blocks.glass, 'y', ArcanaItems.marsine);
		
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
		
		addShapelessRecipe(new ItemStack(VanillaItemsOther.shadowCoins, 6), VanillaItemsOther.shadowStone);
		
		addSmelting(ItemsFood.rawEmpoweredMeat, ItemsFood.empoweredMeat, 1);
		
		addRecipe(VanillaItemsOther.pureAquaticPellets, "PPP", "PPP", "PPP", 'P', VanillaItemsOther.aquaticPellets);
		addRecipe(VanillaItemsOther.aquaBall,"wsw", "wkw", "wsw", 'w', Items.water_bucket, 's', Items.slime_ball, 'k', VanillaItemsOther.krakenSkin);
		addShapelessRecipe(VanillaItemsOther.aquaticBlazeRod, VanillaItemsOther.aquaBall, Items.blaze_rod);
		
		addRecipe(VanillaItemsOther.corruptedStone, "III", "III", "III", 'I', VanillaItemsOther.corruptedShards);
		addRecipe(VanillaItemsOther.jungleStone, "III", "III", "III", 'I', VanillaItemsOther.jungleShards);
		addRecipe(IceikaItems.iceStone, "III", "III", "III", 'I', IceikaItems.iceShards);
		addRecipe(VanillaItemsOther.moltenStone, "III", "III", "III", 'I', VanillaItemsOther.moltenShards);
		addRecipe(VanillaItemsOther.divineStone, "III", "III", "III", 'I', VanillaItemsOther.divineShards);
		addRecipe(VanillaItemsOther.enderStone, "III", "III", "III", 'I', VanillaItemsOther.enderShards);
		addRecipe(VanillaItemsOther.terranStone, "III", "III", "III", 'I', VanillaItemsOther.terranShards);
		addRecipe(VanillaItemsOther.shadowStone, "II", "II", 'I', VanillaItemsOther.shadowBar);

		addRecipe(VanillaItemsOther.legendaryEnderEye, "III", "III", "III", 'I', VanillaItemsOther.enderStone);
		
		addRecipe(VanillaItemsOther.krakenScale, "K K", "K K", "KKK", 'K', new ItemStack(Items.dye, 1, 0));
		addShapelessRecipe(VanillaItemsOther.krakenSkin, VanillaItemsOther.krakenScale, VanillaItemsOther.krakenScale);
		
		addShapelessRecipe(IS.bacon, Items.porkchop);
		addRecipe(IS.cheese, "MMM", "MMM", "MMM", 'M', Items.milk_bucket);
		addSmelting(Items.egg, ItemsFood.boiledEgg, 0.3F);
		addSmelting(Blocks.pumpkin, ItemsFood.hotPie, 0.3F);
		addShapelessRecipe(ItemsFood.advMushroomStew, ItemsFood.whiteMushroom, Items.mushroom_stew);
		addShapelessRecipe(ItemsFood.chickenDinner, ItemsFood.advMushroomStew, Items.cooked_chicken, Items.bread);
		
		addShapelessRecipe(new ItemStack(VanillaBlocks.divinePlanks, 4), VanillaBlocks.divineWood);
		
		addRecipe(VanillaBlocks.altarOfCorruption, "sss", "ddd", "ddd", 's', VanillaItemsOther.corruptedStone, 'd', VanillaBlocks.darkStone);
		
		addRecipe(IceikaBlocks.coalstoneStairs, "c  ", "cc ", "ccc", 'c', IceikaBlocks.coalstone);

		addRecipe(VanillaBlocks.lightFenceRed, "   ", "III", "III", 'I', Items.redstone);
		addRecipe(VanillaBlocks.lightFenceGreen, "   ", "III", "III", 'I', new ItemStack(Items.dye, 1, 2));
		addRecipe(VanillaBlocks.lightFenceBlue, "   ", "III", "III", 'I', new ItemStack(Items.dye, 1, 4));

        addRecipe(VanillaItemsOther.teleportationCrystal, "EEE", "EDE", "EEE", 'E', Items.ender_pearl, 'D', Items.diamond);	
        addRecipe(new ItemStack(VanillaBlocks.darkBridge), "GGG", "G G", "GGG", 'G', Items.glowstone_dust); 
        
        addRecipe(VanillaBlocks.hellspiderPumpkin, "MMM", "MPM", "MMM", 'M', VanillaItemsOther.moltenShards, 'P', Blocks.pumpkin);
        addRecipe(VanillaBlocks.frostPumpkin, "MMM", "MPM", "MMM", 'M', IceikaItems.iceStone, 'P', Blocks.pumpkin);
        addRecipe(VanillaBlocks.jungleSpiderPumpkin, "MMM", "MPM", "MMM", 'M', VanillaItemsOther.jungleShards, 'P', Blocks.pumpkin);
        addRecipe(VanillaBlocks.blazePumpkin, "MMM", "MPM", "MMM", 'M', Items.blaze_rod, 'P', Blocks.pumpkin);
        addRecipe(VanillaBlocks.enderWatcherPumpkin, "MMM", "MPM", "MMM", 'M', VanillaItemsOther.enderShards, 'P', Blocks.pumpkin);
        addRecipe(VanillaBlocks.glaconPumpkin, "MMM", "MPM", "MMM", 'M', IceikaItems.iceShards, 'P', Blocks.pumpkin);
        addRecipe(VanillaBlocks.zombiePumpkin, "MMM", "MPM", "MMM", 'M', Items.rotten_flesh, 'P', Blocks.pumpkin);
        addRecipe(VanillaBlocks.creeperPumpkin, "MMM", "MPM", "MMM", 'M', Items.gunpowder, 'P', Blocks.pumpkin);
        addRecipe(VanillaBlocks.cyclopsPumpkin, "MMM", "MPM", "MMM", 'M', Items.gold_ingot, 'P', Blocks.pumpkin);
        addRecipe(VanillaBlocks.enderPumpkin, "MMM", "MPM", "MMM", 'M', Items.ender_pearl, 'P', Blocks.pumpkin);
        addRecipe(VanillaBlocks.ghastPumpkin, "MMM", "MPM", "MMM", 'M', Items.ghast_tear, 'P', Blocks.pumpkin);
        addRecipe(VanillaBlocks.skeletonPumpkin, "MMM", "MPM", "MMM", 'M', Items.bone, 'P', Blocks.pumpkin);
        addRecipe(VanillaBlocks.spiderPumpkin, "MMM", "MPM", "MMM", 'M', Items.string, 'P', Blocks.pumpkin);
        
        addShapelessRecipe(new ItemStack(VanillaBlocks.rainbowWool, 4), new ItemStack(Blocks.wool, 1, 1), new ItemStack(Blocks.wool, 1, 14), new ItemStack(Blocks.wool, 1, 4), new ItemStack(Blocks.wool, 1, 5), new ItemStack(Blocks.wool, 1, 9), new ItemStack(Blocks.wool, 1, 11), new ItemStack(Blocks.wool, 1, 10));
        addRecipe(new ItemStack(VanillaBlocks.checker, 3), "xyx", "yxy", "xyx", 'x', new ItemStack(Blocks.wool, 1, 0), 'y', new ItemStack(Blocks.wool, 1, 15));
        addRecipe(new ItemStack(VanillaBlocks.blueStone, 8), "GGG", "GLG", "GGG", 'G', Blocks.glowstone, 'L', new ItemStack(Items.dye, 1, 4));
        addOredictRecipe(new ItemStack(VanillaBlocks.crate, 4), "xxx", "y y", "xxx", 'x', "plankWood", 'y', "logWood");
        addRecipe(new ItemStack(VanillaBlocks.plankDesign, 4), "xyx", "yxy", "xyx", 'x', new ItemStack(Blocks.planks, 1, 0), 'y', new ItemStack(Blocks.planks, 1, 1) );
        
        addRecipe(new ItemStack(VanillaBlocks.skeletonTorch, 4), "x", "y", 'y', Items.bone, 'x', Items.coal);
        addOredictRecipe(new ItemStack(VanillaBlocks.aquaTorch, 4), "x", "y", 'y', "stickWood", 'x', VanillaItemsOther.aquaticBlazeRod);
        addOredictRecipe(new ItemStack(TwilightBlocks.edenTorch, 4), "x", "y", 'y', "stickWood", 'x', TwilightItemsOther.edenFragments);
        
        addRecipe(new ItemStack(VanillaBlocks.spikeBlock), "x x", " x ", "x x", 'x', Items.iron_ingot);
        addRecipe(new ItemStack(VanillaBlocks.hotSpikeBlock), "x x", " x ", "x x", 'x', VanillaItemsOther.netheriteIngot);
        
        addShapelessRecipe(new ItemStack(VanillaItemsOther.mushroomSeeds, 4), ItemsFood.whiteMushroom);
        addShapelessRecipe(new ItemStack(VanillaItemsOther.tomatoSeeds, 4), ItemsFood.tomato);
        
        addStairRecipe(VanillaBlocks.divinePlanks, VanillaBlocks.divineStairs);
        addSlabRecipe(VanillaBlocks.divinePlanks, VanillaBlocks.divineSlab);
        
        addShapelessRecipe(new ItemStack(ArcanaBlocks.eucalyptusPlank, 4), ArcanaBlocks.eucalyptusWood);
        
        addShapelessRecipe(new ItemStack(IceikaBlocks.frozenPlanks, 4), IceikaBlocks.frozenWood);
        addStairRecipe(IceikaBlocks.frozenPlanks, IceikaBlocks.frozenStairs);
        addSlabRecipe(IceikaBlocks.frozenPlanks, IceikaBlocks.frozenSlab);
        
        addRecipe(new ItemStack(VanillaBlocks.blueVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.dye, 4), 'O', Blocks.obsidian);
        addRecipe(new ItemStack(VanillaBlocks.redVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.dye, 1, 1), 'O', Blocks.obsidian);
        addRecipe(new ItemStack(VanillaBlocks.cyanVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.dye, 1, 6), 'O', Blocks.obsidian);
        addRecipe(new ItemStack(VanillaBlocks.purpleVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.dye, 1, 5), 'O', Blocks.obsidian);
        addRecipe(new ItemStack(VanillaBlocks.yellowVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.dye, 1, 11), 'O', Blocks.obsidian);
	}
}
