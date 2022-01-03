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
        		int treeHeight = 3 + rand.nextInt(3), extraHeight = treeHeight + 1;
        		if (heightCheck(world, pos, extraHeight, 1)) {
        			BlockState log = BlockRegistry.mortumLog.defaultBlockState(), leaves = BlockRegistry.mortumLeaves.defaultBlockState().setValue(BlockModLeaves.DISTANCE, 1);
        			grow(world, pos, log, 0, treeHeight);
        			setBlock(world, pos.offset(0, extraHeight, 0), leaves);
                	grow(world, pos, leaves, treeHeight - 2, extraHeight, 1, 0);
                	grow(world, pos, leaves, treeHeight - 2, treeHeight - 1, 1, 1);
                	grow(world, pos, leaves, treeHeight -2, treeHeight -1, 2, 2, 2);
                	for(int offset = -1; offset < 2; offset++) {
        				grow(world, pos, leaves, treeHeight -2, treeHeight -1, 2, offset);
        			}
                	grow(world, pos, leaves, treeHeight, 1, 1, false, 2);
                	return true;
        		}
        	}
        }
        return false;
    }
}