package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.world.feature.*;
import divinerpg.world.feature.config.*;
import divinerpg.world.feature.config.decoration.*;
import divinerpg.world.feature.config.ore.OreVeinConfig;
import divinerpg.world.feature.config.tree.TreeConfig;
import divinerpg.world.feature.decoration.*;
import divinerpg.world.feature.ore.OreVein;
import divinerpg.world.feature.plant.*;
import divinerpg.world.feature.pond.*;
import divinerpg.world.feature.structurelike.*;
import divinerpg.world.feature.tree.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.neoforged.neoforge.registries.*;

public class FeatureRegistry {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, DivineRPG.MODID);
    
	//Misc
    public static final DeferredHolder<Feature<?>, Feature<EllipsoidConfig>> ELLIPSOID = FEATURES.register("blob", Ellipsoid::new);
    public static final DeferredHolder<Feature<?>, Feature<NBTFeatureConfig>> NBT_FEATURE = FEATURES.register("nbt_feature", NBTFeature::new);
    public static final DeferredHolder<Feature<?>, Feature<OreVeinConfig>> ORE_VEIN = FEATURES.register("ore_vein", OreVein::new);
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>> BUSH = FEATURES.register("bush", Bush::new);
	
    //Overworld
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>> DIVINE_TREE = FEATURES.register("divine_tree", DivineTree::new);
    
    //Twilight
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>>
    	EDEN_TREE = FEATURES.register("eden_tree", EdenTree::new),
    	WILDWOOD_TREE = FEATURES.register("wildwood_tree", WildwoodTree::new),
    	APALACHIA_TREE = FEATURES.register("apalachia_tree", ApalachiaTree::new),
    	SKYTHERN_TREE = FEATURES.register("skythern_tree", SkythernTree::new),
    	MORTUM_TREE = FEATURES.register("mortum_tree", MortumTree::new);
    
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
	public static final DeferredHolder<Feature<?>, Feature<PointedDripstoneConfiguration>> ICICLE = FEATURES.register("icicle", Icicle::new);
	public static final DeferredHolder<Feature<?>, Feature<GemClusterConfig>> GEM_CLUSTER = FEATURES.register("gem_cluster", GemCluster::new);
	public static final DeferredHolder<Feature<?>, Feature<SpudConfig>> SPUD = FEATURES.register("spud", Spud::new);
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
}