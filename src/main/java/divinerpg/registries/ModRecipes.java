package divinerpg.registries;

import divinerpg.util.GenerateJSON;
import net.minecraft.block.*;
import net.minecraft.item.*;
    public class ModRecipes {

        public static void addOredictRecipe(Block result, Object... materials) {
                GenerateJSON.addRecipe(new ItemStack(result, 1), materials);
        }

        public static void addOredictRecipe(Item result, Object... materials) {
                GenerateJSON.addRecipe(new ItemStack(result, 1), materials);
        }

        public static void addOredictRecipe(ItemStack result, Object... materials) {
                GenerateJSON.addRecipe(result, materials);
        }

        public static void addRecipe(Block b, Object... o) {
                GenerateJSON.addRecipe(new ItemStack(b, 1), o);
        }

        public static void addRecipe(Item i, Object... o) {
            GenerateJSON.addRecipe(new ItemStack(i, 1), o);
        }

        public static void addRecipe(ItemStack i, Object... o) {
                GenerateJSON.addRecipe(i, o);
        }

        public static void addShapelessRecipe(Block b, Object... o) {
                GenerateJSON.addShapelessRecipe(new ItemStack(b, 1), o);
        }

        public static void addShapelessRecipe(Item i, Object... o) {
            GenerateJSON.addShapelessRecipe(new ItemStack(i, 1), o);
        }

        public static void addShapelessRecipe(ItemStack i, Object... o) {
                GenerateJSON.addShapelessRecipe(i, o);
        }

        public static void addSlabRecipe(Block mat, Block slab) {
                GenerateJSON.addRecipe(new ItemStack(slab, 6), "XXX", 'X', mat);
        }

        public static void addSmelting(Block input, Block output, float XP) {
                GenerateJSON.addSmelting(new ItemStack(input, 1), new ItemStack(output, 1), XP);
        }

        public static void addSmelting(Block input, Item output, float XP) {
            GenerateJSON.addSmelting(new ItemStack(input, 1), new ItemStack(output, 1), XP);
        }

        public static void addSmelting(Item input, Block output, float XP) {
                GenerateJSON.addSmelting(new ItemStack(input, 1), new ItemStack(output, 1), XP);
        }

        public static void addSmelting(Item input, Item output, float XP) {
                GenerateJSON.addSmelting(new ItemStack(input, 1), new ItemStack(output, 1), XP);
        }

        public static void addSmelting(ItemStack input, ItemStack output, float XP) {
            GenerateJSON.addSmelting(input, output, XP);
        }

        public static void addBlasting(ItemStack input, ItemStack output, float XP) {
            GenerateJSON.addBlasting(input, output, XP);
        }

        public static void addCampfireCooking(ItemStack input, ItemStack output, float XP) {
            GenerateJSON.addCampfireCooking(input, output, XP);
        }

        public static void addStairRecipe(Block mat, Block stair) {
                GenerateJSON.addRecipe(new ItemStack(stair, 4), "X  ", "XX ", "XXX", 'X', mat);
        }

    public ModRecipes() {

            //TODO - Check/change item recipes based on 1.12.2 build
//        https://github.com/DivineRPG/DivineRPG/tree/1.12.2/src/main/resources/assets/divinerpg/recipes
        addBlasting(new ItemStack(BlockRegistry.apalachiaOre), new ItemStack(ItemRegistry.apalachiaFragments), 1.3F);
        addBlasting(new ItemStack(BlockRegistry.arlemiteOre), new ItemStack(ItemRegistry.arlemiteIngot), 1.0F);
        addBlasting(new ItemStack(BlockRegistry.bloodgemOre), new ItemStack(ItemRegistry.bloodgem), 1.2F);
        addBlasting(new ItemStack(BlockRegistry.edenOre), new ItemStack(ItemRegistry.edenFragments), 0.7F);
        addBlasting(new ItemStack(BlockRegistry.mortumOre), new ItemStack(ItemRegistry.mortumFragments), 2.0F);
        addBlasting(new ItemStack(BlockRegistry.realmiteOre), new ItemStack(ItemRegistry.realmiteIngot), 0.7F);
        addBlasting(new ItemStack(BlockRegistry.rupeeOre), new ItemStack(ItemRegistry.rupeeIngot), 1.0F);
        addBlasting(new ItemStack(BlockRegistry.skythernOre), new ItemStack(ItemRegistry.skythernFragments), 1.7F);
        addBlasting(new ItemStack(BlockRegistry.torriditeOre), new ItemStack(ItemRegistry.torriditeIngot), 1.1F);
        addBlasting(new ItemStack(BlockRegistry.wildwoodOre), new ItemStack(ItemRegistry.wildwoodFragments), 1.0F);
        addCampfireCooking(new ItemStack(ItemRegistry.rawEmpoweredMeat), new ItemStack(ItemRegistry.empoweredMeat), 1);
        addRecipe(BlockRegistry.altarOfCorruption, "sss", "ddd", "ddd", 's', ItemRegistry.corruptedStone, 'd', BlockRegistry.darkstone);
        addRecipe(BlockRegistry.apalachiaBlock, "FIF", "IBI", "FIF", 'F', ItemRegistry.apalachiaFragments, 'B', ItemRegistry.apalachiaHeart, 'I', ItemRegistry.apalachiaSoul);
        addRecipe(BlockRegistry.aquaLamp, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', Items.WATER_BUCKET);
        addRecipe(BlockRegistry.arcaniteTubes, "iii", "iii", "iii", 'i', ItemRegistry.arcanium);
        addRecipe(BlockRegistry.arlemiteBlock, "III", "III", "III", 'I', ItemRegistry.arlemiteIngot);
        addRecipe(BlockRegistry.arlemiteBricks, "xyx", "yxy", "xyx", 'x', ItemRegistry.arlemiteIngot, 'y', "minecraft:stone_bricks");
        addRecipe(BlockRegistry.arlemiteLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', ItemRegistry.arlemiteIngot, 'z', Blocks.GLOWSTONE);
        addRecipe(BlockRegistry.arlemiteMinibricks, "XXX", "XCX", "XXX", 'X', BlockRegistry.minibricks, 'C', ItemRegistry.arlemiteIngot);
        addRecipe(BlockRegistry.bedrockMinibricks, "XXX", "XCX", "XXX", 'X', BlockRegistry.minibricks, 'C', ItemRegistry.bedrockChunk);
        addRecipe(BlockRegistry.blackSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.BLACK_DYE, 1));
        addRecipe(BlockRegistry.blazeLamp, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', Items.BLAZE_ROD);
        addRecipe(BlockRegistry.blazePumpkin, "MMM", "MPM", "MMM", 'M', Items.BLAZE_ROD, 'P', Blocks.PUMPKIN);
        addRecipe(BlockRegistry.bloodgemBlock, "III", "III", "III", 'I', ItemRegistry.bloodgem);
        addRecipe(BlockRegistry.bloodgemMinibricks, "XXX", "XCX", "XXX", 'X', BlockRegistry.minibricks, 'C', ItemRegistry.bloodgem);
        addRecipe(BlockRegistry.blueFence, "   ", "III", "III", 'I', new ItemStack(Items.LAPIS_LAZULI, 1));
        addRecipe(BlockRegistry.blueSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.LAPIS_LAZULI, 1));
        addRecipe(BlockRegistry.boneChest, "bbb", "b b", "bbb", 'b', Items.BONE);
        addRecipe(BlockRegistry.brightRedSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.MAGENTA_DYE, 1));
        addRecipe(BlockRegistry.coalstoneStairs, "c  ", "cc ", "ccc", 'c', BlockRegistry.coalstone);
        addRecipe(BlockRegistry.creeperPumpkin, "MMM", "MPM", "MMM", 'M', Items.GUNPOWDER, 'P', Blocks.PUMPKIN);
        addRecipe(BlockRegistry.cyclopsPumpkin, "MMM", "MPM", "MMM", 'M', Items.GOLD_INGOT, 'P', Blocks.PUMPKIN);
        addRecipe(BlockRegistry.diamondLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', Items.DIAMOND, 'z', Blocks.GLOWSTONE);
        addRecipe(BlockRegistry.drakenLamp, "xxx", "zyz", "xxx", 'x', Items.IRON_INGOT, 'y', Items.LAVA_BUCKET, 'z', Blocks.GOLD_BLOCK);
        addRecipe(BlockRegistry.dungeonBookshelf, "DDD", "BBB", "DDD", 'D', BlockRegistry.degradedBricksBreakable, 'B', Items.BOOK);
        addRecipe(BlockRegistry.edenBlock, "FIF", "IBI", "FIF", 'I', ItemRegistry.edenSoul, 'F', ItemRegistry.edenFragments, 'I', ItemRegistry.edenHeart);
        addRecipe(BlockRegistry.edenChest, "bbb", "b b", "bbb", 'b', ItemRegistry.edenFragments);
        addRecipe(BlockRegistry.edenLamp, "xxx", "xyx", "xxx", 'y', ItemRegistry.edenFragments, 'x', Items.IRON_INGOT);
        addRecipe(BlockRegistry.enderLamp, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', Items.ENDER_EYE);
        addRecipe(BlockRegistry.enderPumpkin, "MMM", "MPM", "MMM", 'M', Items.ENDER_PEARL, 'P', Blocks.PUMPKIN);
        addRecipe(BlockRegistry.enderWatcherPumpkin, "MMM", "MPM", "MMM", 'M', ItemRegistry.enderShards, 'P', Blocks.PUMPKIN);
        addRecipe(BlockRegistry.frostPumpkin, "MMM", "MPM", "MMM", 'M', ItemRegistry.iceStone, 'P', Blocks.PUMPKIN);
        addRecipe(BlockRegistry.frostedAllure, "XYX", "YZY", "XYX", 'X', ItemRegistry.iceShards, 'Y', ItemRegistry.iceStone, 'Z', ItemRegistry.aquaticIngot);
        addRecipe(BlockRegistry.ghastPumpkin, "MMM", "MPM", "MMM", 'M', Items.GHAST_TEAR, 'P', Blocks.PUMPKIN);
        addRecipe(BlockRegistry.glaconPumpkin, "MMM", "MPM", "MMM", 'M', ItemRegistry.iceShards, 'P', Blocks.PUMPKIN);
        addRecipe(BlockRegistry.goldLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', Items.GOLD_INGOT, 'z', Blocks.GLOWSTONE);
        addRecipe(BlockRegistry.greenFence, "   ", "III", "III", 'I', new ItemStack(Items.GREEN_DYE, 1));
        addRecipe(BlockRegistry.greenSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.GREEN_DYE, 1));
        addRecipe(BlockRegistry.hellspiderPumpkin, "MMM", "MPM", "MMM", 'M', ItemRegistry.moltenShards, 'P', Blocks.PUMPKIN);
        addRecipe(BlockRegistry.jungleSpiderPumpkin, "MMM", "MPM", "MMM", 'M', ItemRegistry.jungleShards, 'P', Blocks.PUMPKIN);
        addRecipe(BlockRegistry.krakenLamp, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', ItemRegistry.krakenSkin);
        addRecipe(BlockRegistry.lapisLazuliLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.LAPIS_LAZULI, 1), 'z', Blocks.GLOWSTONE);
        addRecipe(BlockRegistry.lavaLamp, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', Items.LAVA_BUCKET);
        addRecipe(BlockRegistry.milkyLamp, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', Items.MILK_BUCKET);
        addRecipe(BlockRegistry.minibricks, "XXX", "XXX", "XXX", 'X', "minecraft:stone_bricks");
        addRecipe(BlockRegistry.mortumBlock, "FIF", "IBI", "FIF", 'F', ItemRegistry.mortumFragments, 'B', ItemRegistry.mortumHeart, 'I', ItemRegistry.mortumSoul);
        addRecipe(BlockRegistry.mortumBlock, "FIF", "IBI", "FIF", 'I', ItemRegistry.mortumSoul, 'F', ItemRegistry.mortumFragments, 'I', ItemRegistry.mortumHeart);
        addRecipe(BlockRegistry.orangeSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.ORANGE_DYE, 1));
        addRecipe(BlockRegistry.purpleSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.PURPLE_DYE, 1));
        addRecipe(BlockRegistry.realmiteBlock, "III", "III", "III", 'I', ItemRegistry.realmiteIngot);
        addRecipe(BlockRegistry.realmiteLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', ItemRegistry.realmiteIngot, 'z', Blocks.GLOWSTONE);
        addRecipe(BlockRegistry.realmiteMinibricks, "XXX", "XCX", "XXX", 'X', BlockRegistry.minibricks, 'C', ItemRegistry.realmiteIngot);
        addRecipe(BlockRegistry.redFence, "   ", "III", "III", 'I', Items.REDSTONE);
        addRecipe(BlockRegistry.redSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.RED_DYE, 1));
        addRecipe(BlockRegistry.redstoneOreLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', Items.REDSTONE, 'z', Blocks.GLOWSTONE);
        addRecipe(BlockRegistry.rupeeBlock, "III", "III", "III", 'I', ItemRegistry.rupeeIngot);
        addRecipe(BlockRegistry.rupeeLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', ItemRegistry.rupeeIngot, 'z', Blocks.GLOWSTONE);
        addRecipe(BlockRegistry.rupeeMinibricks, "XXX", "XCX", "XXX", 'X', BlockRegistry.minibricks, 'C', ItemRegistry.rupeeIngot);
        addRecipe(BlockRegistry.skeletonPumpkin, "MMM", "MPM", "MMM", 'M', Items.BONE, 'P', Blocks.PUMPKIN);
        addRecipe(BlockRegistry.skythernBlock, "FIF", "IBI", "FIF", 'I', ItemRegistry.skythernSoul, 'F', ItemRegistry.skythernFragments, 'I', ItemRegistry.skythernHeart);
        addRecipe(BlockRegistry.spiderPumpkin, "MMM", "MPM", "MMM", 'M', Items.STRING, 'P', Blocks.PUMPKIN);
        addRecipe(BlockRegistry.tealSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.CYAN_DYE, 1));
        addRecipe(BlockRegistry.torriditeBlock, "III", "III", "III", 'I', ItemRegistry.torriditeIngot);
        addRecipe(BlockRegistry.torriditeLamp, "xxx", "xyx", "xzx", 'x', Items.IRON_INGOT, 'y', ItemRegistry.torriditeIngot, 'z', Blocks.GLOWSTONE);
        addRecipe(BlockRegistry.torriditeMinibricks, "XXX", "XCX", "XXX", 'X', BlockRegistry.minibricks, 'C', ItemRegistry.torriditeIngot);
        addRecipe(BlockRegistry.whiteSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.WHITE_DYE, 1));
        addRecipe(BlockRegistry.wildwoodBlock, "FIF", "IBI", "FIF", 'F', ItemRegistry.wildwoodFragments, 'B', ItemRegistry.wildwoodHeart, 'I', ItemRegistry.wildwoodSoul);
        addRecipe(BlockRegistry.workshopBookcase, "CCC", "BBB", "CCC", 'C', BlockRegistry.coalstone, 'B', Items.BOOK);
        addRecipe(BlockRegistry.yellowSteel, "xxx", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', new ItemStack(Items.YELLOW_DYE, 1));
        addRecipe(BlockRegistry.zombiePumpkin, "MMM", "MPM", "MMM", 'M', Items.ROTTEN_FLESH, 'P', Blocks.PUMPKIN);
        addRecipe(ItemRegistry.angelicBoots, "I I", "X X", 'I', ItemRegistry.bluefireStone, 'X', ItemRegistry.iceStone);
        addRecipe(ItemRegistry.angelicChestplate, "I I", "XIX", "XXX", 'I', ItemRegistry.bluefireStone, 'X', ItemRegistry.iceStone);
        addRecipe(ItemRegistry.angelicHelmet, "XXX", "I I", 'I', ItemRegistry.bluefireStone, 'X', ItemRegistry.iceStone);
        addRecipe(ItemRegistry.angelicLeggings, "III", "X X", "X X", 'I', ItemRegistry.bluefireStone, 'X', ItemRegistry.iceStone);
        addRecipe(ItemRegistry.apalachiaAxe, "II ", "IS ", " S ", 'I', ItemRegistry.apalachiaChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.apalachiaBlade, " I ", " I ", " S ", 'I', ItemRegistry.apalachiaChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.apalachiaBlitz, "X X", "X X", "XXX", 'X', ItemRegistry.apalachiaChunk);
        addRecipe(ItemRegistry.apalachiaBoots, "   ", "I I", "I I", 'I', ItemRegistry.apalachiaChunk);
        addRecipe(ItemRegistry.apalachiaBow, " IX", "I X", " IX", 'I', ItemRegistry.apalachiaChunk, 'X', Items.STRING);
        addRecipe(ItemRegistry.apalachiaChestplate, "I I", "III", "III", 'I', ItemRegistry.apalachiaChunk);
        addRecipe(ItemRegistry.apalachiaChunk, "GGG", "G G", "G G", 'G', ItemRegistry.apalachiaGem);
        addRecipe(ItemRegistry.apalachiaGem, "GGG", 'G', ItemRegistry.apalachiaFragments);
        addRecipe(ItemRegistry.apalachiaGem, "GGG", 'G', ItemRegistry.apalachiaSoul);
        addRecipe(ItemRegistry.apalachiaHelmet, "III", "I I", 'I', ItemRegistry.apalachiaChunk);
        addRecipe(ItemRegistry.apalachiaLeggings, "III", "I I", "I I", 'I', ItemRegistry.apalachiaChunk);
        addRecipe(ItemRegistry.apalachiaPhaser, " X ", "XXX", " S ", 'X', ItemRegistry.apalachiaChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.apalachiaPickaxe, "III", " S ", " S ", 'I', ItemRegistry.apalachiaChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.apalachiaShovel, " I ", " S ", " S ", 'I', ItemRegistry.apalachiaChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.aquaBall, "wsw", "wkw", "wsw", 'w', Items.WATER_BUCKET, 's', Items.SLIME_BALL, 'k', ItemRegistry.krakenSkin);
        addRecipe(ItemRegistry.aquastriveBoots, "I I", "I I", 'I', ItemRegistry.aquaticIngot);
        addRecipe(ItemRegistry.aquastriveChestplate, "I I", "III", "III", 'I', ItemRegistry.aquaticIngot);
        addRecipe(ItemRegistry.aquastriveHelmet, "III", "I I", 'I', ItemRegistry.aquaticIngot);
        addRecipe(ItemRegistry.aquastriveLeggings, "III", "I I", "I I", 'I', ItemRegistry.aquaticIngot);
        addRecipe(ItemRegistry.aquaticDagger, "   ", " I ", " S ", 'I', ItemRegistry.aquaticIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.aquaticMaul, "III", "III", "ISI", 'I', ItemRegistry.aquaticIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.aquaticTrident, " I ", "III", " S ", 'I', ItemRegistry.aquaticIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.aquaton, "III", "III", " S ", 'I', ItemRegistry.aquaticIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.aquatoothMaul, "TKT", "TKT", "KSK", 'T', ItemRegistry.liopleurodonTeeth, 'K', ItemRegistry.liopleurodonSkull, 'S', Items.STICK);
        addRecipe(ItemRegistry.aquatoothSword, " T ", "TKT", " S ", 'T', ItemRegistry.liopleurodonTeeth, 'K', ItemRegistry.liopleurodonSkull, 'S', Items.STICK);
        addRecipe(ItemRegistry.arlemiteAxe, "II ", "IS ", " S ", 'I', ItemRegistry.arlemiteIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.arlemiteBoots, "X X", "I I", 'I', ItemRegistry.arlemiteIngot, 'X', Items.IRON_INGOT);
        addRecipe(ItemRegistry.arlemiteChestplate, "I I", "XIX", "IXI", 'I', ItemRegistry.arlemiteIngot, 'X', Items.IRON_INGOT);
        addRecipe(ItemRegistry.arlemiteHelmet, "III", "X X", 'I', ItemRegistry.arlemiteIngot, 'X', Items.IRON_INGOT);
        addRecipe(ItemRegistry.arlemiteHoe, "II ", " S ", " S ", 'I', ItemRegistry.arlemiteIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.arlemiteIngot, "III", "III", "III", 'I', ItemRegistry.arlemiteNugget);
        addRecipe(ItemRegistry.arlemiteLeggings, "III", "X X", "I I", 'I', ItemRegistry.arlemiteIngot, 'X', Items.IRON_INGOT);
        addRecipe(ItemRegistry.arlemitePickaxe, "III", " S ", " S ", 'I', ItemRegistry.arlemiteIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.arlemite_shield, "prp", "pCp", " r ", 'r', ItemRegistry.arlemiteIngot, 'p', ItemRegistry.shadowBar, 'C', ItemRegistry.bloodgem);
        addRecipe(ItemRegistry.arlemiteShovel, " I ", " S ", " S ", 'I', ItemRegistry.arlemiteIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.arlemiteStabber, " I ", " I ", " S ", 'I', ItemRegistry.arlemiteIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.awakened_haliteHelmet, "dHd", "dhd", "aha", 'h', ItemRegistry.haliteHelmet, 'a', ItemRegistry.arcanium, 'd', ItemRegistry.divineStone, 'H', ItemRegistry.corruptedHelmet);
        addRecipe(ItemRegistry.awakened_haliteChestplate, "dHd", "dhd", "aha", 'h', ItemRegistry.haliteChestplate, 'a', ItemRegistry.arcanium, 'd', ItemRegistry.divineStone, 'H', ItemRegistry.corruptedChestplate);
        addRecipe(ItemRegistry.awakened_haliteLeggings, "dHd", "dhd", "aha", 'h', ItemRegistry.haliteLeggings, 'a', ItemRegistry.arcanium, 'd', ItemRegistry.divineStone, 'H', ItemRegistry.corruptedLeggings);
        addRecipe(ItemRegistry.awakened_haliteBoots, "dHd", "dhd", "aha", 'h', ItemRegistry.haliteBoots, 'a', ItemRegistry.arcanium, 'd', ItemRegistry.divineStone, 'H', ItemRegistry.corruptedBoots);
        addRecipe(ItemRegistry.bedrockAxe, "II ", "IS ", " S ", 'I', ItemRegistry.bedrockChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.bedrockBoots, "I I", "I I", 'I', ItemRegistry.bedrockChunk);
        addRecipe(ItemRegistry.bedrockChestplate, "I I", "III", "III", 'I', ItemRegistry.bedrockChunk);
        addRecipe(ItemRegistry.bedrockHelmet, "III", "I I", 'I', ItemRegistry.bedrockChunk);
        addRecipe(ItemRegistry.bedrockLeggings, "III", "I I", "I I", 'I', ItemRegistry.bedrockChunk);
        addRecipe(ItemRegistry.bedrockMaul, " B ", "BBB", " I ", 'B', ItemRegistry.bedrockChunk, 'I', Items.STICK);
        addRecipe(ItemRegistry.bedrockPickaxe, "III", " S ", " S ", 'I', ItemRegistry.bedrockChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.bedrockShovel, " I ", " S ", " S ", 'I', ItemRegistry.bedrockChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.bedrockSword, " B ", " B ", " S ", 'B', ItemRegistry.bedrockChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.bloodgem_sword, " I ", " I ", " S ", 'I', ItemRegistry.bloodgem, 'S', Items.STICK);
        addRecipe(ItemRegistry.bluefireBow, " IX", "I X", " IX", 'I', ItemRegistry.aquaticBlazeRod, 'X', ItemRegistry.bluefireStone);
        addRecipe(ItemRegistry.bluefireSword, " I ", " I ", " S ", 'I', ItemRegistry.bluefireStone, 'S', ItemRegistry.shadowBar);
        addRecipe(ItemRegistry.bowheadAnchor, "III", "IXI", " X ", 'I', ItemRegistry.whaleFin, 'X', ItemRegistry.aquaticIngot);
        addRecipe(ItemRegistry.bowheadCannon, " I ", " I ", " X ", 'I', ItemRegistry.whaleFin, 'X', ItemRegistry.aquaticIngot);
        addRecipe(ItemRegistry.callOfTheWatcher, " H ", "SES", " S ", 'E', ItemRegistry.watchingEye, 'S', ItemRegistry.moltenStone, 'H', ItemRegistry.hellstoneIngot);
        addRecipe(ItemRegistry.corruptedAxe, "II ", "IS ", " S ", 'I', ItemRegistry.corruptedStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.corruptedBoots, "I I", "I I", 'I', ItemRegistry.corruptedStone);
        addRecipe(ItemRegistry.corruptedCannon, "III", "S S", 'I', ItemRegistry.corruptedStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.corruptedChestplate, "I I", "III", "III", 'I', ItemRegistry.corruptedStone);
        addRecipe(ItemRegistry.corruptedHelmet, "III", "I I", 'I', ItemRegistry.corruptedStone);
        addRecipe(ItemRegistry.corruptedLeggings, "III", "I I", "I I", 'I', ItemRegistry.corruptedStone);
        addRecipe(ItemRegistry.corruptedMaul, "III", "ISI", " S ", 'I', ItemRegistry.corruptedStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.corruptedPickaxe, "III", " S ", " S ", 'I', ItemRegistry.corruptedStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.corruptedShovel, " I ", " S ", " S ", 'I', ItemRegistry.corruptedStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.corruptedStone, "III", "III", "III", 'I', ItemRegistry.corruptedShards);
        addRecipe(ItemRegistry.crabAnchor, "III", "IXI", " X ", 'I', ItemRegistry.crabClaw, 'X', ItemRegistry.aquaticIngot);
        addRecipe(ItemRegistry.crabclawCannon, " I ", " I ", " X ", 'I', ItemRegistry.crabClaw, 'X', ItemRegistry.aquaticIngot);
        addRecipe(ItemRegistry.crabclawMaul, "III", "ISI", " S ", 'I', ItemRegistry.crabClaw, 'S', Items.STICK);
        addRecipe(ItemRegistry.cyclopsEye, "III", "III", "III", 'I', ItemRegistry.cyclopsEyeShards);
        addRecipe(ItemRegistry.cyclopsianStaff, " E ", " S ", " S ", 'E', ItemRegistry.cyclopsEye, 'S', Items.STICK);
        addRecipe(ItemRegistry.cyclopsianSword, " E ", " E ", " S ", 'E', ItemRegistry.cyclopsEye, 'S', Items.STICK);
        addRecipe(ItemRegistry.deathBringer, " I ", "ISI", " S ", 'I', ItemRegistry.corruptedStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.divineAxe, "II ", "IS ", " S ", 'I', ItemRegistry.divineStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.divineBoots, "I I", "I I", 'I', ItemRegistry.divineStone);
        addRecipe(ItemRegistry.divineChestplate, "I I", "III", "III", 'I', ItemRegistry.divineStone);
        addRecipe(ItemRegistry.divineHelmet, "III", "I I", 'I', ItemRegistry.divineStone);
        addRecipe(ItemRegistry.divineLeggings, "III", "I I", "I I", 'I', ItemRegistry.divineStone);
        addRecipe(ItemRegistry.divinePickaxe, "III", " S ", " S ", 'I', ItemRegistry.divineStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.divineShovel, " I ", " S ", " S ", 'I', ItemRegistry.divineStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.divineStone, "III", "III", "III", 'I', ItemRegistry.divineShards);
        addRecipe(ItemRegistry.divineSword, " I ", "III", " S ", 'I', ItemRegistry.divineStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.edenAxe, "II ", "IS ", " S ", 'I', ItemRegistry.edenChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.edenBlade, " I ", " I ", " S ", 'I', ItemRegistry.edenChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.edenBlitz, "X X", "X X", "XXX", 'X', ItemRegistry.edenChunk);
        addRecipe(ItemRegistry.edenBoots, "   ", "I I", "I I", 'I', ItemRegistry.edenChunk);
        addRecipe(ItemRegistry.edenBow, " IX", "I X", " IX", 'I', ItemRegistry.edenChunk, 'X', Items.STRING);
        addRecipe(ItemRegistry.edenChestplate, "I I", "III", "III", 'I', ItemRegistry.edenChunk);
        addRecipe(ItemRegistry.edenChunk, "GGG", "G G", "G G", 'G', ItemRegistry.edenGem);
        addRecipe(ItemRegistry.edenGem, "GGG", 'G', ItemRegistry.edenFragments);
        addRecipe(ItemRegistry.edenGem, "GGG", 'G', ItemRegistry.edenSoul);
        addRecipe(ItemRegistry.edenHelmet, "III", "I I", 'I', ItemRegistry.edenChunk);
        addRecipe(ItemRegistry.edenLeggings, "III", "I I", "I I", 'I', ItemRegistry.edenChunk);
        addRecipe(ItemRegistry.edenPhaser, " X ", "XXX", " S ", 'X', ItemRegistry.edenChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.edenPickaxe, "III", " S ", " S ", 'I', ItemRegistry.edenChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.eden_shield, "ppp", "pCp", " r ", 'r', ItemRegistry.edenChunk, 'p', BlockRegistry.edenPlanks, 'C', ItemRegistry.edenSoul);
        addRecipe(ItemRegistry.edenShovel, " I ", " S ", " S ", 'I', ItemRegistry.edenChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.eliteRealmiteBoots, "I I", "I I", 'I', BlockRegistry.realmiteBlock);
        addRecipe(ItemRegistry.eliteRealmiteChestplate, "I I", "III", "III", 'I', BlockRegistry.realmiteBlock);
        addRecipe(ItemRegistry.eliteRealmiteHelmet, "III", "I I", 'I', BlockRegistry.realmiteBlock);
        addRecipe(ItemRegistry.eliteRealmiteLeggings, "III", "I I", "I I", 'I', BlockRegistry.realmiteBlock);
        addRecipe(ItemRegistry.enderBoots, "I I", "I I", 'I', ItemRegistry.enderStone);
        addRecipe(ItemRegistry.enderBow, " IX", "E X", " IX", 'I', ItemRegistry.enderStone, 'X', Items.STRING, 'E', ItemRegistry.watchingEye);
        addRecipe(ItemRegistry.enderChestplate, "I I", "III", "III", 'I', ItemRegistry.enderStone);
        addRecipe(ItemRegistry.enderHelmet, "III", "I I", 'I', ItemRegistry.enderStone);
        addRecipe(ItemRegistry.enderLeggings, "III", "I I", "I I", 'I', ItemRegistry.enderStone);
        addRecipe(ItemRegistry.enderStone, "III", "III", "III", 'I', ItemRegistry.enderShards);
        addRecipe(ItemRegistry.enderSword, " L ", " L ", " S ", 'L', ItemRegistry.legendaryEnderEye, 'S', ItemRegistry.shadowBar);
        addRecipe(ItemRegistry.flamingFury, "XIX", "XIX", "XOX", 'I', ItemRegistry.furyFire, 'X', ItemRegistry.infernoSword, 'O', ItemRegistry.shadowBar);
        addRecipe(ItemRegistry.frostCannon, "I I", "I I", "XXX", 'I', ItemRegistry.shadowBar, 'X', ItemRegistry.iceStone);
        addRecipe(ItemRegistry.frostSword, " I ", " I ", " S ", 'I', ItemRegistry.iceStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.frozenBoots, "I I", "I I", 'I', ItemRegistry.iceStone);
        addRecipe(ItemRegistry.frozenChestplate, "I I", "III", "III", 'I', ItemRegistry.iceStone);
        addRecipe(ItemRegistry.frozenHelmet, "III", "I I", 'I', ItemRegistry.iceStone);
        addRecipe(ItemRegistry.frozenLeggings, "III", "I I", "I I", 'I', ItemRegistry.iceStone);
        addRecipe(ItemRegistry.furyMaul, "OBO", "BBB", "OBO", 'B', ItemRegistry.bedrockChunk, 'O', Blocks.DIAMOND_ORE);
        addRecipe(ItemRegistry.ghastCannon, "I I", "I I", "XXX", 'I', ItemRegistry.shadowBar, 'X', ItemRegistry.hellstoneIngot);
        addRecipe(ItemRegistry.goldenFury, "GGG", "GFG", "FFF", 'F', ItemRegistry.furyFire, 'G', Blocks.GOLD_BLOCK);
        addRecipe(ItemRegistry.hordeHorn, " H ", "SES", " S ", 'E', Items.ENDER_EYE, 'S', ItemRegistry.enderStone, 'H', ItemRegistry.hellstoneIngot);
        addRecipe(ItemRegistry.hunterBow, " IX", "I X", " IX", 'I', ItemRegistry.jungleStone, 'X', Items.STRING);
        addRecipe(ItemRegistry.iceStone, "III", "III", "III", 'I', ItemRegistry.iceShards);
        addRecipe(ItemRegistry.infernalFlame, "BBB", "BSB", "BBB", 'B', ItemRegistry.purpleBlaze, 'S', ItemRegistry.infernoSword);
        addRecipe(ItemRegistry.infernoBoots, "I I", "I I", 'I', ItemRegistry.moltenStone);
        addRecipe(ItemRegistry.infernoBow, " IX", "I X", " IX", 'I', ItemRegistry.moltenStone, 'X', Items.BLAZE_POWDER);
        addRecipe(ItemRegistry.infernoChestplate, "I I", "III", "III", 'I', ItemRegistry.moltenStone);
        addRecipe(ItemRegistry.infernoHelmet, "III", "I I", 'I', ItemRegistry.moltenStone);
        addRecipe(ItemRegistry.infernoLeggings, "III", "I I", "I I", 'I', ItemRegistry.moltenStone);
        addRecipe(ItemRegistry.infernoSword, "BOB", "BOB", "BSB", 'B', Items.BLAZE_POWDER, 'O', Blocks.REDSTONE_ORE, 'S', Items.STICK);
        addRecipe(ItemRegistry.jungleBoots, "I I", "I I", 'I', ItemRegistry.jungleStone);
        addRecipe(ItemRegistry.jungleChestplate, "I I", "III", "III", 'I', ItemRegistry.jungleStone);
        addRecipe(ItemRegistry.jungleHelmet, "III", "I I", 'I', ItemRegistry.jungleStone);
        addRecipe(ItemRegistry.jungleKnife, " I ", " I ", " S ", 'I', ItemRegistry.jungleStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.jungleLeggings, "III", "I I", "I I", 'I', ItemRegistry.jungleStone);
        addRecipe(ItemRegistry.jungleStone, "III", "III", "III", 'I', ItemRegistry.jungleShards);
        addRecipe(ItemRegistry.krakenBoots, "I I", "I I", 'I', ItemRegistry.krakenSkin);
        addRecipe(ItemRegistry.krakenChestplate, "I I", "III", "III", 'I', ItemRegistry.krakenSkin);
        addRecipe(ItemRegistry.krakenHelmet, "III", "I I", 'I', ItemRegistry.krakenSkin);
        addRecipe(ItemRegistry.krakenLeggings, "III", "I I", "I I", 'I', ItemRegistry.krakenSkin);
        addRecipe(ItemRegistry.krakenScale, "K K", "K K", "KKK", 'K', new ItemStack(Items.INK_SAC, 1));
        addRecipe(ItemRegistry.legendaryEnderEye, "III", "III", "III", 'I', ItemRegistry.enderStone);
        addRecipe(ItemRegistry.liopleurodonAnchor, "SIS", "IXI", " X ", 'I', ItemRegistry.liopleurodonTeeth, 'X', ItemRegistry.aquaticIngot, 'S', ItemRegistry.liopleurodonSkull);
        addRecipe(ItemRegistry.maelstrom, "III", "IXI", "III", 'I', ItemRegistry.purpleBlaze, 'X', Items.BOOK);
        addRecipe(ItemRegistry.massivence, "X X", "III", " I ", 'I', ItemRegistry.torriditeIngot, 'X', ItemRegistry.bloodgem);
        addRecipe(ItemRegistry.moltenStone, "III", "III", "III", 'I', ItemRegistry.moltenShards);
        addRecipe(ItemRegistry.moltenSword, " I ", " I ", " S ", 'I', ItemRegistry.moltenStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.mortumAxe, "II ", "IS ", " S ", 'I', ItemRegistry.mortumChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.mortumBlade, " I ", " I ", " S ", 'I', ItemRegistry.mortumChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.mortumBlitz, "X X", "X X", "XXX", 'X', ItemRegistry.mortumChunk);
        addRecipe(ItemRegistry.mortumBoots, "   ", "I I", "I I", 'I', ItemRegistry.mortumChunk);
        addRecipe(ItemRegistry.mortumBow, " IX", "I X", " IX", 'I', ItemRegistry.mortumChunk, 'X', Items.STRING);
        addRecipe(ItemRegistry.mortumChestplate, "I I", "III", "III", 'I', ItemRegistry.mortumChunk);
        addRecipe(ItemRegistry.mortumChunk, "GGG", "G G", "G G", 'G', ItemRegistry.mortumGem);
        addRecipe(ItemRegistry.mortumGem, "GGG", 'G', ItemRegistry.mortumFragments);
        addRecipe(ItemRegistry.mortumGem, "GGG", 'G', ItemRegistry.mortumSoul);
        addRecipe(ItemRegistry.mortumHelmet, "III", "I I", 'I', ItemRegistry.mortumChunk);
        addRecipe(ItemRegistry.mortumLeggings, "III", "I I", "I I", 'I', ItemRegistry.mortumChunk);
        addRecipe(ItemRegistry.mortumPhaser, " X ", "XXX", " S ", 'X', ItemRegistry.mortumChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.mortumPickaxe, "III", " S ", " S ", 'I', ItemRegistry.mortumChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.mortum_shield, "ppp", "prp", " z ", 'r', ItemRegistry.torriditeChunk, 'p', BlockRegistry.mortumPlanks, 'z', ItemRegistry.mortumChunk);
        addRecipe(ItemRegistry.mortumShovel, " I ", " S ", " S ", 'I', ItemRegistry.mortumChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.mysteriousClock, " H ", "SCS", " S ", 'C', Items.CLOCK, 'S', ItemRegistry.corruptedStone, 'H', ItemRegistry.hellstoneIngot);
        addRecipe(ItemRegistry.oceanKnife, " I ", " I ", " S ", 'I', ItemRegistry.aquaticIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.palavence, "I I", "III", " I ", 'I', ItemRegistry.realmiteIngot);
        addRecipe(ItemRegistry.poisonSaber, " R ", "BRB", "BSB", 'R', ItemRegistry.jungleStone, 'B', ItemRegistry.shadowBar, 'S', Items.STICK);
        addRecipe(ItemRegistry.pureAquaticPellets, "PPP", "PPP", "PPP", 'P', ItemRegistry.aquaticPellets);
        addRecipe(ItemRegistry.realmiteAxe, "II ", "IS ", " S ", 'I', ItemRegistry.realmiteIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.realmiteBoots, "I I", "I I", 'I', ItemRegistry.realmiteIngot);
        addRecipe(ItemRegistry.realmiteChestplate, "I I", "III", "III", 'I', ItemRegistry.realmiteIngot);
        addRecipe(ItemRegistry.realmiteHelmet, "III", "I I", 'I', ItemRegistry.realmiteIngot);
        addRecipe(ItemRegistry.realmiteHoe, "II ", " S ", " S ", 'I', ItemRegistry.realmiteIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.realmiteLeggings, "III", "I I", "I I", 'I', ItemRegistry.realmiteIngot);
        addRecipe(ItemRegistry.realmitePickaxe, "III", " S ", " S ", 'I', ItemRegistry.realmiteIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.realmite_shield, "prp", "prp", " r ", 'r', ItemRegistry.realmiteIngot, 'p', "minecraft:planks");
        addRecipe(ItemRegistry.realmiteShovel, " I ", " S ", " S ", 'I', ItemRegistry.realmiteIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.realmiteSword, " I ", " I ", " S ", 'I', ItemRegistry.realmiteIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.rupeeAxe, "II ", "IS ", " S ", 'I', ItemRegistry.rupeeIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.rupeeBoots, "I I", "I I", 'I', ItemRegistry.rupeeIngot);
        addRecipe(ItemRegistry.rupeeChestplate, "I I", "III", "III", 'I', ItemRegistry.rupeeIngot);
        addRecipe(ItemRegistry.rupeeHelmet, "III", "I I", 'I', ItemRegistry.rupeeIngot);
        addRecipe(ItemRegistry.rupeeHoe, "II ", " S ", " S ", 'I', ItemRegistry.rupeeIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.rupeeLeggings, "III", "I I", "I I", 'I', ItemRegistry.rupeeIngot);
        addRecipe(ItemRegistry.rupeePickaxe, "III", " S ", " S ", 'I', ItemRegistry.rupeeIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.rupeeRapier, " I ", " I ", " S ", 'I', ItemRegistry.rupeeIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.rupee_shield, "rpr", "rrr", " p ", 'r', ItemRegistry.rupeeIngot, 'p', ItemRegistry.shadowBar);
        addRecipe(ItemRegistry.rupeeShovel, " I ", " S ", " S ", 'I', ItemRegistry.rupeeIngot, 'S', Items.STICK);
        addRecipe(ItemRegistry.scorchingSword, " I ", " I ", " S ", 'I', ItemRegistry.purpleBlaze, 'S', ItemRegistry.torriditeIngot);
        addRecipe(ItemRegistry.serenadeOfDeath, "I  ", "III", "  I", 'I', ItemRegistry.shadowBar);
        addRecipe(ItemRegistry.serenadeOfHealth, "I  ", "III", "  I", 'I', ItemRegistry.torriditeChunk);
        addRecipe(ItemRegistry.serenadeStriker, "I  ", "III", "  I", 'I', Items.DIAMOND);
        addRecipe(ItemRegistry.shadowBoots, "I I", "I I", 'I', ItemRegistry.shadowStone);
        addRecipe(ItemRegistry.shadowBow, " IX", "I X", " IX", 'I', ItemRegistry.shadowBar, 'X', Items.STRING);
        addRecipe(ItemRegistry.shadowChestplate, "I I", "III", "III", 'I', ItemRegistry.shadowStone);
        addRecipe(ItemRegistry.shadowHelmet, "III", "I I", 'I', ItemRegistry.shadowStone);
        addRecipe(ItemRegistry.shadowLeggings, "III", "I I", "I I", 'I', ItemRegistry.shadowStone);
        addRecipe(ItemRegistry.shadowStone, "II", "II", 'I', ItemRegistry.shadowBar);
        addRecipe(ItemRegistry.sharkAnchor, "III", "IXI", " X ", 'I', ItemRegistry.sharkFin, 'X', ItemRegistry.aquaticIngot);
        addRecipe(ItemRegistry.sharkSword, " I ", " I ", " S ", 'I', ItemRegistry.sharkFin, 'S', ItemRegistry.aquaticIngot);
        addRecipe(ItemRegistry.shuriken, " I ", "III", " I ", 'I', Items.IRON_INGOT);
        addRecipe(ItemRegistry.skythernAxe, "II ", "IS ", " S ", 'I', ItemRegistry.skythernChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.skythernBlade, " I ", " I ", " S ", 'I', ItemRegistry.skythernChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.skythernBlitz, "X X", "X X", "XXX", 'X', ItemRegistry.skythernChunk);
        addRecipe(ItemRegistry.skythernBoots, "   ", "I I", "I I", 'I', ItemRegistry.skythernChunk);
        addRecipe(ItemRegistry.skythernBow, " IX", "I X", " IX", 'I', ItemRegistry.skythernChunk, 'X', Items.STRING);
        addRecipe(ItemRegistry.skythernChestplate, "I I", "III", "III", 'I', ItemRegistry.skythernChunk);
        addRecipe(ItemRegistry.skythernChunk, "GGG", "G G", "G G", 'G', ItemRegistry.skythernGem);
        addRecipe(ItemRegistry.skythernGem, "GGG", 'G', ItemRegistry.skythernFragments);
        addRecipe(ItemRegistry.skythernGem, "GGG", 'G', ItemRegistry.skythernSoul);
        addRecipe(ItemRegistry.skythernHelmet, "III", "I I", 'I', ItemRegistry.skythernChunk);
        addRecipe(ItemRegistry.skythernLeggings, "III", "I I", "I I", 'I', ItemRegistry.skythernChunk);
        addRecipe(ItemRegistry.skythernPhaser, " X ", "XXX", " S ", 'X', ItemRegistry.skythernChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.skythernPickaxe, "III", " S ", " S ", 'I', ItemRegistry.skythernChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.skythern_shield, "ppp", "prp", " z ", 'r', ItemRegistry.torriditeChunk, 'p', BlockRegistry.skythernPlanks, 'z', ItemRegistry.skythernChunk);
        addRecipe(ItemRegistry.skythernShovel, " I ", " S ", " S ", 'I', ItemRegistry.skythernChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.slimeSword, "SDS", "SDS", "SDS", 'D', Items.DIAMOND_SWORD, 'S', Items.SLIME_BALL);
        addRecipe(ItemRegistry.snowGlobe, " G ", "GSG", "DBD", 'G', Blocks.GLASS, 'S', Blocks.SNOW_BLOCK, 'D', Items.DIAMOND, 'B', ItemRegistry.shadowBar);
        addRecipe(ItemRegistry.soundOfMusic, "III", "IXI", "III", 'I', ItemRegistry.purpleBlaze, 'X', Items.STRING);
        addRecipe(ItemRegistry.teleportationCrystal, "EEE", "EDE", "EEE", 'E', Items.ENDER_PEARL, 'D', Items.DIAMOND);
        addRecipe(ItemRegistry.terranBoots, "I I", "I I", 'I', ItemRegistry.terranStone);
        addRecipe(ItemRegistry.terranChestplate, "I I", "III", "III", 'I', ItemRegistry.terranStone);
        addRecipe(ItemRegistry.terranDagger, " T ", " S ", 'T', ItemRegistry.terranStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.terranHelmet, "III", "I I", 'I', ItemRegistry.terranStone);
        addRecipe(ItemRegistry.terranKnife, " T ", " T ", " S ", 'T', ItemRegistry.terranStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.terranLeggings, "III", "I I", "I I", 'I', ItemRegistry.terranStone);
        addRecipe(ItemRegistry.terranMaul, "TTT", " T ", " S ", 'T', ItemRegistry.terranStone, 'S', Items.STICK);
        addRecipe(ItemRegistry.terranStone, "III", "III", "III", 'I', ItemRegistry.terranShards);
        addRecipe(ItemRegistry.torriditeBoots, "S S", "I I", 'I', BlockRegistry.torriditeBlock, 'S', ItemRegistry.shadowBar);
        addRecipe(ItemRegistry.torriditeChestplate, "S S", "III", "III", 'I', BlockRegistry.torriditeBlock, 'S', ItemRegistry.shadowBar);
        addRecipe(ItemRegistry.torriditeChunk, " I ", "III", " I ", 'I', ItemRegistry.torriditeIngot);
        addRecipe(ItemRegistry.torriditeHelmet, "III", "S S", 'I', BlockRegistry.torriditeBlock, 'S', ItemRegistry.shadowBar);
        addRecipe(ItemRegistry.torriditeLeggings, "III", "S S", "I I", 'I', BlockRegistry.torriditeBlock, 'S', ItemRegistry.shadowBar);
        addRecipe(ItemRegistry.twilightClock, "CCC", "CCC", "CCC", 'C', Items.CLOCK);
        addRecipe(ItemRegistry.wildwoodAxe, "II ", "IS ", " S ", 'I', ItemRegistry.wildwoodChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.wildwoodBlade, " I ", " I ", " S ", 'I', ItemRegistry.wildwoodChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.wildwoodBlitz, "X X", "X X", "XXX", 'X', ItemRegistry.wildwoodChunk);
        addRecipe(ItemRegistry.wildwoodBoots, "   ", "I I", "I I", 'I', ItemRegistry.wildwoodChunk);
        addRecipe(ItemRegistry.wildwoodBow, " IX", "I X", " IX", 'I', ItemRegistry.wildwoodChunk, 'X', Items.STRING);
        addRecipe(ItemRegistry.wildwoodChestplate, "I I", "III", "III", 'I', ItemRegistry.wildwoodChunk);
        addRecipe(ItemRegistry.wildwoodChunk, "GGG", "G G", "G G", 'G', ItemRegistry.wildwoodGem);
        addRecipe(ItemRegistry.wildwoodGem, "GGG", 'G', ItemRegistry.wildwoodFragments);
        addRecipe(ItemRegistry.wildwoodGem, "GGG", 'G', ItemRegistry.wildwoodSoul);
        addRecipe(ItemRegistry.wildwoodHelmet, "III", "I I", 'I', ItemRegistry.wildwoodChunk);
        addRecipe(ItemRegistry.wildwoodLeggings, "III", "I I", "I I", 'I', ItemRegistry.wildwoodChunk);
        addRecipe(ItemRegistry.wildwoodPhaser, " X ", "XXX", " S ", 'X', ItemRegistry.wildwoodChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.wildwoodPickaxe, "III", " S ", " S ", 'I', ItemRegistry.wildwoodChunk, 'S', Items.STICK);
        addRecipe(ItemRegistry.wildwood_shield, "ppp", "prp", " p ", 'r', ItemRegistry.wildwoodChunk, 'p', BlockRegistry.wildwoodPlanks);
        addRecipe(ItemRegistry.wildwoodShovel, " I ", " S ", " S ", 'I', ItemRegistry.wildwoodChunk, 'S', Items.STICK);
        addRecipe(new ItemStack(BlockRegistry.ancientBrickSlabBreakable, 6), "sss", 's', BlockRegistry.ancientBricksBreakable);
        addRecipe(new ItemStack(BlockRegistry.ancientBrickStairsBreakable, 4), "s  ", "ss ", "sss", 's', BlockRegistry.ancientBricksBreakable);
        addRecipe(new ItemStack(BlockRegistry.ancientBrickWallBreakable, 6), "sss", "sss", 's', BlockRegistry.ancientBricksBreakable);
        addRecipe(new ItemStack(BlockRegistry.apalachiaBricks, 4), "ss ", "si ", 's', "minecraft:stone_bricks", 'i', ItemRegistry.apalachiaGem);
        addRecipe(new ItemStack(BlockRegistry.apalachiaPlanks, 4), "s", 's', BlockRegistry.apalachiaLog);
        addRecipe(new ItemStack(BlockRegistry.apalachiaSlab, 6), "sss", 's', BlockRegistry.apalachiaPlanks);
        addRecipe(new ItemStack(BlockRegistry.apalachiaStairs, 4), "s  ", "ss ", "sss", 's', BlockRegistry.apalachiaPlanks);
        addRecipe(new ItemStack(BlockRegistry.aquaTorch, 4), "x", "y", 'y', Items.STICK, 'x', ItemRegistry.aquaticBlazeRod);
        addRecipe(new ItemStack(BlockRegistry.arcanaPortalFrame, 12), " c ", "iii", " c ", 'c', ItemRegistry.bluefireStone, 'i', Blocks.IRON_BLOCK);
        addRecipe(new ItemStack(BlockRegistry.arcaniumTorch, 4), "x", "y", 'y', Items.STICK, 'x', ItemRegistry.arcanium);
        addRecipe(new ItemStack(BlockRegistry.arcaniumTorch, 4), "x", "z", 'x', ItemRegistry.arcanium, 'z', Items.STICK);
        addRecipe(new ItemStack(BlockRegistry.blueStone, 8), "GGG", "GLG", "GGG", 'G', Blocks.GLOWSTONE, 'L', new ItemStack(Items.LAPIS_LAZULI, 1));
        addRecipe(new ItemStack(BlockRegistry.blueVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.LAPIS_LAZULI, 4), 'O', Blocks.OBSIDIAN);
        addRecipe(new ItemStack(BlockRegistry.checker, 3), "xyx", "yxy", "xyx", 'x', new ItemStack(Blocks.WHITE_WOOL, 1), 'y', new ItemStack(Blocks.BLACK_WOOL, 1));
        addRecipe(new ItemStack(BlockRegistry.crate, 4), "xxx", "y y", "xxx", 'x', "minecraft:planks", 'y', "minecraft:logs");
        addRecipe(new ItemStack(BlockRegistry.cyanVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.CYAN_DYE, 1), 'O', Blocks.OBSIDIAN);
        addRecipe(new ItemStack(BlockRegistry.darkBridge), "GGG", "G G", "GGG", 'G', Items.GLOWSTONE_DUST);
        addRecipe(new ItemStack(BlockRegistry.degradedBrickSlabBreakable, 6), "sss", 's', BlockRegistry.degradedBricksBreakable);
        addRecipe(new ItemStack(BlockRegistry.degradedBrickStairsBreakable, 4), "s  ", "ss ", "sss", 's', BlockRegistry.degradedBricksBreakable);
        addRecipe(new ItemStack(BlockRegistry.degradedBrickWallBreakable, 6), "sss", "sss", 's', BlockRegistry.degradedBricksBreakable);
        addRecipe(new ItemStack(BlockRegistry.divinePlanks, 4), "s", 's', BlockRegistry.divineLog);
        addRecipe(new ItemStack(BlockRegistry.divineSlab, 6), "sss", 's', BlockRegistry.divinePlanks);
        addRecipe(new ItemStack(BlockRegistry.divineStairs, 4), "s  ", "ss ", "sss", 's', BlockRegistry.divinePlanks);
        addRecipe(new ItemStack(BlockRegistry.edenPlanks, 4), "s", 's', BlockRegistry.edenLog);
        addRecipe(new ItemStack(BlockRegistry.edenSlab, 6), "sss", 's', BlockRegistry.edenPlanks);
        addRecipe(new ItemStack(BlockRegistry.edenStairs, 4), "s  ", "ss ", "sss", 's', BlockRegistry.edenPlanks);
        addRecipe(new ItemStack(BlockRegistry.edenTorch, 4), "x", "y", 'y', Items.STICK, 'x', ItemRegistry.edenFragments);
        addRecipe(new ItemStack(BlockRegistry.eucalyptusPlanks, 4), "s", 's', BlockRegistry.eucalyptusLog);
        addRecipe(new ItemStack(BlockRegistry.eucalyptusSlab, 6), "sss", 's', BlockRegistry.eucalyptusPlanks);
        addRecipe(new ItemStack(BlockRegistry.eucalyptusStairs, 4), "s  ", "ss ", "sss", 's', BlockRegistry.eucalyptusPlanks);
        addRecipe(new ItemStack(BlockRegistry.frozenPlanks, 4), "s", 's', BlockRegistry.frozenLog);
        addRecipe(new ItemStack(BlockRegistry.frozenSlab, 6), "sss", 's', BlockRegistry.frozenPlanks);
        addRecipe(new ItemStack(BlockRegistry.frozenStairs, 4), "s  ", "ss ", "sss", 's', BlockRegistry.frozenPlanks);
        addRecipe(new ItemStack(BlockRegistry.hotSpikeBlock), "x x", " x ", "x x", 'x', ItemRegistry.torriditeIngot);
        addRecipe(new ItemStack(BlockRegistry.mortumPlanks, 4), "s", 's', BlockRegistry.mortumLog);
        addRecipe(new ItemStack(BlockRegistry.mortumSlab, 6), "sss", 's', BlockRegistry.mortumPlanks);
        addRecipe(new ItemStack(BlockRegistry.mortumStairs, 4), "s  ", "ss ", "sss", 's', BlockRegistry.mortumPlanks);
        addRecipe(new ItemStack(BlockRegistry.plankDesign, 4), "xyx", "yxy", "xyx", 'x', "minecraft:planks", 'y', "minecraft:planks");
        addRecipe(new ItemStack(BlockRegistry.purpleVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.PURPLE_DYE, 1), 'O', Blocks.OBSIDIAN);
        addRecipe(new ItemStack(BlockRegistry.redVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.RED_DYE, 1), 'O', Blocks.OBSIDIAN);
        addRecipe(new ItemStack(BlockRegistry.skeletonTorch, 4), "x", "y", 'y', Items.BONE, 'x', Items.COAL);
        addRecipe(new ItemStack(BlockRegistry.skythernPlanks, 4), "s", 's', BlockRegistry.skythernLog);
        addRecipe(new ItemStack(BlockRegistry.skythernSlab, 6), "sss", 's', BlockRegistry.skythernPlanks);
        addRecipe(new ItemStack(BlockRegistry.skythernStairs, 4), "s  ", "ss ", "sss", 's', BlockRegistry.skythernPlanks);
        addRecipe(new ItemStack(BlockRegistry.spikeBlock), "x x", " x ", "x x", 'x', Items.IRON_INGOT);
        addRecipe(new ItemStack(BlockRegistry.stainedGlass, 1), "y  ", " x ", "   ", 'x', Blocks.GLASS, 'y', ItemRegistry.marsine);
        addRecipe(new ItemStack(BlockRegistry.stainedGlass2, 1), " y ", " x ", "   ", 'x', Blocks.GLASS, 'y', ItemRegistry.marsine);
        addRecipe(new ItemStack(BlockRegistry.stainedGlass3, 1), "  y", " x ", "   ", 'x', Blocks.GLASS, 'y', ItemRegistry.marsine);
        addRecipe(new ItemStack(BlockRegistry.stainedGlass4, 1), "   ", "yx ", "   ", 'x', Blocks.GLASS, 'y', ItemRegistry.marsine);
        addRecipe(new ItemStack(BlockRegistry.stainedGlass5, 1), "   ", " xy", "   ", 'x', Blocks.GLASS, 'y', ItemRegistry.marsine);
        addRecipe(new ItemStack(BlockRegistry.stainedGlass6, 1), "   ", " x ", "y  ", 'x', Blocks.GLASS, 'y', ItemRegistry.marsine);
        addRecipe(new ItemStack(BlockRegistry.stainedGlass7, 1), "   ", " x ", " y ", 'x', Blocks.GLASS, 'y', ItemRegistry.marsine);
        addRecipe(new ItemStack(BlockRegistry.stainedGlass8, 1), "   ", " x ", "  y", 'x', Blocks.GLASS, 'y', ItemRegistry.marsine);
        addRecipe(new ItemStack(BlockRegistry.wildwoodBricks, 4), "ss ", "si ", 's', "minecraft:stone_bricks", 'i', ItemRegistry.wildwoodGem);
        addRecipe(new ItemStack(BlockRegistry.wildwoodPlanks, 4), "s", 's', BlockRegistry.wildwoodLog);
        addRecipe(new ItemStack(BlockRegistry.wildwoodSlab, 6), "sss", 's', BlockRegistry.wildwoodPlanks);
        addRecipe(new ItemStack(BlockRegistry.wildwoodStairs, 4), "s  ", "ss ", "sss", 's', BlockRegistry.wildwoodPlanks);
        addRecipe(new ItemStack(BlockRegistry.yellowVane, 4), "CCC", "COC", "CCC", 'C', new ItemStack(Items.YELLOW_DYE, 1), 'O', Blocks.OBSIDIAN);
        addRecipe(new ItemStack(ItemRegistry.bedrockChunk, 3), "OOO", "OBO", " OO", 'O', Blocks.OBSIDIAN, 'B', BlockRegistry.rupeeBlock);
        addRecipe(new ItemStack(ItemRegistry.cheese, 3), "MMM", "MMM", "MMM", 'M', Items.MILK_BUCKET);
        addRecipe(new ItemStack(ItemRegistry.dualClaw), " C ", "AAA", " C ", 'C', ItemRegistry.crabClaw, 'A', ItemRegistry.aquaticIngot);
        addRecipe(new ItemStack(ItemRegistry.edenArrow, 4), " I ", " S ", " Z ", 'I', ItemRegistry.edenFragments, 'S', Items.STICK, 'Z', Items.FEATHER);
        addRecipe(new ItemStack(ItemRegistry.furyArrow, 4), " I ", " S ", " Z ", 'I', ItemRegistry.mortumFragments, 'S', Items.STICK, 'Z', Items.FEATHER);
        addRecipe(new ItemStack(ItemRegistry.jungleRapier), "S S", "SBS", " B ", 'S', ItemRegistry.jungleStone, 'B', ItemRegistry.shadowBar);
        addRecipe(new ItemStack(ItemRegistry.vileStorm, 8), "SSS", "SJS", "SSS", 'J', ItemRegistry.jungleShards, 'S', ItemRegistry.shuriken);
        addRecipe(new ItemStack(ItemRegistry.wildwoodArrow, 4), " I ", " S ", " Z ", 'I', ItemRegistry.wildwoodFragments, 'S', Items.STICK, 'Z', Items.FEATHER);
        addShapelessRecipe(BlockRegistry.aquatonicBricks, ItemRegistry.aquaBall, "minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:stone_bricks");
        addShapelessRecipe(BlockRegistry.bluefireLamp, Blocks.GLOWSTONE, ItemRegistry.bluefireStone);
        addShapelessRecipe(BlockRegistry.darkstoneBricks, "minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:stone_bricks", Items.INK_SAC);
        addShapelessRecipe(BlockRegistry.diamondBricks, "minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:stone_bricks", Items.DIAMOND);
        addShapelessRecipe(BlockRegistry.divineLamp, Blocks.GLOWSTONE, ItemRegistry.divineStone);
        addShapelessRecipe(BlockRegistry.divineRock, ItemRegistry.divineShards, "minecraft:base_stone_overworld");
        addShapelessRecipe(BlockRegistry.enderStoneLamp, Blocks.GLOWSTONE, ItemRegistry.enderStone);
        addShapelessRecipe(BlockRegistry.goldBricks, "minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:stone_bricks", Items.GOLD_INGOT);
        addShapelessRecipe(BlockRegistry.greenBricks, "minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:stone_bricks", new ItemStack(Items.GREEN_DYE, 1));
        addShapelessRecipe(BlockRegistry.iceLamp, Blocks.GLOWSTONE, ItemRegistry.iceStone);
        addShapelessRecipe(BlockRegistry.ironBricks, "minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:stone_bricks", Items.IRON_INGOT);
        addShapelessRecipe(BlockRegistry.jungleLamp, Blocks.GLOWSTONE, ItemRegistry.jungleStone);
        addShapelessRecipe(BlockRegistry.lapisLazuliBricks, "minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:stone_bricks", new ItemStack(Items.LAPIS_LAZULI, 1));
        addShapelessRecipe(BlockRegistry.lavaBricks, "minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:stone_bricks", Items.LAVA_BUCKET);
        addShapelessRecipe(BlockRegistry.milkStoneBricks, BlockRegistry.milkStone, BlockRegistry.milkStone, BlockRegistry.milkStone, BlockRegistry.milkStone);
        addShapelessRecipe(BlockRegistry.moltenLamp, Blocks.GLOWSTONE, ItemRegistry.moltenStone);
        addShapelessRecipe(BlockRegistry.pinkBricks, "minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:stone_bricks", new ItemStack(Items.PINK_DYE, 1));
        addShapelessRecipe(BlockRegistry.purpleBricks, "minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:stone_bricks", new ItemStack(Items.PURPLE_DYE, 1));
        addShapelessRecipe(BlockRegistry.realmiteBricks, ItemRegistry.realmiteIngot, ItemRegistry.realmiteIngot, ItemRegistry.realmiteIngot, ItemRegistry.realmiteIngot, ItemRegistry.realmiteIngot);
        addShapelessRecipe(BlockRegistry.redstoneBricks, "minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:stone_bricks", Items.REDSTONE);
        addShapelessRecipe(BlockRegistry.terranLamp, Blocks.GLOWSTONE, ItemRegistry.terranStone);
        addShapelessRecipe(BlockRegistry.torriditeBricks, ItemRegistry.torriditeIngot);
        addShapelessRecipe(ItemRegistry.advancedMushroomStew, ItemRegistry.whiteMushroom, Items.MUSHROOM_STEW);
        addShapelessRecipe(ItemRegistry.apalachiaDust, BlockRegistry.apalachiaTallgrass);
        addShapelessRecipe(ItemRegistry.apalachiaDust, BlockRegistry.duskFlower);
        addShapelessRecipe(ItemRegistry.apalachiaFragments, ItemRegistry.apalachiaSoul);
        addShapelessRecipe(ItemRegistry.aquaticBlazeRod, ItemRegistry.aquaBall, Items.BLAZE_ROD);
        addShapelessRecipe(ItemRegistry.arlemiteShickaxe, ItemRegistry.arlemitePickaxe, ItemRegistry.arlemiteShovel, ItemRegistry.arlemiteAxe, ItemRegistry.arlemiteHoe);
        addShapelessRecipe(ItemRegistry.baseSpawnCrystal, ItemRegistry.skythernSoul, ItemRegistry.skythernSoul, ItemRegistry.skythernSoul, ItemRegistry.skythernSoul, ItemRegistry.skythernSoul);
        addShapelessRecipe(ItemRegistry.blackEnderSword, ItemRegistry.enderSword, ItemRegistry.grayDiamondChunk);
        addShapelessRecipe(ItemRegistry.blueDiamondChunk, Items.DIAMOND, ItemRegistry.rupeeIngot);
        addShapelessRecipe(ItemRegistry.blueDivineSword, ItemRegistry.divineSword, ItemRegistry.blueDiamondChunk);
        addShapelessRecipe(ItemRegistry.blueEnderBoots, ItemRegistry.enderBoots, ItemRegistry.blueDiamondChunk);
        addShapelessRecipe(ItemRegistry.blueEnderChestplate, ItemRegistry.enderChestplate, ItemRegistry.blueDiamondChunk);
        addShapelessRecipe(ItemRegistry.blueEnderHelmet, ItemRegistry.enderHelmet, ItemRegistry.blueDiamondChunk);
        addShapelessRecipe(ItemRegistry.blueEnderLeggings, ItemRegistry.enderLeggings, ItemRegistry.blueDiamondChunk);
        addShapelessRecipe(ItemRegistry.blueEnderSword, ItemRegistry.enderSword, ItemRegistry.blueDiamondChunk);
        addShapelessRecipe(ItemRegistry.blueRupeeBoots, ItemRegistry.rupeeBoots, ItemRegistry.blueDiamondChunk);
        addShapelessRecipe(ItemRegistry.blueRupeeChestplate, ItemRegistry.rupeeChestplate, ItemRegistry.blueDiamondChunk);
        addShapelessRecipe(ItemRegistry.blueRupeeHelmet, ItemRegistry.rupeeHelmet, ItemRegistry.blueDiamondChunk);
        addShapelessRecipe(ItemRegistry.blueRupeeLeggings, ItemRegistry.rupeeLeggings, ItemRegistry.blueDiamondChunk);
        addShapelessRecipe(ItemRegistry.chickenDinner, ItemRegistry.advancedMushroomStew, Items.COOKED_CHICKEN, Items.BREAD);
        addShapelessRecipe(ItemRegistry.densosCrystal, ItemRegistry.baseSpawnCrystal, ItemRegistry.apalachiaSoul, ItemRegistry.mortumSoul, ItemRegistry.wildwoodSoul, ItemRegistry.skythernSoul);
        addShapelessRecipe(ItemRegistry.divineShickaxe, ItemRegistry.divinePickaxe, ItemRegistry.divineShovel, ItemRegistry.divineAxe);
        addShapelessRecipe(ItemRegistry.edenDust, BlockRegistry.edenBrush);
        addShapelessRecipe(ItemRegistry.edenDust, BlockRegistry.sunBlossom);
        addShapelessRecipe(ItemRegistry.edenDust, BlockRegistry.sunbloom);
        addShapelessRecipe(ItemRegistry.edenFragments, ItemRegistry.edenSoul);
        addShapelessRecipe(ItemRegistry.grayDiamondChunk, Items.DIAMOND, ItemRegistry.shadowBar);
        addShapelessRecipe(ItemRegistry.grayDivineSword, ItemRegistry.divineSword, ItemRegistry.grayDiamondChunk);
        addShapelessRecipe(ItemRegistry.grayEnderBoots, ItemRegistry.enderBoots, ItemRegistry.grayDiamondChunk);
        addShapelessRecipe(ItemRegistry.grayEnderChestplate, ItemRegistry.enderChestplate, ItemRegistry.grayDiamondChunk);
        addShapelessRecipe(ItemRegistry.grayEnderHelmet, ItemRegistry.enderHelmet, ItemRegistry.grayDiamondChunk);
        addShapelessRecipe(ItemRegistry.grayEnderLeggings, ItemRegistry.enderLeggings, ItemRegistry.grayDiamondChunk);
        addShapelessRecipe(ItemRegistry.grayRupeeBoots, ItemRegistry.rupeeBoots, ItemRegistry.grayDiamondChunk);
        addShapelessRecipe(ItemRegistry.grayRupeeChestplate, ItemRegistry.rupeeChestplate, ItemRegistry.grayDiamondChunk);
        addShapelessRecipe(ItemRegistry.grayRupeeHelmet, ItemRegistry.rupeeHelmet, ItemRegistry.grayDiamondChunk);
        addShapelessRecipe(ItemRegistry.grayRupeeLeggings, ItemRegistry.rupeeLeggings, ItemRegistry.grayDiamondChunk);
        addShapelessRecipe(ItemRegistry.greenDiamondChunk, Items.DIAMOND, ItemRegistry.arlemiteIngot);
        addShapelessRecipe(ItemRegistry.greenDivineSword, ItemRegistry.divineSword, ItemRegistry.greenDiamondChunk);
        addShapelessRecipe(ItemRegistry.greenEnderBoots, ItemRegistry.enderBoots, ItemRegistry.greenDiamondChunk);
        addShapelessRecipe(ItemRegistry.greenEnderChestplate, ItemRegistry.enderChestplate, ItemRegistry.greenDiamondChunk);
        addShapelessRecipe(ItemRegistry.greenEnderHelmet, ItemRegistry.enderHelmet, ItemRegistry.greenDiamondChunk);
        addShapelessRecipe(ItemRegistry.greenEnderLeggings, ItemRegistry.enderLeggings, ItemRegistry.greenDiamondChunk);
        addShapelessRecipe(ItemRegistry.greenEnderSword, ItemRegistry.enderSword, ItemRegistry.greenDiamondChunk);
        addShapelessRecipe(ItemRegistry.greenRupeeBoots, ItemRegistry.rupeeBoots, ItemRegistry.greenDiamondChunk);
        addShapelessRecipe(ItemRegistry.greenRupeeChestplate, ItemRegistry.rupeeChestplate, ItemRegistry.greenDiamondChunk);
        addShapelessRecipe(ItemRegistry.greenRupeeHelmet, ItemRegistry.rupeeHelmet, ItemRegistry.greenDiamondChunk);
        addShapelessRecipe(ItemRegistry.greenRupeeLeggings, ItemRegistry.rupeeLeggings, ItemRegistry.greenDiamondChunk);
        addShapelessRecipe(ItemRegistry.hellstoneIngot, ItemRegistry.shadowBar, ItemRegistry.torriditeChunk);
        addShapelessRecipe(ItemRegistry.karotCrystal, ItemRegistry.baseSpawnCrystal, ItemRegistry.apalachiaSoul, ItemRegistry.mortumSoul, ItemRegistry.mortumSoul, ItemRegistry.skythernSoul);
        addShapelessRecipe(ItemRegistry.krakenSkin, ItemRegistry.krakenScale, ItemRegistry.krakenScale);
        addShapelessRecipe(ItemRegistry.mortumDust, BlockRegistry.demonBrambles);
        addShapelessRecipe(ItemRegistry.mortumDust, BlockRegistry.eyePlant);
        addShapelessRecipe(ItemRegistry.mortumDust, BlockRegistry.mortumBrush);
        addShapelessRecipe(ItemRegistry.mortumFragments, ItemRegistry.mortumSoul);
        addShapelessRecipe(ItemRegistry.redDiamondChunk, Items.DIAMOND, ItemRegistry.torriditeChunk);
        addShapelessRecipe(ItemRegistry.redDivineSword, ItemRegistry.divineSword, ItemRegistry.redDiamondChunk);
        addShapelessRecipe(ItemRegistry.redEnderBoots, ItemRegistry.enderBoots, ItemRegistry.redDiamondChunk);
        addShapelessRecipe(ItemRegistry.redEnderChestplate, ItemRegistry.enderChestplate, ItemRegistry.redDiamondChunk);
        addShapelessRecipe(ItemRegistry.redEnderHelmet, ItemRegistry.enderHelmet, ItemRegistry.redDiamondChunk);
        addShapelessRecipe(ItemRegistry.redEnderLeggings, ItemRegistry.enderLeggings, ItemRegistry.redDiamondChunk);
        addShapelessRecipe(ItemRegistry.redEnderSword, ItemRegistry.enderSword, ItemRegistry.redDiamondChunk);
        addShapelessRecipe(ItemRegistry.redRupeeBoots, ItemRegistry.rupeeBoots, ItemRegistry.redDiamondChunk);
        addShapelessRecipe(ItemRegistry.redRupeeChestplate, ItemRegistry.rupeeChestplate, ItemRegistry.redDiamondChunk);
        addShapelessRecipe(ItemRegistry.redRupeeHelmet, ItemRegistry.rupeeHelmet, ItemRegistry.redDiamondChunk);
        addShapelessRecipe(ItemRegistry.redRupeeLeggings, ItemRegistry.rupeeLeggings, ItemRegistry.redDiamondChunk);
        addShapelessRecipe(ItemRegistry.reyvorCrystal, ItemRegistry.baseSpawnCrystal, ItemRegistry.mortumSoul, ItemRegistry.mortumSoul, ItemRegistry.edenSoul, ItemRegistry.wildwoodSoul);
        addShapelessRecipe(ItemRegistry.rupeeShickaxe, ItemRegistry.rupeePickaxe, ItemRegistry.rupeeShovel, ItemRegistry.rupeeAxe, ItemRegistry.rupeeHoe);
        addShapelessRecipe(ItemRegistry.shadowBar, ItemRegistry.rupeeIngot, ItemRegistry.arlemiteIngot);
        addShapelessRecipe(ItemRegistry.skythernDust, BlockRegistry.dustBrambles);
        addShapelessRecipe(ItemRegistry.skythernDust, BlockRegistry.dustLily);
        addShapelessRecipe(ItemRegistry.skythernDust, BlockRegistry.skythernBrush);
        addShapelessRecipe(ItemRegistry.skythernFragments, ItemRegistry.skythernSoul);
        addShapelessRecipe(ItemRegistry.soulFiendCrystal, ItemRegistry.baseSpawnCrystal, ItemRegistry.apalachiaSoul, ItemRegistry.skythernSoul, ItemRegistry.wildwoodSoul, ItemRegistry.edenSoul);
        addShapelessRecipe(ItemRegistry.twilightDemonCrystal, ItemRegistry.baseSpawnCrystal, ItemRegistry.mortumSoul, ItemRegistry.mortumSoul, ItemRegistry.wildwoodSoul, ItemRegistry.skythernSoul);
        addShapelessRecipe(ItemRegistry.vamacheronCrystal, ItemRegistry.baseSpawnCrystal, ItemRegistry.mortumSoul, ItemRegistry.mortumSoul, ItemRegistry.mortumSoul, ItemRegistry.mortumSoul);
        addShapelessRecipe(ItemRegistry.wildwoodDust, BlockRegistry.moonBud);
        addShapelessRecipe(ItemRegistry.wildwoodDust, BlockRegistry.moonlightFern);
        addShapelessRecipe(ItemRegistry.wildwoodDust, BlockRegistry.wildwoodTallgrass);
        addShapelessRecipe(ItemRegistry.wildwoodFragments, ItemRegistry.wildwoodSoul);
        addShapelessRecipe(ItemRegistry.yellowDiamondChunk, Items.DIAMOND, ItemRegistry.realmiteIngot);
        addShapelessRecipe(ItemRegistry.yellowDivineSword, ItemRegistry.divineSword, ItemRegistry.yellowDiamondChunk);
        addShapelessRecipe(ItemRegistry.yellowEnderBoots, ItemRegistry.enderBoots, ItemRegistry.yellowDiamondChunk);
        addShapelessRecipe(ItemRegistry.yellowEnderChestplate, ItemRegistry.enderChestplate, ItemRegistry.yellowDiamondChunk);
        addShapelessRecipe(ItemRegistry.yellowEnderHelmet, ItemRegistry.enderHelmet, ItemRegistry.yellowDiamondChunk);
        addShapelessRecipe(ItemRegistry.yellowEnderLeggings, ItemRegistry.enderLeggings, ItemRegistry.yellowDiamondChunk);
        addShapelessRecipe(ItemRegistry.yellowEnderSword, ItemRegistry.enderSword, ItemRegistry.yellowDiamondChunk);
        addShapelessRecipe(ItemRegistry.yellowRupeeBoots, ItemRegistry.rupeeBoots, ItemRegistry.yellowDiamondChunk);
        addShapelessRecipe(ItemRegistry.yellowRupeeChestplate, ItemRegistry.rupeeChestplate, ItemRegistry.yellowDiamondChunk);
        addShapelessRecipe(ItemRegistry.yellowRupeeHelmet, ItemRegistry.rupeeHelmet, ItemRegistry.yellowDiamondChunk);
        addShapelessRecipe(ItemRegistry.yellowRupeeLeggings, ItemRegistry.rupeeLeggings, ItemRegistry.yellowDiamondChunk);
        addShapelessRecipe(new ItemStack(BlockRegistry.darkstone, 10), Blocks.OBSIDIAN, Blocks.GLOWSTONE);
        addShapelessRecipe(new ItemStack(BlockRegistry.milkStone, 4), "minecraft:base_stone_overworld", "minecraft:base_stone_overworld", "minecraft:base_stone_overworld", Items.MILK_BUCKET);
        addShapelessRecipe(new ItemStack(BlockRegistry.rainbowWool, 4), new ItemStack(Blocks.ORANGE_WOOL, 1), new ItemStack(Blocks.RED_WOOL, 1), new ItemStack(Blocks.YELLOW_WOOL, 1), new ItemStack(Blocks.LIME_WOOL, 1), new ItemStack(Blocks.CYAN_WOOL, 1), new ItemStack(Blocks.BLUE_WOOL, 1), new ItemStack(Blocks.PURPLE_WOOL, 1));
        addShapelessRecipe(new ItemStack(ItemRegistry.apalachiaSlicer, 20), ItemRegistry.apalachiaGem);
        addShapelessRecipe(new ItemStack(ItemRegistry.arlemiteIngot, 9), BlockRegistry.arlemiteBlock);
        addShapelessRecipe(new ItemStack(ItemRegistry.bacon, 6), Items.PORKCHOP);
        addShapelessRecipe(new ItemStack(ItemRegistry.bloodgem, 9), BlockRegistry.bloodgemBlock);
        addShapelessRecipe(new ItemStack(ItemRegistry.corruptedBullet, 16), ItemRegistry.corruptedShards);
        addShapelessRecipe(new ItemStack(ItemRegistry.cyclopsEyeShards, 9), ItemRegistry.cyclopsEye);
        addShapelessRecipe(new ItemStack(ItemRegistry.edenSlicer, 20), ItemRegistry.edenGem);
        addShapelessRecipe(new ItemStack(ItemRegistry.mortumSlicer, 20), ItemRegistry.mortumGem);
        addShapelessRecipe(new ItemStack(ItemRegistry.realmiteIngot, 9), BlockRegistry.realmiteBlock);
        addShapelessRecipe(new ItemStack(ItemRegistry.rupeeIngot, 9), BlockRegistry.rupeeBlock);
        addShapelessRecipe(new ItemStack(ItemRegistry.shadowCoins, 6), ItemRegistry.shadowStone);
        addShapelessRecipe(new ItemStack(ItemRegistry.skythernSlicer, 20), ItemRegistry.skythernGem);
        addShapelessRecipe(new ItemStack(ItemRegistry.tomatoSeeds, 4), ItemRegistry.tomato);
        addShapelessRecipe(new ItemStack(ItemRegistry.torriditeIngot, 9), BlockRegistry.torriditeBlock);
        addShapelessRecipe(new ItemStack(ItemRegistry.whiteMushroomSeeds, 4), ItemRegistry.whiteMushroom);
        addShapelessRecipe(new ItemStack(ItemRegistry.wildwoodSlicer, 20), ItemRegistry.wildwoodGem);
        addSmelting(BlockRegistry.apalachiaOre, ItemRegistry.apalachiaFragments, 1.3F);
        addSmelting(BlockRegistry.arlemiteOre, ItemRegistry.arlemiteIngot, 1.0F);
        addSmelting(BlockRegistry.bloodgemOre, ItemRegistry.bloodgem, 1.2F);
        addSmelting(BlockRegistry.edenOre, ItemRegistry.edenFragments, 0.7F);
        addSmelting(BlockRegistry.mortumOre, ItemRegistry.mortumFragments, 2.0F);
        addSmelting(BlockRegistry.realmiteOre, ItemRegistry.realmiteIngot, 0.7F);
        addSmelting(BlockRegistry.rupeeOre, ItemRegistry.rupeeIngot, 1.0F);
        addSmelting(BlockRegistry.skythernOre, ItemRegistry.skythernFragments, 1.7F);
        addSmelting(BlockRegistry.torriditeOre, ItemRegistry.torriditeIngot, 1.1F);
        addSmelting(BlockRegistry.wildwoodOre, ItemRegistry.wildwoodFragments, 1.0F);
        addSmelting(ItemRegistry.edenFragments, ItemRegistry.edenSparkles, 1);
        addSmelting(ItemRegistry.pureAquaticPellets, ItemRegistry.aquaticIngot, 0.6F);
        addSmelting(ItemRegistry.rawEmpoweredMeat, ItemRegistry.empoweredMeat, 1);
        addSmelting(new ItemStack(BlockRegistry.apalachiaOre), new ItemStack(ItemRegistry.apalachiaFragments), 1.3F);
        addSmelting(new ItemStack(BlockRegistry.arlemiteOre), new ItemStack(ItemRegistry.arlemiteIngot), 1.0F);
        addSmelting(new ItemStack(BlockRegistry.bloodgemOre), new ItemStack(ItemRegistry.bloodgem), 1.2F);
        addSmelting(new ItemStack(BlockRegistry.edenOre), new ItemStack(ItemRegistry.edenFragments), 0.7F);
        addSmelting(new ItemStack(BlockRegistry.mortumOre), new ItemStack(ItemRegistry.mortumFragments), 2.0F);
        addSmelting(new ItemStack(BlockRegistry.realmiteOre), new ItemStack(ItemRegistry.realmiteIngot), 0.7F);
        addSmelting(new ItemStack(BlockRegistry.rupeeOre), new ItemStack(ItemRegistry.rupeeIngot), 1.0F);
        addSmelting(new ItemStack(BlockRegistry.skythernOre), new ItemStack(ItemRegistry.skythernFragments), 1.7F);
        addSmelting(new ItemStack(BlockRegistry.torriditeOre), new ItemStack(ItemRegistry.torriditeIngot), 1.1F);
        addSmelting(new ItemStack(BlockRegistry.wildwoodOre), new ItemStack(ItemRegistry.wildwoodFragments), 1.0F);
        addSmelting(new ItemStack(ItemRegistry.edenFragments), new ItemStack(ItemRegistry.edenSparkles), 1);
        addSmelting(new ItemStack(ItemRegistry.pureAquaticPellets), new ItemStack(ItemRegistry.aquaticIngot), 0.6F);
        addSmelting(new ItemStack(ItemRegistry.rawEmpoweredMeat), new ItemStack(ItemRegistry.empoweredMeat), 1);
        addSmelting(new ItemStack(Items.EGG), new ItemStack(ItemRegistry.boiledEgg), 0.3F);
        addSmelting(new ItemStack(Items.PUMPKIN_PIE), new ItemStack(ItemRegistry.hotPumpkinPie), 0.3F);

    }

}