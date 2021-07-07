package divinerpg.tiles.furnace;

import divinerpg.registries.*;

public class TileEntityGreenlightFurnace extends TileEntityModFurnace {

    public TileEntityGreenlightFurnace() {
        super(TileRegistry.GREENLIGHT_FURNACE);
    }

    public String getFuranceName() {
        return "block.divinerpg.greenlight_furnace";
    }

    int getFurnaceSpeed() {
        return 140;
    }

    public boolean needsFuel() {
        return true;
    }

}
