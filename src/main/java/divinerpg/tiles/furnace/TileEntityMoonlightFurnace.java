package divinerpg.tiles.furnace;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;

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

    @Override
    protected Container createMenu(int i, PlayerInventory playerInventory) {
        return new MoonlightFurnaceContainer(i, playerInventory, this, this.dataAccess);
    }
}
