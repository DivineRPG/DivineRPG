package divinerpg.items.ranged.bows;

import divinerpg.items.ranged.ItemBow;
import divinerpg.util.Utils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.ItemRegistry.inferno_arrow;
import static divinerpg.util.RarityList.INFERNO;
import static java.lang.Integer.MAX_VALUE;
import static net.minecraft.world.item.enchantment.Enchantments.FLAME;

public class InfernoBow extends ItemBow {
    public InfernoBow() {
        super(new Properties().fireResistant(), 0, 72000, 1, inferno_arrow, INFERNO);
    }
    @Override public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        arrow.igniteForTicks(MAX_VALUE >> 1);
        return arrow;
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(inferno_arrow.get());
    }
    @Override public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return super.supportsEnchantment(stack, enchantment) && !enchantment.is(FLAME);
    }
    @Override public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return super.isBookEnchantable(stack, book) && !Utils.hasStoredEnchantment(FLAME, book);
    }
}