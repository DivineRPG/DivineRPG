package divinerpg.api.java.divinerpg.api.armor14;

import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;

public interface IPoweredArmorSet extends IForgeRegistryEntry<IPoweredArmorSet> {

    /**
     * Gets current set describer
     */
    IArmorSet getArmorSetDescriber();

    /**
     * Gets equipped callback. Can be null
     */
    @Nullable
    IEquipped getEquippedHandler();

    /**
     * Register current power ability
     *
     * @param clazz   - class of event
     * @param ability - ability handler
     */
    <T extends Event> IPoweredArmorSet addAbility(Class<T> clazz, IPowerAbility<T> ability);

    /**
     * Called on event when player is full equipped.
     *
     * @param event - Forge event
     */
    <T extends Event> void handleAbility(T event);
}
