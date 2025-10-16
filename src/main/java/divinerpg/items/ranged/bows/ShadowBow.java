package divinerpg.items.ranged.bows;

import divinerpg.entities.projectile.DivineArrow;
import divinerpg.entities.projectile.arrows.ShadowArrow;
import divinerpg.items.ranged.ItemBow;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static divinerpg.registries.ItemRegistry.shadow_arrow;
import static divinerpg.util.RarityList.DARK_GRAY;
import static net.minecraft.core.component.DataComponents.POTION_CONTENTS;
import static net.minecraft.world.effect.MobEffects.BLINDNESS;
import static net.neoforged.api.distmarker.Dist.CLIENT;

public class ShadowBow extends ItemBow {
    public final int effectSeconds;
    public ShadowBow() {
        super(new Properties().component(POTION_CONTENTS, PotionContents.EMPTY.withEffectAdded(new MobEffectInstance(BLINDNESS, 4 * 20, 1))), 1225, 36000, 1, null, DARK_GRAY);
        effectSeconds = 4;
    }
    @Override public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        switch(arrow) {
            case ShadowArrow h -> {
                h.powerMultiplier = 1.2F;
                h.addEffect(new MobEffectInstance(BLINDNESS, effectSeconds * 20, 1));
                return arrow;
            } case Arrow a -> addEffect(a, new MobEffectInstance(BLINDNESS, effectSeconds * 20, 1));
            case DivineArrow a -> a.addEffect(new MobEffectInstance(BLINDNESS, effectSeconds * 20, 1));
            default -> {}
        } return arrow;
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(shadow_arrow.get());
    }
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        PotionContents potioncontents = stack.get(POTION_CONTENTS);
        if(potioncontents != null) potioncontents.addPotionTooltip(component -> tooltip.add(component.copy().withStyle(ChatFormatting.BLACK)), 1, context.tickRate());
    }
}