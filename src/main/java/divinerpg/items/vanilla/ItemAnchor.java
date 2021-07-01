package divinerpg.items.vanilla;

import com.google.common.collect.*;
import divinerpg.enums.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

import java.util.*;

public class ItemAnchor extends ItemModRanged {
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;
    protected static final UUID ATTACK_MODIFIER = UUID.fromString("de0e83e8-d7ff-11eb-b8bc-0242ac130003");
    public ItemAnchor(String name, BulletType projectileType) {

        super(name,
                null,
                projectileType,
                SoundRegistry.BLITZ,
                SoundCategory.MASTER,
                -1,
                0,
                null,
                0);

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_MODIFIER, "Weapon attack", 7.0D, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();

    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        return equipmentSlot == EquipmentSlotType.OFFHAND ? this.attributeModifiers : super.getAttributeModifiers(equipmentSlot, stack);
    }
}
