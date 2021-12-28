package divinerpg.items.twilight;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundCategory;

import java.util.UUID;
import java.util.function.Supplier;

public class ItemTwilightBlitz extends ItemModRanged {
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;
    protected static final UUID ATTACK_MODIFIER = UUID.fromString("de0e83e8-d7ff-11eb-b8bc-0242ac130007");

    public ItemTwilightBlitz(String name, Rarity rarity, BulletType projectileType, Supplier<Item> ammoSupplier) {
        super(name, rarity, null, projectileType, SoundRegistry.BLITZ, SoundCategory.MASTER,-1,0, ammoSupplier,0);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_MODIFIER, "Weapon attack", bulletType.getDamage() - 1, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        return equipmentSlot == EquipmentSlotType.OFFHAND ? this.attributeModifiers : super.getAttributeModifiers(equipmentSlot, stack);
    }
}
