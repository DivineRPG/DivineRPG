package naturix.divinerpg.dimensions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.dimensions.ModTeleporter.PortalPosition;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ModTeleporter extends Teleporter {

	protected final WorldServer myWorld;
	protected final Random random;
    protected final Long2ObjectMap<ModTeleporter.PortalPosition> destinationCoordinateCache = new Long2ObjectOpenHashMap<ModTeleporter.PortalPosition>(4096);
	protected final List destinationCoordinateKeys = new ArrayList();
	protected int dimensionID;
	protected Block portal, frameBlock;

	public ModTeleporter(WorldServer worldServer, int dimensionID, Block portal, Block frameBlock) {
		super(worldServer);
		this.myWorld = worldServer;
		this.dimensionID = dimensionID;
		this.portal = portal;
		this.frameBlock = frameBlock;
		this.random = new Random(worldServer.getSeed());
	}

	@Override
	public void placeInPortal(Entity entity, float par8) {
			if (!this.placeInExistingPortal(entity, par8)) {
				this.makePortal(entity);
				this.placeInExistingPortal(entity, par8);
		}
	}

	@Override
	public boolean placeInExistingPortal(Entity e, float par2) {
		boolean flag = true;
		double d0 = -1.0D;
		
		int i = MathHelper.floor(e.posX);
		int j = MathHelper.floor(e.posZ);
		boolean flag1 = true;
		BlockPos object = BlockPos.ORIGIN;
		long k = ChunkPos.asLong(i, j);

		if (this.destinationCoordinateCache.containsKey(k))
		{
			PortalPosition portalposition = this.destinationCoordinateCache.get(k);
			d0 = 0.0D;
			object = portalposition;
			portalposition.lastUpdateTime = this.myWorld.getTotalWorldTime();
			flag1 = false;
		}
		else
		{
			BlockPos blockpos4 = new BlockPos(e);

			for (int l = -128; l <= 128; ++l)
			{
				BlockPos blockpos1;

				for (int i1 = -128; i1 <= 128; ++i1)
				{
					for (BlockPos blockpos = blockpos4.add(l, this.myWorld.getActualHeight() - 1 - blockpos4.getY(), i1); blockpos.getY() >= 0; blockpos = blockpos1)
					{
						blockpos1 = blockpos.down();

						if (this.myWorld.getBlockState(blockpos).getBlock() == portal)
						{
							while (this.myWorld.getBlockState(blockpos1 = blockpos.down()).getBlock() == portal)
							{
								blockpos = blockpos1;
							}

							double d1 = blockpos.distanceSq(blockpos4);

							if (d0 < 0.0D || d1 < d0)
							{
								d0 = d1;
								object = blockpos;
							}
						}
					}
				}
			}
		}

		if (d0 >= 0.0D)
		{
			if (flag1)
			{
                this.destinationCoordinateCache.put(k, new ModTeleporter.PortalPosition(object, this.world.getTotalWorldTime()));
			}

			double d4 = object.getX() + 0.5D;
			double d5 = object.getY() + 0.5D;
			double d6 = object.getZ() + 0.5D;
			EnumFacing enumfacing = null;

			if (this.myWorld.getBlockState(object.west()).getBlock() == portal)
			{
				enumfacing = EnumFacing.NORTH;
			}

			if (this.myWorld.getBlockState(object.east()).getBlock() == portal)
			{
				enumfacing = EnumFacing.SOUTH;
			}

			if (this.myWorld.getBlockState(object.north()).getBlock() == portal)
			{
				enumfacing = EnumFacing.EAST;
			}

			if (this.myWorld.getBlockState(object.south()).getBlock() == portal)
			{
				enumfacing = EnumFacing.WEST;
			}

			EnumFacing enumfacing1 = EnumFacing.getHorizontal(0);
			//EnumFacing enumfacing1 = EnumFacing.getHorizontal(e.func_181012_aH());

			if (enumfacing != null)
			{
				EnumFacing enumfacing2 = enumfacing.rotateYCCW();
				BlockPos blockpos2 = object.offset(enumfacing);
				boolean flag2 = this.func_180265_a(blockpos2);
				boolean flag3 = this.func_180265_a(blockpos2.offset(enumfacing2));

				if (flag3 && flag2)
				{
					object = object.offset(enumfacing2);
					enumfacing = enumfacing.getOpposite();
					enumfacing2 = enumfacing2.getOpposite();
					BlockPos blockpos3 = object.offset(enumfacing);
					flag2 = this.func_180265_a(blockpos3);
					flag3 = this.func_180265_a(blockpos3.offset(enumfacing2));
				}

				float f6 = 0.5F;
				float f1 = 0.5F;

				if (!flag3 && flag2)
				{
					f6 = 1.0F;
				}
				else if (flag3 && !flag2)
				{
					f6 = 0.0F;
				}
				else if (flag3)
				{
					f1 = 0.0F;
				}

				d4 = object.getX() + 0.5D;
				d5 = object.getY() + 0.5D;
				d6 = object.getZ() + 0.5D;
				d4 += enumfacing2.getFrontOffsetX() * f6 + enumfacing.getFrontOffsetX() * f1;
				d6 += enumfacing2.getFrontOffsetZ() * f6 + enumfacing.getFrontOffsetZ() * f1;
				float f2 = 0.0F;
				float f3 = 0.0F;
				float f4 = 0.0F;
				float f5 = 0.0F;

				if (enumfacing == enumfacing1)
				{
					f2 = 1.0F;
					f3 = 1.0F;
				}
				else if (enumfacing == enumfacing1.getOpposite())
				{
					f2 = -1.0F;
					f3 = -1.0F;
				}
				else if (enumfacing == enumfacing1.rotateY())
				{
					f4 = 1.0F;
					f5 = -1.0F;
				}
				else
				{
					f4 = -1.0F;
					f5 = 1.0F;
				}

				double d2 = e.motionX;
				double d3 = e.motionZ;
				e.motionX = d2 * f2 + d3 * f5;
				e.motionZ = d2 * f4 + d3 * f3;
				e.rotationYaw = par2 - enumfacing1.getHorizontalIndex() * 90 + enumfacing.getHorizontalIndex() * 90;
			}
			else
			{
				e.motionX = e.motionY = e.motionZ = 0.0D;
			}

			e.setLocationAndAngles(d4, d5, d6, e.rotationYaw, e.rotationPitch);
			return true;
		}
		else
		{
			return false;
		}
		

	}

	private boolean func_180265_a(BlockPos p_180265_1_)
	{
		return !this.myWorld.isAirBlock(p_180265_1_) || !this.myWorld.isAirBlock(p_180265_1_.up());
	}

	@Override
	public boolean makePortal(Entity entity) {
		byte b0 = 16;
		double d0 = -1.0D;
		int i = MathHelper.floor(entity.posX);
		int j = MathHelper.floor(entity.posY);
		int k = MathHelper.floor(entity.posZ);
		int l = i;
		int i1 = j;
		int j1 = k;
		int k1 = 0;
		int l1 = this.random.nextInt(4);
		int i2;
		double d1;
		double d2;
		int k2;
		int i3;
		int k3;
		int j3;
		int i4;
		int l3;
		int k4;
		int j4;
		int i5;
		int l4;
		double d3;
		double d4;

		for (i2 = i - b0; i2 <= i + b0; ++i2) {
			d1 = i2 + 0.5D - entity.posX;

			for (k2 = k - b0; k2 <= k + b0; ++k2) {
				d2 = k2 + 0.5D - entity.posZ;
				label274:

					for (i3 = this.myWorld.getActualHeight() - 1; i3 >= 0; --i3) {
						if (this.myWorld.isAirBlock(new BlockPos(i2, i3, k2))) {
							while (i3 > 0 && this.myWorld.isAirBlock(new BlockPos(i2, i3 - 1, k2)))
								--i3;

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

											if (k4 < 0 && !this.myWorld.getBlockState(new BlockPos(l4, i5, j5)).getMaterial().isSolid() || k4 >= 0 && !this.myWorld.isAirBlock(new BlockPos(l4, i5, j5)))
												continue label274;
										}
									}
								}

								d4 = i3 + 0.5D - entity.posY;
								d3 = d1 * d1 + d4 * d4 + d2 * d2;

								if (d0 < 0.0D || d3 < d0) {
									d0 = d3;
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

		if (d0 < 0) {
			for (i2 = i - b0; i2 <= i + b0; ++i2) {
				d1 = i2 + 0.5D - entity.posX;

				for (k2 = k - b0; k2 <= k + b0; ++k2) {
					d2 = k2 + 0.5D - entity.posZ;
					label222:

						for (i3 = this.myWorld.getActualHeight() - 1; i3 >= 0; --i3) {
							if (this.myWorld.isAirBlock(new BlockPos(i2, i3, k2))) {
								while (i3 > 0 && this.myWorld.isAirBlock(new BlockPos(i2, i3 - 1, k2)))
									--i3;

								for (j3 = l1; j3 < l1 + 2; ++j3) {
									k3 = j3 % 2;
									l3 = 1 - k3;

									for (i4 = 0; i4 < 4; ++i4) {
										for (j4 = -1; j4 < 4; ++j4) {
											k4 = i2 + (i4 - 1) * k3;
											l4 = i3 + j4;
											i5 = k2 + (i4 - 1) * l3;

											if (j4 < 0 && !this.myWorld.getBlockState(new BlockPos(k4, l4, i5)).getMaterial().isSolid() || j4 >= 0 && !this.myWorld.isAirBlock(new BlockPos(k4, l4, i5)))
												continue label222;
										}
									}

									d4 = i3 + 0.5D - entity.posY;
									d3 = d1 * d1 + d4 * d4 + d2 * d2;

									if (d0 < 0 || d3 < d0) {
										d0 = d3;
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

		boolean flag;

		if (d0 < 0.0D) {
			if (i1 < 70)
				i1 = 70;

			if (i1 > this.myWorld.getActualHeight() - 10)
				i1 = this.myWorld.getActualHeight() - 10;

			j2 = i1;

			for (i3 = -1; i3 <= 1; ++i3) {
				for (j3 = 1; j3 < 3; ++j3) {
					for (k3 = -1; k3 < 3; ++k3) {
						l3 = k5 + (j3 - 1) * l5 + i3 * l2;
						i4 = j2 + k3;
						j4 = k2 + (j3 - 1) * l2 - i3 * l5;
						flag = k3 < 0;
						this.myWorld.setBlockState(new BlockPos(l3, i4, j4), flag ? frameBlock.getDefaultState() : Blocks.AIR.getDefaultState());
					}
				}
			}
		}

		for (i3 = 0; i3 < 4; ++i3) {
			for (j3 = 0; j3 < 4; ++j3) {
				for (k3 = -1; k3 < 4; ++k3) {
					l3 = k5 + (j3 - 1) * l5;
					i4 = j2 + k3;
					j4 = k2 + (j3 - 1) * l2;
					flag = j3 == 0 || j3 == 3 || k3 == -1 || k3 == 3;
					this.myWorld.setBlockState(new BlockPos(l3, i4, j4), (flag ? frameBlock.getDefaultState() : portal.getDefaultState()), 2);
				}
			}

			for (j3 = 0; j3 < 4; ++j3) {
				for (k3 = -1; k3 < 4; ++k3) {
					l3 = k5 + (j3 - 1) * l5;
					i4 = j2 + k3;
					j4 = k2 + (j3 - 1) * l2;
					BlockPos pos = new BlockPos(l3, i4, j4);
					this.myWorld.notifyNeighborsOfStateChange(pos, this.myWorld.getBlockState(pos).getBlock(), false);
				}
			}
		}
		return true;
	}
	
	public class PortalPosition extends BlockPos
    {
        /** The worldtime at which this PortalPosition was last verified */
        public long lastUpdateTime;

        public PortalPosition(BlockPos pos, long lastUpdate)
        {
            super(pos.getX(), pos.getY(), pos.getZ());
            this.lastUpdateTime = lastUpdate;
        }
    }

    @Override
    public void placeEntity(World world, Entity entity, float yaw)
    {
        if (entity instanceof EntityPlayerMP)
            placeInPortal(entity, yaw);
        else
            placeInExistingPortal(entity, yaw);
    }
}