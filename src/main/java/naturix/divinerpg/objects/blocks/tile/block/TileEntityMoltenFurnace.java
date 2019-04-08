package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.objects.blocks.arcana.BlockMoltenFurnace;

public class TileEntityMoltenFurnace extends TileEntityInfiniteFurnace {

    public String getFuranceName() {
        return "tile.molten_furnace.name";
    }

    int getFurnaceSpeed() {
        return 275;
    }

    public void updateBlockState() {
        BlockMoltenFurnace.setState(this.canSmelt(), world, pos);
    }
}