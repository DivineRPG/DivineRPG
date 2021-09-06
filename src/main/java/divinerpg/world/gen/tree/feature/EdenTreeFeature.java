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
            	treeHeight = 12 + rand.nextInt(1);
            	extraHeight = treeHeight + 4;
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
                    //Tree trunk
                    chanceSetBlock(world, pos.offset(1, 0, 0), log, 1);
                    chanceSetBlock(world, pos.offset(0, 0, 1), log, 1);
                    chanceSetBlock(world, pos.offset(-1, 0, 0), log, 1);
                    chanceSetBlock(world, pos.offset(0, 0, -1), log, 1);

                    //Leaves
                    for(int i = -3; i < 3; i++) {
                		setBlock(world, pos.offset(1, treeHeight + i, 0), leaves);
                		setBlock(world, pos.offset(-1, treeHeight + i, 0), leaves);
                		setBlock(world, pos.offset(0, treeHeight + i, 1), leaves);
                		setBlock(world, pos.offset(0, treeHeight + i, -1), leaves);
                    }
                    for(int i = 0; i < 4; i++) {
                    	setBlock(world, pos.offset(0, treeHeight + i, 0), leaves);
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
            		
            		setBlock(world, pos.offset(1, treeHeight, 1), leaves);
            		setBlock(world, pos.offset(1, treeHeight, -1), leaves);
            		setBlock(world, pos.offset(-1, treeHeight, 1), leaves);
            		setBlock(world, pos.offset(-1, treeHeight, -1), leaves);
            		
            		for(int i = -1; i < 2; i++) {
                		setBlock(world, pos.offset(1, treeHeight + i, 0), leaves);
                		setBlock(world, pos.offset(-1, treeHeight + i, 0), leaves);
                		setBlock(world, pos.offset(0, treeHeight + i, 1), leaves);
                		setBlock(world, pos.offset(0, treeHeight + i, -1), leaves);
                    }
            		break;
                default:
                	//Leaves
                	setBlock(world, pos.offset(0, treeHeight + 1, 0), leaves);
                	
                	for(int i = -2; i < 2; i++) {
                		setBlock(world, pos.offset(1, treeHeight + i, 0), leaves);
                		setBlock(world, pos.offset(-1, treeHeight + i, 0), leaves);
                		setBlock(world, pos.offset(0, treeHeight + i, 1), leaves);
                		setBlock(world, pos.offset(0, treeHeight + i, -1), leaves);
                		if(i < 0) {
                			setBlock(world, pos.offset(1, treeHeight + i, 1), leaves);
                			setBlock(world, pos.offset(1, treeHeight + i, -1), leaves);
                			setBlock(world, pos.offset(-1, treeHeight + i, 1), leaves);
                			setBlock(world, pos.offset(-1, treeHeight + i, -1), leaves);
                			
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
                		} else if(i == 0) {
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