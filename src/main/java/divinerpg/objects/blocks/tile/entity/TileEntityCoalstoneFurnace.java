package divinerpg.objects.blocks.tile.entity;

import divinerpg.objects.blocks.BlockModFurnace;
import divinerpg.registry.BlockRegistry;

public class TileEntityCoalstoneFurnace extends TileEntityModFurnace {

    public String getFuranceName() {
        return "tile.coalstone_furnace.name";
    }

    int getFurnaceSpeed() {
        return 300;
    }

    public boolean needsFuel() {
        return false;
    }

    public void updateBlockState(boolean isBurning) {
        BlockModFurnace.updateBlock(isBurning ? BlockRegistry.coalstoneFurnaceOn : BlockRegistry.coalstoneFurnace, world, pos);
    }
}