package divinerpg.util;

import net.minecraft.network.chat.*;

/**
 * Provides full set perks inforamtion
 */
public interface IFullSetInfo {

    /**
     * Returns description with full set perks.
     * Obviously same on whole set
     *
     * @return - pretty description
     */
    Component getFullSetPerks();
}