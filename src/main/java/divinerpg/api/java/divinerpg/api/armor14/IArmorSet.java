package divinerpg.api.java.divinerpg.api.armor14;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public interface IArmorSet {

    /**
     * Adds variant of armor set. Null-items is ignored
     *
     * @param helmet
     * @param chest
     * @param legs
     * @param boots
     */
    default IArmorSet withVariant(Item helmet, Item chest, Item legs, Item boots) {
        return withVariant(helmet, chest, legs, boots, null);
    }

    /**
     * Adds variant of armor set. Null-items is ignored
     */
    IArmorSet withVariant(Item helmet, Item chest, Item legs, Item boots, Item shield);

    /**
     * Adds variants of armor set. Null-items is ignored
     *
     * @param helmet
     * @param chest
     * @param legs
     * @param boots
     */
    default IArmorSet withVariants(Item[] helmet, Item[] chest, Item[] legs, Item[] boots) {
        return withVariants(helmet, chest, legs, boots, null);
    }

    /**
     * Adds variants of armor set. Null-items is ignored
     */
    IArmorSet withVariants(Item[] helmet, Item[] chest, Item[] legs, Item[] boots, Item[] shields);

    /**
     * Is current set applied on player
     *
     * @param entity - player
     */
    boolean isEquipped(EntityPlayer entity);
}
