package divinerpg.world.gen.tree.feature;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
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
    		int treeHeight, extraHeight, treeType = rand.nextInt(3);
        	switch(treeType) {
        	case 0:
            	treeHeight = 4 + rand.nextInt(10);
            	extraHeight = treeHeight + 3 + rand.nextInt(2);
            	break;
        	case 1:
        		treeHeight = 3 + rand.nextInt(3);
        		extraHeight = treeHeight + 1;
        		break;
            default:
            	treeHeight = 4 + rand.nextInt(3);
            	extraHeight = treeHeight + 2;
        	}
        	if (heightCheck(world, pos, extraHeight, 1)) {
        		BlockPos.Mutable mut = new BlockPos.Mutable().set(pos.below());
                BlockState log = BlockRegistry.edenLog.defaultBlockState();
                BlockState leaves = BlockRegistry.edenLeaves.defaultBlockState();
                //Main trunk
                for (int i = 0; i < treeHeight + 1; i++) {
                    setBlock(world, mut.move(Direction.UP), log);
                }
                switch(treeType) {
            	case 0:
            		int bottomHeight = 1;
            		if(treeHeight > 9 || treeHeight == 9 && rand.nextInt(2) == 1) {
        				bottomHeight++;
            			chanceSetBlock(world, pos.offset(1, 0, 0), log, 1);
                        chanceSetBlock(world, pos.offset(0, 0, 1), log, 1);
                        chanceSetBlock(world, pos.offset(-1, 0, 0), log, 1);
                        chanceSetBlock(world, pos.offset(0, 0, -1), log, 1);
        			}
            		coverTrunk(world, pos, leaves, bottomHeight, treeHeight + 1, 1, false);
        			if(treeHeight > 8) {
        				coverTrunk(world, pos, leaves, bottomHeight + 2, treeHeight - 3, 2, false);
        				coverTrunk(world, pos, leaves, treeHeight - 2, treeHeight - 2, 2, true);
        				coverTrunkCorners(world, pos, leaves, bottomHeight + 1, treeHeight - 2, false);
        				coverTrunkCorners(world, pos, leaves, treeHeight - 1, treeHeight - 1, true);
        			} else {
        				coverTrunkCorners(world, pos, leaves, bottomHeight + 1, treeHeight - 1, false);
        				if(treeHeight < 7) {
        					coverTrunkCorners(world, pos, leaves, treeHeight, treeHeight, true);
        				}
        				if(treeHeight > 5) {
        					coverTrunk(world, pos, leaves, bottomHeight + 2, treeHeight - 2, 2, false);
        				}
        				if(treeHeight != 4 && treeHeight < 8) {
        					coverTrunk(world, pos, leaves, bottomHeight + 1, bottomHeight + 1, 2, true);
                			if(treeHeight < 7) {
                				coverTrunk(world, pos, leaves, treeHeight - 1, treeHeight - 1, 2, true);
                			}
        				}
        			}
            		for(int i = treeHeight + 1; i < extraHeight + 1; i++) {
                    	setBlock(world, pos.offset(0, i, 0), leaves);
                    }
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
            			chanceSetBlock(world, pos.offset(1, 0, 0), log, 1);
                        //Fall-through
            		case 1:
            			chanceSetBlock(world, pos.offset(0, 0, 1), log, 1);
            			//Fall-through
            		case 2:
            			chanceSetBlock(world, pos.offset(-1, 0, 0), log, 1);
            			//Fall-through
            		case 3:
            			chanceSetBlock(world, pos.offset(0, 0, -1), log, 1);
            		}
            		//Leaves
            		setBlock(world, pos.offset(0, treeHeight + 1, 0), leaves);
            		
            		coverTrunk(world, pos, leaves, treeHeight - 1, treeHeight + 1, 1, false);
            		coverTrunkCorners(world, pos, leaves, treeHeight, treeHeight, false);
            		break;
                default:
                	//Leaves
                	setBlock(world, pos.offset(0, treeHeight + 1, 0), leaves);
                	
                	coverTrunk(world, pos, leaves, treeHeight - 2, treeHeight + 1, 1, false);
                	coverTrunkCorners(world, pos, leaves, treeHeight - 2, treeHeight - 1, false);
                	for(int i = -2; i < 1; i++) {
                		if(i < 0) {
                			chanceSetBlock(world, pos.offset(2, treeHeight + i, 2), leaves, 1);
                			chanceSetBlock(world, pos.offset(2, treeHeight + i, -2), leaves, 1);
                			chanceSetBlock(world, pos.offset(-2, treeHeight + i, 2), leaves, 1);
                			chanceSetBlock(world, pos.offset(-2, treeHeight + i, -2), leaves, 1);
                			
                			for(int offset = -1; offset < 2; offset++) {
                				setBlock(world, pos.offset(-2, treeHeight + i, offset), leaves);
                				setBlock(world, pos.offset(2, treeHeight + i, offset), leaves);
                				setBlock(world, pos.offset(offset, treeHeight + i, -2), leaves);
                				setBlock(world, pos.offset(offset, treeHeight + i, 2), leaves);
                			}
                		} else {
                			chanceSetBlock(world, pos.offset(1, treeHeight + i, 1), leaves, 1);
                			chanceSetBlock(world, pos.offset(1, treeHeight + i, -1), leaves, 1);
                			chanceSetBlock(world, pos.offset(-1, treeHeight + i, 1), leaves, 1);
                			chanceSetBlock(world, pos.offset(-1, treeHeight + i, -1), leaves, 1);
                		}
                	}
            	}
                return true;
            }
    	}
    	return false;
    }
}