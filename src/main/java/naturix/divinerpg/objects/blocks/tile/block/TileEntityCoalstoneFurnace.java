package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.objects.blocks.iceika.BlockCoalstoneFurnace;

public class TileEntityCoalstoneFurnace extends TileEntityInfiniteFurnace {

    public String getFuranceName() {
        return "tile.coalstone_furnace.name";
    }

    int getFurnaceSpeed() {
        return 300;
    }

    public void updateBlockState() {
        BlockCoalstoneFurnace.setState(this.canSmelt(), world, pos);
    }
}