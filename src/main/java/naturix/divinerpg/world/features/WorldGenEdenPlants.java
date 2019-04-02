package naturix.divinerpg.world.features;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenEdenPlants extends WorldGenerator {
    private final Block grassBlock;

    public WorldGenEdenPlants(Block grassBlock) {
        this.grassBlock = grassBlock;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        for (int i = 0; i < 128; ++i) {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.getBlockState(blockpos.down()).getBlock() == ModBlocks.edenGrass) {
                worldIn.setBlockState(blockpos, grassBlock.getDefaultState());
                return true;
            }
        }
        return false;
    }
}
