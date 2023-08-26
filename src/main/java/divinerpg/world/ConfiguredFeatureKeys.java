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
import net.minecraftforge.registries.ForgeRegistries;


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
			AURORAOAK_TREE = registerKey("auroraoak_tree"),
			COZYBARK_TREE = registerKey("cozybark_tree"),
			SHIVERSPINE_BUSH = registerKey("shiverspine_bush"),
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
		register(context, DIVINE_TREE, FeatureRegistry.DIVINE_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, TAR_LAKE, Feature.LAKE, new Configuration(BlockStateProvider.simple(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "smoldering_tar"))), BlockStateProvider.simple(Blocks.STONE)));

		//Twilight
		register(context, TWILIGHT_TAR_LAKE, Feature.LAKE, new Configuration(BlockStateProvider.simple(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "smoldering_tar"))), BlockStateProvider.simple(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "twilight_stone")))));
		register(context, EDEN_TREE, FeatureRegistry.EDEN_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, EDEN_BUSH, FeatureRegistry.BUSH.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, WILDWOOD_TREE, FeatureRegistry.WILDWOOD_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, APALACHIA_TREE, FeatureRegistry.APALACHIA_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, SKYTHERN_TREE, FeatureRegistry.SKYTHERN_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, SKYTHERN_BUSH, FeatureRegistry.BUSH.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, MORTUM_TREE, FeatureRegistry.MORTUM_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, MORTUM_BUSH, FeatureRegistry.BUSH.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));

		//Iceika
		register(context, SHIVERSPINE_TREE, FeatureRegistry.SHIVERSPINE_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "shiverspine_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, AURORAOAK_TREE, FeatureRegistry.AURORAOAK_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "auroraoak_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "auroraoak_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, COZYBARK_TREE, FeatureRegistry.COZYBARK_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "cozybark_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "cozybark_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, SHIVERSPINE_BUSH, FeatureRegistry.BUSH.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "shiverspine_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, GEOTHERMAL_POND, FeatureRegistry.GEOTHERMAL_POND.get(), new RuleTestConfig(ImmutableList.of()));
		register(context, GLACIAL_POND, FeatureRegistry.GLACIAL_POND.get(), new RuleTestConfig(ImmutableList.of()));
		register(context, BRITTLE_POND, FeatureRegistry.BRITTLE_POND.get(), new RuleTestConfig(ImmutableList.of()));
		register(context, THERMAL_VENT, FeatureRegistry.THERMAL_VENT.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, FROZEN_LIGHT, FeatureRegistry.FROZEN_LIGHT.get(), new RuleTestConfig(ImmutableList.of()));
		register(context, BRITTLE_PLANTS, FeatureRegistry.BRITTLE_PLANTS.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, BRITTLE_CAVES_VEGETATION, FeatureRegistry.BRITTLE_CAVES_VEGETATION.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, WHALE_SKELETON, FeatureRegistry.WHALE_SKELETON.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, SNOW_COVERAGE, FeatureRegistry.SNOW_COVERAGE.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, SNOW_SPREADER, FeatureRegistry.SNOW_SPREADER.get(), NoneFeatureConfiguration.INSTANCE);

		//Arcana
		register(context, ARCANA_DUNGEON, FeatureRegistry.ARCANA_DUNGEON.get(), NoneFeatureConfiguration.INSTANCE);
		register(context, ARCANA_TAR_LAKE, Feature.LAKE, new Configuration(BlockStateProvider.simple(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "smoldering_tar"))), BlockStateProvider.simple(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_sludge_breakable")))));
		register(context, ARCANITE_VINES, FeatureRegistry.ARCANITE_VINES.get(), NoneFeatureConfiguration.INSTANCE);

		//Vethea
		register(context, DREAM_ASTEROID, FeatureRegistry.ELLIPSOID.get(), new EllipsoidConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_stone")).defaultBlockState(), 2, 7, ImmutableList.of()));
		register(context, DREAM_ASTEROID_SMALL, FeatureRegistry.ELLIPSOID.get(), new EllipsoidConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_stone")).defaultBlockState(), 1, 2, ImmutableList.of()));
		register(context, FIREWOOD_TREE, FeatureRegistry.FIREWOOD_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "firewood_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "firewood_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, DREAMWOOD_TREE, FeatureRegistry.DREAMWOOD_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dreamwood_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dreamwood_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, HYREWOOD_TREE, FeatureRegistry.DREAMWOOD_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "hyrewood_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "hyrewood_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
		register(context, MINTWOOD_TREE, FeatureRegistry.FIREWOOD_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mintwood_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mintwood_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()));
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