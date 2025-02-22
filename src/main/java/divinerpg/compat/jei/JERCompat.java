package divinerpg.compat.jei;

import divinerpg.registries.*;
import jeresources.api.*;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.drop.*;
import jeresources.api.restrictions.*;
import jeresources.compatibility.api.JERAPI;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class JERCompat {
    public static void init() {
        IJERAPI jerApi = JERAPI.getInstance();
        IDungeonRegistry dungeonRegistry = jerApi.getDungeonRegistry();
        if(dungeonRegistry != null) {
            //Overworld
            dungeonRegistry.registerChest(getDungeon("diamond_dave_geode"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.AMETHYST_GEODE));
            dungeonRegistry.registerChest(getDungeon("ancient_tomb"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.ANCIENT_TOMB));
            dungeonRegistry.registerChest(getDungeon("livestock_merchant_hut"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.LIVESTOCK_MERCHANT_HUT));
            //Iceika
            dungeonRegistry.registerChest(getDungeon("iceika_dungeon"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.ICEIKA_DUNGEON));
            dungeonRegistry.registerChest(getDungeon("iceika_hut"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.ICEIKA_HUT));
            dungeonRegistry.registerChest(getDungeon("groglin_village"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.GROGLIN_VILLAGE));
            dungeonRegistry.registerChest(getDungeon("gruzzorlug_village"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.GRUZZORLUG_VILLAGE));
            //Arcana
            dungeonRegistry.registerChest(getDungeon("banquet_hall"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.BANQUET_HALL));
            dungeonRegistry.registerChest(getDungeon("utility_hallway"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.UTILITY_HALLWAY));
            //Twilight
            dungeonRegistry.registerChest(getDungeon("eden_hut"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.EDEN_HUT));
            dungeonRegistry.registerChest(getDungeon("skythern_hut"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.SKYTHERN_HUT));
            dungeonRegistry.registerChest(getDungeon("wildwood_hut"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.WILDWOOD_HUT));
            //Vethea
            dungeonRegistry.registerChest(getDungeon("crypt"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.CRYPT));
            dungeonRegistry.registerChest(getDungeon("karos_madhouse"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.KAROS_MADHOUSE));
            dungeonRegistry.registerChest(getDungeon("quadrotic_post"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.QUADROTIC_POST));
            dungeonRegistry.registerChest(getDungeon("raglok_chamber"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.RAGLOK_CHAMBER));
            dungeonRegistry.registerChest(getDungeon("temple_bottom"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.TEMPLE_BOTTOM));
            dungeonRegistry.registerChest(getDungeon("temple_middle"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.TEMPLE_MIDDLE));
            dungeonRegistry.registerChest(getDungeon("temple_top"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.TEMPLE_TOP));
            dungeonRegistry.registerChest(getDungeon("wreck_hall"), ResourceKey.create(Registries.LOOT_TABLE, LootTableRegistry.WRECK_HALL));
        } IWorldGenRegistry worldGenRegistry = jerApi.getWorldGenRegistry();
        if(worldGenRegistry != null) {
            //Overworld
            worldGenRegistry.register(new ItemStack(BlockRegistry.realmiteOre.get()), new ItemStack(BlockRegistry.realmiteOreDeepslate.get()), new DistributionSquare(30, 8, 28, 52), new LootDrop(new ItemStack(ItemRegistry.raw_realmite.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.arlemiteOre.get()), new ItemStack(BlockRegistry.arlemiteOreDeepslate.get()), new DistributionSquare(2, 8, 5, 70), new LootDrop(new ItemStack(ItemRegistry.raw_arlemite.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.rupeeOre.get()), new ItemStack(BlockRegistry.rupeeOreDeepslate.get()), new DistributionSquare(3, 8, -64, 64), new LootDrop(new ItemStack(ItemRegistry.raw_rupee.get()), 1, 4, Conditional.affectedByFortune));
            //Nether
            worldGenRegistry.register(new ItemStack(BlockRegistry.torriditeOre.get()), new DistributionSquare(5, 4, 8, 120), new Restriction(new DimensionRestriction(Level.NETHER)), new LootDrop(new ItemStack(ItemRegistry.raw_torridite.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.bloodgemOre.get()), new DistributionSquare(5, 4, 8, 120), new Restriction(new DimensionRestriction(Level.NETHER)), new LootDrop(new ItemStack(ItemRegistry.bloodgem.get()), 1, 4, Conditional.affectedByFortune));
            //Iceika
            worldGenRegistry.register(new ItemStack(BlockRegistry.anthraciteOre.get()), new DistributionSquare(16, 12, 45, 318), new Restriction(new DimensionRestriction(LevelRegistry.ICEIKA)), new LootDrop(new ItemStack(ItemRegistry.anthracite.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.oxdriteOre.get()), new DistributionSquare(8, 8, 64, 128), new Restriction(new DimensionRestriction(LevelRegistry.ICEIKA)), new LootDrop(new ItemStack(ItemRegistry.raw_oxdrite.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.oxdriteOre.get()), new DistributionSquare(16, 8, -64, 64), new Restriction(new DimensionRestriction(LevelRegistry.ICEIKA)), new LootDrop(new ItemStack(ItemRegistry.raw_oxdrite.get()), 1, 4, Conditional.affectedByFortune));
            //Twilight
            worldGenRegistry.register(new ItemStack(BlockRegistry.edenOre.get()), new DistributionSquare(6, 5, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.EDEN)), new LootDrop(new ItemStack(ItemRegistry.eden_fragments.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.wildwoodOre.get()), new DistributionSquare(6, 8, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.WILDWOOD)), new LootDrop(new ItemStack(ItemRegistry.wildwood_fragments.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.apalachiaOre.get()), new DistributionSquare(12, 12, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.APALACHIA)), new LootDrop(new ItemStack(ItemRegistry.apalachia_fragments.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.skythernOre.get()), new DistributionSquare(7, 6, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.SKYTHERN)), new LootDrop(new ItemStack(ItemRegistry.skythern_fragments.get()), 1, 4, Conditional.affectedByFortune));
            worldGenRegistry.register(new ItemStack(BlockRegistry.mortumOre.get()), new DistributionSquare(5, 5, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.MORTUM)), new LootDrop(new ItemStack(ItemRegistry.mortum_fragments.get()), 1, 4, Conditional.affectedByFortune));
        } IPlantRegistry plantRegistry = jerApi.getPlantRegistry();
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
    public static String getDungeon(String name){return dungeonName(name).getString();}
    public static Component dungeonName(String text, Object... args) {
        if(args == null) {args = new Object[0];}
        MutableComponent result = MutableComponent.create(new TranslatableContents(String.format("dungeon.divinerpg.%s", text), null, args));
        return result.withStyle(ChatFormatting.GRAY);
    }
}