package divinerpg.block_entities.furnace;

import divinerpg.client.menu.WhitefireFurnaceMenu;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class WhitefireFurnaceBlockEntity extends InfiniFurnaceBlockEntity {
    public WhitefireFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.WHITEFIRE_FURNACE.get(), pos, state, "block.divinerpg.whitefire_furnace", 2.3);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new WhitefireFurnaceMenu(i, playerInventory, this, this.dataAccess);
    }
}