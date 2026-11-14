package divinerpg.block_entities.chest;

import divinerpg.client.menu.FrostedChestMenu;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class FrostedChestBlockEntity extends ModChestBlockEntity {

    public FrostedChestBlockEntity(BlockPos p_154992_, BlockState p_154993_) {
        super(BlockEntityRegistry.FROSTED_CHEST.get(), p_154992_, p_154993_);
    }

    @Override
    public String getChestName() {
        return BlockRegistry.frostedChest.get().getDescriptionId();
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inv) {
        return FrostedChestMenu.threeRows(i, inv, this);
    }
}