package divinerpg.events;

import divinerpg.config.CommonConfig;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

public class Tooltips {
    @SubscribeEvent
    public void onItemTooltip(final ItemTooltipEvent event) {
        List<Component> tooltip = event.getToolTip();
        ItemStack stack = event.getItemStack();
        if(stack.getItem() instanceof TieredItem item) {
            if(CommonConfig.Values.TOOL_TOOLTIPIFICATION && (stack.is(ItemTags.SHOVELS) || stack.is(ItemTags.PICKAXES) || stack.is(Tags.Items.MINING_TOOL_TOOLS) || stack.is(ItemTags.AXES) || stack.is(ItemTags.HOES) || stack.is(Tags.Items.TOOLS) && !stack.is(Tags.Items.MELEE_WEAPON_TOOLS) && !stack.is(ItemTags.SWORDS))) {
                tooltip.add(1, LocalizeUtils.efficiency((int) item.getTier().getSpeed()));
                TagKey<Block> tagKey = item.getTier().getIncorrectBlocksForDrops();
                if(tagKey == BlockTags.INCORRECT_FOR_NETHERITE_TOOL) tooltip.add(2, LocalizeUtils.harvestLevel(Items.OBSIDIAN.asItem().getName(stack).getString() + "+"));
                else if(tagKey == BlockTags.INCORRECT_FOR_DIAMOND_TOOL) tooltip.add(2, LocalizeUtils.harvestLevel(Items.OBSIDIAN.asItem().getName(stack).getString()));
                else if(tagKey == BlockTags.INCORRECT_FOR_IRON_TOOL) tooltip.add(2, LocalizeUtils.harvestLevel(Items.DIAMOND.getName(stack).getString()));
                else if(tagKey == BlockTags.INCORRECT_FOR_STONE_TOOL) tooltip.add(2, LocalizeUtils.harvestLevel(Items.LAPIS_LAZULI.getName(stack).getString()));
                else if(tagKey == BlockTags.INCORRECT_FOR_GOLD_TOOL || tagKey == BlockTags.INCORRECT_FOR_WOODEN_TOOL) tooltip.add(2, LocalizeUtils.harvestLevel(Items.COAL.getName(stack).getString()));
            }
        }
    }
}