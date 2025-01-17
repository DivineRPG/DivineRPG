package divinerpg.items.ranged.bows;

import divinerpg.items.ranged.ItemBow;
import divinerpg.registries.ItemRegistry;
import divinerpg.util.*;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.api.distmarker.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InfernoBow extends ItemBow {
    public InfernoBow() {
        super(new Properties().fireResistant(), 0, 72000, 1, ItemRegistry.inferno_arrow, RarityList.INFERNO);
    }
    @Override public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        arrow.igniteForTicks(Integer.MAX_VALUE >> 1);
        return arrow;
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(ItemRegistry.inferno_arrow.get());
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.burningShots());
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return super.supportsEnchantment(stack, enchantment) && !enchantment.is(Enchantments.FLAME);
    }
    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return super.isBookEnchantable(stack, book) && !Utils.hasStoredEnchantment(Enchantments.FLAME, book);
    }
}