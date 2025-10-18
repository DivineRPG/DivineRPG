package divinerpg.compat.farmersdelight;

import divinerpg.enums.ToolStats;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.item.KnifeItem;

import java.util.List;

import static net.minecraft.tags.BlockTags.*;
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
        tooltip.add(LocalizeUtils.efficiency((int)getTier().getSpeed()));
        TagKey<Block> tagKey = getTier().getIncorrectBlocksForDrops();
        if(tagKey == INCORRECT_FOR_DIAMOND_TOOL || tagKey == INCORRECT_FOR_NETHERITE_TOOL) tooltip.add(LocalizeUtils.harvestLevel(Items.OBSIDIAN.asItem().getName(stack)));
        else if (tagKey == INCORRECT_FOR_IRON_TOOL) tooltip.add(LocalizeUtils.harvestLevel(Items.DIAMOND.getName(stack)));
    }
}