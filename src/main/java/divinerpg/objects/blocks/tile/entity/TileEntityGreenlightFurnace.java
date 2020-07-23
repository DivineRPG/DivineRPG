package divinerpg.objects.blocks.tile.entity;

import divinerpg.objects.blocks.BlockModFurnace;
import divinerpg.registry.BlockRegistry;

public class TileEntityGreenlightFurnace extends TileEntityModFurnace {

    public String getFuranceName() {
        return "tile.greenlight_furnace.name";
    }

    int getFurnaceSpeed() {
        return 140;
    }

    public boolean needsFuel() {
        return true;
    }

    public void updateBlockState(boolean isBurning) {
        BlockModFurnace.updateBlock(isBurning ? BlockRegistry.greenlightFurnaceOn : BlockRegistry.greenlightFurnace, world,
                pos);
    }
}