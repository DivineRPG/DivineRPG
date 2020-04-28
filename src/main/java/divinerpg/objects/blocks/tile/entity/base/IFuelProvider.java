package divinerpg.objects.blocks.tile.entity.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public interface IFuelProvider extends IInventory {

    /**
     * Is block need fuel
     *
     * @return
     */
    boolean needFuel();

    /**
     * Tries to consume fuel.
     * More than zero if founded fuel
     *
     * @return butning ticks
     */
    int consumeFuel();

    /**
     * Called when furnace finished working
     */
    void onFinished();

    /**
     * Called when we start to cook
     */
    void onStart();

    /**
     * Determines if there any possible receipe
     *
     * @return
     */
    boolean haveItemsToSmelt();

    /**
     * Gets current burning ticks
     *
     * @return
     */
    int getBurningTicks();

    /**
     * Set current burning tick
     *
     * @param value
     */
    void setBurningTicks(int value);

    /**
     * Gets current cook time
     *
     * @return
     */
    int getCurrentCookTime();

    /**
     * Sets new cook time
     *
     * @param value
     */
    void setCookTime(int value);

    /**
     * Gets burn time for furnace
     *
     * @return
     */
    int getCookTimeLength();

    /**
     * Called when state of burning was changed
     *
     * @param isBurning
     */
    void changeBurnState(boolean isBurning);

    /**
     * Returbs stacks list reference
     *
     * @return
     */
    NonNullList<ItemStack> getInventoryRef();

    /**
     * Update burning tick
     */
    default void updateBurningTick() {
        int currentBurnTime = getBurningTicks();
        int cookTime = getCurrentCookTime();
        boolean hasRecipe = haveItemsToSmelt();

        // we can't cook, don't have a receipe
        if (!hasRecipe) {
            cooldownFurnace();
            return;
        }

        // try to consume fuel
        if (currentBurnTime <= 0) {
            // infinite furnace alwways has fuel
            currentBurnTime = needFuel()
                    ? consumeFuel()
                    : 20;
        }

        // we don't have fuel
        if (currentBurnTime <= 0) {
            cooldownFurnace();
            return;
        }

        // check if we need to consume recipe
        if (cookTime <= 0) {
            onStart();

            changeBurnState(true);
        }

        // decrease burn time
        setBurningTicks(Math.max(currentBurnTime - 1, 0));

        // increase cook time
        setCookTime(Math.max(cookTime + 1, 0));

        // getting the result
        if (getCurrentCookTime() >= getCookTimeLength()) {
            setCookTime(0);
            onFinished();
        }
    }

    default void cooldownFurnace() {
        int burningTicks = getBurningTicks();
        if (burningTicks > 0) {
            changeBurnState(false);
        }

        setBurningTicks(Math.max(burningTicks - 1, 0));
        setCookTime(Math.max(getCurrentCookTime() - 1, 0));
    }

    @Override
    default ItemStack getStackInSlot(int index) {
        if (0 <= index && index < getSizeInventory()) {
            return getInventoryRef().get(index);
        }

        return ItemStack.EMPTY;
    }

    @Override
    default ItemStack decrStackSize(int index, int count) {
        ItemStack result = ItemStackHelper.getAndSplit(getInventoryRef(), index, count);
        markDirty();
        return result;
    }

    @Override
    default ItemStack removeStackFromSlot(int index) {
        ItemStack result = ItemStackHelper.getAndRemove(getInventoryRef(), index);
        markDirty();
        return result;
    }

    @Override
    default int getSizeInventory() {
        return getInventoryRef().size();
    }

    @Override
    default int getInventoryStackLimit() {
        return 64;
    }

    @Override
    default void setInventorySlotContents(int index, ItemStack stack) {
        this.getInventoryRef().set(index, stack);

        if (!stack.isEmpty() && stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }

        this.markDirty();
    }

    @Override
    default boolean isEmpty() {
        return getInventoryRef().stream().noneMatch(ItemStack::isEmpty);
    }

    @Override
    default void clear() {
        for (int i = 0; i < getSizeInventory(); i++) {
            setInventorySlotContents(i, ItemStack.EMPTY);
        }
    }

    //
    // Default implementation
    //

    @Override
    default void openInventory(EntityPlayer player) {

    }

    @Override
    default void closeInventory(EntityPlayer player) {

    }

    @Override
    default int getFieldCount() {
        return 2;
    }

    @Override
    default int getField(int id) {
        switch (id) {
            case 0:
                return getBurningTicks();

            case 1:
                return getCurrentCookTime();

            default:
                return 0;
        }
    }

    @Override
    default void setField(int id, int value) {
        switch (id) {
            case 0:
                setBurningTicks(value);
                return;

            case 1:
                setCookTime(value);
                return;
        }
    }
}
