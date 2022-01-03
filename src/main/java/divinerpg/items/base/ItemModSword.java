package divinerpg.items.base;

import com.google.common.collect.*;
import divinerpg.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

// speed slowdown from http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/modification-development/2679129-how-do-i-change-the-attack-cooldown-of-a-weapon
public class ItemModSword extends SwordItem {

    public ItemModSword(String name, Rarity rarity, IItemTier tier, ItemGroup group) {
        super(tier, 3, 1.6F, new Item.Properties().tab(group).rarity(rarity));
        setRegistryName(DivineRPG.MODID, name);
    }
    public ItemModSword(String name, IItemTier tier, Item.Properties properties) {
        super(tier, 3, 1.6F, properties);
        setRegistryName(DivineRPG.MODID, name);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        addAdditionalInformation(tooltip);
        if (getMaxDamage() == -1) {
            tooltip.add(LocalizeUtils.infiniteUses());
        }
    }

    protected void addAdditionalInformation(List<ITextComponent> list) {
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(final EquipmentSlotType slot, final ItemStack stack) {
        final Multimap<Attribute, AttributeModifier> modifiers = ArrayListMultimap.create(super.getAttributeModifiers(slot, stack));

        if (slot == EquipmentSlotType.MAINHAND) {
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