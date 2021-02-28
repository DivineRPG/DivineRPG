package divinerpg.registries;

import divinerpg.*;
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
        overworldOres.add(register("arlemite_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockRegistry.arlemiteOre.getDefaultState(), 5)).range(16).square().func_242731_b(4)));
        overworldOres.add(register("realmite_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockRegistry.realmiteOre.getDefaultState(), 5)).range(48).square().func_242731_b(8)));
        overworldOres.add(register("rupee_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockRegistry.rupeeOre.getDefaultState(), 5)).range(16).square().func_242731_b(4)));
        netherOres.add(register("bloodgem_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, BlockRegistry.bloodgemOre.getDefaultState(), 10)).range(256).square().func_242731_b(4)));
        netherOres.add(register("torridite_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, BlockRegistry.torriditeOre.getDefaultState(), 10)).range(256).square().func_242731_b(4)));
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if(event.getCategory().equals(Biome.Category.NETHER)){
            for(ConfiguredFeature<?, ?> ore : netherOres){
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        for(ConfiguredFeature<?, ?> ore : overworldOres){
            if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);



        }

        if(!event.getCategory().equals(Biome.Category.NETHER) || !event.getCategory().equals(Biome.Category.THEEND) || !event.getCategory().equals(Biome.Category.JUNGLE) || !event.getCategory().equals(Biome.Category.SWAMP) || !event.getCategory().equals(Biome.Category.MESA) || !event.getCategory().equals(Biome.Category.MUSHROOM)){
            generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, KeyRegistry.DIVINE_TREE.withPlacement(Placement.CHANCE.configure(new ChanceConfig(25))).func_242731_b(2));
        }

        EntityRegistry.spawnStuff(event);
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, DivineRPG.MODID + ":" + name, configuredFeature);
    }

}