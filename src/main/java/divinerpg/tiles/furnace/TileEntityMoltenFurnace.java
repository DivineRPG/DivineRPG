package divinerpg.tiles.furnace;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;

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

    @Override
    protected Container createMenu(int i, PlayerInventory playerInventory) {
        return new MoltenFurnaceContainer(i, playerInventory, this, this.dataAccess);
    }
}
