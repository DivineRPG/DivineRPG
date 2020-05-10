package divinerpg.objects.blocks.tile.container;

import divinerpg.objects.blocks.tile.entity.TileEntityDreamLamp;
import divinerpg.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerDreamLamp extends Container {
    public TileEntityDreamLamp tileEntity;
    public InventoryPlayer inv;
    private final World world;
    private final EntityPlayer player;

    public ContainerDreamLamp(InventoryPlayer inv, World worldIn, TileEntityDreamLamp teLamp)
    {
        this.inv = inv;
        this.player = inv.player;
        this.world = worldIn;
        this.tileEntity = teLamp;
        this.addSlotToContainer(new SlotDreamLamp(tileEntity, 0, 80, 47));
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

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUsableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if(itemstack.getItem() != ModItems.acid) {
                return ItemStack.EMPTY;
            }
            if (index == 0 && !this.mergeItemStack(itemstack1, 1, 37, false))
            {
                return ItemStack.EMPTY;
            }
            else if (index != 0 && !this.mergeItemStack(itemstack1, 0, 1, false))
            {
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
}
