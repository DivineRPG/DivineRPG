package divinerpg.dimensions.skythern;

import divinerpg.dimensions.wildwood.LargeWildwoodTree;
import divinerpg.registry.BlockRegistry;

/**
 * Created by LiteWolf101 on 10/8/2018.
 */
public class SkythernTreeLargeTruffle extends LargeWildwoodTree {
    public SkythernTreeLargeTruffle(boolean notify, int minTrunkHeight) {
        super(notify, minTrunkHeight, BlockRegistry.skythernLog.getDefaultState(), BlockRegistry.skythernLeaves.getDefaultState(), BlockRegistry.truffle);
    }
}
