package divinerpg.api.java.divinerpg.api.armorNew.interfaces;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

import java.util.List;

/**
 * Describes how armorset should lok like
 */
public interface IArmorSet {
    /**
     * Returns list of possible values
     *
     * @param slot - entity slot
     */
    List<Item> getPossibleItems(EntityEquipmentSlot slot);

    /**
     * Adds variant of armor
     */
    default <T extends IArmorSet> T withVariant(Item helmet, Item chest, Item legs, Item boots) {
        return withVariant(helmet, chest, legs, boots, null);
    }

    <T extends IArmorSet> T withVariant(Item helmet, Item chest, Item legs, Item boots, Item shield);
}
