package naturix.divinerpg.objects.items.arcana;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityReflector;
import naturix.divinerpg.objects.items.base.RangedWeaponBase;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipHelper;
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
				ModSounds.REFLECTOR,
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
		tooltip.add(TooltipHelper.getInfoText("tooltip.refector.push"));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}