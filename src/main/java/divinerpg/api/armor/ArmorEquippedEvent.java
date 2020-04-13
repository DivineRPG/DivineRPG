package divinerpg.api.armor;

import divinerpg.api.DivineAPI;
import divinerpg.api.armor.cap.IArmorPowers;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.*;

public class ArmorEquippedEvent extends Event {
    /**
     * List of confirmed armor
     */
    private final Set<ResourceLocation> confirmed = new HashSet<>();
    private final Map<EntityEquipmentSlot, Set<Item>> items = new LinkedHashMap<>();

    public ArmorEquippedEvent(Entity player) {
        IArmorPowers powers = DivineAPI.getArmorPowers(player);

        for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
            HashSet<Item> slotItems = new HashSet<>();

            if (powers != null) {
                slotItems.addAll(powers.currentItems(slot));
            }

            items.put(slot, slotItems);
        }
    }

    /**
     * Gets sets of items on player. Unmodifiable
     *
     * @param slot
     * @return
     */
    public Set<Item> getItemsInSlot(EntityEquipmentSlot slot) {
        return Collections.unmodifiableSet(items.get(slot));
    }

    /**
     * Confirm current set ID
     *
     * @param id
     */
    public void confirm(ResourceLocation id) {
        confirmed.add(id);
    }

    /**
     * Remove current set ID
     *
     * @param id
     */
    public void remove(ResourceLocation id) {
        confirmed.remove(id);
    }

    /**
     * Returns unique ids of confirmed sets.
     *
     * @return
     */
    public Set<ResourceLocation> getConfirmed() {
        return new HashSet<>(confirmed);
    }
}
