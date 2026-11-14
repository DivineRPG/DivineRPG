package divinerpg.block_entities.furnace;

import divinerpg.client.menu.GreenlightFurnaceMenu;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class GreenlightFurnaceBlockEntity extends ModFurnaceBlockEntity {
    public GreenlightFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.GREENLIGHT_FURNACE.get(), pos, state, "block.divinerpg.greenlight_furnace", 1.3F);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new GreenlightFurnaceMenu(i, playerInventory, this, dataAccess);
    }
}