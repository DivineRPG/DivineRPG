package divinerpg.tiles.chests;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;

public class TileEntityEdenChest extends TileEntityModChest {

    public TileEntityEdenChest() {
        super(TileRegistry.EDEN_CHEST);
    }

    @Override
    public String getChestName() {
        return BlockRegistry.edenChest.getDescriptionId();
    }

    @Override
    public int getContainerSize() {
        return 54;
    }

    protected Container createMenu(int window, PlayerInventory playerInventory) {
        return ModChestContainer.createEdenContainer(window, playerInventory, this);
    }
}
