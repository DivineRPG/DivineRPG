package divinerpg.block_entities.chests;

import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class EdenChestBlockEntity extends ModChestBlockEntity {
    public EdenChestBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.EDEN_CHEST.get(), pos, state);
        setItems(NonNullList.withSize(54, ItemStack.EMPTY));
    }

    @Override
    public String getChestName() {
        return BlockRegistry.edenChest.get().getDescriptionId();
    }

    @Override
    public int getContainerSize() {
        return 54;
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inv) {
    	return ChestMenu.sixRows(i, inv, this);
    }
}