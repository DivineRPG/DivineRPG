package divinerpg.objects.blocks.tile.entity;

import divinerpg.objects.blocks.BlockModFurnace;
import divinerpg.registry.BlockRegistry;

public class TileEntityWhitefireFurnace extends TileEntityModFurnace {

    public String getFuranceName() {
        return "tile.whitefire_furnace.name";
    }

    int getFurnaceSpeed() {
        return 150;
    }

    public boolean needsFuel() {
        return false;
    }

    public void updateBlockState(boolean isBurning) {
        BlockModFurnace.updateBlock(isBurning ? BlockRegistry.whitefireFurnaceOn : BlockRegistry.whitefireFurnace, world, pos);
    }
}