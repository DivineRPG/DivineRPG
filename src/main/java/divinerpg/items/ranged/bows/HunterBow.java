package divinerpg.items.ranged.bows;

import divinerpg.entities.projectile.DivineArrow;
import divinerpg.entities.projectile.arrows.HunterArrow;
import divinerpg.items.ranged.ItemBow;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static divinerpg.registries.ItemRegistry.hunter_arrow;
import static divinerpg.util.RarityList.GREEN;
import static net.minecraft.world.effect.MobEffects.POISON;

public class HunterBow extends ItemBow {
    public final int effectSeconds;
    public HunterBow() {
        super(new Properties(), 1125, 72000, 1.2F, null, GREEN);
        effectSeconds = 2;
    }
    @Override public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        switch(arrow) {
            case HunterArrow h -> {
                h.powerMultiplier = 1.2F;
                return arrow;
            } case Arrow a -> addEffect(a, new MobEffectInstance(POISON, effectSeconds * 20, 3));
            case DivineArrow a -> a.addEffect(new MobEffectInstance(POISON, effectSeconds * 20, 3));
            default -> {}
        } return arrow;
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(hunter_arrow.get());
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        tooltip.add(LocalizeUtils.poison(effectSeconds));
    }
}