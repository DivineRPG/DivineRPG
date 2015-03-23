package net.divinerpg.blocks.vethea.container;

import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotDreamLamp extends Slot {

    public SlotDreamLamp(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
        super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
    }
    
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == VetheaItems.acid;
    }

}
