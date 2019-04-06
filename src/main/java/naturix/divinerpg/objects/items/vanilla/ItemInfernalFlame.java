package naturix.divinerpg.objects.items.vanilla;

import naturix.divinerpg.objects.entities.entity.vanilla.KingOfScorchers;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.log.Logging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemInfernalFlame extends ItemMod {

public ItemInfernalFlame(String name) {
	super(name, DRPGCreativeTabs.spawner);
	setMaxStackSize(1);
}

@Override
public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
        float hitX, float hitY, float hitZ) {
	if (!worldIn.isRemote && worldIn.provider.getDimension() == -1) {
		KingOfScorchers entityegg = new KingOfScorchers(worldIn);
		entityegg.setPositionAndRotation(pos.getX() + 0.5D, (double) pos.getY() + 1, pos.getZ(), player.rotationYaw,
		        player.rotationPitch);
		worldIn.spawnEntity(entityegg);
		player.addStat(StatList.getObjectUseStats(this));
		ItemStack stack = new ItemStack(this);
		stack.shrink(1);

		return EnumActionResult.SUCCESS;
	} else {
		if (worldIn.provider.getDimension() != -1 && worldIn.isRemote) {
			Logging.message(player, TextFormatting.AQUA + "This item can only be used in the nether.");
		}
		return EnumActionResult.FAIL;
	}
}
}
