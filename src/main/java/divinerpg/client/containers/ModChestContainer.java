package divinerpg.client.containers;

import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.network.*;

public class ModChestContainer<C extends IInventory> extends Container {
    private final IInventory inventory;

    public ModChestContainer(int i, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        this(ContainerRegistry.EDEN_CHEST.get(), i, playerInventory, new Inventory(54));
    }

    public static ModChestContainer createEdenContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
        return new ModChestContainer(ContainerRegistry.EDEN_CHEST.get(), windowId, playerInventory, inventory);
    }

    public ModChestContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory, IInventory inventory) {
        super(containerType, windowId);
        checkContainerSize(inventory, 54);
        this.inventory = inventory;
        inventory.startOpen(playerInventory.player);
        int i = (6 - 4) * 18;

        for(int j = 0; j < 6; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, (103 + l * 18 + i) +1));
            }
        }

        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, (161 + i) + 1));
        }
    }

    public boolean stillValid(PlayerEntity p_75145_1_) {
        return this.inventory.stillValid(p_75145_1_);
    }

    public ItemStack quickMoveStack(PlayerEntity p_82846_1_, int p_82846_2_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_82846_2_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (p_82846_2_ < 6 * 9) {
                if (!this.moveItemStackTo(itemstack1, 6 * 9, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, 6 * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    public void removed(PlayerEntity p_75134_1_) {
        super.removed(p_75134_1_);
        this.inventory.stopOpen(p_75134_1_);
    }

    public IInventory getInventory() {
        return this.inventory;
    }

}