package naturix.divinerpg.dimensions.iceika.worldgen.trees;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

/**
 * Created by LiteWolf101 on Jan
 * /24/2019
 */
public class LargeThinIceTree extends WorldGenAbstractTree {
    private int minTrunkHeight = 5;
    protected IBlockState log = ModBlocks.frozenLog.getDefaultState();
    protected IBlockState leaves = ModBlocks.brittleLeaves.getDefaultState();

    public LargeThinIceTree(boolean notify, int minTrunkHeight) {
        super(notify);
        this.minTrunkHeight = minTrunkHeight;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos blockPos) {
        int trunkHeight = rand.nextInt(4) + minTrunkHeight;
        int branchSectionNum = rand.nextInt(7) + 10;
        int treeHeight = trunkHeight + (branchSectionNum * 2);
        Material materialBelow = worldIn.getBlockState(blockPos.down()).getMaterial();
        if (blockPos.getY() <= worldIn.getSeaLevel() && blockPos.getY() + treeHeight + 1 >= worldIn.getHeight() || materialBelow != Material.GRASS && materialBelow != Material.GROUND) {
            return false;
        }
        generateTrunk(worldIn, blockPos, trunkHeight);
        generateBranchLayer(worldIn, blockPos, branchSectionNum, trunkHeight + 1);
        return true;
    }

    private void generateTrunk(World worldIn, BlockPos blockPos, int trunkHeight) {
        for (int y = 0; y <= trunkHeight; y++) {
            setBlockAndNotifyAdequately(worldIn, blockPos.up(y), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(1, y, 0), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(1, y, 1), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(0, y, 1), log);
        }
    }

    private void generateBranchLayer(World worldIn, BlockPos blockPos, int branchSectionNum, int trunkHeight) {
        for (int y = 0; y <= branchSectionNum*2; y++) {
            if (y % 2 == 1) {
                for (int x = -1; x <= 2; x++) {
                    for (int z = -2; z <= 3; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), leaves);
                    }
                }
                for (int x = -2; x <= 3; x++) {
                    for (int z = -1; z <= 2; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), leaves);
                    }
                }
            }
            if (y % 2 == 0) {
                for (int x = 0; x <= 1; x++) {
                    for (int z = -1; z <= 2; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), leaves);
                    }
                }
                for (int x = -1; x <= 2; x++) {
                    for (int z = 0; z <= 1; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), leaves);
                    }
                }
            }
            setBlockAndNotifyAdequately(worldIn, blockPos.up(y + trunkHeight), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(1, y + trunkHeight, 0), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(1, y + trunkHeight, 1), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(0, y + trunkHeight, 1), log);
        }
        //generate top
        for (int x = 0; x <= 1; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*2) + trunkHeight + 1, z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*2) + trunkHeight + 2, z), leaves);
            }
        }
        for (int x = -1; x <= 2; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*2) + trunkHeight + 2, z), leaves);
            }
        }

    }

    protected boolean canGrowInto(Block blockType)
    {
        Material material = blockType.getDefaultState().getMaterial();
        return material == Material.AIR || material == Material.LEAVES || blockType == Blocks.GRASS || blockType == Blocks.DIRT || blockType == Blocks.LOG || blockType == Blocks.LOG2 || blockType == Blocks.SAPLING || blockType == Blocks.VINE;
    }

    public static int getDefaultMinTrunkHeight () {
        return 5;
    }
}
