package net.divinerpg.blocks.vethea.container.tileentity;

import net.divinerpg.blocks.vethea.BlockDreamLamp;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDreamLamp extends TileEntity implements IInventory {
    public ItemStack slot;
    
    @Override
    public void updateEntity() {
        super.updateEntity();
        if(slot != null && slot.getItem() == VetheaItems.acid && this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord) == VetheaBlocks.dreamLamp) {
            BlockDreamLamp.updateState(true, this.getWorld(), this.xCoord, this.yCoord, this.zCoord);
        } else if((slot == null || (slot != null && slot.getItem() != VetheaItems.acid)) && this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord) == VetheaBlocks.dreamLampOn) {
            BlockDreamLamp.updateState(false, this.getWorld(), this.xCoord, this.yCoord, this.zCoord);
        }
    }
    
    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int slotIn) {
        return slot;
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        if (this.slot != null)
        {
            ItemStack itemstack;

            if (this.slot.stackSize <= count) {
                itemstack = this.slot;
                this.slot = null;
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.slot.splitStack(count);
                if (this.slot.stackSize == 0) this.slot = null;
                this.markDirty();
                return itemstack;
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        return slot;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        slot = stack;
    }

    @Override
    public String getInventoryName() {
        return "Dream Lamp";
    }

    @Override
    public boolean isCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openChest() {}

    @Override
    public void closeChest() {}

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return stack != null && stack.getItem() == VetheaItems.acid;
    }
    
    @Override
    public Packet getDescriptionPacket() {
        if(slot != null) return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 3, slot.writeToNBT(new NBTTagCompound()));
        return null;
    }
    
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        this.slot = ItemStack.loadItemStackFromNBT(packet.getNbtCompound());
    }
    
    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        if(this.slot != null) tag.setTag("Slot", this.slot.writeToNBT(new NBTTagCompound()));
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        if(tag.hasKey("Slot")) this.slot = ItemStack.loadItemStackFromNBT((NBTTagCompound) tag.getTag("Slot"));
    }
}
