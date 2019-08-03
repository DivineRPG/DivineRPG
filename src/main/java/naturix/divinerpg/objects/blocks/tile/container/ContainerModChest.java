package naturix.divinerpg.objects.blocks.tile.container;

import naturix.divinerpg.objects.blocks.tile.entity.TileEntityModChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerModChest extends Container {
    private final int numRows;
    private final TileEntityModChest chestInventory;

    public ContainerModChest(InventoryPlayer playerInventory, TileEntityModChest chestInventory, EntityPlayer player) {
        this.chestInventory = chestInventory;
        this.numRows = chestInventory.getSizeInventory() / 9;
        chestInventory.openInventory(player);

        int iY = 18;

        //chest inv
        for (int i = 0; i < this.numRows; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(chestInventory, j + i * 9, 8 + j * 18, iY));
            }
            iY += 18;
        }

        iY += 14;

        //player inv
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, iY));
            }
            iY += 18;
        }

        iY += 4;

        //player hotbar
        for (int k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, iY));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.chestInventory.isUsableByPlayer(playerIn);
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        chestInventory.closeInventory(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (index < this.numRows * 9) {
                if (!this.mergeItemStack(itemStack1, this.numRows * 9, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemStack1, 0, this.numRows * 9, false)) {
                return ItemStack.EMPTY;
            }
            if (itemStack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemStack;
    }

    public TileEntityModChest getChestInventory() {
        return this.chestInventory;
    }
}
