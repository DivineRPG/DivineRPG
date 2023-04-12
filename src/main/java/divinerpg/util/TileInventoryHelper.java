package divinerpg.util;

import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraftforge.items.*;

import java.util.function.*;

public class TileInventoryHelper implements Container {

    private final ItemStackHandler chestContents;
    private Predicate<Player> canPlayerAccessInventoryLambda = x -> true;
    private Notify markDirtyNotificationLambda = () -> {
    };
    private final Notify openInventoryNotificationLambda = () -> {
    };
    private final Notify closeInventoryNotificationLambda = () -> {
    };

    private TileInventoryHelper(int size) {
        this.chestContents = new ItemStackHandler(size);
    }


    private TileInventoryHelper(int size, Predicate<Player> canPlayerAccessInventoryLambda, Notify markDirtyNotificationLambda) {
        this.chestContents = new ItemStackHandler(size);
        this.canPlayerAccessInventoryLambda = canPlayerAccessInventoryLambda;
        this.markDirtyNotificationLambda = markDirtyNotificationLambda;
    }

    public static TileInventoryHelper createForBlockEntity(int size,
                                                           Predicate<Player> canPlayerAccessInventoryLambda,
                                                           Notify markDirtyNotificationLambda) {
        return new TileInventoryHelper(size, canPlayerAccessInventoryLambda, markDirtyNotificationLambda);
    }

    public static TileInventoryHelper createForClientSideContainer(int size) {
        return new TileInventoryHelper(size);
    }

    public CompoundTag serializeNBT() {
        return chestContents.serializeNBT();
    }

    public void deserializeNBT(CompoundTag nbt) {
        chestContents.deserializeNBT(nbt);
    }

    @Override
    public boolean stillValid(Player player) {
        return canPlayerAccessInventoryLambda.test(player);
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack) {
        return chestContents.isItemValid(index, stack);
    }

    @Override
    public void setChanged() {
        markDirtyNotificationLambda.invoke();
    }

    @Override
    public void startOpen(Player player) {
        openInventoryNotificationLambda.invoke();
    }

    @Override
    public void stopOpen(Player player) {
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
    @FunctionalInterface
    public interface Notify {
        void invoke();
    }
}