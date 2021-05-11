package divinerpg.registries;

import divinerpg.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;

public class ConfiguredStructureRegistry {
    public static StructureFeature<?, ?> CONFIGURED_HUT = StructureRegistry.HUT.get().configured(IFeatureConfig.NONE);


    public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(DivineRPG.MODID, "overworld/livestock_merchant_hut"), CONFIGURED_HUT);

        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureRegistry.HUT.get(), CONFIGURED_HUT);
    }
}
