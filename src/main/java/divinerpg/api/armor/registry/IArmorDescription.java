package divinerpg.api.armor.registry;

import divinerpg.api.armor.IEquipped;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

/**
 * Represents power set
 */
public interface IArmorDescription extends IForgeRegistryEntry<IArmorDescription> {

    /**
     * Get all possible event handlers. Unmodifiable!
     *
     * @return
     */
    List<IForgeEvent<?>> getHandlers();

    /**
     * Gets handler on wearing status change
     *
     * @return
     */
    @Nullable
    IEquipped getEquippedHandler();

    /**
     * Gets possible items from slot id.
     *
     * @param slot
     * @return
     */
    Set<Item> getPossibleItems(EntityEquipmentSlot slot);
}
