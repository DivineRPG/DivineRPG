package divinerpg.tiles.furnace;

import divinerpg.registries.*;

public class TileEntityMoltenFurnace extends TileEntityModFurnace {

    public TileEntityMoltenFurnace() {
        super(TileRegistry.MOLTEN_FURNACE);
    }

    public String getFuranceName() {
        return "block.divinerpg.molten_furnace";
    }

    int getFurnaceSpeed() {
        return 275;
    }

    public boolean needsFuel() {
        return false;
    }

}
