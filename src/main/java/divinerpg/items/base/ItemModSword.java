package divinerpg.items.base;

import com.google.common.collect.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.*;

public class ItemModSword extends SwordItem {

    public ItemModSword(Rarity rarity, Tier tier) {
        super(tier, 1, 1.0F, new Item.Properties().rarity(rarity));
    }

    public ItemModSword(Tier tier) {
        super(tier, 1, 1.0F, new Item.Properties());
    }

    public ItemModSword(Tier tier, Item.Properties properties) {
        super(tier, 1, 1.0F, properties);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        addAdditionalInformation(tooltip);
        if (stack.getMaxDamage() == -1) {
            tooltip.add(LocalizeUtils.infiniteUses());
        }
    }

    protected void addAdditionalInformation(List<Component> list) {
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(final EquipmentSlot slot, final ItemStack stack) {
        final Multimap<Attribute, AttributeModifier> modifiers = ArrayListMultimap.create(super.getAttributeModifiers(slot, stack));

        if (slot == EquipmentSlot.MAINHAND) {
            replaceModifier(modifiers, Attributes.ATTACK_SPEED, BASE_ATTACK_SPEED_UUID, getTier().getSpeed());
        }

        return ImmutableMultimap.copyOf(modifiers);
    }

    /**
     * Replace a modifier in the {@link Multimap} with a copy that's had {@code multiplier} applied to its value.
     *
     * @param modifierMultimap The Multimap
     * @param attribute        The attribute being modified
     * @param id               The ID of the modifier
     * @param multiplier       The multiplier to apply
     */
    private void replaceModifier(final Multimap<Attribute, AttributeModifier> modifierMultimap, final Attribute attribute, final UUID id, final double multiplier) {
        final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute);
        final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getId().equals(id)).findFirst();

        modifierOptional.ifPresent(modifier -> {
            modifiers.remove(modifier);
            modifiers.add(new AttributeModifier(modifier.getId(), modifier.getName(), modifier.getAmount() * multiplier, modifier.getOperation()));
        });
    }
}