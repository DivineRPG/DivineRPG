package divinerpg.block_entities.block;

import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.Predicate;

public class OxcrateBlockEntity extends BlockEntity implements Hopper {
    private Item item;
    private ItemStack tempstack = ItemStack.EMPTY;
    private int cooldown = 6;
    public OxcrateBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.OXCRATE.get(), pos, blockState);
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, OxcrateBlockEntity block) {
        if(block.item != null && state.getValue(BlockStateProperties.ENABLED)) {
            if(block.cooldown < 1) {
                if(HopperBlockEntity.suckInItems(level, block)) block.cooldown = 6;
            } else block.cooldown--;
        }
    }
    public void setItem(ItemStack item) {
        this.item = item == null || item.isEmpty() ? null : item.getItem();
    }
    @Override protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if(item != null) tag.put("item", new ItemStack(item).save(registries));
    }
    @Override public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if(tag.contains("item")) item = ItemStack.parseOptional(registries, tag.getCompound("item")).getItem();
    }
    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        if(stack.is(item)) {
            tempstack = stack;
            return InserterBlockEntity.ejectItems(level, worldPosition, this, Direction.DOWN);
        } return false;
    }
    @Override public boolean hasAnyMatching(Predicate<ItemStack> predicate) {return predicate.test(tempstack);}
    public double getLevelX() {return worldPosition.getX() + .5;}
    public double getLevelY() {return worldPosition.getY() + .5;}
    public double getLevelZ() {return worldPosition.getZ() + .5;}
    @Override public boolean isGridAligned() {return false;}
    @Override public int getContainerSize() {return 1;}
    @Override public boolean isEmpty() {return false;}
    @Override public ItemStack getItem(int i) {return tempstack;}
    @Override public ItemStack removeItem(int i, int amount) {
        if(amount > 0) setChanged();
        else return ItemStack.EMPTY;
        ItemStack s = tempstack;
        tempstack = ItemStack.EMPTY;
        return s;
    }
    @Override public ItemStack removeItemNoUpdate(int i) {
        ItemStack s = tempstack;
        tempstack = ItemStack.EMPTY;
        return s;
    }
    @Override public boolean canTakeItem(Container c, int i, ItemStack s) {
        return level.getBlockState(worldPosition).getValue(BlockStateProperties.ENABLED);
    }
    @Override public int countItem(Item i) {return 0;}
    @Override public void setItem(int i, ItemStack itemStack) {tempstack = itemStack == null ? ItemStack.EMPTY : itemStack;}
    @Override public boolean stillValid(Player player) {return !player.isSpectator();}
    @Override public void clearContent() {tempstack = ItemStack.EMPTY;}
}