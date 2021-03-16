package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class BlockModBridge extends BlockModPowered {
    public BlockModBridge(String name, float hardness) {
        super(name, Block.Properties
                .of(Material.GLASS)
                .strength(hardness, 3.0F)
                .requiresCorrectToolForDrops());
        //TODO - write lighting
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return state.getValue(POWERED) ? 15 : 0;
    }
//
//    @Nullable
//    @Override
//    public AxisAlignedBB getCollisionBoundingBox(BlockState blockState, World worldIn, BlockPos pos) {
//        return blockState.get(POWERED) ? blockState.getCollisionShape(worldIn, pos) : NULL_AABB;
//    }
//
//    @Override
//    public boolean isOpaqueCube(IBlockState state) {
//        return state.getValue(POWERED);
//    }
//
//    @Override
//    public boolean isFullCube(IBlockState state) {
//        return state.getValue(POWERED);
//    }
}
