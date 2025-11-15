package divinerpg.events;

import divinerpg.config.ClientConfig;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

import static net.minecraft.ChatFormatting.*;
import static net.neoforged.api.distmarker.Dist.CLIENT;
import static net.neoforged.neoforge.common.Tags.Blocks.NEEDS_NETHERITE_TOOL;

@OnlyIn(CLIENT)
public class Tooltips {
    @SubscribeEvent
    public void onItemTooltip(final ItemTooltipEvent event) {
        List<Component> tooltip = event.getToolTip();
        ItemStack stack = event.getItemStack();
        if(stack.getItem() instanceof DiggerItem item && ClientConfig.Values.TOOL_TOOLTIPIFICATION) {
            tooltip.add(1, LocalizeUtils.efficiency((int)item.getTier().getSpeed()));
            TagKey<Block> tagKey = item.getTier().getIncorrectBlocksForDrops();
            HolderSet<Block> holderSet = BuiltInRegistries.BLOCK.getOrCreateTag(tagKey);
            if(holderSet.stream().anyMatch(holder -> holder.is(BlockTags.NEEDS_STONE_TOOL))) tooltip.add(2, LocalizeUtils.harvestLevel(Component.literal(Items.COAL.getName(stack).getString()).withStyle(DARK_GRAY)));
            else if(holderSet.stream().anyMatch(holder -> holder.is(BlockTags.NEEDS_IRON_TOOL))) tooltip.add(2, LocalizeUtils.harvestLevel(Component.literal(Items.LAPIS_LAZULI.getName(stack).getString()).withColor(5931746)));
            else if(holderSet.stream().anyMatch(holder -> holder.is(BlockTags.NEEDS_DIAMOND_TOOL))) tooltip.add(2, LocalizeUtils.harvestLevel(Component.literal(Items.DIAMOND.getName(stack).getString()).withColor(2293477)));
            else if(holderSet.stream().anyMatch(holder -> holder.is(NEEDS_NETHERITE_TOOL))) tooltip.add(2, LocalizeUtils.harvestLevel(Component.literal(Items.OBSIDIAN.getName(stack).getString()).withColor(7096985)));
            else tooltip.add(2, LocalizeUtils.harvestLevel(Component.literal(Items.OBSIDIAN.getName(stack).getString() + "+").withStyle(DARK_RED)));
        }
    }
}