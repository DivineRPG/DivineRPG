package divinerpg.items.twilight;

import com.google.common.collect.*;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.item.*;
import java.util.UUID;

public class ItemTwilightBlitz extends ItemModRanged {
    protected static final UUID ATTACK_MODIFIER = UUID.fromString("de0e83e8-d7ff-11eb-b8bc-0242ac130007");
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;
    public ItemTwilightBlitz(Rarity rarity, BulletType bulletType, Item ammoSupplier) {
        super(rarity, null, bulletType, SoundRegistry.BLITZ.get(), 0, 0, ammoSupplier, 0);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_MODIFIER, "Weapon attack", bulletType.getDamage() - 1, AttributeModifier.Operation.ADDITION));
        attributeModifiers = builder.build();
    }
    @Override public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {return equipmentSlot == EquipmentSlot.OFFHAND ? attributeModifiers : super.getAttributeModifiers(equipmentSlot, stack);}
}