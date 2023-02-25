package divinerpg.world.feature.tree.grower;

import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.*;
import net.minecraft.world.level.levelgen.feature.*;

import javax.annotation.*;

public class DivineTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean largeHive) {
        return Holder.direct(ConfiguredFeatureRegistry.DIVINE_TREE.get());
    }
}