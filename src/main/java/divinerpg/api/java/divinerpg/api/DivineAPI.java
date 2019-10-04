package divinerpg.api;

import divinerpg.api.arcana.IArcana;
import net.minecraft.entity.Entity;

import static divinerpg.api.arcana.ArcanaProvider.ARCANA_CAP;

/**
 * Main API class.
 */
public class DivineAPI {
    /**
     * Armor registry. Will injected on FMLPreInitEvent
     */
    public static IFullArmorRegistry ARMOR_REGISTRY = null;

    /**
     * Gets the arcana capability
     * @param entity - any entity, but we are using player
     * @return - IArcana capability
     */
    public static IArcana getArcana(Entity entity){
        return entity.getCapability(ARCANA_CAP, null);
    }
}
