package divinerpg.api.java.divinerpg.api.armorset;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handler for special armor powers
 */
public class FullArmorHandler implements IEquipped {
    public final List<ArmorSetVariant> armorVariants = new ArrayList<>();
    public final Map<Class, List<IPowerAbility>> abilityMap = new HashMap<>();
    protected final IEquipped equippedHandler;

    /**
     * Init handler with set and callback on equipped
     */
    public FullArmorHandler(Item head, Item chest, Item legs, Item boots, IEquipped handler) {
        equippedHandler = handler;
        withVariants(head, chest, legs, boots);
    }

    /**
     * Init handler with set, callback on equipped do not needed
     */
    public FullArmorHandler(Item head, Item chest, Item legs, Item boots) {
        this(head, chest, legs, boots, null);
    }

    /**
     * Add variants to handler. Set one of the argument to null to ignore them
     *
     * @return this
     */
    public FullArmorHandler withVariants(Item head, Item chest, Item legs, Item boots) {
        return withVariants(new ArmorSetVariant(head, chest, legs, boots));
    }

    public FullArmorHandler withVariants(ArmorSetVariant variant) {
        armorVariants.add(variant);
        return this;
    }

    /**
     * Adding ability to handler
     *
     * @param clazz   - Event class determines in which event we'll call ability callback
     * @param ability - the ability callback
     * @return this
     */
    public <T extends Event> FullArmorHandler withAbility(Class<T> clazz, IPowerAbility<T> ability) {
        if (!abilityMap.containsKey(clazz)) {
            abilityMap.put(clazz, new ArrayList<>());
        }

        List<IPowerAbility> abilities = abilityMap.get(clazz);
        if (abilities.contains(ability)) {
            throw new IllegalArgumentException("Ability is already registered!");
        }

        abilities.add(ability);
        return this;
    }

    /**
     * Trigger all abilities working with that event
     *
     * @param event
     * @param <T>
     */
    public <T extends Event> void handle(T event) {
        Class<? extends Event> clazz = event.getClass();
        if (abilityMap.containsKey(clazz)) {
            abilityMap.get(clazz).forEach(iPowerAbility -> iPowerAbility.handle(event));
        }
    }

    @Override
    public void onStatusChanged(EntityPlayer player, boolean isFullEquipped) {
        if (equippedHandler == null)
            return;

        equippedHandler.onStatusChanged(player, isFullEquipped);
    }

    @Override
    public int hashCode() {
        return armorVariants.hashCode();
    }

}
