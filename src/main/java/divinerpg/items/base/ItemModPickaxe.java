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

public class ItemModPickaxe extends PickaxeItem {
	public Optional<Integer> nameColor;
    public ItemModPickaxe(Tier tier, int rarity) {
        super(tier, new Properties().attributes(PickaxeItem.createAttributes(tier, 0, -2.8F)));
        this.nameColor = Optional.of(rarity);
    }
    public ItemModPickaxe(Tier tier) {
        super(tier, new Properties().attributes(PickaxeItem.createAttributes(tier, 0, -2.8F)));
    }
    public ItemModPickaxe(Tier tier, Properties properties) {
        super(tier, properties.attributes(PickaxeItem.createAttributes(tier, 0, -2.8F)));
    }
	@OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency((int)getTier().getSpeed()));
        TagKey<Block> tagKey = getTier().getIncorrectBlocksForDrops();
        if(!stack.isDamageableItem()) stack.set(DataComponents.UNBREAKABLE, new Unbreakable(true));
    }
	@Override
    public Component getName(ItemStack pStack) {
    	return nameColor != null && nameColor.isPresent() ? ((MutableComponent) super.getName(pStack)).withColor(nameColor.get()) : super.getName(pStack);
    }
}