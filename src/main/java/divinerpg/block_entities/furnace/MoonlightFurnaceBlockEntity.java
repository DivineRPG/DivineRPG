package divinerpg.block_entities.furnace;

import divinerpg.client.menu.MoonlightFurnaceMenu;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class MoonlightFurnaceBlockEntity extends ModFurnaceBlockEntity {
    public MoonlightFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.MOONLIGHT_FURNACE.get(), pos, state, "block.divinerpg.moonlight_furnace", 2.6F);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new MoonlightFurnaceMenu(i, playerInventory, this, this.dataAccess);
    }
}