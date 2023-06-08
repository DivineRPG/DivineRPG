package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;

public class BlockModBridge extends BlockModPowered {
    public BlockModBridge() {
        super(Block.Properties
                .of()
                .strength(0.3F)
                .isViewBlocking(BlockModBridge::never)
                .noOcclusion()
                .sound(SoundType.GLASS)
        );
    }
    private static boolean never(BlockState state, BlockGetter reader, BlockPos pos) {
        return false;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    @SuppressWarnings("deprecation")
	@Override
    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return blockState.getValue(POWERED) ? super.getCollisionShape(blockState, reader, pos, context) : Shapes.empty();
    }


}
