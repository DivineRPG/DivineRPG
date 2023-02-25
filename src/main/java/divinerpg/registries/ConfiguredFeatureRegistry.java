package divinerpg.registries;

import com.google.common.collect.ImmutableList;

import divinerpg.DivineRPG;
import divinerpg.world.feature.config.*;
import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.LakeFeature.Configuration;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ConfiguredFeatureRegistry {
	private ConfiguredFeatureRegistry() {}
	public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DivineRPG.MODID);
	
	//Overworld
    public static final RegistryObject<ConfiguredFeature<?, ?>>
    	DIVINE_TREE = CONFIGURED_FEATURES.register("divine_tree", () -> new ConfiguredFeature<>(FeatureRegistry.DIVINE_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
    	TAR_LAKE = CONFIGURED_FEATURES.register("tar_lake", () -> new ConfiguredFeature<>(Feature.LAKE, new Configuration(BlockStateProvider.simple(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "smoldering_tar"))), BlockStateProvider.simple(Blocks.STONE))));
	
	//Twilight
	public static final RegistryObject<ConfiguredFeature<?, ?>>
		TWILIGHT_TAR_LAKE = CONFIGURED_FEATURES.register("twilight_tar_lake", () -> new ConfiguredFeature<>(Feature.LAKE, new Configuration(BlockStateProvider.simple(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "smoldering_tar"))), BlockStateProvider.simple(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "twilight_stone")))))),
		EDEN_TREE = CONFIGURED_FEATURES.register("eden_tree", () -> new ConfiguredFeature<>(FeatureRegistry.EDEN_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		EDEN_BUSH = CONFIGURED_FEATURES.register("eden_bush", () -> new ConfiguredFeature<>(FeatureRegistry.BUSH.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		WILDWOOD_TREE = CONFIGURED_FEATURES.register("wildwood_tree", () -> new ConfiguredFeature<>(FeatureRegistry.WILDWOOD_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		APALACHIA_TREE = CONFIGURED_FEATURES.register("apalachia_tree", () -> new ConfiguredFeature<>(FeatureRegistry.APALACHIA_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		SKYTHERN_TREE = CONFIGURED_FEATURES.register("skythern_tree", () -> new ConfiguredFeature<>(FeatureRegistry.SKYTHERN_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		SKYTHERN_BUSH = CONFIGURED_FEATURES.register("skythern_bush", () -> new ConfiguredFeature<>(FeatureRegistry.BUSH.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		MORTUM_TREE = CONFIGURED_FEATURES.register("mortum_tree", () -> new ConfiguredFeature<>(FeatureRegistry.MORTUM_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		MORTUM_BUSH = CONFIGURED_FEATURES.register("mortum_bush", () -> new ConfiguredFeature<>(FeatureRegistry.BUSH.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of())));
	
	//Iceika
	public static final RegistryObject<ConfiguredFeature<?, ?>>
		FROZEN_TREE = CONFIGURED_FEATURES.register("frozen_tree", () -> new ConfiguredFeature<>(FeatureRegistry.FROZEN_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		FROZEN_BUSH = CONFIGURED_FEATURES.register("frozen_bush", () -> new ConfiguredFeature<>(FeatureRegistry.BUSH.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		GEOTHERMAL_POND = CONFIGURED_FEATURES.register("geothermal_pond", () -> new ConfiguredFeature<>(FeatureRegistry.GEOTHERMAL_POND.get(), new RuleTestConfig(ImmutableList.of()))),
		GLACIAL_POND = CONFIGURED_FEATURES.register("glacial_pond", () -> new ConfiguredFeature<>(FeatureRegistry.GLACIAL_POND.get(), new RuleTestConfig(ImmutableList.of()))),
		BRITTLE_POND = CONFIGURED_FEATURES.register("brittle_pond", () -> new ConfiguredFeature<>(FeatureRegistry.BRITTLE_POND.get(), new RuleTestConfig(ImmutableList.of()))),
		THERMAL_VENT = CONFIGURED_FEATURES.register("thermal_vent", () -> new ConfiguredFeature<>(FeatureRegistry.THERMAL_VENT.get(), NoneFeatureConfiguration.INSTANCE)),
		FROZEN_LIGHT = CONFIGURED_FEATURES.register("frozen_light", () -> new ConfiguredFeature<>(FeatureRegistry.FROZEN_LIGHT.get(), new RuleTestConfig(ImmutableList.of()))),
		BRITTLE_PLANTS = CONFIGURED_FEATURES.register("brittle_plants", () -> new ConfiguredFeature<>(FeatureRegistry.BRITTLE_PLANTS.get(), NoneFeatureConfiguration.INSTANCE)),
		BRITTLE_CAVES_VEGETATION = CONFIGURED_FEATURES.register("brittle_caves_vegetation", () -> new ConfiguredFeature<>(FeatureRegistry.BRITTLE_CAVES_VEGETATION.get(), NoneFeatureConfiguration.INSTANCE));

	//Arcana
	public static final RegistryObject<ConfiguredFeature<?, ?>>
		ARCANA_DUNGEON = CONFIGURED_FEATURES.register("arcana_dungeon", () -> new ConfiguredFeature<>(FeatureRegistry.ARCANA_DUNGEON.get(), NoneFeatureConfiguration.INSTANCE)),
		ARCANA_TAR_LAKE = CONFIGURED_FEATURES.register("arcana_tar_lake", () -> new ConfiguredFeature<>(Feature.LAKE, new Configuration(BlockStateProvider.simple(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "smoldering_tar"))), BlockStateProvider.simple(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_sludge_breakable")))))),
		GEM_OF_THE_DUNES = CONFIGURED_FEATURES.register("gem_of_the_dunes", () -> new ConfiguredFeature<>(FeatureRegistry.GEM_OF_THE_DUNES.get(), NoneFeatureConfiguration.INSTANCE)),
		ARCANITE_VINES = CONFIGURED_FEATURES.register("arcanite_vines", () -> new ConfiguredFeature<>(FeatureRegistry.ARCANITE_VINES.get(), NoneFeatureConfiguration.INSTANCE));
	
	//Vethea
	public static final RegistryObject<ConfiguredFeature<?, ?>>
		DREAM_ASTEROID = CONFIGURED_FEATURES.register("dream_asteroid", () -> new ConfiguredFeature<>(FeatureRegistry.ELLIPSOID.get(), new EllipsoidConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_stone")).defaultBlockState(), 2, 7, ImmutableList.of()))),
		DREAM_ASTEROID_SMALL = CONFIGURED_FEATURES.register("dream_asteroid_small", () -> new ConfiguredFeature<>(FeatureRegistry.ELLIPSOID.get(), new EllipsoidConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_stone")).defaultBlockState(), 1, 2, ImmutableList.of()))),
		FIREWOOD_TREE = CONFIGURED_FEATURES.register("firewood_tree", () -> new ConfiguredFeature<>(FeatureRegistry.FIREWOOD_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "firewood_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "firewood_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		DREAMWOOD_TREE = CONFIGURED_FEATURES.register("dreamwood_tree", () -> new ConfiguredFeature<>(FeatureRegistry.DREAMWOOD_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dreamwood_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dreamwood_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		HYREWOOD_TREE = CONFIGURED_FEATURES.register("hyrewood_tree", () -> new ConfiguredFeature<>(FeatureRegistry.DREAMWOOD_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "hyrewood_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "hyrewood_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		MINTWOOD_TREE = CONFIGURED_FEATURES.register("mintwood_tree", () -> new ConfiguredFeature<>(FeatureRegistry.FIREWOOD_TREE.get(), new TreeConfig(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mintwood_log")).defaultBlockState(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mintwood_leaves")).defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), ImmutableList.of()))),
		BEAM = CONFIGURED_FEATURES.register("beam", () -> new ConfiguredFeature<>(FeatureRegistry.BEAM.get(), NoneFeatureConfiguration.INSTANCE));
}