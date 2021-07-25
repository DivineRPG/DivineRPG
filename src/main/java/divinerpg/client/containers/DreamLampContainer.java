package divinerpg.client.containers;

import divinerpg.client.containers.slot.*;
import divinerpg.registries.*;
import divinerpg.tiles.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.network.*;
import net.minecraft.world.*;

public class DreamLampContainer<C extends IInventory> extends Container {
    public TileEntityDreamLamp tileEntity;
    public PlayerInventory inv;
    private final World world;
    private final PlayerEntity player;

    public DreamLampContainer(PlayerInventory inv, World worldIn, TileEntityDreamLamp teLamp)
    {
        super(ContainerRegistry.DREAM_LAMP.get(), teLamp.hashCode());
        this.inv = inv;
        this.player = inv.player;
        this.world = worldIn;
        this.tileEntity = teLamp;
        this.addSlot(new SlotDreamLamp(tileEntity, 0, 80, 47));
        bindPlayerInventory(inv);
    }

    public DreamLampContainer(int i, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        this(playerInventory, playerInventory.player.level, TileRegistry.DREAM_LAMP.create());
    }

    public void bindPlayerInventory(PlayerInventory inventoryplayer) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {
                addSlot(new Slot(inventoryplayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int i = 0; i < 9; i++) {
            addSlot(new Slot(inventoryplayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return tileEntity.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            if(itemstack.getItem() != ItemRegistry.acid) {
                return ItemStack.EMPTY;
            }
            if (index == 0 && !this.moveItemStackTo(itemstack1, 1, 37, false))
            {
                return ItemStack.EMPTY;
            }
            else if (index != 0 && !this.moveItemStackTo(itemstack1, 0, 1, false))
            {
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

            ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);
            if (index == 0) {
                playerIn.drop(itemstack2, false);
            }
        }

        return itemstack;
    }
}
