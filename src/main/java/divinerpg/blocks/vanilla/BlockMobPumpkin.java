package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import java.util.function.Supplier;

import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.world.level.block.Blocks.PUMPKIN;

public class BlockMobPumpkin extends HorizontalDirectionalBlock {
    public static final MapCodec<BlockMobPumpkin> CODEC = simpleCodec(BlockMobPumpkin::new);
    @Override public MapCodec<BlockMobPumpkin> codec() {return CODEC;}
    private Supplier<SoundEvent> sound;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public BlockMobPumpkin(Properties properties) {super(properties);}
    public BlockMobPumpkin(Supplier<SoundEvent> sound, MapColor color) {
        super(Properties.ofFullCopy(PUMPKIN).mapColor(color));
        this.sound = sound;
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(FACING).add(POWERED);}
    @Override public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if((player.isCrouching() && !player.getMainHandItem().isEmpty()) || sound == null) return InteractionResult.PASS;
        level.playSound(player, pos, sound.get(), BLOCKS, 3, .9F + level.getRandom().nextFloat() * .2F);
        return InteractionResult.SUCCESS;
    }
    @Override protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        //TODO: to add some kind of delay in order to prevent sound spamming (for both redstone activation and manual usage)
        boolean flag = level.hasNeighborSignal(pos);
        if(flag != state.getValue(POWERED)) {
            if(flag && sound != null) {
                level.playSound(null, pos, sound.get(), BLOCKS, 3,  .9F + level.getRandom().nextFloat() * .2F + (level.getBestNeighborSignal(pos) - 7) * .05F);
            } level.setBlock(pos, state.setValue(POWERED, flag), 3);
        }
    }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());}
    @Override public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {return true;}
}