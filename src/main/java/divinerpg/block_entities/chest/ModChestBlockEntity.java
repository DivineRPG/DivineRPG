package divinerpg.block_entities.chest;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;

public abstract class ModChestBlockEntity extends ChestBlockEntity {
    protected ModChestBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    @Override
    public void setBlockState(BlockState state) {
        super.setBlockState(state.setValue(ChestBlock.TYPE, ChestType.SINGLE));
    }
    abstract public String getChestName();
    @Override
    public Component getName() {
        return Component.translatable(this.hasCustomName() ? this.getCustomName().getString() : getChestName());
    }
    protected Component getDefaultName() {
        return Component.translatable("container.chest");
    }
    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        if(items.size() == getContainerSize()) super.setItems(items);
    }
}