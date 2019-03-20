package naturix.divinerpg.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class TreeGen extends WorldGenAbstractTree {

		/** The minimum height of a generated trees. */
		private final int minTreeHeight;

		/** True if this trees should grow Vines. */
		private final boolean vinesGrow;

		/** The metadata value of the wood to use in trees generation. */
		private final int metaWood;

		/** The metadata value of the leaves to use in trees generation. */
		private final int metaLeaves;

		private IBlockState log;

		private IBlockState leaves;

		public TreeGen(boolean b, IBlockState iBlockState, IBlockState iBlockState2) {
			super(b);
			this.minTreeHeight = 4;
			this.metaWood = 0;
			this.metaLeaves = 0;
			this.vinesGrow = false;
			this.log = iBlockState;
			this.leaves = iBlockState2;
		}

		public boolean generate(World par1World, Random par2Random, BlockPos pos) {
			int par3 = pos.getX();
			int par4 = pos.getY();
			int par5 = pos.getZ();
			int var6 = par2Random.nextInt(3) + this.minTreeHeight;
			boolean var7 = true;

			if (par4 >= 1 && par4 + var6 + 1 <= 256) {
				int var8;
				byte var9;
				int var11;
				int var12;

				for (var8 = par4; var8 <= par4 + 1 + var6; ++var8) {
					var9 = 1;

					if (var8 == par4) {
						var9 = 0;
					}

					if (var8 >= par4 + 1 + var6 - 2) {
						var9 = 2;
					}

					for (int var10 = par3 - var9; var10 <= par3 + var9 && var7; ++var10) {
						for (var11 = par5 - var9; var11 <= par5 + var9 && var7; ++var11) {
							if (var8 >= 0 && var8 < 256) {
								Block var12s = par1World.getBlockState(new BlockPos(var10, var8, var11)).getBlock();
								var12 = Block.getIdFromBlock(var12s);

								if (var12 != 0 && var12s != Blocks.AIR && var12s != Blocks.GRASS && var12s != Blocks.DIRT
										&& var12s != log) {
									var7 = false;
								}
							} else {
								var7 = false;
							}
						}
					}
				}

				if (!var7) {
					return false;
				} else {
					Block var8s = par1World.getBlockState(new BlockPos(par3, par4 - 1, par5)).getBlock();
					var8 = Block.getIdFromBlock(var8s);

					if ((var8s == Blocks.GRASS || var8s == Blocks.DIRT) && par4 < 256 - var6 - 1) {
						par1World.setBlockState(new BlockPos(par3, par4 - 1, par5), Blocks.DIRT.getDefaultState(), 3);
						var9 = 3;
						byte var18 = 0;
						int var13;
						int var14;
						int var15;

						for (var11 = par4 - var9 + var6; var11 <= par4 + var6; ++var11) {
							var12 = var11 - (par4 + var6);
							var13 = var18 + 1 - var12 / 2;

							for (var14 = par3 - var13; var14 <= par3 + var13; ++var14) {
								var15 = var14 - par3;

								for (int var16 = par5 - var13; var16 <= par5 + var13; ++var16) {
									int var17 = var16 - par5;

									if ((Math.abs(var15) != var13 || Math.abs(var17) != var13 || par2Random.nextInt(2) != 0 && var12 != 0)) {
										par1World.setBlockState(new BlockPos(var14, var11, var16), leaves, 3);
									}
								}
							}
						}

						for (var11 = 0; var11 < var6; ++var11) {
							Block var12s = par1World.getBlockState(new BlockPos(par3, par4 + var11, par5)).getBlock();
							var12 = Block.getIdFromBlock(var12s);

							if (var12 == 0 || var12s != null) {
								par1World.setBlockState(new BlockPos(par3, par4 + var11, par5), log, 3);

								if (this.vinesGrow && var11 > 0) {
									if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(new BlockPos(par3 - 1, par4 + var11, par5))) {
										par1World.setBlockState(new BlockPos(par3 - 1, par4 + var11, par5), Blocks.AIR.getDefaultState(), 3);
									}

									if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(new BlockPos(par3 + 1, par4 + var11, par5))) {
										par1World.setBlockState(new BlockPos(par3 + 1, par4 + var11, par5), Blocks.AIR.getDefaultState(), 3);
									}

									if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(new BlockPos(par3, par4 + var11, par5 - 1))) {
										par1World.setBlockState(new BlockPos(par3, par4 + var11, par5 - 1), Blocks.AIR.getDefaultState(), 3);
									}

									if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(new BlockPos(par3, par4 + var11, par5 + 1))) {
										par1World.setBlockState(new BlockPos(par3, par4 + var11, par5 + 1), Blocks.AIR.getDefaultState(), 3);
									}
								}
							}
						}

						if (this.vinesGrow) {
							for (var11 = par4 - 3 + var6; var11 <= par4 + var6; ++var11) {
								var12 = var11 - (par4 + var6);
								var13 = 2 - var12 / 2;

								for (var14 = par3 - var13; var14 <= par3 + var13; ++var14) {
									for (var15 = par5 - var13; var15 <= par5 + var13; ++var15) {
										if (par1World.getBlockState(new BlockPos(var14, var11, var15)).getBlock() == Blocks.MAGMA) {
											if (par2Random.nextInt(4) == 0
													&& Block.getIdFromBlock(par1World.getBlockState(new BlockPos(var14 - 1, var11, var15))
															.getBlock()) == 0) {
												this.growVines(par1World, var14 - 1, var11, var15, 8);
											}

											if (par2Random.nextInt(4) == 0
													&& Block.getIdFromBlock(par1World.getBlockState(new BlockPos(var14 + 1, var11, var15))
															.getBlock()) == 0) {
												this.growVines(par1World, var14 + 1, var11, var15, 2);
											}

											if (par2Random.nextInt(4) == 0
													&& Block.getIdFromBlock(par1World.getBlockState(new BlockPos(var14, var11, var15 - 1))
															.getBlock()) == 0) {
												this.growVines(par1World, var14, var11, var15 - 1, 1);
											}

											if (par2Random.nextInt(4) == 0
													&& Block.getIdFromBlock(par1World.getBlockState(new BlockPos(var14, var11, var15 + 1))
															.getBlock()) == 0) {
												this.growVines(par1World, var14, var11, var15 + 1, 4);
											}
										}
									}
								}
							}

							if (par2Random.nextInt(5) == 0 && var6 > 5) {
								for (var11 = 0; var11 < 2; ++var11) {
									for (var12 = 0; var12 < 4; ++var12) {
										if (par2Random.nextInt(4 - var11) == 0) {
											var13 = par2Random.nextInt(3);
											par1World.setBlockState(new BlockPos(par3, par4 + var6 - 5 + var11, par5),
													Blocks.MELON_BLOCK.getDefaultState(), 3);
										}
									}
								}
							}
						}

						return true;
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		}

		/**
		 * Grows vines downward from the given block for a given length.
		 * Args: World, x, starty, z, vine-length
		 */
		private void growVines(World par1World, int par2, int par3, int par4, int par5) {
			par1World.setBlockState(new BlockPos(par2, par3, par4), Blocks.AIR.getDefaultState(), 3);
			int var6 = 4;

			while (true) {
				--par3;

				if (Block.getIdFromBlock(par1World.getBlockState(new BlockPos(par2, par3, par4)).getBlock()) != 0 || var6 <= 0) {
					return;
				}

				par1World.setBlockState(new BlockPos(par2, par3, par4), Blocks.AIR.getDefaultState(), 3);
				--var6;
			}
		}

		protected boolean canGrowInto(Block blockType) {
			return true;
		}

		public void generateSaplings(World worldIn, Random random, BlockPos pos) {
		}

		/**
		 * sets dirt at a specific location if it isn't already dirt
		 */
		protected void setDirtAt(World worldIn, BlockPos pos) {
			if (worldIn.getBlockState(pos).getBlock() != Blocks.DIRT) {
				this.setBlockAndNotifyAdequately(worldIn, pos, Blocks.DIRT.getDefaultState());
			}
		}

		public boolean isReplaceable(World world, BlockPos pos) {
			net.minecraft.block.state.IBlockState state = world.getBlockState(pos);
			return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos)
					|| state.getBlock().isWood(world, pos) || canGrowInto(state.getBlock());
		}

	}
