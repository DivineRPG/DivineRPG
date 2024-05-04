package divinerpg.items.base;

import com.google.common.collect.*;
import divinerpg.capability.ArcanaProvider;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.*;

public class ItemModSword extends SwordItem {
    public int arcanaConsumedUse;
    public int arcanaConsumedAttack;
    public int cooldown;
    public ItemModSword(Rarity rarity, Tier tier) {super(tier, 1, 1, new Properties().rarity(rarity));}
    public ItemModSword(Tier tier) {super(tier, 1, 1, new Properties());}
    public ItemModSword(Tier tier, Properties properties) {super(tier, 1, 1, properties);}
    //TODO: to use a different method, so that you can't spam click entities, then proceed using the new method in other places
    @Override public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if(arcana.getArcana() >= arcanaConsumedAttack) arcana.consume(player, arcanaConsumedAttack);
        }); return super.onLeftClickEntity(stack, player, entity);
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
        if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
        if(arcanaConsumedAttack > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedAttack));
        if(!stack.getItem().canBeDepleted()) tooltip.add(LocalizeUtils.infiniteUses());
    }
}