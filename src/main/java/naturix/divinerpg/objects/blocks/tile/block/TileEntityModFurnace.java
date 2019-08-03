package naturix.divinerpg.objects.blocks.tile.block;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public abstract class TileEntityModFurnace extends TileEntity implements ISidedInventory, ITickable {
    // 0 is input. 1 is fuel and 2 is output.
    private static final int[] SLOTS_TOP = new int[] { 0 };
    private static final int[] SLOTS_BOTTOM = new int[] { 2, 1 };
    private static final int[] SLOTS_SIDES = new int[] { 1 };
    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
    public int furnaceBurnTime;
    public int currentItemBurnTime;
    public int cookTime;
    public int totalCookTime;
    public String customName;
    public boolean wasBurning;

    abstract public String getFuranceName();

    abstract int getFurnaceSpeed();

    abstract public boolean needsFuel();

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : getFuranceName();
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentTranslation(this.getName());
    }

    @Override
    public int getSizeInventory() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.inventory) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return (ItemStack) this.inventory.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemStack = (ItemStack) this.inventory.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemStack)
                && ItemStack.areItemStackTagsEqual(stack, itemStack);
        this.inventory.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag) {
            ItemStack stack1 = (ItemStack) this.inventory.get(index + 1);
            this.totalCookTime = this.getFurnaceSpeed();
            this.cookTime = 0;
            markDirty();
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventory);
        this.furnaceBurnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.currentItemBurnTime = TileEntityFurnace.getItemBurnTime(this.inventory.get(1));
        if (compound.hasKey("CustomName", 8)) {
            this.customName = compound.getString("CustomName");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", (short) this.furnaceBurnTime);
        compound.setInteger("CookTime", (short) this.cookTime);
        compound.setInteger("CookTimeTotal", (short) this.totalCookTime);
        ItemStackHelper.saveAllItems(compound, this.inventory);
        if (compound.hasKey("CustomName", 8)) {
            compound.setString("CustomName", this.customName);
        }
        return compound;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean canSmelt() {
        if (((ItemStack) this.inventory.get(0)).isEmpty()) {
            return false;
        } else {
            ItemStack result = this.getSmeltingResult((ItemStack) this.inventory.get(0));
            if (result.isEmpty()) {
                return false;
            } else {
                ItemStack output = ((ItemStack) this.inventory.get(2));
                if (output.isEmpty()) {
                    return true;
                }
                if (!output.isItemEqual(result)) {
                    return false;
                }
                int res = output.getCount() + result.getCount();
                return res <= getInventoryStackLimit() && res <= output.getMaxStackSize();
            }
        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack input = (ItemStack) this.inventory.get(0);
            ItemStack output = (ItemStack) this.inventory.get(2);
            ItemStack result = this.getSmeltingResult(input);

            if (output.isEmpty()) {
                this.inventory.set(2, result.copy());
            } else if (output.getItem() == result.getItem()) {
                output.grow(result.getCount());
            }

            input.shrink(1);
        }
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        if (this.world.getTileEntity(this.pos) != this) {
            return false;
        } else {
            return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
                    (double) this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return index == 0 || (this.needsFuel() && index == 1 && TileEntityFurnace.isItemFuel(stack));
    }

    @Override
    public int getField(int id) {
        switch (id) {
        case 0:
            return this.furnaceBurnTime;
        case 1:
            return this.currentItemBurnTime;
        case 2:
            return this.cookTime;
        case 3:
            return this.totalCookTime;
        default:
            return 0;
        }
    }

    @Override
    public void setField(int id, int value) {
        switch (id) {
        case 0:
            this.furnaceBurnTime = value;
            break;
        case 1:
            this.currentItemBurnTime = value;
            break;
        case 2:
            this.cookTime = value;
            break;
        case 3:
            this.totalCookTime = value;
        }
    }

    @Override
    public int getFieldCount() {
        return 4;
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }

    public abstract void updateBlockState(boolean isBurning);

    @Override
    public void update() {

        if (!this.world.isRemote) {
            boolean isDirty = false;
            boolean isBurning = false;

            if (this.needsFuel()) {
                ItemStack itemstack = this.inventory.get(1);

                if (this.furnaceBurnTime > 0) {
                    --this.furnaceBurnTime;
                    if (!(this.furnaceBurnTime > 0)) {
                        isDirty = true;
                    } else {
                        isBurning = true;
                    }
                }

                if ((isBurning || !itemstack.isEmpty()) && !((ItemStack) this.inventory.get(0)).isEmpty()) {
                    if (!isBurning && this.canSmelt()) {
                        this.furnaceBurnTime = this.currentItemBurnTime = this.getItemBurnTime(itemstack);

                        if (this.furnaceBurnTime > 0) {
                            isDirty = true;
                            isBurning = true;

                            if (!itemstack.isEmpty()) {
                                Item item = itemstack.getItem();
                                itemstack.shrink(1);

                                if (itemstack.isEmpty()) {
                                    ItemStack item1 = item.getContainerItem(itemstack);
                                    this.inventory.set(1, item1);
                                }
                            }
                        }
                    }
                }
            } else {
                isBurning = this.canSmelt();
            }

            if (isBurning) {
                if (this.canSmelt()) {
                    ++this.cookTime;

                    if (this.cookTime == this.totalCookTime) {
                        this.cookTime = 0;
                        this.totalCookTime = this.getFurnaceSpeed();
                        this.smeltItem();
                        isDirty = true;
                    }
                }
            } else if (this.cookTime > 0) {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }

            if (this.wasBurning != isBurning) {
                updateBlockState(isBurning);
            }
            this.wasBurning = isBurning;

            if (isDirty) {
                this.markDirty();
            }
        }
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        if (side == EnumFacing.DOWN) {
            return SLOTS_BOTTOM;
        } else {
            return side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES;
        }
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        if (index == 1) {
            return true;
        }
        return false;
    }

    public int getItemBurnTime(ItemStack stack) {
        return TileEntityFurnace.getItemBurnTime(stack);
    }

    public ItemStack getSmeltingResult(ItemStack stack) {
        return FurnaceRecipes.instance().getSmeltingResult(stack);
    }
}