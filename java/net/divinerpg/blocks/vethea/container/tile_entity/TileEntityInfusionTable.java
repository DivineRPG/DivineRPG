package net.divinerpg.blocks.vethea.container.tile_entity;

import net.divinerpg.blocks.vethea.container.ContainerInfusionTable;
import net.divinerpg.utils.recipes.RecipesInfusionTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
		if(inventory[2] == null) {
			if(inventory[0] != null && inventory[1] != null) {
				Item item1 = inventory[0].getItem();
				Item item2 = inventory[1].getItem();
				if(item1 != null && item2 != null) {
					RecipesInfusionTable x = new RecipesInfusionTable();
					ItemStack item = x.getResult(item1, item2);
					if(item != null && x.getStackSize(item1, item2) <= inventory[0].stackSize) {
						inventory[2] = item;
						this.decrStackSize(0, x.getStackSize(item1, item2));
						this.decrStackSize(1, 1);
					}
				}
			}
		}
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
}
