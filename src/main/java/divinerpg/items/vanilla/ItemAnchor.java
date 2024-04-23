package divinerpg.items.vanilla;

import com.google.common.collect.*;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class ItemAnchor extends ItemModRanged {
    protected static final UUID ATTACK_MODIFIER = UUID.fromString("de0e83e8-d7ff-11eb-b8bc-0242ac130003");
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public ItemAnchor(BulletType projectileType) {
        super(projectileType, SoundRegistry.BLITZ.get(), null, 0, 0);

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_MODIFIER, "Weapon attack", 7.0D, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();

    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {
        return equipmentSlot == EquipmentSlot.OFFHAND ? this.attributeModifiers : super.getAttributeModifiers(equipmentSlot, stack);
    }
}
