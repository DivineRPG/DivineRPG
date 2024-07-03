package divinerpg.compat.jei;

import divinerpg.DivineRPG;
import divinerpg.registries.*;
import jeresources.api.*;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.drop.*;
import jeresources.api.restrictions.*;
import jeresources.compatibility.api.JERAPI;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class JERCompat {
    public static void init() {
        IJERAPI jerApi = JERAPI.getInstance();
        IDungeonRegistry dungeonRegistry = jerApi.getDungeonRegistry();
        if(dungeonRegistry != null) {
            //TODO: to add lang keys for translation
            //Overworld
            dungeonRegistry.registerChest("Diamond Dave's Chest", new ResourceLocation(DivineRPG.MODID, "chests/overworld/amethyst"));
            dungeonRegistry.registerChest("Ancient Tomb Chest", new ResourceLocation(DivineRPG.MODID, "chests/overworld/ancient_tomb"));
            dungeonRegistry.registerChest("Merchant's Hut Chest", new ResourceLocation(DivineRPG.MODID, "chests/overworld/livestock_chest"));
            //Iceika
            dungeonRegistry.registerChest("Iceika Chest", new ResourceLocation(DivineRPG.MODID, "chests/iceika/iceika_chest_dungeon"));
            dungeonRegistry.registerChest("Iceika Hut Chest", new ResourceLocation(DivineRPG.MODID, "chests/iceika/iceika_chest_hut"));
            dungeonRegistry.registerChest("Groglin Chest", new ResourceLocation(DivineRPG.MODID, "chests/iceika/groglin_chest"));
            dungeonRegistry.registerChest("Gruzzorlug Chest", new ResourceLocation(DivineRPG.MODID, "chests/iceika/gruzzorlug_chest"));
            //Arcana
            dungeonRegistry.registerChest("Banquet Hall Chest", new ResourceLocation(DivineRPG.MODID, "chests/arcana/banquet_hall_loot"));
            dungeonRegistry.registerChest("Utility Hallway Chest", new ResourceLocation(DivineRPG.MODID, "chests/arcana/utility_hallway_loot"));
            //Twilight
            dungeonRegistry.registerChest("Eden Hut Chest", new ResourceLocation(DivineRPG.MODID, "chests/twilight/eden/hut_chest"));
            dungeonRegistry.registerChest("Skythern Chest", new ResourceLocation(DivineRPG.MODID, "chests/twilight/skythern/chest"));
            dungeonRegistry.registerChest("Wildwood Chest", new ResourceLocation(DivineRPG.MODID, "chests/twilight/wildwood/chest"));
            //Vethea
            dungeonRegistry.registerChest("Crypt Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/crypt_loot"));
            dungeonRegistry.registerChest("Karos Madhouse Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/karos_madhouse_loot"));
            dungeonRegistry.registerChest("Quadrotic Post Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/quadrotic_post_loot"));
            dungeonRegistry.registerChest("Raglok Chamber Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/raglok_chamber_loot"));
            dungeonRegistry.registerChest("Temple Bottom Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/temple_loot_bottom"));
            dungeonRegistry.registerChest("Temple Middle Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/temple_loot_middle"));
            dungeonRegistry.registerChest("Temple Top Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/temple_loot_top"));
            dungeonRegistry.registerChest("Wreck Hall Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/wreck_hall_loot"));
        }
        IWorldGenRegistry worldGenRegistry = jerApi.getWorldGenRegistry();
        if(worldGenRegistry != null) {
            //Overworld
            worldGenRegistry.register(new ItemStack(BlockRegistry.realmiteOre.get()), new ItemStack(BlockRegistry.realmiteOreDeepslate.get()), new DistributionSquare(30, 8, 28, 52), new LootDrop(new ItemStack(ItemRegistry.raw_realmite.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.arlemiteOre.get()), new ItemStack(BlockRegistry.arlemiteOreDeepslate.get()), new DistributionSquare(2, 8, 5, 70), new LootDrop(new ItemStack(ItemRegistry.raw_arlemite.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.rupeeOre.get()), new ItemStack(BlockRegistry.rupeeOreDeepslate.get()), new DistributionSquare(3, 8, -64, 64), new LootDrop(new ItemStack(ItemRegistry.raw_rupee.get()), 1, 4, Conditional.affectedByFortune));
            //Nether
            worldGenRegistry.register(new ItemStack(BlockRegistry.torriditeOre.get()), new DistributionSquare(5, 4, 8, 120), new Restriction(new DimensionRestriction(Level.NETHER)), new LootDrop(new ItemStack(ItemRegistry.raw_torridite.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.bloodgemOre.get()), new DistributionSquare(5, 4, 8, 120), new Restriction(new DimensionRestriction(Level.NETHER)), new LootDrop(new ItemStack(ItemRegistry.bloodgem.get()), 1, 4, Conditional.affectedByFortune));
            //Iceika
            worldGenRegistry.register(new ItemStack(BlockRegistry.anthraciteOre.get()), new DistributionSquare(12, 12, 45, 318), new Restriction(new DimensionRestriction(LevelRegistry.ICEIKA)), new LootDrop(new ItemStack(ItemRegistry.anthracite.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.oxdriteOre.get()), new DistributionSquare(2, 8, 64, 128), new Restriction(new DimensionRestriction(LevelRegistry.ICEIKA)), new LootDrop(new ItemStack(ItemRegistry.raw_oxdrite.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.oxdriteOre.get()), new DistributionSquare(8, 8, -64, 64), new Restriction(new DimensionRestriction(LevelRegistry.ICEIKA)), new LootDrop(new ItemStack(ItemRegistry.raw_oxdrite.get()), 1, 4, Conditional.affectedByFortune));
            //Twilight
            worldGenRegistry.register(new ItemStack(BlockRegistry.edenOre.get()), new DistributionSquare(6, 5, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.EDEN)), new LootDrop(new ItemStack(ItemRegistry.eden_fragments.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.wildwoodOre.get()), new DistributionSquare(6, 8, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.WILDWOOD)), new LootDrop(new ItemStack(ItemRegistry.wildwood_fragments.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.apalachiaOre.get()), new DistributionSquare(12, 12, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.APALACHIA)), new LootDrop(new ItemStack(ItemRegistry.apalachia_fragments.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.skythernOre.get()), new DistributionSquare(7, 6, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.SKYTHERN)), new LootDrop(new ItemStack(ItemRegistry.skythern_fragments.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.mortumOre.get()), new DistributionSquare(5, 5, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.MORTUM)), new LootDrop(new ItemStack(ItemRegistry.mortum_fragments.get()), 1, 4, Conditional.affectedByFortune));
        }
        IPlantRegistry plantRegistry = jerApi.getPlantRegistry();
        if(plantRegistry != null) {
            //Overworld
            plantRegistry.register(new ItemStack(ItemRegistry.tomato_seeds.get()), BlockRegistry.tomatoPlant.get().defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.tomato.get()), 2, 5));
            plantRegistry.register(new ItemStack(ItemRegistry.white_mushroom_seeds.get()), BlockRegistry.whiteMushroomPlant.get().defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.white_mushroom.get()), 2, 5));
            //Iceika
            plantRegistry.registerWithSoil(new ItemStack(ItemRegistry.winterberry.get()), BlockRegistry.winterberryBush.get().defaultBlockState(), BlockRegistry.brittleMoss.get().defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.winterberry.get()), 1, 1));
            //Arcana
            plantRegistry.register(new ItemStack(ItemRegistry.aquamarine_seeds.get()), BlockRegistry.aquamarinePlant.get().defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.aquamarine.get()), 1, 1), new PlantDrop(new ItemStack(ItemRegistry.aquamarine_seeds.get()), 1, 4));
            plantRegistry.register(new ItemStack(ItemRegistry.eucalyptus_root_seeds.get()), BlockRegistry.eucalyptusPlant.get().defaultBlockState(), new PlantDrop(new ItemStack(BlockRegistry.eucalyptusLog.get()), 1, 1), new PlantDrop(new ItemStack(ItemRegistry.eucalyptus_root_seeds.get()), 1, 4));
            plantRegistry.register(new ItemStack(ItemRegistry.hitchak_seeds.get()), BlockRegistry.hitchakPlant.get().defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.hitchak.get()), 2, 5));
            plantRegistry.register(new ItemStack(ItemRegistry.lamona_seeds.get()), BlockRegistry.lamonaPlant.get().defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.lamona.get()), 2, 5));
            plantRegistry.register(new ItemStack(ItemRegistry.marsine_seeds.get()), BlockRegistry.marsinePlant.get().defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.marsine.get()), 2, 5));
            plantRegistry.register(new ItemStack(ItemRegistry.veilo_seeds.get()), BlockRegistry.veiloPlant.get().defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.veilo.get()), 2, 5));
            plantRegistry.registerWithSoil(new ItemStack(ItemRegistry.firestock_seeds.get()), BlockRegistry.firestockPlant.get().defaultBlockState(), BlockRegistry.arcaniteGrass.get().defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.firestock.get()), 2, 5));
            plantRegistry.registerWithSoil(new ItemStack(ItemRegistry.pinfly_seeds.get()), BlockRegistry.pinflyPlant.get().defaultBlockState(), BlockRegistry.arcaniteGrass.get().defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.pinfly.get()), 2, 5));
            //Twilight
            plantRegistry.registerWithSoil(new ItemStack(ItemRegistry.moonbulb_seeds.get()), BlockRegistry.moonbulbPlant.get().defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.moonbulb.get()), 2, 5));
            plantRegistry.registerWithSoil(new ItemStack(ItemRegistry.purple_glowbone_seeds.get()), BlockRegistry.purpleGlowbonePlant.get().defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.purple_glowbone.get()), 2, 5));
            plantRegistry.registerWithSoil(new ItemStack(ItemRegistry.pink_glowbone_seeds.get()), BlockRegistry.pinkGlowbonePlant.get().defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.pink_glowbone.get()), 2, 5));
            plantRegistry.register(new ItemStack(ItemRegistry.sky_plant_seeds.get()), BlockRegistry.skyPlant.get().defaultBlockState(), new PlantDrop(new ItemStack(ItemRegistry.sky_flower.get()), 1, 1), new PlantDrop(new ItemStack(ItemRegistry.sky_plant_seeds.get()), 1, 4));
        }
    }
}