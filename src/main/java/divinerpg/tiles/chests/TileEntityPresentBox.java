package divinerpg.tiles.chests;

import divinerpg.registries.*;

public class TileEntityPresentBox extends TileEntityModChest {

    public TileEntityPresentBox() {
        super(TileRegistry.PRESENT_BOX);
    }

    @Override
    public String getChestName() {
        return BlockRegistry.presentBox.getDescriptionId();
    }
}
