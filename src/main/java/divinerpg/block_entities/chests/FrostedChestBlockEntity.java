package divinerpg.block_entities.chests;

import divinerpg.client.menu.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.*;

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