package net.divinerpg.items.base;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Consumer;

import static net.minecraft.core.component.DataComponents.POTION_CONTENTS;

public class ItemMod extends Item {
    public Integer nameColor;
    public int arcanaConsumedUse, cooldown;
//    public ItemMod() {super(new Properties());}
    public ItemMod(Properties properties) {super(properties);}
    public ItemMod setArcanaUseConsumption(int amount) {
        arcanaConsumedUse = amount;
        return this;
    }
    public ItemMod setArcanaUseCooldown(int amount) {
        cooldown = amount;
        return this;
    }
    protected InteractionResult arcanicUse(Level level, Player player, InteractionHand hand) {
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        //TODO - Arcana
//        if(arcanaConsumedUse != 0 && Arcana.getAmount(player) >= arcanaConsumedUse) {
//            if(!level.isClientSide()) Arcana.modifyAmount(player, -arcanaConsumedUse);
//            player.getCooldowns().addCooldown(this, cooldown);
//            player.awardStat(ITEM_USED.get(this));
//            return arcanicUse(level, player, hand);
//    }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
        PotionContents potioncontents = stack.get(POTION_CONTENTS);
        //TODO - potion contents
//        if(potioncontents != null) {
//            if(!(this instanceof ItemMinersAmulet)) tooltip.add(LocalizeUtils.inflict());
//            potioncontents.addPotionTooltip(tooltip::add, 1, context.tickRate());
//        }
//        if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
    }
    @Override public Component getName(ItemStack pStack) {
        return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}