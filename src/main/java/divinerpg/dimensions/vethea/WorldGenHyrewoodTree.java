package divinerpg.dimensions.vethea;

import divinerpg.registry.ModBlocks;

/**
 * Gnenerates hyrewood trees using the same procedure as vanilla forest oak trees
 */
public class WorldGenHyrewoodTree extends WorldGenVetheaForestTree {
    public WorldGenHyrewoodTree(boolean notify) {
        super(notify, ModBlocks.hyrewoodLog.getDefaultState(), ModBlocks.hyrewoodLeaves.getDefaultState());
    }
}
