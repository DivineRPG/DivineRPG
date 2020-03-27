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
     * @return Containing items in object
     */
    Set<ItemStack> getAbsorbedItemStacks();

    /**
     * @return Unique containing items
     */
    default Set<Item> getItems() {
        return getAbsorbedItemStacks().stream().map(ItemStack::getItem).collect(Collectors.toSet());
    }
}
