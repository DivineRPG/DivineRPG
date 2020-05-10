package divinerpg.dimensions.vethea;

import divinerpg.registry.ModBlocks;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class TeleporterVethea extends Teleporter {
	
	protected WorldServer myWorld;

	public TeleporterVethea(WorldServer var1) {
		super(var1);
		this.myWorld = var1;
	}

	@Override
	public boolean placeInExistingPortal(Entity entity, float rotationYaw) {
		short searchRange = 64;
		double var10 = -1.0D;
		int var12 = 0;
		int var13 = 0;
		int var14 = 0;

		int entityPosX = MathHelper.floor(entity.posX);
		int entityPosZ = MathHelper.floor(entity.posZ);

		double var24;

		for(int searchX = entityPosX - searchRange; searchX <= entityPosX + searchRange; ++searchX) {
			for(int searchZ = entityPosZ - searchRange; searchZ <= entityPosZ + searchRange; ++searchZ) {
				for(int searchY = 0; searchY < 256; ++searchY) {
					if(this.isBlockPortal(this.myWorld, searchX, searchY, searchZ)) {

						double searchXOffset = searchX + 0.5D - entity.posX;
						double searchYOffset = searchY + 0.5D - entity.posY;
						double searchZOffset = searchZ + 0.5D - entity.posZ;
						double var26 = Math.pow(searchXOffset, 2) + Math.pow(searchYOffset, 2) + Math.pow(searchZOffset, 2);

						if(var10 < 0.0D || var26 < var10) {
							var10 = var26;
							var12 = searchX;
							var13 = searchY;
							var14 = searchZ;
						}
					}
				}
			}
		}

		if(var10 >= 0.0D) {
			double var28 = var12 + 0.5D;
			double var22 = var13 + 0.5D;
			var24 = var14 + 0.5D;

			if(this.isBlockPortal(this.myWorld, var12 - 1, var13, var14)) var28 -= 0.5D;
			if(this.isBlockPortal(this.myWorld, var12 + 1, var13, var14)) var28 += 0.5D;
			if(this.isBlockPortal(this.myWorld, var12, var13, var14 - 1)) var24 -= 0.5D;
			if(this.isBlockPortal(this.myWorld, var12, var13, var14 + 1)) var24 += 0.5D;

			if(myWorld.provider.getDimension()==0) {
				EntityPlayer player = (EntityPlayer)entity;
				player.setLocationAndAngles(player.getBedLocation(0).getX(), player.getBedLocation(0).getY()+1, player.getBedLocation(0).getZ(), entity.rotationYaw, 0.0F);
			}else {
			entity.setLocationAndAngles(var28, var22 + 1.0D, var24 + 1.0D, entity.rotationYaw, 0.0F);
		}	entity.motionX = entity.motionY = entity.motionZ = 0.0D;
			return true;
		} else 
			return false;
	}

	public boolean isBlockPortal(World var1, int var2, int var3, int var4) {
		//System.out.println(var2 + " " + var3 + " " + var4 + " " + var1.getBlockState(new BlockPos(var2, var3, var4)).getBlock());
		if(var1.getBlockState(new BlockPos(var2, var3, var4)).getBlock() == ModBlocks.vetheaPortal) {
			return true;
		}
		return false;

	}

	@Override
	public boolean makePortal(Entity entity) {
		byte var4 = 16;
		double var32, var33, var16, var19, var5 = -1.0D, var2 = this.myWorld.provider.getDimension() == 0 ? 2.0D : 0.5D;
		int var7 = MathHelper.floor(entity.posX);
		int var8 = MathHelper.floor(entity.posY * var2);
		int var9 = MathHelper.floor(entity.posZ);
		int var10 = var7, var11 = var8, var12 = var9, var13 = 0, var14 = this.myWorld.rand.nextInt(4), var15, var18, var21, var23, var22, var25, var24, var27, var26, var29, var28;

		var13 = 0;
		var23 = 0;

		for(var15 = var7 - var4; var15 <= var7 + var4; ++var15) {
			var16 = var15 + 0.5D - entity.posX;

			for(var18 = var9 - var4; var18 <= var9 + var4; ++var18) {
				var19 = var18 + 0.5D - entity.posZ;
				label178:

					for(var21 = 127; var21 >= 0; --var21) {
						if(this.myWorld.isAirBlock(new BlockPos(var15, var21, var18))) {
							while(var21 > 0 && this.myWorld.isAirBlock(new BlockPos(var15, var21 - 1, var18))) {
								--var21;
							}

							var23 = var13 % 2;

							for(var22 = var14; var22 < var14 + 4; ++var22) {
								var23 = var22 % 2;
								var24 = 1 - var23;

								if(var22 % 4 >= 2) {
									var23 = -var23;
									var24 = -var24;
								}

								for(var25 = 0; var25 < 3; ++var25) {
									for(var26 = 0; var26 < 4; ++var26) {
										for(var27 = -1; var27 < 4; ++var27) {
											var28 = var15 + (var26 - 1) * var23 + var25 * var24;
											var29 = var21 + var27;
											int var30 = var18 + (var26 - 1) * var24 - var25 * var23;

											if(var27 < 0 && !this.myWorld.getBlockState(new BlockPos(var28, var29, var30)).getMaterial().isSolid() || var27 >= 0 && !this.myWorld.isAirBlock(new BlockPos(var28, var29, var30))) {
												continue label178;
											}
										}
									}
								}

								var32 = var21 + 0.5D - entity.posY * var2;
								var33 = var16 * var16 + var32 * var32 + var19 * var19;

								if(var5 < 0.0D || var33 < var5) {
									var5 = var33;
									var10 = var15;
									var11 = var21;
									var12 = var18;
									var13 = var22 % 4;
								}
							}
						}
					}
			}
		}

		if(var5 < 0.0D) {
			for(var15 = var7 - var4; var15 <= var7 + var4; ++var15) {
				var16 = var15 + 0.5D - entity.posX;

				for(var18 = var9 - var4; var18 <= var9 + var4; ++var18) {
					var19 = var18 + 0.5D - entity.posZ;
					label126:

						for(var21 = 127; var21 >= 0; --var21) {
							if(this.myWorld.isAirBlock(new BlockPos(var15, var21, var18))) {
								while(var21 > 0 && this.myWorld.isAirBlock(new BlockPos(var15, var21 - 1, var18))) {
									--var21;
								}

								for(var22 = var14; var22 < var14 + 2; ++var22) {
									var23 = var22 % 2;
									var24 = 1 - var23;

									for(var25 = 0; var25 < 4; ++var25) {
										for(var26 = -1; var26 < 4; ++var26) {
											var27 = var15 + (var25 - 1) * var23;
											var28 = var21 + var26;
											var29 = var18 + (var25 - 1) * var24;

											if(var26 < 0 && !this.myWorld.getBlockState(new BlockPos(var27, var28, var29)).getMaterial().isSolid() || var26 >= 0 && !this.myWorld.isAirBlock(new BlockPos(var27, var28, var29))) {
												continue label126;
											}
										}
									}

									var32 = var21 + 0.5D - entity.posY * var2;
									var33 = var16 * var16 + var32 * var32 + var19 * var19;

									if(var5 < 0.0D || var33 < var5) {
										var5 = var33;
										var10 = var15;
										var11 = var21;
										var12 = var18;
										var13 = var22 % 2;
									}
								}
							}
						}
				}
			}
		}

		int var31 = var13 % 2;
		int var20 = 1 - var31;

		if(var13 % 4 >= 2) {
			var31 = -var31;
			var20 = -var20;
		}



		this.makePortalAt(this.myWorld, var10, var11, var12);
		return true;
	}

	private void makePortalAt(World world, int x, int y, int z) {

		y = 16;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < 6; k++) {
//					world.setBlockState(new BlockPos(x + i - 3, y + j - 1, z + k - 4), Blocks.AIR.getDefaultState());
				}
			}
		}

		IBlockState portalState = ModBlocks.vetheaPortal.getDefaultState().withProperty(BlockPortal.AXIS, EnumFacing.Axis.Z);

		world.setBlockState(new BlockPos(x + 1, y, z), ModBlocks.mortumBlock.getDefaultState());
		world.setBlockState(new BlockPos(x, y, z), ModBlocks.mortumBlock.getDefaultState());
		world.setBlockState(new BlockPos(x + 2, y, z), ModBlocks.mortumBlock.getDefaultState());
		world.setBlockState(new BlockPos(x + 1, y + 1, z - 1), ModBlocks.mortumBlock.getDefaultState());
	    world.setBlockState(new BlockPos(x + 1, y + 1, z + 1), ModBlocks.mortumBlock.getDefaultState());
		world.setBlockState(new BlockPos(x + 1, y + 2, z - 2), ModBlocks.mortumBlock.getDefaultState());
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 2), ModBlocks.mortumBlock.getDefaultState());
	    world.setBlockState(new BlockPos(x + 1, y + 3, z + 1), ModBlocks.mortumBlock.getDefaultState());
		world.setBlockState(new BlockPos(x + 1, y + 3, z - 1), ModBlocks.mortumBlock.getDefaultState());
		world.setBlockState(new BlockPos(x + 1, y + 4, z), ModBlocks.mortumBlock.getDefaultState());
		world.setBlockState(new BlockPos(x + 1, y + 1, z), portalState, 2);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 1), portalState, 2);
		world.setBlockState(new BlockPos(x + 1, y + 2, z), portalState, 2);
		world.setBlockState(new BlockPos(x + 1, y + 2, z - 1), portalState, 2);
		world.setBlockState(new BlockPos(x + 1, y + 3, z), portalState, 2);
	}
}
