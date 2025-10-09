package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;

import static net.minecraft.world.level.block.Blocks.REDSTONE_LAMP;

public class BlockModBridge extends BlockModPowered {
    public BlockModBridge() {super(Properties.ofFullCopy(REDSTONE_LAMP).noOcclusion().lightLevel((state) -> state.getValue(POWERED) ? 15 : 0));}
	@Override public VoxelShape getCollisionShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return state.getValue(POWERED) ? super.getCollisionShape(state, reader, pos, context) : Shapes.empty();
    }
}