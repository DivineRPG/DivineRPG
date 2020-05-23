package divinerpg.objects.blocks.tile.entity;

import divinerpg.objects.blocks.BlockModFurnace;
import divinerpg.registry.BlockRegistry;

public class TileEntityMoonlightFurnace extends TileEntityModFurnace {

    public String getFuranceName() {
        return "tile.moonlight_furnace.name";
    }

    int getFurnaceSpeed() {
        return 100;
    }

    public boolean needsFuel() {
        return true;
    }

    public void updateBlockState(boolean isBurning) {
        BlockModFurnace.updateBlock(isBurning ? BlockRegistry.moonlightFurnaceOn : BlockRegistry.moonlightFurnace, world, pos);
    }
}