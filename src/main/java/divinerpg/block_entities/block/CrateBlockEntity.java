package divinerpg.block_entities.block;

import java.util.function.Predicate;

import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CrateBlockEntity extends BlockEntity implements Hopper {
	private ItemStack stack = ItemStack.EMPTY;
	private int cooldown = 6;
	public CrateBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityRegistry.CRATE.get(), pos, state);
	}
	public static void serverTick(Level level, BlockPos pos, BlockState state, CrateBlockEntity block) {
		if(!block.isEmpty() && state.getValue(BlockStateProperties.ENABLED)) {
			if(block.cooldown < 1) {
				if(HopperBlockEntity.suckInItems(level, block)) block.cooldown = 6;
			} else block.cooldown--;
		}
	}
	@Override
	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		tag.put("item", getItem().save(new CompoundTag()));
	}
	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		if(tag.contains("item")) stack = ItemStack.of(tag.getCompound("item"));
	}
	@Override
	public int getContainerSize() {
		return 1;
	}
	protected ItemStack getItem() {
		return stack;
	}
	@Override
	public void clearContent() {
		stack = ItemStack.EMPTY;
	}
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	@Override
	public ItemStack getItem(int i) {
		return stack;
	}
	@Override
	public ItemStack removeItem(int i, int amount) {
		if(amount > 0) setChanged();
		else return ItemStack.EMPTY;
		int c = stack.getCount();
		if(amount > c) {
			ItemStack s = stack;
			stack = ItemStack.EMPTY;
			return s;
		} stack.setCount(stack.getCount() - amount);
		return stack.copyWithCount(amount);
	}
	@Override
	public ItemStack removeItemNoUpdate(int i) {
		ItemStack s = stack;
		stack = ItemStack.EMPTY;
		return s;
	}
	@Override
	public void setItem(int i, ItemStack s) {
		stack = s == null ? ItemStack.EMPTY : s;
	}
	@Override
	public boolean stillValid(Player player) {
		return !player.isSpectator();
	}
	@Override
	public void setRemoved() {
		super.setRemoved();
		stack = ItemStack.EMPTY;
	}
	@Override
	public int countItem(Item i) {
		return stack.is(i) ? stack.getCount() : 0;
	}
	@Override
	public boolean hasAnyMatching(Predicate<ItemStack> predicate) {
		return predicate.test(stack);
	}
	@Override
	public boolean canTakeItem(Container c, int i, ItemStack s) {
		return stack.getCount() > 1 && level.getBlockState(worldPosition).getValue(BlockStateProperties.ENABLED);
	}
	public double getLevelX() {return worldPosition.getX() + .5;}
	public double getLevelY() {return worldPosition.getY() + .5;}
	public double getLevelZ() {return worldPosition.getZ() + .5;}
	@Override
	public VoxelShape getSuckShape() {
		return ABOVE;
	}
}