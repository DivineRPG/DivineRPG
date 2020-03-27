package divinerpg.api.armor.cap;

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
    void putOn(ResourceLocation id);

    /**
     * Removes armor from player
     *
     * @param id
     */
    void takeOff(ResourceLocation id);
}
