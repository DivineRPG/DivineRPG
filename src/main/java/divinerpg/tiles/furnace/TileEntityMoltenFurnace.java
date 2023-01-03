package divinerpg.tiles.furnace;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.state.*;

public class TileEntityMoltenFurnace extends TileEntityInfiniFurnace {
    public TileEntityMoltenFurnace(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.MOLTEN_FURNACE.get(), pos, state, "block.divinerpg.molten_furnace", 2.0);
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
        return new MoltenFurnaceContainer(i, playerInventory, this, this.dataAccess);
    }
}
