package naturix.divinerpg.bases.dimensions;

import naturix.divinerpg.bases.blocks.portal.PortalBase;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class EdenTeleporter extends Teleporter {

    protected BlockPos lastPortalPos;
    /**
     * A horizontal vector related to the position of the last portal the entity was in
     */
    protected Vec3d lastPortalVec;

    public EdenTeleporter(WorldServer worldIn) {

        super(worldIn);

    }


    public void setFrostRealmPortal(Entity entity, BlockPos pos) {
        if (entity.timeUntilPortal > 0) {

            entity.timeUntilPortal = entity.getPortalCooldown();

        }
    }

    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {
        if (!this.placeInExistingPortal(entityIn, rotationYaw)) {
            this.makePortal(entityIn);
            this.placeInExistingPortal(entityIn, rotationYaw);
        }
    }


    @Override
    public boolean placeInExistingPortal(Entity entityIn, float rotationYaw) {

        int i = 128;

        double d0 = -1.0D;

        int j = MathHelper.floor(entityIn.posX);

        int k = MathHelper.floor(entityIn.posZ);

        boolean flag = true;

        BlockPos blockpos = BlockPos.ORIGIN;

        long l = ChunkPos.asLong(j, k);


        if (this.destinationCoordinateCache.containsKey(l)) {

            PortalPosition teleporter$portalposition = this.destinationCoordinateCache.get(l);

            d0 = 0.0D;

            blockpos = teleporter$portalposition;

            teleporter$portalposition.lastUpdateTime = this.world.getTotalWorldTime();

            flag = false;

        } else {

            BlockPos blockpos3 = new BlockPos(entityIn);


            for (int i1 = -128; i1 <= 128; ++i1) {

                BlockPos blockpos2;


                for (int j1 = -128; j1 <= 128; ++j1) {

                    for (BlockPos blockpos1 =

                         blockpos3.add(i1, this.world.getActualHeight() - 1 - blockpos3.getY(), j1);

                         blockpos1.getY() >= 0; blockpos1 = blockpos2) {

                        blockpos2 = blockpos1.down();


                        if (this.world.getBlockState(blockpos1).getBlock() == ModBlocks.portalEden) {

                            for (blockpos2 = blockpos1.down();

                                 this.world.getBlockState(blockpos2).getBlock() == ModBlocks.portalEden;

                                 blockpos2 = blockpos2.down()) {

                                blockpos1 = blockpos2;

                            }


                            double d1 = blockpos1.distanceSq(blockpos3);


                            if (d0 < 0.0D || d1 < d0) {

                                d0 = d1;

                                blockpos = blockpos1;

                            }

                        }

                    }

                }

            }

        }


        if (d0 >= 0.0D) {

            if (flag) {

                this.destinationCoordinateCache.put(l, new PortalPosition(blockpos, this.world.getTotalWorldTime()));

            }


            double d5 = (double) blockpos.getX() + 0.5D;

            double d7 =  blockpos.getZ() + 0.5D;

            BlockPattern.PatternHelper blockpattern$patternhelper =

            		ModBlocks.portalEden.createPatternHelper(this.world, blockpos);

            boolean flag1 =

                    blockpattern$patternhelper.getForwards().rotateY().getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE;

            double d2 = blockpattern$patternhelper.getForwards().getAxis() == EnumFacing.Axis.X ?

                    (double) blockpattern$patternhelper.getFrontTopLeft().getZ() :

                    (double) blockpattern$patternhelper.getFrontTopLeft().getX();

            double d6 = (double) blockpos.getY() + 0.5D;


            if (flag1) {

                ++d2;

            }


            if (blockpattern$patternhelper.getForwards().getAxis() == EnumFacing.Axis.X) {

                d7 = d2 + 1.0D * (double) blockpattern$patternhelper.getWidth() *

                        (double) blockpattern$patternhelper.getForwards().rotateY().getAxisDirection().getOffset();

                d5 += this.world.rand.nextBoolean() ? 1.25 : -1.25;

            } else {

                d5 = d2 + 1.0D * (double) blockpattern$patternhelper.getWidth() *

                        (double) blockpattern$patternhelper.getForwards().rotateY().getAxisDirection().getOffset();

                d7 += this.world.rand.nextBoolean() ? 1.25 : -1.25;

            }


            float f = 0.0F;

            float f1 = 0.0F;

            float f2 = 0.0F;

            float f3 = 0.0F;

            f2 = -1.0F;

            f3 = 1.0F;


            double d3 = entityIn.motionX;

            double d4 = entityIn.motionZ;

            entityIn.motionX = d3 * (double) f + d4 * (double) f3;

            entityIn.motionZ = d3 * (double) f2 + d4 * (double) f1;

            entityIn.rotationYaw =

                    rotationYaw - (float) 90 +

                            (float) 90;


            if (entityIn instanceof EntityPlayerMP) {

                ((EntityPlayerMP) entityIn).connection.setPlayerLocation(d5, d6, d7, entityIn.rotationYaw, 0.0F);

            } else {

                entityIn.setLocationAndAngles(d5, d6, d7, entityIn.rotationYaw, entityIn.rotationPitch);

            }


            return true;

        }

        return false;

    }


    @Override
    public boolean makePortal(Entity entityIn) {

        BlockPos pos = entityIn.getPosition().north();

        for (int x = -3; x <= 3; x++) {

            for (int z = -3; z <= 3; z++) {
                for (int y = -2; y <= 3; y++) {
                    this.world.setBlockState(pos.add(x, -2, z), Blocks.AIR.getDefaultState());
                }
                this.world.setBlockState(pos.add(x, -2, z), Blocks.SNOW.getDefaultState());
            }

        }
        for (int x = -2; x <= 2; x++) {

            for (int y = -1; y <= 3; y++) {
                this.world.setBlockState(pos.add(x, y, 0), Blocks.SNOW.getDefaultState());
            }
        }
        for (int x = -1; x <= 1; x++) {
            for (int y = 0; y <= 2; y++) {
                this.world.setBlockState(pos.add(x, y, 0), ModBlocks.portalEden.getDefaultState().withProperty(PortalBase.AXIS, EnumFacing.Axis.X), 0);
            }
        }

        return true;

    }

}