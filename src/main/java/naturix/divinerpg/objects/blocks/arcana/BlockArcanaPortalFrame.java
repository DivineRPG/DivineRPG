package naturix.divinerpg.objects.blocks.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.Config;
import naturix.divinerpg.objects.blocks.BlockMod;
import naturix.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockArcanaPortalFrame extends BlockMod {
    protected static final AxisAlignedBB AABB_BLOCK = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D);

    protected Block portal;

    public BlockArcanaPortalFrame(String name, Block portal) {
        super(EnumBlockType.ROCK, name, 5.0F);
        this.portal = portal;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return AABB_BLOCK;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
            List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
        addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_BLOCK);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return face == EnumFacing.DOWN ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer,
            ItemStack stack) {
        //int var6 = ((MathHelper.floor(placer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3) + 2) % 4;
        world.setBlockState(pos, this.getDefaultState(), 3);
        if (placer instanceof EntityPlayerMP && placer.dimension != Config.arcanaDimensionId) {
            boolean validFrame = true;
            int startX = pos.getX();
            int startZ = pos.getZ();
            int y = pos.getY();
            IBlockState thisState = this.getDefaultState();

            /* Find upper left hand corner of frame */
            if (world.getBlockState(new BlockPos(startX - 1, y, startZ)) == thisState
                    || world.getBlockState(new BlockPos(startX + 1, y, startZ)) == thisState) {
                while (world.getBlockState(new BlockPos(startX - 1, y, startZ)) == thisState) {
                    startX--;
                }
                startX--;
                if (world.getBlockState(new BlockPos(startX, y, startZ - 1)) == thisState) {
                    startZ = startZ - 4;
                }
            } else if (world.getBlockState(new BlockPos(startX, y, startZ - 1)) == thisState
                    || world.getBlockState(new BlockPos(startX, y, startZ + 1)) == thisState) {
                while (world.getBlockState(new BlockPos(startX, y, startZ - 1)) == thisState) {
                    startZ--;
                }
                startZ--;
                if (world.getBlockState(new BlockPos(startX - 1, y, startZ)) == thisState) {
                    startX = startX - 4;
                }
            }

            /* Check if it is a valid Arcana portal frame */
            frameCheckLoops: for (int scanZ = startZ; scanZ < startZ + 5; scanZ++) {
                if ((scanZ == startZ || scanZ == startZ + 4)) {
                    for (int scanX = startX + 1; scanX < startX + 4; scanX++) {
                        if (world.getBlockState(new BlockPos(scanX, y, scanZ)) != thisState) {
                            validFrame = false;
                            break frameCheckLoops;
                        }
                    }
                } else {
                    for (int scanX = startX; scanX < startX + 5; scanX++) {
                        if (scanX == startX || scanX == startX + 4) {
                            if (world.getBlockState(new BlockPos(scanX, y, scanZ)) != thisState) {
                                validFrame = false;
                                break frameCheckLoops;
                            }
                        } else if (world.getBlockState(new BlockPos(scanX, y, scanZ)) != Blocks.AIR.getDefaultState()) {
                            validFrame = false;
                            break frameCheckLoops;
                        }
                    }
                }
            }

            /* Set portal blocks */
            if (validFrame) {
                IBlockState portalState = portal.getDefaultState();

                world.setBlockState(pos.add(1, 0, 1), portalState);
                world.setBlockState(pos.add(2, 0, 1), portalState);
                world.setBlockState(pos.add(3, 0, 1), portalState);
                world.setBlockState(pos.add(1, 0, 2), portalState);
                world.setBlockState(pos.add(2, 0, 2), portalState);
                world.setBlockState(pos.add(3, 0, 2), portalState);
                world.setBlockState(pos.add(1, 0, 3), portalState);
                world.setBlockState(pos.add(2, 0, 3), portalState);
                world.setBlockState(pos.add(3, 0, 3), portalState);
            }
        }
    }

}
