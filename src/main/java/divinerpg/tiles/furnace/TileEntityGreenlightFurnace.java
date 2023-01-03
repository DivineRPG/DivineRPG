package divinerpg.tiles.furnace;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.state.*;

public class TileEntityGreenlightFurnace extends TileEntityModFurnace {
    public TileEntityGreenlightFurnace(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.GREENLIGHT_FURNACE.get(), pos, state, "block.divinerpg.greenlight_furnace", 1.3);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new GreenlightFurnaceContainer(i, playerInventory, this, dataAccess);
    }
}
