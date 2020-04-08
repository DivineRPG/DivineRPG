package divinerpg.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class WorldBreakEnchant extends Enchantment {

    /**
     * Restricting current types
     */
    private final Set<String> forbiddenClasses = new HashSet<String>() {{
        add("hammer");
        add("excavator");
    }};

    public WorldBreakEnchant() {
        super(Rarity.VERY_RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
        this.setName("world_break");
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int enchantmentLevel) {
        return 15 * (enchantmentLevel + 1);
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    @Override
    public boolean canApply(ItemStack stack) {
        if (!super.canApply(stack))
            return false;

        return stack.getItem().getToolClasses(stack).stream().noneMatch(forbiddenClasses::contains);
    }
}
