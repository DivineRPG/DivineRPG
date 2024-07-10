package divinerpg.world.feature.tree;

import divinerpg.registries.BlockRegistry;
import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.*;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class FirewoodTree extends SkythernTree {
	protected Direction direction;
	protected void directionalWideGrow(WorldGenLevel world, BlockPos pos, BlockState state, int width, int offset) {
		if(direction == Direction.UP || direction == Direction.DOWN) wideGrow(world, pos, state, width, offset);
		else if(direction == Direction.NORTH || direction == Direction.SOUTH) {
			setBlock(world, pos.offset(offset, width + 1, 0), state);
			setBlock(world, pos.offset(1 - offset, -width, 0), state);
			setBlock(world, pos.offset(-width, offset, 0), state);
			setBlock(world, pos.offset(width + 1, 1 - offset, 0), state);
		} else {
			setBlock(world, pos.offset(0, width + 1, offset), state);
			setBlock(world, pos.offset(0, -width, 1 - offset), state);
			setBlock(world, pos.offset(0, offset, -width), state);
			setBlock(world, pos.offset(0, 1 - offset, width + 1), state);
		}
	}
	@Override
	public boolean canBeHere(WorldGenLevel level, RandomSource random, BlockPos pos, TreeConfig config) {
		BlockState state = level.getBlockState(pos);
		if(config.growableOn.isEmpty() && defaultGrowOn(state)) return searchForSpace(level, random, pos);
		for(RuleTest test : config.growableOn) if(test.test(state, random)) return searchForSpace(level, random, pos);
		return false;
	}
	protected boolean searchForSpace(WorldGenLevel level, RandomSource random, BlockPos pos) {
		for(Direction dir : Direction.values()) {
			direction = dir;
			if(level.getBlockState(pos.relative(direction)).isAir()) return true;
		}
		return false;
	}
	@Override
	protected boolean defaultGrowOn(BlockState state) {
		return state.is(BlockRegistry.dreamStone.get()) || state.is(BlockTags.DIRT);
	}
	protected void placeBigTree(TreeConfig config, WorldGenLevel level, RandomSource random, BlockPos pos) {
		int treeHeight = 5 + random.nextInt(8);
		wideGrow(level, pos, config.log, treeHeight, 0, 0);
		pos = pos.offset(0, treeHeight, 0);
		wideGrow(level, pos, config.leaves, 2, 0, 0);
		wideGrow(level, pos, config.leaves, 1, 1, 0);
		wideGrow(level, pos, config.leaves, 1, 1, 1);
		wideGrow(level, pos, config.leaves, 1, 1, 2);
		wideGrow(level, pos, config.leaves, 2, -1);
		wideGrow(level, pos, config.leaves, 2, 0);
		wideGrow(level, pos, config.leaves, 2, 1);
		wideGrow(level, pos, config.leaves, 2, 2);
		wideGrow(level, pos, config.leaves, 2, 3);
		MutableBlockPos mutable = pos.mutable();
		while(random.nextBoolean() && treeHeight > 0) {
			mutable.move(Direction.DOWN);
			if(random.nextBoolean()) wideGrow(level, mutable, config.leaves, 2, -1);
			if(random.nextBoolean()) wideGrow(level, mutable, config.leaves, 2, 0);
			if(random.nextBoolean()) wideGrow(level, mutable, config.leaves, 2, 1);
			if(random.nextBoolean()) wideGrow(level, mutable, config.leaves, 2, 2);
			if(random.nextBoolean()) wideGrow(level, mutable, config.leaves, 2, 3);
			treeHeight--;
		}
	}
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			if(direction == Direction.UP && random.nextInt(8) == 0) placeBigTree(config, level, random, pos);
			else if(random.nextInt(3) == 0) {
				for(int size = 0; size < 3 + random.nextInt(5); size++) {
					pos = pos.relative(direction);
					directionalWideGrow(level, pos, config.log, 0, 0);
					if(random.nextFloat() < 0.2F) direction = Direction.getRandom(random);
				}
				directionalWideGrow(level, pos, config.leaves, 1, 0);
				directionalWideGrow(level, pos, config.leaves, 1, 1);
				pos = pos.relative(direction);
				directionalWideGrow(level, pos, config.leaves, 0, 0);
				setBlock(level, pos.relative(Direction.getRandom(random)), config.leaves, false);
				setBlock(level, pos.relative(direction), config.leaves, false);
			} else {
				for(int size = 0; size < 3 + random.nextInt(9); size++) {
					pos = pos.relative(direction);
					setBlock(level, pos, config.log, true);
					if(random.nextFloat() < 0.3F) direction = Direction.getRandom(random);
				}
				setBlock(level, pos.above(), config.leaves, false);
				setBlock(level, pos.north(), config.leaves, false);
				setBlock(level, pos.east(), config.leaves, false);
				setBlock(level, pos.south(), config.leaves, false);
				setBlock(level, pos.west(), config.leaves, false);
				setBlock(level, pos.below(), config.leaves, false);
			}
			return true;
		}
		return false;
	}
}