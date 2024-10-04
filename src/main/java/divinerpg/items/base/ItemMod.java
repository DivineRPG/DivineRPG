package divinerpg.items.base;

import divinerpg.attachments.Arcana;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.*;
import java.util.List;

public class ItemMod extends Item {
    public int arcanaConsumedUse, cooldown;
    public ItemMod() {super(new Properties());}
    public ItemMod(Properties properties) {super(properties);}
    public ItemMod setArcanaUseConsumption(int amount) {
    	arcanaConsumedUse = amount;
    	return this;
    }
    public ItemMod setArcanaUseCooldown(int amount) {
    	cooldown = amount;
    	return this;
    }
    protected InteractionResultHolder<ItemStack> arcanicUse(Level level, Player player, InteractionHand hand) {
    	return InteractionResultHolder.success(player.getItemInHand(hand));
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
    	if(arcanaConsumedUse != 0 && Arcana.getAmount(player) >= arcanaConsumedUse) {
            Arcana.modifyAmount(player, -arcanaConsumedUse);
            player.getCooldowns().addCooldown(this, cooldown);
            player.awardStat(Stats.ITEM_USED.get(this));
            return arcanicUse(level, player, hand);
        } return super.use(level, player, hand);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        if(getDescriptionId().contains("torridite")) tooltip.add(LocalizeUtils.i18n("torridite"));
        if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
    }
}