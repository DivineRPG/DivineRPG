package naturix.divinerpg.bases.items;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.portal.IceikaPortal;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SnowGlobe extends ItemBase{

	public SnowGlobe(String name) {
		super(name);
		setMaxStackSize(1);
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos p, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {

//		 if (worldIn.provider.getDimensionType().getId() > 0 || !ModBlocks.portalIceika.makePortal(worldIn, pos))
//	        {
//	            if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos))
//	            {
//	                worldIn.setBlockToAir(pos);
//	            }
//	            else
//	            {
//	                worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
//	            }
//	        }if (worldIn.provider.getDimensionType().getId() > Config.iceikaDimensionId || !ModBlocks.portalIceika.makePortal(worldIn, pos))
//	        {
//	            if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos))
//	            {
//	                worldIn.setBlockToAir(pos);
//	            }
//	            else
//	            {
//	                worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
//	            }
//	        }
		SnowGlobe.Size size = new SnowGlobe.Size(worldIn, p, EnumFacing.Axis.X);
		DivineRPG.logger.info(". Portal block count? "+ size.portalBlockCount+". Did the portal spawn? " + size.isValid());
		if(size.isValid() && size.portalBlockCount == 0) {
			size.placePortalBlocks();
		
		}
            return EnumActionResult.SUCCESS;
        }
	public static class Size {
		private final World world;
		private final EnumFacing.Axis axis;
		private final EnumFacing rightDir;
		private final EnumFacing leftDir;
		private int portalBlockCount;
		private BlockPos bottomLeft;
		private int height;
		private int width;

		public Size(World worldIn, BlockPos pos, EnumFacing.Axis axis) {
			this.world = worldIn;
			this.axis = axis;

			if(axis == EnumFacing.Axis.X) {
				this.leftDir = EnumFacing.EAST;
				this.rightDir = EnumFacing.WEST;
			} else {
				this.leftDir = EnumFacing.NORTH;
				this.rightDir = EnumFacing.SOUTH;
			}

			for(BlockPos blockpos = pos; pos.getY() > blockpos.getY() - 21 && pos.getY() > 0 && this.isEmptyBlock(worldIn.getBlockState(pos.down()).getBlock()); pos = pos.down()) {
				;
			}

			int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;

			if(i >= 0) {
				this.bottomLeft = pos.offset(this.leftDir, i);
				this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);

				if(this.width < 2 || this.width > 21) {
					this.bottomLeft = null;
					this.width = 0;
				}
			}

			if(this.bottomLeft != null) {
				this.height = this.calculatePortalHeight();
			}
		}

		protected int getDistanceUntilEdge(BlockPos pos, EnumFacing facing) {
			int i;

			for(i = 0; i < 22; ++i) {
				BlockPos blockpos = pos.offset(facing, i);

				if(!this.isEmptyBlock(this.world.getBlockState(blockpos).getBlock()) || this.world.getBlockState(blockpos.down()).getBlock() != Blocks.SNOW) {
					break;
				}
			}

			Block block = this.world.getBlockState(pos.offset(facing, i)).getBlock();
			return block == Blocks.SNOW ? i : 0;
		}

		public int getHeight() {
			return this.height;
		}

		public int getWidth() {
			return this.width;
		}

		protected int calculatePortalHeight() {
			label56:

				for(this.height = 0; this.height < 21; ++this.height) {
					for(int i = 0; i < this.width; ++i) {
						BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i).up(this.height);
						Block block = this.world.getBlockState(blockpos).getBlock();

						if(!this.isEmptyBlock(block)) {
							break label56;
						}

						if(block == ModBlocks.portalIceika) {
							++this.portalBlockCount;
						}

						if(i == 0) {
							block = this.world.getBlockState(blockpos.offset(this.leftDir)).getBlock();

							if(block != Blocks.SNOW) {
								break label56;
							}
						}
						else if(i == this.width - 1) {
							block = this.world.getBlockState(blockpos.offset(this.rightDir)).getBlock();

							if(block != Blocks.SNOW) {
								break label56;
							}
						}
					}
				}

		for(int j = 0; j < this.width; ++j) {
			if (this.world.getBlockState(this.bottomLeft.offset(this.rightDir, j).up(this.height)).getBlock() != Blocks.SNOW) {
				this.height = 0;
				break;
			}
		}

		if (this.height <= 21 && this.height >= 3) {
			return this.height;
		} else {
			this.bottomLeft = null;
			this.width = 0;
			this.height = 0;
			return 0;
		}
		}

		protected boolean isEmptyBlock(Block blockIn) {
			return blockIn.getMaterial(blockIn.getDefaultState()) == Material.AIR || blockIn == ModBlocks.portalIceika;
		}

		public boolean isValid() {
			return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
		}

		public void placePortalBlocks() {
			for(int i = 0; i < this.width; ++i) {
				BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i);

				for(int j = 0; j < this.height; ++j) {
					this.world.setBlockState(blockpos.up(j), ModBlocks.portalIceika.getDefaultState().withProperty(IceikaPortal.AXIS, this.axis), 2);
				}
			}
		}
	}
}