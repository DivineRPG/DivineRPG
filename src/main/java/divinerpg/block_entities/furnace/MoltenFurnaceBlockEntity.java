package divinerpg.block_entities.furnace;

import divinerpg.client.menu.MoltenFurnaceMenu;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class MoltenFurnaceBlockEntity extends InfiniFurnaceBlockEntity {
    public MoltenFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.MOLTEN_FURNACE.get(), pos, state, "block.divinerpg.molten_furnace", 2.0);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new MoltenFurnaceMenu(i, playerInventory, this, this.dataAccess);
    }
}