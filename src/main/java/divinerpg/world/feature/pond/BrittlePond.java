package divinerpg.world.feature.pond;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

import divinerpg.world.ConfiguredFeatureKeys;

public class BrittlePond extends GlacialPond {
	@Override
	protected void genDeep(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		if(random.nextFloat() < 0.15F) {
			setBlock(level, pos.above(), Blocks.LILY_PAD.defaultBlockState());
			pos = pos.below();
			setBlock(level, pos, Blocks.WATER.defaultBlockState());
		} else if(random.nextFloat() < 0.1F) {
			BlockState state = Blocks.BIG_DRIPLEAF_STEM.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true);
			setBlock(level, pos, state);
			setBlock(level, pos.above(), Blocks.BIG_DRIPLEAF.defaultBlockState());
			pos = pos.below();
			setBlock(level, pos, state);
		} else if(random.nextFloat() < 0.7F) {
			pos = pos.below();
			setBlock(level, pos, Blocks.WATER.defaultBlockState());
		}
		setBlock(level, pos.below(), random.nextFloat() < 0.6 ? Blocks.CLAY.defaultBlockState() : Blocks.GRAVEL.defaultBlockState());
	}
	@Override
	protected void genShallow(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		if(random.nextFloat() < 0.15F) setBlock(level, pos.above(), Blocks.LILY_PAD.defaultBlockState());
		else if(random.nextFloat() < 0.2F) {
			level.setBlock(pos, Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), 2);
			setBlock(level, pos.above(), Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER));
		}
		setBlock(level, pos.below(), random.nextFloat() < 0.3 ? Blocks.MOSS_BLOCK.defaultBlockState() : Blocks.CLAY.defaultBlockState());
	}
	@Override
	protected void genEdge(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		setBlock(level, pos, random.nextFloat() < 0.3 ? Blocks.CLAY.defaultBlockState() : Blocks.MOSS_BLOCK.defaultBlockState());
		ConfiguredFeature<?, ?> vegetation = ConfiguredFeatureKeys.getConfiguredFeature(level, ConfiguredFeatureKeys.BRITTLE_CAVES_VEGETATION).value();
		vegetation.place(level, null, random, pos.offset(random.nextInt(3) - 1, random.nextInt(3) - 1, random.nextInt(3) - 1));
		pos = pos.offset(random.nextInt(5) - 2, random.nextInt(3) - 1, random.nextInt(5) - 2);
		if(canSustain(rules, level, random, pos)) setBlock(level, pos, Blocks.MOSS_BLOCK.defaultBlockState());
		vegetation.place(level, null, random, pos.offset(random.nextInt(3) - 1, random.nextInt(3) - 1, random.nextInt(3) - 1));
		pos = pos.offset(random.nextInt(3) - 1, random.nextInt(3) - 1, random.nextInt(3) - 1);
		if(canSustain(rules, level, random, pos)) setBlock(level, pos, Blocks.MOSS_BLOCK.defaultBlockState());
		vegetation.place(level, null, random, pos.offset(random.nextInt(3) - 1, random.nextInt(3) - 1, random.nextInt(3) - 1));
	}
}