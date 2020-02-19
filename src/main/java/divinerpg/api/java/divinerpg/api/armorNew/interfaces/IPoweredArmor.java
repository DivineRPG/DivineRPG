package divinerpg.api.java.divinerpg.api.armorNew.interfaces;

import com.sun.istack.internal.NotNull;
import divinerpg.api.java.divinerpg.api.armor14.IEquipped;
import divinerpg.api.java.divinerpg.api.armor14.IPowerAbility;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;
import java.awt.*;

public interface IPoweredArmor extends IForgeRegistryEntry<IPoweredArmor> {

    /**
     * Add ability to armor set
     *
     * @param clazz - class of event
     * @param e     - handling event
     * @param <T>   - type of event
     */
    <T extends Event> void addAbility(Class<T> clazz, IPowerAbility<?> e);

    /**
     * returns equipped handler. Can be null
     */
    @Nullable
    IEquipped getEquippedHandler();

    /**
     * Returns current armor description
     *
     * @return
     */
    @NotNull
    IArmorSet getArmorDescription();
}
