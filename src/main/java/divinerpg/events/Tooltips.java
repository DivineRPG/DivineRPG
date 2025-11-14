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
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

import static net.minecraft.ChatFormatting.*;
import static net.neoforged.api.distmarker.Dist.CLIENT;

@OnlyIn(CLIENT)
public class Tooltips {
    @SubscribeEvent
    public void onItemTooltip(final ItemTooltipEvent event) {
        List<Component> tooltip = event.getToolTip();
        ItemStack stack = event.getItemStack();
        if(stack.getItem() instanceof TieredItem item) {
            if(ClientConfig.Values.TOOL_TOOLTIPIFICATION
                    && (stack.is(ItemTags.SHOVELS) || stack.is(ItemTags.PICKAXES) || stack.is(Tags.Items.MINING_TOOL_TOOLS)
                    || stack.is(ItemTags.AXES) || stack.is(ItemTags.HOES) || stack.is(ItemTags.MINING_ENCHANTABLE)
                    || stack.is(Tags.Items.TOOLS) && !stack.is(Tags.Items.MELEE_WEAPON_TOOLS) && !stack.is(ItemTags.SWORDS))) {
                tooltip.add(1, LocalizeUtils.efficiency((int)item.getTier().getSpeed()));
                TagKey<Block> tagKey = item.getTier().getIncorrectBlocksForDrops();
                HolderSet<Block> holderSet = BuiltInRegistries.BLOCK.getOrCreateTag(tagKey);
                if(holderSet.stream().allMatch(holder -> holder.is(BlockTags.INCORRECT_FOR_NETHERITE_TOOL))) tooltip.add(2, LocalizeUtils.harvestLevel(Component.literal(Items.OBSIDIAN.getName(stack).getString() + "+").withStyle(DARK_RED)));
                else if(holderSet.stream().allMatch(holder -> holder.is(BlockTags.INCORRECT_FOR_DIAMOND_TOOL))) tooltip.add(2, LocalizeUtils.harvestLevel(Component.literal(Items.OBSIDIAN.getName(stack).getString()).withColor(7096985)));
                else if(holderSet.stream().allMatch(holder -> holder.is(BlockTags.INCORRECT_FOR_IRON_TOOL))) tooltip.add(2, LocalizeUtils.harvestLevel(Component.literal(Items.DIAMOND.getName(stack).getString()).withColor(2289878)));
                else if(holderSet.stream().allMatch(holder -> holder.is(BlockTags.INCORRECT_FOR_STONE_TOOL))) tooltip.add(2, LocalizeUtils.harvestLevel(Component.literal(Items.LAPIS_LAZULI.getName(stack).getString()).withColor(5931746)));
                else if(holderSet.stream().allMatch(holder -> holder.is(BlockTags.INCORRECT_FOR_GOLD_TOOL)) || holderSet.stream().allMatch(holder -> holder.is(BlockTags.INCORRECT_FOR_WOODEN_TOOL))) tooltip.add(2, LocalizeUtils.harvestLevel(Component.literal(Items.COAL.getName(stack).getString()).withStyle(DARK_GRAY)));
                else tooltip.add(2, LocalizeUtils.harvestLevel(Component.translatable("selectWorld.versionUnknown").withStyle(WHITE, OBFUSCATED)));
            }
        }
    }
}