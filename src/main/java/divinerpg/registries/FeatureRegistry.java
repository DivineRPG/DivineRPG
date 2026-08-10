package divinerpg.registries;

import divinerpg.world.config.tree.TreeConfig;
import divinerpg.world.feature.*;
import divinerpg.world.feature.config.*;
import divinerpg.world.feature.config.decoration.*;
import divinerpg.world.feature.config.ore.OreVeinConfig;
import divinerpg.world.feature.decoration.*;
import divinerpg.world.feature.ore.OreVein;
import divinerpg.world.feature.plant.*;
import divinerpg.world.feature.pond.*;
import divinerpg.world.feature.structurelike.*;
import divinerpg.world.feature.tree.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.registries.DeferredHolder;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.DivineRegistries.FEATURES;

public class FeatureRegistry {


    public static final DeferredHolder<Feature<?>, Feature<EllipsoidConfig>> ELLIPSOID = FEATURES.register("blob", Ellipsoid::new);
    public static final DeferredHolder<Feature<?>, Feature<NBTFeatureConfig>> NBT_FEATURE = FEATURES.register("nbt_feature", NBTFeature::new);
    public static final DeferredHolder<Feature<?>, Feature<OreVeinConfig>> ORE_VEIN = FEATURES.register("ore_vein", OreVein::new);
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>> BUSH = FEATURES.register("bush", Bush::new);
    public static final DeferredHolder<Feature<?>, Feature<SpudConfig>> SPUD = FEATURES.register("spud", Spud::new);
    public static final DeferredHolder<Feature<?>, Feature<SpudConfig>> HORIZONTAL_SPUD = FEATURES.register("horizontal_spud", HorizontalSpud::new);

    //Overworld
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>> DIVINE_TREE = FEATURES.register("divine_tree", DivineTree::new);
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> KOBBLIN_HILL = FEATURES.register("kobblin_hill", KobblinHill::new);

    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>>
            EDEN_TREE = FEATURES.register("eden_tree", EdenTree::new),
            WILDWOOD_TREE = FEATURES.register("wildwood_tree", WildwoodTree::new),
            APALACHIA_TREE = FEATURES.register("apalachia_tree", ApalachiaTree::new),
            SKYTHERN_TREE = FEATURES.register("skythern_tree", SkythernTree::new),
            MORTUM_TREE = FEATURES.register("mortum_tree", MortumTree::new);

    //Eden
    public static final DeferredHolder<Feature<?>, Feature<DensityFunctionConfig>> LAND_VINES = FEATURES.register("land_vines", LandVines::new);
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>>
            EXPOSURE = FEATURES.register("exposure", Exposure::new),
            DUNCAP = FEATURES.register("duncap", Duncap::new);

    //Iceika
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>>
            SHIVERSPINE_TREE = FEATURES.register("shiverspine_tree", ShiverspineTree::new),
            DEAD_SHIVERSPINE = FEATURES.register("dead_shiverspine", DeadShiverspine::new),
            AURORAOAK_TREE = FEATURES.register("auroraoak_tree", AuroraoakTree::new),
            COZYBARK_TREE = FEATURES.register("cozybark_tree", CozybarkTree::new),
            COZYBARK_BUSH = FEATURES.register("cozybark_bush", CozybarkBush::new),
            STUMP = FEATURES.register("stump", Stump::new),
            FRACTAL_TREE = FEATURES.register("fractal_tree", FractalTree::new),
            GLOWSPROUT = FEATURES.register("glowsprout", Glowsprout::new),
            LOWSPROUT = FEATURES.register("lowsprout", Lowsprout::new),
            SLOWSPROUT = FEATURES.register("slowsprout", Slowsprout::new),
            STREAMLEAF_TREE = FEATURES.register("streamleaf_tree", StreamleafTree::new);
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>>
            THERMAL_VENT = FEATURES.register("thermal_vent", ThermalVent::new),
            BRITTLE_PLANTS = FEATURES.register("brittle_plants", BrittlePlants::new),
            BRITTLE_CAVES_VEGETATION = FEATURES.register("brittle_caves_vegetation", BrittleCavesVegetation::new),
            WHALE_SKELETON = FEATURES.register("whale_skeleton", WhaleSkeleton::new),
            SNOW_COVERAGE = FEATURES.register("snow_coverage", SnowCoverage::new),
            SNOW_SPREADER = FEATURES.register("snow_spreader", SnowSpreader::new);
//    public static final DeferredHolder<Feature<?>, Feature<PointedDripstoneConfiguration>> ICICLE = FEATURES.register("icicle", Icicle::new);
    public static final DeferredHolder<Feature<?>, Feature<GemClusterConfig>> GEM_CLUSTER = FEATURES.register("gem_cluster", GemCluster::new);
    public static final DeferredHolder<Feature<?>, Feature<RuleTestConfig>>
            GEOTHERMAL_POND = FEATURES.register("geothermal_pond", GeothermalPond::new),
            GLACIAL_POND = FEATURES.register("glacial_pond", GlacialPond::new),
            MINERAL_POND = FEATURES.register("mineral_pond", MineralPond::new),
            BRITTLE_POND = FEATURES.register("brittle_pond", BrittlePond::new);

