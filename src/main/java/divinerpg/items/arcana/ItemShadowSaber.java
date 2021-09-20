package divinerpg.items.arcana;

import divinerpg.*;
import divinerpg.capability.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemShadowSaber extends ItemModSword {

    public ItemShadowSaber(String name, IItemTier mat) {
        super(name, mat, new Properties().tab(DivineRPG.tabs.melee).durability(-1));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity hitter) {
        if (hitter instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) hitter;
            Arcana arcana = player.getCapability(ArcanaCapability.CAPABILITY_ARCANA).orElse(null);
            if (arcana.getArcana() >= 12) {
                player.playSound(SoundRegistry.SHADOW_SABER, 1, 1);
                player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 5 * 20, 1));
                arcana.consume(player, 12);
            }
            return true;
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaConsumed(12));
        tooltip.add(LocalizeUtils.i18n("tooltip.shadow_saber"));
    }
}
