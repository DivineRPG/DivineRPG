package divinerpg.blocks.iceika;

import divinerpg.blocks.base.BlockModMoss;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class BlockBrittleMoss extends BlockModMoss {
	public BlockBrittleMoss() {
		super(Block.Properties.copy(Blocks.MOSS_BLOCK).strength(0.6F, 2.0F));
	}
	@Override
	public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean b) {
		return level.getBlockState(pos.below()).isAir() || level.getBlockState(pos.above()).isAir();
	}
	@Override
	public void place(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		if(random.nextBoolean()) pos = pos.relative(Direction.getRandom(random));
		BlockState s = level.getBlockState(pos);
		if(s.is(BlockTags.MOSS_REPLACEABLE) || s.is(BlockTags.SNOW)) {
//			if(s.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_moss")))) ConfiguredFeatureRegistry.BRITTLE_PLANTS.place(level, null, random, pos);
//			else
				level.setBlock(pos, state, 3);
		}
	}
}