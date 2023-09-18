package divinerpg.block_entities.block;

import divinerpg.DivineRPG;
import divinerpg.blocks.vethea.*;
import divinerpg.client.menu.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.*;
import net.minecraft.network.protocol.game.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.*;

public class DreamLampBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    public static final int[] SLOTS = {0};
	protected NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
	protected final ContainerData dataAccess = new ContainerData() {
		@Override public int get(int i) {return burntime;}
		@Override public void set(int type, int value) {burntime = value;}
		@Override public int getCount() {return 1;}};
    int burntime;
    public DreamLampBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.DREAM_LAMP.get(), pos, state);
    }
    @Override @Nullable
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
	public static void serverTick(Level level, BlockPos pos, BlockState state, DreamLampBlockEntity block) {
		if(block.burntime < 0) {
			if(block.items.get(0).getCount() > 0) {
				block.items.get(0).shrink(1);
				block.burntime += 600;
				state = state.setValue(BlockDreamLamp.POWERED, true);
		        level.setBlock(pos, state, 3);
		        setChanged(level, pos, state);
			}
		} else {
			block.burntime--;
			if(block.burntime < 0 && block.items.get(0).getCount() < 1) {
				state = state.setValue(BlockDreamLamp.POWERED, false);
		        level.setBlock(pos, state, 3);
		        setChanged(level, pos, state);
			}
		}
	}
	@Override public int getContainerSize() {return 1;}
	@Override public boolean isEmpty() {return items.get(0).isEmpty();}
	@Override public ItemStack getItem(int i) {return items.get(0);}
	@Override
	public ItemStack removeItem(int i, int j) {
		return ContainerHelper.removeItem(items, i, j);
	}
	@Override
	public ItemStack removeItemNoUpdate(int i) {
		return ContainerHelper.takeItem(items, i);
	}
	@Override
	public void setItem(int slot, ItemStack stack) {
	    items.set(slot, stack);
	    if (stack.getCount() > getMaxStackSize()) stack.setCount(getMaxStackSize());
	}
	@Override
	public boolean stillValid(Player player) {
		if (level.getBlockEntity(worldPosition) != this) return false;
	    else return player.distanceToSqr((double)worldPosition.getX() + 0.5D, (double)worldPosition.getY() + 0.5D, (double)worldPosition.getZ() + 0.5D) <= 64.0D;
	}
	@Override public void clearContent() {items.clear();}
	@Override public int[] getSlotsForFace(Direction dir) {return SLOTS;}
	@Override public boolean canTakeItemThroughFace(int i, ItemStack stack, Direction dir) {return true;}
	@Override public boolean canPlaceItemThroughFace(int i, ItemStack stack, Direction dir) {return canPlaceItem(i, stack);}
	@Override
	public boolean canPlaceItem(int slot, ItemStack stack) {
		return slot > 0 || stack.is(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "acid")));
	}
	@Override
	protected Component getDefaultName() {
        return Component.translatable(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_lamp")).getDescriptionId());
	}
	@Override
	protected AbstractContainerMenu createMenu(int i, Inventory inv) {
		return new DreamLampMenu(i, inv, this);
	}
	@Override
	public void load(CompoundTag tag) {
	      super.load(tag);
	      items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
	      ContainerHelper.loadAllItems(tag, items);
	      burntime = tag.getInt("burntime");
	}
	@Override
	protected void saveAdditional(CompoundTag tag) {
	      super.saveAdditional(tag);
	      tag.putInt("burntime", burntime);
	      ContainerHelper.saveAllItems(tag, items);
	}
}