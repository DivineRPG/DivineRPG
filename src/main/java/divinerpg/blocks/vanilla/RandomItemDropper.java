package divinerpg.blocks.vanilla;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.redstone.Orientation;
import org.jspecify.annotations.Nullable;

import java.util.Set;

import static net.minecraft.sounds.SoundEvents.DISPENSER_DISPENSE;
import static net.minecraft.sounds.SoundSource.BLOCKS;

public class RandomItemDropper extends Block {
    public RandomItemDropper(Properties p) {
        super(p);
        registerDefaultState(stateDefinition.any().setValue(DirectionalBlock.FACING, Direction.NORTH).setValue(BlockStateProperties.TRIGGERED, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DirectionalBlock.FACING, BlockStateProperties.TRIGGERED);
    }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(DirectionalBlock.FACING, context.getNearestLookingDirection().getOpposite());
    }
    @Override public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(DirectionalBlock.FACING, rot.rotate(state.getValue(DirectionalBlock.FACING)));
    }
    @Override public BlockState mirror(BlockState state, Mirror mir) {
        return rotate(state, mir.getRotation(state.getValue(DirectionalBlock.FACING)));
    }
    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean movedByPiston) {
        if(!level.isClientSide()) {
            boolean hasSignal = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above()), triggered = state.getValue(BlockStateProperties.TRIGGERED);
            if(triggered && !hasSignal) level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, false), UPDATE_NONE);
            else if(hasSignal && !triggered) {
                level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, true), 4);
                Set<Identifier> keys = BuiltInRegistries.ITEM.keySet();
                Direction dir = state.getValue(DirectionalBlock.FACING);
                ItemEntity i = new ItemEntity(level, pos.getX() + dir.getStepX() + .5, pos.getY() + dir.getStepY(), pos.getZ() + dir.getStepZ() + .5, new ItemStack(BuiltInRegistries.ITEM.getValue((Identifier) keys.toArray()[level.getRandom().nextInt(keys.size())])));
                i.setDeltaMovement(i.getDeltaMovement().add(dir.getStepX() * .5, dir.getStepY() * .5, dir.getStepZ() * .5));
                level.addFreshEntity(i);
                level.playSound(null, pos, DISPENSER_DISPENSE, BLOCKS);
            }
        }
    }
}