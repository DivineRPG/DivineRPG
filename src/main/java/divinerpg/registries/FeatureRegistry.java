package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.world.feature.Ellipsoid;
import divinerpg.world.feature.NBTFeature;
import divinerpg.world.feature.config.EllipsoidConfig;
import divinerpg.world.feature.config.NBTFeatureConfig;
import divinerpg.world.feature.config.RuleTestConfig;
import divinerpg.world.feature.config.decoration.GemClusterConfig;
import divinerpg.world.feature.config.decoration.SpudConfig;
import divinerpg.world.feature.config.ore.OreVeinConfig;
import divinerpg.world.feature.config.tree.TreeConfig;
import divinerpg.world.feature.decoration.*;
import divinerpg.world.feature.ore.OreVein;
import divinerpg.world.feature.plant.ArcaniteVines;
import divinerpg.world.feature.plant.BrittleCavesVegetation;
import divinerpg.world.feature.plant.BrittlePlants;
import divinerpg.world.feature.plant.Bush;
import divinerpg.world.feature.pond.BrittlePond;
import divinerpg.world.feature.pond.GeothermalPond;
import divinerpg.world.feature.pond.GlacialPond;
import divinerpg.world.feature.pond.MineralPond;
import divinerpg.world.feature.structurelike.ArcanaDungeon;
import divinerpg.world.feature.structurelike.Beam;
import divinerpg.world.feature.tree.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.PointedDripstoneConfiguration;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static divinerpg.DivineRPG.MODID;

@EventBusSubscriber(modid = MODID)
public class FeatureRegistry {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, DivineRPG.MODID);
    
	//Misc
    public static final DeferredHolder<Feature<?>, Feature<EllipsoidConfig>> ELLIPSOID = FEATURES.register("blob", () -> new Ellipsoid());
    public static final DeferredHolder<Feature<?>, Feature<NBTFeatureConfig>> NBT_FEATURE = FEATURES.register("nbt_feature", () -> new NBTFeature());
    public static final DeferredHolder<Feature<?>, Feature<OreVeinConfig>> ORE_VEIN = FEATURES.register("ore_vein", () -> new OreVein());
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>> BUSH = FEATURES.register("bush", () -> new Bush());
	
    //Overworld
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>> DIVINE_TREE = FEATURES.register("divine_tree", () -> new DivineTree());
    
    //Twilight
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>>
    	EDEN_TREE = FEATURES.register("eden_tree", () -> new EdenTree()),
    	WILDWOOD_TREE = FEATURES.register("wildwood_tree", () -> new WildwoodTree()),
    	APALACHIA_TREE = FEATURES.register("apalachia_tree", () -> new ApalachiaTree()),
    	SKYTHERN_TREE = FEATURES.register("skythern_tree", () -> new SkythernTree()),
    	MORTUM_TREE = FEATURES.register("mortum_tree", () -> new MortumTree());
    
    //Iceika
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>>
    	SHIVERSPINE_TREE = FEATURES.register("shiverspine_tree", () -> new ShiverspineTree()),
    	DEAD_SHIVERSPINE = FEATURES.register("dead_shiverspine", () -> new DeadShiverspine()),
    	AURORAOAK_TREE = FEATURES.register("auroraoak_tree", () -> new AuroraoakTree()),
    	COZYBARK_TREE = FEATURES.register("cozybark_tree", () -> new CozybarkTree()),
    	COZYBARK_BUSH = FEATURES.register("cozybark_bush", () -> new CozybarkBush()),
    	STUMP = FEATURES.register("stump", () -> new Stump()),
    	FRACTAL_TREE = FEATURES.register("fractal_tree", () -> new FractalTree()),
    	GLOWSPROUT = FEATURES.register("glowsprout", () -> new Glowsprout()),
    	LOWSPROUT = FEATURES.register("lowsprout", () -> new Lowsprout()),
    	SLOWSPROUT = FEATURES.register("slowsprout", () -> new Slowsprout()),
    	STREAMLEAF_TREE = FEATURES.register("streamleaf_tree", () -> new StreamleafTree());
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>>
    	THERMAL_VENT = FEATURES.register("thermal_vent", () -> new ThermalVent()),
    	BRITTLE_PLANTS = FEATURES.register("brittle_plants", () -> new BrittlePlants()),
    	BRITTLE_CAVES_VEGETATION = FEATURES.register("brittle_caves_vegetation", () -> new BrittleCavesVegetation()),
    	WHALE_SKELETON = FEATURES.register("whale_skeleton", () -> new WhaleSkeleton()),
    	SNOW_COVERAGE = FEATURES.register("snow_coverage", () -> new SnowCoverage()),
    	SNOW_SPREADER = FEATURES.register("snow_spreader", () -> new SnowSpreader());
	public static final DeferredHolder<Feature<?>, Feature<PointedDripstoneConfiguration>> ICICLE = FEATURES.register("icicle", () -> new Icicle());
	public static final DeferredHolder<Feature<?>, Feature<GemClusterConfig>> GEM_CLUSTER = FEATURES.register("gem_cluster", () -> new GemCluster());
	public static final DeferredHolder<Feature<?>, Feature<SpudConfig>> SPUD = FEATURES.register("spud", () -> new Spud());
    public static final DeferredHolder<Feature<?>, Feature<RuleTestConfig>>
    	GEOTHERMAL_POND = FEATURES.register("geothermal_pond", () -> new GeothermalPond()),
    	GLACIAL_POND = FEATURES.register("glacial_pond", () -> new GlacialPond()),
    	MINERAL_POND = FEATURES.register("mineral_pond", () -> new MineralPond()),
    	BRITTLE_POND = FEATURES.register("brittle_pond", () -> new BrittlePond());
    
    //Arcana
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>>
    	ARCANA_DUNGEON = FEATURES.register("arcana_dungeon", () -> new ArcanaDungeon()),
    	ARCANITE_VINES = FEATURES.register("arcanite_vines", () -> new ArcaniteVines());
    
    //Vethea
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>>
    	FIREWOOD_TREE = FEATURES.register("firewood_tree", () -> new FirewoodTree()),
    	DREAMWOOD_TREE = FEATURES.register("dreamwood_tree", () -> new DreamwoodTree());
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> BEAM = FEATURES.register("beam", () -> new Beam());
}