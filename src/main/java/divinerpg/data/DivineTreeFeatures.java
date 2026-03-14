package divinerpg.data;

import divinerpg.DivineRPG;
import divinerpg.registries.BlockRegistry;
import divinerpg.world.feature.tree.GiantDivineFoliagePlacer;
import divinerpg.world.feature.tree.GiantDivineTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class DivineTreeFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_DIVINE_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "giant_divine_tree"));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(GIANT_DIVINE_TREE, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BlockRegistry.divineLog.get()), new GiantDivineTrunkPlacer(32, 24, 24), BlockStateProvider.simple(BlockRegistry.divineLeaves.get()), new GiantDivineFoliagePlacer(ConstantInt.of(10), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).forceDirt().ignoreVines().build()));
    }
}