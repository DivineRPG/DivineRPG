package divinerpg.dimensions.vethea;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Wrapper class to allow for usage of legacy code (e.g. BlockPos instead of Block)
 */
public abstract class VetheaWorldGenerator extends WorldGenerator {
    public void setBlock(World world, int i, int j, int k, Block block) {
        world.setBlockState(new BlockPos(i, j, k), block.getDefaultState());
    }

    public boolean generate(World world, Random rand, BlockPos pos) {
        return generate(world, rand, pos.getX(), pos.getY(), pos.getZ());
    }

    public abstract boolean generate(World world, Random rand, int x, int y, int z);
}
