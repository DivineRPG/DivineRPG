package divinerpg.api.armor.cap;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.Set;

/**
 * Represents armor capabilty
 */
public interface IArmorPowers {

    /**
     * Set of currently wearing armor sets.
     *
     * @return
     */
    Set<ResourceLocation> wearing();

    /**
     * Is current armor equipped
     *
     * @param id - armor id
     * @return
     */
    default boolean wearing(ResourceLocation id) {
        return wearing().contains(id);
    }

    /**
     * Wears current armor by it's ID
     *
     * @param id
     */
    default void putOn(ResourceLocation id) {
        putOn(id, true);
    }

    /**
     * Subscribes on armor set powers
     *
     * @param id          - armor set ID
     * @param sendMessage - should send message to client
     */
    void putOn(ResourceLocation id, boolean sendMessage);

    /**
     * Removes armor from player
     *
     * @param id
     */
    void takeOff(ResourceLocation id);

    /**
     * Gets current items on player
     *
     * @param slot - equipment slot
     * @return
     */
    Set<Item> currentItems(EntityEquipmentSlot slot);

}
