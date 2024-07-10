package divinerpg.world.feature.tree;

import divinerpg.registries.BlockRegistry;
import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;

public class MortumTree extends DivineTree {
	@Override
	protected boolean defaultGrowOn(BlockState state) {
		return state.is(BlockRegistry.mortumDirt.get()) || state.is(BlockRegistry.mortumGrass.get());
	}
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			int treeHeight, extraHeight, treeType = random.nextInt(4);
        	switch(treeType) {
        	case 0:
            	treeHeight = 2 + random.nextInt(4);
            	extraHeight = treeHeight + 1;
            	break;
        	case 1:
        		treeHeight = 1 + random.nextInt(3);
        		extraHeight = treeHeight + 1;
        		break;
        	case 2:
        		treeHeight = 0 + random.nextInt(3);
        		extraHeight = treeHeight + 1;
        		break;
            default: return super.place(config, level, null, random, pos);
        	}
        	if(heightCheck(level, pos, extraHeight, 1)) {
        		BlockState log = config.log, leaves = config.leaves;
        		BlockPos temp;
        		//Main trunk
        		grow(level, pos, log, treeHeight);
                switch(treeType) {
            	case 0:
            		setBlock(level, pos.offset(0, extraHeight, 0), leaves);
            		extraHeight = 1 + random.nextInt(2);
            		temp = pos.offset(0, extraHeight, 0);
            		grow(level, temp, leaves, treeHeight - extraHeight, 1, 0);
            		grow(level, temp.above(), leaves, treeHeight - 2 - extraHeight, 1, 1);
            		break;
            	case 1:
            		//Tree roots
            		setBlock(level, pos.offset(0, -1, 0), log, true);
            		grow(level, pos.below(), log, 1, 0, true);
            		//Leaves
            		setBlock(level, pos.offset(0, extraHeight, 0), leaves);
            		temp = pos.offset(0, treeHeight - 1, 0);
            		grow(level, temp, leaves, extraHeight + 1 - treeHeight, 1, 0);
            		grow(level, temp.above(), leaves, 1, 1);
            		break;
            	case 2:
            		setBlock(level, pos.offset(0, extraHeight, 0), leaves);
            		grow(level, pos.offset(0, treeHeight, 0), leaves, 1, 0);
            		break;
                }
                return true;
        	}
		}
		return false;
	}
}