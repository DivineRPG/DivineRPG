package divinerpg.block_entities.furnace;

import divinerpg.client.menu.OceanfireFurnaceMenu;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class OceanfireFurnaceBlockEntity extends InfiniFurnaceBlockEntity {
    public OceanfireFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.OCEANFIRE_FURNACE.get(), pos, state, "block.divinerpg.oceanfire_furnace", 1.6);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new OceanfireFurnaceMenu(i, playerInventory, this, this.dataAccess);
    }
}