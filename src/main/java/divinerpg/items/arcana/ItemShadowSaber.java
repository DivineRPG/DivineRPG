package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.capability.ArcanaProvider;
import divinerpg.items.base.ItemModSword;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemShadowSaber extends ItemModSword {

    public ItemShadowSaber(Tier mat) {
        super(mat, new Properties().tab(DivineRPG.tabs.melee).durability(-1));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
        if (arcana.getArcana() >= 12) {
            player.playSound(SoundRegistry.SHADOW_SABER.get(), 1, 1);
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5 * 20, 1));
            arcana.consume(player, 12);
        }
    });
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaConsumed(12));
        tooltip.add(LocalizeUtils.i18n("tooltip.shadow_saber"));
    }
}
