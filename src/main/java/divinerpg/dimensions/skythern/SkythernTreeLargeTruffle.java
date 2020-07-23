package divinerpg.dimensions.skythern;

import divinerpg.dimensions.wildwood.LargeWildWoodTree;
import divinerpg.registry.BlockRegistry;

/**
 * Created by LiteWolf101 on 10/8/2018.
 */
public class SkythernTreeLargeTruffle extends LargeWildWoodTree {
    public SkythernTreeLargeTruffle(boolean notify, int minTrunkHeight) {
        super(notify, minTrunkHeight, BlockRegistry.skythernLog.getDefaultState(), BlockRegistry.skythernLeaves.getDefaultState(), BlockRegistry.truffle);
    }
}
