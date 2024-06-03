package divinerpg.items.base;

import com.google.common.collect.*;
import divinerpg.capability.ArcanaProvider;
import divinerpg.enums.ToolStats;
import divinerpg.registries.EnchantmentRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.*;

public class ItemModSword extends SwordItem {
    public int arcanaConsumedUse;
    public int arcanaConsumedAttack;
    public int cooldown;
    public float healAmount;
    public ToolStats sword;
    //Have rarity
    public ItemModSword(Rarity rarity, Tier tier) {
        super(tier, 1, 1, new Properties().rarity(rarity));
        sword = (ToolStats)tier;
    }
    //No rarity
    public ItemModSword(Tier tier) {
        super(tier, 1, 1, new Properties());
        sword = (ToolStats)tier;
    }
    //Fire-resistant swords
    public ItemModSword(Tier tier, Properties properties) {
        super(tier, 1, 1, properties);
        sword = (ToolStats)tier;
    }
    //TODO: to find out why does arcana check doesn't seem to work with the hurtEnemy method
    @Override public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if(arcana.getArcana() >= arcanaConsumedAttack && arcanaConsumedAttack != 0) arcana.consume(player, arcanaConsumedAttack);
        }); return super.onLeftClickEntity(stack, player, entity);
    }
    @Override public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.SLOW) target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sword.effectSec * 20, sword.effectPower));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.POISON) target.addEffect(new MobEffectInstance(MobEffects.POISON, sword.effectSec * 20, sword.effectPower));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME) target.setSecondsOnFire(sword.effectSec);
        return super.hurtEnemy(stack, target, attacker);
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return player.getCapability(ArcanaProvider.ARCANA).map(arcana -> {
            if(arcana.getArcana() >= arcanaConsumedUse && arcanaConsumedUse != 0) {
                arcana.consume(player, arcanaConsumedUse);
                player.getCooldowns().addCooldown(this, cooldown);
                player.awardStat(Stats.ITEM_USED.get(this));
                return InteractionResultHolder.success(player.getItemInHand(hand));
            } return super.use(level, player, hand);
        }).orElse(InteractionResultHolder.pass(player.getItemInHand(hand)));
    }
    @Override public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME && enchantment == Enchantments.FIRE_ASPECT ||
           sword.getSwordSpecial() == ToolStats.SwordSpecial.SLOW && enchantment == EnchantmentRegistry.BRAIN_FREEZE.get()) return false;
        else return enchantment.category.canEnchant(stack.getItem());
    }
    @Override public Multimap<Attribute, AttributeModifier> getAttributeModifiers(final EquipmentSlot slot, final ItemStack stack) {
        final Multimap<Attribute, AttributeModifier> modifiers = ArrayListMultimap.create(super.getAttributeModifiers(slot, stack));
        if(slot == EquipmentSlot.MAINHAND) replaceModifier(modifiers, Attributes.ATTACK_SPEED, BASE_ATTACK_SPEED_UUID, getTier().getSpeed());
        return ImmutableMultimap.copyOf(modifiers);
    }
    /**
     * Replace a modifier in the {@link Multimap} with a copy that's had {@code multiplier} applied to its value.
     *
     * @param modifierMultimap - the Multimap
     * @param attribute - the attribute being modified
     * @param id - the ID of the modifier
     * @param multiplier - the multiplier to apply
     */
    private void replaceModifier(final Multimap<Attribute, AttributeModifier> modifierMultimap, final Attribute attribute, final UUID id, final double multiplier) {
        final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute);
        final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getId().equals(id)).findFirst();
        modifierOptional.ifPresent(modifier -> {
            modifiers.remove(modifier);
            modifiers.add(new AttributeModifier(modifier.getId(), modifier.getName(), modifier.getAmount() * multiplier, modifier.getOperation()));
        });
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.ARCANA_DAMAGE) tooltip.add(LocalizeUtils.weakenedWithoutArcana());
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME) tooltip.add(LocalizeUtils.burn(sword.effectSec));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.HEAL) tooltip.add(LocalizeUtils.healthHeal(healAmount / 2));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.LIGHTNING) tooltip.add(LocalizeUtils.lightningShots());
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.POISON) tooltip.add(LocalizeUtils.poison(sword.effectSec));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.SLOW) tooltip.add(LocalizeUtils.slow(sword.effectSec));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.SPEED) tooltip.add(LocalizeUtils.i18n("shadow_saber"));
        if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
        if(arcanaConsumedAttack > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedAttack));
        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
    }
}