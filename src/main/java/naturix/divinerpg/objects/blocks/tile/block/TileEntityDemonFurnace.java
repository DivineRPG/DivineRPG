package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.objects.blocks.arcana.BlockDemonFurnace;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class TileEntityDemonFurnace extends TileEntityInfiniteFurnace {
    public TileEntityDemonFurnace() {
        super("demon_furnace", 100);
    }

    public void updateBlockState() {
        BlockDemonFurnace.setState(this.canSmelt(), world, pos);
    }

    @Override
    public void update() {
        super.update();
        if (!this.world.isRemote) {
            if (this.canSmelt() && this.world.rand.nextInt(50) == 0) {
                BlockPos blockpos = pos.add(this.world.rand.nextInt(3) - 1, this.world.rand.nextInt(3) - 1,
                        this.world.rand.nextInt(3) - 1);
                if (this.world.isAirBlock(blockpos)) {
                    this.world.setBlockState(blockpos, Blocks.FIRE.getDefaultState());
                }
            }
        }
    }
}