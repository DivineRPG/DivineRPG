package divinerpg.dimensions.wildwood;

import divinerpg.dimensions.LargeTwilightTree;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by LiteWolf101 on 10/8/2018.
 */
public class LargeWildWoodTree extends LargeTwilightTree {

    public LargeWildWoodTree(boolean notify, int minTrunkHeight) {
        this(notify, minTrunkHeight, BlockRegistry.wildwoodLog.getDefaultState(), BlockRegistry.wildwoodLeaves.getDefaultState(), BlockRegistry.wildwoodGrass);
    }

    public LargeWildWoodTree(boolean notify, int minTrunkHeight, IBlockState logState, IBlockState leavesState, Block grassBlock) {
        super(notify, minTrunkHeight, logState, leavesState, grassBlock);
    }

    @Override
    public boolean generate(World world, Random random, BlockPos blockPos) {
        int trunkHeight = random.nextInt(4) + minTrunkHeight;
        int treeHeight = 10 + trunkHeight;
        IBlockState groundState = world.getBlockState(blockPos.down());

        //return false if these conditions are met
        // Spawns only on grass
        if (blockPos.getY() <= 13 && blockPos.getY() + treeHeight + 1 >= world.getHeight()
                || groundState.getBlock() != grass) {
            return false;
        }

        return groundState.getBlock() == grass && generateTree(world, blockPos, treeHeight, trunkHeight);
    }
}
