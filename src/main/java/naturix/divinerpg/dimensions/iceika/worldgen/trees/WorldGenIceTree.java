package naturix.divinerpg.dimensions.iceika.worldgen.trees;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

import static naturix.divinerpg.objects.blocks.LeavesBase.CHECK_DECAY;
import static naturix.divinerpg.objects.blocks.LeavesBase.DECAYABLE;

/**
 * Created by LiteWolf101 on Feb
 * /18/2019
 */
public class WorldGenIceTree extends WorldGenerator {
    //IBlockState leaves = ModBlocks.brittleLeaves.getDefaultState().withProperty(DECAYABLE, false).withProperty(CHECK_DECAY, false);


    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if (worldIn.getChunkProvider().isChunkGeneratedAt(position.getX() >> 4, position.getZ() >> 4)){
            this.generate(worldIn, worldIn.rand, position.getX(), position.getY(), position.getZ());
            return true;
        }
        return false;
    }


    public boolean generate(World world, Random rand, int i, int j, int k) {
        int height = 20 + rand.nextInt(10);
        int leafStart = 1 + rand.nextInt(12);
        int leafHeight = height - leafStart;
        int l = 2 + rand.nextInt(9);
        BlockPos pos = new BlockPos(i, j - 1, k);

        //if (j < 1 || j + height + 1 > 256 || world.getBlockState(pos).getBlock() != ModBlocks.grassIceika || j >= 256 - height - 1) return false;

        for (int y = j; y <= j + 1 + height; y++) {

            if (y < 0 && y >= 256) return false;

            int k1 = 1;

            if (y - j < leafStart) k1 = 0;
            else k1 = l;

            for (int x = i - k1; x <= i + k1; x++) {
                for (int z = k - k1; z <= k + k1; z++) {

                    if (!world.getChunkProvider().isChunkGeneratedAt(x >> 4, z >> 4)) return false;

                    BlockPos bPos = new BlockPos(x, y, z);

                    Block b = world.getBlockState(bPos).getBlock();

                    if (world.getBlockState(bPos).getBlock() != Blocks.AIR && !world.getBlockState(bPos).getBlock().isLeaves(world.getBlockState(bPos),world, bPos)) return false;
                }
            }
        }
        //setBlockAndNotifyAdequately(world, new BlockPos(i, j - 1, k), ModBlocks.grassIceika.getDefaultState());
        //setBlockAndNotifyAdequately(world, new BlockPos(i - 1, j - 1, k), ModBlocks.grassIceika.getDefaultState());
        //setBlockAndNotifyAdequately(world, new BlockPos(i, j - 1, k - 1), ModBlocks.grassIceika.getDefaultState());
        //setBlockAndNotifyAdequately(world, new BlockPos(i - 1, j - 1, k - 1), ModBlocks.grassIceika.getDefaultState());
        int l1 = rand.nextInt(2);
        int j2 = 1;
        boolean flag1 = false;

        for (int i3 = 0; i3 <= leafHeight; i3++) {
            int k3 = j + height - i3;

            for (int i4 = i - l1; i4 <= i + l1; i4++) {
                int k4 = i4 - i;

                for (int l4 = k - l1; l4 <= k + l1; l4++) {
                    int i5 = l4 - k;


                    if ((Math.abs(k4) != l1 || Math.abs(i5) != l1 || l1 <= 0)
                            && (world.getBlockState(new BlockPos(i4, k3, l4)).getBlock() == Blocks.AIR || world.getBlockState(new BlockPos(i4, k3, l4)).getBlock().canBeReplacedByLeaves(world.getBlockState(new BlockPos(i4, k3, l4)),world, new BlockPos(i4, k3, l4)))) {
                        //setBlockAndNotifyAdequately(world, new BlockPos(i4, k3, l4), leaves);
                        //setBlockAndNotifyAdequately(world, new BlockPos(i4 - 1, k3, l4), leaves);
                        //setBlockAndNotifyAdequately(world, new BlockPos(i4, k3, l4 - 1), leaves);
                        //setBlockAndNotifyAdequately(world, new BlockPos(i4 - 1, k3, l4 - 1), leaves);
                    }
                }
            }

            if (l1 >= j2) {
                l1 = flag1 ? 1 : 0;
                flag1 = true;

                if (++j2 > l) j2 = l;
            } else l1++;
        }

        int j3 = rand.nextInt(3);

        for (int l3 = 0; l3 < height - j3; l3++) {
            //if (world.getBlockState(new BlockPos(i, j + l3, k)).getBlock() == Blocks.AIR || world.getBlockState(new BlockPos(i, j + l3, k)).getBlock().isLeaves(world.getBlockState(new BlockPos( i, j + l3, k)),world, new BlockPos( i, j + l3, k))) {
            //    setBlockAndNotifyAdequately(world, new BlockPos(i, j + l3, k), ModBlocks.frozenLog.getDefaultState());
            //    setBlockAndNotifyAdequately(world, new BlockPos(i - 1, j + l3, k), ModBlocks.frozenLog.getDefaultState());
            //    setBlockAndNotifyAdequately(world, new BlockPos(i, j + l3, k - 1), ModBlocks.frozenLog.getDefaultState());
            //    setBlockAndNotifyAdequately(world, new BlockPos(i - 1, j + l3, k - 1), ModBlocks.frozenLog.getDefaultState());
            //}
        }
        return true;
    }
}
