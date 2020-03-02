package divinerpg.dimensions.vethea;

import divinerpg.dimensions.vethea.layer1.WorldGenVetheaForestTree;
import divinerpg.registry.ModBlocks;

/**
 * Gnenerates firewood trees using the same procedure as vanilla forest oak trees
 */
public class WorldGenFirewoodTree extends WorldGenVetheaForestTree {
    public WorldGenFirewoodTree(boolean notify) {
        super(false, ModBlocks.firewoodLog.getDefaultState(), ModBlocks.firewoodLeaves.getDefaultState());
    }
}
