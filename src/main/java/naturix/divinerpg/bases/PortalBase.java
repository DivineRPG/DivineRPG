package naturix.divinerpg.bases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import naturix.divinerpg.ModBlocks;
import naturix.divinerpg.ModDimensions;
import naturix.divinerpg.bases.clock.MysteriousClock;
import naturix.divinerpg.utils.Config;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PortalBase {
	public static Object instance;
	public static int DIMID = Config.dimensionId;
	private String name;
	public static PortalBaseWalker portal;
	public static MysteriousClock block;

	static {
		portal = ModBlocks.edenPortal;
	}

	
	public PortalBase() {
	}

	public static DimensionType dtype = (ModDimensions.edenDimension);


	public void preInit(FMLPreInitializationEvent event) {

		portal.setRegistryName(name);
		ForgeRegistries.BLOCKS.register(portal);
		ForgeRegistries.ITEMS.register(new ItemBlock(portal).setRegistryName(portal.getRegistryName()));

		DimensionManager.registerDimension(DIMID, dtype);

	}

	public static class WorldProviderMod extends WorldProvider {

		@Override
		public void init() {
			this.biomeProvider = new BiomeProviderCustom(this.world.getSeed(), world.getWorldInfo().getTerrainType());
		}

		public DimensionType getDimensionType() {
			return dtype;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public Vec3d getFogColor(float par1, float par2) {
			return new Vec3d(1.0D, 1.0D, 1.0D);
		}

		@Override
		public IChunkGenerator createChunkGenerator() {
			return new ChunkProviderModded(this.world, this.world.getSeed() - 22516);
		}

		@Override
		public boolean isSurfaceWorld() {
			return false;
		}

		@Override
		public boolean canCoordinateBeSpawn(int par1, int par2) {
			return false;
		}

		@Override
		public boolean canRespawnHere() {
			return false;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public boolean doesXZShowFog(int par1, int par2) {
			return false;
		}

		@Override
		protected void generateLightBrightnessTable() {
			float f = 0.5F;
			for (int i = 0; i <= 15; ++i) {
				float f1 = 1.0F - (float) i / 15.0F;
				this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
			}
		}

	}

	public static class TeleporterDimensionMod extends Teleporter {

		private final WorldServer worldServerInstance;
		/** A private Random() function in Teleporter */
		private final Random random;
		private final it.unimi.dsi.fastutil.longs.Long2ObjectMap<Teleporter.PortalPosition> destinationCoordinateCache = new it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap(
				4096);
		private static final String __OBFID = "CL_00000153";

		public TeleporterDimensionMod(WorldServer worldIn) {
			super(worldIn);
			this.worldServerInstance = worldIn;
			this.random = new Random(worldIn.getSeed());
		}

		public void placeInPortal(Entity entityIn, float rotationYaw) {
			if (this.worldServerInstance.provider.getDimension() != 1) {
				if (!this.placeInExistingPortal(entityIn, rotationYaw)) {
					this.makePortal(entityIn);
					this.placeInExistingPortal(entityIn, rotationYaw);
				}
			} else {
				int i = MathHelper.floor(entityIn.posX);
				int j = MathHelper.floor(entityIn.posY) - 1;
				int k = MathHelper.floor(entityIn.posZ);
				byte b0 = 1;
				byte b1 = 0;

				for (int l = -2; l <= 2; ++l) {
					for (int i1 = -2; i1 <= 2; ++i1) {
						for (int j1 = -1; j1 < 3; ++j1) {
							int k1 = i + i1 * b0 + l * b1;
							int l1 = j + j1;
							int i2 = k + i1 * b1 - l * b0;
							boolean flag = j1 < 0;
							this.worldServerInstance.setBlockState(new BlockPos(k1, l1, i2),
									flag ? ModBlocks.blockEden.getDefaultState() : Blocks.AIR.getDefaultState());
						}
					}
				}

				entityIn.setLocationAndAngles((double) i, (double) j, (double) k, entityIn.rotationYaw, 0.0F);
				entityIn.motionX = entityIn.motionY = entityIn.motionZ = 0.0D;
			}
		}

		public boolean placeInExistingPortal(Entity entityIn, float p_180620_2_) {
			boolean flag = true;
			double d0 = -1.0D;
			int i = MathHelper.floor(entityIn.posX);
			int j = MathHelper.floor(entityIn.posZ);
			boolean flag1 = true;
			BlockPos object = BlockPos.ORIGIN;
			long k = ChunkPos.asLong(i, j);

			if (this.destinationCoordinateCache.containsKey(k)) {
				Teleporter.PortalPosition portalposition = (Teleporter.PortalPosition) this.destinationCoordinateCache.get(k);
				d0 = 0.0D;
				object = portalposition;
				portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
				flag1 = false;
			} else {
				BlockPos blockpos4 = new BlockPos(entityIn);

				for (int l = -128; l <= 128; ++l) {
					BlockPos blockpos1;

					for (int i1 = -128; i1 <= 128; ++i1) {
						for (BlockPos blockpos = blockpos4.add(l, this.worldServerInstance.getActualHeight() - 1 - blockpos4.getY(), i1); blockpos
								.getY() >= 0; blockpos = blockpos1) {
							blockpos1 = blockpos.down();

							if (this.worldServerInstance.getBlockState(blockpos).getBlock() == portal) {
								while (this.worldServerInstance.getBlockState(blockpos1 = blockpos.down()).getBlock() == portal) {
									blockpos = blockpos1;
								}

								double d1 = blockpos.distanceSq(blockpos4);

								if (d0 < 0.0D || d1 < d0) {
									d0 = d1;
									object = blockpos;
								}
							}
						}
					}
				}
			}

			if (d0 >= 0.0D) {
				if (flag1) {
					this.destinationCoordinateCache.put(k, new Teleporter.PortalPosition(object, this.worldServerInstance.getTotalWorldTime()));
				}

				double d4 = (double) ((BlockPos) object).getX() + 0.5D;
				double d5 = (double) ((BlockPos) object).getY() + 0.5D;
				double d6 = (double) ((BlockPos) object).getZ() + 0.5D;
				EnumFacing enumfacing = null;

				if (this.worldServerInstance.getBlockState(((BlockPos) object).west()).getBlock() == portal) {
					enumfacing = EnumFacing.NORTH;
				}

				if (this.worldServerInstance.getBlockState(((BlockPos) object).east()).getBlock() == portal) {
					enumfacing = EnumFacing.SOUTH;
				}

				if (this.worldServerInstance.getBlockState(((BlockPos) object).north()).getBlock() == portal) {
					enumfacing = EnumFacing.EAST;
				}

				if (this.worldServerInstance.getBlockState(((BlockPos) object).south()).getBlock() == portal) {
					enumfacing = EnumFacing.WEST;
				}

				// func_181012_aH = getTeleportDirection
				// EnumFacing enumfacing1 =
				// EnumFacing.getHorizontal(entityIn.func_181012_aH());
				EnumFacing enumfacing1 = entityIn.getTeleportDirection();

				if (enumfacing != null) {
					EnumFacing enumfacing2 = enumfacing.rotateYCCW();
					BlockPos blockpos2 = ((BlockPos) object).offset(enumfacing);
					boolean flag2 = this.func_180265_a(blockpos2);
					boolean flag3 = this.func_180265_a(blockpos2.offset(enumfacing2));

					if (flag3 && flag2) {
						object = ((BlockPos) object).offset(enumfacing2);
						enumfacing = enumfacing.getOpposite();
						enumfacing2 = enumfacing2.getOpposite();
						BlockPos blockpos3 = ((BlockPos) object).offset(enumfacing);
						flag2 = this.func_180265_a(blockpos3);
						flag3 = this.func_180265_a(blockpos3.offset(enumfacing2));
					}

					float f6 = 0.5F;
					float f1 = 0.5F;

					if (!flag3 && flag2) {
						f6 = 1.0F;
					} else if (flag3 && !flag2) {
						f6 = 0.0F;
					} else if (flag3) {
						f1 = 0.0F;
					}

					d4 = (double) ((BlockPos) object).getX() + 0.5D;
					d5 = (double) ((BlockPos) object).getY() + 0.5D;
					d6 = (double) ((BlockPos) object).getZ() + 0.5D;
					d4 += (double) ((float) enumfacing2.getFrontOffsetX() * f6 + (float) enumfacing.getFrontOffsetX() * f1);
					d6 += (double) ((float) enumfacing2.getFrontOffsetZ() * f6 + (float) enumfacing.getFrontOffsetZ() * f1);
					float f2 = 0.0F;
					float f3 = 0.0F;
					float f4 = 0.0F;
					float f5 = 0.0F;

					if (enumfacing1 != null && enumfacing == enumfacing1) {
						f2 = 1.0F;
						f3 = 1.0F;
					} else if (enumfacing1 != null && enumfacing == enumfacing1.getOpposite()) {
						f2 = -1.0F;
						f3 = -1.0F;
					} else if (enumfacing1 != null && enumfacing == enumfacing1.rotateY()) {
						f4 = 1.0F;
						f5 = -1.0F;
					} else {
						f4 = -1.0F;
						f5 = 1.0F;
					}

					double d2 = entityIn.motionX;
					double d3 = entityIn.motionZ;
					entityIn.motionX = d2 * (double) f2 + d3 * (double) f5;
					entityIn.motionZ = d2 * (double) f4 + d3 * (double) f3;
					if (enumfacing1 != null)
						entityIn.rotationYaw = p_180620_2_ - (float) (enumfacing1.getHorizontalIndex() * 90)
								+ (float) (enumfacing.getHorizontalIndex() * 90);
				} else {
					entityIn.motionX = entityIn.motionY = entityIn.motionZ = 0.0D;
				}

				entityIn.setLocationAndAngles(d4, d5, d6, entityIn.rotationYaw, entityIn.rotationPitch);
				return true;
			} else {
				return false;
			}
		}

		private boolean func_180265_a(BlockPos p_180265_1_) {
			return !this.worldServerInstance.isAirBlock(p_180265_1_) || !this.worldServerInstance.isAirBlock(p_180265_1_.up());
		}

		public boolean makePortal(Entity p_85188_1_) {

			byte b0 = 16;
			double d0 = -1.0D;
			int i = MathHelper.floor(p_85188_1_.posX);
			int j = MathHelper.floor(p_85188_1_.posY);
			int k = MathHelper.floor(p_85188_1_.posZ);
			int l = i;
			int i1 = j;
			int j1 = k;
			int k1 = 0;
			int l1 = this.random.nextInt(4);
			int i2;
			double d1;
			int k2;
			double d2;
			int i3;
			int j3;
			int k3;
			int l3;
			int i4;
			int j4;
			int k4;
			int l4;
			int i5;
			double d3;
			double d4;

			for (i2 = i - b0; i2 <= i + b0; ++i2) {
				d1 = (double) i2 + 0.5D - p_85188_1_.posX;

				for (k2 = k - b0; k2 <= k + b0; ++k2) {
					d2 = (double) k2 + 0.5D - p_85188_1_.posZ;
					label271 :

					for (i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3) {
						if (this.worldServerInstance.isAirBlock(new BlockPos(i2, i3, k2))) {
							while (i3 > 0 && this.worldServerInstance.isAirBlock(new BlockPos(i2, i3 - 1, k2))) {
								--i3;
							}

							for (j3 = l1; j3 < l1 + 4; ++j3) {
								k3 = j3 % 2;
								l3 = 1 - k3;

								if (j3 % 4 >= 2) {
									k3 = -k3;
									l3 = -l3;
								}

								for (i4 = 0; i4 < 3; ++i4) {
									for (j4 = 0; j4 < 4; ++j4) {
										for (k4 = -1; k4 < 4; ++k4) {
											l4 = i2 + (j4 - 1) * k3 + i4 * l3;
											i5 = i3 + k4;
											int j5 = k2 + (j4 - 1) * l3 - i4 * k3;
											Block tmp = this.worldServerInstance.getBlockState(new BlockPos(l4, i5, j5)).getBlock();
											if (k4 < 0 && !tmp.getMaterial(tmp.getDefaultState()).isSolid() || k4 >= 0
													&& !this.worldServerInstance.isAirBlock(new BlockPos(l4, i5, j5))) {
												continue label271;
											}
										}
									}
								}

								d3 = (double) i3 + 0.5D - p_85188_1_.posY;
								d4 = d1 * d1 + d3 * d3 + d2 * d2;

								if (d0 < 0.0D || d4 < d0) {
									d0 = d4;
									l = i2;
									i1 = i3;
									j1 = k2;
									k1 = j3 % 4;
								}
							}
						}
					}
				}
			}

			if (d0 < 0.0D) {
				for (i2 = i - b0; i2 <= i + b0; ++i2) {
					d1 = (double) i2 + 0.5D - p_85188_1_.posX;

					for (k2 = k - b0; k2 <= k + b0; ++k2) {
						d2 = (double) k2 + 0.5D - p_85188_1_.posZ;
						label219 :

						for (i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3) {
							if (this.worldServerInstance.isAirBlock(new BlockPos(i2, i3, k2))) {
								while (i3 > 0 && this.worldServerInstance.isAirBlock(new BlockPos(i2, i3 - 1, k2))) {
									--i3;
								}

								for (j3 = l1; j3 < l1 + 2; ++j3) {
									k3 = j3 % 2;
									l3 = 1 - k3;

									for (i4 = 0; i4 < 4; ++i4) {
										for (j4 = -1; j4 < 4; ++j4) {
											k4 = i2 + (i4 - 1) * k3;
											l4 = i3 + j4;
											i5 = k2 + (i4 - 1) * l3;
											Block tmpb = this.worldServerInstance.getBlockState(new BlockPos(k4, l4, i5)).getBlock();
											if (j4 < 0 && !tmpb.getMaterial(tmpb.getDefaultState()).isSolid() || j4 >= 0
													&& !this.worldServerInstance.isAirBlock(new BlockPos(k4, l4, i5))) {
												continue label219;
											}
										}
									}

									d3 = (double) i3 + 0.5D - p_85188_1_.posY;
									d4 = d1 * d1 + d3 * d3 + d2 * d2;

									if (d0 < 0.0D || d4 < d0) {
										d0 = d4;
										l = i2;
										i1 = i3;
										j1 = k2;
										k1 = j3 % 2;
									}
								}
							}
						}
					}
				}
			}

			int k5 = l;
			int j2 = i1;
			k2 = j1;
			int l5 = k1 % 2;
			int l2 = 1 - l5;

			if (k1 % 4 >= 2) {
				l5 = -l5;
				l2 = -l2;
			}

			if (d0 < 0.0D) {
				i1 = MathHelper.clamp(i1, 70, this.worldServerInstance.getActualHeight() - 10);
				j2 = i1;

				for (i3 = -1; i3 <= 1; ++i3) {
					for (j3 = 1; j3 < 3; ++j3) {
						for (k3 = -1; k3 < 3; ++k3) {
							l3 = k5 + (j3 - 1) * l5 + i3 * l2;
							i4 = j2 + k3;
							j4 = k2 + (j3 - 1) * l2 - i3 * l5;
							boolean flag = k3 < 0;
							this.worldServerInstance.setBlockState(new BlockPos(l3, i4, j4),
									flag ? ModBlocks.blockEden.getDefaultState() : Blocks.AIR.getDefaultState());
						}
					}
				}
			}

			IBlockState iblockstate = portal.getDefaultState().withProperty(BlockPortal.AXIS, l5 == 0 ? EnumFacing.Axis.Z : EnumFacing.Axis.X);

			for (j3 = 0; j3 < 4; ++j3) {
				for (k3 = 0; k3 < 4; ++k3) {
					for (l3 = -1; l3 < 4; ++l3) {
						i4 = k5 + (k3 - 1) * l5;
						j4 = j2 + l3;
						k4 = k2 + (k3 - 1) * l2;
						boolean flag1 = k3 == 0 || k3 == 3 || l3 == -1 || l3 == 3;
						this.worldServerInstance.setBlockState(new BlockPos(i4, j4, k4), flag1 ? ModBlocks.blockEden.getDefaultState() : iblockstate,
								2);
					}
				}

				for (k3 = 0; k3 < 4; ++k3) {
					for (l3 = -1; l3 < 4; ++l3) {
						i4 = k5 + (k3 - 1) * l5;
						j4 = j2 + l3;
						k4 = k2 + (k3 - 1) * l2;
						this.worldServerInstance.notifyNeighborsOfStateChange(new BlockPos(i4, j4, k4),
								this.worldServerInstance.getBlockState(new BlockPos(i4, j4, k4)).getBlock(), true);
					}
				}
			}

			return true;
		}

		/**
		 * called periodically to remove out-of-date portal locations from the
		 * cache list. Argument par1 is a WorldServer.getTotalWorldTime() value.
		 */
		public void removeStalePortalLocations(long worldTime) {
			if (worldTime % 100L == 0L) {
				long i = worldTime - 300L;
				it.unimi.dsi.fastutil.objects.ObjectIterator<Teleporter.PortalPosition> objectiterator = this.destinationCoordinateCache.values()
						.iterator();

				while (objectiterator.hasNext()) {
					Teleporter.PortalPosition teleporter$portalposition = (Teleporter.PortalPosition) objectiterator.next();

					if (teleporter$portalposition == null || teleporter$portalposition.lastUpdateTime < i) {
						objectiterator.remove();
					}
				}
			}
		}

		public class PortalPosition extends BlockPos {
			/** The worldtime at which this PortalPosition was last verified */
			public long lastUpdateTime;
			private static final String __OBFID = "CL_00000154";

			public PortalPosition(BlockPos pos, long p_i45747_3_) {
				super(pos.getX(), pos.getY(), pos.getZ());
				this.lastUpdateTime = p_i45747_3_;
			}
		}

	}

	// /FIRE BLOCK

	static class BlockFireMod extends Block {

		protected BlockFireMod() {
			super(Material.FIRE);
		}

		public void onBlockAdded(World par1World, int par2, int par3, int par4) {
			/* TutorialPortal.tryToCreatePortal(par1World, par2, par3, par4); */
		}

	}// fire block end

	// /PORTAL BLOCK

	public static class BlockTutorialPortal extends Block {

		public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis> create("axis", EnumFacing.Axis.class,
				new EnumFacing.Axis[]{EnumFacing.Axis.X, EnumFacing.Axis.Z});
		protected static final AxisAlignedBB field_185683_b = new AxisAlignedBB(0.0D, 0.0D, 0.375D, 1.0D, 1.0D, 0.625D);
		protected static final AxisAlignedBB field_185684_c = new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.0D, 1.0D);
		protected static final AxisAlignedBB field_185685_d = new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D);

		public BlockTutorialPortal() {
			super(Material.PORTAL);
			this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Z));
			this.setTickRandomly(true);
			this.setHardness(-1.0F);
			this.setLightLevel(0.75F);
		}

		@javax.annotation.Nullable
		public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
			return NULL_AABB;
		}

		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			switch ((EnumFacing.Axis) state.getValue(AXIS)) {
				case X :
					return field_185683_b;
				case Y :
				default :
					return field_185685_d;
				case Z :
					return field_185684_c;
			}
		}

		public static int getMetaForAxis(EnumFacing.Axis axis) {
			return axis == EnumFacing.Axis.X ? 1 : (axis == EnumFacing.Axis.Z ? 2 : 0);
		}

		public boolean isFullCube(IBlockState state) {
			return false;
		}

		public int getMetaFromState(IBlockState state) {
			return getMetaForAxis((EnumFacing.Axis) state.getValue(AXIS));
		}

		public IBlockState getStateFromMeta(int meta) {
			return this.getDefaultState().withProperty(AXIS, (meta & 3) == 2 ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
		}

		/**
		 * If this block doesn't render as an ordinary block it will return
		 * False (examples: signs, buttons, stairs, etc)
		 */
		/**
		 * Checks to see if this location is valid to create a portal and will
		 * return True if it does. Args: world, x, y, z
		 */
		public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4) {
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
						IBlockState iblockstate = this.getDefaultState().withProperty(BlockPortal.AXIS,
								b0 == 0 ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
						par1World.setBlockState(new BlockPos(par2 + b0 * l, par3 + i1, par4 + b1 * l), iblockstate, 3);
					}
				}
				return true;
			}
		}

		/**
		 * Lets the block know when one of its neighbor changes. Doesn't know
		 * which neighbor changed (coordinates passed are their own) Args: x, y,
		 * z, neighbor blockID
		 */
		@Override
		public void neighborChanged(IBlockState state, World par1World, BlockPos pos, Block neighborBlock, BlockPos fromPos) {

			int par2 = pos.getX();
			int par3 = pos.getY();
			int par4 = pos.getZ();

			byte b0 = 0;
			byte b1 = 1;
			if (getBlock(par1World, par2 - 1, par3, par4) == this || getBlock(par1World, par2 + 1, par3, par4) == this) {
				b0 = 1;
				b1 = 0;
			}
			int i1;
			for (i1 = par3; getBlock(par1World, par2, i1 - 1, par4) == this; --i1) {
				;
			}
			if (getBlock(par1World, par2, i1 - 1, par4) != ModBlocks.blockEden) {
				par1World.setBlockToAir(new BlockPos(par2, par3, par4));
			} else {
				int j1;
				for (j1 = 1; j1 < 4 && getBlock(par1World, par2, i1 + j1, par4) == this; ++j1) {
					;
				}
				if (j1 == 3 && getBlock(par1World, par2, i1 + j1, par4) == ModBlocks.blockEden) {
					boolean flag = getBlock(par1World, par2 - 1, par3, par4) == this || getBlock(par1World, par2 + 1, par3, par4) == this;
					boolean flag1 = getBlock(par1World, par2, par3, par4 - 1) == this || getBlock(par1World, par2, par3, par4 + 1) == this;
					if (flag && flag1) {
						par1World.setBlockToAir(new BlockPos(par2, par3, par4));
					} else {
						if ((getBlock(par1World, par2 + b0, par3, par4 + b1) != ModBlocks.blockEden || getBlock(par1World, par2 - b0, par3, par4 - b1) != this)
								&& (getBlock(par1World, par2 - b0, par3, par4 - b1) != ModBlocks.blockEden || getBlock(par1World, par2 + b0, par3,
										par4 + b1) != this)) {
							par1World.setBlockToAir(new BlockPos(par2, par3, par4));
						}
					}
				} else {
					par1World.setBlockToAir(new BlockPos(par2, par3, par4));
				}
			}
		}

		@SideOnly(Side.CLIENT)
		@Override
		public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
			EnumFacing.Axis axis = null;
			IBlockState iblockstate = worldIn.getBlockState(pos);

			if (worldIn.getBlockState(pos).getBlock() == this) {
				axis = (EnumFacing.Axis) iblockstate.getValue(AXIS);

				if (axis == null) {
					return false;
				}

				if (axis == EnumFacing.Axis.Z && side != EnumFacing.EAST && side != EnumFacing.WEST) {
					return false;
				}

				if (axis == EnumFacing.Axis.X && side != EnumFacing.SOUTH && side != EnumFacing.NORTH) {
					return false;
				}
			}

			boolean flag = worldIn.getBlockState(pos.west()).getBlock() == this && worldIn.getBlockState(pos.west(2)).getBlock() != this;
			boolean flag1 = worldIn.getBlockState(pos.east()).getBlock() == this && worldIn.getBlockState(pos.east(2)).getBlock() != this;
			boolean flag2 = worldIn.getBlockState(pos.north()).getBlock() == this && worldIn.getBlockState(pos.north(2)).getBlock() != this;
			boolean flag3 = worldIn.getBlockState(pos.south()).getBlock() == this && worldIn.getBlockState(pos.south(2)).getBlock() != this;
			boolean flag4 = flag || flag1 || axis == EnumFacing.Axis.X;
			boolean flag5 = flag2 || flag3 || axis == EnumFacing.Axis.Z;
			return flag4 && side == EnumFacing.WEST ? true : (flag4 && side == EnumFacing.EAST ? true : (flag5 && side == EnumFacing.NORTH
					? true
					: flag5 && side == EnumFacing.SOUTH));
		}

		@SideOnly(Side.CLIENT)
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.TRANSLUCENT;
		}

		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{AXIS});
		}

		public int quantityDropped(Random par1Random) {
			return 0;
		}

		@Override
		public void onEntityCollidedWithBlock(World par1World, BlockPos pos, IBlockState state, Entity par5Entity) {

			int par2 = pos.getX();
			int par3 = pos.getY();
			int par4 = pos.getZ();

			if (par5Entity.getRidingEntity() == null && !par5Entity.isBeingRidden() && par5Entity instanceof EntityPlayerMP) {

				EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;
				if (thePlayer.timeUntilPortal > 0) {
					thePlayer.timeUntilPortal = 10;
				} else if (thePlayer.dimension != DIMID) {
					thePlayer.timeUntilPortal = 10;
					thePlayer.mcServer.getPlayerList().transferPlayerToDimension(thePlayer, DIMID,
							new TeleporterDimensionMod(thePlayer.mcServer.getWorld(Config.dimensionId)));
				} else {
					thePlayer.timeUntilPortal = 10;
					thePlayer.mcServer.getPlayerList().transferPlayerToDimension(thePlayer, 0,
							new TeleporterDimensionMod(thePlayer.mcServer.getWorld(0)));
				}
			}
		}

		@SideOnly(Side.CLIENT)
		/**
		 * A randomly called display update to be able to add particles or other items for display
		 */
		@Override
		public void randomDisplayTick(IBlockState worldIn, World par1World, BlockPos pos, Random par5Random) {

			int par2 = pos.getX();
			int par3 = pos.getY();
			int par4 = pos.getZ();

			if (par5Random.nextInt(100) == 0) {
				par1World.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D,
						(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
								("block.portal.ambient"))), SoundCategory.BLOCKS, 0.5F, par5Random.nextFloat() * 0.4F + 0.8F, false);
			}
			for (int l = 0; l < 4; ++l) {
				double d0 = (double) ((float) par2 + par5Random.nextFloat());
				double d1 = (double) ((float) par3 + par5Random.nextFloat());
				double d2 = (double) ((float) par4 + par5Random.nextFloat());
				double d3 = 0.0D;
				double d4 = 0.0D;
				double d5 = 0.0D;
				int i1 = par5Random.nextInt(2) * 2 - 1;
				d3 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				d4 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				d5 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				if (getBlock(par1World, par2 - 1, par3, par4) != this && getBlock(par1World, par2 + 1, par3, par4) != this) {
					d0 = (double) par2 + 0.5D + 0.25D * (double) i1;
					d3 = (double) (par5Random.nextFloat() * 2.0F * (float) i1);
				} else {
					d2 = (double) par4 + 0.5D + 0.25D * (double) i1;
					d5 = (double) (par5Random.nextFloat() * 2.0F * (float) i1);
				}
				par1World.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, d0, d1, d2, d3, d4, d5);
			}
		}

		@SideOnly(Side.CLIENT)
		/**
		 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
		 */
		public int idPicked(World par1World, int par2, int par3, int par4) {
			return 0;
		}
	}

	// portal block

	public static class ChunkProviderModded implements IChunkGenerator {
		protected static final IBlockState field_185982_a = Blocks.DROPPER.getDefaultState();
		private final Random rand;
		private NoiseGeneratorOctaves field_185991_j;
		private NoiseGeneratorOctaves field_185992_k;
		private NoiseGeneratorOctaves field_185993_l;
		private NoiseGeneratorPerlin field_185994_m;
		public NoiseGeneratorOctaves field_185983_b;
		public NoiseGeneratorOctaves field_185984_c;
		public NoiseGeneratorOctaves field_185985_d;
		private final World world;
		private final boolean mapFeaturesEnabled;
		private final WorldType terrainType;
		private final double[] heightMap;
		private final float[] field_185999_r;
		private ChunkGeneratorSettings settings;
		private IBlockState oceanBlock = Blocks.DEADBUSH.getDefaultState();
		private double[] field_186002_u = new double[256];
		private MapGenBase caveGenerator = new MapGenCaves();
		private MapGenBase ravineGenerator = new MapGenRavine();
		private Biome[] biomesForGeneration;
		double[] field_185986_e;
		double[] field_185987_f;
		double[] field_185988_g;
		double[] field_185989_h;
		protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
		protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
		protected static final IBlockState GRAVEL = Blocks.DROPPER.getDefaultState();

		public ChunkProviderModded(World worldIn, long seed) {
			{
				caveGenerator = net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(caveGenerator,
						net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE);
				ravineGenerator = net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(ravineGenerator,
						net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.RAVINE);
			}
			this.world = worldIn;
			this.mapFeaturesEnabled = false;
			this.terrainType = worldIn.getWorldInfo().getTerrainType();
			this.rand = new Random(seed);
			this.field_185991_j = new NoiseGeneratorOctaves(this.rand, 16);
			this.field_185992_k = new NoiseGeneratorOctaves(this.rand, 16);
			this.field_185993_l = new NoiseGeneratorOctaves(this.rand, 8);
			this.field_185994_m = new NoiseGeneratorPerlin(this.rand, 4);
			this.field_185983_b = new NoiseGeneratorOctaves(this.rand, 10);
			this.field_185984_c = new NoiseGeneratorOctaves(this.rand, 16);
			this.field_185985_d = new NoiseGeneratorOctaves(this.rand, 8);
			this.heightMap = new double[825];
			this.field_185999_r = new float[25];

			for (int i = -2; i <= 2; ++i) {
				for (int j = -2; j <= 2; ++j) {
					float f = 10.0F / MathHelper.sqrt((float) (i * i + j * j) + 0.2F);
					this.field_185999_r[i + 2 + (j + 2) * 5] = f;
				}
			}

			this.settings = ChunkGeneratorSettings.Factory.jsonToFactory("").build();

			net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextOverworld ctx = new net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextOverworld(
					field_185991_j, field_185992_k, field_185993_l, field_185994_m, field_185983_b, field_185984_c, field_185985_d);
			ctx = net.minecraftforge.event.terraingen.TerrainGen.getModdedNoiseGenerators(worldIn, this.rand, ctx);
			this.field_185991_j = ctx.getLPerlin1();
			this.field_185992_k = ctx.getLPerlin2();
			this.field_185993_l = ctx.getPerlin();
			this.field_185994_m = ctx.getHeight();
			this.field_185983_b = ctx.getScale();
			this.field_185984_c = ctx.getDepth();
			this.field_185985_d = ctx.getForest();
		}

		@Override
		public Chunk generateChunk(int x, int z) {
			this.rand.setSeed((long) x * 341873128712L + (long) z * 132897987541L + 1);
			ChunkPrimer chunkprimer = new ChunkPrimer();
			this.setBlocksInChunk(x, z, chunkprimer);
			this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 16, z * 16, 16, 16);
			this.replaceBiomeBlocks(x, z, chunkprimer, this.biomesForGeneration);

			if (this.settings.useCaves) {
				this.caveGenerator.generate(this.world, x, z, chunkprimer);
			}

			if (this.settings.useRavines) {
				this.ravineGenerator.generate(this.world, x, z, chunkprimer);
			}

			Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
			byte[] abyte = chunk.getBiomeArray();

			for (int i = 0; i < abyte.length; ++i) {
				abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
			}

			chunk.generateSkylightMap();
			return chunk;
		}

		@Override
		public void populate(int x, int z) {
			BlockFalling.fallInstantly = true;
			int i = x * 16;
			int j = z * 16;
			BlockPos blockpos = new BlockPos(i, 0, j);
			Biome Biome = this.world.getBiome(blockpos.add(16, 0, 16));
			this.rand.setSeed(this.world.getSeed());
			long k = this.rand.nextLong() / 2L * 2L + 1L;
			long l = this.rand.nextLong() / 2L * 2L + 1L;
			this.rand.setSeed((long) x * k + (long) z * l ^ this.world.getSeed());
			boolean flag = false;

			net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, x, z, flag);

			if (Biome != Biomes.DESERT && Biome != Biomes.DESERT_HILLS && this.settings.useWaterLakes && !flag
					&& this.rand.nextInt(this.settings.waterLakeChance) == 0)
				if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag,
						net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE)) {
					int i1 = this.rand.nextInt(16) + 8;
					int j1 = this.rand.nextInt(256);
					int k1 = this.rand.nextInt(16) + 8;
					(new WorldGenLakes(Blocks.DEADBUSH)).generate(this.world, this.rand, blockpos.add(i1, j1, k1));
				}

			if (!flag && this.rand.nextInt(this.settings.lavaLakeChance / 10) == 0 && this.settings.useLavaLakes)
				if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag,
						net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA)) {
					int i2 = this.rand.nextInt(16) + 8;
					int l2 = this.rand.nextInt(this.rand.nextInt(248) + 8);
					int k3 = this.rand.nextInt(16) + 8;

					if (l2 < this.world.getSeaLevel() || this.rand.nextInt(this.settings.lavaLakeChance / 8) == 0) {
						(new WorldGenLakes(Blocks.DEADBUSH)).generate(this.world, this.rand, blockpos.add(i2, l2, k3));
					}
				}

			if (this.settings.useDungeons)
				if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag,
						net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON)) {
					for (int j2 = 0; j2 < this.settings.dungeonChance; ++j2) {
						int i3 = this.rand.nextInt(16) + 8;
						int l3 = this.rand.nextInt(256);
						int l1 = this.rand.nextInt(16) + 8;
						(new WorldGenDungeons()).generate(this.world, this.rand, blockpos.add(i3, l3, l1));
					}
				}

			Biome.decorate(this.world, this.rand, new BlockPos(i, 0, j));
			if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag,
					net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS))
				WorldEntitySpawner.performWorldGenSpawning(this.world, Biome, i + 8, j + 8, 16, 16, this.rand);
			blockpos = blockpos.add(8, 0, 8);

			if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag,
					net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE)) {
				for (int k2 = 0; k2 < 16; ++k2) {
					for (int j3 = 0; j3 < 16; ++j3) {
						BlockPos blockpos1 = this.world.getPrecipitationHeight(blockpos.add(k2, 0, j3));
						BlockPos blockpos2 = blockpos1.down();

						if (this.world.canBlockFreezeWater(blockpos2)) {
							this.world.setBlockState(blockpos2, Blocks.ICE.getDefaultState(), 2);
						}

						if (this.world.canSnowAt(blockpos1, true)) {
							this.world.setBlockState(blockpos1, Blocks.SNOW_LAYER.getDefaultState(), 2);
						}
					}
				}
			}

			int var4 = x * 16;
			int var5 = z * 16;

			net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(false, this, this.world, this.rand, x, z, flag);

			BlockFalling.fallInstantly = false;
		}

		@Override
		public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
			Biome Biome = this.world.getBiome(pos);
			return Biome.getSpawnableList(creatureType);
		}

		@Override
		public void recreateStructures(Chunk chunkIn, int x, int z) {
		}

		@Override
		public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
			return false;
		}

		@Override
		public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
			return null;
		}

		@Override
		public boolean generateStructures(Chunk chunkIn, int x, int z) {
			return false;
		}

		private void setBlocksInChunk(int x, int z, ChunkPrimer primer) {
			this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
			this.generateHeightmap(x * 4, 0, z * 4);

			for (int i = 0; i < 4; ++i) {
				int j = i * 5;
				int k = (i + 1) * 5;

				for (int l = 0; l < 4; ++l) {
					int i1 = (j + l) * 33;
					int j1 = (j + l + 1) * 33;
					int k1 = (k + l) * 33;
					int l1 = (k + l + 1) * 33;

					for (int i2 = 0; i2 < 32; ++i2) {
						double d0 = 0.125D;
						double d1 = this.heightMap[i1 + i2];
						double d2 = this.heightMap[j1 + i2];
						double d3 = this.heightMap[k1 + i2];
						double d4 = this.heightMap[l1 + i2];
						double d5 = (this.heightMap[i1 + i2 + 1] - d1) * d0;
						double d6 = (this.heightMap[j1 + i2 + 1] - d2) * d0;
						double d7 = (this.heightMap[k1 + i2 + 1] - d3) * d0;
						double d8 = (this.heightMap[l1 + i2 + 1] - d4) * d0;

						for (int j2 = 0; j2 < 8; ++j2) {
							double d9 = 0.25D;
							double d10 = d1;
							double d11 = d2;
							double d12 = (d3 - d1) * d9;
							double d13 = (d4 - d2) * d9;

							for (int k2 = 0; k2 < 4; ++k2) {
								double d14 = 0.25D;
								double d16 = (d11 - d10) * d14;
								double lvt_45_1_ = d10 - d16;

								for (int l2 = 0; l2 < 4; ++l2) {
									if ((lvt_45_1_ += d16) > 0.0D) {
										primer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, field_185982_a);
									} else if (i2 * 8 + j2 < this.settings.seaLevel) {
										primer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, this.oceanBlock);
									}
								}

								d10 += d12;
								d11 += d13;
							}

							d1 += d5;
							d2 += d6;
							d3 += d7;
							d4 += d8;
						}
					}
				}
			}
		}

		private void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn) {
			if (!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.world))
				return;
			double d0 = 0.03125D;
			this.field_186002_u = this.field_185994_m.getRegion(this.field_186002_u, (double) (x * 16), (double) (z * 16), 16, 16, d0 * 2.0D,
					d0 * 2.0D, 1.0D);

			for (int i = 0; i < 16; ++i) {
				for (int j = 0; j < 16; ++j) {
					Biome Biome = biomesIn[j + i * 16];
					generateBiomeTerrain(this.world, this.rand, primer, x * 16 + i, z * 16 + j, this.field_186002_u[j + i * 16], Biome);
				}
			}
		}

		private void generateBiomeTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal, Biome Biome) {
			int i = worldIn.getSeaLevel();
			IBlockState iblockstate = Biome.topBlock;
			IBlockState iblockstate1 = Biome.fillerBlock;
			int j = -1;
			int k = (int) (noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
			int l = x & 15;
			int i1 = z & 15;
			BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

			for (int j1 = 255; j1 >= 0; --j1) {
				if (j1 <= rand.nextInt(5)) {
					chunkPrimerIn.setBlockState(i1, j1, l, BEDROCK);
				} else {
					IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);

					if (iblockstate2.getMaterial() == Material.AIR) {
						j = -1;
					} else if (iblockstate2.getBlock() == Blocks.DROPPER) {
						if (j == -1) {
							if (k <= 0) {
								iblockstate = AIR;
								iblockstate1 = Blocks.DROPPER.getDefaultState();
							} else if (j1 >= i - 4 && j1 <= i + 1) {
								iblockstate = Biome.topBlock;
								iblockstate1 = Biome.fillerBlock;
							}

							if (j1 < i && (iblockstate == null || iblockstate.getMaterial() == Material.AIR)) {
								iblockstate1 = Blocks.DEADBUSH.getDefaultState();
							}

							j = k;

							if (j1 >= i - 1) {
								chunkPrimerIn.setBlockState(i1, j1, l, iblockstate);
							} else if (j1 < i - 7 - k) {
								iblockstate = AIR;
								iblockstate1 = Blocks.DROPPER.getDefaultState();
								chunkPrimerIn.setBlockState(i1, j1, l, GRAVEL);
							} else {
								chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
							}
						} else if (j > 0) {
							--j;
							chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);

							if (j == 0 && iblockstate1.getBlock() == Blocks.SAND) {
								j = rand.nextInt(4) + Math.max(0, j1 - 63);
								iblockstate1 = Blocks.DROPPER.getDefaultState();
							}
						}
					}
				}
			}
		}

		private void generateHeightmap(int p_185978_1_, int p_185978_2_, int p_185978_3_) {
			this.field_185989_h = this.field_185984_c.generateNoiseOctaves(this.field_185989_h, p_185978_1_, p_185978_3_, 5, 5,
					(double) this.settings.depthNoiseScaleX, (double) this.settings.depthNoiseScaleZ, (double) this.settings.depthNoiseScaleExponent);
			float f = this.settings.coordinateScale;
			float f1 = this.settings.heightScale;
			this.field_185986_e = this.field_185993_l.generateNoiseOctaves(this.field_185986_e, p_185978_1_, p_185978_2_, p_185978_3_, 5, 33, 5,
					(double) (f / this.settings.mainNoiseScaleX), (double) (f1 / this.settings.mainNoiseScaleY),
					(double) (f / this.settings.mainNoiseScaleZ));
			this.field_185987_f = this.field_185991_j.generateNoiseOctaves(this.field_185987_f, p_185978_1_, p_185978_2_, p_185978_3_, 5, 33, 5,
					(double) f, (double) f1, (double) f);
			this.field_185988_g = this.field_185992_k.generateNoiseOctaves(this.field_185988_g, p_185978_1_, p_185978_2_, p_185978_3_, 5, 33, 5,
					(double) f, (double) f1, (double) f);
			p_185978_3_ = 0;
			p_185978_1_ = 0;
			int i = 0;
			int j = 0;

			for (int k = 0; k < 5; ++k) {
				for (int l = 0; l < 5; ++l) {
					float f2 = 0.0F;
					float f3 = 0.0F;
					float f4 = 0.0F;
					int i1 = 2;
					Biome Biome = this.biomesForGeneration[k + 2 + (l + 2) * 10];

					for (int j1 = -i1; j1 <= i1; ++j1) {
						for (int k1 = -i1; k1 <= i1; ++k1) {
							Biome Biome1 = this.biomesForGeneration[k + j1 + 2 + (l + k1 + 2) * 10];
							float f5 = this.settings.biomeDepthOffSet + Biome1.getBaseHeight() * this.settings.biomeDepthWeight;
							float f6 = this.settings.biomeScaleOffset + Biome1.getHeightVariation() * this.settings.biomeScaleWeight;

							if (this.terrainType == WorldType.AMPLIFIED && f5 > 0.0F) {
								f5 = 1.0F + f5 * 2.0F;
								f6 = 1.0F + f6 * 4.0F;
							}

							float f7 = this.field_185999_r[j1 + 2 + (k1 + 2) * 5] / (f5 + 2.0F);

							if (Biome1.getBaseHeight() > Biome.getBaseHeight()) {
								f7 /= 2.0F;
							}

							f2 += f6 * f7;
							f3 += f5 * f7;
							f4 += f7;
						}
					}

					f2 = f2 / f4;
					f3 = f3 / f4;
					f2 = f2 * 0.9F + 0.1F;
					f3 = (f3 * 4.0F - 1.0F) / 8.0F;
					double d7 = this.field_185989_h[j] / 8000.0D;

					if (d7 < 0.0D) {
						d7 = -d7 * 0.3D;
					}

					d7 = d7 * 3.0D - 2.0D;

					if (d7 < 0.0D) {
						d7 = d7 / 2.0D;

						if (d7 < -1.0D) {
							d7 = -1.0D;
						}

						d7 = d7 / 1.4D;
						d7 = d7 / 2.0D;
					} else {
						if (d7 > 1.0D) {
							d7 = 1.0D;
						}

						d7 = d7 / 8.0D;
					}

					++j;
					double d8 = (double) f3;
					double d9 = (double) f2;
					d8 = d8 + d7 * 0.2D;
					d8 = d8 * (double) this.settings.baseSize / 8.0D;
					double d0 = (double) this.settings.baseSize + d8 * 4.0D;

					for (int l1 = 0; l1 < 33; ++l1) {
						double d1 = ((double) l1 - d0) * (double) this.settings.stretchY * 128.0D / 256.0D / d9;

						if (d1 < 0.0D) {
							d1 *= 4.0D;
						}

						double d2 = this.field_185987_f[i] / (double) this.settings.lowerLimitScale;
						double d3 = this.field_185988_g[i] / (double) this.settings.upperLimitScale;
						double d4 = (this.field_185986_e[i] / 10.0D + 1.0D) / 2.0D;
						double d5 = MathHelper.clampedLerp(d2, d3, d4) - d1;

						if (l1 > 29) {
							double d6 = (double) ((float) (l1 - 29) / 3.0F);
							d5 = d5 * (1.0D - d6) + -10.0D * d6;
						}

						this.heightMap[i] = d5;
						++i;
					}
				}
			}
		}

	}

	public static class BiomeProviderCustom extends BiomeProvider {

		private GenLayer genBiomes;
		/** A GenLayer containing the indices into Biome.biomeList[] */
		private GenLayer biomeIndexLayer;
		/** The BiomeCache object for this world. */
		private BiomeCache biomeCache;
		/** A list of biomes that the player can spawn in. */
		private List<Biome> biomesToSpawnIn;

		public BiomeProviderCustom() {
			this.biomeCache = new BiomeCache(this);
			this.biomesToSpawnIn = new ArrayList();
			this.biomesToSpawnIn.addAll(allowedBiomes);
		}

		public BiomeProviderCustom(long seed, WorldType worldType) {
			this();
			GenLayer[] agenlayer = GenLayerFix.makeTheWorld(seed, worldType);
			agenlayer = getModdedBiomeGenerators(worldType, seed, agenlayer);
			this.genBiomes = agenlayer[0];
			this.biomeIndexLayer = agenlayer[1];

		}

		public BiomeProviderCustom(World world) {
			this(world.getSeed(), world.getWorldInfo().getTerrainType());

		}

		/**
		 * Gets the list of valid biomes for the player to spawn in.
		 */
		@Override
		public List<Biome> getBiomesToSpawnIn() {
			return this.biomesToSpawnIn;
		}

		/**
		 * Returns the Biome related to the x, z position on the world.
		 */

		public Biome getBiomeGenerator(BlockPos pos) {
			return this.getBiomeGenerator(pos, (Biome) null);
		}

		public Biome getBiomeGenerator(BlockPos pos, Biome biomeGenBaseIn) {
			return this.biomeCache.getBiome(pos.getX(), pos.getZ(), biomeGenBaseIn);
		}

		/**
		 * Return an adjusted version of a given temperature based on the y
		 * height
		 */
		@Override
		@SideOnly(Side.CLIENT)
		public float getTemperatureAtHeight(float par1, int par2) {
			return par1;
		}

		/**
		 * Returns an array of biomes for the location input.
		 */
		@Override
		public Biome[] getBiomesForGeneration(Biome[] par1ArrayOfBiome, int par2, int par3, int par4, int par5) {
			IntCache.resetIntCache();

			if (par1ArrayOfBiome == null || par1ArrayOfBiome.length < par4 * par5) {
				par1ArrayOfBiome = new Biome[par4 * par5];
			}

			int[] aint = this.genBiomes.getInts(par2, par3, par4, par5);

			try {
				for (int i = 0; i < par4 * par5; ++i) {
					par1ArrayOfBiome[i] = Biome.getBiome(aint[i]);
				}

				return par1ArrayOfBiome;
			} catch (Throwable throwable) {
				CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
				CrashReportCategory crashreportcategory = crashreport.makeCategory("RawBiomeBlock");
				crashreportcategory.addCrashSection("biomes[] size", Integer.valueOf(par1ArrayOfBiome.length));
				crashreportcategory.addCrashSection("x", Integer.valueOf(par2));
				crashreportcategory.addCrashSection("z", Integer.valueOf(par3));
				crashreportcategory.addCrashSection("w", Integer.valueOf(par4));
				crashreportcategory.addCrashSection("h", Integer.valueOf(par5));
				throw new ReportedException(crashreport);
			}
		}

		/**
		 * Returns biomes to use for the blocks and loads the other data like
		 * temperature and humidity onto the WorldChunkManager Args:
		 * oldBiomeList, x, z, width, depth
		 */
		@Override
		public Biome[] getBiomes(Biome[] oldBiomeList, int x, int z, int width, int depth) {
			return this.getBiomes(oldBiomeList, x, z, width, depth, true);
		}

		/**
		 * Return a list of biomes for the specified blocks. Args: listToReuse,
		 * x, y, width, length, cacheFlag (if false, don't check biomeCache to
		 * avoid infinite loop in BiomeCacheBlock)
		 */
		@Override
		public Biome[] getBiomes(Biome[] listToReuse, int x, int y, int width, int length, boolean cacheFlag) {
			IntCache.resetIntCache();

			if (listToReuse == null || listToReuse.length < width * length) {
				listToReuse = new Biome[width * length];
			}

			if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (y & 15) == 0) {
				Biome[] aBiome1 = this.biomeCache.getCachedBiomes(x, y);
				System.arraycopy(aBiome1, 0, listToReuse, 0, width * length);
				return listToReuse;
			} else {
				int[] aint = this.biomeIndexLayer.getInts(x, y, width, length);

				for (int i = 0; i < width * length; ++i) {
					listToReuse[i] = Biome.getBiome(aint[i]);
				}
				return listToReuse;
			}
		}

		/**
		 * checks given Chunk's Biomes against List of allowed ones
		 */
		@Override
		public boolean areBiomesViable(int x, int y, int z, List par4List) {
			IntCache.resetIntCache();
			int l = x - z >> 2;
			int i1 = y - z >> 2;
			int j1 = x + z >> 2;
			int k1 = y + z >> 2;
			int l1 = j1 - l + 1;
			int i2 = k1 - i1 + 1;
			int[] aint = this.genBiomes.getInts(l, i1, l1, i2);

			try {
				for (int j2 = 0; j2 < l1 * i2; ++j2) {
					Biome biome = Biome.getBiome(aint[j2]);

					if (!par4List.contains(biome)) {
						return false;
					}
				}

				return true;
			} catch (Throwable throwable) {
				CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
				CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
				crashreportcategory.addCrashSection("Layer", this.genBiomes.toString());
				crashreportcategory.addCrashSection("x", Integer.valueOf(x));
				crashreportcategory.addCrashSection("z", Integer.valueOf(y));
				crashreportcategory.addCrashSection("radius", Integer.valueOf(z));
				crashreportcategory.addCrashSection("allowed", par4List);
				throw new ReportedException(crashreport);
			}
		}

		/**
		 * Finds a valid position within a range, that is in one of the listed
		 * biomes. Searches {par1,par2} +-par3 blocks. Strongly favors positive
		 * y positions.
		 */
		@Override
		public BlockPos findBiomePosition(int x, int z, int range, List biomes, Random random) {
			IntCache.resetIntCache();
			int l = x - range >> 2;
			int i1 = z - range >> 2;
			int j1 = x + range >> 2;
			int k1 = z + range >> 2;
			int l1 = j1 - l + 1;
			int i2 = k1 - i1 + 1;
			int[] aint = this.genBiomes.getInts(l, i1, l1, i2);
			BlockPos blockpos = null;
			int j2 = 0;

			for (int k2 = 0; k2 < l1 * i2; ++k2) {
				int l2 = l + k2 % l1 << 2;
				int i3 = i1 + k2 / l1 << 2;
				Biome biome = Biome.getBiome(aint[k2]);

				if (biomes.contains(biome) && (blockpos == null || random.nextInt(j2 + 1) == 0)) {
					blockpos = new BlockPos(l2, 0, i3);
					++j2;
				}
			}

			return blockpos;
		}

		/**
		 * Calls the WorldChunkManager's biomeCache.cleanupCache()
		 */
		@Override
		public void cleanupCache() {
			this.biomeCache.cleanupCache();
		}
	}

	public static class GenLayerFix extends GenLayer {

		public GenLayerFix(long seed) {
			super(seed);
		}

		public static GenLayer[] makeTheWorld(long seed, WorldType type) {
			GenLayer biomes = new GenLayerBiomesCustom(1L);
			biomes = new GenLayerZoom(1000L, biomes);
			biomes = new GenLayerZoom(1001L, biomes);
			biomes = new GenLayerZoom(1002L, biomes);
			biomes = new GenLayerZoom(1003L, biomes);
			biomes = new GenLayerZoom(1004L, biomes);
			biomes = new GenLayerZoom(1005L, biomes);
			GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);
			biomes.initWorldGenSeed(seed);
			genlayervoronoizoom.initWorldGenSeed(seed);
			return new GenLayer[]{biomes, genlayervoronoizoom};
		}

		@Override
		public int[] getInts(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
			return null;
		}
	}

	public static class GenLayerBiomesCustom extends GenLayer {

		protected Biome[] allowedBiomes = {Biomes.DEFAULT,};

		public GenLayerBiomesCustom(long seed) {
			super(seed);
		}

		public GenLayerBiomesCustom(long seed, GenLayer genlayer) {
			super(seed);
			this.parent = genlayer;
		}

		@Override
		public int[] getInts(int x, int z, int width, int depth) {
			int[] dest = IntCache.getIntCache(width * depth);
			for (int dz = 0; dz < depth; dz++) {
				for (int dx = 0; dx < width; dx++) {
					this.initChunkSeed(dx + x, dz + z);
					dest[(dx + dz * width)] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
				}
			}
			return dest;
		}
	}

	// helpers
	public static Block getBlock(IBlockAccess world, int i, int j, int k) {
		return world.getBlockState(new BlockPos(i, j, k)).getBlock();
	}

}
