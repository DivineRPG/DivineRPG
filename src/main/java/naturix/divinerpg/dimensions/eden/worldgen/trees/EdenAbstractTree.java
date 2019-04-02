package naturix.divinerpg.dimensions.eden.worldgen.trees;

import java.util.Random;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class EdenAbstractTree extends WorldGenAbstractTree {
    private int minTreeHeight;
    protected IBlockState log = ModBlocks.edenLogs.getDefaultState();
    protected IBlockState leaves = ModBlocks.edenLeaves.getDefaultState();

    public EdenAbstractTree(boolean notify) {
        this(notify, 13);
    }

    public EdenAbstractTree(boolean notify, int minTreeHeightIn) {
        super(notify);
        this.minTreeHeight = minTreeHeightIn;
        log = ModBlocks.edenLogs.getDefaultState();
        leaves = ModBlocks.edenLeaves.getDefaultState();
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int treeHeight = rand.nextInt(3) + minTreeHeight;
        int randBranchNum = 0;
        Material materialBelow = worldIn.getBlockState(position.down()).getMaterial();

        if (position.getY() < 1 || position.getY() + treeHeight + 1 > 256 || worldIn.getBlockState(position.down()).getBlock() != ModBlocks.edenGrass || position.getY() >= 256 - treeHeight - 1) {
            return false;
        }
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                for (int y = 0; y <= treeHeight; y++) {
                    if (worldIn.getBlockState(new BlockPos(position.getX() + x, position.getY() + y, position.getZ() + z)).getBlock() != Blocks.AIR) {
                        return false;
                    }
                }
            }
        }

        buildTrunk(worldIn, position, treeHeight);
        return true;
    }

    private void buildTrunk(World world, BlockPos pos, int treeHeight) {
        Random random = new Random();
        int rand = random.nextInt(1) + 1;
        int extraHeight = treeHeight + rand;
        this.setBlockAndNotifyAdequately(world, pos.add(1, 0, 0), log);
        this.setBlockAndNotifyAdequately(world, pos.add(0, 0, 1), log);
        this.setBlockAndNotifyAdequately(world, pos.add(-1, 0, 0), log);
        this.setBlockAndNotifyAdequately(world, pos.add(0, 0, -1), log);
        this.setBlockAndNotifyAdequately(world, pos.add(1, 1, 0), log);
        this.setBlockAndNotifyAdequately(world, pos.add(0, 1, 1), log);
        this.setBlockAndNotifyAdequately(world, pos.add(-1, 1, 0), log);
        this.setBlockAndNotifyAdequately(world, pos.add(0, 1, -1), log);
        drawLeafCircle(world, pos.add(0, extraHeight - 1, 0), 1, leaves);
        drawLeafCircle(world, pos.add(0, extraHeight, 0), 2, leaves);
        drawLeafCircle(world, pos.add(0, extraHeight + 1, 0), 1, leaves);
        drawLeafCircle(world, pos.add(0, extraHeight + 2, 0), 0, leaves);
        for (int dy = 0; dy < extraHeight; dy++) {
            this.setBlockAndNotifyAdequately(world, pos.add(0, dy, 0), log);
        }
    }

    private void drawLeafCircle(World world, BlockPos pos, int rad, IBlockState baseState) {
        for (byte dx = 0; dx <= rad; dx++) {
            for (byte dz = 0; dz <= rad; dz++) {
                int dist = (int) (Math.max(dx, dz) + (Math.min(dx, dz) * 0.5));
                if (dx == 3 && dz == 3) {
                    dist = 6;
                }
                if (dx == 0) {
                    // two!
                    if (dz < rad) {
                        setBlockAndNotifyAdequately(world, pos.add(0, 0, dz), baseState);
                        setBlockAndNotifyAdequately(world, pos.add(0, 0, -dz), baseState);
                    } else {
                        setBlockAndNotifyAdequately(world, pos.add(0, 0, dz), leaves);
                        setBlockAndNotifyAdequately(world, pos.add(0, 0, -dz), leaves);
                    }
                } else if (dz == 0) {
                    // two!
                    if (dx < rad) {
                        setBlockAndNotifyAdequately(world, pos.add(dx, 0, 0), baseState);
                        setBlockAndNotifyAdequately(world, pos.add(-dx, 0, 0), baseState);
                    } else {
                        setBlockAndNotifyAdequately(world, pos.add(dx, 0, 0), leaves);
                        setBlockAndNotifyAdequately(world, pos.add(-dx, 0, 0), leaves);
                    }
                } else if (dist < rad) {
                    // do four at a time for easiness!
                    setBlockAndNotifyAdequately(world, pos.add(dx, 0, dz), baseState);
                    setBlockAndNotifyAdequately(world, pos.add(dx, 0, -dz), baseState);
                    setBlockAndNotifyAdequately(world, pos.add(-dx, 0, dz), baseState);
                    setBlockAndNotifyAdequately(world, pos.add(-dx, 0, -dz), baseState);
                } else if (dist == rad) {
                    // do four at a time for easiness!
                    setBlockAndNotifyAdequately(world, pos.add(dx, 0, dz), leaves);
                    setBlockAndNotifyAdequately(world, pos.add(dx, 0, -dz), leaves);
                    setBlockAndNotifyAdequately(world, pos.add(-dx, 0, dz), leaves);
                    setBlockAndNotifyAdequately(world, pos.add(-dx, 0, -dz), leaves);
                }
            }
        }
    }
}