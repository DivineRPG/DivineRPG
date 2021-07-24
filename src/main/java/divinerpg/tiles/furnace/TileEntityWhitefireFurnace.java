package divinerpg.tiles.furnace;

import divinerpg.registries.*;

public class TileEntityWhitefireFurnace extends TileEntityModFurnace {

    public TileEntityWhitefireFurnace() {
        super(TileRegistry.WHITEFIRE_FURNACE);
    }

    public String getFuranceName() {
        return "block.divinerpg.whitefire_furnace";
    }

    int getFurnaceSpeed() {
        return 150;
    }

    public boolean needsFuel() {
        return false;
    }
}
