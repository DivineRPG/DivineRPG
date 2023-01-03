package divinerpg.tiles.furnace;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.state.*;

public class TileEntityWhitefireFurnace extends TileEntityInfiniFurnace {
    public TileEntityWhitefireFurnace(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.WHITEFIRE_FURNACE.get(), pos, state, "block.divinerpg.whitefire_furnace", 2.3);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new WhitefireFurnaceContainer(i, playerInventory, this, this.dataAccess);
    }
}
