package divinerpg.dimensions.wildwood;

import java.util.Random;

import divinerpg.objects.blocks.BlockModSapling;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.BlockVine;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WildWoodTree extends WorldGenAbstractTree {
    private int minTreeHeight;
    private boolean isSapling;

    public WildWoodTree(boolean notify) {
        this(notify, 5);
    }

    public WildWoodTree(boolean notify, int minTreeHeightIn) {
        super(notify);
        this.isSapling = notify;
        this.minTreeHeight = minTreeHeightIn;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        IBlockState log = BlockRegistry.wildwoodLog.getDefaultState();
        IBlockState leaves = BlockRegistry.wildwoodLeaves.getDefaultState();
        boolean isSoil = ((BlockModSapling) BlockRegistry.wildwoodSapling).canPlaceBlockAt(worldIn, position);
        int treeHeight = rand.nextInt(3) + minTreeHeight;
        int treeTopPos = position.getY() + treeHeight;

        if (position.getY() < 1 || treeTopPos + 1 > 256 || !isSoil) {
            return false;
        }

        // Check if tree would fit and can be generated
        if (isSapling) {
            final BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            for (int iPosY = position.getY(); iPosY <= treeTopPos + 1; ++iPosY) {
                int k = (iPosY > (position.getY() + 1)) ? 0 : (iPosY == position.getY()) ? 2 : 1;
                for (int iPosX = position.getX() - k, halflength = position.getX() + k; iPosX <= halflength
                        + k; ++iPosX) {
                    for (int iPosZ = position.getZ() - k, halfLength = position.getZ() + k; iPosZ <= halfLength
                            + k; ++iPosZ) {
                        if (iPosY >= 0 && iPosY < 256) {
                            if (!this.isReplaceable(worldIn, mutableBlockPos.setPos(iPosX, iPosY, iPosZ))) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
        }

        buildTrunk(worldIn, position, treeHeight, log, leaves);
        int i = rand.nextInt(treeHeight);
        for (int i2 = 0; i2 < i; ++i2) {
            BlockPos blockpos = position.up(i2);

            if (this.isAirLeaves(worldIn, blockpos)) {
                this.setBlockAndNotifyAdequately(worldIn, blockpos, log);
                if (i2 > 0) {
                    this.placeVine(worldIn, rand, blockpos.west(), BlockVine.EAST);
                    this.placeVine(worldIn, rand, blockpos.north(), BlockVine.SOUTH);
                }
            }

            if (i2 < i - 1) {
                BlockPos blockpos1 = blockpos.east();

                if (this.isAirLeaves(worldIn, blockpos1)) {
                    this.setBlockAndNotifyAdequately(worldIn, blockpos1, log);
                    if (i2 > 0) {
                        this.placeVine(worldIn, rand, blockpos1.east(), BlockVine.WEST);
                        this.placeVine(worldIn, rand, blockpos1.north(), BlockVine.SOUTH);
                    }
                }

                BlockPos blockpos2 = blockpos.south().east();

                if (this.isAirLeaves(worldIn, blockpos2)) {
                    this.setBlockAndNotifyAdequately(worldIn, blockpos2, log);
                    if (i2 > 0) {
                        this.placeVine(worldIn, rand, blockpos2.east(), BlockVine.WEST);
                        this.placeVine(worldIn, rand, blockpos2.south(), BlockVine.NORTH);
                    }
                }

                BlockPos blockpos3 = blockpos.south();

                if (this.isAirLeaves(worldIn, blockpos3)) {
                    this.setBlockAndNotifyAdequately(worldIn, blockpos3, log);
                    if (i2 > 0) {
                        this.placeVine(worldIn, rand, blockpos3.west(), BlockVine.EAST);
                        this.placeVine(worldIn, rand, blockpos3.south(), BlockVine.NORTH);
                    }
                }
            }
        }
        return true;
    }

    private void placeVine(World world, Random rand, BlockPos pos, PropertyBool property) {
        if (!isSapling && rand.nextInt(3) > 0 && world.isAirBlock(pos)) {
            this.setBlockAndNotifyAdequately(world, pos,
                    BlockRegistry.wildwoodVine.getDefaultState().withProperty(property, Boolean.valueOf(true)));
        }
    }

    private boolean isAirLeaves(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos);
    }

    private void buildTrunk(World world, BlockPos pos, int treeHeight, IBlockState log, IBlockState leaves) {
        Random random = new Random();
        int rand = random.nextInt(1) + 1;
        int extraHeight = treeHeight + rand;
        this.setBlockAndNotifyAdequately(world, pos.add(1, 1, 0), log);
        this.setBlockAndNotifyAdequately(world, pos.add(0, 1, 1), log);
        this.setBlockAndNotifyAdequately(world, pos.add(-1, 1, 0), log);
        this.setBlockAndNotifyAdequately(world, pos.add(0, 1, -1), log);
        drawLeafCircle(world, pos.add(0, 0, 0), 2, log);
        drawLeafCircle(world, pos.add(0, extraHeight - 1, 0), 1, leaves);
        drawLeafCircle(world, pos.add(0, extraHeight, 0), 2, leaves);
        drawLeafCircle(world, pos.add(0, extraHeight + 1, 0), 1, leaves);
        drawLeafCircle(world, pos.add(0, extraHeight + 2, 0), 0, leaves);
        for (int dy = 0; dy < extraHeight; dy++) {
            this.setBlockAndNotifyAdequately(world, pos.add(0, dy, 0), log);
        }
    }

    private void drawLeafCircle(World world, BlockPos pos, int rad, IBlockState leaves) {
        for (byte dx = 0; dx <= rad; dx++) {
            for (byte dz = 0; dz <= rad; dz++) {
                int dist = (int) (Math.max(dx, dz) + (Math.min(dx, dz) * 0.5));
                if (dx == 3 && dz == 3) {
                    dist = 6;
                }
                if (dx == 0) {
                    // two!
                    if (dz < rad) {
                        setBlockAndNotifyAdequately(world, pos.add(0, 0, dz), leaves);
                        setBlockAndNotifyAdequately(world, pos.add(0, 0, -dz), leaves);
                    } else {
                        setBlockAndNotifyAdequately(world, pos.add(0, 0, dz), leaves);
                        setBlockAndNotifyAdequately(world, pos.add(0, 0, -dz), leaves);
                    }
                } else if (dz == 0) {
                    // two!
                    if (dx < rad) {
                        setBlockAndNotifyAdequately(world, pos.add(dx, 0, 0), leaves);
                        setBlockAndNotifyAdequately(world, pos.add(-dx, 0, 0), leaves);
                    } else {
                        setBlockAndNotifyAdequately(world, pos.add(dx, 0, 0), leaves);
                        setBlockAndNotifyAdequately(world, pos.add(-dx, 0, 0), leaves);
                    }
                } else if (dist < rad) {
                    // do four at a time for easiness!
                    setBlockAndNotifyAdequately(world, pos.add(dx, 0, dz), leaves);
                    setBlockAndNotifyAdequately(world, pos.add(dx, 0, -dz), leaves);
                    setBlockAndNotifyAdequately(world, pos.add(-dx, 0, dz), leaves);
                    setBlockAndNotifyAdequately(world, pos.add(-dx, 0, -dz), leaves);
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