package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.*;
import java.util.List;

import static net.minecraft.tags.BlockTags.*;

public class ItemModHoe extends HoeItem {
    public ItemModHoe(Tier tier, Rarity rarity) {
        super(tier, new Properties().attributes(HoeItem.createAttributes(tier, 0, 0)).rarity(rarity));
    }
    public ItemModHoe(Tier tier, float attackSpeed) {
        super(tier, new Properties().attributes(HoeItem.createAttributes(tier, 0, attackSpeed)));
    }
    public ItemModHoe(Tier tier, Properties properties) {
        super(tier, properties.attributes(HoeItem.createAttributes(tier, 0, 0)));
    }
	@OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency((int)getTier().getSpeed()));
        TagKey<Block> tagKey = getTier().getIncorrectBlocksForDrops();
        if(!stack.isDamageableItem()) stack.set(DataComponents.UNBREAKABLE, new Unbreakable(true));
    }
}