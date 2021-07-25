package divinerpg.client.containers.slot;

import divinerpg.client.containers.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;

public class ArcaniumExtractorFuelSlot extends Slot {
    private final ArcaniumExtractorContainer menu;

    public ArcaniumExtractorFuelSlot(ArcaniumExtractorContainer p_i50084_1_, IInventory p_i50084_2_, int p_i50084_3_, int p_i50084_4_, int p_i50084_5_) {
        super(p_i50084_2_, p_i50084_3_, p_i50084_4_, p_i50084_5_);
        this.menu = p_i50084_1_;
    }

    public boolean mayPlace(ItemStack p_75214_1_) {
        return this.menu.isFuel(p_75214_1_);
    }

    public int getMaxStackSize(ItemStack p_178170_1_) {
        return super.getMaxStackSize(p_178170_1_);
    }

}