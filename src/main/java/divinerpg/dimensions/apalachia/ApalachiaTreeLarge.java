package divinerpg.dimensions.apalachia;

import divinerpg.dimensions.wildwood.LargeWildWoodTree;
import divinerpg.registry.BlockRegistry;

/**
 * Created by LiteWolf101 on 10/8/2018.
 */
public class ApalachiaTreeLarge extends LargeWildWoodTree {
    public ApalachiaTreeLarge(boolean notify, int minTrunkHeight) {
        super(notify, minTrunkHeight, BlockRegistry.apalachiaLog.getDefaultState(), BlockRegistry.apalachiaLeaves.getDefaultState(), BlockRegistry.apalachiaGrass);

    }
}
