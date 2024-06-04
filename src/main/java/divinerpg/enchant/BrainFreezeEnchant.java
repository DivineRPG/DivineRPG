package divinerpg.enchant;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.*;

public class BrainFreezeEnchant extends Enchantment {

    public BrainFreezeEnchant() {super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});}
    @Override public int getMaxLevel() {return 3;}
    @Override public boolean isTreasureOnly() {return super.isTreasureOnly();}
}