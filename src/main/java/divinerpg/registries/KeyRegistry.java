package divinerpg.registries;

import divinerpg.*;
import divinerpg.config.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.village.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.blockstateprovider.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.*;
import net.minecraft.world.gen.foliageplacer.*;
import net.minecraft.world.gen.surfacebuilders.*;
import net.minecraft.world.gen.trunkplacer.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

public class KeyRegistry {

    public static RegistryKey<World> EDEN_WORLD;
    public static RegistryKey<Biome> EDEN_BIOME;
    public static RegistryKey<SurfaceBuilder<?>> EDEN_BUILDER;
    public static final DeferredRegister<PointOfInterestType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, DivineRPG.MODID);
    public static RegistryObject<PointOfInterestType> EDEN_PORTAL;
    public static ConfiguredFeature<BaseTreeFeatureConfig,?> DIVINE_TREE, EDEN_TREE, WILDWOOD_TREE, APALACHIA_TREE, SKYTHERN_TREE, MORTUM_TREE, FROZEN_TREE;



    public static void init(){
        DIVINE_TREE = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.divineLog.getDefaultState()), new SimpleBlockStateProvider(BlockRegistry.divineLeaves.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build());

        EDEN_BIOME = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(DivineRPG.MODID, "eden"));
        EDEN_WORLD = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DivineRPG.MODID, "eden"));
        EDEN_BUILDER = RegistryKey.getOrCreateKey(Registry.SURFACE_BUILDER_KEY, new ResourceLocation(DivineRPG.MODID, "eden"));
        EDEN_PORTAL = POI.register("eden_portal", () -> new PointOfInterestType("eden_portal", PointOfInterestType.getAllStates(BlockRegistry.edenPortal), 0, 1));
        EDEN_TREE = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.edenLog.getDefaultState()), new SimpleBlockStateProvider(BlockRegistry.divineLeaves.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build());
        register("ore_eden", Feature.ORE.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(BlockRegistry.twilightStone), BlockRegistry.edenOre.getDefaultState(), Config.twilightVein.get())).range(256).square().func_242731_b(Config.twilightTries.get()));

        WILDWOOD_TREE = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.wildwoodLog.getDefaultState()), new SimpleBlockStateProvider(BlockRegistry.divineLeaves.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build());
        register("ore_wildwood", Feature.ORE.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(BlockRegistry.twilightStone), BlockRegistry.wildwoodOre.getDefaultState(), Config.twilightVein.get())).range(256).square().func_242731_b(Config.twilightTries.get()));

        APALACHIA_TREE = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.apalachiaLog.getDefaultState()), new SimpleBlockStateProvider(BlockRegistry.divineLeaves.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build());
        register("ore_apalachia", Feature.ORE.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(BlockRegistry.twilightStone), BlockRegistry.apalachiaOre.getDefaultState(), Config.twilightVein.get())).range(256).square().func_242731_b(Config.twilightTries.get()));

        SKYTHERN_TREE = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.skythernLog.getDefaultState()), new SimpleBlockStateProvider(BlockRegistry.divineLeaves.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build());
        register("ore_skythern", Feature.ORE.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(BlockRegistry.twilightStone), BlockRegistry.skythernOre.getDefaultState(), Config.twilightVein.get())).range(256).square().func_242731_b(Config.twilightTries.get()));

        MORTUM_TREE = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.mortumLog.getDefaultState()), new SimpleBlockStateProvider(BlockRegistry.divineLeaves.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build());
        register("ore_mortum", Feature.ORE.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(BlockRegistry.twilightStone), BlockRegistry.mortumOre.getDefaultState(), Config.twilightVein.get())).range(256).square().func_242731_b(Config.twilightTries.get()));

        FROZEN_TREE = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.frozenLog.getDefaultState()), new SimpleBlockStateProvider(BlockRegistry.divineLeaves.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build());

    }


    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(DivineRPG.MODID, name), feature);
    }
}
