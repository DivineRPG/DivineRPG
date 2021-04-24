package divinerpg.tiles.chests;

import divinerpg.registries.*;

public class TileEntityFrostedChest extends TileEntityModChest {

    public TileEntityFrostedChest() {
        super(TileRegistry.FROSTED_CHEST);
    }

    public String getChestName() {
        return BlockRegistry.frostedChest.getDescriptionId();
    }
}