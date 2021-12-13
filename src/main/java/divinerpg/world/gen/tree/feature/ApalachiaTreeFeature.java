package divinerpg.world.gen.tree.feature;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;
import java.util.function.*;

public class ApalachiaTreeFeature extends DivineTreeFeature {

    public ApalachiaTreeFeature(Supplier<SaplingBlock> saplingBlock) {
        super(saplingBlock);
    }

    @Override
    protected boolean gen(ISeedReader world, Random rand, BlockPos pos) {
    	if(canSustain(world, pos)) {
    		int treeHeight= rand.nextInt(15), extraHeight, treeType = rand.nextInt(13);
    		switch(treeType) {
    		case 0: case 1:
    			//Javelin
    			extraHeight = treeHeight + 3;
    			break;
    		case 2: case 3: case 4: case 5:
    			//Spike & BigBall
    			extraHeight = treeHeight + 2;
    			break;
    		case 6: case 7: case 8: case 9: case 10: case 11:
    			//Minimalist & Ball & FlatBall
    			extraHeight = treeHeight + 1;
    			break;
    		default:
    			//Cozy
    			treeHeight = 3 + rand.nextInt(3);
    			extraHeight = treeHeight + 4;
    		}
    		if(heightCheck(world, pos, extraHeight, 1)) {
    			BlockState log = BlockRegistry.apalachiaLog.defaultBlockState(), leaves = BlockRegistry.apalachiaLeaves.defaultBlockState();
    			if(treeType != 14) {
    				grow(world, pos, log, 0, treeHeight);
    			}
    			switch(treeType) {
    			case 0:
    				grow(world, pos, leaves, treeHeight - 1, 2, 0, false, 2);
    				//Fall-Through
    			case 1:
    				grow(world, pos, leaves, treeHeight - 2, treeHeight + 1, 1, 0);
    				grow(world, pos, leaves, treeHeight - 1, treeHeight, 1, 1);
    				grow(world, pos, leaves, treeHeight + 1, extraHeight);
    				break;
    			case 2:
    				grow(world, pos, leaves, treeHeight - 1, 1, 1, false, 2);
    				//Fall-Through
    			case 3:
    				grow(world, pos, leaves, treeHeight - 1, treeHeight, 1, 0);
    				grow(world, pos, leaves, treeHeight + 1, extraHeight);
    				break;
    			case 4: case 5:
    				grow(world, pos, leaves, treeHeight + 1, extraHeight);
    				grow(world, pos, leaves, treeHeight - 2, extraHeight, 1, 0);
    				grow(world, pos, leaves, treeHeight - 1, treeHeight + 1, 1, 1);
    				grow(world, pos, leaves, treeHeight - 1, treeHeight + 1, 2, 0);
    				grow(world, pos, leaves, treeHeight, 2, 1);
    				grow(world, pos, leaves, treeHeight, 2, -1);
    				break;
    			case 6: case 7:
    				setBlock(world, pos.offset(0, extraHeight, 0), leaves);
    				grow(world, pos, leaves, treeHeight, 1, 0);
    				break;
    			case 8: case 9: case 10: case 11:
    				setBlock(world, pos.offset(0, extraHeight, 0), leaves);
    				grow(world, pos, leaves, treeHeight - 1, extraHeight, 1, 0);
    				grow(world, pos, leaves, treeHeight, 1, 1);
    				if(treeType == 8 || treeType == 9) {
    					break;
    				}
    				for(int offset = -1; offset < 2; offset++) {
    					grow(world, pos, leaves, treeHeight, 2, offset);
    				}
    				break;
    			default:
    				//Roots
    				grow(world, pos, log, -2, -1, true);
    				grow(world, pos, log, -2, -1, 1, 0, true);
    				grow(world, pos, log, -1, 1, 1, true);
    				grow(world, pos, log, -1, 0, 2, 0, true);
    				grow(world, pos, log, -1, 1, 2, -1, true);
    				grow(world, pos, log, -1, 1, 2, 1, true);
    				grow(world, pos, log, -1, 2, 2, true);
    				grow(world, pos, log, -1, 3, 0, true);
    				//Trunk
    				grow(world, pos, leaves, 1, 2, 0);//Yes, that is intended
    				grow(world, pos, log, 2, 2, 0);
    				grow(world, pos, log, 1, 3, 1, 1);
    				grow(world, pos, log, 2, treeHeight, 1, 0);
    				//Leaves
    				grow(world, pos, leaves, treeHeight, treeHeight + 1, 1, 1);
    				grow(world, pos, log, extraHeight - 1, 1, 1);//Holds the leaves
    				setBlock(world, pos.offset(0, extraHeight, 0), leaves);
    				grow(world, pos, leaves, extraHeight, 1, 0);
    				grow(world, pos, leaves, extraHeight, 1, 1);
    				for(int offset = -1; offset < 2; offset++) {
    					grow(world, pos, leaves, treeHeight + 1, extraHeight - 1, 2, offset);
    				}
    			}
    			return true;
    		}
    	}
    	return false;
    }


}