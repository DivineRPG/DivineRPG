package divinerpg.block_entities.block;

import divinerpg.registries.BlockEntityRegistry;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;

public class OxcrateBlockEntity extends CrateBlockEntity {
    public OxcrateBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.OXCRATE.get(), pos, blockState);
    }
    @Override public boolean canPlaceItem(int slot, ItemStack stack) {
        return countItem(stack.getItem()) > 0;
    }
    @Override public boolean canTakeItem(Container c, int i, ItemStack s) {
        if(countItem(s.getItem()) > 1) {
            while(i > 0) {
                i--;
                if(getItem(i).is(s.getItem())) return true;
            }
        } return false;
    }
    @Override protected Component getDefaultName() {return Component.translatable(BlockRegistry.oxcrate.get().getDescriptionId());}
}