package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static net.minecraft.tags.BlockTags.*;
import static net.minecraft.world.item.Items.*;
import static net.neoforged.api.distmarker.Dist.CLIENT;

public class ItemModPickaxe extends PickaxeItem {
	public Integer nameColor;
    //Base constructor
    public ItemModPickaxe(Tier tier, Properties properties) {
        super(tier, (tier.getUses() == 0 ? properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true)) : properties).attributes(PickaxeItem.createAttributes(tier, 0, -2.8F)));
    }
    //Base pickaxes
    public ItemModPickaxe(Tier tier) {this(tier, new Properties());}
    //Pickaxes with custom rarity
    public ItemModPickaxe(Tier tier, int rarity) {
        this(tier, new Properties());
        nameColor = rarity;
    }
	@OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency((int)getTier().getSpeed()));
        TagKey<Block> tagKey = getTier().getIncorrectBlocksForDrops();
        if(tagKey == INCORRECT_FOR_DIAMOND_TOOL || tagKey == INCORRECT_FOR_NETHERITE_TOOL) tooltip.add(LocalizeUtils.harvestLevel(OBSIDIAN.asItem().getName(stack)));
        else if(tagKey == INCORRECT_FOR_IRON_TOOL) tooltip.add(LocalizeUtils.harvestLevel(DIAMOND.getName(stack)));
    }
	@Override public Component getName(ItemStack pStack) {
    	return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}