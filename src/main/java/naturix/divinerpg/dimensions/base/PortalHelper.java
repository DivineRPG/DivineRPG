package naturix.divinerpg.dimensions.base;

import naturix.divinerpg.ModBlocks;
import naturix.divinerpg.bases.PortalBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class PortalHelper {

	public static Block getBlock(IBlockAccess world, int i, int j, int k) {
		return world.getBlockState(new BlockPos(i, j, k)).getBlock();
	}

	public static boolean tryToCreatePortal(World par1World, int par2, int par3, int par4) {
		byte b0 = 0;
		byte b1 = 0;
		if (getBlock(par1World, par2 - 1, par3, par4) == ModBlocks.blockEden || getBlock(par1World, par2 + 1, par3, par4) == ModBlocks.blockEden) {
			b0 = 1;
		}
		if (getBlock(par1World, par2, par3, par4 - 1) == ModBlocks.blockEden || getBlock(par1World, par2, par3, par4 + 1) == ModBlocks.blockEden) {
			b1 = 1;
		}
		if (b0 == b1) {
			return false;
		} else {
			if (getBlock(par1World, par2 - b0, par3, par4 - b1) == Blocks.AIR) {
				par2 -= b0;
				par4 -= b1;
			}
			int l;
			int i1;
			for (l = -1; l <= 2; ++l) {
				for (i1 = -1; i1 <= 3; ++i1) {
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
					if (l != -1 && l != 2 || i1 != -1 && i1 != 3) {
						Block j1 = getBlock(par1World, par2 + b0 * l, par3 + i1, par4 + b1 * l);
						if (flag) {
							if (j1 != ModBlocks.blockEden) {
								return false;
							}
						}
						/*
						 * else if (j1 != 0 && j1 !=
						 * Main.TutorialFire.blockID) { return false; }
						 */
					}
				}
			}
			for (l = 0; l < 2; ++l) {
				for (i1 = 0; i1 < 3; ++i1) {
					IBlockState iblockstate = PortalBase.portal.getDefaultState().withProperty(BlockPortal.AXIS,
							b0 == 0 ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
					par1World.setBlockState(new BlockPos(par2 + b0 * l, par3 + i1, par4 + b1 * l), iblockstate, 3);
				}
			}
			return true;
		}
	}
	

}
