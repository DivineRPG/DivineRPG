package divinerpg.data;

import divinerpg.registries.BlockRegistry;
import divinerpg.registries.FeatureRegistry;
import divinerpg.registries.FluidRegistry;
import divinerpg.world.ConfiguredFeatureKeys;
import divinerpg.world.config.tree.GiantDivineFoliagePlacer;
import divinerpg.world.config.tree.GiantDivineTrunkPlacer;
import divinerpg.world.config.tree.TreeConfig;
import divinerpg.world.feature.Ellipsoid;
import divinerpg.world.feature.config.EllipsoidConfig;
import divinerpg.world.feature.ore.OreVeinFeature;
import divinerpg.world.feature.structurelike.KobblinHill;
import divinerpg.world.feature.tree.ApalachiaTree;
import divinerpg.world.feature.tree.DivineTree;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.Optional;

public class ModFeatureProvider {

    private static final RuleTest STONE = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    private static final RuleTest DEEPSLATE = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    private static final RuleTest NETHER = new TagMatchTest(BlockTags.create(Identifier.fromNamespaceAndPath("c", "ore_bearing_ground/netherrack")));
    private static final RuleTest STONES = new TagMatchTest(BlockTags.create(Identifier.fromNamespaceAndPath("c", "stones")));

    public static void bootstrap(BootstrapContext<Feature> context) {
        HolderGetter<Feature> configured = context.lookup(Registries.FEATURE);

        registerOre(context, FeatureRegistry.ARLEMITE_ORE, BlockRegistry.arlemiteOre.get(), BlockRegistry.arlemiteOreDeepslate.get(), 0.75f, 0.0f, STONE, DEEPSLATE);
        registerOre(context, FeatureRegistry.REALMITE_ORE, BlockRegistry.realmiteOre.get(), BlockRegistry.realmiteOreDeepslate.get(), 0.4f, 0.0f, STONE, DEEPSLATE);
        registerOre(context, FeatureRegistry.RUPEE_ORE, BlockRegistry.rupeeOre.get(), BlockRegistry.rupeeOreDeepslate.get(), 0.75f, 0.0f, STONE, DEEPSLATE);
        registerOre(context, FeatureRegistry.BLOODGEM_ORE, BlockRegistry.bloodgemOre.get(), 0.6f, 0.0f, NETHER);
        registerOre(context, FeatureRegistry.TORRIDITE_ORE, BlockRegistry.torriditeOre.get(), 0.6f, 0.0f, NETHER);

        context.register(FeatureRegistry.REALMITE_VEIN_LARGE, new OreVeinFeature(0.15f, 0.75f, 0.2f, List.of(new OreVeinFeature.TargetBlockState(STONE, BlockRegistry.realmiteOre.get().defaultBlockState(), 0.5f, 0.4f), new OreVeinFeature.TargetBlockState(STONE, Blocks.ANDESITE.defaultBlockState(), 0.5f, 0.2f))));
        context.register(FeatureRegistry.REALMITE_VEIN_SMALL, new OreVeinFeature(0.5f, 0.6f, 0.1f, List.of(new OreVeinFeature.TargetBlockState(STONE, BlockRegistry.realmiteOre.get().defaultBlockState(), 0.5f, 0.4f), new OreVeinFeature.TargetBlockState(STONE, Blocks.ANDESITE.defaultBlockState(), 0.5f, 0.2f), new OreVeinFeature.TargetBlockState(STONE, Blocks.COBBLESTONE.defaultBlockState(), 0.2f, 0.1f))));

        context.register(FeatureRegistry.DIVINE_TREE_KEY, new DivineTree(new TreeConfig(BlockRegistry.divineLog.get().defaultBlockState(), BlockRegistry.divineLeaves.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), List.of(new TagMatchTest(BlockTags.GRASS_BLOCKS)))));
        context.register(FeatureRegistry.GIANT_DIVINE_TREE, new TreeFeature(Holder.direct(BlockStateProvider.of(BlockRegistry.divineLog.get())), new GiantDivineTrunkPlacer(32, 24, 24), Holder.direct(BlockStateProvider.of(BlockRegistry.divineLeaves.get())), new GiantDivineFoliagePlacer(ConstantInt.of(10), ConstantInt.of(0)), Optional.empty(), new TwoLayersFeatureSize(1, 0, 2), List.of(), true, Holder.direct(BlockStateProvider.of(Blocks.DIRT))));

        context.register(FeatureRegistry.TAR_LAKE_KEY, new LakeFeature(Holder.direct(BlockStateProvider.of(FluidRegistry.SMOLDERING_TAR_BLOCK.get().defaultBlockState())), BlockStateProvider.holderOf(Blocks.STONE), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue()));
        context.register(ConfiguredFeatureKeys.TWILIGHT_TAR_LAKE, new LakeFeature(Holder.direct(BlockStateProvider.of(FluidRegistry.SMOLDERING_TAR_BLOCK.get().defaultBlockState())), Holder.direct(BlockStateProvider.of(BlockRegistry.twilightStone.get())), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue()));

        context.register(FeatureRegistry.KOBBLIN_HILL_KEY, new KobblinHill());
        context.register(FeatureRegistry.TWILIGHT_STONE_BLOB_KEY, new Ellipsoid(new EllipsoidConfig(BlockStateProvider.holderOf(BlockRegistry.twilightStone.get()), BlockStateProvider.holderOf(BlockRegistry.frozenStone.get()), UniformInt.of(2, 5))));

        registerOre(context, FeatureRegistry.APALACHIA_ORE, BlockRegistry.apalachiaOre.get(), 0.6F, 0.15f, STONES);

        context.register(FeatureRegistry.APALACHIA_VEGETATION_KEY, new SimpleBlockFeature(new WeightedStateProvider(WeightedList.<BlockState>builder().add(BlockRegistry.apalachiaTallgrass.get().defaultBlockState(), 5).add(BlockRegistry.duskBloom.get().defaultBlockState(), 1).add(BlockRegistry.duskFlower.get().defaultBlockState(), 2).build())));
        context.register(FeatureRegistry.APALACHIA_TREE_KEY, new ApalachiaTree(new TreeConfig(BlockRegistry.apalachiaLog.get().defaultBlockState(), BlockRegistry.apalachiaLeaves.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), List.of(new TagMatchTest(BlockTags.GRASS_BLOCKS)))));
    }

    private static void registerOre(BootstrapContext<Feature> context, ResourceKey<Feature> key, Block stone, Block deepslate, float chance, float discard, RuleTest ruleTest, RuleTest ruleTest2) {
        var targets = List.of(new OreVeinFeature.TargetBlockState(ruleTest, stone.defaultBlockState(), chance, discard), new OreVeinFeature.TargetBlockState(ruleTest2, deepslate.defaultBlockState(), chance, discard));
        context.register(key, new OreVeinFeature(0.0f, 0.0f, 0.0f, targets));
    }

    private static void registerOre(BootstrapContext<Feature> context, ResourceKey<Feature> key, Block stone, float chance, float discard,  RuleTest ruleTest) {
        var targets = List.of(new OreVeinFeature.TargetBlockState(ruleTest, stone.defaultBlockState(), chance, discard));
        context.register(key, new OreVeinFeature(0.0f, 0.0f, 0.0f, targets));
    }
}