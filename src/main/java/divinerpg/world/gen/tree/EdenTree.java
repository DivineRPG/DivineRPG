package divinerpg.world.gen.tree;

import divinerpg.registries.*;
import net.minecraft.block.trees.*;
import net.minecraft.world.gen.feature.*;

import javax.annotation.*;
import java.util.*;

public class EdenTree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        return KeyRegistry.EDEN_TREE;
    }
}