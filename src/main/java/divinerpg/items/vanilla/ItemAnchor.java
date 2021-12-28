package divinerpg.items.vanilla;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.RarityList;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;

import java.util.UUID;

public class ItemAnchor extends ItemModRanged {
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;
    protected static final UUID ATTACK_MODIFIER = UUID.fromString("de0e83e8-d7ff-11eb-b8bc-0242ac130003");
    public ItemAnchor(String name, BulletType projectileType) {

        super(name,
                RarityList.COMMON,
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
