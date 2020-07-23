package divinerpg.dimensions.iceika;

import divinerpg.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class IceTreeGen extends WorldGenAbstractTree {
    private final boolean fromSapling;

    /**
     * @param notify      - notify when block is placed
     * @param fromSapling - need to check saplings
     */
    public IceTreeGen(boolean notify, boolean fromSapling) {
        super(notify);
        this.fromSapling = fromSapling;
    }

    /**
     * Detects if block is valid dirt
     *
     * @param blockType
     * @return
     */
    @Override
    protected boolean canGrowInto(Block blockType) {
        return blockType == BlockRegistry.frozenDirt || blockType == BlockRegistry.frozenGrass;
    }

    /**
     * Placing dirt below saplings
     *
     * @param worldIn
     * @param pos
     */
    @Override
    protected void setDirtAt(World worldIn, BlockPos pos) {
        if (!canGrowInto(worldIn.getBlockState(pos).getBlock())) {
            setBlockAndNotifyAdequately(worldIn, pos, BlockRegistry.frozenGrass.getDefaultState());
        }
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int height = 20 + rand.nextInt(10);

        if (!canGrowInto(worldIn.getBlockState(position.down()).getBlock()))
            return false;

        if (!hasFreeSpace(worldIn, rand, position, height))
            return false;

        if (fromSapling) {
            position = getSpawnPosition(worldIn, position);
            if (position == null)
                return false;
        }

        // placing dirt below saplings
        BlockPos.getAllInBox(position.down(), position.add(1, -1, 1)).forEach(x -> setDirtAt(worldIn, x));

        IBlockState leaves = BlockRegistry.brittleLeaves.getDefaultState();
        genLeaves(worldIn, rand, leaves, height - (1 + rand.nextInt(12)), height, position.add(1, 0, 1));

        BlockPos.getAllInBox(position.add(0, 0, 0), position.add(1, height - rand.nextInt(3), 1))
                .forEach(x -> setBlockAndNotifyAdequately(worldIn, x, BlockRegistry.frozenLog.getDefaultState()));

        return true;
    }

    /**
     * Check if we can fit the tree here
     *
     * @param worldIn  - world
     * @param rand     - random
     * @param position - position where tree will spawn
     * @param height   - tree height
     * @return
     */
    private boolean hasFreeSpace(World worldIn, Random rand, BlockPos position, int height) {
        if (position.getY() + height > worldIn.getHeight())
            return false;

        AtomicBoolean canGenerate = new AtomicBoolean(true);

        BlockPos.getAllInBoxMutable(position.up(), position.add(1, height, 0))
                .forEach(x -> {
                    IBlockState state = worldIn.getBlockState(x);
                    boolean canReplace = state.getBlock().isAir(state, worldIn, x)
                            || state.getBlock().isLeaves(state, worldIn, x);

                    if (!canReplace) {
                        canGenerate.set(false);
                    }
                });


        return canGenerate.get();
    }

    /**
     * Gets sapling position with min cords
     *
     * @param world    - world
     * @param position - sapling position
     * @return
     */
    @Nullable
    private BlockPos getSpawnPosition(World world, BlockPos position) {
        Map<BlockPos, Block> blockMap = new HashMap<>();

        BlockPos.getAllInBox(position.add(-1, 0, -1), position.add(1, 0, 1))
                .forEach(x -> {
                    if (!x.equals(position)) {
                        blockMap.put(x, world.getBlockState(x).getBlock());
                    }

                    blockMap.put(x.down(), world.getBlockState(x.down()).getBlock());
                });

        for (int x = -1; x < 1; x++) {
            for (int z = -1; z < 1; z++) {
                AtomicBoolean isMatch = new AtomicBoolean(true);

                BlockPos.getAllInBox(position.add(x, 0, z), position.add(x + 1, 0, z + 1))
                        .forEach(p -> {
                            Block block = blockMap.get(p);
                            // null is possible on current sapling position
                            if (block != null && block != BlockRegistry.frozenSapling || !canGrowInto(blockMap.get(p.down())))
                                isMatch.set(false);
                        });

                if (isMatch.get())
                    return position.add(x, 0, z);
            }
        }

        return null;
    }

    /**
     * Legacy
     *
     * @param world
     * @param random
     * @param leaves
     * @param leafHeight
     * @param height
     * @param position   - should be with XZ offset. Who knows?..
     */
    private void genLeaves(World world, Random random, IBlockState leaves, int leafHeight, int height, BlockPos position) {
        boolean flag1 = false;
        int l1 = random.nextInt(2);
        int j2 = 1;
        int l = 2 + random.nextInt(9);

        for (int i3 = 0; i3 <= leafHeight; i3++) {
            int k3 = position.getY() + height - i3;

            for (int i4 = position.getX() - l1; i4 <= position.getX() + l1; i4++) {
                int k4 = i4 - position.getX();

                for (int l4 = position.getZ() - l1; l4 <= position.getZ() + l1; l4++) {
                    int i5 = l4 - position.getZ();

                    if ((Math.abs(k4) != l1 || Math.abs(i5) != l1 || l1 <= 0)) {
                        BlockPos pos = new BlockPos(i4, k3, l4);

                        BlockPos.getAllInBox(pos, pos.add(-1, 0, -1))
                                .forEach(x -> {
                                    IBlockState state = world.getBlockState(x);

                                    if (state.getBlock().canBeReplacedByLeaves(state, world, x))
                                        setBlockAndNotifyAdequately(world, x, leaves);
                                });
                    }
                }
            }

            if (l1 >= j2) {
                l1 = flag1 ? 1 : 0;
                flag1 = true;

                if (++j2 > l)
                    j2 = l;
            } else
                l1++;
        }
    }
}
