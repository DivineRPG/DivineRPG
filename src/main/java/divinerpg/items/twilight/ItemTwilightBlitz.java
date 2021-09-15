package divinerpg.items.twilight;

import com.google.common.collect.*;
import divinerpg.enums.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

import java.util.*;
import java.util.function.*;

public class ItemTwilightBlitz extends ItemModRanged {
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;
    protected static final UUID ATTACK_MODIFIER = UUID.fromString("de0e83e8-d7ff-11eb-b8bc-0242ac130007");

    public ItemTwilightBlitz(String name, BulletType projectileType, Supplier<Item> ammoSupplier) {
        super(name,null, projectileType, SoundRegistry.BLITZ, SoundCategory.MASTER,-1,0, ammoSupplier,0);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_MODIFIER, "Weapon attack", bulletType.getDamage() - 1, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        return equipmentSlot == EquipmentSlotType.OFFHAND ? this.attributeModifiers : super.getAttributeModifiers(equipmentSlot, stack);
    }
}
