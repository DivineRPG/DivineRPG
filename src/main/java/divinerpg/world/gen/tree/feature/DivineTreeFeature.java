package divinerpg.world.gen.tree.feature;

import net.minecraft.block.*;
import net.minecraft.tags.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;

import java.util.*;
import java.util.function.*;

public abstract class DivineTreeFeature extends Feature<BlockStateFeatureConfig> {
    protected final Supplier<SaplingBlock> sapling;

    public DivineTreeFeature(Supplier<SaplingBlock> sapling) {
        super(BlockStateFeatureConfig.CODEC);
        this.sapling = sapling;
    }

    @Override
    public boolean place(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
        return gen(reader, rand, pos);
    }

    protected abstract boolean gen(ISeedReader reader, Random rand, BlockPos pos);

    protected void setBlock(ISeedReader world, BlockPos pos, BlockState state) {
        setBlock(world, pos, state, false);
    }
    protected void setBlock(ISeedReader world, BlockPos pos, BlockState state, boolean replace) {
        if ((replace && world.getBlockState(pos) != Blocks.BEDROCK.defaultBlockState()) || hasSpace(world, pos)) {
        	world.setBlock(pos, state, 0);
        }
    }
    protected void chanceSetBlock(ISeedReader world, BlockPos pos, BlockState state, int chance, boolean replace) {
        if(world.getRandom().nextInt(chance) == 0){
        	setBlock(world, pos, state, replace);
        }
    }
    protected void setBlockSensitive(ISeedReader world, BlockPos pos, BlockState state, int chance) {
    	if(world.getRandom().nextInt(chance) == 0 && isAir(world, pos)) {
    		world.setBlock(pos, state, 0);
    	}
    }
    protected void growStar(ISeedReader world, BlockPos pos, BlockState firstState, BlockState secondState, int y, int width, int offset) {
    	setBlock(world, pos.offset(width, y, offset), firstState, false);
    	grow(world, pos.offset(width, y, offset), secondState, y, 1, 0);
		setBlock(world, pos.offset(-width, y, -offset), firstState, false);
		grow(world, pos.offset(-width, y, -offset), secondState, y, 1, 0);
		setBlock(world, pos.offset(offset, y, -width), firstState, false);
		grow(world, pos.offset(offset, y, -width), secondState, y, 1, 0);
		setBlock(world, pos.offset(-offset, y, width), firstState, false);
		grow(world, pos.offset(-offset, y, width), secondState, y, 1, 0);
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY) {
    	grow(world, pos, state, minY, maxY, 0, 0, false, 1);
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY, boolean replace) {
    	grow(world, pos, state, minY, maxY, 0, 0, replace, 1);
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY, boolean replace, int chance) {
    	grow(world, pos, state, minY, maxY, 0, 0, replace, chance);
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int y, int width, int offset) {
    	grow(world, pos, state, y, width, offset, false, 1);
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int y, int width, int offset, boolean replace) {
    	grow(world, pos, state, y, width, offset, replace, 1);
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int y, int width, int offset, boolean replace, int chance) {
    	chanceSetBlock(world, pos.offset(width, y, offset), state, chance, replace);
		chanceSetBlock(world, pos.offset(-width, y, -offset), state, chance, replace);
		chanceSetBlock(world, pos.offset(offset, y, -width), state, chance, replace);
		chanceSetBlock(world, pos.offset(-offset, y, width), state, chance, replace);
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY, int width, int offset) {
    	grow(world, pos, state, minY, maxY, width, offset, false, 1);
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY, int width, int offset, int chance) {
    	grow(world, pos, state, minY, maxY, width, offset, false, chance);
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY, int width, int offset, boolean replace) {
    	grow(world, pos, state, minY, maxY, width, offset, replace, 1);
    }
    /**
     * sets the given block on all four sides if all conditions are met
     * @param world
     * @param pos the position of origin (the center)
     * @param state the block to grow
     * @param minY to start growing at relative to {@code pos}
     * @param maxY (inclusive) to end growing at relative to {@code pos}.
     * @param width
     * @param offset note that {@code (width, offset) = (offset, -width)}
     * @param chance of setting a block at a position with chance {@code 1/chance}. {@code 0 or 1} = will always set block
     */
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY, int width, int offset, boolean replace, int chance) {
    	maxY++;
    	for(; minY < maxY; minY++) {
    		chanceSetBlock(world, pos.offset(width, minY, offset), state, chance, replace);
    		chanceSetBlock(world, pos.offset(-width, minY, -offset), state, chance, replace);
    		chanceSetBlock(world, pos.offset(offset, minY, -width), state, chance, replace);
    		chanceSetBlock(world, pos.offset(-offset, minY, width), state, chance, replace);
    	}
    }
    protected static boolean hasSpace(ISeedReader world, BlockPos pos) {
        BlockState oldState = world.getBlockState(pos);
        Block oldBlock = oldState.getBlock();
        return oldBlock.isAir(oldState, world, pos) || oldBlock.is(BlockTags.LEAVES) || oldBlock.is(BlockTags.FLOWERS);
    }
    protected static boolean isAir(ISeedReader world, BlockPos pos) {
    	BlockState oldState = world.getBlockState(pos);
        Block oldBlock = oldState.getBlock();
    	return oldBlock.isAir(oldState, world, pos);
    }
    protected boolean heightCheck(ISeedReader world, BlockPos pos, int maxHeight, int width) {
        if (pos.getY() >= 1 && pos.getY() + maxHeight < 256) {
            for (int i = 1; i <= maxHeight; i++) {
                for (int x = 0; x < width; x++) {
                    for (int z = 0; z < width; z++) {
                        if (!hasSpace(world, pos.offset(x, i, z)))
                            return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    protected boolean canSustain(ISeedReader world, BlockPos pos) {
        return TreeFeature.validTreePos(world, pos);
    }
}