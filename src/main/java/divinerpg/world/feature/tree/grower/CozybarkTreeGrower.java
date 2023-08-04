package divinerpg.world.feature.tree.grower;

import org.jetbrains.annotations.Nullable;

import divinerpg.world.ConfiguredFeatureKeys;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CozybarkTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
        return ConfiguredFeatureKeys.AURORAOAK_TREE;
    }
}