package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.*;
import java.util.*;

public class ItemSerenadeOfHealth extends ItemMod {
    public ItemSerenadeOfHealth() {
        super(new Properties().tab(DivineRPG.tabs.utilities).durability(7));
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.serenade_of_health"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getItemInHand(hand);
            if(!player.isCreative()) {
                stack.hurtAndBreak(1, player, (p_220009_1_) -> {
                    p_220009_1_.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
            player.heal(8F);
            player.playSound(SoundRegistry.HEAL.get(), 1F, 1F);
            return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, stack);
        } else return super.use(world, player, hand);
    }
}