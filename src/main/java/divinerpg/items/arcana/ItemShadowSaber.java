package divinerpg.items.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.enums.ToolStats;
import divinerpg.items.base.ItemModSword;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import java.util.List;

public class ItemShadowSaber extends ItemModSword {
    public ItemShadowSaber() {
        super(ToolStats.SHADOW_SABER);
        arcanaConsumedAttack = 12;
    }
    @Override public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
        if(arcana.getArcana() >= arcanaConsumedAttack) {
            player.playSound(SoundRegistry.SHADOW_SABER.get(), 1, 1);
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1));
            }
        }); return super.onLeftClickEntity(stack, player, entity);
    }
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.shadow_saber"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}