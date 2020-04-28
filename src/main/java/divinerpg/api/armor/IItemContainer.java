package divinerpg.api.armor;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents object that absorbs items
 */
public interface IItemContainer {

    /**
     * Containing items in object
     *
     * @param item - current item
     * @return
     */
    Set<ItemStack> getAbsorbedItemStacks(ItemStack item);

    /**
     * Absorb current stack
     *
     * @param stack    - item stack
     * @param toAbsorb - item to absorb
     */
    void absorb(ItemStack stack, ItemStack toAbsorb);

    /**
     * @return Unique containing items
     */
    default Set<Item> getItems(ItemStack item) {
        return getAbsorbedItemStacks(item).stream().map(ItemStack::getItem).collect(Collectors.toSet());
    }
}
