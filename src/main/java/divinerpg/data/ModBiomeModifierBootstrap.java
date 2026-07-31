package divinerpg.data;

import divinerpg.registries.EntityRegistry;
import divinerpg.registries.FeatureRegistry;
import divinerpg.registries.TagRegistry;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static divinerpg.DivineRPG.MODID;

public class ModBiomeModifierBootstrap {

    public static void bootstrap(BootstrapContext<BiomeModifier> ctx) {

        var biomes = ctx.lookup(Registries.BIOME);
        var placed = ctx.lookup(Registries.PLACED_FEATURE);
        var entities = ctx.lookup(Registries.ENTITY_TYPE);

        ResourceKey<BiomeModifier> OVERWORLD_ORES = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "overworld_ores"));
        ResourceKey<BiomeModifier> NETHER_ORES = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "nether_ores"));
        ResourceKey<BiomeModifier> DIVINE_TREE = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "divine_trees"));
        ResourceKey<BiomeModifier> GIANT_DIVINE_TREES = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "giant_divine_trees"));
        ResourceKey<BiomeModifier> END_SPAWNS = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "end_spawns"));
        ResourceKey<BiomeModifier> BASALT_DELTAS = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "basalt_delta_spawns"));
        ResourceKey<BiomeModifier> CRIMSON_FOREST = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "crimson_forest_spawns"));
        ResourceKey<BiomeModifier> REMOVE_CREATURE_SPAWNS = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "remove_creature_spawns"));
        ResourceKey<BiomeModifier> DRIPSTONE_CAVES = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "dripstone_caves_spawns"));
        ResourceKey<BiomeModifier> NETHER_WASTES = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "nether_wastes_spawns"));
        ResourceKey<BiomeModifier> SOUL_SAND_SPAWN_COSTS = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "soul_sand_valley_spawn_costs"));
        ResourceKey<BiomeModifier> SOUL_SAND_VALLEY = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "soul_sand_valley_spawns"));
        ResourceKey<BiomeModifier> BEACH = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "beach_spawns"));
        ResourceKey<BiomeModifier> CAVE = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "cave_spawns"));
        ResourceKey<BiomeModifier> DEEP_OCEAN = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "deep_ocean_spawns"));
        ResourceKey<BiomeModifier> DENSE_VEGETATION_NETHER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "dense_vegetation_nether_spawns"));
        ResourceKey<BiomeModifier> DESERT = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "desert_spawns"));
        ResourceKey<BiomeModifier> TAR_LAKES = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "tar_lakes"));
        ResourceKey<BiomeModifier> FOREST = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "forest_spawns"));
        ResourceKey<BiomeModifier> JUNGLE = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "jungle_spawns"));
        ResourceKey<BiomeModifier> LUSH_CAVES = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "lush_caves_spawns"));
        ResourceKey<BiomeModifier> MINESHAFT = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "mineshaft_spawns"));
        ResourceKey<BiomeModifier> OCEAN = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "ocean_spawns"));
        ResourceKey<BiomeModifier> OVERWORLD = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "overworld_spawns"));
        ResourceKey<BiomeModifier> RIVER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "river_spawns"));
        ResourceKey<BiomeModifier> SNOWY = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "snowy_spawns"));
        ResourceKey<BiomeModifier> SPARSE_VEGETATION_NETHER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "sparse_vegetation_nether_spawns"));
        ResourceKey<BiomeModifier> SPOOKY = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "spooky_spawns"));
        ResourceKey<BiomeModifier> STRONGHOLD_BIASED = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "stronghold_biased_spawns"));
        ResourceKey<BiomeModifier> SWAMP = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "swamp_spawns"));
        ResourceKey<BiomeModifier> WARM_OCEANS = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "warm_oceans_spawns"));
        ResourceKey<BiomeModifier> WARPED_FOREST = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "warped_forest_spawns"));

        ctx.register(OVERWORLD_ORES, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placed.getOrThrow(FeatureRegistry.ARLEMITE_PLACED), placed.getOrThrow(FeatureRegistry.REALMITE_PLACED), placed.getOrThrow(FeatureRegistry.REALMITE_VEIN_LARGE_PLACED), placed.getOrThrow(FeatureRegistry.REALMITE_VEIN_SMALL_PLACED), placed.getOrThrow(FeatureRegistry.RUPEE_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES));
        ctx.register(NETHER_ORES, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER), HolderSet.direct(placed.getOrThrow(FeatureRegistry.TORRIDITE_PLACED), placed.getOrThrow(FeatureRegistry.BLOODGEM_ORE_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES));
        ctx.register(DIVINE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placed.getOrThrow(FeatureRegistry.DIVINE_TREE_PLACED)), GenerationStep.Decoration.VEGETAL_DECORATION));
        ctx.register(GIANT_DIVINE_TREES, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST), HolderSet.direct(placed.getOrThrow(FeatureRegistry.GIANT_DIVINE_TREE_PLACED)), GenerationStep.Decoration.VEGETAL_DECORATION));
        ctx.register(END_SPAWNS, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.ENDER_SPIDER.get(), 1, 4), 9).add(new MobSpawnSettings.SpawnerData(EntityRegistry.ENDER_TRIPLETS.get(), 1, 4), 8).add(new MobSpawnSettings.SpawnerData(EntityRegistry.ENDER_WATCHER.get(), 1, 4), 10).add(new MobSpawnSettings.SpawnerData(EntityRegistry.ENDER_SCROUNGE.get(), 1, 3), 20).build()));
        ctx.register(BASALT_DELTAS, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(TagRegistry.BASALT_DELTAS), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.SCORCHER.get(), 1, 4), 24).build()));
        ctx.register(CRIMSON_FOREST, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(TagRegistry.CRIMSON_FOREST), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.HELL_PIG.get(), 2, 4), 60).add(new MobSpawnSettings.SpawnerData(EntityRegistry.HELL_SPIDER.get(), 1, 2), 24).build()));
        ctx.register(REMOVE_CREATURE_SPAWNS, new BiomeModifiers.RemoveSpawnsBiomeModifier(biomes.getOrThrow(TagRegistry.IS_DEEP_DARK_OR_MUSHROOM), entities.getOrThrow(TagRegistry.OVERWORLD)));
        ctx.register(DRIPSTONE_CAVES, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(TagRegistry.DRIPSTONE_CAVES), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.JACK_O_MAN.get(), 1, 2), 12).add(new MobSpawnSettings.SpawnerData(EntityRegistry.ENTHRALLED_DRAMCRYX.get(), 2, 4), 60).add(new MobSpawnSettings.SpawnerData(EntityRegistry.RAINBOUR.get(), 1, 2), 50).build()));
        ctx.register(NETHER_WASTES, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(TagRegistry.NETHER_WASTES), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.HELL_SPIDER.get(), 1, 2), 36).add(new MobSpawnSettings.SpawnerData(EntityRegistry.WILDFIRE.get(), 1, 2), 60).build()));
        ctx.register(SOUL_SAND_SPAWN_COSTS, new BiomeModifiers.AddSpawnCostsBiomeModifier(biomes.getOrThrow(TagRegistry.SOUL_SAND_VALLEY), HolderSet.direct(EntityRegistry.WILDFIRE.get().builtInRegistryHolder(), EntityRegistry.SCORCHER.get().builtInRegistryHolder()), new MobSpawnSettings.MobSpawnCost(0.7D, 0.15D)));
        ctx.register(SOUL_SAND_VALLEY, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(TagRegistry.SOUL_SAND_VALLEY), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.SCORCHER.get(), 4, 4), 15).add(new MobSpawnSettings.SpawnerData(EntityRegistry.WILDFIRE.get(), 3, 3), 18).build()));
        ctx.register(BEACH, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_beach")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.CRAB.get(), 1, 5), 40).add(new MobSpawnSettings.SpawnerData(EntityRegistry.KING_CRAB.get(), 1, 5), 20).build()));
        ctx.register(CAVE, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_cave")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.RAINBOUR.get(), 1, 2), 30).build()));
        ctx.register(DEEP_OCEAN, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_deep_ocean")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.LIOPLEURODON.get(), 1, 2), 2).build()));
        ctx.register(DENSE_VEGETATION_NETHER, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_dense_vegetation/nether")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.HELL_PIG.get(), 2, 4), 45).add(new MobSpawnSettings.SpawnerData(EntityRegistry.HELL_SPIDER.get(), 1, 2), 14).build()));
        ctx.register(DESERT, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_desert")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.ARID_WARRIOR.get(), 1, 4), 40).add(new MobSpawnSettings.SpawnerData(EntityRegistry.DESERT_CRAWLER.get(), 1, 4), 40).add(new MobSpawnSettings.SpawnerData(EntityRegistry.SAGUARO_WORM.get(), 1, 4), 32).build()));
        //TODO - Tar Lake & Kobblin hill
        //        ctx.register(TAR_LAKES, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(commonTag("is_dry/overworld")), HolderSet.direct(placed.getOrThrow(FeatureRegistry.TAR_LAKE)), GenerationStep.Decoration.LAKES));
        ctx.register(FOREST, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_forest")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.JACK_O_MAN.get(), 1, 1), 4).add(new MobSpawnSettings.SpawnerData(EntityRegistry.CYCLOPS.get(), 2, 4), 80).add(new MobSpawnSettings.SpawnerData(EntityRegistry.PUMPKIN_SPIDER.get(), 1, 3), 60).build()));
        ctx.register(JUNGLE, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_jungle")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.JUNGLE_BAT.get(), 1, 4), 12).add(new MobSpawnSettings.SpawnerData(EntityRegistry.JUNGLE_DRAMCRYX.get(), 1, 4), 60).add(new MobSpawnSettings.SpawnerData(EntityRegistry.JUNGLE_SPIDER.get(), 1, 4), 40).build()));
        ctx.register(LUSH_CAVES, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_lush")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.CAVE_CRAWLER.get(), 2, 3), 60).add(new MobSpawnSettings.SpawnerData(EntityRegistry.CAVECLOPS.get(), 1, 4), 60).add(new MobSpawnSettings.SpawnerData(EntityRegistry.ENTHRALLED_DRAMCRYX.get(), 1, 2), 16).add(new MobSpawnSettings.SpawnerData(EntityRegistry.CRAB.get(), 1, 4), 20).add(new MobSpawnSettings.SpawnerData(EntityRegistry.JUNGLE_BAT.get(), 1, 4), 8).add(new MobSpawnSettings.SpawnerData(EntityRegistry.AEQUOREA.get(), 1, 4), 8).build()));
        ctx.register(MINESHAFT, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.HAS_MINESHAFT),WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.MINER.get(), 1, 2), 60).build()));
        ctx.register(OCEAN, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_ocean")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.WHALE.get(), 1, 3), 2).add(new MobSpawnSettings.SpawnerData(EntityRegistry.AEQUOREA.get(),1, 6), 6).build()));
        ctx.register(OVERWORLD, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_overworld")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.ROTATICK.get(),1, 4), 120).add(new MobSpawnSettings.SpawnerData(EntityRegistry.THE_EYE.get(), 1, 4), 50).add(new MobSpawnSettings.SpawnerData(EntityRegistry.CAVECLOPS.get(), 1, 4), 80).add(new MobSpawnSettings.SpawnerData(EntityRegistry.ENTHRALLED_DRAMCRYX.get(), 1, 4), 60).add(new MobSpawnSettings.SpawnerData(EntityRegistry.THE_GRUE.get(),1, 4), 60).add(new MobSpawnSettings.SpawnerData(EntityRegistry.CAVE_CRAWLER.get(), 1, 3), 40).build()));
        ctx.register(RIVER, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_river")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.AEQUOREA.get(), 1, 6), 3).build()));
        ctx.register(SNOWY, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_snowy")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.FROST.get(), 1, 4), 30).add(new MobSpawnSettings.SpawnerData(EntityRegistry.GLACON.get(), 1, 3), 44).build()));
        ctx.register(SPARSE_VEGETATION_NETHER, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_sparse_vegetation/nether")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.HELL_SPIDER.get(), 1, 2), 16).add(new MobSpawnSettings.SpawnerData(EntityRegistry.WILDFIRE.get(), 1, 2), 20).build()));
        ctx.register(SPOOKY, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_spooky")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.JACK_O_MAN.get(), 1, 1), 7).add(new MobSpawnSettings.SpawnerData(EntityRegistry.CYCLOPS.get(), 2, 4), 40).add(new MobSpawnSettings.SpawnerData(EntityRegistry.PUMPKIN_SPIDER.get(),  1, 3), 40).add(new MobSpawnSettings.SpawnerData(EntityRegistry.ENTHRALLED_DRAMCRYX.get(), 1, 3), 36).build()));
        ctx.register(STRONGHOLD_BIASED, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.STRONGHOLD_BIASED_TO), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.ENDER_SPIDER.get(),1, 4), 16).build()));
        ctx.register(SWAMP, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(commonTag("is_swamp")), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.JACK_O_MAN.get(), 1, 1), 5).add(new MobSpawnSettings.SpawnerData(EntityRegistry.PUMPKIN_SPIDER.get(), 1, 2), 24).build()));
        ctx.register(WARM_OCEANS, new BiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(TagRegistry.WARM_OCEAN),WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.SHARK.get(), 1, 3), 3).build()));
        ctx.register(WARPED_FOREST, new BiomeModifiers.AddSpawnsBiomeModifier(HolderSet.direct(biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("minecraft", "warped_forest")))), WeightedList.<MobSpawnSettings.SpawnerData>builder().add(new MobSpawnSettings.SpawnerData(EntityRegistry.ENDER_SCROUNGE.get(),2, 3), 60).build()));

    }

    private static TagKey<Biome> commonTag(String name){
        return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("c", name));
    }
}