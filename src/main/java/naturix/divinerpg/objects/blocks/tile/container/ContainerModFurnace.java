package naturix.divinerpg.objects.blocks.tile.container;

import naturix.divinerpg.objects.blocks.tile.block.TileEntityModFurnace;
import naturix.divinerpg.objects.blocks.tile.container.slot.DummySlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
public class ContainerModFurnace extends Container {
    private final TileEntityInfiniteFurnace tileEntity;
    private int cookTime, totalCookTime;

    public ContainerModFurnace(InventoryPlayer player, TileEntityInfiniteFurnace tileEntity) {
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
*/
public class ContainerModFurnace extends Container {
    private final IInventory tileFurnace;
    private int cookTime;
    private int totalCookTime;
    private int furnaceBurnTime;
    private int currentItemBurnTime;

    public ContainerModFurnace(InventoryPlayer playerInventory, TileEntityModFurnace tileEntity) {
        this.tileFurnace = tileEntity;
        this.addSlotToContainer(new Slot(tileEntity, 0, 56, 17));
        if (tileEntity.needsFuel()) {
            this.addSlotToContainer(new SlotFurnaceFuel(tileEntity, 1, 56, 53));
        } else {
            this.addSlotToContainer(new DummySlot(tileEntity, 1, 56, 53));
        }
        this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, tileEntity, 2, 116, 35));

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }

    @Override
    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileFurnace);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i) {
            IContainerListener icontainerlistener = this.listeners.get(i);
            if (this.cookTime != this.tileFurnace.getField(2)) {
                icontainerlistener.sendWindowProperty(this, 2, this.tileFurnace.getField(2));
            }
            if (this.furnaceBurnTime != this.tileFurnace.getField(0)) {
                icontainerlistener.sendWindowProperty(this, 0, this.tileFurnace.getField(0));
            }
            if (this.currentItemBurnTime != this.tileFurnace.getField(1)) {
                icontainerlistener.sendWindowProperty(this, 1, this.tileFurnace.getField(1));
            }
            if (this.totalCookTime != this.tileFurnace.getField(3)) {
                icontainerlistener.sendWindowProperty(this, 3, this.tileFurnace.getField(3));
            }
        }

        this.cookTime = this.tileFurnace.getField(2);
        this.furnaceBurnTime = this.tileFurnace.getField(0);
        this.currentItemBurnTime = this.tileFurnace.getField(1);
        this.totalCookTime = this.tileFurnace.getField(3);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int data) {
        this.tileFurnace.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileFurnace.isUsableByPlayer(playerIn);
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
            } else if (index != 1 && index != 0) {
                if (!FurnaceRecipes.instance().getSmeltingResult(itemstack1).isEmpty()) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (TileEntityFurnace.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 3 && index < 30) {
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
}