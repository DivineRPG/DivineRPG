package divinerpg.objects.items.vanilla;

import com.google.common.collect.Multimap;

import divinerpg.enums.BulletType;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.SoundCategory;

public class ItemAnchor extends RangedWeaponBase {

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
    }

    @Override
    @Deprecated // Use ItemStack sensitive version below.
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
                    new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 7, 0));
        }

        return multimap;
    }
}