package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.objects.blocks.iceika.CoalstoneFurnace;

public class TileEntityCoalstoneFurnace extends TileEntityInfiniteFurnace {
    public TileEntityCoalstoneFurnace() {
        super("coalstone_furnace", 300);
    }

    public void updateBlockState() {
        CoalstoneFurnace.setState(this.canSmelt(), world, pos);
    }
}