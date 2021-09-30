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

    
    /**
     * sets the given block on all for sides if all conditions are met
     * @param world
     * @param pos the position of origin (the center)
     * @param state the block to set
     * @param minY relative to {@code pos}
     * @param maxY relative to {@code pos}. set to same as minY to have it only on one height
     * @param width (for 0 you rather just use {@link #grow(ISeedReader, BlockPos, BlockState, int, int, int, int)} else offset replaces width)
     * @param offset rotates the cross (note that {@code (width, offset) = (offset, -width)})
     * @param chance (int >= 1) of setting a block at a position. chance in percentage = {@code 1/chance}. 1 = will always set block
     * @param returnChance for each column to independently stop growing. 1 = will not stop
     */
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY, int width, int offset, boolean replace, int chance, int returnChance) {
    	grow(world, pos.offset(width, 0, offset), state, minY, maxY, replace, chance, returnChance);
    	grow(world, pos.offset(-width, 0, -offset), state, minY, maxY, replace, chance, returnChance);
    	grow(world, pos.offset(offset, 0, -width), state, minY, maxY, replace, chance, returnChance);
    	grow(world, pos.offset(-offset, 0, width), state, minY, maxY, replace, chance, returnChance);
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY, int width, int offset, boolean replace, int chance) {
    	grow(world, pos.offset(width, 0, offset), state, minY, maxY, replace, chance);
    	grow(world, pos.offset(-width, 0, -offset), state, minY, maxY, replace, chance);
    	grow(world, pos.offset(offset, 0, -width), state, minY, maxY, replace, chance);
    	grow(world, pos.offset(-offset, 0, width), state, minY, maxY, replace, chance);
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY, boolean replace, int chance, int returnChance) {
    	for(; minY < maxY + 1; minY++) {
    		if(chance == 1) {
    			setBlock(world, pos.offset(0, minY, 0), state, replace);
    		} else {
    			chanceSetBlock(world, pos.offset(0, minY, 0), state, chance, replace);
    		}
    		if(returnChance != 1 && world.getRandom().nextInt(returnChance) == 0) {
    			return;
    		}
    	}
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY, boolean replace, int chance) {
    	for(; minY < maxY + 1; minY++) {
    		if(chance == 1) {
    			setBlock(world, pos.offset(0, minY, 0), state, replace);
    		} else {
    			chanceSetBlock(world, pos.offset(0, minY, 0), state, chance, replace);
    		}
    	}
    }
    protected void grow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY, boolean replace) {
    	for(; minY < maxY + 1; minY++) {
    		setBlock(world, pos.offset(0, minY, 0), state, replace);
    	}
    }
    protected static boolean hasSpace(ISeedReader world, BlockPos pos) {
        BlockState oldState = world.getBlockState(pos);
        Block oldBlock = oldState.getBlock();
        return oldBlock.isAir(oldState, world, pos) || oldBlock.is(BlockTags.LEAVES) || oldBlock.is(BlockTags.FLOWERS);
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