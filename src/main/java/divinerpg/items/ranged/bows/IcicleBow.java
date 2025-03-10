package divinerpg.items.ranged.bows;

import divinerpg.entities.projectile.DivineArrow;
import divinerpg.entities.projectile.arrows.IcicleArrow;
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

public class IcicleBow extends ItemBow {
    public final int effectSeconds;
    public IcicleBow() {
        super(new Properties(), 1456, 24000, 1, null, RarityList.ICICLE);
        effectSeconds = 4;
    }
    @Override public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        switch(arrow) {
            case IcicleArrow h -> {
                h.powerMultiplier = 1.2F;
                h.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectSeconds * 20, 1));
                return arrow;
            } case Arrow a -> addEffect(a, new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectSeconds * 20, 1));
            case DivineArrow a -> a.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectSeconds * 20, 1));
            default -> {}
        } return arrow;
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(ItemRegistry.icicle_arrow.get());
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        tooltip.add(LocalizeUtils.slow(effectSeconds));
    }
}