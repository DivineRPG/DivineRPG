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
	private static final BlockState  leaves = BlockRegistry.wildwoodLeaves.defaultBlockState(),
			northVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(SixWayBlock.NORTH, true),
    		eastVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(SixWayBlock.EAST, true),
    		southVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(SixWayBlock.SOUTH, true),
    		westVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(SixWayBlock.WEST, true),
    		log = BlockRegistry.wildwoodLog.defaultBlockState();
	
    private void growLeavesWithVines(ISeedReader world, BlockPos pos, int y, int width, int offset, int leavesChance, int vineChance) {
    	chanceSetBlock(world, pos.offset(width, y, offset), leaves, leavesChance, false);
		if(!isAir(world, pos.offset(width, y, offset))) {
			setBlockSensitive(world, pos.offset(width + 1, y, offset), westVines, vineChance);
		}
		chanceSetBlock(world, pos.offset(-width, y, -offset), leaves, leavesChance, false);
		if(!isAir(world, pos.offset(-width, y, -offset))) {
			setBlockSensitive(world, pos.offset(-width - 1, y, -offset), eastVines, vineChance);
		}
		chanceSetBlock(world, pos.offset(offset, y, -width), leaves, leavesChance, false);
		if(!isAir(world, pos.offset(offset, y, -width))) {
			setBlockSensitive(world, pos.offset(offset, y, -width - 1), southVines, vineChance);
		}
		chanceSetBlock(world, pos.offset(-offset, y, width), leaves, leavesChance, false);
		if(!isAir(world, pos.offset(-offset, y, width))) {
			setBlockSensitive(world, pos.offset(-offset, y, width + 1), northVines, vineChance);
		}
    }
	private void growVines(ISeedReader world, BlockPos pos, int minY, int maxY, int width, int offset, int chance) {
    	for(; minY < maxY + 1; minY++) {
    		setBlockSensitive(world, pos.offset(width, minY, offset), westVines, chance);
    		setBlockSensitive(world, pos.offset(-width, minY, -offset), eastVines, chance);
    		setBlockSensitive(world, pos.offset(offset, minY, -width), southVines, chance);
    		setBlockSensitive(world, pos.offset(-offset, minY, width), northVines, chance);
    	}
    }
    private void growTheLeaves(ISeedReader world, BlockPos pos, int minY, int maxY, int vineChance) {
    	for(byte offset = -1; offset < 2; offset++) {
			grow(world, pos, leaves, minY, maxY, 2, offset);
			growVines(world, pos, minY, maxY, 3, offset, vineChance);
		}
    }
    @Override
    protected boolean gen(ISeedReader world, Random rand, BlockPos pos) {
    	if (canSustain(world, pos)) {
    		int treeHeight, extraHeight, treeType = rand.nextInt(7);
    		switch(treeType) {
    		case 0:
    			//Swamp
    			treeHeight = 1 + rand.nextInt(4);
    			extraHeight = treeHeight + 3;
    			break;
    		case 1:
    			//Shroomcap tree
    			treeHeight = 6 + rand.nextInt(4);
    			extraHeight = treeHeight + 1;
    			break;
    		case 2:
    			//BranchTree
    			if(rand.nextInt(32) == 0) {
    				treeHeight = 15;
    				extraHeight = 16;
    			} else {
    				treeHeight = 5 + rand.nextInt(2);
        			extraHeight = treeHeight + 1;
    			}
    			break;
    		case 3:
    			//Big Jungle-Mangrove tree
    			treeHeight = 7 + rand.nextInt(4);
    			extraHeight = treeHeight + 2;
    			break;
    		case 4:
    			//Small bush
    			treeHeight = 1 + rand.nextInt(2);
    			extraHeight = treeHeight + 1;
    			break;
    		case 5:
    			//Mangrove
    			treeHeight = 2 + rand.nextInt(6);
    			extraHeight = treeHeight + 1;
    			break;
    		default:
    			//Vanilla
    			treeHeight = 3 + rand.nextInt(3);
            	extraHeight = treeHeight + 1;
    		}
    		if (heightCheck(world, pos, extraHeight, 1)) {
    	        switch(treeType) {
    	        case 0:
    	        	//Roots
    	        	grow(world, pos, log, -2, 1, 0, true);
    	        	for(int offset = -1; offset < 2; offset++) {
        				grow(world, pos, log, -2, 2, offset, true);
        			}
    	        	//Trunk
    	        	grow(world, pos, log, -2, treeHeight, true);
    	        	grow(world, pos, log, -1, 1, 1, 0, true);
	        		grow(world, pos, log, -2, 0, 1, 1, true);
	        		//Leaves
	        		setBlock(world, pos.offset(0, extraHeight, 0), leaves);
	        		grow(world, pos, leaves, treeHeight, treeHeight + 2, 1, 0);
	        		grow(world, pos, leaves, treeHeight + 1, treeHeight + 2, 1, 1);
	        		growTheLeaves(world, pos, treeHeight + 1, treeHeight + 1, 2);
	        		grow(world, pos, leaves, treeHeight, 1, 1, false, 2);
	        		grow(world, pos, leaves, treeHeight + 1, 2, 2, false, 2);
	        		for(int offset = -1; offset < 2; offset++) {
	        			growLeavesWithVines(world, pos, treeHeight, 2, offset, 2, 2);
	        		}
    	        	break;
    	        case 1:
    	        	//Roots
    	        	grow(world, pos, log, -1, 3, 1, true);
    	        	grow(world, pos, log, -1, 3, -1, true);
    	        	grow(world, pos, log, -2, -1, 2, 2, true);
    	        	//Trunk
    	        	grow(world, pos, log, -treeHeight/2, treeHeight, true);
    	        	grow(world, pos, log, -treeHeight/3, 1, 1, 0);
    	        	grow(world, pos, log, -treeHeight/4, 0, 1, 1);
    	        	grow(world, pos, log, -1, 0, 2, 0, true);
    	        	growVines(world, pos, 0, 0, 3, 0, 1);
    	        	growVines(world, pos, 0, 0, 2, 1, 2);
    	        	growVines(world, pos, 0, 0, 2, -1, 2);
    	        	//Leaves
    	        	int w = rand.nextInt(2);
    	        	grow(world, pos, log, treeHeight - 1, 1, 0, false);
    	        	grow(world, pos, log, treeHeight - 3, 1, 0, false);
    	        	if(w == 1) {
    	        		grow(world, pos, log, treeHeight - 3, 2, 0, false);
    	        	}
    	        	grow(world, pos, log, treeHeight - 4, 2 + w, 1, false);
    	        	grow(world, pos, log, treeHeight - 4, 2 + w, -1, false);
    	        	grow(world, pos, log, treeHeight - 5, 3 + w, 0, false);
    	        	grow(world, pos, log, treeHeight - 5, 3 + w, 2, false);
    	        	grow(world, pos, log, treeHeight - 5, 3 + w, -2, false);
    	        	growVines(world, pos, treeHeight - 5, treeHeight - 5, -2 - w, 0, 2);
    	        	growVines(world, pos, treeHeight - 5, treeHeight - 5, -2 - w, 2, 2);
    	        	growVines(world, pos, treeHeight - 5, treeHeight - 5, -2 - w, -2, 2);
    	        	growVines(world, pos, treeHeight - 4, treeHeight - 4, -1 - w, 1, 2);
    	        	growVines(world, pos, treeHeight - 4, treeHeight - 4, -1 - w, -1, 2);
    	        	grow(world, pos, leaves, treeHeight - 5, 3 + w, 1);
    	        	grow(world, pos, leaves, treeHeight - 5, 3 + w, -1);
    	        	if(w == 1) {
    	        		grow(world, pos, leaves, treeHeight - 5, 4, 3);
    	        		grow(world, pos, leaves, treeHeight - 5, 4, -3);
    	        		grow(world, pos, leaves, treeHeight - 4, 3, 2);
    	        		grow(world, pos, leaves, treeHeight - 4, 3, -2);
    	        		grow(world, pos, leaves, treeHeight - 4, 3, 3);
    	        		grow(world, pos, leaves, treeHeight - 3, 2, 2);
    	        		grow(world, pos, leaves, treeHeight - 3, 2, 1);
    	        		grow(world, pos, leaves, treeHeight - 3, 2, -1);
    	        	} else {
    	        		grow(world, pos, leaves, treeHeight - 4, 2, 2);
    	        	}
	        		grow(world, pos, leaves, treeHeight - 5, 3, 3);
	        		growVines(world, pos.offset(0, treeHeight - 5, 0), 0, 0, 4, 3 + w, 2);
	        		grow(world, pos, leaves, treeHeight - 3, treeHeight - 1, 1, 1);
	        		grow(world, pos, leaves, treeHeight - 2, treeHeight - 1, 2, 0);
	        		setBlock(world, pos.offset(0, treeHeight - 2, 0), leaves);
	        		grow(world, pos, leaves, treeHeight, 1, 0);
	        		setBlock(world, pos.offset(0, extraHeight, 0), leaves);
    	        	for(byte i = -2; i < 3; i++) {
    	        		grow(world, pos, leaves, treeHeight - 5, 4 + w, i);
    	        		growVines(world, pos, treeHeight - 5, treeHeight - 5, 5 + w, i, 2);
    	        		grow(world, pos, leaves, treeHeight - 4, 3 + w, i);
    	        		if(i > -2 && i < 2) {
    	        			grow(world, pos, leaves, treeHeight - 3, 2 + w, i);
    	        		}
    	        	}
    	        	break;
    	        case 2:
    	        	int trunkY = treeHeight/3;
    	        	//Trunk
    	        	grow(world, pos, log, 0, trunkY);
    	        	//Leaves
    	        	if(treeHeight == 15) {
    	        		grow(world, pos, log, trunkY + 1, 1, 0);
    	        		grow(world, pos, log, trunkY + 2, 2, 1);
    	        		int offset = 1, width;
    	        		for(int y = trunkY + 3; y < treeHeight + 1; y++) {
    	        			offset++;
    	        			if(offset == 2) {
    	        				offset = -2;
    	        				width = 2;
    	        			} else {
    	        				width = 3;
    	        			}
    	        			grow(world, pos, log, y, width, offset);
    	        			grow(world, pos, leaves, y + 1, width, offset);
    	        			growLeavesWithVines(world, pos.offset(width, y, offset), 0, 1, 0, 1, 2);
    	        			growLeavesWithVines(world, pos.offset(-width, y, -offset), 0, 1, 0, 1, 2);
    	        			growLeavesWithVines(world, pos.offset(offset, y, -width), 0, 1, 0, 1, 2);
    	        			growLeavesWithVines(world, pos.offset(-offset, y, width), 0, 1, 0, 1, 2);
    	        		}
    	        		grow(world, pos, leaves, trunkY + 1, trunkY + 2);
    	        		grow(world, pos, leaves, trunkY + 2, 1, 0);
    	        		grow(world, pos, leaves, trunkY + 1, trunkY + 2, 1, 1);
    	        		grow(world, pos, leaves, trunkY + 1, trunkY + 2, 2, 0);
    	        		grow(world, pos, leaves, trunkY + 2, 3, 1);
    	        		grow(world, pos, leaves, trunkY + 2, 2, 2);
    	        		grow(world, pos, leaves, extraHeight, 3, offset);
    	        	} else {
    	        		int length = treeHeight - trunkY;
	    	        	for(int i = rand.nextInt(4) == 0 ? 0 : 1; i < 3; i++) {
	    	        		if(i == 2) {
	    	        			treeHeight -= rand.nextInt(3);
	    	        		}
	    	        		double stepX = (double) ((-3D + rand.nextDouble() * 7)/length), stepZ = (double) ((-3D + rand.nextDouble() * 7)/length);
	        	        	double x = 0D, z = 0D;
	        	        	for(int y = 1; y < length + 1; y++) {
	        	        		x += stepX;
	        	        		z += stepZ;
	    	        			setBlock(world, pos.offset(x, trunkY + y, z), log);
	        	        		grow(world, pos.offset(x, trunkY + y, z), leaves, 0, 1, 0);
	        	        		growLeavesWithVines(world, pos.offset(x, trunkY + y, z), 0, 1, 1, 2, 3);
	        	        		if(y > 1 && trunkY + y < treeHeight) {
	    	        				growLeavesWithVines(world, pos.offset(x, trunkY + y, z), 0, 2, 0, 3, 2);
	    	        			}
	        	        	}
	        	        	setBlock(world, pos.offset(x, extraHeight, z), leaves);
	    	        	}
    	        	}
    	        	break;
    	        case 3:
    	        	//Trunk
    	        	int destX = -3 + rand.nextInt(7), destZ = -3 + rand.nextInt(7);
    	        	double stepX = (double) destX / (treeHeight + 1), stepZ = (double) destZ / (treeHeight + 1),
    	        	x = 0, z = 0;
    	        	for(int y = 1; y < treeHeight + 1; y++) {
    	        		long pX = Math.round(x), pZ = Math.round(z);
    	        		setBlock(world, pos.offset(pX, y, pZ), log);
    	        		grow(world, pos.offset(pX, y, pZ), log, 0, 1, 0);
    	        		growVines(world, pos.offset(pX, y, pZ), 0, 0, 2, 0, 3);
    	        		x += stepX;
    	        		z += stepZ;
    	        	}
    	        	grow(world, pos, log, 2, 1, 0);
    	        	grow(world, pos, log, -1, 0, true);
    	        	grow(world, pos, log, 1, 2, 1, 1);
    	        	grow(world, pos, log, -2, 1, 2, 0, true);
    	        	grow(world, pos, log, -2, 0, 2, 2, true);
    	        	//Leaves
    	        	BlockPos p = pos.offset(destX, treeHeight, destZ);
    	        	setBlock(world, p, log);
    	        	setBlock(world, p.offset(0, 1, 0), leaves);
    	        	grow(world, p, leaves, 0, 1, 1, 0);
    	        	grow(world, p, log, 0, 1, 1);
    	        	grow(world, p, leaves, 1, 1, 1);
    	        	for(int i = -2; i < 2; i++) {
    	        		if(Math.abs(i) == 1) {
    	        			grow(world, p, log, 0, 2, i);
    	        			grow(world, p, leaves, 1, 2, i);
    	        		} else {
    	        			grow(world, p, leaves, 0, 1, 2, i);
    	        		}
    	        		growLeavesWithVines(world, p, 0, 3, i, 1, 2);
    	        		growLeavesWithVines(world, p, -1, 3, i, 3, 1);
    	        	}
    	        	growLeavesWithVines(world, p, 0, 3, 2, 1, 2);
    	        	grow(world, p, leaves, 2, 1, 0);
    	        	setBlock(world, p.offset(0, 2, 0), leaves);
    	        	break;
    	        case 4:
    	        	grow(world, pos, log, 0, treeHeight, true);
    	        	grow(world, pos, leaves, treeHeight, 1, 0);
    	        	setBlock(world, pos.offset(0, extraHeight, 0), leaves);
    	        	break;
    	        case 5:
	        		//Roots
    	        	grow(world, pos, log, -3, treeHeight - 5, 2, 0, true);
    	        	grow(world, pos, log, -2, -1, 1, 1, true);
    	        	grow(world, pos, log, treeHeight - 4, treeHeight - 3, 1, 0, true);
    	        	growVines(world, pos, treeHeight - 4, treeHeight - 3, 1, 1, 2);
    	        	pos = pos.offset(0, treeHeight - 4, 0);
    	        	//Fall-Through
    	        default:
    	        	grow(world, pos, log, 0, treeHeight);
    	        	setBlock(world, pos.offset(0, extraHeight, 0), leaves);
                	grow(world, pos, leaves, treeHeight - 2, extraHeight, 1, 0);
                	grow(world, pos, leaves, treeHeight - 2, treeHeight - 1, 1, 1);
                	grow(world, pos, leaves, treeHeight - 2, treeHeight -1, 2, 2, 2);
                	growTheLeaves(world, pos, treeHeight - 2, treeHeight - 1, 4);
                	grow(world, pos, leaves, treeHeight, 1, 1, false, 2);
                	for(int offset = -1; offset < 2; offset++) {
                		growLeavesWithVines(world, pos, treeHeight - 3, 2, offset, 3, 1);
                	}
    	        }
    	        return true;
    		}
    	}
    	return false;
    }
}