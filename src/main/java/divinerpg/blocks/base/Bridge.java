package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;

public class Bridge extends RedstoneLampBlock {
    public Bridge(Properties p) {super(p);}
    @Override public VoxelShape getCollisionShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return state.getValue(LIT) ? super.getCollisionShape(state, reader, pos, context) : Shapes.empty();
    }
}