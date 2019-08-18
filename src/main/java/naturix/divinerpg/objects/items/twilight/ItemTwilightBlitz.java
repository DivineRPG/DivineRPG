package naturix.divinerpg.objects.items.twilight;

import com.google.common.collect.Multimap;

import naturix.divinerpg.enums.BulletType;
import naturix.divinerpg.objects.items.base.RangedWeaponBase;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.SoundCategory;

public class ItemTwilightBlitz extends RangedWeaponBase {

    public ItemTwilightBlitz(String name, BulletType projectileType, Item ammo) {
        super(name,
                null,
                projectileType,
                ModSounds.BLITZ,
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
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER,
                    "Weapon modifier", this.bulletType.getDamage() - 1, 0));
        }

        return multimap;
    }
}
