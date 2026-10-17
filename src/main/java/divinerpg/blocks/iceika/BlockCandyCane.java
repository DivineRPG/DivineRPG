package divinerpg.blocks.iceika;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.PushReaction;

import static net.minecraft.world.level.block.state.properties.NoteBlockInstrument.BASEDRUM;

public class BlockCandyCane extends HorizontalDirectionalBlock {
    public BlockCandyCane(Properties properties) {
        super(properties.strength(.75F).instrument(BASEDRUM).sound(SoundType.CALCITE).pushReaction(PushReaction.POPPED));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(FACING);}
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());}
}