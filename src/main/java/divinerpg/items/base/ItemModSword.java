package divinerpg.items.base;

import divinerpg.attachments.Arcana;
import divinerpg.enums.ToolStats;
import divinerpg.registries.EnchantmentRegistry;
import divinerpg.util.*;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.*;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.*;
import java.util.*;

public class ItemModSword extends SwordItem {
	public Integer nameColor;
    public int arcanaConsumedUse, arcanaConsumedAttack, cooldown;
    public ToolStats sword;
    //Base constructor
    public ItemModSword(Tier tier, Properties properties) {
        super(tier, (tier.getUses() == 0 ? properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true)) : properties).attributes(ShovelItem.createAttributes(tier, 1, tier.getSpeed())));
        sword = (ToolStats)tier;
    }
    //Have rarity
    public ItemModSword(Tier tier, int rarity) {
        this(tier, new Properties());
        sword = (ToolStats)tier;
        nameColor = rarity;
    }
    //No rarity
    public ItemModSword(Tier tier) {
        super(tier, (tier.getUses() == 0 ? new Properties().component(DataComponents.UNBREAKABLE, new Unbreakable(true)) : new Properties()).attributes(ShovelItem.createAttributes(tier, 1, tier.getSpeed())));
        sword = (ToolStats)tier;
    }
    public ItemModSword setAttackArcanaConsumption(int amount) {
    	arcanaConsumedAttack = amount;
    	return this;
    }
    public void arcanicAttack(ItemStack stack, Player player, Entity entity) {}
    protected InteractionResultHolder<ItemStack> arcanicUse(Level level, Player player, InteractionHand hand){
    	return InteractionResultHolder.success(player.getItemInHand(hand));
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(arcanaConsumedUse != 0 && Arcana.getAmount(player) >= arcanaConsumedUse) {
            if(!level.isClientSide()) Arcana.modifyAmount(player, -arcanaConsumedUse);
            player.getCooldowns().addCooldown(this, cooldown);
            player.awardStat(Stats.ITEM_USED.get(this));
            return arcanicUse(level, player, hand);
        } return super.use(level, player, hand);
    }

    @Override public boolean isEnchantable(ItemStack stack) {return true;}
    @Override public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return super.supportsEnchantment(stack, enchantment)
                && !(stack.has(DataComponents.UNBREAKABLE) && (enchantment.is(Enchantments.MENDING) || enchantment.is(Enchantments.UNBREAKING)))
                && !(sword.getSwordSpecial() == ToolStats.SwordSpecial.SLOW && enchantment.is(EnchantmentRegistry.BRAIN_FREEZE))
                && !(sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME && enchantment.is(Enchantments.FIRE_ASPECT));
    }
    @Override public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return !(stack.has(DataComponents.UNBREAKABLE) && (Utils.hasStoredEnchantment(Enchantments.MENDING, book) || Utils.hasStoredEnchantment(Enchantments.UNBREAKING, book)))
                && !(sword.getSwordSpecial() == ToolStats.SwordSpecial.SLOW && Utils.hasStoredEnchantment(EnchantmentRegistry.BRAIN_FREEZE, book))
                && !(sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME && Utils.hasStoredEnchantment(Enchantments.FIRE_ASPECT, book));
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.ARCANA_DAMAGE) tooltip.add(LocalizeUtils.weakenedWithoutArcana());
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME) tooltip.add(LocalizeUtils.burn(sword.effectSec));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.LIGHTNING) tooltip.add(LocalizeUtils.lightningShots());
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.POISON) tooltip.add(LocalizeUtils.poison(sword.effectSec));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.SLOW) tooltip.add(LocalizeUtils.slow(sword.effectSec));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.SPEED) tooltip.add(LocalizeUtils.i18n("shadow_saber"));
        if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
        if(arcanaConsumedAttack > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedAttack));
    }
    @Override public Component getName(ItemStack pStack) {
    	return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}