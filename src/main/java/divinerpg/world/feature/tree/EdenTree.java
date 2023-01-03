package divinerpg.world.feature.tree;

import divinerpg.DivineRPG;
import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.registries.ForgeRegistries;

public class EdenTree extends DivineTree {
	@Override
	protected boolean defaultGrowOn(BlockState state) {
		return state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_dirt"))) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_grass")));
	}
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			int treeHeight, extraHeight, treeType = random.nextInt(4);
        	switch(treeType) {
        	case 0:
            	treeHeight = 3 + random.nextInt(10);
            	extraHeight = treeHeight + 3 + random.nextInt(2);
            	break;
        	case 1:
        		treeHeight = 1 + random.nextInt(3);
        		extraHeight = treeHeight + 2;
        		break;
        	case 2:
        		treeHeight = 0 + random.nextInt(3);
        		extraHeight = treeHeight + 1;
        		break;
			default: return super.place(config, level, chunkGen, random, pos);
			}
			if(heightCheck(level, pos, extraHeight, 1)) {
				BlockState log = config.log, leaves = config.leaves;
				//Main trunk
                grow(level, pos, log, treeHeight);
                switch(treeType) {
            	case 0:
            		int bottomHeight = 1;
            		if(treeHeight > 9 || (treeHeight == 9 && random.nextBoolean())) {
        				bottomHeight++;
        				grow(level, random, pos, log, 1, 0, 0.5F);
        			}
            		grow(level, pos.offset(0, bottomHeight, 0), leaves, treeHeight + 1 - bottomHeight, 1, 0);
        			if(treeHeight > 7) {
        				grow(level, pos.offset(0, bottomHeight + 2, 0), leaves, treeHeight - 5 - bottomHeight, 2, 0);
        				grow(level, random, pos.offset(0, treeHeight - 2, 0), leaves, 2, 0, 0.5F);
        				grow(level, pos.offset(0, bottomHeight + 1, 0), leaves, treeHeight - 3 - bottomHeight, 1, 1);
        				grow(level, random, pos.offset(0, treeHeight - 1, 0), leaves, 1, 1, 0.5F);
        			} else {
        				if(treeHeight - 2 >= bottomHeight + 2) grow(level, pos.offset(0, bottomHeight + 2, 0), leaves, treeHeight - 4 - bottomHeight, 2, 0);
        				grow(level, pos.offset(0, bottomHeight + 1, 0), leaves, treeHeight - 2 - bottomHeight, 1, 1);
        				if(treeHeight < 7) grow(level, random, pos.offset(0, treeHeight, 0), leaves, 1, 1, 0.5F);
        				if(treeHeight != 3 && treeHeight < 7) {
    						grow(level, random, pos.offset(0, bottomHeight + 1, 0), leaves, 2, 0, 0.5F);
                			if(treeHeight < 6) grow(level, random, pos.offset(0, treeHeight - 1, 0), leaves, 2, 0, 0.5F);
        				}
        			}
        			grow(level, pos.offset(0, treeHeight + 1, 0), leaves, extraHeight - 1 - treeHeight);
                    break;
            	case 1:
            		//Tree roots
            		setBlock(level, pos.offset(0, -1, 0), log, true);
            		grow(level, pos.below(), log, 1, 0, true);
            		grow(level, random, pos, log, 1, 0, 0.25F);
            		//Leaves
            		setBlock(level, pos.offset(0, treeHeight + 1, 0), leaves);
            		chanceSetBlock(level, random, pos.offset(0, extraHeight, 0), leaves, 0.5F);
            		grow(level, pos.offset(0, treeHeight - 1, 0), leaves, 2, 1, 0);
            		grow(level, random, pos.offset(0, treeHeight - 1, 0), leaves, 1, 1, 0.25F);
            		grow(level, pos.offset(0, treeHeight, 0), leaves, 1, 1);
            		grow(level, random, pos.offset(0, treeHeight, 0), leaves, 2, 0, 0.5F);
            		break;
            	default:
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