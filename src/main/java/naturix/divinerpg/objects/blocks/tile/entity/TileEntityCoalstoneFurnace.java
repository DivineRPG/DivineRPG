package naturix.divinerpg.objects.blocks.tile.entity;

import naturix.divinerpg.objects.blocks.iceika.BlockCoalstoneFurnace;

public class TileEntityCoalstoneFurnace extends TileEntityModFurnace {

    public String getFuranceName() {
        return "tile.coalstone_furnace.name";
    }

    int getFurnaceSpeed() {
        return 300;
    }

    public boolean needsFuel() {
        return false;
    }

    public void updateBlockState(boolean isBurning) {
        BlockCoalstoneFurnace.setState(isBurning, world, pos);
    }
}