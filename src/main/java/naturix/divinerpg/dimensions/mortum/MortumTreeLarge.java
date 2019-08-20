package naturix.divinerpg.dimensions.mortum;

import java.util.Random;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

/**
 * Created by LiteWolf101 on 10/8/2018.
 */
public class MortumTreeLarge extends WorldGenAbstractTree {
    private int minTrunkHeight = 3;
    protected IBlockState log = ModBlocks.mortumLogs.getDefaultState();
    protected IBlockState leaves = ModBlocks.mortumLeaves.getDefaultState();

    public MortumTreeLarge(boolean notify, int minTrunkHeight) {
        super(notify);
        this.minTrunkHeight = minTrunkHeight;

    }

    @Override
    public boolean generate(World world, Random random, BlockPos blockPos) {
        int trunkHeight = random.nextInt(4) + minTrunkHeight;
        int treeHeight = 10 + trunkHeight;
        IBlockState groundState = world.getBlockState(blockPos.down());

        //return false if these conditions are met
        // Spawns only on grass
        if (blockPos.getY() <= 13 && blockPos.getY() + treeHeight + 1 >= world.getHeight()
                || groundState.getBlock() != ModBlocks.mortumGrass) {
            return false;
        }

        //Build-a-trees!
        //We generate leaves first so that they can appropriately be replaced by logs
        buildLeaves1(world, blockPos, trunkHeight + 2);
        buildLeaves2(world, blockPos, trunkHeight + 3);
        buildLeaves3(world, blockPos, trunkHeight + 4);
        buildLeaves4(world, blockPos, trunkHeight + 5);
        buildLeaves5(world, blockPos, trunkHeight + 6);
        buildLeaves4(world, blockPos, trunkHeight + 7);
        buildLeaves6(world, blockPos, trunkHeight + 8);
        buildLeaves6(world, blockPos, treeHeight);
        buildTrunk(world, blockPos, treeHeight);
        buildBranchBase(world, blockPos, trunkHeight);
        buildBranches(world, blockPos, trunkHeight + 2);
        buildBranchBase(world, blockPos, trunkHeight + 4);
        buildBranches2(world, blockPos, trunkHeight + 6);
        setTreeHeight(world, blockPos, treeHeight);
        return true;
    }

