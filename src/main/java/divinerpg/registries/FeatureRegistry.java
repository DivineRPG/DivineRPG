package divinerpg.registries;

import divinerpg.*;
import divinerpg.config.*;
import divinerpg.world.gen.tree.feature.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.common.world.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.registries.*;

import java.util.*;
import java.util.function.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID)
public class FeatureRegistry {
    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DivineRPG.MODID);
    public static final RegistryObject<DivineTreeFeature> EDEN_TREE = register("eden_tree", () -> new EdenTreeFeature(() -> BlockRegistry.edenSapling));
    public static final RegistryObject<DivineTreeFeature> WILDWOOD_TREE = register("wildwood_tree", () -> new WildwoodTreeFeature(() -> BlockRegistry.wildwoodSapling));
    public static final RegistryObject<DivineTreeFeature> APALACHIA_TREE = register("apalachia_tree", () -> new ApalachiaTreeFeature(() -> BlockRegistry.apalachiaSapling));
    public static final RegistryObject<DivineTreeFeature> SKYTHERN_TREE = register("skythern_tree", () -> new SkythernTreeFeature(() -> BlockRegistry.skythernSapling));
    public static final RegistryObject<DivineTreeFeature> MORTUM_TREE = register("mortum_tree", () -> new MortumTreeFeature(() -> BlockRegistry.mortumSapling));
    public static final RegistryObject<MortumPlants> MORTUM_BRUSH = register("mortum_plants", () -> new MortumPlants(BlockStateProvidingFeatureConfig.CODEC));

    public static ConfiguredFeature<?, ?> TAR_LAKE;



    public static void register(){
        //Overworld Ore Register
        overworldOres.add(register("arlemite_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockRegistry.arlemiteOre.defaultBlockState(), Config.arlemiteVeinSize.get())).range(Config.arlemiteMaxHeight.get()).squared().count(Config.arlemiteTries.get())));
        overworldOres.add(register("realmite_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockRegistry.realmiteOre.defaultBlockState(), Config.realmiteVeinSize.get())).range(Config.realmiteMaxHeight.get()).squared().count(Config.realmiteTries.get())));
        overworldOres.add(register("rupee_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockRegistry.rupeeOre.defaultBlockState(), Config.rupeeVeinSize.get())).range(Config.rupeeMaxHeight.get()).squared().count(Config.rupeeTries.get())));
        netherOres.add(register("bloodgem_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockRegistry.bloodgemOre.defaultBlockState(), Config.netherVein.get())).range(256).squared().count(Config.netherTries.get())));
        netherOres.add(register("torridite_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockRegistry.torriditeOre.defaultBlockState(), Config.netherVein.get())).range(256).squared().count(Config.netherTries.get())));


        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;

        //TODO - change tar lake to a custom feature so we get twilight stone instead of stone in twilight dimensions
        TAR_LAKE = Feature.LAKE
                .configured(new BlockStateFeatureConfig(BlockRegistry.smolderingTar.defaultBlockState()))
                .decorated(DecoratorRegistry.TAR_LAKE.get().configured(new ChanceConfig(5)));
        Registry.register(registry, new ResourceLocation(DivineRPG.MODID, "tar_lake"), TAR_LAKE);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        ResourceLocation biome = event.getName();
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if (biome == null) return;

        if(event.getCategory().equals(Biome.Category.NETHER)){
            for(ConfiguredFeature<?, ?> ore : netherOres){
                if (ore != null) generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        for(ConfiguredFeature<?, ?> ore : overworldOres){
            if (ore != null) generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);

        }
        if(!event.getCategory().equals(Biome.Category.NETHER) || !event.getCategory().equals(Biome.Category.THEEND) || !event.getCategory().equals(Biome.Category.JUNGLE) || !event.getCategory().equals(Biome.Category.SWAMP) || !event.getCategory().equals(Biome.Category.MESA) || !event.getCategory().equals(Biome.Category.MUSHROOM)){
            generation.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, KeyRegistry.DIVINE_TREE.decorated(Placement.CHANCE.configured(new ChanceConfig(25))).count(2));

            generation.addFeature(GenerationStage.Decoration.LAKES, TAR_LAKE.decorated(Placement.CHANCE.configured(new ChanceConfig(50))).count(1));
        }

        if(biome != null && event.getCategory().equals(Biome.Category.PLAINS)) {
            generation.addStructureStart(ConfiguredStructureRegistry.CONFIGURED_HUT);
        }

        EntityRegistry.spawnStuff(event);
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, DivineRPG.MODID + ":" + name, configuredFeature);
    }
    private static <C extends IFeatureConfig, F extends Feature<C>> RegistryObject<F> register(String id, Supplier<F> feature) {
        return FEATURES.register(id, feature);
    }
}