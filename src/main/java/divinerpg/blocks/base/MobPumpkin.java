package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

import java.util.function.Supplier;

import static net.minecraft.sounds.SoundSource.BLOCKS;

public class MobPumpkin extends HorizontalDirectionalBlock {
    final Supplier<SoundEvent> sound;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public MobPumpkin(Properties properties, Supplier<SoundEvent> sound) {
        super(properties);
        this.sound = sound;
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, false));
    }
    @Override public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if((player.isCrouching() && !player.getMainHandItem().isEmpty()) || sound == null) return InteractionResult.PASS;
        level.playSound(player, pos, sound.get(), BLOCKS, 3, .9F + level.getRandom().nextFloat() * .2F);
        return InteractionResult.SUCCESS;
    }
    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean movedByPiston) {
        //TODO: to add some kind of delay in order to prevent sound spamming (for both redstone activation and manual usage)
        boolean flag = level.hasNeighborSignal(pos);
        if(flag != state.getValue(POWERED)) {
            if(flag && sound != null)
                level.playSound(null, pos, sound.get(), BLOCKS, 3,  .9F + level.getRandom().nextFloat() * .2F + (level.getBestNeighborSignal(pos) - 7) * .05F);
            level.setBlock(pos, state.setValue(POWERED, flag), 3);
        }
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(POWERED);
    }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}