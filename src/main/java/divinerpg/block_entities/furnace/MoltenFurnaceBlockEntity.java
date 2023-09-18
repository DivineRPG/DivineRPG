package divinerpg.block_entities.furnace;

import divinerpg.client.menu.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.state.*;

public class MoltenFurnaceBlockEntity extends InfiniFurnaceBlockEntity {
    public MoltenFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.MOLTEN_FURNACE.get(), pos, state, "block.divinerpg.molten_furnace", 2.0);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new MoltenFurnaceMenu(i, playerInventory, this, this.dataAccess);
    }
}
