package divinerpg.objects.blocks.tile.entity;

import divinerpg.objects.blocks.arcana.BlockMoltenFurnace;

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
        BlockMoltenFurnace.setState(isBurning, world, pos);
    }
}