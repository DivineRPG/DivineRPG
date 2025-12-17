package divinerpg.block_entities.block;

import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class CrateBlockEntity extends RandomizableContainerBlockEntity implements Hopper {
	NonNullList<ItemStack> items;
	private int cooldown = 4;
	public CrateBlockEntity(BlockPos pos, BlockState state) {
		this(BlockEntityRegistry.CRATE.get(), pos, state);
	}
	protected CrateBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		super(type, pos, blockState);
		items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
	}
	@Override public boolean isGridAligned() {return false;}
	public static void serverTick(Level level, BlockPos pos, BlockState state, CrateBlockEntity block) {
		if(!block.isEmpty() && state.getValue(BlockStateProperties.ENABLED)) {
			if(block.cooldown < 1) {
				if(HopperBlockEntity.suckInItems(level, block)) block.cooldown = 4;
			} else block.cooldown--;
		}
	}
	@Override protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
		super.saveAdditional(tag, registries);
		if(!trySaveLootTable(tag)) ContainerHelper.saveAllItems(tag, items, registries);
	}
	@Override public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
		super.loadAdditional(tag, registries);
		items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
		if(!tryLoadLootTable(tag)) ContainerHelper.loadAllItems(tag, items, registries);
		//Backwards compatibility with old version
		if(!(this instanceof OxcrateBlockEntity) && tag.contains("item")) {
			items.set(0, ItemStack.parseOptional(registries, tag.getCompound("item")));
			tag.remove("item");
		}
	}
	@Override public int getContainerSize() {return 27;}
	@Override protected NonNullList<ItemStack> getItems() {return this.items;}
	@Override protected void setItems(NonNullList<ItemStack> items) {
		this.items = items;
	}
	@Override protected Component getDefaultName() {return Component.translatable(BlockRegistry.crate.get().getDescriptionId());}
	@Override protected AbstractContainerMenu createMenu(int id, Inventory player) {return ChestMenu.threeRows(id, player, this);}
	@Override public boolean canTakeItem(Container c, int i, ItemStack s) {return s.getCount() > 1;}
	@Override public double getLevelX() {return worldPosition.getX() + .5;}
	@Override public double getLevelY() {return worldPosition.getY() + .5;}
	@Override public double getLevelZ() {return worldPosition.getZ() + .5;}
}