package divinerpg.objects.blocks;

import divinerpg.enums.StatueType;
import divinerpg.objects.blocks.tile.entity.TileEntityStatue;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStatue extends BlockMod implements ITileEntityProvider {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public StatueType statueType;

    public BlockStatue(String name, StatueType statueType) {
        super(name, 6.0F, Material.ROCK);
        this.statueType = statueType;
        this.hasTileEntity = true;
        setHarvestLevel("pickaxe", 0);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityStatue(this.statueType);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @Override
    @Deprecated
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    @Deprecated
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
                                            float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    @Deprecated
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        this.setDefaultFacing(worldIn, pos, state);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
                                ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            EnumFacing enumfacing = state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock()) {
                enumfacing = EnumFacing.SOUTH;
            } else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock()) {
                enumfacing = EnumFacing.NORTH;
            } else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock()) {
                enumfacing = EnumFacing.EAST;
            } else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock()) {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }

    @Override
    @Deprecated
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    @Override
    @Deprecated
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    public static final AxisAlignedBB WATCHER_AABB = new AxisAlignedBB(0.3F, 0.0F, 0.3F, 0.7F, 0.5F, 0.7F);
    public static final AxisAlignedBB AYERACO_AABB = new AxisAlignedBB(0.2F, 0.0F, 0.20F, 0.8F, 0.4F, 0.8F);
    public static final AxisAlignedBB TWILIGHT_DEMON_AABB = new AxisAlignedBB(0.2F, 0.0F, 0.20F, 0.8F, 1.0F, 0.8F);
    public static final AxisAlignedBB VAMACHERON_AABB = new AxisAlignedBB(0.2F, 0.0F, 0.20F, 0.8F, 0.7F, 0.8F);
    public static final AxisAlignedBB PARASECTA_AABB = new AxisAlignedBB(0.2F, 0.2F, 0.20F, 0.8F, 1.0F, 0.8F);
    public static final AxisAlignedBB SOUL_FIEND_AABB = new AxisAlignedBB(0.2F, 0.0F, 0.20F, 0.8F, 1.0F, 0.8F);

    @SuppressWarnings("incomplete-switch")
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

        if (statueType != null) {
            switch (this.statueType) {
                case RED_AYERACO_STATUE:
                case BLUE_AYERACO_STATUE:
                case GREEN_AYERACO_STATUE:
                case PURPLE_AYERACO_STATUE:
                case YELLOW_AYERACO_STATUE:
                    return AYERACO_AABB;

                case THE_WATCHER_STATUE:
                    return WATCHER_AABB;

                case TWILIGHT_DEMON_STATUE:
                    return TWILIGHT_DEMON_AABB;

                case VAMACHERON_STATUE:
                    return VAMACHERON_AABB;

                case PARASECTA_STATUE:
                    return PARASECTA_AABB;

                case SOUL_FIEND_STATUE:
                    return SOUL_FIEND_AABB;
            }
        }

        return FULL_BLOCK_AABB;
    }
}
