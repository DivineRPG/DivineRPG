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
        		extraHeight = treeHeight + 1;
        		break;
        	case 2:
        		treeHeight = 0 + rand.nextInt(3);
        		extraHeight = treeHeight + 1;
        		break;
            default:
            	treeHeight = 3 + rand.nextInt(3);
            	extraHeight = treeHeight + 2;
        	}
        	if (heightCheck(world, pos, extraHeight, 1)) {
                BlockState log = BlockRegistry.edenLog.defaultBlockState(), leaves = BlockRegistry.edenLeaves.defaultBlockState();
                //Main trunk
                grow(world, pos, log, 0, treeHeight, 0, 0, false);
                switch(treeType) {
            	case 0:
            		int bottomHeight = 1;
            		if(treeHeight > 9 || (treeHeight == 9 && rand.nextInt(2) == 1)) {
        				bottomHeight++;
        				grow(world, pos, log, 0, 0, 1, 0, true);
        			}
            		grow(world, pos, leaves, bottomHeight, treeHeight + 1, 1, 0, false);
        			if(treeHeight > 7) {
        				grow(world, pos, leaves, bottomHeight + 2, treeHeight - 3, 2, 0, false);
        				grow(world, pos, leaves, treeHeight - 2, treeHeight - 2, 2, 0, true);
        				grow(world, pos, leaves, bottomHeight + 1, treeHeight - 2, 1, 1, false);
        				grow(world, pos, leaves, treeHeight - 1, treeHeight - 1, 1, 1, true);
        			} else {
        				if(treeHeight - 2 >= bottomHeight + 2) {
                			grow(world, pos, leaves, bottomHeight + 2, treeHeight - 2, 2, 0, false);
                		}
        				grow(world, pos, leaves, bottomHeight + 1, treeHeight - 1, 1, 1, false);
        				if(treeHeight < 7) {
        					grow(world, pos, leaves, treeHeight, treeHeight, 1, 1, true);
        				}
        				if(treeHeight != 3) {
        					if(treeHeight < 7) {
        						grow(world, pos, leaves, bottomHeight + 1, bottomHeight + 1, 2, 0, true);
                    			if(treeHeight < 6) {
                    				grow(world, pos, leaves, treeHeight - 1, treeHeight - 1, 2, 0, true);
                    			}
        					}
        				}
        			}
        			grow(world, pos, leaves, treeHeight + 1, extraHeight, 0, 0, false);
                    break;
            	case 1:
            		//Tree roots
            		setBlock(world, pos.offset(0, -1, 0), log, true);
            		setBlock(world, pos.offset(-1, -1, 0), log, true);
            		setBlock(world, pos.offset(1, -1, 0), log, true);
            		setBlock(world, pos.offset(0, -1, -1), log, true);
            		setBlock(world, pos.offset(0, -1, 1), log, true);
            		switch(rand.nextInt(4)) {
            		case 0:
            			chanceSetBlock(world, pos.offset(1, 0, 0), log, 2);
                        //Fall-through
            		case 1:
            			chanceSetBlock(world, pos.offset(0, 0, 1), log, 2);
            			//Fall-through
            		case 2:
            			chanceSetBlock(world, pos.offset(-1, 0, 0), log, 2);
            			//Fall-through
            		default:
            			chanceSetBlock(world, pos.offset(0, 0, -1), log, 2);
            		}
            		//Leaves
            		setBlock(world, pos.offset(0, treeHeight + 1, 0), leaves);
            		chanceSetBlock(world, pos.offset(0, treeHeight + 2, 0), leaves, 2);
            		grow(world, pos, leaves, treeHeight - 1, treeHeight + 1, 1, 0, false);
            		grow(world, pos, leaves, treeHeight - 1, treeHeight - 1, 1, 1, true);
            		grow(world, pos, leaves, treeHeight, treeHeight, 1, 1, false);
            		grow(world, pos, leaves, treeHeight, treeHeight, 2, 0, true);
            		break;
            	case 2:
            		setBlock(world, pos.offset(0, treeHeight + 1, 0), leaves);
            		grow(world, pos, leaves, treeHeight, treeHeight, 1, 0, false);
            		break;
                default:
                	setBlock(world, pos.offset(0, treeHeight + 1, 0), leaves);
                	grow(world, pos, leaves, treeHeight - 2, treeHeight + 1, 1, 0, false);
                	grow(world, pos, leaves, treeHeight - 2, treeHeight - 1, 1, 1, false);
                	grow(world, pos, leaves, treeHeight -2, treeHeight -1, 2, 2, true);
                	for(int offset = -1; offset < 2; offset++) {
        				grow(world, pos, leaves, treeHeight -2, treeHeight -1, 2, offset, false);
        			}
                	grow(world, pos, leaves, treeHeight, treeHeight, 1, 1, true);
            	}
                return true;
            }
    	}
    	return false;
    }
}