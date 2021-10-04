package divinerpg.client.containers.slot;

import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;

public class SlotDreamLamp extends Slot {

    public SlotDreamLamp(TileInventoryHelper inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.getItem() == ItemRegistry.acid;
    }

}