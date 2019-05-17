package naturix.divinerpg.objects.blocks.tile.block;

public class TileEntityEdenChest extends TileEntityModChest {
    public TileEntityEdenChest() {
        initChestContents();
    }

    public String getChestName() {
        return "tile.eden_chest.name";
    }

    @Override
    public int getSizeInventory() {
        return 54;
    }
}