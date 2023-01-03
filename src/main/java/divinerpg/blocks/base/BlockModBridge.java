package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.shapes.*;

public class BlockModBridge extends BlockModPowered {
    public BlockModBridge(float hardness) {
        super(Block.Properties
                .of(Material.GLASS)
                .strength(hardness, 3.0F)
                .requiresCorrectToolForDrops()
                .isViewBlocking(BlockModBridge::never)
                .noOcclusion()
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
