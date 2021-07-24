package divinerpg.tiles.furnace;

import divinerpg.registries.*;

public class TileEntityCoalstoneFurnace extends TileEntityModFurnace {

    public TileEntityCoalstoneFurnace() {
        super(TileRegistry.COALSTONE_FURNACE);
    }
    @Override
    public String getFuranceName() {
        return "block.divinerpg.coalstone_furnace";
    }

    @Override
    int getFurnaceSpeed() {
        return 300;
    }

    @Override
    public boolean needsFuel() {
        return false;
    }

}
