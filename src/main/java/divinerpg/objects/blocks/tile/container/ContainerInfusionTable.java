package divinerpg.objects.blocks.tile.container;

import divinerpg.objects.blocks.tile.entity.TileEntityInfusionTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerInfusionTable extends Container {
    public TileEntityInfusionTable tileentity;
    private final World world;
    private final EntityPlayer player;

    public ContainerInfusionTable(InventoryPlayer inv, World worldIn, TileEntityInfusionTable te) {
        this.tileentity = te;
        this.world = worldIn;
        this.player = inv.player;
        addSlotToContainer(new Slot(te, 0, 18, 39));
        addSlotToContainer(new Slot(te, 1, 18, 59));
        addSlotToContainer(new SlotInfusion(inv.player, te, 2, 63, 49));
        bindPlayerInventory(inv);
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
            }
            else if (index != 1 && index != 0) {
                if (index >= 3 && index < 30) {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
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

            ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);
            if (index == 0) {
                playerIn.dropItem(itemstack2, false);
            }
        }
        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileentity.isUsableByPlayer(player);
    }

    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        if (!this.world.isRemote) {
            this.clearContainer(playerIn, this.world, this.tileentity);
        }

    }

    protected void clearContainer(EntityPlayer playerIn, World worldIn, IInventory inventoryIn) {
        int i;
        if (!playerIn.isEntityAlive() || playerIn instanceof EntityPlayerMP && ((EntityPlayerMP)playerIn).hasDisconnected()) {
            for(i = 0; i < inventoryIn.getSizeInventory(); ++i) {
                if(i != 2) {
                    playerIn.dropItem(inventoryIn.removeStackFromSlot(i), false);
                }
            }
        } else {
            for(i = 0; i < inventoryIn.getSizeInventory(); ++i) {
                if(i != 2) {
                    playerIn.inventory.placeItemBackInInventory(worldIn, inventoryIn.removeStackFromSlot(i));
                }
            }
        }
    }
}