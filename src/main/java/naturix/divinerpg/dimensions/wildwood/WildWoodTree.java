package naturix.divinerpg.dimensions.wildwood;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class WildWoodTree extends WorldGenAbstractTree {
    private int minTreeHeight;
    protected IBlockState log = ModBlocks.wildwoodLog.getDefaultState();
    protected IBlockState leaves = ModBlocks.wildwoodLeaves.getDefaultState();

    public WildWoodTree(boolean notify) {
        this(notify, 13);
    }

    public WildWoodTree(boolean notify, int minTreeHeightIn) {
        super(notify);
        this.minTreeHeight = minTreeHeightIn;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int treeHeight = rand.nextInt(3) + minTreeHeight;
        int randBranchNum = 0;
        Material materialBelow = worldIn.getBlockState(position.down()).getMaterial();

        if (position.getY() <= 13 && position.getY() + treeHeight + 1 >= worldIn.getHeight() || materialBelow != Material.GRASS && materialBelow != Material.GROUND) {
            return false;
        }
        
        buildTrunk(worldIn, position, treeHeight);
        int i = rand.nextInt(treeHeight);
        for (int i2 = 0; i2 < i; ++i2)
        {
            BlockPos blockpos = position.up(i2);

            if (this.isAirLeaves(worldIn,blockpos))
            {
                this.setBlockAndNotifyAdequately(worldIn, blockpos, this.log);

                if (i2 > 0)
                {
                    this.placeVine(worldIn, rand, blockpos.west(), BlockVine.EAST);
                    this.placeVine(worldIn, rand, blockpos.north(), BlockVine.SOUTH);
                }
            }

            if (i2 < i - 1)
            {
                BlockPos blockpos1 = blockpos.east();

                if (this.isAirLeaves(worldIn,blockpos1))
                {
                    this.setBlockAndNotifyAdequately(worldIn, blockpos1, this.log);

                    if (i2 > 0)
                    {
                        this.placeVine(worldIn, rand, blockpos1.east(), BlockVine.WEST);
                        this.placeVine(worldIn, rand, blockpos1.north(), BlockVine.SOUTH);
                    }
                }

                BlockPos blockpos2 = blockpos.south().east();

                if (this.isAirLeaves(worldIn,blockpos2))
                {
                    this.setBlockAndNotifyAdequately(worldIn, blockpos2, this.log);

                    if (i2 > 0)
                    {
                        this.placeVine(worldIn, rand, blockpos2.east(), BlockVine.WEST);
                        this.placeVine(worldIn, rand, blockpos2.south(), BlockVine.NORTH);
                    }
                }

                BlockPos blockpos3 = blockpos.south();

                if (this.isAirLeaves(worldIn,blockpos3))
                {
                    this.setBlockAndNotifyAdequately(worldIn, blockpos3, this.log);

                    if (i2 > 0)
                    {
                        this.placeVine(worldIn, rand, blockpos3.west(), BlockVine.EAST);
                        this.placeVine(worldIn, rand, blockpos3.south(), BlockVine.NORTH);
                    }
                }
            }
        }
        return true;
    }
    private void placeVine(World p_181632_1_, Random p_181632_2_, BlockPos p_181632_3_, PropertyBool p_181632_4_)
    {
        if (p_181632_2_.nextInt(3) > 0 && p_181632_1_.isAirBlock(p_181632_3_))
        {
            this.setBlockAndNotifyAdequately(p_181632_1_, p_181632_3_, ModBlocks.vineWild.getDefaultState().withProperty(p_181632_4_, Boolean.valueOf(true)));
        }
    }private boolean isAirLeaves(World world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos);
    }

    private void buildTrunk(World world, BlockPos pos, int treeHeight) {
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
        for (int dy = 0; dy < extraHeight; dy++){
            this.setBlockAndNotifyAdequately(world, pos.add(0, dy, 0), log);
        }
    }

    private void drawLeafCircle(World world, BlockPos pos, int rad, IBlockState baseState) {
        for (byte dx = 0; dx <= rad; dx++) {
            for (byte dz = 0; dz <= rad; dz++) {
                int dist = (int)(Math.max(dx, dz) + (Math.min(dx, dz) * 0.5));
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