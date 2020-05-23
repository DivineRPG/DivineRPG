package divinerpg.objects.blocks.tile.entity;

import divinerpg.registry.InfusionTableRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;

public class TileEntityInfusionTable extends TileEntity implements ITickable, IInventory {

    private NonNullList<ItemStack> inventory;

    public TileEntityInfusionTable() {
        this.inventory = NonNullList.withSize(3, ItemStack.EMPTY);
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
    public int getSizeInventory() {
        return inventory.size();
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return inventory.get(i);
    }

    @Override
    public ItemStack removeStackFromSlot(int i) {
        return ItemStackHelper.getAndRemove(this.inventory, i);
    }

    @Override
    public void update() {
        ItemStack inputStack = inventory.get(0);
        ItemStack templateStack = inventory.get(1);

        if(!inputStack.isEmpty() && !templateStack.isEmpty()) {
            Item input = inventory.get(0).getItem();
            Item template = inventory.get(1).getItem();
            int inputCount = inventory.get(0).getCount();

            InfusionTableRecipes x = InfusionTableRecipes.instance;
            Item item = x.getOutput(input, template, inputCount);
            if(item != null) {
                inventory.set(2, new ItemStack(item));
            }
            else {
                inventory.set(2, ItemStack.EMPTY);
            }
        }
        else {
            inventory.set(2, ItemStack.EMPTY);
        }
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        inventory.set(i, itemstack);
        if (itemstack != null && itemstack.getCount() > getInventoryStackLimit()) {
            itemstack.setCount(getInventoryStackLimit());
        }
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        NBTTagList nbttaglist = tag.getTagList("Items", 10);

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.inventory.size()) {
                ItemStackHelper.loadAllItems(nbttagcompound1, inventory);
            }
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        NBTTagList list = new NBTTagList();

        for (int i = 0; i < this.inventory.size(); ++i) {
            if (this.inventory.get(i) != null) {
                NBTTagCompound slottag = new NBTTagCompound();
                slottag.setByte("Slot", (byte)i);
                this.inventory.get(i).writeToNBT(slottag);
                list.appendTag(slottag);
            }
        }

        tag.setTag("Items", list);
        return tag;

    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return player.world.getTileEntity(pos) == this && player.getDistanceSq(pos) < 64;
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public int getField(int i) {
        return 0;
    }

    @Override
    public void setField(int var1, int var2) {
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        for(ItemStack stack: inventory) {
            stack.setCount(0);
        }
    }

    @Override
    public String getName() {
        return "TeInfusionTable";
    }

    @Override
    public boolean hasCustomName() {
        return true;
    }
}
