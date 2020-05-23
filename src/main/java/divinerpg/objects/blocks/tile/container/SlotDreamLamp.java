package divinerpg.objects.blocks.tile.container;

import divinerpg.registry.ItemRegistry;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotDreamLamp extends Slot {

    public SlotDreamLamp(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == ItemRegistry.acid;
    }

}