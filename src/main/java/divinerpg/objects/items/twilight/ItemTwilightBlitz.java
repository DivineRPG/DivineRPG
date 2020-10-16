package divinerpg.objects.items.twilight;

import com.google.common.collect.Multimap;

import divinerpg.enums.BulletType;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.SoundCategory;

import java.util.function.Supplier;

public class ItemTwilightBlitz extends RangedWeaponBase {

    public ItemTwilightBlitz(String name, BulletType projectileType, Supplier<Item> ammoSupplier) {
        super(name,null, projectileType, SoundRegistry.BLITZ, SoundCategory.MASTER,-1,0, ammoSupplier,0);
    }

    @Override
    @Deprecated // Use ItemStack sensitive version below.
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER,
                    "Weapon modifier", this.bulletType.getDamage() - 1, 0));
        }

        return multimap;
    }
}
