package divinerpg.data;

import com.google.common.collect.ImmutableList;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.FeatureRegistry;
import divinerpg.registries.FluidRegistry;
import divinerpg.world.ConfiguredFeatureKeys;
import divinerpg.world.config.tree.GiantDivineFoliagePlacer;
import divinerpg.world.config.tree.GiantDivineTrunkPlacer;
import divinerpg.world.config.tree.TreeConfig;
import divinerpg.world.feature.Ellipsoid;
import divinerpg.world.feature.config.EllipsoidConfig;
import divinerpg.world.feature.config.ore.OreVeinConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.NoiseBasedCountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.resources.ResourceKey;

import java.util.List;
import java.util.Optional;


public class ModFeatureProvider {

    private static final RuleTest STONE = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    private static final RuleTest DEEPSLATE = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    private static final RuleTest NETHER = new TagMatchTest(BlockTags.create(Identifier.fromNamespaceAndPath("c", "ore_bearing_ground/netherrack")));
    private static final RuleTest STONES = new TagMatchTest(BlockTags.create(Identifier.fromNamespaceAndPath("c", "stones")));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);
        registerOre(context, FeatureRegistry.ARLEMITE_ORE, BlockRegistry.arlemiteOre.get(), BlockRegistry.arlemiteOreDeepslate.get(), 8, 0.75f, STONE, DEEPSLATE);
        registerOre(context, FeatureRegistry.REALMITE_ORE, BlockRegistry.realmiteOre.get(), BlockRegistry.realmiteOreDeepslate.get(), 12, 0.4f, STONE, DEEPSLATE);
        registerOre(context, FeatureRegistry.RUPEE_ORE, BlockRegistry.rupeeOre.get(), BlockRegistry.rupeeOreDeepslate.get(), 8, 0.75f, STONE, DEEPSLATE);
        registerOre(context, FeatureRegistry.BLOODGEM_ORE, BlockRegistry.bloodgemOre.get(), 4, 0.6f, NETHER);
        registerOre(context, FeatureRegistry.TORRIDITE_ORE, BlockRegistry.torriditeOre.get(), 4, 0.6f, NETHER);

        context.register(FeatureRegistry.REALMITE_VEIN_LARGE, new ConfiguredFeature<OreVeinConfig, Feature<OreVeinConfig>>(FeatureRegistry.ORE_VEIN.get(), new OreVeinConfig(0.15f, 0.75f, 0.2f, List.of(new OreVeinConfig.TargetBlockState(STONE, BlockRegistry.realmiteOre.get().defaultBlockState(), 0.5f, 0.4f), new OreVeinConfig.TargetBlockState(STONE, Blocks.ANDESITE.defaultBlockState(), 0.5f, 0.2f)))));
        context.register(FeatureRegistry.REALMITE_VEIN_SMALL, new ConfiguredFeature<OreVeinConfig, Feature<OreVeinConfig>>(FeatureRegistry.ORE_VEIN.get(), new OreVeinConfig(0.5f, 0.6f, 0.1f, List.of(new OreVeinConfig.TargetBlockState(STONE, BlockRegistry.realmiteOre.get().defaultBlockState(), 0.5f, 0.4f), new OreVeinConfig.TargetBlockState(STONE, Blocks.ANDESITE.defaultBlockState(), 0.5f, 0.2f), new OreVeinConfig.TargetBlockState(STONE, Blocks.COBBLESTONE.defaultBlockState(), 0.2f, 0.1f)))));

        context.register(FeatureRegistry.DIVINE_TREE_KEY, new ConfiguredFeature<>(FeatureRegistry.DIVINE_TREE.get(), new TreeConfig(BlockRegistry.divineLog.get().defaultBlockState(), BlockRegistry.divineLeaves.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of(new TagMatchTest(BlockTags.GRASS_BLOCKS)))));
        context.register(FeatureRegistry.GIANT_DIVINE_TREE, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BlockRegistry.divineLog.get()), new GiantDivineTrunkPlacer(32, 24, 24), BlockStateProvider.simple(BlockRegistry.divineLeaves.get()), new GiantDivineFoliagePlacer(ConstantInt.of(10), ConstantInt.of(0)), Optional.empty(), new TwoLayersFeatureSize(1, 0, 2), BlockStateProvider.simple(Blocks.DIRT)).ignoreVines().build()));
        context.register(FeatureRegistry.TAR_LAKE_KEY, new ConfiguredFeature<>(Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(FluidRegistry.SMOLDERING_TAR_BLOCK.get().defaultBlockState()), BlockStateProvider.simple(Blocks.STONE), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue())));
        context.register(ConfiguredFeatureKeys.TWILIGHT_TAR_LAKE, new ConfiguredFeature<>(Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(FluidRegistry.SMOLDERING_TAR_BLOCK.get().defaultBlockState()), BlockStateProvider.simple(BlockRegistry.twilightStone.get()), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue())));

        context.register(FeatureRegistry.KOBBLIN_HILL_KEY, new ConfiguredFeature<>((Feature<NoneFeatureConfiguration>) FeatureRegistry.KOBBLIN_HILL.get(), NoneFeatureConfiguration.INSTANCE));
        context.register(FeatureRegistry.TWILIGHT_STONE_BLOB_KEY, new ConfiguredFeature<>(FeatureRegistry.ELLIPSOID.get(), new EllipsoidConfig(BlockStateProvider.simple(BlockRegistry.twilightStone.get()), BlockStateProvider.simple(BlockRegistry.frozenStone.get()), UniformInt.of(2, 5))));

        registerOre(context, FeatureRegistry.APALACHIA_ORE, BlockRegistry.apalachiaOre.get(), 12, 0.15f, STONES);
        context.register(FeatureRegistry.APALACHIA_VEGETATION_PATCH_KEY, new ConfiguredFeature<>(Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(HolderSet.direct(BlockRegistry.apalachiaGrass.get().builtInRegistryHolder()), BlockStateProvider.simple(BlockRegistry.apalachiaGrass.get()), Holder.direct(new PlacedFeature(configured.getOrThrow(FeatureRegistry.APALACHIA_VEGETATION_KEY), List.of(NoiseBasedCountPlacement.of(1, 1, 2.0)))), CaveSurface.FLOOR, UniformInt.of(1, 5), 1.0f, 2, 0.0f, UniformInt.of(1, 1), 0.0f)));
        context.register(FeatureRegistry.APALACHIA_VEGETATION_KEY, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(WeightedList.<BlockState>builder().add(BlockRegistry.apalachiaTallgrass.get().defaultBlockState(), 5).add(BlockRegistry.duskBloom.get().defaultBlockState(), 1).add(BlockRegistry.duskFlower.get().defaultBlockState(), 2).build()))));

        context.register(FeatureRegistry.APALACHIA_TREE_KEY, new ConfiguredFeature<>(FeatureRegistry.APALACHIA_TREE.get(), new TreeConfig(BlockRegistry.apalachiaLog.get().defaultBlockState(), BlockRegistry.apalachiaLeaves.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of(new TagMatchTest(BlockTags.GRASS_BLOCKS)))));
    }

    private static void registerOre(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, Block stone, Block deepslate, int size, float discard, RuleTest ruleTest, RuleTest ruleTest2) {
        var targets = List.of(OreConfiguration.target(ruleTest, stone.defaultBlockState()), OreConfiguration.target(ruleTest2, deepslate.defaultBlockState()));
        context.register(key, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(targets, size, discard)));
    }

    private static void registerOre(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, Block stone, int size, float discard, RuleTest ruleTest) {
        var targets = List.of(OreConfiguration.target(ruleTest, stone.defaultBlockState()));
        context.register(key, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(targets, size, discard)));
    }

}