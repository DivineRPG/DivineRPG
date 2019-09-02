package divinerpg.objects.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import divinerpg.enums.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockModBridge extends BlockMod {
    public static final PropertyBool POWERED = PropertyBool.create("powered");

    public BlockModBridge(String name) {
        super(EnumBlockType.GLASS, name, 1.5F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(POWERED, false));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { POWERED });
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return meta == 0 ? this.getDefaultState() : this.getDefaultState().withProperty(POWERED, true);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(POWERED) ? 1 : 0;
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        handleBlockState(state, worldIn, pos);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        handleBlockState(state, worldIn, pos);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        handleBlockState(state, worldIn, pos);
    }

    public void handleBlockState(IBlockState state, World worldIn, BlockPos pos) {
        if (!worldIn.isRemote) {
            if (state.getValue(POWERED) && !worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, this.getDefaultState(), 2);
            } else if (!state.getValue(POWERED) && worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, this.getDefaultState().withProperty(POWERED, true), 2);
            }
        }
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return blockState.getValue(POWERED) ? blockState.getBoundingBox(worldIn, pos) : NULL_AABB;
    }

    //@Override
    //public boolean causesSuffocation(IBlockState state) {
    //    return state.getValue(POWERED);
    //}

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return state.getValue(POWERED);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return state.getValue(POWERED);
    }
}