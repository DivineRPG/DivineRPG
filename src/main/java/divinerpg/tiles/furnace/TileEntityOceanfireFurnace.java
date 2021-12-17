package divinerpg.tiles.furnace;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;

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

    @Override
    protected Container createMenu(int i, PlayerInventory playerInventory) {
        return new OceanfireFurnaceContainer(i, playerInventory, this, this.dataAccess);
    }
}
