package naturix.divinerpg.dimensions.apalachia;

import java.util.Random;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenApalachiaPlants extends WorldGenerator {
    private final Block grassBlock;

    public WorldGenApalachiaPlants(Block grassBlock) {
        this.grassBlock = grassBlock;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        for (int i = 0; i < 128; ++i) {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.getBlockState(blockpos.down()).getBlock() == ModBlocks.apalachiaGrass) {
                worldIn.setBlockState(blockpos, grassBlock.getDefaultState());
                return true;
            }
        }
        return false;
    }
}
