package net.divinerpg.blocks.base.tileentity;

import org.apache.logging.log4j.core.filter.BurstFilter;

import net.divinerpg.utils.recipes.ExtractorRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class TileEntityInfiniteFurnace extends TileEntity implements ISidedInventory {
	
    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {1};
    protected ItemStack[] furnaceItemStacks = new ItemStack[2];
    public int furnaceBurnTime, furnaceCookTime, speed, flameTime;
    private String customName;
    
    public TileEntityInfiniteFurnace(String name, int speed) {
		setCustomName(name);
		this.speed = speed;
	}

    @Override
    public int getSizeInventory() {
        return this.furnaceItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int par1) {
        return this.furnaceItemStacks[par1];
    }

    @Override
    public ItemStack decrStackSize(int par1, int par2) {
        if(this.furnaceItemStacks[par1] != null) {
            ItemStack itemstack;
            if(this.furnaceItemStacks[par1].stackSize <= par2) {
                itemstack = this.furnaceItemStacks[par1];
                this.furnaceItemStacks[par1] = null;
                return itemstack;
            } else {
                itemstack = this.furnaceItemStacks[par1].splitStack(par2);
                if (this.furnaceItemStacks[par1].stackSize == 0) this.furnaceItemStacks[par1] = null;
                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int par1) {
        if(this.furnaceItemStacks[par1] != null) {
            ItemStack itemstack = this.furnaceItemStacks[par1];
            this.furnaceItemStacks[par1] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
        this.furnaceItemStacks[par1] = par2ItemStack;
        if(par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) 
        	par2ItemStack.stackSize = this.getInventoryStackLimit();
    }

    @Override
    public String getInventoryName() {
        return this.customName;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    public void setCustomName(String s) {
        this.customName = s;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for(int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b = nbttagcompound1.getByte("Slot");

            if(b >= 0 && b < this.furnaceItemStacks.length) this.furnaceItemStacks[b] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
        }
        this.furnaceBurnTime = nbt.getShort("BurnTime");
        this.furnaceCookTime = nbt.getShort("CookTime");

        if(nbt.hasKey("CustomName", 8)) this.customName = nbt.getString("CustomName");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("BurnTime", (short)this.furnaceBurnTime);
        nbt.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < this.furnaceItemStacks.length; ++i) {
            if(this.furnaceItemStacks[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbt.setTag("Items", nbttaglist);
        if (this.hasCustomInventoryName()) nbt.setString("CustomName", this.customName);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int i) {
        return this.furnaceCookTime * i / speed;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int i) {
        return this.furnaceBurnTime * i / 40;
    }

    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    public abstract void addUpdate();

	@Override
    public void updateEntity() {
        boolean flag = this.furnaceBurnTime > 0;
        boolean flag1 = false;

        if(this.furnaceBurnTime > 0) --this.furnaceBurnTime;

        if(!this.worldObj.isRemote) {
            if(this.furnaceBurnTime == 0 && this.canSmelt()) {
                this.furnaceBurnTime = 40;
            }

            if(this.isBurning() && this.canSmelt()) {
                ++this.furnaceCookTime;
                if(this.flameTime > 0) this.flameTime--;
                else this.flameTime = 40;

                if(this.furnaceCookTime == speed) {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    flag1 = true;
                }
            } else {
                this.furnaceCookTime = 0;
            }

            if(flag != this.furnaceBurnTime > 0) {
                flag1 = true;
                addUpdate();
            }
        }

        if(flag1) this.markDirty();
    }

	private boolean canSmelt() {
		if (this.furnaceItemStacks[0] == null) {
			return false;
		} else {
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
			if (itemstack == null) return false;
			if (this.furnaceItemStacks[1] == null) return true;
			if (!this.furnaceItemStacks[1].isItemEqual(itemstack)) return false;
			int result = furnaceItemStacks[1].stackSize + itemstack.stackSize;
			return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[1].getMaxStackSize();
		}
	}


    public void smeltItem() {
        if(this.canSmelt()) {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);

            if(this.furnaceItemStacks[1] == null) 
                this.furnaceItemStacks[1] = itemstack.copy();
            
            else if(this.furnaceItemStacks[1].getItem() == itemstack.getItem()) 
                this.furnaceItemStacks[1].stackSize += itemstack.stackSize;
            

            --this.furnaceItemStacks[0].stackSize;

            if(this.furnaceItemStacks[0].stackSize <= 0) this.furnaceItemStacks[0] = null;
        }
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack par2ItemStack) {
        return slot != 1;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int slot) {
        return slot == 0 ? slotsBottom : (slot == 1 ? slotsTop : new int[]{});
    }

    @Override
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3) {
        return this.isItemValidForSlot(par1, par2ItemStack);
    }

    @Override
    public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3) {
        return par3 != 0 || par1 != 1 || par2ItemStack.getItem() == Items.bucket;
    }
}