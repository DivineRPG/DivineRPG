package divinerpg.tiles.furnace;

import divinerpg.registries.*;

public class TileEntityOceanfireFurnace extends TileEntityModFurnace {

    public TileEntityOceanfireFurnace() {
        super(TileRegistry.OCEANFIRE_FURNACE);
    }

    public String getFuranceName() {
        return "block.divinerpg.oceanfire_furnace";
    }

    int getFurnaceSpeed() {
        return 225;
    }

    public boolean needsFuel() {
        return false;
    }

}
