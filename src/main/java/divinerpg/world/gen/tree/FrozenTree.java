package divinerpg.world.gen.tree;

import divinerpg.*;
import net.minecraft.block.*;
import net.minecraft.block.trees.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.server.*;

import javax.annotation.*;
import java.util.*;

public class FrozenTree extends Tree {

    private final ResourceLocation configuredFeatureId = new ResourceLocation(DivineRPG.MODID, "frozen_tree");
    @Nullable public ConfiguredFeature<BaseTreeFeatureConfig,?> treeFeature;

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
        return treeFeature;
    }

    @Override
    public boolean growTree(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random rand) {
        MutableRegistry<ConfiguredFeature<?, ?>> registry = world.registryAccess().registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY);
        ConfiguredFeature<?, ?> feature = registry.get(configuredFeatureId);

        if (feature != null && feature.config instanceof BaseTreeFeatureConfig) {
            this.treeFeature = (ConfiguredFeature<BaseTreeFeatureConfig, ?>) feature;
        } else {
            this.treeFeature = null;
            return false;
        }

        return super.growTree(world, chunkGenerator, pos, state, rand);
    }
}