package divinerpg.dimensions.eden;

import java.util.Random;

import divinerpg.objects.blocks.BlockModSapling;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class EdenTree extends WorldGenAbstractTree {
    private int minTreeHeight;
    private boolean isSapling;

    public EdenTree(boolean notify) {
        this(notify, 5);
    }

    public EdenTree(boolean notify, int minTreeHeightIn) {
        super(notify);
        this.isSapling = notify;
        this.minTreeHeight = minTreeHeightIn;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        boolean isSoil = ((BlockModSapling) BlockRegistry.edenSapling).canPlaceBlockAt(worldIn, position);
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
        /*if (!isSapling) {
            for (int x = -2; x <= 2; x++) {
                for (int z = -2; z <= 2; z++) {
                    for (int y = 0; y <= treeHeight; y++) {
                        if (worldIn
                                .getBlockState(
                                        new BlockPos(position.getX() + x, position.getY() + y, position.getZ() + z))
                                .getBlock() != Blocks.AIR) {
                            return false;
                        }
                    }
                }
            }
        }*/

        buildTrunk(worldIn, position, treeHeight);
        return true;
    }

    private void buildTrunk(World world, BlockPos pos, int treeHeight) {
        IBlockState log = BlockRegistry.edenLog.getDefaultState();
        IBlockState leaves = BlockRegistry.edenLeaves.getDefaultState();
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