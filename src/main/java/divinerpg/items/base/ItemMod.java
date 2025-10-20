package divinerpg.items.base;

import divinerpg.attachments.Arcana;
import divinerpg.items.vethea.ItemMinersAmulet;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static net.minecraft.core.component.DataComponents.POTION_CONTENTS;
import static net.minecraft.stats.Stats.ITEM_USED;
import static net.neoforged.api.distmarker.Dist.CLIENT;

public class ItemMod extends Item {
	public Integer nameColor;
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
            if(!level.isClientSide()) Arcana.modifyAmount(player, -arcanaConsumedUse);
            player.getCooldowns().addCooldown(this, cooldown);
            player.awardStat(ITEM_USED.get(this));
            return arcanicUse(level, player, hand);
        } return super.use(level, player, hand);
    }
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        PotionContents potioncontents = stack.get(POTION_CONTENTS);
        if(potioncontents != null) {
            if(!(this instanceof ItemMinersAmulet)) tooltip.add(LocalizeUtils.inflict());
            potioncontents.addPotionTooltip(tooltip::add, 1, context.tickRate());
        } if(getDescriptionId().contains("torridite")) tooltip.add(LocalizeUtils.i18n("torridite"));
        if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
    }
    @Override public Component getName(ItemStack pStack) {
    	return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}