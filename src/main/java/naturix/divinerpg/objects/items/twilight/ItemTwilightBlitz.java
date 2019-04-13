package naturix.divinerpg.objects.items.twilight;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Multimap;

import naturix.divinerpg.enums.BulletType;
import naturix.divinerpg.objects.items.base.ItemProjectileShooter;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTwilightBlitz extends ItemProjectileShooter {

    public ItemTwilightBlitz(String name, BulletType projectileType, Item ammo) {
        super(name, projectileType, ModSounds.BLITZ, ammo, -1, 0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(TooltipLocalizer.rangedDam(this.projectileType.getDamage()));
        list.add(TooltipLocalizer.ammo(this.ammo));
        list.add(this.uses == -1 ? TooltipLocalizer.infiniteUses()
                : TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getMetadata()));
    }

    @Override
    @Deprecated // Use ItemStack sensitive version below.
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER,
                    "Weapon modifier", this.projectileType.getDamage() - 1, 0));
        }

        return multimap;
    }
}
