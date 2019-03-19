package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.objects.blocks.iceika.BlockCoalstoneFurnace;

public class TileEntityCoalstoneFurnace extends TileEntityInfiniteFurnace {
    public TileEntityCoalstoneFurnace() {
        super("coalstone_furnace", 300);
    }

    public void updateBlockState() {
        BlockCoalstoneFurnace.setState(this.canSmelt(), world, pos);
    }
}