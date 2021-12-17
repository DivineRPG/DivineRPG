package divinerpg.tiles.furnace;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;

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

    @Override
    protected Container createMenu(int i, PlayerInventory playerInventory) {
        return new WhitefireFurnaceContainer(i, playerInventory, this, this.dataAccess);
    }
}
