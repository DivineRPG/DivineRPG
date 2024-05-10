package divinerpg.items.arcana;

import com.google.common.collect.*;
import divinerpg.capability.ArcanaProvider;
import divinerpg.items.base.ItemModSword;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import java.util.*;

public class ItemArcanaPoweredSword extends ItemModSword {
    protected static final UUID ATTACK_MODIFIER = UUID.fromString("de0e83e8-d7ff-11eb-b8bc-0242ac130001");
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;
    public int weakenedDamageValue;
    public ItemArcanaPoweredSword(Tier tier, int arcanaConsumed, int weakenedDamage) {
        super(tier);
        arcanaConsumedAttack = arcanaConsumed;
        weakenedDamageValue = weakenedDamage;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_MODIFIER, "Weapon attack", weakenedDamage, AttributeModifier.Operation.ADDITION));
        attributeModifiers = builder.build();
    }
    //TODO: to use a different method, this one leaves your attribute changed after the punch
    @Override public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if(arcana.getArcana() < arcanaConsumedAttack) {
                player.getAttributes().removeAttributeModifiers(getAttributeModifiers(EquipmentSlot.MAINHAND, stack));
                player.getAttributes().addTransientAttributeModifiers(attributeModifiers);
            } else {
                player.getAttributes().removeAttributeModifiers(attributeModifiers);
                player.getAttributes().addTransientAttributeModifiers(getAttributeModifiers(EquipmentSlot.MAINHAND, stack));
            }
        }); return super.onLeftClickEntity(stack, player, entity);
    }
    @Override public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {return equipmentSlot == EquipmentSlot.OFFHAND ? attributeModifiers : super.getAttributeModifiers(equipmentSlot, stack);}
}