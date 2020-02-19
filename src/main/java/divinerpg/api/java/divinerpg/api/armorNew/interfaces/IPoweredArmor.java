package divinerpg.api.java.divinerpg.api.armorNew.interfaces;

import com.sun.istack.internal.NotNull;
import divinerpg.api.java.divinerpg.api.armor14.IEquipped;
import divinerpg.api.java.divinerpg.api.armor14.IPowerAbility;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Map;


public interface IPoweredArmor extends IForgeRegistryEntry<IPoweredArmor>, IEquipped {

    Map<Class, IPowerAbility<? extends Event>> getAbilityMap();

    /**
     * Add ability to armor set
     *
     * @param clazz - class of event
     * @param e     - handling event
     * @param <T>   - type of event
     */
    <T extends Event> void addAbility(Class<T> clazz, IPowerAbility<T> e);

    /**
     * Returns current armor description
     *
     * @return
     */
    @NotNull
    IArmorSet getArmorDescription();
}
