package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.*;
import java.util.List;
import java.util.Optional;

import static net.minecraft.tags.BlockTags.*;

public class ItemModShovel extends ShovelItem {
	public Optional<Integer> nameColor;
    public ItemModShovel(Tier tier, int nameColor) {
        super(tier, new Properties().attributes(ShovelItem.createAttributes(tier, 0, -3)));
        this.nameColor = Optional.of(nameColor);
    }
    public ItemModShovel(Tier tier) {
        super(tier, new Properties().attributes(ShovelItem.createAttributes(tier, 0, -3)));
    }
    public ItemModShovel(Tier tier, Properties properties) {
        super(tier, properties.attributes(ShovelItem.createAttributes(tier, 0, -3)));
    }
	@OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency((int)getTier().getSpeed()));
        TagKey<Block> tagKey = getTier().getIncorrectBlocksForDrops();
        tooltip.add(LocalizeUtils.harvestLevel(
            tagKey == INCORRECT_FOR_WOODEN_TOOL || tagKey == INCORRECT_FOR_GOLD_TOOL ? Items.COAL
            : (tagKey == INCORRECT_FOR_STONE_TOOL ? Items.LAPIS_LAZULI
            : (tagKey == INCORRECT_FOR_IRON_TOOL ? Items.DIAMOND : Items.OBSIDIAN))));
        if(!stack.isDamageableItem()) stack.set(DataComponents.UNBREAKABLE, new Unbreakable(true));
    }
	@Override
    public Component getName(ItemStack pStack) {
    	return nameColor != null && nameColor.isPresent() ? ((MutableComponent) super.getName(pStack)).withColor(nameColor.get()) : super.getName(pStack);
    }
}