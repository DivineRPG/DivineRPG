package divinerpg.enchant;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.*;

public class RiveEnchant extends Enchantment {
    public RiveEnchant() {super(Rarity.VERY_RARE, EnchantmentCategory.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND});}
    @Override public int getMaxLevel() {return 3;}
    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    @Override public int getMinCost(int level) {return 15 * (level + 1);}
    /**
     * Returns the maximum value of enchantability needed on the enchantment level passed.
     */
    @Override public int getMaxCost(int level) {return super.getMaxCost(level) + 50;}
}