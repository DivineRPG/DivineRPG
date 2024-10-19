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

import com.google.common.base.Optional;

import static net.minecraft.tags.BlockTags.*;

public class ItemModAxe extends AxeItem {
	public Optional<Integer> nameColor;
    public ItemModAxe(Tier tier, float attackSpeed, int rarity) {
        super(tier, new Properties().attributes(AxeItem.createAttributes(tier, 0, attackSpeed)));
        this.nameColor = Optional.of(rarity);
    }
    public ItemModAxe(Tier tier, float attackSpeed) {
        super(tier, new Properties().attributes(AxeItem.createAttributes(tier, 0, attackSpeed)));
    }
    public ItemModAxe(Tier tier, float attackSpeed, Properties properties) {
        super(tier, properties.attributes(AxeItem.createAttributes(tier, 0, attackSpeed)));
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