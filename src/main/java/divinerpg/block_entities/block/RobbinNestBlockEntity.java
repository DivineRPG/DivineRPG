package divinerpg.block_entities.block;

import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import java.util.function.Predicate;

public class RobbinNestBlockEntity extends BlockEntity implements Container {
    private static final String ITEM_TAG = "item";
    private ItemStack item = ItemStack.EMPTY;

    public RobbinNestBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.ROBBIN_NEST.get(), pos, state);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if (!this.item.isEmpty()) {
            output.store(ITEM_TAG, ItemStack.CODEC, this.item);
        }
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.item = input.read(ITEM_TAG, ItemStack.CODEC).orElse(ItemStack.EMPTY);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return super.getUpdateTag(registries);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void setItemNoUpdate(ItemStack item) {
        this.item = item == null ? ItemStack.EMPTY : item;
    }

    public void setItemSilent(ItemStack item) {
        this.item = item == null ? ItemStack.EMPTY : item;
        setChanged();
    }

    public void setItem(ItemStack item) {
        this.item = item == null ? ItemStack.EMPTY : item;
        setChanged();
        if (level != null && !level.isClientSide()) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        this.item = ItemStack.EMPTY;
    }

    public ItemStack getItem() {
        return getItem(0);
    }

    @Override
    public int getContainerSize() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return this.item.isEmpty();
    }

    @Override
    public ItemStack getItem(int slot) {
        return this.item;
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        if (this.item.isEmpty()) {
            return ItemStack.EMPTY;
        }
        ItemStack result = this.item.split(amount);
        if (this.item.isEmpty()) {
            this.item = ItemStack.EMPTY;
        }
        setItem(this.item); // Triggers setChanged() & client sync
        return result;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        ItemStack result = this.item;
        this.item = ItemStack.EMPTY;
        return result;
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        setItem(stack);
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public int countItem(Item item) {
        return (!this.item.isEmpty() && this.item.is(item)) ? this.item.getCount() : 0;
    }

    @Override
    public boolean hasAnyMatching(Predicate<ItemStack> predicate) {
        return predicate.test(this.item);
    }

    @Override
    public void clearContent() {
        setItem(ItemStack.EMPTY);
    }
}