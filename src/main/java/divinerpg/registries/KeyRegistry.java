package divinerpg.registries;

import com.google.common.collect.*;
import divinerpg.*;
import divinerpg.config.*;
import divinerpg.world.arcana.*;
import divinerpg.world.gen.tree.decorator.*;
import divinerpg.world.vethea.*;
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

    public static RegistryKey<World> EDEN_WORLD, WILDWOOD_WORLD, APALACHIA_WORLD, SKYTHERN_WORLD, MORTUM_WORLD, ARCANA_WORLD, VETHEA_WORLD, ICEIKA_WORLD;
    public static RegistryKey<Biome> EDEN_BIOME, WILDWOOD_BIOME, APALACHIA_BIOME, SKYTHERN_BIOME, MORTUM_BIOME, ARCANA_BIOME, VETHEA_BIOME, ICEIKA_PLAINS_BIOME, ICEIKA_HILLS_BIOME;
    public static RegistryKey<SurfaceBuilder<?>> EDEN_BUILDER, WILDWOOD_BUILDER, APALACHIA_BUILDER, SKYTHERN_BUILDER, MORTUM_BUILDER, VETHEA_BUILDER, ICEIKA_BUILDER;
    public static final DeferredRegister<PointOfInterestType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, DivineRPG.MODID);
    public static RegistryObject<PointOfInterestType> EDEN_PORTAL = POI.register("eden_portal", () -> new PointOfInterestType("eden_portal", PointOfInterestType.getBlockStates(BlockRegistry.edenPortal), 0, 1)),
            WILDWOOD_PORTAL = POI.register("wildwood_portal", () -> new PointOfInterestType("wildwood_portal", PointOfInterestType.getBlockStates(BlockRegistry.wildwoodPortal), 0, 1)),
            APALACHIA_PORTAL = POI.register("apalachia_portal", () -> new PointOfInterestType("apalachia_portal", PointOfInterestType.getBlockStates(BlockRegistry.apalachiaPortal), 0, 1)),
            SKYTHERN_PORTAL = POI.register("skythern_portal", () -> new PointOfInterestType("skythern_portal", PointOfInterestType.getBlockStates(BlockRegistry.skythernPortal), 0, 1)),
            MORTUM_PORTAL = POI.register("mortum_portal", () -> new PointOfInterestType("mortum_portal", PointOfInterestType.getBlockStates(BlockRegistry.mortumPortal), 0, 1)),
            ARCANA_PORTAL = POI.register("arcana_portal", () -> new PointOfInterestType("arcana_portal", PointOfInterestType.getBlockStates(BlockRegistry.arcanaPortal), 0, 1)),
            ICEIKA_PORTAL = POI.register("iceika_portal", () -> new PointOfInterestType("iceika_portal", PointOfInterestType.getBlockStates(BlockRegistry.iceikaPortal), 0, 1));
    public static ConfiguredFeature<BaseTreeFeatureConfig, ?> DIVINE_TREE, EDEN_TREE, WILDWOOD_TREE, APALACHIA_TREE, SKYTHERN_TREE, MORTUM_TREE, FROZEN_TREE;


    public static IStructureProcessorType<DivineStructureBlockProcessor> CHEST_PROCESSOR = () -> DivineStructureBlockProcessor.CODEC;

    public static void init() {
        DivineRPG.LOGGER.info("[DivineRPG] Registered registry keys");


        DIVINE_TREE = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.divineLog.defaultBlockState()), new SimpleBlockStateProvider(BlockRegistry.divineLeaves.defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build());
        EDEN_BIOME = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DivineRPG.MODID, "eden"));
        EDEN_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(DivineRPG.MODID, "eden"));
        EDEN_BUILDER = RegistryKey.create(Registry.SURFACE_BUILDER_REGISTRY, new ResourceLocation(DivineRPG.MODID, "eden"));
        EDEN_TREE = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.edenLog.defaultBlockState()), new SimpleBlockStateProvider(BlockRegistry.edenLeaves.defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build());
        register("ore_eden", Feature.ORE.configured(new OreFeatureConfig(new BlockMatchRuleTest(BlockRegistry.twilightStone), BlockRegistry.edenOre.defaultBlockState(), Config.twilightVein.get())).range(256).squared().count(Config.twilightTries.get()));

        WILDWOOD_BIOME = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DivineRPG.MODID, "wildwood"));
        WILDWOOD_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(DivineRPG.MODID, "wildwood"));
        WILDWOOD_BUILDER = RegistryKey.create(Registry.SURFACE_BUILDER_REGISTRY, new ResourceLocation(DivineRPG.MODID, "wildwood"));
        WILDWOOD_TREE = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.wildwoodLog.defaultBlockState()), new SimpleBlockStateProvider(BlockRegistry.wildwoodLeaves.defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).decorators(ImmutableList.of(WildwoodVineTrunkDecorator.INSTANCE, WildwoodVineLeavesDecorator.INSTANCE)).build());
        register("ore_wildwood", Feature.ORE.configured(new OreFeatureConfig(new BlockMatchRuleTest(BlockRegistry.twilightStone), BlockRegistry.wildwoodOre.defaultBlockState(), Config.twilightVein.get())).range(256).squared().count(Config.twilightTries.get()));

        APALACHIA_BIOME = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DivineRPG.MODID, "apalachia"));
        APALACHIA_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(DivineRPG.MODID, "apalachia"));
        APALACHIA_BUILDER = RegistryKey.create(Registry.SURFACE_BUILDER_REGISTRY, new ResourceLocation(DivineRPG.MODID, "apalachia"));
        APALACHIA_TREE = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.apalachiaLog.defaultBlockState()), new SimpleBlockStateProvider(BlockRegistry.apalachiaLeaves.defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build());
        register("ore_apalachia", Feature.ORE.configured(new OreFeatureConfig(new BlockMatchRuleTest(BlockRegistry.twilightStone), BlockRegistry.apalachiaOre.defaultBlockState(), Config.twilightVein.get())).range(256).squared().count(Config.twilightTries.get()));

        SKYTHERN_BIOME = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DivineRPG.MODID, "skythern"));
        SKYTHERN_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(DivineRPG.MODID, "skythern"));
        SKYTHERN_BUILDER = RegistryKey.create(Registry.SURFACE_BUILDER_REGISTRY, new ResourceLocation(DivineRPG.MODID, "skythern"));
        SKYTHERN_TREE = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.skythernLog.defaultBlockState()), new SimpleBlockStateProvider(BlockRegistry.skythernLeaves.defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build());
        register("ore_skythern", Feature.ORE.configured(new OreFeatureConfig(new BlockMatchRuleTest(BlockRegistry.twilightStone), BlockRegistry.skythernOre.defaultBlockState(), Config.twilightVein.get())).range(256).squared().count(Config.twilightTries.get()));

        MORTUM_BIOME = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DivineRPG.MODID, "mortum"));
        MORTUM_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(DivineRPG.MODID, "mortum"));
        MORTUM_BUILDER = RegistryKey.create(Registry.SURFACE_BUILDER_REGISTRY, new ResourceLocation(DivineRPG.MODID, "mortum"));
        MORTUM_TREE = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.mortumLog.defaultBlockState()), new SimpleBlockStateProvider(BlockRegistry.mortumLeaves.defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build());
        register("ore_mortum", Feature.ORE.configured(new OreFeatureConfig(new BlockMatchRuleTest(BlockRegistry.twilightStone), BlockRegistry.mortumOre.defaultBlockState(), Config.twilightVein.get())).range(256).squared().count(Config.twilightTries.get()));

        FROZEN_TREE = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.frozenLog.defaultBlockState()), new SimpleBlockStateProvider(BlockRegistry.brittleLeaves.defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(10, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build());

        ARCANA_BIOME = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DivineRPG.MODID, "arcana"));
        ARCANA_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(DivineRPG.MODID, "arcana"));
        Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(DivineRPG.MODID, "arcana"), ArcanaChunkGenerator.CODEC);

        VETHEA_BIOME = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DivineRPG.MODID, "vethea"));
        VETHEA_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(DivineRPG.MODID, "vethea"));
        VETHEA_BUILDER = RegistryKey.create(Registry.SURFACE_BUILDER_REGISTRY, new ResourceLocation(DivineRPG.MODID, "vethea"));
        Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(DivineRPG.MODID, "vethea"), VetheaChunkGenerator.CODEC);

        ICEIKA_PLAINS_BIOME = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DivineRPG.MODID, "iceika_plains"));
        ICEIKA_HILLS_BIOME = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DivineRPG.MODID, "iceika_hills"));
        ICEIKA_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(DivineRPG.MODID, "iceika"));
        ICEIKA_BUILDER = RegistryKey.create(Registry.SURFACE_BUILDER_REGISTRY, new ResourceLocation(DivineRPG.MODID, "iceika"));

        Registry.register(Registry.STRUCTURE_PROCESSOR, new ResourceLocation(DivineRPG.MODID, "chest_processor"), CHEST_PROCESSOR);
    }


    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(DivineRPG.MODID, name), feature);
    }
}
