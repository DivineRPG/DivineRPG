package divinerpg.dimensions.vethea;

import divinerpg.registry.BlockRegistry;

/**
 * Gnenerates hyrewood trees using the same procedure as vanilla forest oak trees
 */
public class WorldGenHyrewoodTree extends WorldGenVetheaForestTree {
    public WorldGenHyrewoodTree(boolean notify) {
        super(notify, BlockRegistry.hyrewoodLog.getDefaultState(), BlockRegistry.hyrewoodLeaves.getDefaultState());
    }
}
