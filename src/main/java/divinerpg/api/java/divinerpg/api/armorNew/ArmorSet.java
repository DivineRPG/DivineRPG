package divinerpg.api.java.divinerpg.api.armorNew;

import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IArmorSet;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArmorSet implements IArmorSet {
    private final Map<EntityEquipmentSlot, List<Item>> map = new HashMap<>();

    @Override
    public List<Item> getPossibleItems(EntityEquipmentSlot slot) {
        return map.computeIfAbsent(slot, x -> new ArrayList<>());
    }

    @Override
    public <T extends IArmorSet> T withVariant(Item helmet, Item chest, Item legs, Item boots, Item shield) {
        put(EntityEquipmentSlot.HEAD, helmet);
        put(EntityEquipmentSlot.CHEST, chest);
        put(EntityEquipmentSlot.LEGS, legs);
        put(EntityEquipmentSlot.FEET, boots);
        put(EntityEquipmentSlot.OFFHAND, shield);

        return (T) this;
    }

    private void put(EntityEquipmentSlot slot, Item item) {
        if (item == null)
            return;

        List<Item> items = getPossibleItems(slot);
        if (items.contains(item))
            return;

        items.add(item);
    }
}
