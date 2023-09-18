package divinerpg.block_entities.furnace;

import divinerpg.client.menu.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.state.*;

public class CoalstoneFurnaceBlockEntity extends InfiniFurnaceBlockEntity {
    public CoalstoneFurnaceBlockEntity(BlockPos p_154992_, BlockState p_154993_) {
        super(BlockEntityRegistry.COALSTONE_FURNACE.get(), p_154992_, p_154993_, "block.divinerpg.coalstone_furnace", 0.9);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new CoalstoneFurnaceMenu(i, playerInventory, this, this.dataAccess);
    }
}
