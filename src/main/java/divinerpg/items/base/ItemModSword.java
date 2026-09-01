package divinerpg.items.base;

import divinerpg.utils.ArcanaHelper;
import divinerpg.utils.LocalizeUtils;
import divinerpg.utils.ToolStats;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.*;
import net.minecraft.util.Unit;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

import static net.minecraft.stats.Stats.ITEM_USED;

public class ItemModSword extends ItemMod {
    public Integer nameColor;
    public int arcanaConsumedUse, arcanaConsumedAttack, cooldown;
    public ToolStats sword;

    public ItemModSword(ToolStats tier, Properties properties) {
        super(tier.getMaterial().durability() == 0 ? properties.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).sword(tier.getMaterial(), 1.0F, -2.4F) : properties.durability(tier.getMaterial().durability()).sword(tier.getMaterial(), 1.0F, -2.4F));
        this.sword = tier;
    }

    public ItemModSword(Properties properties, ToolStats tier, int rarity) {
        this(tier, properties.sword(tier.getMaterial(), 1.0F, -2.4F));
        this.nameColor = rarity;
    }

    public ItemModSword(ToolStats tier, float speed, Properties properties) {
        super(tier.getMaterial().durability() == 0 ? properties.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).sword(tier.getMaterial(), 1.0F, -2.4F) : properties.durability(tier.getMaterial().durability()).sword(tier.getMaterial(), 1.0F, speed));
        this.sword = tier;
    }

    public ItemModSword setAttackArcanaConsumption(int amount) {
        this.arcanaConsumedAttack = amount;
        return this;
    }

    public ItemModSword setUseArcanaConsumption(int amount, int cooldown) {
        this.arcanaConsumedUse = amount;
        this.cooldown = cooldown;
        return this;
    }

    public void arcanicAttack(ItemStack stack, Player player, Entity entity) {}

    protected InteractionResult arcanicUse(Level level, Player player, InteractionHand hand) {
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (arcanaConsumedUse != 0 && ArcanaHelper.getArcana(player) >= arcanaConsumedUse) {
            if (!level.isClientSide()) {
                ArcanaHelper.modifyAmount(player, -arcanaConsumedUse);
            }
            player.getCooldowns().addCooldown(player.getUseItem(), cooldown);
            player.awardStat(ITEM_USED.get(this));
            return arcanicUse(level, player, hand);
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
        if (sword.getSpecial() == ToolStats.SwordSpecial.ARCANA_DAMAGE) builder.accept(LocalizeUtils.weakenedWithoutArcana());
        if (sword.getSpecial() == ToolStats.SwordSpecial.FLAME) builder.accept(LocalizeUtils.burn(sword.effectSec));
        if (sword.getSpecial() == ToolStats.SwordSpecial.LIGHTNING) builder.accept(LocalizeUtils.lightningShots());
        if (sword.getSpecial() == ToolStats.SwordSpecial.POISON) builder.accept(LocalizeUtils.poison(sword.effectSec));
        if (sword.getSpecial() == ToolStats.SwordSpecial.SLOW) builder.accept(LocalizeUtils.slow(sword.effectSec));
        if (sword.getSpecial() == ToolStats.SwordSpecial.SPEED) builder.accept(LocalizeUtils.i18n("shadow_saber"));
        if (arcanaConsumedUse > 0) builder.accept(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
        if (arcanaConsumedAttack > 0) builder.accept(LocalizeUtils.arcanaConsumed(arcanaConsumedAttack));
    }

    @Override
    public Component getName(ItemStack pStack) {
        return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}