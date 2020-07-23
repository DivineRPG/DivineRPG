package divinerpg.api.armor;

import net.minecraft.entity.EntityLivingBase;

@FunctionalInterface
public interface IEquipped {
    /**
     * @param player
     * @param isOn
     */
    void onEquppedChanged(EntityLivingBase player, boolean isOn);
}
