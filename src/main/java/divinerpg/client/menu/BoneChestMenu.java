package divinerpg.client.menu;

import divinerpg.registries.MenuTypeRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;

public class BoneChestMenu extends ChestMenu {
    private final int containerRows;

    private BoneChestMenu(int p_39225_, Inventory p_39226_, int p_39227_) {
        this(p_39225_, p_39226_, new SimpleContainer(9 * p_39227_), p_39227_);
    }
    public BoneChestMenu(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory, 3);
    }

    public static BoneChestMenu threeRows(int p_39238_, Inventory p_39239_, Container p_39240_) {
        return new BoneChestMenu(p_39238_, p_39239_, p_39240_, 3);
    }

    public BoneChestMenu(int p_39230_, Inventory p_39231_, Container p_39232_, int p_39233_) {
        super(MenuTypeRegistry.BONE_CHEST.get(), p_39230_, p_39231_, p_39232_, p_39233_);
        checkContainerSize(p_39232_, p_39233_ * 9);
        this.containerRows = p_39233_;
        p_39232_.startOpen(p_39231_.player);
        int i = (this.containerRows - 4) * 18;

        for(int j = 0; j < this.containerRows; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(p_39232_, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(p_39231_, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(p_39231_, i1, 8 + i1 * 18, 161 + i));
        }

    }

    public ItemStack quickMoveStack(Player p_39253_, int p_39254_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_39254_);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (p_39254_ < this.containerRows * 9) {
                if (!this.moveItemStackTo(itemstack1, this.containerRows * 9, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.containerRows * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }
}