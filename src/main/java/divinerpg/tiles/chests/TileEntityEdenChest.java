package divinerpg.tiles.chests;

import divinerpg.registries.*;

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
}
