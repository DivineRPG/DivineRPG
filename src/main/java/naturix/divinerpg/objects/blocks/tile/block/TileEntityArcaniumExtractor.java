package naturix.divinerpg.objects.blocks.tile.block;

import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TileEntityArcaniumExtractor extends TileEntityModFurnace {

    public String getFuranceName() {
        return "tile.arcanium_extractor.name";
    }

    int getFurnaceSpeed() {
        return 100;
    }

    public boolean needsFuel() {
        return true;
    }

    public void updateBlockState(boolean isBurning) {
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return (index == 0 && stack.getItem() == Item.getItemFromBlock(ModBlocks.arcaniumOre))
                || (index == 1 && stack.getItem() == ModItems.chargedCollector);
    }

    @Override
    public int getItemBurnTime(ItemStack stack) {
        if (stack == null || stack.getItem() != ModItems.chargedCollector)
            return 0;
        return 400;
    }

    @Override
    public ItemStack getSmeltingResult(ItemStack stack) {
        if (stack == null || stack.getItem() != Item.getItemFromBlock(ModBlocks.arcaniumOre))
            return ItemStack.EMPTY;
        return new ItemStack(ModItems.arcanium);
    }
}