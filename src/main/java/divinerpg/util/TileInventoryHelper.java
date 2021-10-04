package divinerpg.util;

import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraftforge.items.*;

import java.util.function.*;

public class TileInventoryHelper implements IInventory {

    public static TileInventoryHelper createForTileEntity(int size,
                                                          Predicate<PlayerEntity> canPlayerAccessInventoryLambda,
                                                          Notify markDirtyNotificationLambda) {
        return new TileInventoryHelper(size, canPlayerAccessInventoryLambda, markDirtyNotificationLambda);
    }

    public CompoundNBT serializeNBT()  {
        return chestContents.serializeNBT();
    }

    public void deserializeNBT(CompoundNBT nbt)   {
        chestContents.deserializeNBT(nbt);
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return canPlayerAccessInventoryLambda.test(player);
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack) {
        return chestContents.isItemValid(index, stack);
    }

    @FunctionalInterface
    public interface Notify {
        void invoke();
    }


    @Override
    public void setChanged() {
        markDirtyNotificationLambda.invoke();
    }

    @Override
    public void startOpen(PlayerEntity player) {
        openInventoryNotificationLambda.invoke();
    }

    @Override
    public void stopOpen(PlayerEntity player) {
        closeInventoryNotificationLambda.invoke();
    }

    @Override
    public int getContainerSize() {
        return chestContents.getSlots();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < chestContents.getSlots(); ++i) {
            if (!chestContents.getStackInSlot(i).isEmpty()) return false;
        }
        return true;
    }

    @Override
    public ItemStack getItem(int index) {
        return chestContents.getStackInSlot(index);
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        return chestContents.extractItem(index, count, false);
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        int maxPossibleItemStackSize = chestContents.getSlotLimit(index);
        return chestContents.extractItem(index, maxPossibleItemStackSize, false);
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        chestContents.setStackInSlot(index, stack);
    }

    @Override
    public void clearContent() {
        for (int i = 0; i < chestContents.getSlots(); ++i) {
            chestContents.setStackInSlot(i, ItemStack.EMPTY);
        }
    }

    public static TileInventoryHelper createForClientSideContainer(int size) {
        return new TileInventoryHelper(size);
    }

    private TileInventoryHelper(int size) {
        this.chestContents = new ItemStackHandler(size);
    }

    private TileInventoryHelper(int size, Predicate<PlayerEntity> canPlayerAccessInventoryLambda, Notify markDirtyNotificationLambda) {
        this.chestContents = new ItemStackHandler(size);
        this.canPlayerAccessInventoryLambda = canPlayerAccessInventoryLambda;
        this.markDirtyNotificationLambda = markDirtyNotificationLambda;
    }

    private Predicate<PlayerEntity> canPlayerAccessInventoryLambda = x-> true;
    private Notify markDirtyNotificationLambda = ()->{};
    private Notify openInventoryNotificationLambda = ()->{};
    private Notify closeInventoryNotificationLambda = ()->{};
    private final ItemStackHandler chestContents;
}