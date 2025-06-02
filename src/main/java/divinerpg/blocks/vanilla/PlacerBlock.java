package divinerpg.blocks.vanilla;

import divinerpg.util.Utils;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.*;
import net.neoforged.neoforge.common.util.FakePlayer;
import net.neoforged.neoforge.common.util.FakePlayerFactory;

public class PlacerBlock extends MinerBlock {
    @Override public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos p, boolean b) {
        if(level instanceof ServerLevel s) {
            boolean hasSignal = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above()), triggered = state.getValue(BlockStateProperties.TRIGGERED);
            if(triggered && !hasSignal) level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, false), UPDATE_NONE);
            else if(hasSignal && !triggered) {
                level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, true), 4);
                Direction facing = state.getValue(BlockStateProperties.FACING);
                p = pos.relative(facing);
                ItemStack stack;
                if(level.getBlockState(p).isAir() && s.getBlockEntity(pos.relative(facing.getOpposite())) instanceof Container c)
                    for(int i = 0; i < c.getContainerSize(); i++)
                        if(c.canTakeItem(Utils.EMPTY_CONTAINER, i, stack = c.getItem(i).copyWithCount(1)) && stack.getItem() instanceof BlockItem v) {
                    FakePlayer fp = FakePlayerFactory.get(s, Utils.FAKE_PLAYER);
                    float fl = facing.toYRot();
                    fp.setPos(Vec3.atCenterOf(pos));
                    fp.setYRot(fp.yRotO = fl);
                    fp.setYBodyRot(fp.yBodyRotO = fl);
                    fp.setYHeadRot(fp.yHeadRotO = fl);
                    fp.setXRot(fp.yRotO = facing == Direction.UP ? -90 : facing == Direction.DOWN ? 90 : 0);
                    v.place(new BlockPlaceContext(s, fp, InteractionHand.MAIN_HAND, stack, new BlockHitResult(Vec3.atCenterOf(pos), facing, p, false)));
                    c.removeItem(i, 1);
                    break;
                }
            }
        }
    }
}
