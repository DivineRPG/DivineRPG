package net.divinerpg.blocks.vethea.container.tileentity;

import net.divinerpg.utils.recipes.RecipesInfusionTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInfusionTable extends TileEntity implements IInventory {
	
	private ItemStack[] inventory = new ItemStack[3];
	private boolean decreaseable = false;

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
        return inventory[i];
	}

	public void updateEntity() {
		if(inventory[0] != null && inventory[1] != null) {
			Item item1 = inventory[0].getItem();
			Item item2 = inventory[1].getItem();
			int c = inventory[0].stackSize;
			if(item1 != null && item2 != null) {
				RecipesInfusionTable x = new RecipesInfusionTable();
				Item item = x.getOutput(item1, item2, c);
				if(item != null) inventory[2] = new ItemStack(item);
				else inventory[2] = null;
			}
		} else inventory[2] = null;
		super.updateEntity();
	}
	
	@Override
    public ItemStack decrStackSize(int i, int j) {
        if (inventory[i] != null) {
            if (inventory[i].stackSize <= j) {
                ItemStack itemstack = inventory[i];
                inventory[i] = null;
                return itemstack;
            }
            ItemStack itemstack1 = inventory[i].splitStack(j);
            if (inventory[i].stackSize == 0) {
            	inventory[i] = null;
            }
            return itemstack1;
        } else {
            return null;
        }
    }

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		return null;
	}

	@Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        inventory[i] = itemstack;
        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
	
    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        return true;
    }

	@Override
	public String getInventoryName() {
		return "TeInfusionTable";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public void openInventory() { }

	@Override
	public void closeInventory() { }
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        NBTTagList nbttaglist = tag.getTagList("Items", 10);
        this.inventory = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.inventory.length) {
                this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		NBTTagList list = new NBTTagList();

	    for (int i = 0; i < this.inventory.length; ++i) {
	        if (this.inventory[i] != null) {
	            NBTTagCompound slottag = new NBTTagCompound();
	            slottag.setByte("Slot", (byte)i);
	            this.inventory[i].writeToNBT(slottag);
	            list.appendTag(slottag);
	        }
	    }

	    tag.setTag("Items", list);
	}
}
