package divinerpg.dimensions.apalachia;

import divinerpg.dimensions.wildwood.LargeWildWoodTree;
import divinerpg.registry.ModBlocks;

/**
 * Created by LiteWolf101 on 10/8/2018.
 */
public class ApalachiaTreeLarge extends LargeWildWoodTree {
    public ApalachiaTreeLarge(boolean notify, int minTrunkHeight) {
        super(notify, minTrunkHeight, ModBlocks.apalachiaLog.getDefaultState(), ModBlocks.apalachiaLeaves.getDefaultState(), ModBlocks.apalachiaGrass);

    }
}
