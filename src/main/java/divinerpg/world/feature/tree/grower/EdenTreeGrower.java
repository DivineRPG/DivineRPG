package divinerpg.world.feature.tree.grower;

import javax.annotation.Nullable;

import divinerpg.registries.ConfiguredFeatureRegistry;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class EdenTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean largeHive) {
        return Holder.direct(ConfiguredFeatureRegistry.EDEN_TREE.get());
    }
}
