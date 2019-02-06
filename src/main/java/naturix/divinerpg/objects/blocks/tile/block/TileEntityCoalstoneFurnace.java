package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.objects.blocks.CoalstoneFurnace;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.block.CoalstoneFurnaceRecipes;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;

import static naturix.divinerpg.objects.blocks.CoalstoneFurnace.BURNING;
import static naturix.divinerpg.objects.blocks.CoalstoneFurnace.FACING;

/**
 * Created by LiteWolf101 on Jan
 * /29/2019
 */
public class TileEntityCoalstoneFurnace extends TileEntity implements IInventory, ITickable {
    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY); //0 is input. 1 is output.
    private String customName;

    //public int burnTime;
    //public int currentBurnTime;
    public int cookTime;
    public int totalCookTime;


    @Override
    public String getName() {
        return this.hasCustomName()? this.customName : "Coalstone Furnace";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }

    public void setCustomName(String customName){
        this.customName = customName;
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName()? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
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
        return (ItemStack)this.inventory.get(index);
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
        ItemStack itemStack = (ItemStack)this.inventory.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(stack, itemStack);
        this.inventory.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && index + 1 == 1 && !flag) {
            ItemStack stack1 = (ItemStack)this.inventory.get(index + 1);
            this.totalCookTime = this.getCookTime(stack);
            this.cookTime = 0;
            markDirty();
        }
    }

    private int getCookTime(ItemStack stack) {
        return 400;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventory);
        //this.burnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        //this.currentBurnTime = getItemBurnTime((ItemStack)this.inventory.get(0));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        //compound.setInteger("BurnTime", (short)this.burnTime);
        compound.setInteger("CookTime", (short)this.cookTime);
        compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
        ItemStackHelper.saveAllItems(compound, this.inventory);

        if (this.hasCustomName()) {
            compound.setString("CustomName", this.customName);
        }
        return compound;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean canSmelt (){
        if (((ItemStack)this.inventory.get(0)).isEmpty()) {
            return false;
        } else {
            ItemStack result = CoalstoneFurnaceRecipes.getInstance().getResult((ItemStack)this.inventory.get(0));
            if (result.isEmpty()) {
                return false;
            } else {
                ItemStack output = ((ItemStack)this.inventory.get(1));
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
            ItemStack input = (ItemStack)this.inventory.get(0);
            ItemStack output = (ItemStack)this.inventory.get(1);
            ItemStack result = CoalstoneFurnaceRecipes.getInstance().getResult(input);

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
        if (this.world.getTileEntity(this.pos) != this)
        {
            return false;
        }
        else
        {
            return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
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
                    this.totalCookTime = this.getCookTime((ItemStack)this.inventory.get(0));
                    this.smeltItem();
                }
            } else {
                this.cookTime = 0;
            }
            if (this.cookTime < 0) {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }
            if (flag1 == this.canSmelt()) {
                ModBlocks.coalstoneFurnace.setState(this.canSmelt(), world, pos);
                this.markDirty();
            }
        }
    }
}