package divinerpg.client.containers;

import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.network.*;
import net.minecraftforge.api.distmarker.*;

public class PresentBoxContainer extends Container {
    private final IInventory container;
    private final int containerRows;

    public PresentBoxContainer(int p_i50091_2_, PlayerInventory p_i50091_3_, int p_i50091_4_) {
        this(ContainerRegistry.PRESENT_BOX.get(), p_i50091_2_, p_i50091_3_, new Inventory(9 * p_i50091_4_), p_i50091_4_);
    }

    public PresentBoxContainer(int i, PlayerInventory playerInventory, PacketBuffer buffer) {
        this(i, playerInventory, 3);
    }

    public static PresentBoxContainer threeRows(int p_216988_0_, PlayerInventory p_216988_1_) {
        return new PresentBoxContainer(p_216988_0_, p_216988_1_, 3);
    }


    public PresentBoxContainer(ContainerType<?> p_i50092_1_, int p_i50092_2_, PlayerInventory p_i50092_3_, IInventory p_i50092_4_, int p_i50092_5_) {
        super(p_i50092_1_, p_i50092_2_);
        checkContainerSize(p_i50092_4_, p_i50092_5_ * 9);
        this.container = p_i50092_4_;
        this.containerRows = p_i50092_5_;
        p_i50092_4_.startOpen(p_i50092_3_.player);
        int i = (this.containerRows - 4) * 18;

        for(int j = 0; j < this.containerRows; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(p_i50092_4_, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(p_i50092_3_, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(p_i50092_3_, i1, 8 + i1 * 18, 161 + i));
        }

    }

    public boolean stillValid(PlayerEntity p_75145_1_) {
        return this.container.stillValid(p_75145_1_);
    }

    public ItemStack quickMoveStack(PlayerEntity p_82846_1_, int p_82846_2_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_82846_2_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (p_82846_2_ < this.containerRows * 9) {
                if (!this.moveItemStackTo(itemstack1, this.containerRows * 9, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.containerRows * 9, false)) {
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
        this.container.stopOpen(p_75134_1_);
    }

    public IInventory getContainer() {
        return this.container;
    }

    @OnlyIn(Dist.CLIENT)
    public int getRowCount() {
        return this.containerRows;
    }
}