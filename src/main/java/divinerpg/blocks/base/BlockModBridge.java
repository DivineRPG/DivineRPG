package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;

public class BlockModBridge extends BlockModPowered {
    public BlockModBridge(String name, float hardness) {
        super(name, Block.Properties
                .of(Material.GLASS)
                .strength(hardness, 3.0F)
                .requiresCorrectToolForDrops());
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return blockState.getValue(POWERED) ? super.getCollisionShape(blockState, reader, pos, context) : VoxelShapes.empty();
    }
}
