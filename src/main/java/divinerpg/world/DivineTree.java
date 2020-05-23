package divinerpg.world;

import java.util.Random;

import javax.annotation.ParametersAreNonnullByDefault;

import divinerpg.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class DivineTree extends WorldGenAbstractTree {
    private final int minTreeHeight;

    public DivineTree(boolean notify) {
        this(notify, 5);
    }

    public DivineTree(boolean notify, int minTreeHeightIn) {
        super(notify);
        this.minTreeHeight = minTreeHeightIn;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean generate(World worldIn, Random rand, BlockPos blockPos) {
        final BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        int treeHeight = rand.nextInt(3) + this.minTreeHeight;
        boolean canGenerate = true;
        int treeTopPos = blockPos.getY() + treeHeight;

        // Check if tree would fit and can be generated
        if (blockPos.getY() >= 1 && treeTopPos <= 255) {
            for (int iPosY = blockPos.getY(); iPosY <= treeTopPos + 1; ++iPosY) {
                int k = 1;
                if (iPosY == blockPos.getY()) {
                    k = 0;
                }
                if (iPosY >= treeTopPos - 1) {
                    k = 2;
                }
                for (int iPosX = blockPos.getX() - k, halflength = blockPos.getX() + k; iPosX <= halflength + k
                        && canGenerate; ++iPosX) {
                    for (int iPosZ = blockPos.getZ() - k, halfLength = blockPos.getZ() + k; iPosZ <= halfLength + k
                            && canGenerate; ++iPosZ) {
                        if (iPosY >= 0 && iPosY < 256) {
                            if (!this.isReplaceable(worldIn, mutableBlockPos.setPos(iPosX, iPosY, iPosZ))) {
                                canGenerate = false;
                            }
                        } else {
                            canGenerate = false;
                        }
                    }
                }
            }
            if (!canGenerate) {
                return false;
            } else {
                IBlockState logState = BlockRegistry.divineLog.getDefaultState();
                IBlockState leavesState = BlockRegistry.divineLeaves.getDefaultState();
                BlockPos down = blockPos.down();
                IBlockState blockState = worldIn.getBlockState(down);
                Block block = blockState.getBlock();
                boolean isSoil = block.canSustainPlant(blockState, worldIn, down, EnumFacing.UP,
                        (BlockSapling) Blocks.SAPLING);

                if (isSoil && treeTopPos + 1 < 256) {
                    block.onPlantGrow(blockState, worldIn, down, blockPos);

                    // Generate leaves
                    for (int iPosY = treeTopPos - 3; iPosY <= treeTopPos; ++iPosY) {
                        int distanceToTop = iPosY - treeTopPos;
                        int margin = 1 - distanceToTop / 2;

                        for (int xStart = blockPos.getX() - margin, xEnd = blockPos.getX()
                                + margin; xStart <= xEnd; ++xStart) {
                            int currentMarginX = Math.abs(xStart - blockPos.getX());

                            for (int zStart = blockPos.getZ() - margin, zEnd = blockPos.getZ()
                                    + margin; zStart <= zEnd; ++zStart) {
                                int currentMarginZ = Math.abs(zStart - blockPos.getZ());

                                if (currentMarginX != margin || currentMarginZ != margin
                                        || rand.nextInt(2) != 0 && distanceToTop != 0) {
                                    BlockPos leavesBlockPos = new BlockPos(xStart, iPosY, zStart);
                                    IBlockState leavesBlockState = worldIn.getBlockState(leavesBlockPos);
                                    Block leavesBlock = worldIn.getBlockState(leavesBlockPos).getBlock();
                                    if (leavesBlock.isAir(leavesBlockState, worldIn, leavesBlockPos)
                                            || leavesBlock.isLeaves(leavesBlockState, worldIn, leavesBlockPos)
                                            || leavesBlockState.getMaterial()  == Material.VINE) {
                                        this.setBlockAndNotifyAdequately(worldIn, leavesBlockPos, leavesState);
                                    }
                                }
                            }
                        }
                    }

                    // Create log
                    for (int i = 0; i < treeHeight; ++i) {
                        BlockPos upN = blockPos.up(i);
                        IBlockState blockStateUp = worldIn.getBlockState(upN);
                        Block blockUp = blockStateUp.getBlock();
                        if (blockUp.isAir(blockStateUp, worldIn, upN) || blockUp.isLeaves(blockStateUp, worldIn, upN)
                                || blockStateUp.getMaterial() == Material.VINE) {
                            this.setBlockAndNotifyAdequately(worldIn, blockPos.up(i), logState);
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}