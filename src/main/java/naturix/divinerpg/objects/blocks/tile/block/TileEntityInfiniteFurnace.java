package naturix.divinerpg.objects.blocks.tile.block;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public abstract class TileEntityInfiniteFurnace extends TileEntity implements IInventory, ITickable {
    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY); // 0 is input. 1 is
                                                                                                    // output.
    private String customName;
    public int cookTime;
    public int totalCookTime;
    public int speed;

    public TileEntityInfiniteFurnace(String name, int speed) {
        this.customName = "tile." + name + "_down.name";
        this.speed = speed;
    }

    public String getName() {
        return this.customName;
    }

    @Override
    public boolean hasCustomName() {
        return true;
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

        if (index == 0 && index + 1 == 1 && !flag) {
            ItemStack stack1 = (ItemStack) this.inventory.get(index + 1);
            this.totalCookTime = this.speed;
            this.cookTime = 0;
            markDirty();
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventory);
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.customName = compound.getString("CustomName");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("CookTime", (short) this.cookTime);
        compound.setInteger("CookTimeTotal", (short) this.totalCookTime);
        ItemStackHelper.saveAllItems(compound, this.inventory);
        compound.setString("CustomName", this.customName);
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
            ItemStack result = FurnaceRecipes.instance().getSmeltingResult((ItemStack) this.inventory.get(0));
            if (result.isEmpty()) {
                return false;
            } else {
                ItemStack output = ((ItemStack) this.inventory.get(1));
                if (output.isEmpty()) {
                    return true;
                }
                if (output.isItemEqual(result)) {
                    return true;
                }
                int res = output.getCount() + result.getCount();
                return res <= getInventoryStackLimit() && res <= output.getMaxStackSize();
            }
        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack input = (ItemStack) this.inventory.get(0);
            ItemStack output = (ItemStack) this.inventory.get(1);
            ItemStack result = FurnaceRecipes.instance().getSmeltingResult(input);

            if (output.isEmpty()) {
                this.inventory.set(1, result.copy());
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
        return index == 0;
    }

    @Override
    public int getField(int id) {
        switch (id) {
        case 0:
            return this.cookTime;
        case 1:
            return this.totalCookTime;
        default:
            return 0;
        }
    }

    @Override
    public void setField(int id, int value) {
        switch (id) {
        case 0:
            this.cookTime = value;
            break;
        case 1:
            this.totalCookTime = value;
        }
    }

    @Override
    public int getFieldCount() {
        return 2;
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }

    public abstract void updateBlockState();

    @Override
    public void update() {
        boolean flag1 = false;
        if (!this.world.isRemote) {
            if (this.canSmelt()) {
                ++cookTime;
                if (cookTime < totalCookTime) {
                    flag1 = true;
                }
                if (cookTime == totalCookTime) {
                    this.cookTime = 0;
                    this.totalCookTime = this.speed;
                    this.smeltItem();
                }
            } else {
                this.cookTime = 0;
            }
            if (this.cookTime < 0) {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }
            if (flag1 == this.canSmelt()) {
                updateBlockState();
                this.markDirty();
            }
        }
    }
}