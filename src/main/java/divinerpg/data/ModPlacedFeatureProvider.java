package divinerpg.data;

import divinerpg.registries.FeatureRegistry;
import divinerpg.world.ConfiguredFeatureKeys;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.heightproviders.TrapezoidHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatureProvider {

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<Feature> configured = context.lookup(Registries.FEATURE);

        registerOre(context, FeatureRegistry.ARLEMITE_PLACED, configured, FeatureRegistry.ARLEMITE_ORE, CountPlacement.of(2), HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.aboveBottom(5), VerticalAnchor.aboveBottom(70))));
        registerOre(context, FeatureRegistry.REALMITE_PLACED, configured, FeatureRegistry.REALMITE_ORE, CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64)));
        registerOre(context, FeatureRegistry.RUPEE_PLACED, configured, FeatureRegistry.RUPEE_ORE, CountPlacement.of(6), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(32)));
        registerOre(context, FeatureRegistry.REALMITE_VEIN_LARGE_PLACED, configured, FeatureRegistry.REALMITE_VEIN_LARGE, CountPlacement.of(2), HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(128)));
        registerOre(context, FeatureRegistry.REALMITE_VEIN_SMALL_PLACED, configured, FeatureRegistry.REALMITE_VEIN_SMALL, CountPlacement.of(4), HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(128)));
        registerOre(context, FeatureRegistry.BLOODGEM_ORE_PLACED, configured, FeatureRegistry.BLOODGEM_ORE, CountPlacement.of(5), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()));
        registerOre(context, FeatureRegistry.TORRIDITE_PLACED, configured, FeatureRegistry.TORRIDITE_ORE, CountPlacement.of(5), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()));

        registerPlaced(context, FeatureRegistry.DIVINE_TREE_PLACED, configured, FeatureRegistry.DIVINE_TREE_KEY, List.of(RarityFilter.onAverageOnceEvery(12), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), InSquarePlacement.spread()));
        registerPlaced(context, FeatureRegistry.GIANT_DIVINE_TREE_PLACED, configured, FeatureRegistry.GIANT_DIVINE_TREE, List.of(RarityFilter.onAverageOnceEvery(500), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), BiomeFilter.biome()));

        context.register(FeatureRegistry.KOBBLIN_HILL_PLACED, new PlacedFeature(configured.getOrThrow(FeatureRegistry.KOBBLIN_HILL_KEY), List.of(RarityFilter.onAverageOnceEvery(12), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(BlockTags.DIRT)))));
        context.register(FeatureRegistry.TAR_LAKE, new PlacedFeature(configured.getOrThrow(FeatureRegistry.TAR_LAKE_KEY), List.of(RarityFilter.onAverageOnceEvery(100), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BiomeFilter.biome())));
        context.register(FeatureRegistry.TWILIGHT_TAR_LAKE_PLACED_KEY, new PlacedFeature(configured.getOrThrow(ConfiguredFeatureKeys.TWILIGHT_TAR_LAKE), List.of(RarityFilter.onAverageOnceEvery(200), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG))));


        context.register(FeatureRegistry.APALACHIA_ORE_PLACED, new PlacedFeature(configured.getOrThrow(FeatureRegistry.APALACHIA_ORE),List.of(CountPlacement.of(12),InSquarePlacement.spread(),HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(256)),BiomeFilter.biome())));
        context.register(FeatureRegistry.APALACHIA_VEGETATION_KEY_PLACED, new PlacedFeature(configured.getOrThrow(FeatureRegistry.APALACHIA_VEGETATION_KEY), List.of(CountPlacement.of(34), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(Direction.DOWN, BlockTags.GRASS_BLOCKS)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), BiomeFilter.biome())));
        context.register(FeatureRegistry.APALACHIA_TREE_PLACED, new PlacedFeature(configured.getOrThrow(FeatureRegistry.APALACHIA_TREE_KEY), List.of(NoiseBasedCountPlacement.of(12,90, 0.0), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), BiomeFilter.biome())));
        context.register(FeatureRegistry.APALACHIA_VEGETATION_PATCH_KEY, new PlacedFeature(configured.getOrThrow(FeatureRegistry.APALACHIA_VEGETATION_KEY), List.of(RarityFilter.onAverageOnceEvery(4))));
    }

    private static void registerOre(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, HolderGetter<Feature> configured, ResourceKey<Feature> feature, PlacementModifier count, PlacementModifier height) {
        context.register(key, new PlacedFeature(configured.getOrThrow(feature), List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome())));
    }

    private static void registerPlaced(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, HolderGetter<Feature> configured, ResourceKey<Feature> feature, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configured.getOrThrow(feature), modifiers));
    }
}