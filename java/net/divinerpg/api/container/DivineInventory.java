package net.divinerpg.api.container;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class DivineInventory extends InventoryMerchant implements IInventory
{
    private final IMerchant theMerchant;
    private final EntityPlayer thePlayer;
    private ItemStack[] theInventory;
    private MerchantRecipe currentRecipe;
    private int currentRecipeIndex;

    public DivineInventory(EntityPlayer par1EntityPlayer, IMerchant par2IMerchant, int par3)
    {
        super(par1EntityPlayer, par2IMerchant);
        theInventory = new ItemStack[par3];
        this.thePlayer = par1EntityPlayer;
        this.theMerchant = par2IMerchant;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.theInventory.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.theInventory[par1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.theInventory[par1] != null)
        {
            ItemStack var3;

            if (par1 == 2)
            {
                var3 = this.theInventory[par1];
                this.theInventory[par1] = null;
                return var3;
            }
            else if (this.theInventory[par1].stackSize <= par2)
            {
                var3 = this.theInventory[par1];
                this.theInventory[par1] = null;

                if (this.inventoryResetNeededOnSlotChange(par1))
                {
                    this.resetRecipeAndSlots();
                }

                return var3;
            }
            else
            {
                var3 = this.theInventory[par1].splitStack(par2);

                if (this.theInventory[par1].stackSize == 0)
                {
                    this.theInventory[par1] = null;
                }

                if (this.inventoryResetNeededOnSlotChange(par1))
                {
                    this.resetRecipeAndSlots();
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * if par1 slot has changed, does resetRecipeAndSlots need to be called?
     */
    private boolean inventoryResetNeededOnSlotChange(int par1)
    {
        return par1 == 0 || par1 == 1;
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.theInventory[par1] != null)
        {
            ItemStack var2 = this.theInventory[par1];
            this.theInventory[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.theInventory[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }

        if (this.inventoryResetNeededOnSlotChange(par1))
        {
            this.resetRecipeAndSlots();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "mob.villager";
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.theMerchant.getCustomer() == par1EntityPlayer;
    }

    public void openChest() {}

    public void closeChest() {}

    /**
     * Called when an the contents of an Inventory change, usually
     */
    public void onInventoryChanged()
    {
        this.resetRecipeAndSlots();
    }

    public void resetRecipeAndSlots()
    {
        this.currentRecipe = null;
        ItemStack var1 = this.theInventory[0];
        ItemStack var2 = this.theInventory[1];

        if (var1 == null)
        {
            var1 = var2;
            var2 = null;
        }

        if (var1 == null)
        {
            this.setInventorySlotContents(2, (ItemStack)null);
        }
        else
        {
            MerchantRecipeList var3 = this.theMerchant.getRecipes(this.thePlayer);

            if (var3 != null)
            {
                MerchantRecipe var4 = var3.canRecipeBeUsed(var1, var2, this.currentRecipeIndex);

                if (var4 != null && !var4.isRecipeDisabled())
                {
                    this.currentRecipe = var4;
                    this.setInventorySlotContents(2, var4.getItemToSell().copy());
                }
                else if (var2 != null)
                {
                    var4 = var3.canRecipeBeUsed(var2, var1, this.currentRecipeIndex);

                    if (var4 != null && !var4.isRecipeDisabled())
                    {
                        this.currentRecipe = var4;
                        this.setInventorySlotContents(2, var4.getItemToSell().copy());
                    }
                    else
                    {
                        this.setInventorySlotContents(2, (ItemStack)null);
                    }
                }
                else
                {
                    this.setInventorySlotContents(2, (ItemStack)null);
                }
            }
        }
    }

    public MerchantRecipe getCurrentRecipe()
    {
        return this.currentRecipe;
    }

    public void setCurrentRecipeIndex(int par1)
    {
        this.currentRecipeIndex = par1;
        this.resetRecipeAndSlots();
    }
}
