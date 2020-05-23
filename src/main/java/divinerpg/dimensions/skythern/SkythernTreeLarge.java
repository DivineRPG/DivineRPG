package divinerpg.dimensions.skythern;

import divinerpg.dimensions.wildwood.LargeWildWoodTree;
import divinerpg.registry.BlockRegistry;

/**
 * Created by LiteWolf101 on 10/8/2018.
 */
public class SkythernTreeLarge extends LargeWildWoodTree {

    public SkythernTreeLarge(boolean notify, int minTrunkHeight) {
        super(notify, minTrunkHeight, BlockRegistry.skythernLog.getDefaultState(), BlockRegistry.skythernLeaves.getDefaultState(), BlockRegistry.skythernGrass);
    }
}
