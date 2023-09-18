package divinerpg.block_entities.furnace;

import divinerpg.client.menu.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.state.*;

public class WhitefireFurnaceBlockEntity extends InfiniFurnaceBlockEntity {
    public WhitefireFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.WHITEFIRE_FURNACE.get(), pos, state, "block.divinerpg.whitefire_furnace", 2.3);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new WhitefireFurnaceMenu(i, playerInventory, this, this.dataAccess);
    }
}
