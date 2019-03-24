package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Multimap;

import naturix.divinerpg.objects.items.base.ItemProjectileShooter;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAnchor extends ItemProjectileShooter {

	public ItemAnchor(String name, String projectileTex, int damage) {
		super(name, damage, DRPGSoundHandler.BLITZ, projectileTex, -1, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		list.add(TooltipLocalizer.rangedDam(damage));
		list.add(TooltipLocalizer.meleeDam(8));
		list.add(TooltipLocalizer.infiniteAmmo());
		list.add(TooltipLocalizer.infiniteUses());
	}

	@Override
	@Deprecated // Use ItemStack sensitive version below.
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		Multimap multimap = super.getItemAttributeModifiers(equipmentSlot);
		multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
		        new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 8, 0));
		return multimap;
	}
}