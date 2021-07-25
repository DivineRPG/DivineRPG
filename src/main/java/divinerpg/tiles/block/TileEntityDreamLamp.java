package divinerpg.tiles.block;

import divinerpg.blocks.vethea.*;
import divinerpg.client.containers.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;

public class TileEntityDreamLamp extends LockableTileEntity implements IInventory, ITickableTileEntity {

    protected NonNullList<ItemStack> inventory;

    public TileEntityDreamLamp() {
        super(TileRegistry.DREAM_LAMP);
        this.inventory = NonNullList.withSize(1, ItemStack.EMPTY);
    }

    @Override
    public void tick() {
        if(!this.level.isClientSide) {
            ItemStack acidStack = inventory.get(0);
            boolean powerOn = false;
            if (!acidStack.isEmpty() && acidStack.getItem() == ItemRegistry.acid) {
                powerOn = true;
            } else if (acidStack.isEmpty() || acidStack.getItem() != ItemRegistry.acid) {
                powerOn = false;
            }

            Block block = this.level.getBlockState(this.worldPosition).getBlock();
            if (block instanceof BlockDreamLamp) {
                if (powerOn) {
                    ((BlockDreamLamp) block).setOn(this.level, this.worldPosition);
                } else {
                    ((BlockDreamLamp) block).setOff(this.level, this.worldPosition);
                }
            }
            this.setChanged();
        }
    }


    @Override
    public int getContainerSize() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : inventory) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int slot) {
        return inventory.get(slot);
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        return ItemStackHelper.removeItem(this.inventory, index, count);
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        return ItemStackHelper.takeItem(this.inventory, i);
    }

    @Override
    public void setItem(int index, ItemStack itemstack) {
        this.inventory.set(index, itemstack);
        if (itemstack != null && itemstack.getCount() > getMaxStackSize()) {
            itemstack.setCount(getMaxStackSize());
        }
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return player.level.getBlockEntity(worldPosition) == this && player.distanceToSqr(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()) < 64;
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack) {
        return stack != ItemStack.EMPTY && stack.getItem() == ItemRegistry.acid;
    }

    @Override
    public CompoundNBT save(CompoundNBT tag) {
        super.save(tag);
        ItemStackHelper.saveAllItems(tag, this.inventory);
        return tag;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent(level.getBlockState(worldPosition).getBlock().getDescriptionId());
    }

    @Override
    public void load(BlockState state, CompoundNBT tag) {
        super.load(state, tag);
        //TODO - save dream lamp inventory (means a rewrite)
        ItemStackHelper.loadAllItems(tag, this.inventory);
    }

    @Override
    public void startOpen(PlayerEntity player) {

    }

    @Override
    public void stopOpen(PlayerEntity player) {
    }


    protected Container createMenu(int i, PlayerInventory playerInventory) {
        return new DreamLampContainer(playerInventory, level, this);
    }

    @Override
    public void clearContent() {

    }
}