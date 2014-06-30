package net.divinerpg.blocks.vethea.container;

import net.divinerpg.blocks.vethea.container.tile_entity.TileEntityInfusionTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerInfusionTable extends Container {
	public TileEntityInfusionTable tileentity;
	private Slot slot;
	
	public ContainerInfusionTable(InventoryPlayer player_inventory, TileEntityInfusionTable tile_entity) {
		this.tileentity = tile_entity;
		addSlotToContainer(new Slot(tile_entity, 0, 18, 39));
		addSlotToContainer(new Slot(tile_entity, 1, 18, 59));
		slot = addSlotToContainer(new SlotFurnace(player_inventory.player, tile_entity, 2, 63, 49));
		bindPlayerInventory(player_inventory);
	}

	public void bindPlayerInventory(InventoryPlayer inventoryplayer) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryplayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryplayer, i, 8 + i * 18, 142));
		}
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 0) {
                if (!this.mergeItemStack(itemstack1, 1, 37, true)) {
                    return null;
                }
            } else {
                if (((Slot)this.inventorySlots.get(0)).getHasStack() || !((Slot)this.inventorySlots.get(0)).isItemValid(itemstack1)) {
                    return null;
                }

                if (itemstack1.hasTagCompound() && itemstack1.stackSize == 1) {
                    ((Slot)this.inventorySlots.get(0)).putStack(itemstack1.copy());
                    itemstack1.stackSize = 0;
                }
                else if (itemstack1.stackSize >= 1) {
                    ((Slot)this.inventorySlots.get(0)).putStack(new ItemStack(itemstack1.getItem(), 1, itemstack1.getItemDamage()));
                    itemstack1.stackSize--;
                }
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }
        return itemstack;
    }

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tileentity.isUseableByPlayer(player);
	}
}