    //Arcana
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>>
            ARCANA_DUNGEON = FEATURES.register("arcana_dungeon", ArcanaDungeon::new),
            ARCANITE_VINES = FEATURES.register("arcanite_vines", ArcaniteVines::new);

    //Vethea
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>>
            FIREWOOD_TREE = FEATURES.register("firewood_tree", FirewoodTree::new),
            DREAMWOOD_TREE = FEATURES.register("dreamwood_tree", DreamwoodTree::new);
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> BEAM = FEATURES.register("beam", Beam::new);

    public static final ResourceKey<ConfiguredFeature<?, ?>> KOBBLIN_HILL_KEY = registerConfigured("kobblin_hill");
    public static final ResourceKey<PlacedFeature> KOBBLIN_HILL_PLACED = registerPlaced("kobblin_hill");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TAR_LAKE_KEY = registerConfigured("tar_lake");
    public static final ResourceKey<PlacedFeature> TAR_LAKE = registerPlaced("tar_lake");
    public static final ResourceKey<PlacedFeature> TWILIGHT_TAR_LAKE_PLACED_KEY = registerPlaced("twilight_tar_lake");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ARLEMITE_ORE = registerConfigured("arlemite_ore");
    public static final ResourceKey<PlacedFeature> ARLEMITE_PLACED = registerPlaced("arlemite");

    public static final ResourceKey<ConfiguredFeature<?, ?>> REALMITE_ORE = registerConfigured("realmite_ore");
    public static final ResourceKey<PlacedFeature> REALMITE_PLACED = registerPlaced("realmite");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUPEE_ORE = registerConfigured("rupee_ore");
    public static final ResourceKey<PlacedFeature> RUPEE_PLACED = registerPlaced("rupee");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOODGEM_ORE = registerConfigured("bloodgem_ore");
    public static final ResourceKey<PlacedFeature> BLOODGEM_ORE_PLACED = registerPlaced("bloodgem_ore_placed");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TORRIDITE_ORE = registerConfigured("torridite_ore");
    public static final ResourceKey<PlacedFeature> TORRIDITE_PLACED = registerPlaced("torridite_placed");

    public static final ResourceKey<ConfiguredFeature<?, ?>> REALMITE_VEIN_SMALL = registerConfigured("realmite_vein_small");
    public static final ResourceKey<PlacedFeature> REALMITE_VEIN_SMALL_PLACED = registerPlaced("realmite_vein_small");

