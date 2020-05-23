package divinerpg.objects.blocks.tile.entity;

import divinerpg.objects.blocks.BlockModFurnace;
import divinerpg.registry.BlockRegistry;

public class TileEntityMoltenFurnace extends TileEntityModFurnace {

    public String getFuranceName() {
        return "tile.molten_furnace.name";
    }

    int getFurnaceSpeed() {
        return 275;
    }

    public boolean needsFuel() {
        return false;
    }

    public void updateBlockState(boolean isBurning) {
        BlockModFurnace.updateBlock(isBurning ? BlockRegistry.moltenFurnaceOn : BlockRegistry.moltenFurnace, world, pos);
    }
}