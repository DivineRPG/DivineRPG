package divinerpg.blocks.vanilla;

import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.redstone.Orientation;
import org.jspecify.annotations.Nullable;

import static divinerpg.registries.TagRegistry.MINEABLE_WITH_SHICKAXE;
import static net.minecraft.tags.BlockTags.INCORRECT_FOR_DIAMOND_TOOL;

public class MinerBlock extends Block {
    public MinerBlock(Properties p) {
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
        if(level instanceof ServerLevel s) {
            boolean hasSignal = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above()), triggered = state.getValue(BlockStateProperties.TRIGGERED);
            if(triggered && !hasSignal) level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, false), UPDATE_NONE);
            else if(hasSignal && !triggered) {
                level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, true), 4);
                BlockPos p = pos.relative(state.getValue(BlockStateProperties.FACING));
                if(!s.getBlockState(p).is(INCORRECT_FOR_DIAMOND_TOOL) && s.getBlockState(p).is(MINEABLE_WITH_SHICKAXE)) s.destroyBlock(p, true);
            }
        }
    }
    //TODO: appendHovertext
//    @OnlyIn(CLIENT)
//    @Override public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
//        super.appendHoverText(stack, context, tooltip, flagIn);
//        if(stack.getItem() != placer.asItem()) {
//            tooltip.add(1, LocalizeUtils.efficiency("∞"));
//            tooltip.add(LocalizeUtils.harvestLevel(Component.literal(Items.OBSIDIAN.getName(stack).getString()).withColor(5257328)));
//        }
//    }
}