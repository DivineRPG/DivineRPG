package divinerpg.objects.items.arcana;

import divinerpg.objects.entities.entity.projectiles.EntityReflector;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemReflector extends RangedWeaponBase {
	public ItemReflector() {
		super("arcanium_reflector",
				EntityReflector.class,
				null,
				SoundRegistry.REFLECTOR,
				SoundCategory.MASTER,
				-1,
				0,
				null,
				20);
		setCreativeTab(DivineRPGTabs.utility);
		setFull3D();
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(LocalizeUtils.i18n("tooltip.refector.push"));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}