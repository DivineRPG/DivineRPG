package divinerpg.world.gen.tree.feature;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;
import java.util.function.*;

public class MortumTreeFeature extends DivineTreeFeature {

    public MortumTreeFeature(Supplier<SaplingBlock> saplingBlock) {
        super(saplingBlock);
    }

    @Override
    protected boolean gen(ISeedReader world, Random rand, BlockPos pos) {
        if(world.getBlockState(pos.below()).getMaterial() == Material.DIRT || world.getBlockState(pos.below()).getMaterial() == Material.GRASS) {
        	if (canSustain(world, pos)) {
        		int treeHeight, extraHeight, treeType = rand.nextInt(4);
            	switch(treeType) {
            	case 0:
                	treeHeight = 2 + rand.nextInt(4);
                	extraHeight = treeHeight + 1;
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
                	extraHeight = treeHeight + 1;
            	}
            	if (heightCheck(world, pos, extraHeight, 1)) {
                    BlockState log = BlockRegistry.mortumLog.defaultBlockState(), leaves = BlockRegistry.mortumLeaves.defaultBlockState().setValue(BlockModLeaves.DISTANCE, 1);
                    //Main trunk
                    grow(world, pos, log, 0, treeHeight);
                    switch(treeType) {
                	case 0:
                		setBlock(world, pos.offset(0, extraHeight, 0), leaves);
                		extraHeight = 1 + rand.nextInt(2);
                		grow(world, pos, leaves, extraHeight, treeHeight, 1, 0);
                		grow(world, pos, leaves, extraHeight + 1, treeHeight - 1, 1, 1);
                		break;
                	case 1:
                		//Tree roots
                		setBlock(world, pos.offset(0, -1, 0), log, true);
                		grow(world, pos, log, -1, 1, 0, true);
                		//Leaves
                		setBlock(world, pos.offset(0, extraHeight, 0), leaves);
                		grow(world, pos, leaves, treeHeight - 1, extraHeight, 1, 0);
                		grow(world, pos, leaves, treeHeight, 1, 1);
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
        }
        return false;
    }
}