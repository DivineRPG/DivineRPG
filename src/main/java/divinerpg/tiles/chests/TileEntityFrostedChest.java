package divinerpg.tiles.chests;

import divinerpg.registries.*;

public class TileEntityFrostedChest extends TileEntityModChest {

    public TileEntityFrostedChest() {
        super(TileRegistry.FROSTED_CHEST);
    }

    @Override
    public String getChestName() {
        return BlockRegistry.frostedChest.getDescriptionId();
    }

    @Override
    public int getContainerSize() {
        return 27;
    }
}