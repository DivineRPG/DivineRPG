package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.base.ItemBase;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;

public class ItemTeleportationCrystal extends ItemBase {

private static class CommandTeleporter implements ITeleporter {
private CommandTeleporter(BlockPos targetPos) {
}

@Override
public void placeEntity(World world, Entity entity, float yaw) {
}

}

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
public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
	ItemStack stack = player.getHeldItem(hand);
	BlockPos pos = player.getBedLocation();
	player.changeDimension(0, new CommandTeleporter(pos));
	player.moveToBlockPosAndAngles(pos, player.rotationYaw, player.rotationPitch);
	if (!player.isCreative()) {
		stack.damageItem(1, player);
	}
	return super.onItemRightClick(world, player, hand);
}
}