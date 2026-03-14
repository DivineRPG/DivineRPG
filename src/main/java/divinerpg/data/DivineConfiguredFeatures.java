package divinerpg.data;

import divinerpg.data.DivineTreeFeatures;
import divinerpg.world.ConfiguredFeatureKeys;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class DivineConfiguredFeatures {

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> ctx) {
        ConfiguredFeatureKeys.bootstrap(ctx);
        DivineTreeFeatures.bootstrap(ctx);
    }
}