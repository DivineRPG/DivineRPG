package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.objects.blocks.arcana.BlockMoltenFurnace;

public class TileEntityMoltenFurnace extends TileEntityInfiniteFurnace {
    public TileEntityMoltenFurnace() {
        super("molten_furnace", 275);
    }

    public void updateBlockState() {
        BlockMoltenFurnace.setState(this.canSmelt(), world, pos);
    }
}