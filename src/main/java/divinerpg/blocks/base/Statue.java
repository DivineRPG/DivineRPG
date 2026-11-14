package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.*;

import java.util.function.Supplier;

import static net.minecraft.sounds.SoundSource.BLOCKS;

public class Statue extends HorizontalDirectionalBlock {
    private static final int ROTATIONS = RotationSegment.getMaxSegmentIndex() + 1;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    private final Supplier<SoundEvent> statueSound;
    public Statue(Properties p, Supplier<SoundEvent> soundIn) {
        super(p);
        statueSound = soundIn;
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, false));
    }
    @Override public boolean skipRendering(BlockState state, BlockState state1, Direction dir) {return true;}
    @Override public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult trace) {
        if((player.isCrouching() && !player.getMainHandItem().isEmpty()) || statueSound == null) return InteractionResult.PASS;
        level.playSound(player, pos, statueSound.get(), BLOCKS, 3, .9F + level.getRandom().nextFloat() * .2F);
        return InteractionResult.SUCCESS;
    }
    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @org.jspecify.annotations.Nullable Orientation orientation, boolean movedByPiston) {
        //TODO: to add some kind of delay in order to prevent sound spamming (for both redstone activation and manual usage)
        boolean flag = level.hasNeighborSignal(pos);
        if(flag != state.getValue(POWERED)) {
            if(flag && statueSound != null)
                level.playSound(null, pos, statueSound.get(), BLOCKS, 3,  .9F + level.getRandom().nextFloat() * .2F + (level.getBestNeighborSignal(pos) - 7) * .05F);
            level.setBlock(pos, state.setValue(POWERED, flag), 3);
        }
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(POWERED);
    }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return Shapes.create(new AABB(.2, 0, .2, .8, 1, .8));
    }
}