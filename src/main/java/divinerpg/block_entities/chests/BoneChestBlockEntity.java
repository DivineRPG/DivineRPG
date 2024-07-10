package divinerpg.block_entities.chests;

import divinerpg.client.menu.BoneChestMenu;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class BoneChestBlockEntity extends ModChestBlockEntity {

    public BoneChestBlockEntity(BlockPos p_154992_, BlockState p_154993_) {
        super(BlockEntityRegistry.BONE_CHEST.get(), p_154992_, p_154993_);
        setItems(NonNullList.withSize(27, ItemStack.EMPTY));
    }

    @Override
    public String getChestName() {
        return BlockRegistry.boneChest.get().getDescriptionId();
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inv) {
        return BoneChestMenu.threeRows(i, inv, this);
    }
}
