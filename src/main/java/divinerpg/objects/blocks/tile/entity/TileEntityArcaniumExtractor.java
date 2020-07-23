package divinerpg.objects.blocks.tile.entity;

import divinerpg.registry.BlockRegistry;
import divinerpg.registry.ItemRegistry;
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
        return (index == 0 && stack.getItem() == Item.getItemFromBlock(BlockRegistry.arcaniumOre))
                || (index == 1 && stack.getItem() == ItemRegistry.chargedCollector);
    }

    @Override
    public int getItemBurnTime(ItemStack stack) {
        if (stack == null || stack.getItem() != ItemRegistry.chargedCollector)
            return 0;
        return 400;
    }

    @Override
    public ItemStack getSmeltingResult(ItemStack stack) {
        if (stack == null || stack.getItem() != Item.getItemFromBlock(BlockRegistry.arcaniumOre))
            return ItemStack.EMPTY;
        return new ItemStack(ItemRegistry.arcanium);
    }
}