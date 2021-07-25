package divinerpg.client.containers;

import divinerpg.client.containers.slot.*;
import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.network.*;
import net.minecraft.util.*;

public class InfusionTableContainer<C extends IInventory> extends Container {
    private final IInventory inventory;
    private final IIntArray data;

    public InfusionTableContainer(int id, PlayerInventory playerInventory) {
        this(id, playerInventory, new Inventory(3), new IntArray(3));
    }

    public InfusionTableContainer(int id, PlayerInventory playerInventory, IInventory inventory, IIntArray data) {
        super(ContainerRegistry.INFUSION_TABLE.get(), id);
        checkContainerSize(inventory, 3);
        checkContainerDataCount(data, 3);
        this.inventory = inventory;
        this.data = data;
        addSlot(new Slot(inventory, 0, 18, 39));
        addSlot(new Slot(inventory, 1, 18, 59));
        addSlot(new SlotInfusion(inventory, 2, 63, 49));

        this.addDataSlots(data);

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
        }

    }

    public InfusionTableContainer(int i, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        this(i, playerInventory);
    }

    public boolean stillValid(PlayerEntity player) {
        return this.inventory.stillValid(player);
    }

    public ItemStack quickMoveStack(PlayerEntity player, int s) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(s);

        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            if (s == 2) {
                if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            }
            else if (s != 1 && s != 0) {
                if (s >= 3 && s < 30) {
                    if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if (s >= 30 && s < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            ItemStack itemstack2 = slot.onTake(player, itemstack1);
            if (s == 0) {
                player.drop(itemstack2, false);
            }
        }
        return itemstack;
    }





}
