package divinerpg.tiles.furnace;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.state.*;

public class TileEntityOceanfireFurnace extends TileEntityInfiniFurnace {
    public TileEntityOceanfireFurnace(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.OCEANFIRE_FURNACE.get(), pos, state, "block.divinerpg.oceanfire_furnace", 1.6);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new OceanfireFurnaceContainer(i, playerInventory, this, this.dataAccess);
    }
}
