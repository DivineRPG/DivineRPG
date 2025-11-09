package divinerpg.compat.farmersdelight;

import divinerpg.config.CommonConfig;
import divinerpg.enums.ToolStats;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.common.item.KnifeItem;

import java.util.List;

import static net.neoforged.api.distmarker.Dist.CLIENT;

public class CookingKnife extends KnifeItem {
    public ToolStats sword;
    public CookingKnife(Tier tier) {
        super(tier, new Properties().attributes(SwordItem.createAttributes(tier, 1, -2.4F)));
        sword = (ToolStats)tier;
    }
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        if(CommonConfig.Values.TOOL_TOOLTIPIFICATION && (stack.is(ItemTags.SHOVELS) || stack.is(ItemTags.PICKAXES) || stack.is(Tags.Items.MINING_TOOL_TOOLS) || stack.is(ItemTags.AXES) || stack.is(ItemTags.HOES) || stack.is(Tags.Items.TOOLS) && !stack.is(Tags.Items.MELEE_WEAPON_TOOLS) && !stack.is(ItemTags.SWORDS))) {
            tooltip.add(1, LocalizeUtils.efficiency((int)getTier().getSpeed()));
            TagKey<Block> tagKey = getTier().getIncorrectBlocksForDrops();
            if(tagKey == BlockTags.INCORRECT_FOR_NETHERITE_TOOL) tooltip.add(2, LocalizeUtils.harvestLevel(Items.OBSIDIAN.asItem().getName(stack).getString() + "+"));
            else if(tagKey == BlockTags.INCORRECT_FOR_DIAMOND_TOOL) tooltip.add(2, LocalizeUtils.harvestLevel(Items.OBSIDIAN.asItem().getName(stack).getString()));
            else if (tagKey == BlockTags.INCORRECT_FOR_IRON_TOOL) tooltip.add(2, LocalizeUtils.harvestLevel(Items.DIAMOND.getName(stack).getString()));
        }
    }
}