package divinerpg.items.base;

import divinerpg.utils.ArcanaHelper;
import divinerpg.utils.LocalizeUtils;
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
import static net.minecraft.stats.Stats.ITEM_USED;

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
        if(arcanaConsumedUse != 0 && ArcanaHelper.getArcana(player) >= arcanaConsumedUse) {
            if(!level.isClientSide()) ArcanaHelper.setArcana(player, -arcanaConsumedUse);
            player.getCooldowns().addCooldown(player.getUseItem(), cooldown);
            player.awardStat(ITEM_USED.get(this));
            return arcanicUse(level, player, hand);
    }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
        PotionContents potioncontents = stack.get(POTION_CONTENTS);
        //TODO - potion contents
        if(potioncontents != null) {
//            if(!(this instanceof ItemMinersAmulet)) tooltip.add(LocalizeUtils.inflict());
//            potioncontents.addPotionTooltip(builder::accept, 1, context.tickRate());
        }
        if(arcanaConsumedUse > 0) builder.accept(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
    }
    @Override public Component getName(ItemStack pStack) {
        return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}