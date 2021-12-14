package divinerpg.world.gen.tree.feature;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;
import java.util.function.*;

public class SkythernTreeFeature extends DivineTreeFeature {

    public SkythernTreeFeature(Supplier<SaplingBlock> saplingBlock) {
        super(saplingBlock);
    }
    private void wideGrow(ISeedReader world, BlockPos pos, BlockState state, int y, int width, int offset) {
    	setBlock(world, pos.offset(width + 1, y, offset), state);
		setBlock(world, pos.offset(-width, y, 1 - offset), state);
		setBlock(world, pos.offset(offset, y, -width), state);
		setBlock(world, pos.offset(1 - offset, y, width + 1), state);
    }
    private void wideGrow(ISeedReader world, BlockPos pos, BlockState state, int minY, int maxY, int width, int offset) {
    	maxY++;
    	for(; minY < maxY; minY++) {
    		setBlock(world, pos.offset(width + 1, minY, offset), state);
    		setBlock(world, pos.offset(-width, minY, 1 - offset), state);
    		setBlock(world, pos.offset(offset, minY, -width), state);
    		setBlock(world, pos.offset(1 - offset, minY, width + 1), state);
    	}
    }
    @Override
    protected boolean gen(ISeedReader world, Random rand, BlockPos pos) {
    	if(canSustain(world, pos)) {
    		int treeHeight, extraHeight, treeType = rand.nextInt(10), width = 1;
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
    		case 5: case 6: case 7:
    			//Tall1, Tall2, Tall3
    			width = 2;
    			treeHeight = 15 + rand.nextInt(20);
    			extraHeight = treeHeight + 2;
    			break;
    		case 8:
    			//1.12.2
    			treeHeight = 13 + rand.nextInt(8);
    			extraHeight = treeHeight + 1;
    			break;
    		default:
    			//Vanilla
    			treeHeight = 3 + rand.nextInt(3);
            	extraHeight = treeHeight + 1;
    		}
    		if(heightCheck(world, pos, extraHeight, width)) {
    			BlockState log = BlockRegistry.skythernLog.defaultBlockState(), leaves = BlockRegistry.skythernLeaves.defaultBlockState();
    			//Main trunk
    			grow(world, pos, log, 0 ,treeHeight);
    			grow(world, pos, leaves, treeHeight + 1, extraHeight);
    			if(width == 2) {
    				grow(world, pos.offset(1, 0, 0), log, 0, treeHeight);
    				grow(world, pos.offset(1, 0, 0), leaves, treeHeight + 1, extraHeight);
    				grow(world, pos.offset(0, 0, 1), log, 0, treeHeight);
    				grow(world, pos.offset(0, 0, 1), leaves, treeHeight + 1, extraHeight);
    				grow(world, pos.offset(1, 0, 1), log, 0, treeHeight);
    				grow(world, pos.offset(1, 0, 1), leaves, treeHeight + 1, extraHeight);
    			}
    			switch(treeType) {
    			case 0:
    				grow(world, pos, leaves, treeHeight - 1, treeHeight + 1, 1, 0);
    				break;
    			case 1: case 2:
    				int bottomHeight = rand.nextInt(2), wideHeight = 2 - bottomHeight + rand.nextInt(2);
    				boolean shift = rand.nextBoolean(), even = treeHeight % 2 == bottomHeight ^ shift;
    				for(int y = 2 - bottomHeight; y <= treeHeight; y++) {
    					if(y == wideHeight && treeType == 2 && wideHeight != extraHeight - 3) {
    						grow(world, pos, leaves, y, 1, 1);
    						grow(world, pos, leaves, y, 2, -1);
    						grow(world, pos, leaves, y, 2, 0);
    						grow(world, pos, leaves, y, 2, 1);
    						grow(world, pos, leaves, y, 2, 2);
    						for(int offset = -2; offset < 3; offset++) {
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
    				for(int offset = -1; offset < 2; offset++) {
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
    			case 7:
    				width = treeHeight - 2;
    				wideGrow(world, pos, leaves, width, treeHeight, 1, 0);
    				wideGrow(world, pos, leaves, width, treeHeight, 1, 1);
    				wideGrow(world, pos, leaves, width, treeHeight - 1, 1, -1);
    				wideGrow(world, pos, leaves, width, treeHeight - 1, 2, 0);
    				wideGrow(world, pos, leaves, width, treeHeight - 1, 2, 1);
    				wideGrow(world, pos, leaves, width, 2, 2);
    				wideGrow(world, pos, leaves, width, 2, -1);
    				wideGrow(world, pos, leaves, width, 2, -2);
    				wideGrow(world, pos, leaves, width, 3, 0);
    				wideGrow(world, pos, leaves, width, 3, 1);
    				break;
    			case 8:
    				grow(world, pos, log, treeHeight - 10, treeHeight - 9, 1, 0);
    				grow(world, pos, leaves, treeHeight - 8, treeHeight - 7, 1, 0);
    				grow(world, pos, log, treeHeight - 6, treeHeight - 5, 1, 0);
    				grow(world, pos, leaves, treeHeight - 4, treeHeight - 2, 1, 0);
    				grow(world, pos, leaves, treeHeight, 1, 0);
    				grow(world, pos, log, treeHeight - 8, 2, 0);
    				grow(world, pos, log, treeHeight - 8, 1, 1);
    				grow(world, pos, log, treeHeight - 4, 2, 0);
    				grow(world, pos, leaves, treeHeight - 7, treeHeight - 3, 1, 1);
    				grow(world, pos, leaves, treeHeight - 7, treeHeight - 3, 2, 0);
    				grow(world, pos, leaves, treeHeight - 7, treeHeight - 6, 2, 1);
    				grow(world, pos, leaves, treeHeight - 7, treeHeight - 6, 2, -1);
    				grow(world, pos, leaves, treeHeight - 4, 2, 1);
    				grow(world, pos, leaves, treeHeight - 4, 2, -1);
    				grow(world, pos, log, treeHeight - 7, 2, 2);
    				grow(world, pos, leaves, treeHeight - 6, 2, 2);
    				grow(world, pos, log, treeHeight - 7, 3, 0);
    				grow(world, pos, leaves, treeHeight - 6, 3, 0);
    				grow(world, pos, leaves, treeHeight - 4, 3, 0);
    				grow(world, pos, log, treeHeight - 6, 3, 3);
    				grow(world, pos, leaves, treeHeight - 7, 3, -2);
    				grow(world, pos, leaves, treeHeight - 7, 3, -1);
    				grow(world, pos, leaves, treeHeight - 7, 3, 1);
    				grow(world, pos, leaves, treeHeight - 7, 3, 2);
    				grow(world, pos, log, treeHeight - 7, 4, 0);
    				grow(world, pos, leaves, treeHeight - 6, 4, 0);
    				grow(world, pos, leaves, treeHeight - 7, 4, -3);
    				grow(world, pos, leaves, treeHeight - 7, 4, -1);
    				grow(world, pos, leaves, treeHeight - 7, 4, 1);
    				grow(world, pos, leaves, treeHeight - 7, 4, 3);
    				grow(world, pos, leaves, treeHeight - 7, 5, 0);
    				break;
    			default:
                	setBlock(world, pos.offset(0, extraHeight, 0), leaves);
                	grow(world, pos, leaves, treeHeight - 2, extraHeight, 1, 0);
                	grow(world, pos, leaves, treeHeight - 2, treeHeight - 1, 1, 1);
                	grow(world, pos, leaves, treeHeight -2, treeHeight -1, 2, 2, 2);
                	for(int offset = -1; offset < 2; offset++) {
        				grow(world, pos, leaves, treeHeight -2, treeHeight -1, 2, offset);
        			}
                	grow(world, pos, leaves, treeHeight, 1, 1, false, 2);
    			}
    			return true;
    		}
    	}
    	return false;
    }
}