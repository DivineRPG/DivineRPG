package divinerpg.client.containers.slot;

import divinerpg.registries.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;

public class SlotDreamLamp extends Slot {

    public SlotDreamLamp(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == ItemRegistry.acid;
    }

}