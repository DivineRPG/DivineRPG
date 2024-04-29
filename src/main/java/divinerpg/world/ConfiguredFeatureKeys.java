package divinerpg.world;

import com.google.common.collect.ImmutableList;
import divinerpg.DivineRPG;
import divinerpg.registries.FeatureRegistry;
import divinerpg.world.feature.config.*;
import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.*;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.LakeFeature.Configuration;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.fml.common.Mod;

import static divinerpg.util.Utils.*;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ConfiguredFeatureKeys {
	private ConfiguredFeatureKeys() {}

	//Overworld
	public static final ResourceKey<ConfiguredFeature<?, ?>> DIVINE_TREE = registerKey("divine_tree"),
			TAR_LAKE = registerKey("tar_lake");

	//Twilight
	public static final ResourceKey<ConfiguredFeature<?, ?>> TWILIGHT_TAR_LAKE = registerKey("twilight_tar_lake"),
			EDEN_TREE = registerKey("eden_tree"),
			EDEN_BUSH = registerKey("eden_bush"),
			WILDWOOD_TREE = registerKey("wildwood_tree"),
			APALACHIA_TREE = registerKey("apalachia_tree"),
			SKYTHERN_TREE = registerKey("skythern_tree"),
			SKYTHERN_BUSH = registerKey("skythern_bush"),
			MORTUM_TREE = registerKey("mortum_tree"),
			MORTUM_BUSH = registerKey("mortum_bush");

	//Iceika
	public static final ResourceKey<ConfiguredFeature<?, ?>>
			SHIVERSPINE_TREE = registerKey("shiverspine_tree"),
			DEAD_SHIVERSPINE = registerKey("dead_shiverspine"),
			AURORAOAK_TREE = registerKey("auroraoak_tree"),
			COZYBARK_TREE = registerKey("cozybark_tree"),
			COZYBARK_STUMP = registerKey("cozybark_stump"),
			FRACTAL_TREE = registerKey("fractal_tree"),
			STREAMLEAF_TREE = registerKey("streamleaf_tree"),
			GLOWSPROUT = registerKey("glowsprout"),
			LOWSPROUT = registerKey("lowsprout"),
			SLOWSPROUT = registerKey("slowsprout"),
			SHIVERSPINE_BUSH = registerKey("shiverspine_bush"),
			COZYBARK_BUSH = registerKey("cozybark_bush"),
			GEOTHERMAL_POND = registerKey("geothermal_pond"),
			GLACIAL_POND = registerKey("glacial_pond"),
			BRITTLE_POND = registerKey("brittle_pond"),
			THERMAL_VENT = registerKey("thermal_vent"),
			FROZEN_LIGHT = registerKey("frozen_light"),
			BRITTLE_PLANTS = registerKey("brittle_plants"),
			BRITTLE_CAVES_VEGETATION = registerKey("brittle_caves_vegetation"),
			WHALE_SKELETON = registerKey("whale_skeleton"),
			SNOW_COVERAGE = registerKey("snow_coverage"),
			SNOW_SPREADER = registerKey("snow_spreader");

	//Arcana
	public static final ResourceKey<ConfiguredFeature<?, ?>> ARCANA_DUNGEON = registerKey("arcana_dungeon"),
			ARCANA_TAR_LAKE = registerKey("arcana_tar_lake"),
			ARCANITE_VINES = registerKey("arcanite_vines");

	//Vethea
	public static final ResourceKey<ConfiguredFeature<?, ?>> DREAM_ASTEROID = registerKey("dream_asteroid"),
			DREAM_ASTEROID_SMALL = registerKey("dream_asteroid_small"),
			FIREWOOD_TREE = registerKey("firewood_tree"),
			DREAMWOOD_TREE = registerKey("dreamwood_tree"),
			HYREWOOD_TREE = registerKey("hyrewood_tree"),
			MINTWOOD_TREE = registerKey("mintwood_tree"),
			BEAM = registerKey("beam");

	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DivineRPG.MODID, name));
	}
	
	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		//Overworld
		register(context, DIVINE_TREE, FeatureRegistry.DIVINE_TREE.get(), new TreeConfig(getBlockState("divine_log"), getBlockState("divine_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, TAR_LAKE, Feature.LAKE, new Configuration(BlockStateProvider.simple(getBlock("smoldering_tar")), BlockStateProvider.simple(Blocks.STONE)));

		//Twilight
		register(context, TWILIGHT_TAR_LAKE, Feature.LAKE, new Configuration(BlockStateProvider.simple(getBlock("smoldering_tar")), BlockStateProvider.simple(getBlock("twilight_stone"))));
		register(context, EDEN_TREE, FeatureRegistry.EDEN_TREE.get(), new TreeConfig(getBlockState("eden_log"), getBlockState("eden_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, EDEN_BUSH, FeatureRegistry.BUSH.get(), new TreeConfig(getBlockState("eden_log"), getBlockState("eden_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, WILDWOOD_TREE, FeatureRegistry.WILDWOOD_TREE.get(), new TreeConfig(getBlockState("wildwood_log"), getBlockState("wildwood_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, APALACHIA_TREE, FeatureRegistry.APALACHIA_TREE.get(), new TreeConfig(getBlockState("apalachia_log"), getBlockState("apalachia_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, SKYTHERN_TREE, FeatureRegistry.SKYTHERN_TREE.get(), new TreeConfig(getBlockState("skythern_log"), getBlockState("skythern_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, SKYTHERN_BUSH, FeatureRegistry.BUSH.get(), new TreeConfig(getBlockState("skythern_log"), getBlockState("skythern_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, MORTUM_TREE, FeatureRegistry.MORTUM_TREE.get(), new TreeConfig(getBlockState("mortum_log"), getBlockState("mortum_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, MORTUM_BUSH, FeatureRegistry.BUSH.get(), new TreeConfig(getBlockState("mortum_log"), getBlockState("mortum_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));

		//Iceika
		register(context, SHIVERSPINE_TREE, FeatureRegistry.SHIVERSPINE_TREE.get(), new TreeConfig(getBlockState("shiverspine_log"), getBlockState("brittle_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, DEAD_SHIVERSPINE, FeatureRegistry.DEAD_SHIVERSPINE.get(), new TreeConfig(getBlockState("shiverspine_log"), Blocks.DIRT.defaultBlockState(), ImmutableList.of()));
		register(context, AURORAOAK_TREE, FeatureRegistry.AURORAOAK_TREE.get(), new TreeConfig(getBlockState("auroraoak_log"), getBlockState("auroraoak_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, COZYBARK_TREE, FeatureRegistry.COZYBARK_TREE.get(), new TreeConfig(getBlockState("cozybark_log"), getBlockState("cozybark_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, COZYBARK_STUMP, FeatureRegistry.STUMP.get(), new TreeConfig(getBlockState("cozybark_log"), getBlockState("roofbell"), ImmutableList.of()));
		register(context, GLOWSPROUT, FeatureRegistry.GLOWSPROUT.get(), new TreeConfig(getBlockState("glowsprout_stem"), getBlockState("glowsprout_bulb"), ImmutableList.of()));
		register(context, LOWSPROUT, FeatureRegistry.LOWSPROUT.get(), new TreeConfig(getBlockState("lowsprout_stem"), getBlockState("lowsprout_bulb"), ImmutableList.of()));
		register(context, SLOWSPROUT, FeatureRegistry.SLOWSPROUT.get(), new TreeConfig(getBlockState("slowsprout_stem"), getBlockState("slowsprout_bulb"), ImmutableList.of()));
		register(context, SHIVERSPINE_BUSH, FeatureRegistry.BUSH.get(), new TreeConfig(getBlockState("shiverspine_log"), getBlockState("brittle_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, COZYBARK_BUSH, FeatureRegistry.COZYBARK_BUSH.get(), new TreeConfig(getBlockState("cozybark_log"), getBlockState("cozybark_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, STREAMLEAF_TREE, FeatureRegistry.STREAMLEAF_TREE.get(), new TreeConfig(getBlockState("streamleaf_log"), getBlockState("streamleaf_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, GEOTHERMAL_POND, FeatureRegistry.GEOTHERMAL_POND.get(), new RuleTestConfig(ImmutableList.of()));
		register(context, GLACIAL_POND, FeatureRegistry.GLACIAL_POND.get(), new RuleTestConfig(ImmutableList.of()));
		register(context, BRITTLE_POND, FeatureRegistry.BRITTLE_POND.get(), new RuleTestConfig(ImmutableList.of()));
		register(context, THERMAL_VENT, FeatureRegistry.THERMAL_VENT.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, BRITTLE_PLANTS, FeatureRegistry.BRITTLE_PLANTS.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, BRITTLE_CAVES_VEGETATION, FeatureRegistry.BRITTLE_CAVES_VEGETATION.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, WHALE_SKELETON, FeatureRegistry.WHALE_SKELETON.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, SNOW_COVERAGE, FeatureRegistry.SNOW_COVERAGE.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, SNOW_SPREADER, FeatureRegistry.SNOW_SPREADER.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, FRACTAL_TREE, FeatureRegistry.FRACTAL_TREE.get(), new TreeConfig(Blocks.PACKED_ICE.defaultBlockState(), Blocks.ICE.defaultBlockState(), ImmutableList.of()));

		//Arcana
		register(context, ARCANA_DUNGEON, FeatureRegistry.ARCANA_DUNGEON.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, ARCANA_TAR_LAKE, Feature.LAKE, new Configuration(BlockStateProvider.simple(getBlock("smoldering_tar")), BlockStateProvider.simple(getBlock("soul_sludge_breakable"))));
		register(context, ARCANITE_VINES, FeatureRegistry.ARCANITE_VINES.get(), NoneFeatureConfiguration.INSTANCE);

		//Vethea
		register(context, DREAM_ASTEROID, FeatureRegistry.ELLIPSOID.get(), new EllipsoidConfig(BlockStateProvider.simple(getBlock("dream_stone")), 2, 7, ImmutableList.of()));
		register(context, DREAM_ASTEROID_SMALL, FeatureRegistry.ELLIPSOID.get(), new EllipsoidConfig(BlockStateProvider.simple(getBlock("dream_stone")), 1, 2, ImmutableList.of()));
		register(context, FIREWOOD_TREE, FeatureRegistry.FIREWOOD_TREE.get(), new TreeConfig(getBlockState("firewood_log"), getBlockState("firewood_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, DREAMWOOD_TREE, FeatureRegistry.DREAMWOOD_TREE.get(), new TreeConfig(getBlockState("dreamwood_log"), getBlockState("dreamwood_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, HYREWOOD_TREE, FeatureRegistry.DREAMWOOD_TREE.get(), new TreeConfig(getBlockState("hyrewood_log"), getBlockState("hyrewood_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, MINTWOOD_TREE, FeatureRegistry.FIREWOOD_TREE.get(), new TreeConfig(getBlockState("mintwood_log"), getBlockState("mintwood_leaves").setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, BEAM, FeatureRegistry.BEAM.get(), NoneFeatureConfiguration.INSTANCE);

	}

	public static void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, Feature<NoneFeatureConfiguration> feature) {
		register(context, key, feature, FeatureConfiguration.NONE);
	}

	public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}
	
	public static Reference<ConfiguredFeature<?, ?>> getConfiguredFeature(WorldGenLevel level, ResourceKey<ConfiguredFeature<?, ?>> key){
		return level.getServer().registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(key).get();
	}
}