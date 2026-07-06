package net.divinerpg.data;

import net.divinerpg.registries.FeatureRegistry;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.TrapezoidHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatureProvider {

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);

        registerOre(context, FeatureRegistry.ARLEMITE_PLACED, configured, FeatureRegistry.ARLEMITE_ORE, CountPlacement.of(2), HeightRangePlacement.of(TrapezoidHeight.of(VerticalAnchor.aboveBottom(5), VerticalAnchor.aboveBottom(70))));
        registerOre(context, FeatureRegistry.REALMITE_PLACED, configured, FeatureRegistry.REALMITE_ORE, CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64)));
        registerOre(context, FeatureRegistry.RUPEE_PLACED, configured, FeatureRegistry.RUPEE_ORE, CountPlacement.of(6), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(32)));
        registerOre(context, FeatureRegistry.REALMITE_VEIN_LARGE_PLACED, configured, FeatureRegistry.REALMITE_VEIN_LARGE, CountPlacement.of(2), HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(128)));
        registerOre(context, FeatureRegistry.REALMITE_VEIN_SMALL_PLACED, configured, FeatureRegistry.REALMITE_VEIN_SMALL, CountPlacement.of(4), HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(128)));
        registerOre(context, FeatureRegistry.BLOODGEM_ORE_PLACED, configured, FeatureRegistry.BLOODGEM_ORE, CountPlacement.of(5), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()));
        registerOre(context, FeatureRegistry.TORRIDITE_PLACED, configured, FeatureRegistry.TORRIDITE_ORE, CountPlacement.of(5), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()));

        registerPlaced(context, FeatureRegistry.DIVINE_TREE_PLACED, configured, FeatureRegistry.DIVINE_TREE_KEY, List.of(RarityFilter.onAverageOnceEvery(12), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), InSquarePlacement.spread()));
        registerPlaced(context, FeatureRegistry.GIANT_DIVINE_TREE_PLACED, configured, FeatureRegistry.GIANT_DIVINE_TREE, List.of(RarityFilter.onAverageOnceEvery(500), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), BiomeFilter.biome()));
    }

    private static void registerOre(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, HolderGetter<ConfiguredFeature<?, ?>> configured, ResourceKey<ConfiguredFeature<?, ?>> feature, PlacementModifier count, PlacementModifier height) {
        context.register(key, new PlacedFeature(configured.getOrThrow(feature), List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome())));
    }

    private static void registerPlaced(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, HolderGetter<ConfiguredFeature<?, ?>> configured, ResourceKey<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configured.getOrThrow(feature), modifiers));
    }
}