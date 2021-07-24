package divinerpg.tiles.furnace;

import divinerpg.registries.*;

public class TileEntityMoonlightFurnace extends TileEntityModFurnace {

    public TileEntityMoonlightFurnace() {
        super(TileRegistry.MOONLIGHT_FURNACE);
    }

    public String getFuranceName() {
        return "block.divinerpg.moonlight_furnace";
    }

    int getFurnaceSpeed() {
        return 100;
    }

    public boolean needsFuel() {
        return true;
    }
}
