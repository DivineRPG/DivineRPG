package divinerpg.block_entities.furnace;

import divinerpg.client.menu.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.state.*;

public class MoonlightFurnaceBlockEntity extends ModFurnaceBlockEntity {
    public MoonlightFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.MOONLIGHT_FURNACE.get(), pos, state, "block.divinerpg.moonlight_furnace", 2.6);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new MoonlightFurnaceMenu(i, playerInventory, this, this.dataAccess);
    }
}
