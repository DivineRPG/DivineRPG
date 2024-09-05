package divinerpg.block_entities.block;

import divinerpg.registries.BlockEntityRegistry;
import divinerpg.util.DivineRPGPacketHandler;
import divinerpg.util.packets.PacketItemContentChanged;
import divinerpg.util.packets.PacketRequestItemContent;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.PacketDistributor.TargetPoint;

import java.util.function.Predicate;

public class RobbinNestBlockEntity extends BlockEntity implements Container {
	private static final String ITEM_TAG = "item";
	private ItemStack item;
	public RobbinNestBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityRegistry.ROBBIN_NEST.get(), pos, state);
	}
	@Override
	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		tag.put(ITEM_TAG, getItem().save(new CompoundTag()));
	}
	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		if(tag.contains(ITEM_TAG)) item = ItemStack.of(tag.getCompound(ITEM_TAG));
	}
	@SuppressWarnings("resource") @Override public void onLoad() {
		super.onLoad();
		if(level.isClientSide()) {
			DivineRPGPacketHandler.INSTANCE.sendToServer(new PacketRequestItemContent(worldPosition));
		}
	}
	public void setItemNoUpdate(ItemStack item) {
		this.item = item;
	}
	public void setItemSilent(ItemStack item) {
		this.item = item;
		setChanged();
	}
	public void setItem(ItemStack item) {
		if(!level.isClientSide() && (this.item == null ? item != null && !item.isEmpty() : (item == null ? !this.item.isEmpty() : this.item.isEmpty() ^ item.isEmpty())))
			DivineRPGPacketHandler.INSTANCE.send(PacketDistributor.NEAR.with(TargetPoint.p(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), 256, level.dimension())), new PacketItemContentChanged(worldPosition, item.getItem()));
		this.item = item;
		setChanged();
	}
	@Override
	public void setRemoved() {
		super.setRemoved();
		item = ItemStack.EMPTY;
	}
	public ItemStack getItem() {return getItem(0);}
	public ItemStack removeItem(int amount) {
		return removeItem(0, amount);
	}
	@Override public int getContainerSize() {return 1;}
	@Override public boolean isEmpty() {return item == null || item.isEmpty();}
	@Override public ItemStack getItem(int i) {return item == null ? ItemStack.EMPTY : item;}
	@Override public ItemStack removeItem(int i, int amount) {
		if(item == null || item.isEmpty()) return ItemStack.EMPTY;
		int count = item.getCount() - amount;
		if(count < 1) {
			ItemStack output = item.copy();
			setItem(ItemStack.EMPTY);
			return output;
		} setItem(item.copyWithCount(count));
		return item.copyWithCount(amount);
	}
	@Override public ItemStack removeItemNoUpdate(int amount) {
		if(item == null || item.isEmpty()) return ItemStack.EMPTY;
		int count = item.getCount() - amount;
		if(count < 1) {
			ItemStack output = item.copy();
			item = ItemStack.EMPTY;
			return output;
		} item = item.copyWithCount(count);
		return item.copyWithCount(amount);
	}
	@Override public void setItem(int i, ItemStack stack) {setItem(stack);}
	@Override public boolean stillValid(Player player) {return !player.isSpectator();}
	@Override public int countItem(Item i) {return item == null || item.isEmpty() || !item.is(i) ? 0 : item.getCount();}
	@Override public boolean hasAnyMatching(Predicate<ItemStack> predicate) {return predicate.test(item == null ? ItemStack.EMPTY : item);}
	@Override public void clearContent() {setItem(ItemStack.EMPTY);}
}