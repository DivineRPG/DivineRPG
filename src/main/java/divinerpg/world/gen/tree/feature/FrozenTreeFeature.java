package divinerpg.world.gen.tree.feature;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;
import java.util.function.*;

public class FrozenTreeFeature extends DivineTreeFeature {

    public FrozenTreeFeature(Supplier<SaplingBlock> saplingBlock) {
        super(saplingBlock);
    }
    @Override
    protected boolean hasSpace(ISeedReader world, BlockPos pos) {
        BlockState oldState = world.getBlockState(pos);
        Block oldBlock = oldState.getBlock();
        return oldBlock.isAir(oldState, world, pos) || oldBlock.is(BlockTags.LEAVES) || oldBlock.is(BlockTags.FLOWERS) || oldBlock.is(Blocks.SNOW);
    }
    @Override
    protected boolean gen(ISeedReader world, Random rand, BlockPos pos) {
    	if((canSustain(world, pos) || world.getBlockState(pos).is(Blocks.SNOW)) && !world.getBlockState(pos.below()).is(Blocks.WATER)) {
    		int treeHeight, extraHeight, treeType = rand.nextInt(11), width = 1;
    		switch(treeType) {
    		case 0:
    			//Spike
    			treeHeight = 2 + rand.nextInt(12);
    			extraHeight = treeHeight + 2;
    			break;
    		case 1: case 2:
    			//Stacking1, Stacking2
    			treeHeight = 3 + rand.nextInt(6);
    			extraHeight = treeHeight + 3;
    			break;
    		case 3: case 4:
    			//Popsickle1, Popsickle2
    			treeHeight = 4 + rand.nextInt(9);
    			extraHeight = treeHeight + 2;
    			break;
    		default:
    			//Tall1, Tall2, Tall3, default
    			width = 2;
    			treeHeight = 15 + rand.nextInt(20);
    			extraHeight = treeHeight + 2;
    			break;
    		}
    		if(heightCheck(world, pos, extraHeight, width)) {
    			BlockState log = BlockRegistry.frozenLog.defaultBlockState(), leaves = BlockRegistry.brittleLeaves.defaultBlockState().setValue(BlockModLeaves.DISTANCE, 1);
    			//Main trunk
    			grow(world, pos, log, -1 ,treeHeight);
    			grow(world, pos, leaves, treeHeight + 1, extraHeight);
    			if(width == 2) {
    				grow(world, pos.offset(1, 0, 0), log, -1, treeHeight);
    				grow(world, pos.offset(1, 0, 0), leaves, treeHeight + 1, extraHeight);
    				grow(world, pos.offset(0, 0, 1), log, -1, treeHeight);
    				grow(world, pos.offset(0, 0, 1), leaves, treeHeight + 1, extraHeight);
    				grow(world, pos.offset(1, 0, 1), log, -1, treeHeight);
    				grow(world, pos.offset(1, 0, 1), leaves, treeHeight + 1, extraHeight);
    			}
    			int bottomHeight, offset;
    			switch(treeType) {
    			case 0:
    				grow(world, pos, leaves, treeHeight - 1, treeHeight + 1, 1, 0);
    				break;
    			case 1: case 2:
    				bottomHeight = rand.nextInt(2);
    				int wideHeight = 2 - bottomHeight + rand.nextInt(2);
    				boolean shift = rand.nextBoolean(), even = treeHeight % 2 == bottomHeight ^ shift;
    				for(int y = 2 - bottomHeight; y <= treeHeight; y++) {
    					if(y == wideHeight && treeType == 2 && wideHeight != extraHeight - 3) {
    						grow(world, pos, leaves, y, 1, 1);
    						grow(world, pos, leaves, y, 2, -1);
    						grow(world, pos, leaves, y, 2, 0);
    						grow(world, pos, leaves, y, 2, 1);
    						grow(world, pos, leaves, y, 2, 2);
    						for(offset = -2; offset < 3; offset++) {
    							grow(world, pos, leaves, y, 3, offset);
    						}
    						if(y % 2 == bottomHeight ^ shift) {
    							shift = !shift;
    						}
    					} else if(y % 2 == bottomHeight ^ shift) {
    						grow(world, pos, leaves, y, 1, 1);
    						grow(world, pos, leaves, y, 2, -1);
    						grow(world, pos, leaves, y, 2, 0);
    						grow(world, pos, leaves, y, 2, 1);
    					}
    				}
    				grow(world, pos, log, treeHeight, treeHeight + rand.nextInt(even ? 2 : 3));
    				grow(world, pos, leaves,  2 - bottomHeight, treeHeight + (even ? 1 : 0), 1, 0);
    				grow(world, pos, leaves, extraHeight - (even ? 0 : 1), 1, 0);
    				break;
    			case 3:
    				width += rand.nextInt(2);
    				grow(world, pos, leaves, treeHeight - width, treeHeight + 1, 1, 0);
    				grow(world, pos, leaves, treeHeight - width + 1, treeHeight, 1, 1);
    				for(offset = -1; offset < 2; offset++) {
    					grow(world, pos, leaves, treeHeight - width + 1, treeHeight, 2, offset);
    				}
    				break;
    			case 4:
    				grow(world, pos, leaves, treeHeight - 2, treeHeight + 1, 1, 0);
    				grow(world, pos, leaves, treeHeight - 2, treeHeight, 1, 1);
    				width = -2;
    				for(; width < 3; width++) {
    					if(Math.abs(width) < 2) {
    						grow(world, pos, leaves, treeHeight - 2, treeHeight, 2, width);
    					}
    					grow(world, pos, leaves, treeHeight - 1, 3, width);
    				}
    				grow(world, pos, leaves, treeHeight - 1, 2, 2);
    				break;
    			case 5:
    				width = treeHeight - 3 - rand.nextInt(3);
    				wideGrow(world, pos, leaves, width, treeHeight, 1, 0);
    				wideGrow(world, pos, leaves, width, treeHeight, 1, 1);
    				extraHeight = treeHeight - 2;
    				wideGrow(world, pos, leaves, width, extraHeight, 1, -1);
    				wideGrow(world, pos, leaves, width, extraHeight, 2, 0);
    				wideGrow(world, pos, leaves, width, extraHeight, 2, 1);
    				extraHeight -= 2;
    				wideGrow(world, pos, leaves, width, extraHeight, 2, -1);
    				wideGrow(world, pos, leaves, width, extraHeight, 2, 2);
    				wideGrow(world, pos, leaves, width, extraHeight, 3, 0);
    				wideGrow(world, pos, leaves, width, extraHeight, 3, 1);
    				break;
    			case 6:
    				width = treeHeight - 15;
    				wideGrow(world, pos, leaves, treeHeight, 1, 0);
    				wideGrow(world, pos, leaves, treeHeight, 1, 1);
    				extraHeight = treeHeight - 3;
    				wideGrow(world, pos, leaves, width, extraHeight, 1, 0);
    				wideGrow(world, pos, leaves, width, extraHeight, 1, 1);
    				extraHeight--;
    				while(extraHeight > treeHeight - 8) {
    					wideGrow(world, pos, leaves, extraHeight, 1, -1);
        				wideGrow(world, pos, leaves, extraHeight, 2, 0);
        				wideGrow(world, pos, leaves, extraHeight, 2, 1);
        				extraHeight -= 2;
    				}
    				wideGrow(world, pos, leaves, width, extraHeight, 1, -1);
    				wideGrow(world, pos, leaves, width, extraHeight, 2, 0);
    				wideGrow(world, pos, leaves, width, extraHeight, 2, 1);
    				while(extraHeight > treeHeight - 11) {
    					wideGrow(world, pos, leaves, extraHeight, 2, -2);
        				wideGrow(world, pos, leaves, extraHeight, 2, -1);
        				wideGrow(world, pos, leaves, extraHeight, 2, 2);
        				wideGrow(world, pos, leaves, extraHeight, 2, 3);
        				wideGrow(world, pos, leaves, extraHeight, 3, 0);
        				wideGrow(world, pos, leaves, extraHeight, 3, 1);
        				extraHeight -= 2;
    				}
    				extraHeight = width + 2;
    				wideGrow(world, pos, leaves, width, extraHeight, 2, -2);
    				wideGrow(world, pos, leaves, width, extraHeight, 2, -1);
    				wideGrow(world, pos, leaves, width, extraHeight, 2, 2);
    				wideGrow(world, pos, leaves, width, extraHeight, 2, 3);
    				wideGrow(world, pos, leaves, width, extraHeight, 3, 0);
    				wideGrow(world, pos, leaves, width, extraHeight, 3, 1);
    				wideGrow(world, pos, leaves, width + 1, 3, -2);
    				wideGrow(world, pos, leaves, width + 1, 3, -1);
    				wideGrow(world, pos, leaves, width + 1, 3, 2);
    				wideGrow(world, pos, leaves, width + 1, 3, 3);
    				wideGrow(world, pos, leaves, width + 1, 4, 0);
    				wideGrow(world, pos, leaves, width + 1, 4, 1);
    				break;
    			case 7: case 8:
    				wideGrow(world, pos, leaves, treeHeight + 1, 1, 0);
                	wideGrow(world, pos, leaves, treeHeight + 1, 1, 1);
                	treeHeight--;
                	bottomHeight = 2 + rand.nextInt(5);
                	wideGrow(world, pos, leaves, bottomHeight, treeHeight, 1, 0);
                	wideGrow(world, pos, leaves, bottomHeight, treeHeight, 1, 1);
                	for(width = treeHeight - 1; width > bottomHeight; width--) {
                		if((treeHeight - width) % 3 != 0) {
                			wideGrow(world, pos, leaves, width, 1, -1);
                			for(offset = -1; offset < 3; offset++) {
                				wideGrow(world, pos, leaves, width, 2, offset);
                			}
                		}
                		if((treeHeight - width) % 3 == 2) {
                			wideGrow(world, pos, leaves, width, 2, -2);
                			for(offset = -2; offset < 4; offset++) {
                				wideGrow(world, pos, leaves, width, 3, offset);
                			}
                		}
                	}
    				break;
    			default:
                	wideGrow(world, pos, leaves, extraHeight, 1, 0);
                	wideGrow(world, pos, leaves, extraHeight, 1, 1);
                	bottomHeight = 5 + rand.nextInt(10);
                	treeHeight++;
                	for(int stage = 2; treeHeight > bottomHeight;) {
                		for(width = 1; width < stage; width++) {
                			treeHeight--;
                			extraHeight = (treeHeight + 1) - (stage - width);
                			for(offset = 1 - width; offset <= width; offset++) {
                				wideGrow(world, pos, leaves, extraHeight, treeHeight, width, offset);
                			}
                			wideGrow(world, pos, leaves, extraHeight, treeHeight, width - 1, width);
                		}
                		if(stage < 6) {
                			stage++;
                		}
                	}
    			}
    			return true;
    		}
    	}
    	return false;
    }
}