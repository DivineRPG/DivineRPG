package divinerpg.client.containers.slot;

import divinerpg.recipe.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;

public class SlotInfusion extends Slot {
        IInventory inventory;
    public SlotInfusion(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    this.inventory=inventoryIn;
    }

    @Override
    protected void onQuickCraft(ItemStack stack, int p_75210_2_) {
        if(inventory.getItem(2).isEmpty()) {
            if(!inventory.getItem(0).isEmpty() && !inventory.getItem(1).isEmpty()) {
                ItemStack inputStack = inventory.getItem(0);
                ItemStack templateStack = inventory.getItem(1);
                int inputStackSize = inputStack.getCount();

                if(!inputStack.isEmpty() && !templateStack.isEmpty()) {
                    Item item1 = inventory.getItem(0).getItem();
                    Item item2 = inventory.getItem(1).getItem();
                    InfusionTableRecipes x = InfusionTableRecipes.instance;
                    Item item = x.getOutput(item1, item2, inputStackSize);
                    if(item != null) {
                        inventory.removeItem(0, inputStackSize);
                        inventory.removeItem(1, 1);
                    }
                }
            }
        }
    }
}
