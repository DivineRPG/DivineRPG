package divinerpg.world.gen.tree.feature;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;
import java.util.function.*;

public class EdenTreeFeature extends DivineTreeFeature {

    public EdenTreeFeature(Supplier<SaplingBlock> saplingBlock) {
        super(saplingBlock);
    }

    @Override
    protected boolean gen(ISeedReader world, Random rand, BlockPos pos) {
    	if (canSustain(world, pos)) {
    		int treeHeight, extraHeight, treeType = rand.nextInt(4);
        	switch(treeType) {
        	case 0:
            	treeHeight = 3 + rand.nextInt(10);
            	extraHeight = treeHeight + 3 + rand.nextInt(2);
            	break;
        	case 1:
        		treeHeight = 1 + rand.nextInt(3);
        		extraHeight = treeHeight + 2;
        		break;
        	case 2:
        		treeHeight = 0 + rand.nextInt(3);
        		extraHeight = treeHeight + 1;
        		break;
            default:
            	treeHeight = 3 + rand.nextInt(3);
            	extraHeight = treeHeight + 1;
        	}
        	if (heightCheck(world, pos, extraHeight, 1)) {
                BlockState log = BlockRegistry.edenLog.defaultBlockState(), leaves = BlockRegistry.edenLeaves.defaultBlockState();
                //Main trunk
                grow(world, pos, log, 0, treeHeight);
                switch(treeType) {
            	case 0:
            		int bottomHeight = 1;
            		if(treeHeight > 9 || (treeHeight == 9 && rand.nextBoolean())) {
        				bottomHeight++;
        				grow(world, pos, log, 0, 0, 1, 0, false, 2);
        			}
            		grow(world, pos, leaves, bottomHeight, treeHeight + 1, 1, 0);
        			if(treeHeight > 7) {
        				grow(world, pos, leaves, bottomHeight + 2, treeHeight - 3, 2, 0);
        				grow(world, pos, leaves, treeHeight - 2, 2, 0, false, 2);
        				grow(world, pos, leaves, bottomHeight + 1, treeHeight - 2, 1, 1);
        				grow(world, pos, leaves, treeHeight - 1, 1, 1, false, 2);
        			} else {
        				if(treeHeight - 2 >= bottomHeight + 2) {
                			grow(world, pos, leaves, bottomHeight + 2, treeHeight - 2, 2, 0);
                		}
        				grow(world, pos, leaves, bottomHeight + 1, treeHeight - 1, 1, 1);
        				if(treeHeight < 7) {
        					grow(world, pos, leaves, treeHeight, 1, 1, false, 2);
        				}
        				if(treeHeight != 3) {
        					if(treeHeight < 7) {
        						grow(world, pos, leaves, bottomHeight + 1, 2, 0, false, 2);
                    			if(treeHeight < 6) {
                    				grow(world, pos, leaves, treeHeight - 1, 2, 0, false, 2);
                    			}
        					}
        				}
        			}
        			grow(world, pos, leaves, treeHeight + 1, extraHeight);
                    break;
            	case 1:
            		//Tree roots
            		setBlock(world, pos.offset(0, -1, 0), log, true);
            		grow(world, pos, log, -1, 1, 0, true);
            		grow(world, pos, log, 0, 1, 0, false, 4);
            		//Leaves
            		setBlock(world, pos.offset(0, treeHeight + 1, 0), leaves);
            		chanceSetBlock(world, pos.offset(0, extraHeight, 0), leaves, 2, false);
            		grow(world, pos, leaves, treeHeight - 1, treeHeight + 1, 1, 0);
            		grow(world, pos, leaves, treeHeight - 1, 1, 1, false, 2);
            		grow(world, pos, leaves, treeHeight, 1, 1);
            		grow(world, pos, leaves, treeHeight, 2, 0, false, 2);
            		break;
            	case 2:
            		setBlock(world, pos.offset(0, extraHeight, 0), leaves);
            		grow(world, pos, leaves, treeHeight, 1, 0);
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