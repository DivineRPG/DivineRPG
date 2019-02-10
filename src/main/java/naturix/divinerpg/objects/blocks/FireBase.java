package naturix.divinerpg.objects.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FireBase extends Block {
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);

	public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(1F, 0.0F, 1F, 0F, 0.1F, 0F);
	public String name;

	public FireBase(String name) {
		super(Material.FIRE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
		this.setTickRandomly(true);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.name = name;
	}

	/**
	 * Checks if the block can be caught on fire
	 */
	@Deprecated // Use canCatchFire with face sensitive version below
	public boolean canCatchFire(IBlockAccess worldIn, BlockPos pos) {
		return canCatchFire(worldIn, pos, EnumFacing.UP);
	}

	/*
	 * ================================= Forge Start
	 * ======================================
	 */
	/**
	 * Side sensitive version that calls the block function.
	 *
	 * @param world
	 *            The current worldgen
	 * @param pos
	 *            Block position
	 * @param face
	 *            The side the fire is coming from
	 * @return True if the face can catch fire.
	 */
	public boolean canCatchFire(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return world.getBlockState(pos).getBlock().isFlammable(world, pos, face);
	}

	/*
	 * ================================= Forge Start
	 * ======================================
	 */
	protected boolean canDie(World worldIn, BlockPos pos) {
		return worldIn.isRainingAt(pos) || worldIn.isRainingAt(pos.west()) || worldIn.isRainingAt(pos.east())
		        || worldIn.isRainingAt(pos.north()) || worldIn.isRainingAt(pos.south());
	}

	private boolean canNeighborCatchFire(World worldIn, BlockPos pos) {
		for (EnumFacing enumfacing : EnumFacing.values()) {
			if (this.canCatchFire(worldIn, pos.offset(enumfacing), enumfacing.getOpposite())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Checks if this block can be placed exactly at the given position.
	 */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).isTopSolid() || this.canNeighborCatchFire(worldIn, pos);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { AGE });
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	/**
	 * Get the actual Block state of this Block at the given position. This applies
	 * properties not visible in the metadata, such as fence connections.
	 */
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return this.getDefaultState();
	}

	/**
	 * Get the geometry of the queried face at the given position and state. This is
	 * used to decide whether things like buttons are allowed to be placed on the
	 * face, or how glass panes connect to the face, among other things.
	 * <p>
	 * Common values are {@code SOLID}, which is the default, and {@code UNDEFINED},
	 * which represents something that does not fit the other descriptions and will
	 * generally cause other things not to connect to the face.
	 * 
	 * @return an approximation of the form of the given face
	 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BLOCK_AABB;
	}

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	/**
	 * Get the MapColor for this Block and the given BlockState
	 */
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return MapColor.TNT;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(AGE).intValue();
	}

	private int getNeighborEncouragement(World worldIn, BlockPos pos) {
		if (!worldIn.isAirBlock(pos)) {
			return 0;
		} else {
			int i = 0;

			for (EnumFacing enumfacing : EnumFacing.values()) {
				i = Math.max(worldIn.getBlockState(pos.offset(enumfacing)).getBlock().getFireSpreadSpeed(worldIn,
				        pos.offset(enumfacing), enumfacing.getOpposite()), i);
			}

			return i;
		}
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
	}

	/**
	 * Returns if this block is collidable. Only used by fire, although stairs
	 * return that of the block that the stair is made of (though nobody's going to
	 * make fire stairs, right?)
	 */
	@Override
	public boolean isCollidable() {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for
	 * render
	 */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	/**
	 * Called when a neighboring block was changed and marks that this state should
	 * perform any checks during a neighbor change. Cases may include when redstone
	 * power is updated, cactus blocks popping off due to a neighboring solid block,
	 * etc.
	 */
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
			worldIn.setBlockToAir(pos);
		}
	}

	/**
	 * Called after the block is set in the Chunk data, but before the Tile Entity
	 * is set
	 */
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if (worldIn.provider.getDimensionType().getId() > 0 || ModBlocks.portalEden.makePortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}
		if (worldIn.provider.getDimensionType().getId() > Config.edenDimensionId
		        || !ModBlocks.portalEden.makePortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}

		if (worldIn.provider.getDimensionType().getId() > 0 || !ModBlocks.portalWild.makePortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}
		if (worldIn.provider.getDimensionType().getId() > Config.wildWoodDimensionId
		        || !ModBlocks.portalWild.makePortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}

		if (worldIn.provider.getDimensionType().getId() > 0 || !ModBlocks.portalApalachia.makePortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}
		if (worldIn.provider.getDimensionType().getId() > Config.apalachiaDimensionId
		        || !ModBlocks.portalApalachia.makePortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}

		if (worldIn.provider.getDimensionType().getId() > 0 || !ModBlocks.portalSkythern.makePortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}
		if (worldIn.provider.getDimensionType().getId() > Config.skythernDimensionId
		        || !ModBlocks.portalSkythern.makePortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}

		if (worldIn.provider.getDimensionType().getId() > 0 || !ModBlocks.portalMortum.makePortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}
		if (worldIn.provider.getDimensionType().getId() > Config.mortumDimensionId
		        || !ModBlocks.portalMortum.makePortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}

		if (worldIn.provider.getDimensionType().getId() > 0 || !ModBlocks.portalIceika.makePortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}
		if (worldIn.provider.getDimensionType().getId() > Config.iceikaDimensionId
		        || !ModBlocks.portalIceika.makePortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}

	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random random) {
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(24) == 0) {
			worldIn.playSound(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, SoundEvents.BLOCK_FIRE_AMBIENT,
			        SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
		}

		if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP)
		        && !ModBlocks.blueFire.canCatchFire(worldIn, pos.down(), EnumFacing.UP)) {
			if (ModBlocks.blueFire.canCatchFire(worldIn, pos.west(), EnumFacing.EAST)) {
				for (int j = 0; j < 2; ++j) {
					double d3 = pos.getX() + rand.nextDouble() * 0.10000000149011612D;
					double d8 = pos.getY() + rand.nextDouble();
					double d13 = pos.getZ() + rand.nextDouble();
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d3, d8, d13, 0.0D, 0.0D, 0.0D);
				}
			}

			if (ModBlocks.blueFire.canCatchFire(worldIn, pos.east(), EnumFacing.WEST)) {
				for (int k = 0; k < 2; ++k) {
					double d4 = pos.getX() + 1 - rand.nextDouble() * 0.10000000149011612D;
					double d9 = pos.getY() + rand.nextDouble();
					double d14 = pos.getZ() + rand.nextDouble();
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d4, d9, d14, 0.0D, 0.0D, 0.0D);
				}
			}

			if (ModBlocks.blueFire.canCatchFire(worldIn, pos.north(), EnumFacing.SOUTH)) {
				for (int l = 0; l < 2; ++l) {
					double d5 = pos.getX() + rand.nextDouble();
					double d10 = pos.getY() + rand.nextDouble();
					double d15 = pos.getZ() + rand.nextDouble() * 0.10000000149011612D;
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d5, d10, d15, 0.0D, 0.0D, 0.0D);
				}
			}

			if (ModBlocks.blueFire.canCatchFire(worldIn, pos.south(), EnumFacing.NORTH)) {
				for (int i1 = 0; i1 < 2; ++i1) {
					double d6 = pos.getX() + rand.nextDouble();
					double d11 = pos.getY() + rand.nextDouble();
					double d16 = pos.getZ() + 1 - rand.nextDouble() * 0.10000000149011612D;
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d6, d11, d16, 0.0D, 0.0D, 0.0D);
				}
			}

			if (ModBlocks.blueFire.canCatchFire(worldIn, pos.up(), EnumFacing.DOWN)) {
				for (int j1 = 0; j1 < 2; ++j1) {
					double d7 = pos.getX() + rand.nextDouble();
					double d12 = pos.getY() + 1 - rand.nextDouble() * 0.10000000149011612D;
					double d17 = pos.getZ() + rand.nextDouble();
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d7, d12, d17, 0.0D, 0.0D, 0.0D);
				}
			}
		} else {
			for (int i = 0; i < 3; ++i) {
				double d0 = pos.getX() + rand.nextDouble();
				double d1 = pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
				double d2 = pos.getZ() + rand.nextDouble();
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, name);
	}

	@Override
	public boolean requiresUpdates() {
		return false;
	}

	/**
	 * How many worldgen ticks before ticking
	 */
	@Override
	public int tickRate(World worldIn) {
		return 30;
	}

	private void tryCatchFire(World worldIn, BlockPos pos, int chance, Random random, int age, EnumFacing face) {
		int i = worldIn.getBlockState(pos).getBlock().getFlammability(worldIn, pos, face);

		if (random.nextInt(chance) < i) {
			IBlockState iblockstate = worldIn.getBlockState(pos);

			if (random.nextInt(age + 10) < 5 && !worldIn.isRainingAt(pos)) {
				int j = age + random.nextInt(5) / 4;

				if (j > 15) {
					j = 15;
				}

				worldIn.setBlockState(pos, this.getDefaultState().withProperty(AGE, Integer.valueOf(j)), 3);
			} else {
				worldIn.setBlockToAir(pos);
			}

			if (iblockstate.getBlock() == Blocks.TNT) {
				Blocks.TNT.onBlockDestroyedByPlayer(worldIn, pos,
				        iblockstate.withProperty(BlockTNT.EXPLODE, Boolean.valueOf(true)));
			}
		}
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (worldIn.getGameRules().getBoolean("doFireTick")) {
			if (!worldIn.isAreaLoaded(pos, 2)) {
				return; // Forge: prevent loading unloaded chunks when spreading fire
			}
			if (!this.canPlaceBlockAt(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			}

			Block block = worldIn.getBlockState(pos.down()).getBlock();
			boolean flag = block.isFireSource(worldIn, pos.down(), EnumFacing.UP);

			int i = state.getValue(AGE).intValue();

			if (!flag && worldIn.isRaining() && this.canDie(worldIn, pos) && rand.nextFloat() < 0.2F + i * 0.03F) {
				worldIn.setBlockToAir(pos);
			} else {
				if (i < 15) {
					state = state.withProperty(AGE, Integer.valueOf(i + rand.nextInt(3) / 2));
					worldIn.setBlockState(pos, state, 4);
				}

				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + rand.nextInt(10));

				if (!flag) {
					if (!this.canNeighborCatchFire(worldIn, pos)) {
						if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP)
						        || i > 3) {
							worldIn.setBlockToAir(pos);
						}

						return;
					}

					if (!this.canCatchFire(worldIn, pos.down(), EnumFacing.UP) && i == 15 && rand.nextInt(4) == 0) {
						worldIn.setBlockToAir(pos);
						return;
					}
				}

				boolean flag1 = worldIn.isBlockinHighHumidity(pos);
				if (flag1) {
				}

				// this.tryCatchFire(worldIn, pos.east(), 300 + j, rand, i, EnumFacing.WEST);
				// this.tryCatchFire(worldIn, pos.west(), 300 + j, rand, i, EnumFacing.EAST);
				// this.tryCatchFire(worldIn, pos.down(), 250 + j, rand, i, EnumFacing.UP);
				// this.tryCatchFire(worldIn, pos.up(), 250 + j, rand, i, EnumFacing.DOWN);
				// this.tryCatchFire(worldIn, pos.north(), 300 + j, rand, i, EnumFacing.SOUTH);
				// this.tryCatchFire(worldIn, pos.south(), 300 + j, rand, i, EnumFacing.NORTH);

				for (int k = -1; k <= 1; ++k) {
					for (int l = -1; l <= 1; ++l) {
						for (int i1 = -1; i1 <= 4; ++i1) {
							if (k != 0 || i1 != 0 || l != 0) {
								int j1 = 100;

								if (i1 > 1) {
									j1 += (i1 - 1) * 100;
								}

								BlockPos blockpos = pos.add(k, i1, l);
								int k1 = this.getNeighborEncouragement(worldIn, blockpos);

								if (k1 > 0) {
									int l1 = (k1 + 40 + worldIn.getDifficulty().getDifficultyId() * 7) / (i + 30);

									if (flag1) {
										l1 /= 2;
									}

									if (l1 > 0 && rand.nextInt(j1) <= l1
									        && (!worldIn.isRaining() || !this.canDie(worldIn, blockpos))) {
										int i2 = i + rand.nextInt(5) / 4;

										if (i2 > 15) {
											i2 = 15;
										}

										worldIn.setBlockState(blockpos, state.withProperty(AGE, Integer.valueOf(i2)),
										        3);
									}
								}
							}
						}
					}
				}
			}
		}
	}

}