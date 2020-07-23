package divinerpg.objects.blocks.tile.container;

import divinerpg.registry.InfusionTableRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotInfusion extends SlotFurnaceOutput {

    public SlotInfusion(EntityPlayer player, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
        super(player, inventoryIn, slotIndex, xPosition, yPosition);
    }

    @Override
    protected void onCrafting(ItemStack stack) {
        if(inventory.getStackInSlot(2).isEmpty()) {
            if(!inventory.getStackInSlot(0).isEmpty() && !inventory.getStackInSlot(1).isEmpty()) {
                ItemStack inputStack = inventory.getStackInSlot(0);
                ItemStack templateStack = inventory.getStackInSlot(1);
                int inputStackSize = inputStack.getCount();

                if(!inputStack.isEmpty() && !templateStack.isEmpty()) {
                    Item item1 = inventory.getStackInSlot(0).getItem();
                    Item item2 = inventory.getStackInSlot(1).getItem();
                    InfusionTableRecipes x = InfusionTableRecipes.instance;
                    Item item = x.getOutput(item1, item2, inputStackSize);
                    if(item != null) {
                        inventory.decrStackSize(0, inputStackSize);
                        inventory.decrStackSize(1, 1);
                    }
                }
            }
        }
    }
}