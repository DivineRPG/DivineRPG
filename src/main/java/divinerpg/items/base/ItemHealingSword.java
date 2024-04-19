package divinerpg.items.base;

import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemHealingSword extends ItemModSword {
    private final float healAmount;
    public ItemHealingSword(Tier material, float healAmount) {
        super(material);
        this.healAmount = healAmount;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getItemInHand(hand);
            if(!player.isCreative()) stack.hurtAndBreak(1, player, (p_220044_0_) -> p_220044_0_.broadcastBreakEvent(hand));
            player.heal(healAmount);
            player.playSound(SoundRegistry.HEAL.get(), 1, 1);
            player.awardStat(Stats.ITEM_USED.get(this));
            player.getCooldowns().addCooldown(this, 3);
            return InteractionResultHolder.success(stack);
        } return super.use(level, player, hand);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.heals", healAmount / 2));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}