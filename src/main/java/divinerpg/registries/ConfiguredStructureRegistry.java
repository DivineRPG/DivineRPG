package divinerpg.registries;

import net.minecraft.util.registry.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;

public class ConfiguredStructureRegistry {
    public static StructureFeature<?, ?> CONFIGURED_HUT = StructureRegistry.HUT.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_WORKSHOP_HOUSE_1 = StructureRegistry.WORKSHOP_HOUSE_1.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_WORKSHOP_HOUSE_2 = StructureRegistry.WORKSHOP_HOUSE_2.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_WORKSHOP_HOUSE_3 = StructureRegistry.WORKSHOP_HOUSE_3.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_WORKSHOP_HOUSE_4 = StructureRegistry.WORKSHOP_HOUSE_4.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_WORKSHOP_HOUSE_5 = StructureRegistry.WORKSHOP_HOUSE_5.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_WORKSHOP_HOUSE_6 = StructureRegistry.WORKSHOP_HOUSE_6.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_EDEN = StructureRegistry.EDEN.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_WILDWOOD = StructureRegistry.WILDWOOD.get().configured(IFeatureConfig.NONE);

    public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;

        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.HUT.get(), CONFIGURED_HUT);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.WORKSHOP_HOUSE_1.get(), CONFIGURED_WORKSHOP_HOUSE_1);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.WORKSHOP_HOUSE_2.get(), CONFIGURED_WORKSHOP_HOUSE_2);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.WORKSHOP_HOUSE_3.get(), CONFIGURED_WORKSHOP_HOUSE_3);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.WORKSHOP_HOUSE_4.get(), CONFIGURED_WORKSHOP_HOUSE_4);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.WORKSHOP_HOUSE_5.get(), CONFIGURED_WORKSHOP_HOUSE_5);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.WORKSHOP_HOUSE_6.get(), CONFIGURED_WORKSHOP_HOUSE_6);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.EDEN.get(), CONFIGURED_EDEN);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.WILDWOOD.get(), CONFIGURED_WILDWOOD);
    }
}
