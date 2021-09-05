package divinerpg.registries;

import net.minecraft.util.registry.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;

public class ConfiguredStructureRegistry {
    public static StructureFeature<?, ?> CONFIGURED_HUT = StructureRegistry.HUT.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_EDEN = StructureRegistry.EDEN.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_WILDWOOD = StructureRegistry.WILDWOOD.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_APALACHIA = StructureRegistry.APALACHIA.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_SKYTHERN = StructureRegistry.SKYTHERN.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_MORTUM = StructureRegistry.MORTUM.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_ICEIKA = StructureRegistry.ICEIKA.get().configured(IFeatureConfig.NONE);

    public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;

        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.HUT.get(), CONFIGURED_HUT);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.EDEN.get(), CONFIGURED_EDEN);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.WILDWOOD.get(), CONFIGURED_WILDWOOD);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.APALACHIA.get(), CONFIGURED_APALACHIA);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.SKYTHERN.get(), CONFIGURED_SKYTHERN);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.MORTUM.get(), CONFIGURED_MORTUM);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.ICEIKA.get(), CONFIGURED_ICEIKA);
    }
}
