package divinerpg.api.armor;

import net.minecraft.util.text.ITextComponent;

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
    ITextComponent getFullSetPerks();
}
