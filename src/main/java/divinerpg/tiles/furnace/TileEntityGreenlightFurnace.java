package divinerpg.tiles.furnace;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;

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

    @Override
    protected Container createMenu(int i, PlayerInventory playerInventory) {
        return new GreenlightFurnaceContainer(i, playerInventory, this, this.dataAccess);
    }
}
