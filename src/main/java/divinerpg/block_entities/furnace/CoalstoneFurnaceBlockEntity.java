package divinerpg.block_entities.furnace;

import divinerpg.client.menu.CoalstoneFurnaceMenu;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class CoalstoneFurnaceBlockEntity extends InfiniFurnaceBlockEntity {
    public CoalstoneFurnaceBlockEntity(BlockPos p_154992_, BlockState p_154993_) {
        super(BlockEntityRegistry.COALSTONE_FURNACE.get(), p_154992_, p_154993_, "block.divinerpg.coalstone_furnace", 0.9);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new CoalstoneFurnaceMenu(i, playerInventory, this, this.dataAccess);
    }
}