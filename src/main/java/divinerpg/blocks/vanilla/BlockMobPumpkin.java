package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.BlockHitResult;
import java.util.function.Supplier;

public class BlockMobPumpkin extends HorizontalDirectionalBlock {
    public static final MapCodec<BlockMobPumpkin> CODEC = simpleCodec(BlockMobPumpkin::new);
    private Supplier<SoundEvent> sound;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    @Override public MapCodec<BlockMobPumpkin> codec() {return CODEC;}
    public BlockMobPumpkin(Properties properties) {super(properties);}
    public BlockMobPumpkin(Supplier<SoundEvent> sound, MapColor color) {
        super(Block.Properties.of().strength(1).pushReaction(PushReaction.DESTROY).sound(SoundType.WOOD).instrument(NoteBlockInstrument.DIDGERIDOO).mapColor(color));
        this.sound = sound;
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    @Override public InteractionResult useWithoutItem(BlockState state, Level worldIn, BlockPos pos, Player player, BlockHitResult hit) {
        if((player.isCrouching() && !player.getMainHandItem().isEmpty()) || sound == null) return InteractionResult.PASS;
        worldIn.playSound(player, pos, sound.get(), SoundSource.BLOCKS, 3, 1);
        return InteractionResult.SUCCESS;
    }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(FACING);}
}