package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemSerenadeOfInfusion extends ItemMod {

    public ItemSerenadeOfInfusion() {
        super(new Properties().durability(15));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.serenade_of_infusion"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!player.isCreative()) {
            stack.hurtAndBreak(1, player, (p_220009_1_) -> {
                p_220009_1_.broadcastBreakEvent(player.getUsedItemHand());
            });
        }
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 2, true, false));
        player.playSound(SoundRegistry.HEAL.get(), 1, 1);
        return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, stack);
    }
}