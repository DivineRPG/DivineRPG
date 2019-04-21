package naturix.divinerpg.world;

import java.util.Random;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenDivineTree extends WorldGenAbstractTree {
    private final int minTreeHeight;
    private final boolean vinesGrow;
    private final IBlockState metaWood;
    private final IBlockState metaLeaves;


    public WorldGenDivineTree(int minTreeHeight, IBlockState metaWood, IBlockState metaLeaves, boolean doVinesGrow) {
        super(true);
        this.minTreeHeight = minTreeHeight;
        this.metaWood = metaWood;
        this.metaLeaves = metaLeaves;
        this.vinesGrow = doVinesGrow;
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

                for (int iPosX = blockPos.getX() - k, halflength = blockPos.getX() + k; iPosX <= halflength + k && canGenerate; ++iPosX) {
                    for (int iPosZ = blockPos.getZ() - k, halfLength = blockPos.getZ() + k; iPosZ <= halfLength + k && canGenerate; ++iPosZ) {
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
                BlockPos down = blockPos.down();
                IBlockState blockState = worldIn.getBlockState(down);
                Block block = blockState.getBlock();
                boolean isSoil = block.canSustainPlant(blockState, worldIn, down, EnumFacing.UP, (BlockSapling) Blocks.SAPLING);

                if (isSoil && treeTopPos + 1 < 256) {
                    block.onPlantGrow(blockState, worldIn, down, blockPos);

                    // Generate leaves and fruits
                    for (int iPosY = treeTopPos - 3; iPosY <= treeTopPos; ++iPosY) {
                        int distanceToTop = iPosY - treeTopPos;
                        int margin = 1 - distanceToTop / 2;

                        for (int xStart = blockPos.getX() - margin, xEnd = blockPos.getX() + margin; xStart <= xEnd; ++xStart) {
                            int currentMarginX = Math.abs(xStart - blockPos.getX());

                            for (int zStart = blockPos.getZ() - margin, zEnd = blockPos.getZ() + margin; zStart <= zEnd; ++zStart) {
                                int currentMarginZ = Math.abs(zStart - blockPos.getZ());

                                if (currentMarginX != margin || currentMarginZ != margin || rand.nextInt(2) != 0 && distanceToTop != 0) {
                                    BlockPos leavesBlockPos = new BlockPos(xStart, iPosY, zStart);
                                    IBlockState leavesBlockState = worldIn.getBlockState(leavesBlockPos);

                                    Block leavesBlock = worldIn.getBlockState(leavesBlockPos).getBlock();

                                    if (leavesBlock.isAir(leavesBlockState, worldIn, leavesBlockPos) || leavesBlock.isLeaves(leavesBlockState, worldIn, leavesBlockPos)
                                            || leavesBlock.getMaterial(leavesBlockState) == Material.VINE) {
                                        this.setBlockAndNotifyAdequately(worldIn, leavesBlockPos, this.metaLeaves);


                                        BlockPos fruitBlockPos = new BlockPos(xStart, iPosY - 1, zStart);
                                        BlockPos blockBelowFruitPos = new BlockPos(xStart, iPosY - 2, zStart);
                                        if (worldIn.isAirBlock(fruitBlockPos)) {
                                            if (worldIn.isAirBlock(blockBelowFruitPos) && iPosY > 2) {

                                              

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // Create log (and vines)
                    for (int i = 0; i < treeHeight; ++i) {
                        BlockPos upN = blockPos.up(i);
                        IBlockState blockStateUp = worldIn.getBlockState(upN);
                        Block blockUp = blockStateUp.getBlock();

                        if (blockUp.isAir(blockStateUp, worldIn, upN) || blockUp.isLeaves(blockStateUp, worldIn, upN) || blockUp.getMaterial(blockStateUp) == Material.VINE) {
                            this.setBlockAndNotifyAdequately(worldIn, blockPos.up(i), this.metaWood);

                            if (this.vinesGrow && i > 0) {
                                if (rand.nextInt(3) > 0 && worldIn.isAirBlock(blockPos.add(-1, i, 0))) {
                                    this.setBlockVine(worldIn, blockPos.add(-1, i, 0), BlockVine.EAST);
                                }

                                if (rand.nextInt(3) > 0 && worldIn.isAirBlock(blockPos.add(1, i, 0))) {
                                    this.setBlockVine(worldIn, blockPos.add(1, i, 0), BlockVine.WEST);
                                }

                                if (rand.nextInt(3) > 0 && worldIn.isAirBlock(blockPos.add(0, i, -1))) {
                                    this.setBlockVine(worldIn, blockPos.add(0, i, -1), BlockVine.SOUTH);
                                }

                                if (rand.nextInt(3) > 0 && worldIn.isAirBlock(blockPos.add(0, i, 1))) {
                                    this.setBlockVine(worldIn, blockPos.add(0, i, 1), BlockVine.NORTH);
                                }
                            }
                        }
                    }

                    // Create vines
                    if (this.vinesGrow) {
                        for (int yBottom = treeTopPos - 3; yBottom <= treeTopPos; ++yBottom) {
                            int distanceToTop = yBottom - treeTopPos;
                            int k = 2 - distanceToTop / 2;

                            for (int xStart = blockPos.getX() - k, xEnd = blockPos.getX() + k; xStart <= xEnd; ++xStart) {
                                for (int zStart = blockPos.getZ() - k, zEnd = blockPos.getZ() + k; zStart <= zEnd; ++zStart) {
                                    mutableBlockPos.setPos(xStart, yBottom, zStart);
                                    if (worldIn.getBlockState(mutableBlockPos).getBlock().isLeaves(
                                            worldIn.getBlockState(mutableBlockPos), worldIn, mutableBlockPos)) {
                                        BlockPos posWest = mutableBlockPos.west();
                                        BlockPos posEast = mutableBlockPos.east();
                                        BlockPos posNorth = mutableBlockPos.north();
                                        BlockPos posSouth = mutableBlockPos.south();

                                        if (rand.nextInt(4) == 0 && worldIn.getBlockState(posWest).getBlock().isAir(
                                                worldIn.getBlockState(posWest), worldIn, posWest)) {
                                            this.setVines(worldIn, posWest, BlockVine.EAST);
                                        }

                                        if (rand.nextInt(4) == 0 && worldIn.getBlockState(posEast).getBlock()
                                                .isAir(worldIn.getBlockState(posEast), worldIn, posEast)) {
                                            this.setVines(worldIn, posEast, BlockVine.WEST);
                                        }

                                        if (rand.nextInt(4) == 0 && worldIn.getBlockState(posNorth).getBlock().isAir(
                                                worldIn.getBlockState(posNorth), worldIn, posNorth)) {
                                            this.setVines(worldIn, posNorth, BlockVine.SOUTH);
                                        }

                                        if (rand.nextInt(4) == 0 && worldIn.getBlockState(posSouth).getBlock().isAir(
                                                worldIn.getBlockState(posSouth), worldIn, posSouth)) {
                                            this.setVines(worldIn, posSouth, BlockVine.NORTH);
                                        }
                                    }
                                }
                            }
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

    private void setBlockVine(World world, BlockPos blockPos, PropertyBool propertyBool) {
        this.setBlockAndNotifyAdequately(world, blockPos, Blocks.VINE.getDefaultState().withProperty(propertyBool, true));
    }

    private void setVines(World world, BlockPos blockPos, PropertyBool propertyBool) {
        this.setBlockVine(world, blockPos, propertyBool);
        int i = 4;

        for (blockPos = blockPos.down(); world.getBlockState(blockPos).getBlock().isAir(world.getBlockState(blockPos), world, blockPos) && i > 0; --i) {
            this.setBlockVine(world, blockPos, propertyBool);
            blockPos = blockPos.down();
        }
    }
}