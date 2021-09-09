package divinerpg.world.gen.tree.feature;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.state.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;
import java.util.function.*;

public class WildwoodTreeFeature extends DivineTreeFeature {

    public WildwoodTreeFeature(Supplier<SaplingBlock> sapling) {
        super(sapling);
    }
    //TODO - redo wildwood tree all together

    public static final BooleanProperty UP = SixWayBlock.UP;
    public static final BooleanProperty NORTH = SixWayBlock.NORTH;
    public static final BooleanProperty EAST = SixWayBlock.EAST;
    public static final BooleanProperty SOUTH = SixWayBlock.SOUTH;
    public static final BooleanProperty WEST = SixWayBlock.WEST;
    @Override
    protected boolean gen(ISeedReader world, Random rand, BlockPos pos) {
    	int random = rand.nextInt(1) + 1;
        int treeHeight = 12;
        int extraHeight = treeHeight + random;

        if (!heightCheck(world, pos, extraHeight + 4, 1))
            return false;

        if (!canSustain(world, pos))
            return false;

        BlockPos.Mutable mut = new BlockPos.Mutable().set(pos.below());
        BlockState log = BlockRegistry.wildwoodLog.defaultBlockState();
        BlockState leaves = BlockRegistry.wildwoodLeaves.defaultBlockState();
//        BlockState upVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(UP, Boolean.TRUE);
        BlockState northVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(NORTH, Boolean.TRUE);
        BlockState eastVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(EAST, Boolean.TRUE);
        BlockState southVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(SOUTH, Boolean.TRUE);
        BlockState westVines = BlockRegistry.wildwoodVine.defaultBlockState().setValue(WEST, Boolean.TRUE);


        //Tree trunk
        for (int i = 0; i < extraHeight; i++) {
            setBlock(world, mut.move(Direction.UP), log);


            chanceSetBlock(world, pos.offset(0, i, -2), southVines, 1);
            chanceSetBlock(world, pos.offset(0, i, 2), northVines, 1);
            chanceSetBlock(world, pos.offset(-2, i , 0), eastVines, 1);
            chanceSetBlock(world, pos.offset(2, i, 0), westVines, 1);
        }
        chanceSetBlock(world, pos.offset(1, 0, 0), log, 1);
        chanceSetBlock(world, pos.offset(0, 0, 1), log, 1);
        chanceSetBlock(world, pos.offset(-1, 0, 0), log, 1);
        chanceSetBlock(world, pos.offset(0, 0, -1), log, 1);

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
}
