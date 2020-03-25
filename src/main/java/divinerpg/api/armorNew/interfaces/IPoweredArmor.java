package divinerpg.api.armorNew.interfaces;

import divinerpg.api.armorNew.ForgeEventHandler;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.function.Consumer;


/**
 * Describe what powered armor should do
 */
public interface IPoweredArmor extends IForgeRegistryEntry<IPoweredArmor>, IEquipped {

    Map<Class, ForgeEventHandler<?>> getAbilityMap();

    /**
     * Add ability to armor set
     *
     * @param clazz - class of event
     * @param e     - handling event
     * @param <T>   - type of event
     */
    <T extends Event, TRes extends IPoweredArmor> TRes addAbility(Class<T> clazz, Consumer<T> e);

    /**
     * Returns current armor description
     *
     * @return
     */
    @Nonnull
    IArmorSet getArmorDescription();
}
