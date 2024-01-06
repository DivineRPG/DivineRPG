package divinerpg.enchant;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.*;

public class InsulationEnchant extends Enchantment {
	public InsulationEnchant() {super(Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.CHEST});}
	@Override public boolean isTreasureOnly() {return true;}
}