package divinerpg.tiles.furnace;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;
import net.minecraft.util.math.*;

public class TileEntityDemonFurnace extends TileEntityModFurnace {

    public TileEntityDemonFurnace() {
        super(TileRegistry.DEMON_FURNACE);
    }

    public String getFuranceName() {
        return "block.divinerpg.demon_furnace";
    }

    int getFurnaceSpeed() {
        return 100;
    }

    public boolean needsFuel() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            if (!isLit() && this.level.random.nextInt(50) == 0) {
                BlockPos blockpos = getBlockPos().offset(this.level.random.nextInt(3) - 1, this.level.random.nextInt(3) - 1,
                        this.level.random.nextInt(3) - 1);
                if (this.level.isEmptyBlock(blockpos)) {
                    this.level.setBlock(blockpos, Blocks.FIRE.defaultBlockState(), 3);
                }
            }
        }
    }
    @Override
    protected Container createMenu(int i, PlayerInventory playerInventory) {
        return new DemonFurnaceContainer(i, playerInventory, this, this.dataAccess);
    }

}