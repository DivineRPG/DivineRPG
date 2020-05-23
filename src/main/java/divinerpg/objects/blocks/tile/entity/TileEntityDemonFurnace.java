package divinerpg.objects.blocks.tile.entity;

import divinerpg.objects.blocks.BlockModFurnace;
import divinerpg.registry.BlockRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class TileEntityDemonFurnace extends TileEntityModFurnace {

    public String getFuranceName() {
        return "tile.demon_furnace.name";
    }

    int getFurnaceSpeed() {
        return 100;
    }

    public boolean needsFuel() {
        return false;
    }

    public void updateBlockState(boolean isBurning) {
        BlockModFurnace.updateBlock(isBurning ? BlockRegistry.demonFurnaceOn : BlockRegistry.demonFurnace, world, pos);
    }

    @Override
    public void update() {
        super.update();
        if (!this.world.isRemote) {
            if (this.wasBurning && this.world.rand.nextInt(50) == 0) {
                BlockPos blockpos = pos.add(this.world.rand.nextInt(3) - 1, this.world.rand.nextInt(3) - 1,
                        this.world.rand.nextInt(3) - 1);
                if (this.world.isAirBlock(blockpos)) {
                    this.world.setBlockState(blockpos, Blocks.FIRE.getDefaultState());
                }
            }
        }
    }
}