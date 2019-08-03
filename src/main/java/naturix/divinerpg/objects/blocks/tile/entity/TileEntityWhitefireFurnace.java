package naturix.divinerpg.objects.blocks.tile.entity;

import naturix.divinerpg.objects.blocks.arcana.BlockWhitefireFurnace;

public class TileEntityWhitefireFurnace extends TileEntityModFurnace {

    public String getFuranceName() {
        return "tile.whitefire_furnace.name";
    }

    int getFurnaceSpeed() {
        return 150;
    }

    public boolean needsFuel() {
        return false;
    }

    public void updateBlockState(boolean isBurning) {
        BlockWhitefireFurnace.setState(isBurning, world, pos);
    }
}