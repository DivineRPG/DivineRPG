package divinerpg.world.gen.tree.feature;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
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
            int random = rand.nextInt(1) + 1;
            int treeHeight = 6;
            int extraHeight = treeHeight + random;

            if (!heightCheck(world, pos, extraHeight + 4, 1))
                return false;

            if (!canSustain(world, pos))
                return false;

            BlockPos.Mutable mut = new BlockPos.Mutable().set(pos.below());
            BlockState log = BlockRegistry.mortumLog.defaultBlockState();
            BlockState leaves = BlockRegistry.mortumLeaves.defaultBlockState();


            //Tree trunk
            for (int i = 0; i < extraHeight; i++) {
                setBlock(world, mut.move(Direction.UP), log);
            }
            chanceSetBlock(world, pos.offset(1, 0, 0), log, 1, false);
            chanceSetBlock(world, pos.offset(0, 0, 1), log, 1, false);
            chanceSetBlock(world, pos.offset(-1, 0, 0), log, 1, false);
            chanceSetBlock(world, pos.offset(0, 0, -1), log, 1, false);

            //Leaves
            setBlock(world, pos.offset(1, treeHeight - 3, 0), leaves);
            setBlock(world, pos.offset(1, treeHeight - 2, 0), leaves);
            setBlock(world, pos.offset(1, treeHeight - 1, 0), leaves);
            setBlock(world, pos.offset(1, treeHeight, 0), leaves);
            setBlock(world, pos.offset(1, treeHeight + 1, 0), leaves);
            setBlock(world, pos.offset(1, treeHeight + 2, 0), leaves);

            setBlock(world, pos.offset(-1, treeHeight - 3, 0), leaves);
            setBlock(world, pos.offset(-1, treeHeight - 2, 0), leaves);
            setBlock(world, pos.offset(-1, treeHeight - 1, 0), leaves);
            setBlock(world, pos.offset(-1, treeHeight, 0), leaves);
            setBlock(world, pos.offset(-1, treeHeight + 1, 0), leaves);
            setBlock(world, pos.offset(-1, treeHeight + 2, 0), leaves);

            setBlock(world, pos.offset(0, treeHeight - 3, 1), leaves);
            setBlock(world, pos.offset(0, treeHeight - 2, 1), leaves);
            setBlock(world, pos.offset(0, treeHeight - 1, 1), leaves);
            setBlock(world, pos.offset(0, treeHeight, 1), leaves);
            setBlock(world, pos.offset(0, treeHeight + 1, 1), leaves);

            setBlock(world, pos.offset(0, treeHeight - 3, -1), leaves);
            setBlock(world, pos.offset(0, treeHeight - 2, -1), leaves);
            setBlock(world, pos.offset(0, treeHeight - 1, -1), leaves);
            setBlock(world, pos.offset(0, treeHeight, -1), leaves);
            setBlock(world, pos.offset(0, treeHeight + 1, -1), leaves);
            setBlock(world, pos.offset(0, treeHeight + 2, -1), leaves);

            setBlock(world, pos.offset(0, treeHeight, 0), leaves);
            setBlock(world, pos.offset(0, treeHeight + 1, 0), leaves);
            setBlock(world, pos.offset(0, treeHeight + 2, 0), leaves);
            setBlock(world, pos.offset(0, treeHeight + 3, 0), leaves);

            return true;
        }
        return false;
    }


}