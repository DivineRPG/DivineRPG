package divinerpg.block_entities.chests;

import net.minecraft.core.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
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