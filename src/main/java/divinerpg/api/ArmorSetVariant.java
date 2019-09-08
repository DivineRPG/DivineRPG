package divinerpg.api;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Describes full armor set. Can be with variables of helmets or chestplates, etc.
 */
public class ArmorSetVariant {
    private final List<Item> headVariant = new ArrayList<>();
    private final List<Item> chestVariant = new ArrayList<>();
    private final List<Item> legsVariant = new ArrayList<>();
    private final List<Item> bootsVariant = new ArrayList<>();

    public ArmorSetVariant(Item head, Item chest, Item legs, Item boots) {
        addSetVariant(head, chest, legs, boots);
    }

    /**
     * Set current set version
     */
    public ArmorSetVariant addSetVariant(Item head, Item chest, Item legs, Item boots) {
        if (head != null)
            headVariant.add(head);

        if (chest != null)
            chestVariant.add(chest);

        if (legs != null)
            legsVariant.add(legs);

        if (boots != null)
            bootsVariant.add(boots);

        return this;
    }

    public boolean isEquipped(Item head, Item chest, Item legs, Item boots) {
        return headVariant.contains(head)
                && chestVariant.contains(chest)
                && legsVariant.contains(legs)
                && bootsVariant.contains(boots);
    }
}
