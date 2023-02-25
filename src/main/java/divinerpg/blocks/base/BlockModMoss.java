package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.MossBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BlockModMoss extends MossBlock {
	public BlockModMoss(Properties properties) {
		super(properties);
	}
	@Override
	public boolean isValidBonemealTarget(BlockGetter level, BlockPos pos, BlockState state, boolean b) {
		return level.getBlockState(pos.below()).isAir();
	}
	@Override
	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		BlockState myState = this.defaultBlockState();
		place(level, random, pos.above(), myState);
		place(level, random, pos.below(), myState);
		place(level, random, pos.north(), myState);
		place(level, random, pos.east(), myState);
		place(level, random, pos.south(), myState);
		place(level, random, pos.west(), myState);
	}
	public void place(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		if(random.nextBoolean()) pos = pos.relative(Direction.getRandom(random));
		if(level.getBlockState(pos).is(BlockTags.MOSS_REPLACEABLE)) level.setBlock(pos, state, 3);
	}
}