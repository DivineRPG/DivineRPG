package naturix.divinerpg.registry;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.utils.GenerateJSON;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModRecipes {
    public static void addOredictRecipe(Block result, Object... materials) {
        if (Config.genJSON) {
            GenerateJSON.addRecipe(new ItemStack(result, 1), materials);
        }
    }

    public static void addOredictRecipe(Item result, Object... materials) {
        if (Config.genJSON) {
            GenerateJSON.addRecipe(new ItemStack(result, 1), materials);
        }
    }

    public static void addOredictRecipe(ItemStack result, Object... materials) {
        if (Config.genJSON) {
            GenerateJSON.addRecipe(result, materials);
        }
    }

    protected static void addRecipe(Block b, Object... o) {
        if (Config.genJSON) {
            GenerateJSON.addRecipe(new ItemStack(b, 1), o);
        }
    }

    protected static void addRecipe(Item i, Object... o) {
        if (Config.genJSON) {
            GenerateJSON.addRecipe(new ItemStack(i, 1), o);
        }
    }

    protected static void addRecipe(ItemStack i, Object... o) {
        if (Config.genJSON) {
            GenerateJSON.addRecipe(i, o);
        }
    }

    protected static void addShapelessRecipe(Block b, Object... o) {
        if (Config.genJSON) {
            GenerateJSON.addShapelessRecipe(new ItemStack(b, 1), o);
        }
    }

    protected static void addShapelessRecipe(Item i, Object... o) {
        if (Config.genJSON) {
            GenerateJSON.addShapelessRecipe(new ItemStack(i, 1), o);
        }
    }

    protected static void addShapelessRecipe(ItemStack i, Object... o) {
        if (Config.genJSON) {
            GenerateJSON.addShapelessRecipe(i, o);
        }
    }

    protected static void addSlabRecipe(Block mat, Block slab) {
        if (Config.genJSON) {
            GenerateJSON.addRecipe(new ItemStack(slab, 6), "XXX", 'X', mat);
        }
    }

    protected static void addSmelting(Block input, Block output, float XP) {
        if (Config.genJSON) {
            GenerateJSON.addSmelting(new ItemStack(input, 1), new ItemStack(output, 1), XP);
        }
    }

    protected static void addSmelting(Block input, Item output, float XP) {
        if (Config.genJSON) {
            GenerateJSON.addSmelting(new ItemStack(input, 1), new ItemStack(output, 1), XP);
        }
    }

    protected static void addSmelting(Item input, Block output, float XP) {
        if (Config.genJSON) {
            GenerateJSON.addSmelting(new ItemStack(input, 1), new ItemStack(output, 1), XP);
        }
    }

    protected static void addSmelting(Item input, Item output, float XP) {
        if (Config.genJSON) {
            GenerateJSON.addSmelting(new ItemStack(input, 1), new ItemStack(output, 1), XP);
        }
    }

    protected static void addSmelting(ItemStack input, ItemStack output, float XP) {
        if (Config.genJSON) {
            GenerateJSON.addSmelting(input, output, XP);
        }
    }

    protected static void addStairRecipe(Block mat, Block stair) {
        if (Config.genJSON) {
            GenerateJSON.addRecipe(new ItemStack(stair, 4), "X  ", "XX ", "XXX", 'X', mat);
        }
    }

    public ModRecipes() {
        if (Config.debug) {
            DivineRPG.logger.info("Generating Recipe JSONs");
        }

        // weapons
        addRecipe(ModItems.palavence, "I I", "III", " I ", 'I', ModItems.realmiteIngot);
        addRecipe(ModItems.massivence, "X X", "III", " I ", 'I', ModItems.netheriteIngot, 'X', ModItems.bloodgem);

        addOredictRecipe(ModItems.frostSword, " I ", " I ", " S ", 'I', ModItems.iceStone, 'S', "stickWood");
        addOredictRecipe(ModItems.bloodgemSword, " I ", " I ", " S ", 'I', ModItems.bloodgem, 'S', "stickWood");
        addOredictRecipe(ModItems.infernoSword, "BOB", "BOB", "BSB", 'B', Items.BLAZE_POWDER, 'O', Blocks.REDSTONE_ORE,
                'S', "stickWood");
        addOredictRecipe(ModItems.moltenSword, " I ", " I ", " S ", 'I', ModItems.moltenStone, 'S', "stickWood");
        addRecipe(ModItems.scorchingSword, " I ", " I ", " S ", 'I', ModItems.purpleBlaze, 'S',
                ModItems.netheriteIngot);
        addRecipe(ModItems.bluefireSword, " I ", " I ", " S ", 'I', ModItems.bluefireStone, 'S', ModItems.shadowBar);
        addRecipe(ModItems.flamingFury, "XIX", "XIX", "XOX", 'I', ModItems.furyFire, 'X', ModItems.infernoSword, 'O',
                ModItems.shadowBar);
        addOredictRecipe(ModItems.poisonSaber, " R ", "BRB", "BSB", 'R', ModItems.jungleStone, 'B', ModItems.shadowBar,
                'S', "stickWood");
        addRecipe(ModItems.enderSword, " L ", " L ", " S ", 'L', ModItems.legendaryEnderEye, 'S', ModItems.shadowBar);
        addOredictRecipe(ModItems.arlemiteStabber, " I ", " I ", " S ", 'I', ModItems.arlemiteIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.rupeeSword, " I ", " I ", " S ", 'I', ModItems.rupeeIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.realmiteSword, " I ", " I ", " S ", 'I', ModItems.realmiteIngot, 'S', "stickWood");
        addRecipe(ModItems.slimeSword, "SDS", "SDS", "SDS", 'D', Items.DIAMOND_SWORD, 'S', Items.SLIME_BALL);
        addOredictRecipe(ModItems.oceanKnife, " I ", " I ", " S ", 'I', ModItems.aquaticIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.aquaticDagger, "   ", " I ", " S ", 'I', ModItems.aquaticIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.aquaticMaul, "III", "III", "ISI", 'I', ModItems.aquaticIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.aquaticTrident, " I ", "III", " S ", 'I', ModItems.aquaticIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.aquaton, "III", "III", " S ", 'I', ModItems.aquaticIngot, 'S', "stickWood");
        addRecipe(ModItems.sharkSword, " I ", " I ", " S ", 'I', ModItems.sharkFin, 'S', ModItems.aquaticIngot);
        addOredictRecipe(ModItems.crabclawMaul, "III", "ISI", " S ", 'I', ModItems.crabClaw, 'S', "stickWood");
        addOredictRecipe(ModItems.bedrockSword, " B ", " B ", " S ", 'B', Blocks.BEDROCK, 'S', "stickWood");
        addOredictRecipe(ModItems.divineSword, " I ", "III", " S ", 'I', ModItems.divineStone, 'S', "stickWood");
        addRecipe(ModItems.furyMaul, "OBO", "BBB", "OBO", 'B', Blocks.BEDROCK, 'O', Blocks.DIAMOND_ORE);
        addOredictRecipe(ModItems.deathBringer, " I ", "ISI", " S ", 'I', ModItems.corruptedStone, 'S', "stickWood");
        addOredictRecipe(ModItems.corruptedMaul, "III", "ISI", " S ", 'I', ModItems.corruptedStone, 'S', "stickWood");
        addOredictRecipe(ModItems.bedrockMaul, " B ", "BBB", " I ", 'B', Blocks.BEDROCK, 'I', "stickWood");
        addOredictRecipe(ModItems.jungleKnife, " I ", " I ", " S ", 'I', ModItems.jungleStone, 'S', "stickWood");
        addOredictRecipe(ModItems.cyclopsianSword, " E ", " E ", " S ", 'E', ModItems.cyclopsEye, 'S', "stickWood");
        addOredictRecipe(ModItems.cyclopsianStaff, " E ", " S ", " S ", 'E', ModItems.cyclopsEye, 'S', "stickWood");
        addRecipe(new ItemStack(ModItems.dualClaw), " C ", "AAA", " C ", 'C', ModItems.crabClaw, 'A',
                ModItems.aquaticIngot);
        addOredictRecipe(ModItems.terranDagger, " T ", " S ", 'T', ModItems.terranStone, 'S', "stickWood");
        addOredictRecipe(ModItems.terranKnife, " T ", " T ", " S ", 'T', ModItems.terranStone, 'S', "stickWood");
        addOredictRecipe(ModItems.terranMaul, "TTT", " T ", " S ", 'T', ModItems.terranStone, 'S', "stickWood");
        addOredictRecipe(ModItems.aquatoothSword, " T ", "TKT", " S ", 'T', ModItems.liopleurodonTeeth, 'K',
                ModItems.liopleurodonSkull, 'S', "stickWood");
        addOredictRecipe(ModItems.aquatoothMaul, "TKT", "TKT", "KSK", 'T', ModItems.liopleurodonTeeth, 'K',
                ModItems.liopleurodonSkull, 'S', "stickWood");
        addRecipe(new ItemStack(ModItems.jungleRapier), "S S", "SBS", " B ", 'S', ModItems.jungleStone, 'B',
                ModItems.shadowBar);

        // ranged weapons
        addRecipe(ModItems.shuriken, " I ", "III", " I ", 'I', Items.IRON_INGOT);
        addRecipe(new ItemStack(ModItems.vileStorm, 8), "SSS", "SJS", "SSS", 'J', ModItems.jungleShards, 'S',
                ModItems.shuriken);
        addRecipe(ModItems.soundOfMusic, "III", "IXI", "III", 'I', ModItems.purpleBlaze, 'X', Items.STRING);
        addRecipe(ModItems.maelstrom, "III", "IXI", "III", 'I', ModItems.purpleBlaze, 'X', Items.BOOK);
        addRecipe(ModItems.ghastCannon, "I I", "I I", "XXX", 'I', ModItems.shadowBar, 'X', ModItems.hellstoneIngot);
        addRecipe(ModItems.liopleurodonAnchor, "SIS", "IXI", " X ", 'I', ModItems.liopleurodonTeeth, 'X',
                ModItems.aquaticIngot, 'S', ModItems.liopleurodonSkull);
        addRecipe(ModItems.bowheadAnchor, "III", "IXI", " X ", 'I', ModItems.whaleFin, 'X', ModItems.aquaticIngot);
        addRecipe(ModItems.sharkAnchor, "III", "IXI", " X ", 'I', ModItems.sharkFin, 'X', ModItems.aquaticIngot);
        addRecipe(ModItems.crabAnchor, "III", "IXI", " X ", 'I', ModItems.crabClaw, 'X', ModItems.aquaticIngot);

        addRecipe(ModItems.hunterBow, " IX", "I X", " IX", 'I', ModItems.jungleStone, 'X', Items.STRING);
        addRecipe(ModItems.shadowBow, " IX", "I X", " IX", 'I', ModItems.shadowBar, 'X', Items.STRING);
        addRecipe(ModItems.enderBow, " IX", "E X", " IX", 'I', ModItems.enderStone, 'X', Items.STRING, 'E',
                ModItems.watchingEye);
        addRecipe(ModItems.bluefireBow, " IX", "I X", " IX", 'I', ModItems.aquaticBlazeRod, 'X',
                ModItems.bluefireStone);
        addRecipe(ModItems.infernoBow, " IX", "I X", " IX", 'I', ModItems.moltenStone, 'X', Items.BLAZE_POWDER);

        addRecipe(ModItems.frostCannon, "I I", "I I", "XXX", 'I', ModItems.shadowBar, 'X', ModItems.iceStone);
        addRecipe(ModItems.bowheadCannon, " I ", " I ", " X ", 'I', ModItems.whaleFin, 'X', ModItems.aquaticIngot);
        addRecipe(ModItems.crabclawCannon, " I ", " I ", " X ", 'I', ModItems.crabClaw, 'X', ModItems.aquaticIngot);
        addOredictRecipe(ModItems.corruptedCannon, "III", "S S", 'I', ModItems.corruptedStone, 'S', "stickWood");

        addRecipe(ModItems.goldenFury, "GGG", "GFG", "FFF", 'F', ModItems.furyFire, 'G', Blocks.GOLD_BLOCK);

        // Tools
        addOredictRecipe(ModItems.realmitePickaxe, "III", " S ", " S ", 'I', ModItems.realmiteIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.realmiteShovel, " I ", " S ", " S ", 'I', ModItems.realmiteIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.realmiteAxe, "II ", "IS ", " S ", 'I', ModItems.realmiteIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.realmiteHoe, "II ", " S ", " S ", 'I', ModItems.realmiteIngot, 'S', "stickWood");

        addOredictRecipe(ModItems.corruptedPickaxe, "III", " S ", " S ", 'I', ModItems.corruptedStone, 'S',
                "stickWood");
        addOredictRecipe(ModItems.corruptedShovel, " I ", " S ", " S ", 'I', ModItems.corruptedStone, 'S', "stickWood");
        addOredictRecipe(ModItems.corruptedAxe, "II ", "IS ", " S ", 'I', ModItems.corruptedStone, 'S', "stickWood");

        addOredictRecipe(ModItems.bedrockPickaxe, "III", " S ", " S ", 'I', Blocks.BEDROCK, 'S', "stickWood");
        addOredictRecipe(ModItems.bedrockShovel, " I ", " S ", " S ", 'I', Blocks.BEDROCK, 'S', "stickWood");
        addOredictRecipe(ModItems.bedrockAxe, "II ", "IS ", " S ", 'I', Blocks.BEDROCK, 'S', "stickWood");

        addOredictRecipe(ModItems.arlemitePickaxe, "III", " S ", " S ", 'I', ModItems.arlemiteIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.arlemiteShovel, " I ", " S ", " S ", 'I', ModItems.arlemiteIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.arlemiteAxe, "II ", "IS ", " S ", 'I', ModItems.arlemiteIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.arlemiteHoe, "II ", " S ", " S ", 'I', ModItems.arlemiteIngot, 'S', "stickWood");
        addShapelessRecipe(ModItems.arlemiteShickaxe, ModItems.arlemitePickaxe, ModItems.arlemiteShovel,
                ModItems.arlemiteAxe, ModItems.arlemiteHoe);

        addOredictRecipe(ModItems.rupeePickaxe, "III", " S ", " S ", 'I', ModItems.rupeeIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.rupeeShovel, " I ", " S ", " S ", 'I', ModItems.rupeeIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.rupeeAxe, "II ", "IS ", " S ", 'I', ModItems.rupeeIngot, 'S', "stickWood");
        addOredictRecipe(ModItems.rupeeHoe, "II ", " S ", " S ", 'I', ModItems.rupeeIngot, 'S', "stickWood");
        addShapelessRecipe(ModItems.rupeeShickaxe, ModItems.rupeePickaxe, ModItems.rupeeShovel, ModItems.rupeeAxe,
                ModItems.rupeeHoe);

        addOredictRecipe(ModItems.divinePickaxe, "III", " S ", " S ", 'I', ModItems.divineStone, 'S', "stickWood");
        addOredictRecipe(ModItems.divineShovel, " I ", " S ", " S ", 'I', ModItems.divineStone, 'S', "stickWood");
        addOredictRecipe(ModItems.divineAxe, "II ", "IS ", " S ", 'I', ModItems.divineStone, 'S', "stickWood");
        addShapelessRecipe(ModItems.divineShickaxe, ModItems.divinePickaxe, ModItems.divineShovel, ModItems.divineAxe);

        // serenades
        addRecipe(ModItems.serenadeStriker, "I  ", "III", "  I", 'I', Items.DIAMOND);
        addRecipe(ModItems.serenadeOfHealth, "I  ", "III", "  I", 'I', ModItems.netheriteChunk);
        addRecipe(ModItems.serenadeOfDeath, "I  ", "III", "  I", 'I', ModItems.shadowBar);

        // armor

        // FIXME - Remove Vanilla DIAMOND, GOLDEN and IRON armor and put the replacement
        // in

        // removeCraftingRecipe(Items.DIAMOND_CHESTPLATE);
        // removeCraftingRecipe(Items.DIAMOND_LEGGINGS);
        // removeCraftingRecipe(Items.DIAMOND_BOOTS);
        // removeCraftingRecipe(Items.DIAMOND_HELMET);
        // removeCraftingRecipe(Items.GOLDEN_CHESTPLATE);
        // removeCraftingRecipe(Items.GOLDEN_LEGGINGS);
        // removeCraftingRecipe(Items.GOLDEN_BOOTS);
        // removeCraftingRecipe(Items.GOLDEN_HELMET);
        // removeCraftingRecipe(Items.IRON_CHESTPLATE);
        // removeCraftingRecipe(Items.IRON_LEGGINGS);
        // removeCraftingRecipe(Items.IRON_BOOTS);
        // removeCraftingRecipe(Items.IRON_HELMET);

        // addRecipe(ModItems.diamondHelmet, "III", "I I", 'I', Items.DIAMOND);
        // addRecipe(ModItems.diamondBody, "I I", "III", "III", 'I', Items.DIAMOND);
        // addRecipe(ModItems.diamondLegs, "III", "I I", "I I", 'I', Items.DIAMOND);
        // addRecipe(ModItems.diamondBoots, "I I", "I I", 'I', Items.DIAMOND);

        // addRecipe(ModItems.ironHelmet, "III", "I I", 'I', Items.IRON_INGOT);
        // addRecipe(ModItems.ironBody, "I I", "III", "III", 'I', Items.IRON_INGOT);
        // addRecipe(ModItems.ironLegs, "III", "I I", "I I", 'I', Items.IRON_INGOT);
        // addRecipe(ModItems.ironBoots, "I I", "I I", 'I', Items.IRON_INGOT);

        // addRecipe(ModItems.goldHelmet, "III", "I I", 'I', Items.GOLD_INGOT);
        // addRecipe(ModItems.goldBody, "I I", "III", "III", 'I', Items.GOLD_INGOT);
        // addRecipe(ModItems.goldLegs, "III", "I I", "I I", 'I', Items.GOLD_INGOT);
        // addRecipe(ModItems.goldBoots, "I I", "I I", 'I', Items.GOLD_INGOT);

        addRecipe(ModItems.realmiteHelmet, "III", "I I", 'I', ModItems.realmiteIngot);
        addRecipe(ModItems.realmiteBody, "I I", "III", "III", 'I', ModItems.realmiteIngot);
        addRecipe(ModItems.realmiteLegs, "III", "I I", "I I", 'I', ModItems.realmiteIngot);
        addRecipe(ModItems.realmiteBoots, "I I", "I I", 'I', ModItems.realmiteIngot);

        addRecipe(ModItems.eliteRealmiteHelmet, "III", "I I", 'I', ModBlocks.realmiteBlock);
        addRecipe(ModItems.eliteRealmiteBody, "I I", "III", "III", 'I', ModBlocks.realmiteBlock);
        addRecipe(ModItems.eliteRealmiteLegs, "III", "I I", "I I", 'I', ModBlocks.realmiteBlock);
        addRecipe(ModItems.eliteRealmiteBoots, "I I", "I I", 'I', ModBlocks.realmiteBlock);

        addRecipe(ModItems.bedrockHelmet, "III", "I I", 'I', Blocks.BEDROCK);
        addRecipe(ModItems.bedrockBody, "I I", "III", "III", 'I', Blocks.BEDROCK);
        addRecipe(ModItems.bedrockLegs, "III", "I I", "I I", 'I', Blocks.BEDROCK);
        addRecipe(ModItems.bedrockBoots, "I I", "I I", 'I', Blocks.BEDROCK);

        addRecipe(ModItems.rupeeHelmet, "III", "I I", 'I', ModItems.rupeeIngot);
        addRecipe(ModItems.rupeeBody, "I I", "III", "III", 'I', ModItems.rupeeIngot);
        addRecipe(ModItems.rupeeLegs, "III", "I I", "I I", 'I', ModItems.rupeeIngot);
        addRecipe(ModItems.rupeeBoots, "I I", "I I", 'I', ModItems.rupeeIngot);

        addRecipe(ModItems.arlemiteHelmet, "III", "X X", 'I', ModItems.arlemiteIngot, 'X', Items.IRON_INGOT);
        addRecipe(ModItems.arlemiteBody, "I I", "XIX", "IXI", 'I', ModItems.arlemiteIngot, 'X', Items.IRON_INGOT);
        addRecipe(ModItems.arlemiteLegs, "III", "X X", "I I", 'I', ModItems.arlemiteIngot, 'X', Items.IRON_INGOT);
        addRecipe(ModItems.arlemiteBoots, "X X", "I I", 'I', ModItems.arlemiteIngot, 'X', Items.IRON_INGOT);

        addRecipe(ModItems.infernoHelmet, "III", "I I", 'I', ModItems.moltenStone);
        addRecipe(ModItems.infernoBody, "I I", "III", "III", 'I', ModItems.moltenStone);
        addRecipe(ModItems.infernoLegs, "III", "I I", "I I", 'I', ModItems.moltenStone);
        addRecipe(ModItems.infernoBoots, "I I", "I I", 'I', ModItems.moltenStone);

        addRecipe(ModItems.netheriteHelmet, "III", "S S", 'I', ModBlocks.netheriteBlock, 'S', ModItems.shadowBar);
        addRecipe(ModItems.netheriteBody, "S S", "III", "III", 'I', ModBlocks.netheriteBlock, 'S', ModItems.shadowBar);
        addRecipe(ModItems.netheriteLegs, "III", "S S", "I I", 'I', ModBlocks.netheriteBlock, 'S', ModItems.shadowBar);
        addRecipe(ModItems.netheriteBoots, "S S", "I I", 'I', ModBlocks.netheriteBlock, 'S', ModItems.shadowBar);

        addRecipe(ModItems.enderHelmet, "III", "I I", 'I', ModItems.enderStone);
        addRecipe(ModItems.enderBody, "I I", "III", "III", 'I', ModItems.enderStone);
        addRecipe(ModItems.enderLegs, "III", "I I", "I I", 'I', ModItems.enderStone);
        addRecipe(ModItems.enderBoots, "I I", "I I", 'I', ModItems.enderStone);

        addRecipe(ModItems.divineHelmet, "III", "I I", 'I', ModItems.divineStone);
        addRecipe(ModItems.divineBody, "I I", "III", "III", 'I', ModItems.divineStone);
        addRecipe(ModItems.divineLegs, "III", "I I", "I I", 'I', ModItems.divineStone);
        addRecipe(ModItems.divineBoots, "I I", "I I", 'I', ModItems.divineStone);

        addRecipe(ModItems.angelicHelmet, "XXX", "I I", 'I', ModItems.bluefireStone, 'X', ModItems.iceStone);
        addRecipe(ModItems.angelicBody, "I I", "XIX", "XXX", 'I', ModItems.bluefireStone, 'X', ModItems.iceStone);
        addRecipe(ModItems.angelicLegs, "III", "X X", "X X", 'I', ModItems.bluefireStone, 'X', ModItems.iceStone);
        addRecipe(ModItems.angelicBoots, "I I", "X X", 'I', ModItems.bluefireStone, 'X', ModItems.iceStone);

        addRecipe(ModItems.shadowHelmet, "III", "I I", 'I', ModItems.shadowStone);
        addRecipe(ModItems.shadowBody, "I I", "III", "III", 'I', ModItems.shadowStone);
        addRecipe(ModItems.shadowLegs, "III", "I I", "I I", 'I', ModItems.shadowStone);
        addRecipe(ModItems.shadowBoots, "I I", "I I", 'I', ModItems.shadowStone);

        addRecipe(ModItems.aquastriveHelmet, "III", "I I", 'I', ModItems.aquaticIngot);
        addRecipe(ModItems.aquastriveBody, "I I", "III", "III", 'I', ModItems.aquaticIngot);
        addRecipe(ModItems.aquastriveLegs, "III", "I I", "I I", 'I', ModItems.aquaticIngot);
        addRecipe(ModItems.aquastriveBoots, "I I", "I I", 'I', ModItems.aquaticIngot);

        addRecipe(ModItems.krakenHelmet, "III", "I I", 'I', ModItems.krakenSkin);
        addRecipe(ModItems.krakenBody, "I I", "III", "III", 'I', ModItems.krakenSkin);
        addRecipe(ModItems.krakenLegs, "III", "I I", "I I", 'I', ModItems.krakenSkin);
        addRecipe(ModItems.krakenBoots, "I I", "I I", 'I', ModItems.krakenSkin);

        addRecipe(ModItems.jungleHelmet, "III", "I I", 'I', ModItems.jungleStone);
        addRecipe(ModItems.jungleBody, "I I", "III", "III", 'I', ModItems.jungleStone);
        addRecipe(ModItems.jungleLegs, "III", "I I", "I I", 'I', ModItems.jungleStone);
        addRecipe(ModItems.jungleBoots, "I I", "I I", 'I', ModItems.jungleStone);

        addRecipe(ModItems.frozenHelmet, "III", "I I", 'I', ModItems.iceStone);
        addRecipe(ModItems.frozenBody, "I I", "III", "III", 'I', ModItems.iceStone);
        addRecipe(ModItems.frozenLegs, "III", "I I", "I I", 'I', ModItems.iceStone);
        addRecipe(ModItems.frozenBoots, "I I", "I I", 'I', ModItems.iceStone);

        addRecipe(ModItems.corruptedHelmet, "III", "I I", 'I', ModItems.corruptedStone);
        addRecipe(ModItems.corruptedBody, "I I", "III", "III", 'I', ModItems.corruptedStone);
        addRecipe(ModItems.corruptedLegs, "III", "I I", "I I", 'I', ModItems.corruptedStone);
        addRecipe(ModItems.corruptedBoots, "I I", "I I", 'I', ModItems.corruptedStone);

        addRecipe(ModItems.terranHelmet, "III", "I I", 'I', ModItems.terranStone);
        addRecipe(ModItems.terranBody, "I I", "III", "III", 'I', ModItems.terranStone);
        addRecipe(ModItems.terranLegs, "III", "I I", "I I", 'I', ModItems.terranStone);
        addRecipe(ModItems.terranBoots, "I I", "I I", 'I', ModItems.terranStone);

        // Colorable Weapons / Armor
        addShapelessRecipe(ModItems.redRupeeHelmet, ModItems.rupeeHelmet, ModItems.redDiamondChunk);
        addShapelessRecipe(ModItems.redRupeeBody, ModItems.rupeeBody, ModItems.redDiamondChunk);
        addShapelessRecipe(ModItems.redRupeeLegs, ModItems.rupeeLegs, ModItems.redDiamondChunk);
        addShapelessRecipe(ModItems.redRupeeBoots, ModItems.rupeeBoots, ModItems.redDiamondChunk);
        addShapelessRecipe(ModItems.greenRupeeHelmet, ModItems.rupeeHelmet, ModItems.greenDiamondChunk);
        addShapelessRecipe(ModItems.greenRupeeBody, ModItems.rupeeBody, ModItems.greenDiamondChunk);
        addShapelessRecipe(ModItems.greenRupeeLegs, ModItems.rupeeLegs, ModItems.greenDiamondChunk);
        addShapelessRecipe(ModItems.greenRupeeBoots, ModItems.rupeeBoots, ModItems.greenDiamondChunk);
        addShapelessRecipe(ModItems.blueRupeeHelmet, ModItems.rupeeHelmet, ModItems.blueDiamondChunk);
        addShapelessRecipe(ModItems.blueRupeeBody, ModItems.rupeeBody, ModItems.blueDiamondChunk);
        addShapelessRecipe(ModItems.blueRupeeLegs, ModItems.rupeeLegs, ModItems.blueDiamondChunk);
        addShapelessRecipe(ModItems.blueRupeeBoots, ModItems.rupeeBoots, ModItems.blueDiamondChunk);
        addShapelessRecipe(ModItems.yellowRupeeHelmet, ModItems.rupeeHelmet, ModItems.yellowDiamondChunk);
        addShapelessRecipe(ModItems.yellowRupeeBody, ModItems.rupeeBody, ModItems.yellowDiamondChunk);
        addShapelessRecipe(ModItems.yellowRupeeLegs, ModItems.rupeeLegs, ModItems.yellowDiamondChunk);
        addShapelessRecipe(ModItems.yellowRupeeBoots, ModItems.rupeeBoots, ModItems.yellowDiamondChunk);
        addShapelessRecipe(ModItems.grayRupeeHelmet, ModItems.rupeeHelmet, ModItems.grayDiamondChunk);
        addShapelessRecipe(ModItems.grayRupeeBody, ModItems.rupeeBody, ModItems.grayDiamondChunk);
        addShapelessRecipe(ModItems.grayRupeeLegs, ModItems.rupeeLegs, ModItems.grayDiamondChunk);
        addShapelessRecipe(ModItems.grayRupeeBoots, ModItems.rupeeBoots, ModItems.grayDiamondChunk);

        addShapelessRecipe(ModItems.redEnderHelmet, ModItems.enderHelmet, ModItems.redDiamondChunk);
        addShapelessRecipe(ModItems.redEnderBody, ModItems.enderBody, ModItems.redDiamondChunk);
        addShapelessRecipe(ModItems.redEnderLegs, ModItems.enderLegs, ModItems.redDiamondChunk);
        addShapelessRecipe(ModItems.redEnderBoots, ModItems.enderBoots, ModItems.redDiamondChunk);
        addShapelessRecipe(ModItems.greenEnderHelmet, ModItems.enderHelmet, ModItems.greenDiamondChunk);
        addShapelessRecipe(ModItems.greenEnderBody, ModItems.enderBody, ModItems.greenDiamondChunk);
        addShapelessRecipe(ModItems.greenEnderLegs, ModItems.enderLegs, ModItems.greenDiamondChunk);
        addShapelessRecipe(ModItems.greenEnderBoots, ModItems.enderBoots, ModItems.greenDiamondChunk);
        addShapelessRecipe(ModItems.blueEnderHelmet, ModItems.enderHelmet, ModItems.blueDiamondChunk);
        addShapelessRecipe(ModItems.blueEnderBody, ModItems.enderBody, ModItems.blueDiamondChunk);
        addShapelessRecipe(ModItems.blueEnderLegs, ModItems.enderLegs, ModItems.blueDiamondChunk);
        addShapelessRecipe(ModItems.blueEnderBoots, ModItems.enderBoots, ModItems.blueDiamondChunk);
        addShapelessRecipe(ModItems.yellowEnderHelmet, ModItems.enderHelmet, ModItems.yellowDiamondChunk);
        addShapelessRecipe(ModItems.yellowEnderBody, ModItems.enderBody, ModItems.yellowDiamondChunk);
        addShapelessRecipe(ModItems.yellowEnderLegs, ModItems.enderLegs, ModItems.yellowDiamondChunk);
        addShapelessRecipe(ModItems.yellowEnderBoots, ModItems.enderBoots, ModItems.yellowDiamondChunk);
        addShapelessRecipe(ModItems.grayEnderHelmet, ModItems.enderHelmet, ModItems.grayDiamondChunk);
        addShapelessRecipe(ModItems.grayEnderBody, ModItems.enderBody, ModItems.grayDiamondChunk);
        addShapelessRecipe(ModItems.grayEnderLegs, ModItems.enderLegs, ModItems.grayDiamondChunk);
        addShapelessRecipe(ModItems.grayEnderBoots, ModItems.enderBoots, ModItems.grayDiamondChunk);

        addShapelessRecipe(ModItems.redDiamondChunk, Items.DIAMOND, ModItems.netheriteChunk);
        addShapelessRecipe(ModItems.greenDiamondChunk, Items.DIAMOND, ModItems.arlemiteIngot);
        addShapelessRecipe(ModItems.blueDiamondChunk, Items.DIAMOND, ModItems.rupeeIngot);
        addShapelessRecipe(ModItems.yellowDiamondChunk, Items.DIAMOND, ModItems.realmiteIngot);
        addShapelessRecipe(ModItems.grayDiamondChunk, Items.DIAMOND, ModItems.shadowBar);

        addShapelessRecipe(ModItems.redDivineSword, ModItems.divineSword, ModItems.redDiamondChunk);
        addShapelessRecipe(ModItems.yellowDivineSword, ModItems.divineSword, ModItems.yellowDiamondChunk);
        addShapelessRecipe(ModItems.greenDivineSword, ModItems.divineSword, ModItems.greenDiamondChunk);
        addShapelessRecipe(ModItems.blueDivineSword, ModItems.divineSword, ModItems.blueDiamondChunk);
        addShapelessRecipe(ModItems.grayDivineSword, ModItems.divineSword, ModItems.grayDiamondChunk);

        addShapelessRecipe(ModItems.redEnderSword, ModItems.enderSword, ModItems.redDiamondChunk);
        addShapelessRecipe(ModItems.yellowEnderSword, ModItems.enderSword, ModItems.yellowDiamondChunk);
        addShapelessRecipe(ModItems.greenEnderSword, ModItems.enderSword, ModItems.greenDiamondChunk);
        addShapelessRecipe(ModItems.blueEnderSword, ModItems.enderSword, ModItems.blueDiamondChunk);
        addShapelessRecipe(ModItems.grayEnderSword, ModItems.enderSword, ModItems.grayDiamondChunk);

        // misc
        addRecipe(ModItems.netheriteChunk, " I ", "III", " I ", 'I', ModItems.netheriteIngot);
        addShapelessRecipe(new ItemStack(ModItems.cyclopsEyeShards, 9), ModItems.cyclopsEye);
        addShapelessRecipe(new ItemStack(ModItems.corruptedBullet, 16), ModItems.corruptedShards);

        addRecipe(ModBlocks.arlemiteBlock, "III", "III", "III", 'I', ModItems.arlemiteIngot);
        addRecipe(ModBlocks.rupeeBlock, "III", "III", "III", 'I', ModItems.rupeeIngot);
        addRecipe(ModBlocks.realmiteBlock, "III", "III", "III", 'I', ModItems.realmiteIngot);
        addRecipe(ModBlocks.netheriteBlock, "III", "III", "III", 'I', ModItems.netheriteIngot);
        addRecipe(ModBlocks.bloodgemBlock, "III", "III", "III", 'I', ModItems.bloodgem);
        // FIXME - Need to add
        // addRecipe(new ItemStack(ModBlocks.arcanaPortalFrame, 12), " c ", "iii", " c
        // ", 'c', ModItems.bluefireStone, 'i', Blocks.IRON_BLOCK);

        addRecipe(ModItems.twilightClock, "CCC", "CCC", "CCC", 'C', Items.CLOCK);
        addRecipe(ModItems.snowGlobe, " G ", "GSG", "DBD", 'G', Blocks.GLASS, 'S', Blocks.SNOW, 'D', Items.DIAMOND, 'B',
                ModItems.shadowBar);

        addRecipe(ModItems.mysteriousClock, " H ", "SCS", " S ", 'C', Items.CLOCK, 'S', ModItems.corruptedStone, 'H',
                ModItems.hellstoneIngot);
        addRecipe(ModItems.callOfTheWatcher, " H ", "SES", " S ", 'E', ModItems.watchingEye, 'S', ModItems.moltenStone,
                'H', ModItems.hellstoneIngot);
        addRecipe(ModItems.hordeHorn, " H ", "SES", " S ", 'E', Items.ENDER_EYE, 'S', ModItems.enderStone, 'H',
                ModItems.hellstoneIngot);
        addRecipe(ModItems.infernalFlame, "BBB", "BSB", "BBB", 'B', ModItems.purpleBlaze, 'S', ModItems.infernoSword);

        addRecipe(ModBlocks.tealSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.DYE, 1, 6));
        addRecipe(ModBlocks.redSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.DYE, 1, 1));
        addRecipe(ModBlocks.purpleSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y',
                new ItemStack(Items.DYE, 1, 5));
        addRecipe(ModBlocks.greenSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y',
                new ItemStack(Items.DYE, 1, 2));
        addRecipe(ModBlocks.yellowSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y',
                new ItemStack(Items.DYE, 1, 11));
        addRecipe(ModBlocks.blueSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.DYE, 1, 4));
        addRecipe(ModBlocks.whiteSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y',
                new ItemStack(Items.DYE, 1, 15));
        addRecipe(ModBlocks.blackSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y',
                new ItemStack(Items.DYE, 1, 0));
        addRecipe(ModBlocks.orangeSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y',
                new ItemStack(Items.DYE, 1, 14));
        addRecipe(ModBlocks.brightRedSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y',
                new ItemStack(Items.DYE, 1, 13));

        addShapelessRecipe(new ItemStack(ModBlocks.milkStone, 4), Blocks.STONE, Blocks.STONE, Blocks.STONE,
                Items.MILK_BUCKET);

        addShapelessRecipe(ModBlocks.aquatonicBricks, ModItems.aquaBall, Blocks.STONEBRICK, Blocks.STONEBRICK,
                Blocks.STONEBRICK);
        addRecipe(ModBlocks.arlemiteBricks, "xyx", "yxy", "xyx", 'x', ModItems.arlemiteIngot, 'y', Blocks.STONEBRICK);
        addShapelessRecipe(ModBlocks.darkstoneBricks, Blocks.STONEBRICK, Blocks.STONEBRICK, Blocks.STONEBRICK,
                new ItemStack(Items.DYE, 1, 0));
        addShapelessRecipe(ModBlocks.diamondBricks, Blocks.STONEBRICK, Blocks.STONEBRICK, Blocks.STONEBRICK,
                Items.DIAMOND);
        addShapelessRecipe(ModBlocks.goldBricks, Blocks.STONEBRICK, Blocks.STONEBRICK, Blocks.STONEBRICK,
                Items.GOLD_INGOT);
        addShapelessRecipe(ModBlocks.greenBricks, Blocks.STONEBRICK, Blocks.STONEBRICK, Blocks.STONEBRICK,
                new ItemStack(Items.DYE, 1, 2));
        addShapelessRecipe(ModBlocks.ironBricks, Blocks.STONEBRICK, Blocks.STONEBRICK, Blocks.STONEBRICK,
                Items.IRON_INGOT);
        addShapelessRecipe(ModBlocks.lapisLazuliBricks, Blocks.STONEBRICK, Blocks.STONEBRICK, Blocks.STONEBRICK,
                new ItemStack(Items.DYE, 1, 4));
        addShapelessRecipe(ModBlocks.lavaBricks, Blocks.STONEBRICK, Blocks.STONEBRICK, Blocks.STONEBRICK,
                Items.LAVA_BUCKET);
        addShapelessRecipe(ModBlocks.netheriteBricks, ModItems.netheriteIngot);
        addShapelessRecipe(ModBlocks.pinkBricks, Blocks.STONEBRICK, Blocks.STONEBRICK, Blocks.STONEBRICK,
                new ItemStack(Items.DYE, 1, 9));
        addShapelessRecipe(ModBlocks.purpleBricks, Blocks.STONEBRICK, Blocks.STONEBRICK, Blocks.STONEBRICK,
                new ItemStack(Items.DYE, 1, 5));
        addShapelessRecipe(ModBlocks.realmiteBricks, ModItems.realmiteIngot, ModItems.realmiteIngot,
                ModItems.realmiteIngot, ModItems.realmiteIngot, ModItems.realmiteIngot);
        addShapelessRecipe(ModBlocks.redstoneBricks, Blocks.STONEBRICK, Blocks.STONEBRICK, Blocks.STONEBRICK,
                Items.REDSTONE);
        addShapelessRecipe(ModBlocks.milkStoneBricks, ModBlocks.milkStone, ModBlocks.milkStone, ModBlocks.milkStone,
                ModBlocks.milkStone);

        addRecipe(ModBlocks.rupeeMinibricks, "XXX", "XCX", "XXX", 'X', ModBlocks.minibricks, 'C', ModItems.rupeeIngot);
        addRecipe(ModBlocks.realmiteMinibricks, "XXX", "XCX", "XXX", 'X', ModBlocks.minibricks, 'C',
                ModItems.realmiteIngot);
        addRecipe(ModBlocks.arlemiteMinibricks, "XXX", "XCX", "XXX", 'X', ModBlocks.minibricks, 'C',
                ModItems.arlemiteIngot);
        addRecipe(ModBlocks.minibricks, "XXX", "XXX", "XXX", 'X', Blocks.STONEBRICK);
        addRecipe(ModBlocks.bloodgemMinibricks, "XXX", "XCX", "XXX", 'X', ModBlocks.minibricks, 'C', ModItems.bloodgem);
        addRecipe(ModBlocks.netheriteMinibricks, "XXX", "XCX", "XXX", 'X', ModBlocks.minibricks, 'C',
                ModItems.netheriteIngot);
        addRecipe(ModBlocks.bedrockMinibricks, "XXX", "XCX", "XXX", 'X', ModBlocks.minibricks, 'C', Blocks.BEDROCK);

        addShapelessRecipe(new ItemStack(ModBlocks.darkstone, 10), Blocks.OBSIDIAN, Blocks.GLOWSTONE);

        addRecipe(ModBlocks.aquaLamp, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', Items.WATER_BUCKET);
        addRecipe(ModBlocks.arlemiteLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', ModItems.arlemiteIngot, 'z',
                Blocks.GLOWSTONE);
        addRecipe(ModBlocks.blazeLamp, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', Items.BLAZE_ROD);
        addShapelessRecipe(ModBlocks.bluefireLamp, Blocks.GLOWSTONE, ModItems.bluefireStone);
        addRecipe(ModBlocks.diamondLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', Items.DIAMOND, 'z',
                Blocks.GLOWSTONE);
        addShapelessRecipe(ModBlocks.divineLamp, Blocks.GLOWSTONE, ModItems.divineStone);
        addRecipe(ModBlocks.drakenLamp, "xxx", "zyz", "xxx", 'x', Items.IRON_INGOT, 'y', Items.LAVA_BUCKET, 'z',
                Blocks.GOLD_BLOCK);
        addRecipe(ModBlocks.edenLamp, "xxx", "xyx", "xxx", 'y', ModItems.edenFragments, 'x', Items.IRON_INGOT);
        addRecipe(ModBlocks.enderLamp, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', Items.ENDER_EYE);
        addShapelessRecipe(ModBlocks.enderStoneLamp, Blocks.GLOWSTONE, ModItems.enderStone);
        addRecipe(ModBlocks.goldLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', Items.GOLD_INGOT, 'z',
                Blocks.GLOWSTONE);

        addShapelessRecipe(ModBlocks.iceLamp, Blocks.GLOWSTONE, ModItems.iceStone);
        addShapelessRecipe(ModBlocks.jungleLamp, Blocks.GLOWSTONE, ModItems.jungleStone);
        addRecipe(ModBlocks.krakenLamp, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', ModItems.krakenSkin);
        addRecipe(ModBlocks.lapisLazuliLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y',
                new ItemStack(Items.DYE, 1, 4), 'z', Blocks.GLOWSTONE);
        addRecipe(ModBlocks.lavaLamp, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', Items.LAVA_BUCKET);
        addRecipe(ModBlocks.milkyLamp, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', Items.MILK_BUCKET);
        addShapelessRecipe(ModBlocks.moltenLamp, Blocks.GLOWSTONE, ModItems.moltenStone);
        addRecipe(ModBlocks.netheriteLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', ModItems.netheriteIngot,
                'z', Blocks.GLOWSTONE);
        addRecipe(ModBlocks.realmiteLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', ModItems.realmiteIngot, 'z',
                Blocks.GLOWSTONE);
        addRecipe(ModBlocks.redstoneOrekLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', Items.REDSTONE, 'z',
                Blocks.GLOWSTONE);
        addRecipe(ModBlocks.rupeeLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', ModItems.rupeeIngot, 'z',
                Blocks.GLOWSTONE);
        addShapelessRecipe(ModBlocks.terranLamp, Blocks.GLOWSTONE, ModItems.terranStone);

        addRecipe(new ItemStack(ModBlocks.stainedGlass, 1), "y  ", " x ", "   ", 'x', Blocks.GLASS, 'y',
                ModItems.marsine);
        addRecipe(new ItemStack(ModBlocks.stainedGlass2, 1), " y ", " x ", "   ", 'x', Blocks.GLASS, 'y',
                ModItems.marsine);
        addRecipe(new ItemStack(ModBlocks.stainedGlass3, 1), "  y", " x ", "   ", 'x', Blocks.GLASS, 'y',
                ModItems.marsine);
        addRecipe(new ItemStack(ModBlocks.stainedGlass4, 1), "   ", "yx ", "   ", 'x', Blocks.GLASS, 'y',
                ModItems.marsine);
        addRecipe(new ItemStack(ModBlocks.stainedGlass5, 1), "   ", " xy", "   ", 'x', Blocks.GLASS, 'y',
                ModItems.marsine);
        addRecipe(new ItemStack(ModBlocks.stainedGlass6, 1), "   ", " x ", "y  ", 'x', Blocks.GLASS, 'y',
                ModItems.marsine);
        addRecipe(new ItemStack(ModBlocks.stainedGlass7, 1), "   ", " x ", " y ", 'x', Blocks.GLASS, 'y',
                ModItems.marsine);
        addRecipe(new ItemStack(ModBlocks.stainedGlass8, 1), "   ", " x ", "  y", 'x', Blocks.GLASS, 'y',
                ModItems.marsine);

        // FIXME - Need to add
        // addRecipe(ModBlocks.boneChest, "bbb", "b b", "bbb", 'b', Items.BONE);

        addRecipe(new ItemStack(Blocks.BEDROCK, 3), "OOO", "OBO", " OO", 'O', Blocks.OBSIDIAN, 'B',
                ModBlocks.rupeeBlock);
        addSmelting(ModBlocks.realmiteOre, ModItems.realmiteIngot, 0.7F);
        addSmelting(ModBlocks.arlemiteOre, ModItems.arlemiteIngot, 1.0F);
        addSmelting(ModBlocks.rupeeOre, ModItems.rupeeIngot, 1.0F);
        addSmelting(ModBlocks.netheriteOre, ModItems.netheriteIngot, 1.1F);
        addSmelting(ModBlocks.bloodgemOre, ModItems.bloodgem, 1.2F);
        addSmelting(ModItems.pureAquaticPellets, ModItems.aquaticIngot, 0.6F);
        addShapelessRecipe(ModItems.hellstoneIngot, ModItems.shadowBar, ModItems.netheriteChunk);

        addShapelessRecipe(new ItemStack(ModItems.arlemiteIngot, 9), ModBlocks.arlemiteBlock);
        addShapelessRecipe(new ItemStack(ModItems.rupeeIngot, 9), ModBlocks.rupeeBlock);
        addShapelessRecipe(new ItemStack(ModItems.realmiteIngot, 9), ModBlocks.realmiteBlock);
        addShapelessRecipe(new ItemStack(ModItems.netheriteIngot, 9), ModBlocks.netheriteBlock);
        addShapelessRecipe(new ItemStack(ModItems.bloodgem, 9), ModBlocks.bloodgemBlock);
        addShapelessRecipe(ModItems.shadowBar, ModItems.rupeeIngot, ModItems.arlemiteIngot);

        addShapelessRecipe(new ItemStack(ModItems.shadowCoins, 6), ModItems.shadowStone);

        addSmelting(ModItems.rawEmpoweredMeat, ModItems.empoweredMeat, 1);

        addRecipe(ModItems.pureAquaticPellets, "PPP", "PPP", "PPP", 'P', ModItems.aquaticPellets);
        addRecipe(ModItems.aquaBall, "wsw", "wkw", "wsw", 'w', Items.WATER_BUCKET, 's', Items.SLIME_BALL, 'k',
                ModItems.krakenSkin);
        addShapelessRecipe(ModItems.aquaticBlazeRod, ModItems.aquaBall, Items.BLAZE_ROD);

        addRecipe(ModItems.corruptedStone, "III", "III", "III", 'I', ModItems.corruptedShards);
        addRecipe(ModItems.jungleStone, "III", "III", "III", 'I', ModItems.jungleShards);
        addRecipe(ModItems.iceStone, "III", "III", "III", 'I', ModItems.iceShards);
        addRecipe(ModItems.moltenStone, "III", "III", "III", 'I', ModItems.moltenShards);
        addRecipe(ModItems.divineStone, "III", "III", "III", 'I', ModItems.divineShards);
        addRecipe(ModItems.enderStone, "III", "III", "III", 'I', ModItems.enderShards);
        addRecipe(ModItems.terranStone, "III", "III", "III", 'I', ModItems.terranShards);
        addRecipe(ModItems.shadowStone, "II", "II", 'I', ModItems.shadowBar);

        addRecipe(ModItems.legendaryEnderEye, "III", "III", "III", 'I', ModItems.enderStone);

        addRecipe(ModItems.krakenScale, "K K", "K K", "KKK", 'K', new ItemStack(Items.DYE, 1, 0));
        addShapelessRecipe(ModItems.krakenSkin, ModItems.krakenScale, ModItems.krakenScale);

        addShapelessRecipe(new ItemStack(ModItems.bacon, 6), Items.PORKCHOP);
        addRecipe(new ItemStack(ModItems.cheese, 3), "MMM", "MMM", "MMM", 'M', Items.MILK_BUCKET);
        addSmelting(Items.EGG, ModItems.boiledEgg, 0.3F);
        addSmelting(Blocks.PUMPKIN, ModItems.hotPumpkinPie, 0.3F);
        addShapelessRecipe(ModItems.advMushroomStew, ModItems.whiteMushroom, Items.MUSHROOM_STEW);
        addShapelessRecipe(ModItems.chickenDinner, ModItems.advMushroomStew, Items.COOKED_CHICKEN, Items.BREAD);

        addShapelessRecipe(new ItemStack(ModBlocks.divinePlanks, 4), ModBlocks.divineWood);

        // FIXME - Need to add
        // addRecipe(ModBlocks.altarOfCorruption, "sss", "ddd", "ddd", 's',
        // ModItems.corruptedStone, 'd', ModBlocks.darkstone);

        addRecipe(ModBlocks.coalstoneStairs, "c  ", "cc ", "ccc", 'c', ModBlocks.coalstone);

        addRecipe(ModBlocks.redFence, "   ", "III", "III", 'I', Items.REDSTONE);
        addRecipe(ModBlocks.greenFence, "   ", "III", "III", 'I', new ItemStack(Items.DYE, 1, 2));
        addRecipe(ModBlocks.blueFence, "   ", "III", "III", 'I', new ItemStack(Items.DYE, 1, 4));

        addRecipe(ModItems.teleportationCrystal, "EEE", "EDE", "EEE", 'E', Items.ENDER_PEARL, 'D', Items.DIAMOND);
        addRecipe(new ItemStack(ModBlocks.darkBridge), "GGG", "G G", "GGG", 'G', Items.GLOWSTONE_DUST);

        addRecipe(ModBlocks.hellspiderPumpkin, "MMM", "MPM", "MMM", 'M', ModItems.moltenShards, 'P', Blocks.PUMPKIN);
        addRecipe(ModBlocks.frostPumpkin, "MMM", "MPM", "MMM", 'M', ModItems.iceStone, 'P', Blocks.PUMPKIN);
        addRecipe(ModBlocks.jungleSpiderPumpkin, "MMM", "MPM", "MMM", 'M', ModItems.jungleShards, 'P', Blocks.PUMPKIN);
        addRecipe(ModBlocks.blazePumpkin, "MMM", "MPM", "MMM", 'M', Items.BLAZE_ROD, 'P', Blocks.PUMPKIN);
        addRecipe(ModBlocks.enderWatcherPumpkin, "MMM", "MPM", "MMM", 'M', ModItems.enderShards, 'P', Blocks.PUMPKIN);
        addRecipe(ModBlocks.glaconPumpkin, "MMM", "MPM", "MMM", 'M', ModItems.iceShards, 'P', Blocks.PUMPKIN);
        addRecipe(ModBlocks.zombiePumpkin, "MMM", "MPM", "MMM", 'M', Items.ROTTEN_FLESH, 'P', Blocks.PUMPKIN);
        addRecipe(ModBlocks.creeperPumpkin, "MMM", "MPM", "MMM", 'M', Items.GUNPOWDER, 'P', Blocks.PUMPKIN);
        addRecipe(ModBlocks.cyclopsPumpkin, "MMM", "MPM", "MMM", 'M', Items.GOLD_INGOT, 'P', Blocks.PUMPKIN);
        addRecipe(ModBlocks.enderPumpkin, "MMM", "MPM", "MMM", 'M', Items.ENDER_PEARL, 'P', Blocks.PUMPKIN);
        addRecipe(ModBlocks.ghastPumpkin, "MMM", "MPM", "MMM", 'M', Items.GHAST_TEAR, 'P', Blocks.PUMPKIN);
        addRecipe(ModBlocks.skeletonPumpkin, "MMM", "MPM", "MMM", 'M', Items.BONE, 'P', Blocks.PUMPKIN);
        addRecipe(ModBlocks.spiderPumpkin, "MMM", "MPM", "MMM", 'M', Items.STRING, 'P', Blocks.PUMPKIN);

        addShapelessRecipe(new ItemStack(ModBlocks.rainbowWool, 4), new ItemStack(Blocks.WOOL, 1, 1),
                new ItemStack(Blocks.WOOL, 1, 14), new ItemStack(Blocks.WOOL, 1, 4), new ItemStack(Blocks.WOOL, 1, 5),
                new ItemStack(Blocks.WOOL, 1, 9), new ItemStack(Blocks.WOOL, 1, 11), new ItemStack(Blocks.WOOL, 1, 10));
        addRecipe(new ItemStack(ModBlocks.checker, 3), "xyx", "yxy", "xyx", 'x', new ItemStack(Blocks.WOOL, 1, 0), 'y',
                new ItemStack(Blocks.WOOL, 1, 15));
        addRecipe(new ItemStack(ModBlocks.blueStone, 8), "GGG", "GLG", "GGG", 'G', Blocks.GLOWSTONE, 'L',
                new ItemStack(Items.DYE, 1, 4));
        addOredictRecipe(new ItemStack(ModBlocks.crate, 4), "xxx", "y y", "xxx", 'x', "plankWood", 'y', "logWood");
        addRecipe(new ItemStack(ModBlocks.plankDesign, 4), "xyx", "yxy", "xyx", 'x', new ItemStack(Blocks.PLANKS, 1, 0),
                'y', new ItemStack(Blocks.PLANKS, 1, 1));

        addRecipe(new ItemStack(ModBlocks.skeletonTorch, 4), "x", "y", 'y', Items.BONE, 'x', Items.COAL);
        addOredictRecipe(new ItemStack(ModBlocks.aquaTorch, 4), "x", "y", 'y', "stickWood", 'x',
                ModItems.aquaticBlazeRod);
        // FIXME - Need to add
        // addOredictRecipe(new ItemStack(ModBlocks.edenTorch, 4), "x", "y", 'y',
        // "stickWood", 'x', ModItems.edenFragments);

        addRecipe(new ItemStack(ModBlocks.spikeBlock), "x x", " x ", "x x", 'x', Items.IRON_INGOT);
        addRecipe(new ItemStack(ModBlocks.hotSpikeBlock), "x x", " x ", "x x", 'x', ModItems.netheriteIngot);

        addShapelessRecipe(new ItemStack(ModItems.whiteMushroomSeeds, 4), ModItems.whiteMushroom);
        addShapelessRecipe(new ItemStack(ModItems.tomatoSeeds, 4), ModItems.tomato);

        addStairRecipe(ModBlocks.divinePlanks, ModBlocks.divineStairs);
        addSlabRecipe(ModBlocks.divinePlanks, ModBlocks.divineSlab);

        // FIXME - Need to add
        // addShapelessRecipe(new ItemStack(ModBlocks.eucalyptusPlank, 4),
        // ModBlocks.eucalyptusWood);

        addShapelessRecipe(new ItemStack(ModBlocks.frozenPlanks, 4), ModBlocks.frozenWood);
        addStairRecipe(ModBlocks.frozenPlanks, ModBlocks.frozenStairs);
        addSlabRecipe(ModBlocks.frozenPlanks, ModBlocks.frozenSlab);

        addRecipe(new ItemStack(ModBlocks.blueVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.DYE, 4), 'O',
                Blocks.OBSIDIAN);
        addRecipe(new ItemStack(ModBlocks.redVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.DYE, 1, 1), 'O',
                Blocks.OBSIDIAN);
        addRecipe(new ItemStack(ModBlocks.cyanVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.DYE, 1, 6), 'O',
                Blocks.OBSIDIAN);
        addRecipe(new ItemStack(ModBlocks.purpleVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.DYE, 1, 5), 'O',
                Blocks.OBSIDIAN);
        addRecipe(new ItemStack(ModBlocks.yellowVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.DYE, 1, 11),
                'O', Blocks.OBSIDIAN);

        GenerateJSON.generateConstants();
    }
}
