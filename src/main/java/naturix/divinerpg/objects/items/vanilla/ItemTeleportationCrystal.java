package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.base.ItemBase;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.ItemTeleporter;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
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

	list.add("Not yet ready!");
	list.add("Works in overworld but not other dims");
}

@Override
public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer entityIn, EnumHand hand) {
	// The line below keeps crashing but thats how i thought you got the overworld?
	ItemTeleporter teleporter = new ItemTeleporter(worldIn.getMinecraftServer().getWorld(0));
	ItemStack stack = entityIn.getHeldItem(hand);

	EntityPlayerMP playerMP = (EntityPlayerMP) entityIn;

	teleporter.transferPlayerToDimension(playerMP, 0);
	if (!entityIn.isCreative())

	{
		stack.damageItem(1, entityIn);
	}
	return super.onItemRightClick(worldIn, entityIn, hand);
}

}