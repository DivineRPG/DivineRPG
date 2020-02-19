package divinerpg.api.java.divinerpg.api.armorNew;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerEvent;

import java.util.*;

/**
 * Event posted to detect armor changes
 */
public class IsEquppedEvent extends PlayerEvent {
    /**
     * reference to armor
     */
    private final Map<EntityEquipmentSlot, Item> currentArmor;
    private final List<ResourceLocation> currentlyEquipped = new ArrayList<>();

    public IsEquppedEvent(EntityPlayer player, Map<EntityEquipmentSlot, Item> currentArmor) {
        super(player);
        this.currentArmor = currentArmor;
    }

    /**
     * Gets list of equipped armor sets
     *
     * @return
     */
    public Collection<ResourceLocation> getEquipped() {
        return Collections.unmodifiableCollection(currentlyEquipped);
    }

    /**
     * Adds list as confirmed equipment
     *
     * @param set
     */
    public void add(ResourceLocation set) {
        if (!currentlyEquipped.contains(set))
            currentlyEquipped.add(set);
    }

    /**
     * Remove list from confirmed equipment
     *
     * @param set
     */
    public void remove(ResourceLocation set) {
        currentlyEquipped.remove(set);
    }

    /**
     * Get current item in player inventory
     *
     * @param slot
     * @return
     */
    public Item getItemInSlot(EntityEquipmentSlot slot) {
        return currentArmor.get(slot);
    }
}
