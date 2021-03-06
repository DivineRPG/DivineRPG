package divinerpg.registries;


import com.google.common.collect.*;
import divinerpg.*;
import divinerpg.world.gen.structure.structures.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.settings.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

import java.util.*;

public class StructureRegistry {

    public static final DeferredRegister<Structure<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, DivineRPG.MODID);

    public static final RegistryObject<Structure<NoFeatureConfig>> HUT = DEFERRED_REGISTRY_STRUCTURE.register("hut", () -> (new HutStructure(NoFeatureConfig.CODEC)));
    //TODO - add loot to workshop house 1
    public static final RegistryObject<Structure<NoFeatureConfig>> WORKSHOP_HOUSE_1 = DEFERRED_REGISTRY_STRUCTURE.register("workshop_house_1", () -> (new DivineStructure(NoFeatureConfig.CODEC, ImmutableList.of(), "iceika/houses/workshop_house_1", GenerationStage.Decoration.SURFACE_STRUCTURES)));
    public static final RegistryObject<Structure<NoFeatureConfig>> WORKSHOP_HOUSE_2 = DEFERRED_REGISTRY_STRUCTURE.register("workshop_house_2", () -> (new DivineStructure(NoFeatureConfig.CODEC, ImmutableList.of(), "iceika/houses/workshop_house_2", GenerationStage.Decoration.SURFACE_STRUCTURES)));
    public static final RegistryObject<Structure<NoFeatureConfig>> WORKSHOP_HOUSE_3 = DEFERRED_REGISTRY_STRUCTURE.register("workshop_house_3", () -> (new DivineStructure(NoFeatureConfig.CODEC, ImmutableList.of(), "iceika/houses/workshop_house_3", GenerationStage.Decoration.SURFACE_STRUCTURES)));
    public static final RegistryObject<Structure<NoFeatureConfig>> WORKSHOP_HOUSE_4 = DEFERRED_REGISTRY_STRUCTURE.register("workshop_house_4", () -> (new DivineStructure(NoFeatureConfig.CODEC, ImmutableList.of(), "iceika/houses/workshop_house_4", GenerationStage.Decoration.SURFACE_STRUCTURES)));
    public static final RegistryObject<Structure<NoFeatureConfig>> WORKSHOP_HOUSE_5 = DEFERRED_REGISTRY_STRUCTURE.register("workshop_house_5", () -> (new DivineStructure(NoFeatureConfig.CODEC, ImmutableList.of(), "iceika/houses/workshop_house_5", GenerationStage.Decoration.SURFACE_STRUCTURES)));
    public static final RegistryObject<Structure<NoFeatureConfig>> WORKSHOP_HOUSE_6 = DEFERRED_REGISTRY_STRUCTURE.register("workshop_house_6", () -> (new DivineStructure(NoFeatureConfig.CODEC, ImmutableList.of(), "iceika/houses/workshop_house_6", GenerationStage.Decoration.SURFACE_STRUCTURES)));

    public static void setupStructures() {
        //StructureSeperationSettings average distance (chunks), minimum distance (chunks), seed mod
        setupMapSpacingAndLand(HUT.get(), new StructureSeparationSettings(30, 5, 45611502), true);


        setupMapSpacingAndLand(WORKSHOP_HOUSE_1.get(), new StructureSeparationSettings(30, 5, 45611502), true);
        setupMapSpacingAndLand(WORKSHOP_HOUSE_2.get(), new StructureSeparationSettings(30, 5, 45611502), true);
        setupMapSpacingAndLand(WORKSHOP_HOUSE_3.get(), new StructureSeparationSettings(30, 5, 45611502), true);
        setupMapSpacingAndLand(WORKSHOP_HOUSE_4.get(), new StructureSeparationSettings(30, 5, 45611502), true);
        setupMapSpacingAndLand(WORKSHOP_HOUSE_5.get(), new StructureSeparationSettings(30, 5, 45611502), true);
        setupMapSpacingAndLand(WORKSHOP_HOUSE_6.get(), new StructureSeparationSettings(30, 5, 45611502), true);
    }

    public static <F extends Structure<?>> void setupMapSpacingAndLand(
            F structure,
            StructureSeparationSettings structureSeparationSettings,
            boolean transformSurroundingLand)
    {
        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
        if(transformSurroundingLand){
            Structure.NOISE_AFFECTING_FEATURES =
                    ImmutableList.<Structure<?>>builder()
                            .addAll(Structure.NOISE_AFFECTING_FEATURES)
                            .add(structure)
                            .build();
        }
        DimensionStructuresSettings.DEFAULTS =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.DEFAULTS)
                        .put(structure, structureSeparationSettings)
                        .build();

        WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap = settings.getValue().structureSettings().structureConfig();

            if(structureMap instanceof ImmutableMap){
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().structureSettings().structureConfig = tempMap;
            }
            else{
                structureMap.put(structure, structureSeparationSettings);
            }
        });
    }
}
