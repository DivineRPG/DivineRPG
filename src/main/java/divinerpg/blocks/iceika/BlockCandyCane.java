package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import static net.minecraft.world.level.block.state.properties.NoteBlockInstrument.BASEDRUM;
import static net.minecraft.world.level.material.PushReaction.PUSH_ONLY;

public class BlockCandyCane extends HorizontalDirectionalBlock {
    public static final MapCodec<BlockCandyCane> CODEC = simpleCodec(BlockCandyCane::new);
    @Override public MapCodec<BlockCandyCane> codec() {return CODEC;}
    public BlockCandyCane(Properties properties) {
        super(properties.strength(.75F).instrument(BASEDRUM).sound(SoundType.CALCITE).pushReaction(PUSH_ONLY));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(FACING);}
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());}
}