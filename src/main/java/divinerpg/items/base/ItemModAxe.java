package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import divinerpg.util.Utils;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.*;
import java.util.*;

import static net.minecraft.tags.BlockTags.*;
import static net.minecraft.world.item.Items.*;

public class ItemModAxe extends AxeItem {
	public Integer nameColor;
    //Base constructor
    public ItemModAxe(Tier tier, float attackSpeed, Properties properties) {
        super(tier, (tier.getUses() == 0 ? properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true)) : properties).attributes(AxeItem.createAttributes(tier, 0, attackSpeed)));
    }
    //Base axes
    public ItemModAxe(Tier tier, float attackSpeed) {this(tier, attackSpeed, new Properties());}
    //Axes with custom rarity
    public ItemModAxe(Tier tier, float attackSpeed, int rarity) {
        this(tier, attackSpeed, new Properties());
        nameColor = rarity;
    }
	@OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency((int)getTier().getSpeed()));
        TagKey<Block> tagKey = getTier().getIncorrectBlocksForDrops();
        if(tagKey == INCORRECT_FOR_DIAMOND_TOOL || tagKey == INCORRECT_FOR_NETHERITE_TOOL) tooltip.add(LocalizeUtils.harvestLevel(OBSIDIAN.asItem().getName(stack)));
        else if(tagKey == INCORRECT_FOR_IRON_TOOL) tooltip.add(LocalizeUtils.harvestLevel(DIAMOND.getName(stack)));
    }
	@Override public Component getName(ItemStack pStack) {
    	return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return super.supportsEnchantment(stack, enchantment) && !(stack.has(DataComponents.UNBREAKABLE) && (enchantment.is(Enchantments.MENDING) || enchantment.is(Enchantments.UNBREAKING)));
    }
    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return !(stack.has(DataComponents.UNBREAKABLE) && (Utils.hasStoredEnchantment(Enchantments.MENDING, book) || Utils.hasStoredEnchantment(Enchantments.UNBREAKING, book)));
    }
}