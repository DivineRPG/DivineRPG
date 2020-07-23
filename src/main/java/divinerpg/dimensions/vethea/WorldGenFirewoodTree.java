package divinerpg.dimensions.vethea;

import divinerpg.registry.BlockRegistry;

/**
 * Gnenerates firewood trees using the same procedure as vanilla forest oak trees
 */
public class WorldGenFirewoodTree extends WorldGenVetheaForestTree {
    public WorldGenFirewoodTree(boolean notify) {
        super(notify, BlockRegistry.firewoodLog.getDefaultState(), BlockRegistry.firewoodLeaves.getDefaultState());
    }
}
