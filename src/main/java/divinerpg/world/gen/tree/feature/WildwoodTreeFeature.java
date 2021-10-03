package divinerpg.world.gen.tree.feature;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;
import java.util.function.*;

public class WildwoodTreeFeature extends DivineTreeFeature {
    public WildwoodTreeFeature(Supplier<SaplingBlock> sapling) {
        super(sapling);
    }
    private static final BlockState northVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(SixWayBlock.NORTH, true),
    		eastVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(SixWayBlock.EAST, true),
    		southVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(SixWayBlock.SOUTH, true),
    		westVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(SixWayBlock.WEST, true);
    private void growVines(ISeedReader world, BlockPos pos, int minY, int maxY, int width, int offset, boolean dynamicVines, int chance) {
    	if(dynamicVines && offset != 0) {
    		if(offset < 0) {
    			chanceSetBlock(world, pos.offset(width, minY, offset), eastVines, chance, false);
        		chanceSetBlock(world, pos.offset(-width, minY, -offset), westVines, chance, false);
        		chanceSetBlock(world, pos.offset(offset, minY, -width), southVines, chance, false);
        		chanceSetBlock(world, pos.offset(-offset, minY, width), northVines, chance, false);
    		} else {
    			chanceSetBlock(world, pos.offset(width, minY, offset), westVines, chance, false);
        		chanceSetBlock(world, pos.offset(-width, minY, -offset), eastVines, chance, false);
        		chanceSetBlock(world, pos.offset(offset, minY, -width), northVines, chance, false);
        		chanceSetBlock(world, pos.offset(-offset, minY, width), southVines, chance, false);
    		}
    	} else {
    		for(; minY < maxY + 1; minY++) {
        		chanceSetBlock(world, pos.offset(width, minY, offset), westVines, chance, false);
        		chanceSetBlock(world, pos.offset(-width, minY, -offset), eastVines, chance, false);
        		chanceSetBlock(world, pos.offset(offset, minY, -width), southVines, chance, false);
        		chanceSetBlock(world, pos.offset(-offset, minY, width), northVines, chance, false);
        	}
    	}
    }
    private void growTheLeaves(ISeedReader world, BlockPos pos, int minY, int maxY, int vineChance) {
    	for(int offset = -1; offset < 2; offset++) {
			grow(world, pos, BlockRegistry.wildwoodLeaves.defaultBlockState(), minY, maxY, 2, offset, false, 1);
			growVines(world, pos, minY, maxY, 3, offset, false, vineChance);
		}
    }
    @Override
    protected boolean gen(ISeedReader world, Random rand, BlockPos pos) {
    	if (canSustain(world, pos)) {
    		int treeHeight, extraHeight, treeType = rand.nextInt(3);
    		switch(treeType) {
    		case 0:
    			treeHeight = 2 + rand.nextInt(6);
    			extraHeight = treeHeight + 2;
    			break;
    		case 1:
    			treeHeight = 1 + rand.nextInt(4);
    			extraHeight = treeHeight + 3;
    			break;
    		default:
    			treeHeight = 3 + rand.nextInt(3);
            	extraHeight = treeHeight + 1;
    		}
    		if (heightCheck(world, pos, extraHeight, 1)) {
    			BlockState log = BlockRegistry.wildwoodLog.defaultBlockState(), leaves = BlockRegistry.wildwoodLeaves.defaultBlockState();
    	        switch(treeType) {
    	        case 0:
    	        	//Roots
    	        	grow(world, pos, log, -3, treeHeight - 5, 2, 0, true, 1);
    	        	grow(world, pos, log, -2, -1, 1, 1, true, 1);
    	        	grow(world, pos, log, treeHeight - 4, treeHeight - 3, 1, 0, true, 1);
    	        	growVines(world, pos, treeHeight - 4, treeHeight - 3, 1, 1, false, 2);
    	        	//Trunk
    	        	grow(world, pos, log, treeHeight - 4, treeHeight, true);
    	        	//Leaves
    	        	grow(world, pos, leaves, treeHeight - 1, treeHeight + 1, 1, 0, false, 1);
    	        	grow(world, pos, leaves, treeHeight, treeHeight + 1, 1, 1, false, 1);
    	        	setBlock(world, pos.offset(0, extraHeight, 0), leaves);
    	        	growTheLeaves(world, pos, treeHeight, treeHeight, 2);
    	        	grow(world, pos, leaves, treeHeight -1, treeHeight - 1, 1, 1, false, 2);
    	        	grow(world, pos, leaves, treeHeight, treeHeight, 2, 2, false, 2);
    	        	grow(world, pos, leaves, treeHeight + 1, treeHeight + 1, 2, 0, false, 2);
    	        	grow(world, pos, leaves, treeHeight + 2, treeHeight + 2, 1, 0, false, 2);
    	        	break;
    	        case 1:
    	        	//Roots
    	        	grow(world, pos, log, -2, -2, 1, 0, true, 1);
    	        	for(int offset = -1; offset < 2; offset++) {
        				grow(world, pos, log, -2, -2, 2, offset, true, 1);
        			}
    	        	//Trunk
    	        	grow(world, pos, log, -2, treeHeight, true);
    	        	int tempHeight;
    	        	if(treeHeight == 1) {
    	        		tempHeight = treeHeight - 1;
    	        	} else {
    	        		tempHeight = treeHeight - 2;
    	        	}
    	        	grow(world, pos, log, -1, tempHeight, 1, 0, true, 1, 2);
	        		grow(world, pos, log, -2, tempHeight, 1, 1, true, 1, 2);
	        		//Leaves
	        		setBlock(world, pos.offset(0, extraHeight, 0), leaves);
	        		grow(world, pos, leaves, treeHeight, treeHeight + 2, 1, 0, false, 1);
	        		grow(world, pos, leaves, treeHeight + 1, treeHeight + 2, 1, 1, false, 1);
	        		growTheLeaves(world, pos, treeHeight + 1, treeHeight + 1, 2);
	        		grow(world, pos, leaves, treeHeight, treeHeight, 1, 1, false, 2);
	        		grow(world, pos, leaves, treeHeight + 1, treeHeight + 1, 2, 2, false, 2);
    	        	break;
    	        default:
    	        	grow(world, pos, log, 0, treeHeight, false);
    	        	setBlock(world, pos.offset(0, extraHeight, 0), leaves);
                	grow(world, pos, leaves, treeHeight - 2, extraHeight, 1, 0, false, 1);
                	grow(world, pos, leaves, treeHeight - 2, treeHeight - 1, 1, 1, false, 1);
                	grow(world, pos, leaves, treeHeight -2, treeHeight -1, 2, 2, false, 2);
                	growTheLeaves(world, pos, treeHeight - 2, treeHeight - 1, 4);
                	grow(world, pos, leaves, treeHeight, treeHeight, 1, 1, false, 2);
    	        }
    	        return true;
    		}
    	}
    	return false;
    }
}