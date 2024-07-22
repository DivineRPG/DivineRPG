package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.*;

public class BlockCandyCane extends HorizontalDirectionalBlock {
	public static final MapCodec<BlockCandyCane> CODEC = simpleCodec(BlockCandyCane::new);
	@Override public MapCodec<BlockCandyCane> codec() {return CODEC;}
	public BlockCandyCane(Properties properties) {
		super(properties.instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(.75F).pushReaction(PushReaction.PUSH_ONLY));
	}
	@Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {p_53681_.add(FACING);}
	@Override public BlockState getStateForPlacement(BlockPlaceContext p_53679_) {return this.defaultBlockState().setValue(FACING, p_53679_.getHorizontalDirection().getOpposite());}
}