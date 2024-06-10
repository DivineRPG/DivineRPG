package divinerpg.world.feature.tree;

import divinerpg.DivineRPG;
import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.registries.ForgeRegistries;

public class ShiverspineTree extends SkythernTree {
	@Override
	protected boolean defaultGrowOn(BlockState state) {
		return state.is(BlockTags.SNOW) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_grass"))) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_dirt")));
	}
	@Override
	public boolean hasSpace(BlockState state) {
		return state.is(BlockTags.SNOW) || super.hasSpace(state);
	}
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			if(level.getBlockState(pos.below()).is(BlockTags.SNOW)) pos = pos.below();
			int treeHeight, extraHeight, treeType = random.nextInt(25), width = 1;
    		switch(treeType) {
    		case 1: case 2:
    			//Stacking1, Stacking2
    			treeHeight = 3 + random.nextInt(6);
    			extraHeight = treeHeight + 3;
    			break;
    		case 0: case 3: case 7: case 8: case 9: case 10:
    			//Tall1, Tall2, Tall3
    			width = 2;
    			treeHeight = 15 + random.nextInt(20);
    			extraHeight = treeHeight + 2;
    			break;
    		default: return super.place(config, level, chunkGen, random, pos);
    		} if(heightCheck(level, pos, extraHeight, width)) {
    			BlockState log = config.log, leaves = config.leaves;
    			BlockPos temp;
    			//Main trunk
    			grow(level, pos, log, treeHeight + 1);
    			grow(level, pos.offset(0, treeHeight + 1, 0), leaves, extraHeight - 1 - treeHeight);
    			if(width == 2) {
    				MutableBlockPos mut = pos.offset(1, 0, 0).mutable();
    				while(hasSpace(level.getBlockState(mut.move(0, -1, 0)))) setBlock(level, mut, log, true);
    				grow(level, pos.offset(1, 0, 0), log, treeHeight + 1);
    				grow(level, pos.offset(1, treeHeight + 1, 0), leaves, extraHeight - 1 - treeHeight);
    				mut = pos.offset(0, 0, 1).mutable();
    				while(hasSpace(level.getBlockState(mut.move(0, -1, 0)))) setBlock(level, mut, log, true);
    				grow(level, pos.offset(0, 0, 1), log, treeHeight - 1);
    				grow(level, pos.offset(0, treeHeight + 1, 1), leaves, extraHeight - 1 - treeHeight);
    				mut = pos.offset(1, 0, 1).mutable();
    				while(hasSpace(level.getBlockState(mut.move(0, -1, 0)))) setBlock(level, mut, log, true);
    				grow(level, pos.offset(1, 0, 1), log, treeHeight + 1);
    				grow(level, pos.offset(1, treeHeight + 1, 1), leaves, extraHeight - 1 - treeHeight);
    			} int bottomHeight, offset;
    			switch(treeType) {
    			case 1: case 2:
    				bottomHeight = random.nextInt(2);
    				int wideHeight = 2 - bottomHeight + random.nextInt(2);
    				boolean shift = random.nextBoolean(), even = treeHeight % 2 == bottomHeight ^ shift;
    				for(int y = 2 - bottomHeight; y <= treeHeight; y++) {
    					if(y == wideHeight && treeType == 2 && wideHeight != extraHeight - 3) {
    						temp = pos.offset(0, y, 0);
    						grow(level, temp, leaves, 1, 1);
    						grow(level, temp, leaves, 2, -1);
    						grow(level, temp, leaves, 2, 0);
    						grow(level, temp, leaves, 2, 1);
    						grow(level, temp, leaves, 2, 2);
    						for(offset = -2; offset < 3; offset++) grow(level, temp, leaves, 3, offset);
    						if(y % 2 == bottomHeight ^ shift) shift = !shift;
    					} else if(y % 2 == bottomHeight ^ shift) {
    						temp = pos.offset(0, y, 0);
    						grow(level, temp, leaves, 1, 1);
    						grow(level, temp, leaves, 2, -1);
    						grow(level, temp, leaves, 2, 0);
    						grow(level, temp, leaves, 2, 1);
    					}
    				}
    				grow(level, pos.offset(0, treeHeight, 0), log, random.nextInt(even ? 2 : 3));
    				grow(level, pos.offset(0,  2 - bottomHeight, 0), leaves,  treeHeight + (even ? -1 : -2) + bottomHeight, 1, 0);
    				grow(level, pos.offset(0, extraHeight - (even ? 0 : 1), 0), leaves, 1, 0);
    				break;
    			case 7: case 8:
    				temp = pos.offset(0, treeHeight + 1, 0);
    				wideGrow(level, temp, leaves, 1, 0);
                	wideGrow(level, temp, leaves, 1, 1);
                	treeHeight--;
                	bottomHeight = 2 + random.nextInt(5);
                	temp = pos.offset(0, bottomHeight, 0);
                	int tempInt = treeHeight - bottomHeight;
                	wideGrow(level, temp, leaves, tempInt, 1, 0);
                	wideGrow(level, temp, leaves, tempInt, 1, 1);
                	for(width = treeHeight - 1; width > bottomHeight; width--) {
                		if((treeHeight - width) % 3 != 0) {
                			wideGrow(level, pos.offset(0, width, 0), leaves, 1, -1);
                			for(offset = -1; offset < 3; offset++) wideGrow(level, pos.offset(0, width, 0), leaves, 2, offset);
                		}
                		if((treeHeight - width) % 3 == 2) {
                			wideGrow(level, pos.offset(0, width, 0), leaves, 2, -2);
                			for(offset = -2; offset < 4; offset++) wideGrow(level, pos.offset(0, width, 0), leaves, 3, offset);
                		}
                	}
    				break;
    			default:
    				temp = pos.offset(0, extraHeight, 0);
                	wideGrow(level, temp, leaves, 1, 0);
                	wideGrow(level, temp, leaves, 1, 1);
                	bottomHeight = 5 + random.nextInt(10);
                	treeHeight++;
                	for(int stage = 2; treeHeight > bottomHeight;) {
                		for(width = 1; width < stage; width++) {
                			treeHeight--;
                			extraHeight = (treeHeight + 1) - (stage - width);
                			for(offset = 1 - width; offset <= width; offset++) wideGrow(level, pos.offset(0, extraHeight, 0), leaves, treeHeight - extraHeight, width, offset);
                			wideGrow(level, pos.offset(0, extraHeight, 0), leaves, treeHeight - extraHeight, width - 1, width);
                		} if(stage < 6) stage++;
                	}
    			} return true;
    		}
		} return false;
	}
}