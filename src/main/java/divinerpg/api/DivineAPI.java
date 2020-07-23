package divinerpg.api;

import divinerpg.api.arcana.IArcana;
import divinerpg.api.armor.cap.ArmorProvider;
import divinerpg.api.armor.cap.IArmorPowers;
import divinerpg.api.armor.registry.IArmorDescription;
import divinerpg.utils.attributes.IReflectionHelper;
import divinerpg.utils.attributes.ReflectionHelper;
import net.minecraft.entity.Entity;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

import javax.annotation.Nullable;

import static divinerpg.api.arcana.ArcanaProvider.ARCANA_CAP;

/**
 * Main API class.
 */
public class DivineAPI {
    /**
     * Reflection helper working with obfuscated code
     */
    public final static IReflectionHelper reflectionHelper = new ReflectionHelper();


    /**
     * Contains all powered armor registry
     *
     * @return
     */
    public static IForgeRegistry<IArmorDescription> getArmorDescriptionRegistry() {
        return RegistryManager.ACTIVE.getRegistry(IArmorDescription.class);
    }

    /**
     * Gets the arcana capability
     *
     * @param entity - any entity, but we are using player
     * @return - IArcana capability
     */
    @Nullable
    public static IArcana getArcana(Entity entity) {
        if (entity == null)
            return null;

        return entity.getCapability(ARCANA_CAP, null);
    }

    /**
     * Gets armor capability
     *
     * @param entity
     * @return
     */
    @Nullable
    public static IArmorPowers getArmorPowers(Entity entity) {
        if (entity == null)
            return null;

        return entity.getCapability(ArmorProvider.ArmorCapability, null);
    }
}
