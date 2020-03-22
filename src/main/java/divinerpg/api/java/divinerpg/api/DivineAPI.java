package divinerpg.api.java.divinerpg.api;

import divinerpg.api.java.divinerpg.api.arcana.IArcana;
import divinerpg.api.java.divinerpg.api.armorNew.MainArmorEvents;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IPoweredArmor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

import static divinerpg.api.java.divinerpg.api.arcana.ArcanaProvider.ARCANA_CAP;

/**
 * Main API class.
 */
public class DivineAPI {
    /**
     * Contains all possible power sets data
     */
    public static IForgeRegistry<IPoweredArmor> getPowerSetRegistry() {
        return RegistryManager.ACTIVE.getRegistry(IPoweredArmor.class);
    }

    /**
     * Gets the arcana capability
     *
     * @param entity - any entity, but we are using player
     * @return - IArcana capability
     */
    public static IArcana getArcana(Entity entity) {
        return entity.getCapability(ARCANA_CAP, null);
    }

    /**
     * Checks if player wears that type of armor
     *
     * @param entity - player
     * @param id     - ID of powered armor set
     */
    public static boolean isOn(Entity entity, ResourceLocation id) {
        if (id == null || !(entity instanceof EntityPlayer))
            return false;

        return MainArmorEvents.findPlayerArmorObserver((EntityPlayer) entity).isOn(id);
    }
}
