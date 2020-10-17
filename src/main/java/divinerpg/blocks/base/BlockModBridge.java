package divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockModBridge extends BlockModPowered {
    public BlockModBridge(String name, float hardness) {
        super(name, Block.Properties
                .create(Material.GLASS)
                .hardnessAndResistance(hardness, 3.0F)
                .func_235861_h_());
        //TODO - write lighting
    }

//    @Override
//    public int getLightValue(BlockState state, World world, BlockPos pos) {
//        return state.get(POWERED) ? 15 : 0;
//    }
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