    public static final ResourceKey<ConfiguredFeature<?, ?>> REALMITE_VEIN_LARGE = registerConfigured("realmite_vein_large");
    public static final ResourceKey<PlacedFeature> REALMITE_VEIN_LARGE_PLACED = registerPlaced("realmite_vein_large");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DIVINE_TREE_KEY = registerConfigured("divine_tree");
    public static final ResourceKey<PlacedFeature> DIVINE_TREE_PLACED = registerPlaced("divine_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_DIVINE_TREE = registerConfigured("giant_divine_tree");
    public static final ResourceKey<PlacedFeature> GIANT_DIVINE_TREE_PLACED = registerPlaced("giant_divine_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ELLIPSOID_KEY = registerConfigured("blob");
    public static final ResourceKey<PlacedFeature> ELLIPSOID_PLACED = registerPlaced("blob");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NBT_FEATURE_KEY = registerConfigured("nbt_feature");
    public static final ResourceKey<PlacedFeature> NBT_FEATURE_PLACED = registerPlaced("nbt_feature");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_VEIN_KEY = registerConfigured("ore_vein");
    public static final ResourceKey<PlacedFeature> ORE_VEIN_PLACED = registerPlaced("ore_vein");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH_KEY = registerConfigured("bush");
    public static final ResourceKey<PlacedFeature> BUSH_PLACED = registerPlaced("bush");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPUD_KEY = registerConfigured("spud");
    public static final ResourceKey<PlacedFeature> SPUD_PLACED = registerPlaced("spud");

    public static final ResourceKey<ConfiguredFeature<?, ?>> HORIZONTAL_SPUD_KEY = registerConfigured("horizontal_spud");
    public static final ResourceKey<PlacedFeature> HORIZONTAL_SPUD_PLACED = registerPlaced("horizontal_spud");

    public static final ResourceKey<ConfiguredFeature<?, ?>> EDEN_TREE_KEY = registerConfigured("eden_tree");
    public static final ResourceKey<PlacedFeature> EDEN_TREE_PLACED = registerPlaced("eden_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> WILDWOOD_TREE_KEY = registerConfigured("wildwood_tree");
    public static final ResourceKey<PlacedFeature> WILDWOOD_TREE_PLACED = registerPlaced("wildwood_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> APALACHIA_TREE_KEY = registerConfigured("apalachia_tree");
    public static final ResourceKey<PlacedFeature> APALACHIA_TREE_PLACED = registerPlaced("apalachia_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYTHERN_TREE_KEY = registerConfigured("skythern_tree");
    public static final ResourceKey<PlacedFeature> SKYTHERN_TREE_PLACED = registerPlaced("skythern_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MORTUM_TREE_KEY = registerConfigured("mortum_tree");
    public static final ResourceKey<PlacedFeature> MORTUM_TREE_PLACED = registerPlaced("mortum_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LAND_VINES_KEY = registerConfigured("land_vines");
    public static final ResourceKey<PlacedFeature> LAND_VINES_PLACED = registerPlaced("land_vines");

    public static final ResourceKey<ConfiguredFeature<?, ?>> EXPOSURE_KEY = registerConfigured("exposure");
    public static final ResourceKey<PlacedFeature> EXPOSURE_PLACED = registerPlaced("exposure");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DUNCAP_KEY = registerConfigured("duncap");
    public static final ResourceKey<PlacedFeature> DUNCAP_PLACED = registerPlaced("duncap");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SHIVERSPINE_TREE_KEY = registerConfigured("shiverspine_tree");
    public static final ResourceKey<PlacedFeature> SHIVERSPINE_TREE_PLACED = registerPlaced("shiverspine_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SHIVERSPINE_KEY = registerConfigured("dead_shiverspine");
    public static final ResourceKey<PlacedFeature> DEAD_SHIVERSPINE_PLACED = registerPlaced("dead_shiverspine");

    public static final ResourceKey<ConfiguredFeature<?, ?>> AURORAOAK_TREE_KEY = registerConfigured("auroraoak_tree");
    public static final ResourceKey<PlacedFeature> AURORAOAK_TREE_PLACED = registerPlaced("auroraoak_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> COZYBARK_TREE_KEY = registerConfigured("cozybark_tree");
    public static final ResourceKey<PlacedFeature> COZYBARK_TREE_PLACED = registerPlaced("cozybark_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> COZYBARK_BUSH_KEY = registerConfigured("cozybark_bush");
    public static final ResourceKey<PlacedFeature> COZYBARK_BUSH_PLACED = registerPlaced("cozybark_bush");

    public static final ResourceKey<ConfiguredFeature<?, ?>> STUMP_KEY = registerConfigured("stump");
    public static final ResourceKey<PlacedFeature> STUMP_PLACED = registerPlaced("stump");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FRACTAL_TREE_KEY = registerConfigured("fractal_tree");
    public static final ResourceKey<PlacedFeature> FRACTAL_TREE_PLACED = registerPlaced("fractal_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWSPROUT_KEY = registerConfigured("glowsprout");
    public static final ResourceKey<PlacedFeature> GLOWSPROUT_PLACED = registerPlaced("glowsprout");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LOWSPROUT_KEY = registerConfigured("lowsprout");
    public static final ResourceKey<PlacedFeature> LOWSPROUT_PLACED = registerPlaced("lowsprout");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SLOWSPROUT_KEY = registerConfigured("slowsprout");
    public static final ResourceKey<PlacedFeature> SLOWSPROUT_PLACED = registerPlaced("slowsprout");

    public static final ResourceKey<ConfiguredFeature<?, ?>> STREAMLEAF_TREE_KEY = registerConfigured("streamleaf_tree");
    public static final ResourceKey<PlacedFeature> STREAMLEAF_TREE_PLACED = registerPlaced("streamleaf_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> THERMAL_VENT_KEY = registerConfigured("thermal_vent");
    public static final ResourceKey<PlacedFeature> THERMAL_VENT_PLACED = registerPlaced("thermal_vent");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BRITTLE_PLANTS_KEY = registerConfigured("brittle_plants");
    public static final ResourceKey<PlacedFeature> BRITTLE_PLANTS_PLACED = registerPlaced("brittle_plants");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BRITTLE_CAVES_VEGETATION_KEY = registerConfigured("brittle_caves_vegetation");
    public static final ResourceKey<PlacedFeature> BRITTLE_CAVES_VEGETATION_PLACED = registerPlaced("brittle_caves_vegetation");

    public static final ResourceKey<ConfiguredFeature<?, ?>> WHALE_SKELETON_KEY = registerConfigured("whale_skeleton");
    public static final ResourceKey<PlacedFeature> WHALE_SKELETON_PLACED = registerPlaced("whale_skeleton");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SNOW_COVERAGE_KEY = registerConfigured("snow_coverage");
    public static final ResourceKey<PlacedFeature> SNOW_COVERAGE_PLACED = registerPlaced("snow_coverage");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SNOW_SPREADER_KEY = registerConfigured("snow_spreader");
    public static final ResourceKey<PlacedFeature> SNOW_SPREADER_PLACED = registerPlaced("snow_spreader");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GEM_CLUSTER_KEY = registerConfigured("gem_cluster");
    public static final ResourceKey<PlacedFeature> GEM_CLUSTER_PLACED = registerPlaced("gem_cluster");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GEOTHERMAL_POND_KEY = registerConfigured("geothermal_pond");
    public static final ResourceKey<PlacedFeature> GEOTHERMAL_POND_PLACED = registerPlaced("geothermal_pond");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLACIAL_POND_KEY = registerConfigured("glacial_pond");
    public static final ResourceKey<PlacedFeature> GLACIAL_POND_PLACED = registerPlaced("glacial_pond");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MINERAL_POND_KEY = registerConfigured("mineral_pond");
    public static final ResourceKey<PlacedFeature> MINERAL_POND_PLACED = registerPlaced("mineral_pond");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BRITTLE_POND_KEY = registerConfigured("brittle_pond");
    public static final ResourceKey<PlacedFeature> BRITTLE_POND_PLACED = registerPlaced("brittle_pond");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ARCANA_DUNGEON_KEY = registerConfigured("arcana_dungeon");
    public static final ResourceKey<PlacedFeature> ARCANA_DUNGEON_PLACED = registerPlaced("arcana_dungeon");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ARCANITE_VINES_KEY = registerConfigured("arcanite_vines");
    public static final ResourceKey<PlacedFeature> ARCANITE_VINES_PLACED = registerPlaced("arcanite_vines");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FIREWOOD_TREE_KEY = registerConfigured("firewood_tree");
    public static final ResourceKey<PlacedFeature> FIREWOOD_TREE_PLACED = registerPlaced("firewood_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DREAMWOOD_TREE_KEY = registerConfigured("dreamwood_tree");
    public static final ResourceKey<PlacedFeature> DREAMWOOD_TREE_PLACED = registerPlaced("dreamwood_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BEAM_KEY = registerConfigured("beam");
    public static final ResourceKey<PlacedFeature> BEAM_PLACED = registerPlaced("beam");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TWILIGHT_STONE_BLOB_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "twilight_stone_blob"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> APALACHIA_ORE = registerConfigured("apalachia_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> APALACHIA_VEGETATION_PATCH_KEY = registerConfigured("apalachia_vegetation_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> APALACHIA_VEGETATION_KEY = registerConfigured("apalachia_vegetation");
    public static final ResourceKey<PlacedFeature> APALACHIA_ORE_PLACED = registerPlaced("apalachia_ore");
    public static final ResourceKey<PlacedFeature> APALACHIA_VEGETATION_KEY_PLACED = registerPlaced("apalachia_vegetation");

    private static ResourceKey<ConfiguredFeature<?, ?>> registerConfigured(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(MODID, name));
    }

    private static ResourceKey<PlacedFeature> registerPlaced(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, name));
    }

    public static void load() {}
}