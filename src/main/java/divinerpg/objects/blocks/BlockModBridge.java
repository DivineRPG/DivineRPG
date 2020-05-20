package divinerpg.objects.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockModBridge extends BlockModPowered {

    public BlockModBridge(String name, float hardness) {
        super(name, hardness, Material.GLASS);
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

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return state.getValue(POWERED);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return state.getValue(POWERED);
    }
}