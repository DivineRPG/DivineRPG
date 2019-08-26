package divinerpg.objects.blocks.arcana;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.Config;
import divinerpg.enums.EnumBlockType;
import divinerpg.objects.blocks.BlockMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockArcanaPortalFrame extends BlockMod {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    protected static final AxisAlignedBB AABB_BLOCK = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D);

    protected Block portal;

    public BlockArcanaPortalFrame(String name, Block portal) {
        super(EnumBlockType.ROCK, name, 5.0F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
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
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
            float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { FACING });
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
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        worldIn.notifyNeighborsOfStateChange(pos, this, false);
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer,
            ItemStack stack) {
        world.setBlockState(pos, state, 3);
        if (placer instanceof EntityPlayerMP && placer.dimension != Config.arcanaDimensionId) {
            boolean validFrame = true;
            IBlockState northFaceState = this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
            IBlockState southFaceState = this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
            IBlockState eastFaceState = this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
            IBlockState westFaceState = this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
            int startX = pos.getX();
            int startZ = pos.getZ();
            int y = pos.getY();

            /* Find upper left hand corner of frame */
            if (world.getBlockState(new BlockPos(startX - 1, y, startZ)).getBlock() == this
                    || world.getBlockState(new BlockPos(startX + 1, y, startZ)).getBlock() == this) {
                while (world.getBlockState(new BlockPos(startX - 1, y, startZ)).getBlock() == this) {
                    startX--;
                }
                startX--;
                if (world.getBlockState(new BlockPos(startX, y, startZ - 1)).getBlock() == this) {
                    startZ = startZ - 4;
                }
            } else if (world.getBlockState(new BlockPos(startX, y, startZ - 1)).getBlock() == this
                    || world.getBlockState(new BlockPos(startX, y, startZ + 1)).getBlock() == this) {
                while (world.getBlockState(new BlockPos(startX, y, startZ - 1)).getBlock() == this) {
                    startZ--;
                }
                startZ--;
                if (world.getBlockState(new BlockPos(startX - 1, y, startZ)).getBlock() == this) {
                    startX = startX - 4;
                }
            }

            /* Check if it is a valid Arcana portal frame */
            frameCheckLoops: for (int scanZ = startZ; scanZ < startZ + 5; scanZ++) {
                if ((scanZ == startZ || scanZ == startZ + 4)) {
                    for (int scanX = startX + 1; scanX < startX + 4; scanX++) {
                        if (world.getBlockState(
                                new BlockPos(scanX, y, scanZ)) != (scanZ == startZ ? northFaceState : southFaceState)) {
                            validFrame = false;
                            break frameCheckLoops;
                        }
                    }
                } else {
                    for (int scanX = startX; scanX < startX + 5; scanX++) {
                        if (scanX == startX || scanX == startX + 4) {
                            if (world.getBlockState(new BlockPos(scanX, y, scanZ)) != (scanX == startX ? westFaceState :
                                    eastFaceState)) {
                                validFrame = false;
                                break frameCheckLoops;
                            }
                        } else if (world.getBlockState(new BlockPos(scanX, y, scanZ)) != Blocks.AIR.getDefaultState()
                                && world.getBlockState(new BlockPos(scanX, y, scanZ)) != portal.getDefaultState()) {
                            validFrame = false;
                            break frameCheckLoops;
                        }
                    }
                }
            }

            /* Set portal blocks */
            if (validFrame) {
                BlockPos inside = new BlockPos(startX, y, startZ);
                IBlockState portalState = portal.getDefaultState();

                world.setBlockState(inside.add(1, 0, 1), portalState);
                world.setBlockState(inside.add(2, 0, 1), portalState);
                world.setBlockState(inside.add(3, 0, 1), portalState);
                world.setBlockState(inside.add(1, 0, 2), portalState);
                world.setBlockState(inside.add(2, 0, 2), portalState);
                world.setBlockState(inside.add(3, 0, 2), portalState);
                world.setBlockState(inside.add(1, 0, 3), portalState);
                world.setBlockState(inside.add(2, 0, 3), portalState);
                world.setBlockState(inside.add(3, 0, 3), portalState);
            }
        }
    }
}
