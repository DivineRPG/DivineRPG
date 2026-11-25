package divinerpg.items.base;

import divinerpg.attachments.Arcana;
import net.minecraft.network.chat.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import static net.minecraft.stats.Stats.ITEM_USED;

public class ArcanicItem extends Item {
    public Integer nameColor;
    public int arcanaConsumedUse, cooldown;
    public ArcanicItem(Properties properties) {super(properties);}
    public ArcanicItem(Properties p, int arcanaUseConsumption, int arcanaUseCooldown) {
        super(p);
        arcanaConsumedUse = arcanaUseConsumption;
        cooldown = arcanaUseCooldown;
    }
    public ArcanicItem setArcanaUseConsumption(int amount) {
        arcanaConsumedUse = amount;
        return this;
    }
    public ArcanicItem setArcanaUseCooldown(int amount) {
        cooldown = amount;
        return this;
    }
    protected InteractionResult arcanicUse(Level level, Player player, InteractionHand hand) {
        return InteractionResult.SUCCESS;
    }
    @Override public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if(arcanaConsumedUse != 0 && Arcana.getAmount(player) >= arcanaConsumedUse) {
            if(!level.isClientSide()) Arcana.modifyAmount(player, -arcanaConsumedUse);
            player.getCooldowns().addCooldown(player.getItemInHand(hand), cooldown);
            player.awardStat(ITEM_USED.get(this));
            return arcanicUse(level, player, hand);
        } return super.use(level, player, hand);
    }
//    @OnlyIn(CLIENT)
//    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
//        super.appendHoverText(stack, context, tooltip, flagIn);
//        PotionContents potioncontents = stack.get(POTION_CONTENTS);
//        if(potioncontents != null) {
//            if(!(this instanceof ItemMinersAmulet)) tooltip.add(LocalizeUtils.inflict());
//            potioncontents.addPotionTooltip(tooltip::add, 1, context.tickRate());
//        } if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
//    }
}