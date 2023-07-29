package divinerpg.registries;

import divinerpg.*;
import divinerpg.world.feature.*;
import divinerpg.world.feature.config.*;
import divinerpg.world.feature.config.ore.*;
import divinerpg.world.feature.config.tree.TreeConfig;
import divinerpg.world.feature.decoration.*;
import divinerpg.world.feature.ore.OreVein;
import divinerpg.world.feature.plant.*;
import divinerpg.world.feature.pond.*;
import divinerpg.world.feature.structurelike.*;
import divinerpg.world.feature.tree.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.registries.*;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FeatureRegistry {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DivineRPG.MODID);
    
	//Misc
    public static final RegistryObject<Feature<EllipsoidConfig>> ELLIPSOID = FEATURES.register("blob", () -> new Ellipsoid());
    public static final RegistryObject<Feature<NBTFeatureConfig>> NBT_FEATURE = FEATURES.register("nbt_feature", () -> new NBTFeature());
    public static final RegistryObject<Feature<OreVeinConfig>> ORE_VEIN = FEATURES.register("ore_vein", () -> new OreVein());
    public static final RegistryObject<Feature<TreeConfig>> BUSH = FEATURES.register("bush", () -> new Bush());
	
    //Overworld
    public static final RegistryObject<Feature<TreeConfig>> DIVINE_TREE = FEATURES.register("divine_tree", () -> new DivineTree());
    
    //Twilight
    public static final RegistryObject<Feature<TreeConfig>>
    	EDEN_TREE = FEATURES.register("eden_tree", () -> new EdenTree()),
    	WILDWOOD_TREE = FEATURES.register("wildwood_tree", () -> new WildwoodTree()),
    	APALACHIA_TREE = FEATURES.register("apalachia_tree", () -> new ApalachiaTree()),
    	SKYTHERN_TREE = FEATURES.register("skythern_tree", () -> new SkythernTree()),
    	MORTUM_TREE = FEATURES.register("mortum_tree", () -> new MortumTree());
    
    //Iceika
    public static final RegistryObject<Feature<TreeConfig>>
    	SHIVERSPINE_TREE = FEATURES.register("shiverspine_tree", () -> new ShiverspineTree()),
    	AURORAOAK_TREE = FEATURES.register("auroraoak_tree", () -> new AuroraoakTree());
    public static final RegistryObject<Feature<NoneFeatureConfiguration>>
    	THERMAL_VENT = FEATURES.register("thermal_vent", () -> new ThermalVent()),
    	BRITTLE_PLANTS = FEATURES.register("brittle_plants", () -> new BrittlePlants()),
    	BRITTLE_CAVES_VEGETATION = FEATURES.register("brittle_caves_vegetation", () -> new BrittleCavesVegetation()),
    	WHALE_SKELETON = FEATURES.register("whale_skeleton", () -> new WhaleSkeleton());
	public static final RegistryObject<Feature<PointedDripstoneConfiguration>> ICICLE = FEATURES.register("icicle", () -> new Icicle());
    public static final RegistryObject<Feature<RuleTestConfig>>
    	GEOTHERMAL_POND = FEATURES.register("geothermal_pond", () -> new GeothermalPond()),
    	GLACIAL_POND = FEATURES.register("glacial_pond", () -> new GlacialPond()),
    	BRITTLE_POND = FEATURES.register("brittle_pond", () -> new BrittlePond()),
    	FROZEN_LIGHT = FEATURES.register("frozen_light", () -> new FrozenLight());
    
    //Arcana
    public static final RegistryObject<Feature<NoneFeatureConfiguration>>
    	ARCANA_DUNGEON = FEATURES.register("arcana_dungeon", () -> new ArcanaDungeon()),
    	ARCANITE_VINES = FEATURES.register("arcanite_vines", () -> new ArcaniteVines());
    
    //Vethea
    public static final RegistryObject<Feature<TreeConfig>>
    	FIREWOOD_TREE = FEATURES.register("firewood_tree", () -> new FirewoodTree()),
    	DREAMWOOD_TREE = FEATURES.register("dreamwood_tree", () -> new DreamwoodTree());
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> BEAM = FEATURES.register("beam", () -> new Beam());
}