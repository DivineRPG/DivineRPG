package naturix.divinerpg.objects.entities.container;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotMerchantResult;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by LiteWolf101 on Feb /19/2019
 */
public class ContainerDivineMerchant extends Container {
    private IMerchant merchant;
    private InventoryMerchant inventoryMerchant;
    private final World world;

    public ContainerDivineMerchant(InventoryPlayer inventory, IMerchant merchant, World world) {
        this.merchant = merchant;
        this.world = world;
        this.inventoryMerchant = new InventoryMerchant(inventory.player, merchant);
        this.addSlotToContainer(new Slot(this.inventoryMerchant, 0, 36, 53));
        this.addSlotToContainer(new Slot(this.inventoryMerchant, 1, 62, 53));
        this.addSlotToContainer(new SlotMerchantResult(inventory.player, merchant, this.inventoryMerchant, 2, 120, 53));

        // player inv
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // player hotbar
        for (int k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(inventory, k, 8 + k * 18, 142));
        }
    }

    public InventoryMerchant getMerchantInventory() {
        return this.inventoryMerchant;
    }

    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        this.inventoryMerchant.resetRecipeAndSlots();
        super.onCraftMatrixChanged(inventoryIn);
    }

    public void setCurrentRecipeIndex(int currentRecipeIndex) {
        this.inventoryMerchant.setCurrentRecipeIndex(currentRecipeIndex);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.merchant.getCustomer() == playerIn;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index != 0 && index != 1) {
                if (index >= 3 && index < 30) {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        this.merchant.setCustomer((EntityPlayer) null);
        super.onContainerClosed(playerIn);

        if (!this.world.isRemote) {
            ItemStack itemstack = this.inventoryMerchant.removeStackFromSlot(0);

            if (!itemstack.isEmpty()) {
                playerIn.dropItem(itemstack, false);
            }

            itemstack = this.inventoryMerchant.removeStackFromSlot(1);

            if (!itemstack.isEmpty()) {
                playerIn.dropItem(itemstack, false);
            }
        }
    }
}
