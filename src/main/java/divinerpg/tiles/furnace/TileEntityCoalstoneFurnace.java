package divinerpg.tiles.furnace;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.state.*;

public class TileEntityCoalstoneFurnace extends TileEntityInfiniFurnace {
    public TileEntityCoalstoneFurnace(BlockPos p_154992_, BlockState p_154993_) {
        super(BlockEntityRegistry.COALSTONE_FURNACE.get(), p_154992_, p_154993_, "block.divinerpg.coalstone_furnace", 0.9);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new CoalstoneFurnaceContainer(i, playerInventory, this, this.dataAccess);
    }
}
