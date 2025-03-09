package divinerpg.items.ranged.bows;

import divinerpg.entities.projectile.DivineArrow;
import divinerpg.entities.projectile.arrows.ShadowArrow;
import divinerpg.items.ranged.ItemBow;
import divinerpg.registries.ItemRegistry;
import divinerpg.util.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ShadowBow extends ItemBow {
    int effectSeconds;
    public ShadowBow() {
        super(new Properties(), 1225, 36000, 1, null, RarityList.DARK_GRAY);
        effectSeconds = 4;
    }
    @Override public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        switch(arrow) {
            case ShadowArrow h -> {
                h.powerMultiplier = 1.2F;
                h.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, effectSeconds * 20, 1));
                return arrow;
            } case Arrow a -> addEffect(a, new MobEffectInstance(MobEffects.BLINDNESS, effectSeconds * 20, 1));
            case DivineArrow a -> a.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, effectSeconds * 20, 1));
            default -> {}
        } return arrow;
    }
    @Override
    public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(ItemRegistry.shadow_arrow.get());
    }

    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.blind(effectSeconds));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}