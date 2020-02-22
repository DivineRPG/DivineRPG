package divinerpg.api.java.divinerpg.api.armorNew.interfaces;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Managing players wearing that armor set
 */
public interface IPoweredArmorManage {
    /**
     * Gets current armor set
     *
     * @return
     */
    IPoweredArmor getArmorSet();

    /**
     * Adds player to handlers list
     *
     * @param player
     */
    void addPlayer(EntityPlayer player);

    /**
     * Removes player from handler list
     *
     * @param player
     */
    void removePlayer(EntityPlayer player);
}
