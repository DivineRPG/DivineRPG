package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.objects.blocks.arcana.WhitefireFurnace;

public class TileEntityWhitefireFurnace extends TileEntityInfiniteFurnace {
    public TileEntityWhitefireFurnace() {
        super("whitefire_furnace", 150);
    }

    public void updateBlockState() {
        WhitefireFurnace.setState(this.canSmelt(), world, pos);
    }
}