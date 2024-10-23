package divinerpg.world.feature.tree;

import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class DivineTree extends Feature<TreeConfig> {
	public DivineTree() {
		super(TreeConfig.CODEC);
	}
	public boolean hasSpace(WorldGenLevel level, BlockPos pos) {
		BlockState state = level.getBlockState(pos);
		return hasSpace(state);
	}
	public boolean hasSpace(BlockState state) {
		return state.isAir() || state.is(BlockTags.LEAVES) || state.is(BlockTags.FLOWERS) || state.is(BlockTags.REPLACEABLE_BY_TREES) && !state.is(Blocks.WATER);
	}
	public final boolean heightCheck(WorldGenLevel level, BlockPos pos, int maxHeight, int width) {
		for(int y = 0; y < maxHeight; y++) {
			if(level.isOutsideBuildHeight(pos.offset(0, y, 0))) return false;
			for(int x = 0; x < width; x++) for(int z = 0; z < width; z++) if(!hasSpace(level, pos.offset(x, y, z))) return false;
		}
		return true;
	}
	public boolean canBeHere(WorldGenLevel level, RandomSource random, BlockPos pos, TreeConfig config) {
		if(hasSpace(level, pos)) {
			BlockState state = level.getBlockState(pos.below());
			if(config.growableOn.isEmpty() && defaultGrowOn(state)) return true;
			for(RuleTest test : config.growableOn) if(test.test(state, random)) return true;
			return false;
		}
		return false;
	}
	/**
	 * Only called when config.growableOn is empty.
	 * Override to set the default blocks the tree can grow on.
	 * @param state the BlockState below origin
	 * @return if state is a default block the tree can grow on
	 */
	protected boolean defaultGrowOn(BlockState state) {
		return state.is(BlockTags.DIRT);
	}
	protected void setBlock(WorldGenLevel level, BlockPos pos, BlockState state, boolean replace) {
		BlockState block = level.getBlockState(pos);
		if(hasSpace(block) || (replace && !block.is(Blocks.BEDROCK))) setBlock(level, pos, state);
	}
	protected void setBlockSensitive(WorldGenLevel level, RandomSource random, BlockPos pos, BlockState state, float chance) {
		if(random.nextFloat() <= chance && level.getBlockState(pos).isAir()) setBlock(level, pos, state);
	}
	protected void chanceSetBlock(WorldGenLevel level, RandomSource random, BlockPos pos, BlockState state, float chance) {
		if(random.nextFloat() <= chance) setBlock(level, pos, state, false);
	}
	protected void chanceSetBlock(WorldGenLevel level, RandomSource random, BlockPos pos, BlockState state, float chance, boolean replace) {
		if(random.nextFloat() <= chance) setBlock(level, pos, state, replace);
	}
	protected void grow(WorldGenLevel world, BlockPos pos, BlockState state, int width, int offset) {
		grow(world, pos, state, width, offset, false);
	}
	protected void grow(WorldGenLevel world, BlockPos pos, BlockState state, int width, int offset, boolean replace) {
    	setBlock(world, pos.offset(width, 0, offset), state, replace);
		setBlock(world, pos.offset(-width, 0, -offset), state, replace);
		setBlock(world, pos.offset(offset, 0, -width), state, replace);
		setBlock(world, pos.offset(-offset, 0, width), state, replace);
    }
	protected void grow(WorldGenLevel world, RandomSource random, BlockPos pos, BlockState state, int width, int offset, float chance) {
		grow(world, random, pos, state, width, offset, false, chance);
	}
	protected void grow(WorldGenLevel world, RandomSource random, BlockPos pos, BlockState state, int width, int offset, boolean replace, float chance) {
    	chanceSetBlock(world, random, pos.offset(width, 0, offset), state, chance, replace);
		chanceSetBlock(world, random, pos.offset(-width, 0, -offset), state, chance, replace);
		chanceSetBlock(world, random, pos.offset(offset, 0, -width), state, chance, replace);
		chanceSetBlock(world, random, pos.offset(-offset, 0, width), state, chance, replace);
    }
	protected void grow(WorldGenLevel world, BlockPos pos, BlockState state, int maxY) {
		grow(world, pos, state, maxY, false);
	}
	protected void grow(WorldGenLevel world, BlockPos pos, BlockState state, int maxY, boolean replace) {
    	for(int minY = 0; minY <= maxY; minY++) setBlock(world, pos.offset(0, minY, 0), state, replace);
	}
	protected void grow(WorldGenLevel world, RandomSource random, BlockPos pos, BlockState state, int maxY, float chance) {
		grow(world, random, pos, state, maxY, false, chance);
	}
	protected void grow(WorldGenLevel world, RandomSource random, BlockPos pos, BlockState state, int maxY, boolean replace, float chance) {
    	for(int minY = 0; minY <= maxY; minY++) chanceSetBlock(world, random, pos.offset(0, minY, 0), state, chance, replace);
	}
	protected void grow(WorldGenLevel world, BlockPos pos, BlockState state, int maxY, int width, int offset) {
		grow(world, pos, state, maxY, width, offset, false);
	}
	protected void grow(WorldGenLevel world, BlockPos pos, BlockState state, int maxY, int width, int offset, boolean replace) {
		for(int minY = 0; minY <= maxY; minY++) {
    		setBlock(world, pos.offset(width, minY, offset), state, replace);
    		setBlock(world, pos.offset(-width, minY, -offset), state, replace);
    		setBlock(world, pos.offset(offset, minY, -width), state, replace);
    		setBlock(world, pos.offset(-offset, minY, width), state, replace);
    	}
	}
	protected void grow(WorldGenLevel world, RandomSource random, BlockPos pos, BlockState state, int maxY, int width, int offset, float chance) {
		grow(world, random, pos, state, maxY, width, offset, false, chance);
	}
	/**
     * sets the given block on all four sides if all conditions are met
     * @param pos the center of which the width and offset will be applied relative to
     * @param state the block to grow
     * @param maxY (inclusive) to end growing at relative to {@code pos}.
     * @param width the tree width offset
     * @param offset note that {@code (width, offset) = (offset, -width)}
     * @param chance of setting a block at a position. {@code 1} = will always set block
     */
    protected void grow(WorldGenLevel world, RandomSource random, BlockPos pos, BlockState state, int maxY, int width, int offset, boolean replace, float chance) {
    	for(int minY = 0; minY <= maxY; minY++) {
    		chanceSetBlock(world, random, pos.offset(width, minY, offset), state, chance, replace);
    		chanceSetBlock(world, random, pos.offset(-width, minY, -offset), state, chance, replace);
    		chanceSetBlock(world, random, pos.offset(offset, minY, -width), state, chance, replace);
    		chanceSetBlock(world, random, pos.offset(-offset, minY, width), state, chance, replace);
    	}
    }
	@Override
	public boolean place(FeaturePlaceContext<TreeConfig> context) {
		return place(context.config(), context.level(), context.chunkGenerator(), context.random(), context.origin());
	}
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			int treeHeight = 3 + random.nextInt(3), extraHeight = treeHeight + 1;
			if(heightCheck(level, pos, extraHeight, 1)) {
				BlockState log = config.log, leaves = config.leaves;
				grow(level, pos, log, treeHeight);
				setBlock(level, pos.offset(0, extraHeight, 0), leaves);
				BlockPos temp = pos.offset(0, treeHeight - 2, 0);
            	grow(level, temp, leaves, 1, 1, 1);
            	grow(level, temp, leaves, 3, 1, 0);
				for(int offset = -1; offset < 2; offset++) grow(level, temp, leaves, 1, 2, offset);
            	grow(level, random, temp, leaves, 1, 2, 2, 0.5F);
            	grow(level, random, pos.offset(0, treeHeight, 0), leaves, 1, 1, 0.5F);
            	return true;
			}
		}
		return false;
	}
}