    private void buildLeaves6(World world, BlockPos blockPos, int height) {
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, -1), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, 1), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-1, height, 0), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(1, height, 0), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height + 1, 0), leaves);
    }

    private void buildLeaves5(World world, BlockPos blockPos, int height) {
        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 5; z++) {
                this.setBlockAndNotifyAdequately(world, blockPos.add(x - 1, height, z - 2), leaves);
            }
        }
        for (int x = 0; x < 5; x++) {
            for (int z = 0; z < 3; z++) {
                this.setBlockAndNotifyAdequately(world, blockPos.add(x - 2, height, z - 1), leaves);
            }
        }
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, -3), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, 3), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-3, height, 0), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(3, height, 0), leaves);
    }

    private void buildLeaves4(World world, BlockPos blockPos, int height) {
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, -1), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, 1), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-1, height, 0), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(1, height, 0), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, -2), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(1, height, -1), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(2, height, 0), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(1, height, 1), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, 2), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-1, height, 1), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-2, height, 0), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-1, height, -1), leaves);
    }

    private void buildLeaves3(World world, BlockPos blockPos, int height) {
        for (int x = 0; x <= 4; x++) {
            for (int z = 0; z <= 4; z++) {
                this.setBlockAndNotifyAdequately(world, blockPos.add(x - 2, height, z - 2), leaves);
            }
        }
        for (int length = 2; length <= 3; length++) {
            this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, -length - 1), leaves);
            this.setBlockAndNotifyAdequately(world, blockPos.add(length, height, -length), leaves);
            this.setBlockAndNotifyAdequately(world, blockPos.add(length + 1, height, 0), leaves);
            this.setBlockAndNotifyAdequately(world, blockPos.add(length, height, length), leaves);
            this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, length + 1), leaves);
            this.setBlockAndNotifyAdequately(world, blockPos.add(-length, height, length), leaves);
            this.setBlockAndNotifyAdequately(world, blockPos.add(-length - 1, height, 0), leaves);
            this.setBlockAndNotifyAdequately(world, blockPos.add(-length, height, -length), leaves);
        }
    }

    private void buildLeaves2(World world, BlockPos blockPos, int height) {
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, -5), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, 5), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-5, height, 0), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(5, height, 0), leaves);

        this.setBlockAndNotifyAdequately(world, blockPos.add(1, height, -4), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(1, height, 4), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-4, height, 1), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(4, height, 1), leaves);

        this.setBlockAndNotifyAdequately(world, blockPos.add(-1, height, -4), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-1, height, 4), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-4, height, -1), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(4, height, -1), leaves);

        this.setBlockAndNotifyAdequately(world, blockPos.add(3, height, 4), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(3, height, -4), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-3, height, 4), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-3, height, -4), leaves);

        this.setBlockAndNotifyAdequately(world, blockPos.add(4, height, 3), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(4, height, -3), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-4, height, 3), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-4, height, -3), leaves);

        for (int x = -1; x <= 5; x++) {
            for (int z = -1; z <= 5; z++) {
                this.setBlockAndNotifyAdequately(world, blockPos.add(x - 2, height, z - 2), leaves);
            }
        }
    }

    private void buildLeaves1(World world, BlockPos blockPos, int height) {
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, -1), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, 1), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-1, height, 0), leaves);
        this.setBlockAndNotifyAdequately(world, blockPos.add(1, height, 0), leaves);
    }

    private void buildBranches2(World world, BlockPos blockPos, int height) {
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, -2), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, 2), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-2, height, 0), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(2, height, 0), log);
    }

    private void buildBranches(World world, BlockPos blockPos, int height) {
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, -2), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(1, height, -1), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(2, height, 0), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(1, height, 1), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, height, 2), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-1, height, 1), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-2, height, 0), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-1, height, -1), log);
        for (int length = 2; length <= 3; length++) {
            //north
            this.setBlockAndNotifyAdequately(world, blockPos.add(0, height + 1, -length - 1), log);
            //northeast
            this.setBlockAndNotifyAdequately(world, blockPos.add(length, height + 1, -length), log);
            //east
            this.setBlockAndNotifyAdequately(world, blockPos.add(length + 1, height + 1, 0), log);
            //southeast
            this.setBlockAndNotifyAdequately(world, blockPos.add(length, height + 1, length), log);
            //south
            this.setBlockAndNotifyAdequately(world, blockPos.add(0, height + 1, length + 1), log);
            //southwest
            this.setBlockAndNotifyAdequately(world, blockPos.add(-length, height + 1, length), log);
            //west
            this.setBlockAndNotifyAdequately(world, blockPos.add(-length - 1, height + 1, 0), log);
            //northwest
            this.setBlockAndNotifyAdequately(world, blockPos.add(-length, height + 1, -length), log);
        }
    }

    private void buildBranchBase(World world, BlockPos blockPos, int trunkHeight) {
        for (int dy = trunkHeight; dy <= trunkHeight + 1; dy++) {
            this.setBlockAndNotifyAdequately(world, blockPos.add(0, dy, -1), log);
            this.setBlockAndNotifyAdequately(world, blockPos.add(0, dy, 1), log);
            this.setBlockAndNotifyAdequately(world, blockPos.add(-1, dy, 0), log);
            this.setBlockAndNotifyAdequately(world, blockPos.add(1, dy, 0), log);
        }
    }

    private void buildTrunk(World world, BlockPos blockPos, int treeHeight) {
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, -1, -1), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(0, -1, 1), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(-1, -1, 0), log);
        this.setBlockAndNotifyAdequately(world, blockPos.add(1, -1, 0), log);
        for (int dy = -1; dy <= treeHeight; dy++) {
            this.setBlockAndNotifyAdequately(world, blockPos.add(0, dy, 0), log);
        }
    }

    private int setTreeHeight(World world, BlockPos pos, int treeHeight) {
        return treeHeight;
    }

    public int getTreeHeight(World world, BlockPos pos, int treeHeight) {
        return this.setTreeHeight(world, pos, treeHeight);
    }
}
