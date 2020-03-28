package divinerpg.capabilities.armor;

import divinerpg.api.armor.IEquipped;
import divinerpg.api.armor.registry.IArmorDescription;
import divinerpg.api.armor.registry.IForgeEvent;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Consumer;

public class ArmorDescription extends IForgeRegistryEntry.Impl<IArmorDescription> implements IArmorDescription {
    private final List<IForgeEvent<?>> powers = new ArrayList<>();
    private final Map<EntityEquipmentSlot, Set<Item>> possibleItems = new LinkedHashMap<>();
    private final IEquipped handler;

    public ArmorDescription() {
        this(null);
    }

    public ArmorDescription(IEquipped handler) {
        this.handler = handler;
    }

    /**
     * Adding possible armor power
     *
     * @param power - event handler
     * @param <T>   - any forge event type
     * @return
     */
    public <T extends Event> ArmorDescription withHandler(Class<T> clazz, Consumer<T> power) {
        powers.add(new ForgeEvent<>(clazz, power));
        return this;
    }

    /**
     * Adding possible armors items
     *
     * @param slot  - curent slot
     * @param items - list of items
     * @return
     */
    public ArmorDescription withPossibleItems(EntityEquipmentSlot slot, Item... items) {

        if (items != null && items.length > 0) {
            Set<Item> set = possibleItems.computeIfAbsent(slot, x -> new HashSet<>());
            set.addAll(Arrays.asList(items));
        }

        return this;
    }

    @Override
    public List<IForgeEvent<?>> getHandlers() {
        return new ArrayList<>(powers);
    }

    @Nullable
    @Override
    public IEquipped getEquippedHandler() {
        return handler;
    }

    @Override
    public Set<Item> getPossibleItems(EntityEquipmentSlot slot) {
        Set<Item> set = possibleItems.computeIfAbsent(slot, x -> new HashSet<>());
        return new HashSet<>(set);
    }
}
