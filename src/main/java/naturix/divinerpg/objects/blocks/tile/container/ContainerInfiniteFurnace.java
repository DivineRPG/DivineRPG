package naturix.divinerpg.objects.blocks.tile.container;

import naturix.divinerpg.objects.blocks.tile.block.TileEntityInfiniteFurnace;
import naturix.divinerpg.objects.blocks.tile.container.slot.SlotInfiniteFurnaceOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerInfiniteFurnace extends Container {
    private final TileEntityInfiniteFurnace tileEntity;
    private int cookTime, totalCookTime;

    public ContainerInfiniteFurnace(InventoryPlayer player, TileEntityInfiniteFurnace tileEntity) {
        this.tileEntity = tileEntity;

        this.addSlotToContainer(new Slot(tileEntity, 0, 56, 17));
        this.addSlotToContainer(new SlotInfiniteFurnaceOutput(player.player, tileEntity, 1, 116, 35));

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(player, k, 8 + k * 18, 142));
        }
    }

    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileEntity);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); i++) {
            IContainerListener listener = (IContainerListener) this.listeners.get(i);

            if (this.cookTime != this.tileEntity.getField(0)) {
                listener.sendWindowProperty(this, 0, this.tileEntity.getField(0));
            }
            if (this.totalCookTime != this.tileEntity.getField(1)) {
                listener.sendWindowProperty(this, 1, this.tileEntity.getField(1));
            }
        }
        this.cookTime = this.tileEntity.getField(0);
        this.totalCookTime = this.tileEntity.getField(1);
    }

    @Override
    public void updateProgressBar(int id, int data) {
        this.tileEntity.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileEntity.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack previous = ItemStack.EMPTY;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();
            int inventorySize = tileEntity.getSizeInventory();

            if (index < inventorySize) {
                // From container inventory to player's inventory
                if (!this.mergeItemStack(current, inventorySize, inventorySize + 36, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // From the player's inventory to container
                if (!this.mergeItemStack(current, 0, 1, false))
                    return ItemStack.EMPTY;

                if (current.getCount() == 0)
                    slot.putStack(ItemStack.EMPTY);
                else
                    slot.onSlotChanged();

                if (current.getCount() == previous.getCount())
                    return null;
                slot.onTake(playerIn, current);
            }
        }
        return previous;
    }
}