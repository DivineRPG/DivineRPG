package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.objects.blocks.arcana.BlockWhitefireFurnace;

public class TileEntityWhitefireFurnace extends TileEntityInfiniteFurnace {

    public String getFuranceName() {
        return "tile.whitefire_furnace.name";
    }

    int getFurnaceSpeed() {
        return 150;
    }

    public void updateBlockState() {
        BlockWhitefireFurnace.setState(this.canSmelt(), world, pos);
    }
}