package divinerpg.registries;

import com.mojang.serialization.MapCodec;
import divinerpg.world.feature.*;
import divinerpg.world.feature.decoration.*;
import divinerpg.world.feature.ore.OreVein;
import divinerpg.world.feature.ore.OreVeinFeature;
import divinerpg.world.feature.plant.*;
import divinerpg.world.feature.pond.*;
import divinerpg.world.feature.structurelike.*;
import divinerpg.world.feature.tree.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.registries.DeferredHolder;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.DivineRegistries.FEATURES;

public class FeatureRegistry {

    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<Ellipsoid>> ELLIPSOID = FEATURES.register("blob", () -> Ellipsoid.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<NBTFeature>> NBT_FEATURE = FEATURES.register("nbt_feature", () -> NBTFeature.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<OreVein>> ORE_VEIN = FEATURES.register("ore_vein", () -> OreVein.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<OreVeinFeature>> ORE_VEIN_FEATURE = FEATURES.register("ore_vein_feature", () -> OreVeinFeature.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<Bush>> BUSH = FEATURES.register("bush", () -> Bush.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<Spud>> SPUD = FEATURES.register("spud", () -> Spud.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<HorizontalSpud>> HORIZONTAL_SPUD = FEATURES.register("horizontal_spud", () -> HorizontalSpud.CODEC);

    // Overworld
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<DivineTree>> DIVINE_TREE = FEATURES.register("divine_tree", () -> DivineTree.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<KobblinHill>> KOBBLIN_HILL = FEATURES.register("kobblin_hill", () -> KobblinHill.CODEC);

    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<EdenTree>> EDEN_TREE = FEATURES.register("eden_tree", () -> EdenTree.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<WildwoodTree>> WILDWOOD_TREE = FEATURES.register("wildwood_tree", () -> WildwoodTree.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<ApalachiaTree>> APALACHIA_TREE = FEATURES.register("apalachia_tree", () -> ApalachiaTree.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<SkythernTree>> SKYTHERN_TREE = FEATURES.register("skythern_tree", () -> SkythernTree.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<MortumTree>> MORTUM_TREE = FEATURES.register("mortum_tree", () -> MortumTree.CODEC);

    // Eden
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<LandVines>> LAND_VINES = FEATURES.register("land_vines", () -> LandVines.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<Exposure>> EXPOSURE = FEATURES.register("exposure", () -> Exposure.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<Duncap>> DUNCAP = FEATURES.register("duncap", () -> Duncap.CODEC);

    // Iceika
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<ShiverspineTree>> SHIVERSPINE_TREE = FEATURES.register("shiverspine_tree", () -> ShiverspineTree.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<DeadShiverspine>> DEAD_SHIVERSPINE = FEATURES.register("dead_shiverspine", () -> DeadShiverspine.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<AuroraoakTree>> AURORAOAK_TREE = FEATURES.register("auroraoak_tree", () -> AuroraoakTree.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<CozybarkTree>> COZYBARK_TREE = FEATURES.register("cozybark_tree", () -> CozybarkTree.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<CozybarkBush>> COZYBARK_BUSH = FEATURES.register("cozybark_bush", () -> CozybarkBush.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<Stump>> STUMP = FEATURES.register("stump", () -> Stump.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<FractalTree>> FRACTAL_TREE = FEATURES.register("fractal_tree", () -> FractalTree.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<Glowsprout>> GLOWSPROUT = FEATURES.register("glowsprout", () -> Glowsprout.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<Lowsprout>> LOWSPROUT = FEATURES.register("lowsprout", () -> Lowsprout.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<Slowsprout>> SLOWSPROUT = FEATURES.register("slowsprout", () -> Slowsprout.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<StreamleafTree>> STREAMLEAF_TREE = FEATURES.register("streamleaf_tree", () -> StreamleafTree.CODEC);

    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<ThermalVent>> THERMAL_VENT = FEATURES.register("thermal_vent", () -> ThermalVent.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<BrittlePlants>> BRITTLE_PLANTS = FEATURES.register("brittle_plants", () -> BrittlePlants.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<BrittleCavesVegetation>> BRITTLE_CAVES_VEGETATION = FEATURES.register("brittle_caves_vegetation", () -> BrittleCavesVegetation.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<WhaleSkeleton>> WHALE_SKELETON = FEATURES.register("whale_skeleton", () -> WhaleSkeleton.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<SnowCoverage>> SNOW_COVERAGE = FEATURES.register("snow_coverage", () -> SnowCoverage.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<SnowSpreader>> SNOW_SPREADER = FEATURES.register("snow_spreader", () -> SnowSpreader.CODEC);

    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<GemCluster>> GEM_CLUSTER = FEATURES.register("gem_cluster", () -> GemCluster.CODEC);

    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<GeothermalPond>> GEOTHERMAL_POND = FEATURES.register("geothermal_pond", () -> GeothermalPond.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<GlacialPond>> GLACIAL_POND = FEATURES.register("glacial_pond", () -> GlacialPond.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<MineralPond>> MINERAL_POND = FEATURES.register("mineral_pond", () -> MineralPond.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<BrittlePond>> BRITTLE_POND = FEATURES.register("brittle_pond", () -> BrittlePond.CODEC);

    // Arcana
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<ArcanaDungeon>> ARCANA_DUNGEON = FEATURES.register("arcana_dungeon", () -> ArcanaDungeon.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<ArcaniteVines>> ARCANITE_VINES = FEATURES.register("arcanite_vines", () -> ArcaniteVines.CODEC);

    // Vethea
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<FirewoodTree>> FIREWOOD_TREE = FEATURES.register("firewood_tree", () -> FirewoodTree.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<DreamwoodTree>> DREAMWOOD_TREE = FEATURES.register("dreamwood_tree", () -> DreamwoodTree.CODEC);
    public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<Beam>> BEAM = FEATURES.register("beam", () -> Beam.CODEC);

    public static final ResourceKey<Feature> KOBBLIN_HILL_KEY = registerFeature("kobblin_hill");
    public static final ResourceKey<PlacedFeature> KOBBLIN_HILL_PLACED = registerPlaced("kobblin_hill");

    public static final ResourceKey<Feature> TAR_LAKE_KEY = registerFeature("tar_lake");
    public static final ResourceKey<PlacedFeature> TAR_LAKE = registerPlaced("tar_lake");
    public static final ResourceKey<PlacedFeature> TWILIGHT_TAR_LAKE_PLACED_KEY = registerPlaced("twilight_tar_lake");

    public static final ResourceKey<Feature> ARLEMITE_ORE = registerFeature("arlemite_ore");
    public static final ResourceKey<PlacedFeature> ARLEMITE_PLACED = registerPlaced("arlemite");

    public static final ResourceKey<Feature> REALMITE_ORE = registerFeature("realmite_ore");
    public static final ResourceKey<PlacedFeature> REALMITE_PLACED = registerPlaced("realmite");

    public static final ResourceKey<Feature> RUPEE_ORE = registerFeature("rupee_ore");
    public static final ResourceKey<PlacedFeature> RUPEE_PLACED = registerPlaced("rupee");

    public static final ResourceKey<Feature> BLOODGEM_ORE = registerFeature("bloodgem_ore");
    public static final ResourceKey<PlacedFeature> BLOODGEM_ORE_PLACED = registerPlaced("bloodgem_ore_placed");

    public static final ResourceKey<Feature> TORRIDITE_ORE = registerFeature("torridite_ore");
    public static final ResourceKey<PlacedFeature> TORRIDITE_PLACED = registerPlaced("torridite_placed");

    public static final ResourceKey<Feature> REALMITE_VEIN_SMALL = registerFeature("realmite_vein_small");
    public static final ResourceKey<PlacedFeature> REALMITE_VEIN_SMALL_PLACED = registerPlaced("realmite_vein_small");

    public static final ResourceKey<Feature> REALMITE_VEIN_LARGE = registerFeature("realmite_vein_large");
    public static final ResourceKey<PlacedFeature> REALMITE_VEIN_LARGE_PLACED = registerPlaced("realmite_vein_large");

    public static final ResourceKey<Feature> DIVINE_TREE_KEY = registerFeature("divine_tree");
    public static final ResourceKey<PlacedFeature> DIVINE_TREE_PLACED = registerPlaced("divine_tree");

    public static final ResourceKey<Feature> GIANT_DIVINE_TREE = registerFeature("giant_divine_tree");
    public static final ResourceKey<PlacedFeature> GIANT_DIVINE_TREE_PLACED = registerPlaced("giant_divine_tree");

    public static final ResourceKey<Feature> ELLIPSOID_KEY = registerFeature("blob");
    public static final ResourceKey<PlacedFeature> ELLIPSOID_PLACED = registerPlaced("blob");

    public static final ResourceKey<Feature> NBT_FEATURE_KEY = registerFeature("nbt_feature");
    public static final ResourceKey<PlacedFeature> NBT_FEATURE_PLACED = registerPlaced("nbt_feature");

    public static final ResourceKey<Feature> ORE_VEIN_KEY = registerFeature("ore_vein");
    public static final ResourceKey<PlacedFeature> ORE_VEIN_PLACED = registerPlaced("ore_vein");

    public static final ResourceKey<Feature> BUSH_KEY = registerFeature("bush");
    public static final ResourceKey<PlacedFeature> BUSH_PLACED = registerPlaced("bush");

    public static final ResourceKey<Feature> SPUD_KEY = registerFeature("spud");
    public static final ResourceKey<PlacedFeature> SPUD_PLACED = registerPlaced("spud");

    public static final ResourceKey<Feature> HORIZONTAL_SPUD_KEY = registerFeature("horizontal_spud");
    public static final ResourceKey<PlacedFeature> HORIZONTAL_SPUD_PLACED = registerPlaced("horizontal_spud");

    public static final ResourceKey<Feature> EDEN_TREE_KEY = registerFeature("eden_tree");
    public static final ResourceKey<PlacedFeature> EDEN_TREE_PLACED = registerPlaced("eden_tree");

    public static final ResourceKey<Feature> WILDWOOD_TREE_KEY = registerFeature("wildwood_tree");
    public static final ResourceKey<PlacedFeature> WILDWOOD_TREE_PLACED = registerPlaced("wildwood_tree");

    public static final ResourceKey<Feature> APALACHIA_TREE_KEY = registerFeature("apalachia_tree");
    public static final ResourceKey<PlacedFeature> APALACHIA_TREE_PLACED = registerPlaced("apalachia_tree");

    public static final ResourceKey<Feature> SKYTHERN_TREE_KEY = registerFeature("skythern_tree");
    public static final ResourceKey<PlacedFeature> SKYTHERN_TREE_PLACED = registerPlaced("skythern_tree");

    public static final ResourceKey<Feature> MORTUM_TREE_KEY = registerFeature("mortum_tree");
    public static final ResourceKey<PlacedFeature> MORTUM_TREE_PLACED = registerPlaced("mortum_tree");

    public static final ResourceKey<Feature> LAND_VINES_KEY = registerFeature("land_vines");
    public static final ResourceKey<PlacedFeature> LAND_VINES_PLACED = registerPlaced("land_vines");

    public static final ResourceKey<Feature> EXPOSURE_KEY = registerFeature("exposure");
    public static final ResourceKey<PlacedFeature> EXPOSURE_PLACED = registerPlaced("exposure");

    public static final ResourceKey<Feature> DUNCAP_KEY = registerFeature("duncap");
    public static final ResourceKey<PlacedFeature> DUNCAP_PLACED = registerPlaced("duncap");

    public static final ResourceKey<Feature> SHIVERSPINE_TREE_KEY = registerFeature("shiverspine_tree");
    public static final ResourceKey<PlacedFeature> SHIVERSPINE_TREE_PLACED = registerPlaced("shiverspine_tree");

    public static final ResourceKey<Feature> DEAD_SHIVERSPINE_KEY = registerFeature("dead_shiverspine");
    public static final ResourceKey<PlacedFeature> DEAD_SHIVERSPINE_PLACED = registerPlaced("dead_shiverspine");

    public static final ResourceKey<Feature> AURORAOAK_TREE_KEY = registerFeature("auroraoak_tree");
    public static final ResourceKey<PlacedFeature> AURORAOAK_TREE_PLACED = registerPlaced("auroraoak_tree");

    public static final ResourceKey<Feature> COZYBARK_TREE_KEY = registerFeature("cozybark_tree");
    public static final ResourceKey<PlacedFeature> COZYBARK_TREE_PLACED = registerPlaced("cozybark_tree");

    public static final ResourceKey<Feature> COZYBARK_BUSH_KEY = registerFeature("cozybark_bush");
    public static final ResourceKey<PlacedFeature> COZYBARK_BUSH_PLACED = registerPlaced("cozybark_bush");

    public static final ResourceKey<Feature> STUMP_KEY = registerFeature("stump");
    public static final ResourceKey<PlacedFeature> STUMP_PLACED = registerPlaced("stump");

    public static final ResourceKey<Feature> FRACTAL_TREE_KEY = registerFeature("fractal_tree");
    public static final ResourceKey<PlacedFeature> FRACTAL_TREE_PLACED = registerPlaced("fractal_tree");

    public static final ResourceKey<Feature> GLOWSPROUT_KEY = registerFeature("glowsprout");
    public static final ResourceKey<PlacedFeature> GLOWSPROUT_PLACED = registerPlaced("glowsprout");

    public static final ResourceKey<Feature> LOWSPROUT_KEY = registerFeature("lowsprout");
    public static final ResourceKey<PlacedFeature> LOWSPROUT_PLACED = registerPlaced("lowsprout");

    public static final ResourceKey<Feature> SLOWSPROUT_KEY = registerFeature("slowsprout");
    public static final ResourceKey<PlacedFeature> SLOWSPROUT_PLACED = registerPlaced("slowsprout");

    public static final ResourceKey<Feature> STREAMLEAF_TREE_KEY = registerFeature("streamleaf_tree");
    public static final ResourceKey<PlacedFeature> STREAMLEAF_TREE_PLACED = registerPlaced("streamleaf_tree");

    public static final ResourceKey<Feature> THERMAL_VENT_KEY = registerFeature("thermal_vent");
    public static final ResourceKey<PlacedFeature> THERMAL_VENT_PLACED = registerPlaced("thermal_vent");

    public static final ResourceKey<Feature> BRITTLE_PLANTS_KEY = registerFeature("brittle_plants");
    public static final ResourceKey<PlacedFeature> BRITTLE_PLANTS_PLACED = registerPlaced("brittle_plants");

    public static final ResourceKey<Feature> BRITTLE_CAVES_VEGETATION_KEY = registerFeature("brittle_caves_vegetation");
    public static final ResourceKey<PlacedFeature> BRITTLE_CAVES_VEGETATION_PLACED = registerPlaced("brittle_caves_vegetation");

    public static final ResourceKey<Feature> WHALE_SKELETON_KEY = registerFeature("whale_skeleton");
    public static final ResourceKey<PlacedFeature> WHALE_SKELETON_PLACED = registerPlaced("whale_skeleton");

    public static final ResourceKey<Feature> SNOW_COVERAGE_KEY = registerFeature("snow_coverage");
    public static final ResourceKey<PlacedFeature> SNOW_COVERAGE_PLACED = registerPlaced("snow_coverage");

    public static final ResourceKey<Feature> SNOW_SPREADER_KEY = registerFeature("snow_spreader");
    public static final ResourceKey<PlacedFeature> SNOW_SPREADER_PLACED = registerPlaced("snow_spreader");

    public static final ResourceKey<Feature> GEM_CLUSTER_KEY = registerFeature("gem_cluster");
    public static final ResourceKey<PlacedFeature> GEM_CLUSTER_PLACED = registerPlaced("gem_cluster");

    public static final ResourceKey<Feature> GEOTHERMAL_POND_KEY = registerFeature("geothermal_pond");
    public static final ResourceKey<PlacedFeature> GEOTHERMAL_POND_PLACED = registerPlaced("geothermal_pond");

    public static final ResourceKey<Feature> GLACIAL_POND_KEY = registerFeature("glacial_pond");
    public static final ResourceKey<PlacedFeature> GLACIAL_POND_PLACED = registerPlaced("glacial_pond");

    public static final ResourceKey<Feature> MINERAL_POND_KEY = registerFeature("mineral_pond");
    public static final ResourceKey<PlacedFeature> MINERAL_POND_PLACED = registerPlaced("mineral_pond");

    public static final ResourceKey<Feature> BRITTLE_POND_KEY = registerFeature("brittle_pond");
    public static final ResourceKey<PlacedFeature> BRITTLE_POND_PLACED = registerPlaced("brittle_pond");

    public static final ResourceKey<Feature> ARCANA_DUNGEON_KEY = registerFeature("arcana_dungeon");
    public static final ResourceKey<PlacedFeature> ARCANA_DUNGEON_PLACED = registerPlaced("arcana_dungeon");

    public static final ResourceKey<Feature> ARCANITE_VINES_KEY = registerFeature("arcanite_vines");
    public static final ResourceKey<PlacedFeature> ARCANITE_VINES_PLACED = registerPlaced("arcanite_vines");

    public static final ResourceKey<Feature> FIREWOOD_TREE_KEY = registerFeature("firewood_tree");
    public static final ResourceKey<PlacedFeature> FIREWOOD_TREE_PLACED = registerPlaced("firewood_tree");

    public static final ResourceKey<Feature> DREAMWOOD_TREE_KEY = registerFeature("dreamwood_tree");
    public static final ResourceKey<PlacedFeature> DREAMWOOD_TREE_PLACED = registerPlaced("dreamwood_tree");

    public static final ResourceKey<Feature> BEAM_KEY = registerFeature("beam");
    public static final ResourceKey<PlacedFeature> BEAM_PLACED = registerPlaced("beam");

    public static final ResourceKey<Feature> TWILIGHT_STONE_BLOB_KEY = ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(MODID, "twilight_stone_blob"));

    public static final ResourceKey<Feature> APALACHIA_ORE = registerFeature("apalachia_ore");
    public static final ResourceKey<PlacedFeature> APALACHIA_VEGETATION_PATCH_KEY = registerPlaced("apalachia_vegetation_patch");
    public static final ResourceKey<Feature> APALACHIA_VEGETATION_KEY = registerFeature("apalachia_vegetation");
    public static final ResourceKey<PlacedFeature> APALACHIA_ORE_PLACED = registerPlaced("apalachia_ore");
    public static final ResourceKey<PlacedFeature> APALACHIA_VEGETATION_KEY_PLACED = registerPlaced("apalachia_vegetation");


    private static ResourceKey<Feature> registerFeature(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(MODID, name));
    }

    private static ResourceKey<PlacedFeature> registerPlaced(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, name));
    }

    public static void load() {}
}