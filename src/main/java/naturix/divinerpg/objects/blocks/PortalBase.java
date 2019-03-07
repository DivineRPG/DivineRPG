package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.DivineTeleporter;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBlock;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class PortalBase extends BlockBreakable implements IHasModel {

	public static final int[][] sides = new int[][] { new int[0], { 3, 1 }, { 2, 0 } };

	public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis>create("axis",
	        EnumFacing.Axis.class, EnumFacing.Axis.X, EnumFacing.Axis.Z);

	protected static final AxisAlignedBB X_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.375D, 1.0D, 1.0D, 0.625D);
	protected static final AxisAlignedBB Z_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.0D, 1.0D);

	protected static final AxisAlignedBB Y_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D);

	public static void sendEntityToDimension(Entity entity, int dimId, Teleporter tp) {
		if (!entity.world.isRemote && !entity.isDead) {
			entity.world.profiler.startSection("changeDimension");
			MinecraftServer minecraftserver = entity.getServer();
			int j = entity.dimension;
			WorldServer worldserver = minecraftserver.getWorld(j);
			WorldServer worldserver1 = minecraftserver.getWorld(dimId);
			entity.dimension = dimId;

			if (j == dimId && dimId != 0) {
				worldserver1 = minecraftserver.getWorld(0);
				entity.dimension = 0;
			}

			entity.world.removeEntity(entity);
			entity.isDead = false;
			minecraftserver.getPlayerList().transferEntityToWorld(entity, j, worldserver, worldserver1, tp);
			Entity newEntity = EntityList.createEntityByID((entity.getEntityId()), worldserver1);

			if (newEntity != null) {
				newEntity.getEntityData();

				// if (j == dimId && dimId != 0) {
				// BlockPos chunkcoordinates = worldserver1.getSpawnPoint();
				// chunkcoordinates.posY =
				// entity.world.getTopSolidOrLiquidBlock(chunkcoordinates.posX,
				// chunkcoordinates.posZ);
				// newEntity.setLocationAndAngles((double) chunkcoordinates.posX, (double)
				// chunkcoordinates.posY,
				// (double) chunkcoordinates.posZ + 10, newEntity.rotationYaw,
				// newEntity.rotationPitch);
				// }

				worldserver1.spawnEntity(newEntity);
			}

			entity.isDead = true;
			entity.world.profiler.endSection();
			worldserver.resetUpdateEntityTick();
			worldserver1.resetUpdateEntityTick();
			entity.world.profiler.endSection();
		}
	}

	protected String name;
	protected int dimensionID;
	protected Block fireBlock, blockFrame;

	public PortalBase(String name, int dimensionID, Block fireBlock, Block blockFrame) {
		super(Material.PORTAL, false);
		this.name = name;
		this.dimensionID = dimensionID;
		this.fireBlock = fireBlock;
		this.blockFrame = blockFrame;
		setUnlocalizedName(name);
		setRegistryName(name);
		if (Config.debug) {
			setCreativeTab(DivineRPG.BlocksTab);
		} else {
			setCreativeTab(null);
		}
		setTickRandomly(true);
		setBlockUnbreakable();
		((FireBase) fireBlock).addPortal(this);
		setLightLevel(0.8f);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		switch (state.getValue(AXIS)) {
		case X:
			return X_AABB;
		case Y:
		default:
			return Y_AABB;
		case Z:
			return Z_AABB;
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return null;
	}

	public int getMeta(int meta) {
		return meta & 3;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		double x = entity.getPosition().getX();
		double y = entity.getPosition().getY();
		double z = entity.getPosition().getZ();

		if ((entity.isRiding() == false) && (entity.isBeingRidden() == false)) {
			if (entity instanceof EntityPlayerMP) {
				EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
				if (thePlayer.timeUntilPortal > 0) {
					thePlayer.timeUntilPortal = 10;
				} else if (thePlayer.dimension != dimensionID) {
					thePlayer.timeUntilPortal = 10;
					thePlayer.mcServer.getPlayerList().transferPlayerToDimension(thePlayer, dimensionID,
					        new DivineTeleporter(thePlayer.mcServer.getWorld(dimensionID), x, y, z));

				} else {
					thePlayer.timeUntilPortal = 10;
					thePlayer.mcServer.getPlayerList().transferPlayerToDimension(thePlayer, 0,
					        new DivineTeleporter(thePlayer.mcServer.getWorld(0), x, y, z));
				}
			} else {
				if (entity.dimension != this.dimensionID) {
					entity.timeUntilPortal = 10;
					// sendEntityToDimension(entity, this.dimensionID, new
					// DivineTeleporter(MinecraftServer.getServer().getWorld(this.dimensionID),
					// this.dimensionID, this, this.blockFrame));
				} else {
					entity.timeUntilPortal = 10;
					// sendEntityToDimension(entity, 0, new
					// DivineTeleporter(MinecraftServer.getServer().getWorld(0), 0,
					// this, this.blockFrame));
				}
			}
		}
	}

	@Override
	public void registerModels() {
		// TODO Auto-generated method stub

	}

	// @Override
	// public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos pos2)
	// {
	// byte size1 = 0;
	// byte size2 = 1;
	// int x = pos2.getX(), y = pos2.getY(), z = pos2.getZ();
	// if (world.getBlockState(new BlockPos(x - 1, y, z)) == this
	// || world.getBlockState(new BlockPos(x + 1, y, z)) == this) {
	// size1 = 1;
	// size2 = 0;
	// }
	//
	// int i1;
	//
	// for (i1 = y; world.getBlockState(new BlockPos(x, i1 - 1, z)) == this; --i1) {
	// ;
	// }
	//
	// if (world.getBlock(x, i1 - 1, z) != blockFrame) {
	// world.setBlockToAir(x, y, z);
	// } else {
	// int j1;
	//
	// for (j1 = 1; j1 < 4 && world.getBlock(x, i1 + j1, z) == this; ++j1) {
	// ;
	// }
	//
	// if (j1 == 3 && world.getBlock(x, i1 + j1, z) == blockFrame) {
	// boolean flag = world.getBlock(x - 1, y, z) == this || world.getBlock(x + 1,
	// y, z) == this;
	// boolean flag1 = world.getBlock(x, y, z - 1) == this || world.getBlock(x, y, z
	// + 1) == this;
	//
	// if (flag && flag1) {
	// world.setBlockToAir(x, y, z);
	// } else {
	// if ((world.getBlock(x + size1, y, z + size2) != blockFrame
	// || world.getBlock(x - size1, y, z - size2) != this)
	// && (world.getBlock(x - size1, y, z - size2) != blockFrame
	// || world.getBlock(x + size1, y, z + size2) != this)) {
	// world.setBlockToAir(x, y, z);
	// }
	// }
	// } else {
	// world.setBlockToAir(x, y, z);
	// }
	// }
	// }

	// @SideOnly(Side.CLIENT)
	// @Override
	// public void randomDisplayTick(World world, BlockPos pos, Random rand) {
	// for (int l = 0; l < 4; ++l) {
	// double d0 = xPos + rand.nextFloat();
	// double d1 = yPos + rand.nextFloat();
	// double d2 = zPos + rand.nextFloat();
	// double d3 = 0.0D;
	// double d4 = 0.0D;
	// double d5 = 0.0D;
	// int i1 = rand.nextInt(2) * 2 - 1;
	// d3 = (rand.nextFloat() - 0.5D) * 0.5D;
	// d4 = (rand.nextFloat() - 0.5D) * 0.5D;
	// d5 = (rand.nextFloat() - 0.5D) * 0.5D;
	//
	// if (world.getBlock(xPos - 1, yPos, zPos) != this && world.getBlock(xPos + 1,
	// yPos, zPos) != this) {
	// d0 = xPos + 0.5D + 0.25D * i1;
	// d3 = rand.nextFloat() * 2.0F * i1;
	// } else {
	// d2 = zPos + 0.5D + 0.25D * i1;
	// d5 = rand.nextFloat() * 2.0F * i1;
	// }
	// EntityFX var20 = this == TwilightBlocks.edenPortal ? new
	// EntityEdenPortalFX(world, d0, d1, d2, d3, d4, d5)
	// : (this == TwilightBlocks.wildwoodPortal ? new EntityWildwoodPortalFX(world,
	// d0, d1, d2, d3, d4, d5)
	// : (this == TwilightBlocks.apalachiaPortal
	// ? new EntityPortalFX(world, d0, d1, d2, d3, d4, d5)
	// : (this == TwilightBlocks.skythernPortal
	// ? new EntitySkythernPortalFX(world, d0, d1, d2, d3, d4, d5)
	// : (this == TwilightBlocks.mortumPortal
	// ? new EntityMortumPortalFX(world, d0, d1, d2, d3, d4, d5)
	// : (this == IceikaBlocks.iceikaPortal
	// ? new EntitySkythernPortalFX(world, d0, d1, d2, d3, d4, d5)
	// : null)))));
	// FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
	// }
	// }
	//
	// @Override
	// public void registerModels() {
	// DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, name);
	// }
	//
	// public boolean tryCreatePortal(World world, int x, int y, int z) {
	// DivineRPG.logger.debug("Trying to create portal");
	// byte size1 = 0;
	// byte size2 = 0;
	// if (world.getBlock(x - 1, y, z) == blockFrame || world.getBlock(x + 1, y, z)
	// == blockFrame) {
	// size1 = 1;
	// }
	// if (world.getBlock(x, y, z - 1) == blockFrame || world.getBlock(x, y, z + 1)
	// == blockFrame) {
	// size2 = 1;
	// }
	// if (size1 == size2) {
	// return false;
	// }
	// if (world.isAirBlock(x - size1, y, z - size2)) {
	// x -= size1;
	// z -= size2;
	// }
	//
	// for (int i = -1; i <= 2; i++) {
	// for (int j = -1; j <= 3; j++) {
	// boolean flag = i == -1 || i == 2 || j == -1 || j == 3;
	// if (i != -1 && i != 2 || j != -1 && j != 3) {
	// Block b1 = world.getBlock(x + size1 * i, y + j, z + size2 * i);
	// boolean isAir = world.isAirBlock(x + size1 * i, y + j, z + size2 * i);
	// if (flag) {
	// if (b1 != blockFrame) {
	// return false;
	// }
	// } else if (!isAir && b1 != fireBlock) {
	// return false;
	// }
	// }
	// }
	// }
	//
	// LogHelper.debug("Creating Portal");
	// for (int i = 0; i < 2; i++) {
	// for (int j = 0; j < 3; j++) {
	// world.setBlock(x + size1 * i, y + j, z + size2 * i, this, 0, 2);
	// }
	// }
	//
	// return true;
	// // PortalSize size = new PortalSize(world, x, y, z, 1, this, fireBlock,
	// // blockFrame);
	// // PortalSize size1 = new PortalSize(world, x, y, z, 2, this, fireBlock,
	// // blockFrame);
	// // LogHelper.debug("Size value: " + size.value);
	// // LogHelper.debug("Size1 value: " + size.value);
	// // LogHelper.debug("Size isInChunk: " + size.isInChunk());
	// // LogHelper.debug("Size1 isInChunk: " + size.isInChunk());
	// // if (size.isInChunk() && (size.value == 0)) {
	// // size.setPortalSize();
	// // LogHelper.debug("Portal created succesfully");
	// // return true;
	// // }
	// // if (size1.isInChunk() && size1.value == 0) {
	// // size1.setPortalSize();
	// // LogHelper.debug("Portal created succesfully");
	// // return true;
	// // }
	// // LogHelper.debug("Portal failed to create");
	// // return false;
	// }
	//
	// @Override
	// public void updateTick(World world, int x, int y, int z, Random rand) {
	// super.updateTick(world, x, y, z, rand);
	//
	// if (world.provider.isSurfaceWorld() &&
	// world.getGameRules().getGameRuleBooleanValue("doMobSpawning")
	// && rand.nextInt(2000) < world.difficultySetting.getDifficultyId()) {
	// int l = y;
	// while (!World.doesBlockHaveSolidTopSurface(world, x, y, z) && l > 0) {
	// l--;
	// }
	//
	// if (l > 0 && !world.getBlock(x, l + 1, z).isNormalCube()) {
	// Entity entity = ItemMonsterPlacer.spawnCreature(world, 57, x + 0.5D, l +
	// 1.1D, z + 0.5D);
	//
	// if (entity != null) {
	// entity.timeUntilPortal = entity.getPortalCooldown();
	// }
	// }
	// }
	// }

}