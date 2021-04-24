package divinerpg.tiles.chests;

import divinerpg.registries.*;

public class TileEntityBoneChest extends TileEntityModChest {

    public TileEntityBoneChest() {
        super(TileRegistry.BONE_CHEST);
    }

    @Override
    public String getChestName() {
        return BlockRegistry.boneChest.getDescriptionId();
    }
}
