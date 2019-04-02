package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.base.ItemBase;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTeleportationCrystal extends ItemBase {

public ItemTeleportationCrystal(String name) {
	super(name);
	setCreativeTab(DRPGCreativeTabs.utility);
	setMaxDamage(10);
	setMaxStackSize(1);
}

@Override
public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
	list.add("Teleport to spawn point");
	list.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getMetadata()));
}
}