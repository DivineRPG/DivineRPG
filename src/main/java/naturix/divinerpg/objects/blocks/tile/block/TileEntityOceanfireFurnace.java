package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.objects.blocks.arcana.BlockOceanfireFurnace;

public class TileEntityOceanfireFurnace extends TileEntityInfiniteFurnace {
    public TileEntityOceanfireFurnace() {
        super("oceanfire_furnace", 225);
    }

    public void updateBlockState() {
        BlockOceanfireFurnace.setState(this.canSmelt(), world, pos);
    }
}