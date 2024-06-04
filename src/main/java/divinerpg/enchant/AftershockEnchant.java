package divinerpg.enchant;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.*;

public class AftershockEnchant  extends Enchantment {
    public AftershockEnchant() {super(Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});}
    @Override public int getMaxLevel() {return 2;}
    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    @Override public int getMinCost(int level) {return 15 * (level + 1);}
    /**
     * Returns the maximum value of enchantability needed on the enchantment level passed.
     */
    @Override public int getMaxCost(int level) {return super.getMaxCost(level) + 50;}
}