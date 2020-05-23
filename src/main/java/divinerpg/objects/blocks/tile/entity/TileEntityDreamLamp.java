package divinerpg.objects.blocks.tile.entity;

import divinerpg.objects.blocks.vethea.BlockDreamLamp;
import divinerpg.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityDreamLamp extends TileEntity implements ITickable, IInventory {

    private NonNullList<ItemStack> inventory;

    public TileEntityDreamLamp() {
        this.inventory = NonNullList.withSize(1, ItemStack.EMPTY);
    }

    @Override
    public void update() {
        if(!this.world.isRemote) {
            ItemStack acidStack = inventory.get(0);
            boolean powerOn = false;
            if (!acidStack.isEmpty() && acidStack.getItem() == ItemRegistry.acid) {
                powerOn = true;
            } else if (acidStack.isEmpty() || acidStack.getItem() != ItemRegistry.acid) {
                powerOn = false;
            }

            Block block = this.world.getBlockState(this.pos).getBlock();
            if (block instanceof BlockDreamLamp) {
                if (powerOn) {
                    ((BlockDreamLamp) block).setOn(this.world, this.pos);
                } else {
                    ((BlockDreamLamp) block).setOff(this.world, this.pos);
                }
            }
            this.markDirty();
        }
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
        return false;
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
    public ItemStack getStackInSlot(int slotIn) {
        return inventory.get(slotIn);
    }

    @Override
    public ItemStack removeStackFromSlot(int i) {
        return ItemStackHelper.getAndRemove(this.inventory, i);
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack itemstack) {
        this.inventory.set(index, itemstack);
        if (itemstack != null && itemstack.getCount() > getInventoryStackLimit()) {
            itemstack.setCount(getInventoryStackLimit());
        }
    }

    @Override
    public String getName() {
        return "Dream Lamp";
    }

    @Override
    public boolean hasCustomName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return player.world.getTileEntity(pos) == this && player.getDistanceSq(pos) < 64;
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return stack != ItemStack.EMPTY && stack.getItem() == ItemRegistry.acid;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        ItemStackHelper.saveAllItems(tag, this.inventory);
        return tag;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        ItemStackHelper.loadAllItems(tag, this.inventory);
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
}

