package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.objects.blocks.arcana.BlockOceanfireFurnace;

public class TileEntityOceanfireFurnace extends TileEntityInfiniteFurnace {

    public String getFuranceName() {
        return "tile.oceanfire_furnace.name";
    }

    int getFurnaceSpeed() {
        return 225;
    }

    public void updateBlockState() {
        BlockOceanfireFurnace.setState(this.canSmelt(), world, pos);
    }
}