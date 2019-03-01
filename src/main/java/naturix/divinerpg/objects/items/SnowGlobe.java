package naturix.divinerpg.objects.items;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SnowGlobe extends ItemBase {

	public SnowGlobe(String name) {
		super(name);
		setMaxStackSize(1);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
	        EnumFacing facing, float hitX, float hitY, float hitZ) {
		pos = pos.offset(facing);
		ItemStack itemstack = player.getHeldItem(hand);

		if (!player.canPlayerEdit(pos, facing, itemstack)) {
			return EnumActionResult.FAIL;
		} else {
			if (worldIn.isAirBlock(pos)) {
				worldIn.playSound(player, pos, SoundEvents.BLOCK_SNOW_STEP, SoundCategory.BLOCKS, 1.0F,
				        itemRand.nextFloat() * 0.4F + 0.8F);
				worldIn.setBlockState(pos, ModBlocks.blueFire.getDefaultState(), 11);
			}

			if (player instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, pos, itemstack);
			}

			return EnumActionResult.SUCCESS;
		}
	}
}