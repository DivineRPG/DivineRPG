package divinerpg.blocks.base;

import divinerpg.block_entities.bosses.StatueBlockEntity;
import net.minecraft.core.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.Nullable;
import java.util.function.Supplier;

import static net.minecraft.sounds.SoundSource.BLOCKS;

public class BlockStatue extends BlockMod implements EntityBlock {
    private static final int ROTATIONS = RotationSegment.getMaxSegmentIndex() + 1;
    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
    private final Supplier<SoundEvent> statueSound;
    public BlockStatue(Supplier<SoundEvent> soundIn) {
        super(Properties.of().strength(2, 6).noOcclusion().requiresCorrectToolForDrops());
        statueSound = soundIn;
        registerDefaultState(defaultBlockState().setValue(ROTATION, 0));
    }
    @Override public boolean skipRendering(BlockState state, BlockState state1, Direction dir) {return true;}
    @Nullable
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return new StatueBlockEntity(pos, state);}
    @Override public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult trace) {
        if((player.isCrouching() && !player.getMainHandItem().isEmpty()) || statueSound == null) return InteractionResult.PASS;
        world.playSound(player, pos, statueSound.get(), BLOCKS, 3, 1);
        return InteractionResult.SUCCESS;
    }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(ROTATION, RotationSegment.convertToSegment(context.getRotation()));
    }
    @Override protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(ROTATION, rotation.rotate(state.getValue(ROTATION), ROTATIONS));
    }
    @Override protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.setValue(ROTATION, mirror.mirror(state.getValue(ROTATION), ROTATIONS));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(ROTATION);
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return Shapes.create(new AABB(.2, 0, .2, .8, 1, .8));
    }
}