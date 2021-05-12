package divinerpg.enchant;

import net.minecraft.enchantment.*;
import net.minecraft.inventory.*;

public class RiveEnchant extends Enchantment {
    public RiveEnchant() {
        super(Rarity.VERY_RARE, EnchantmentType.DIGGER, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
        this.setRegistryName("rive");
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinCost(int enchantmentLevel) {
        return 15 * (enchantmentLevel + 1);
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxCost(int enchantmentLevel) {
        return super.getMaxCost(enchantmentLevel) + 50;
    }
}
