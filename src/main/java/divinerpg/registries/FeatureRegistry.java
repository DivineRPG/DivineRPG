package divinerpg.registries;

import divinerpg.*;
import divinerpg.config.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.common.world.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

import java.util.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID)
public class FeatureRegistry {
    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOres(){
        //Overworld Ore Register
        overworldOres.add(register("arlemite_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockRegistry.arlemiteOre.defaultBlockState(), Config.arlemiteVeinSize.get())).range(Config.arlemiteMaxHeight.get()).squared().count(Config.arlemiteTries.get())));
        overworldOres.add(register("realmite_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockRegistry.realmiteOre.defaultBlockState(), Config.realmiteVeinSize.get())).range(Config.realmiteMaxHeight.get()).squared().count(Config.realmiteTries.get())));
        overworldOres.add(register("rupee_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockRegistry.rupeeOre.defaultBlockState(), Config.rupeeVeinSize.get())).range(Config.rupeeMaxHeight.get()).squared().count(Config.rupeeTries.get())));
        netherOres.add(register("bloodgem_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockRegistry.bloodgemOre.defaultBlockState(), Config.netherVein.get())).range(256).squared().count(Config.netherTries.get())));
        netherOres.add(register("torridite_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockRegistry.torriditeOre.defaultBlockState(), Config.netherVein.get())).range(256).squared().count(Config.netherTries.get())));
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
        }

        if(biome != null && event.getCategory().equals(Biome.Category.PLAINS)) {
            //TODO - finish this
//            generation.withStructure(DivineStructures.Configured.HUT);
        }
        EntityRegistry.spawnStuff(event);
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, DivineRPG.MODID + ":" + name, configuredFeature);
    }

}