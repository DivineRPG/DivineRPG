package divinerpg.tiles.furnace;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;

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

    @Override
    protected Container createMenu(int i, PlayerInventory playerInventory) {
        return new CoalstoneFurnaceContainer(i, playerInventory, this, this.dataAccess);
    }
}
