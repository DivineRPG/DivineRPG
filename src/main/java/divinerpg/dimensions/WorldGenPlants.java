package divinerpg.dimensions;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenPlants extends WorldGenerator {
    private final IBlockState plant;
    private final IBlockState grass;

    public WorldGenPlants(Block plant, Block grass){
        this.plant = plant.getDefaultState();
        this.grass = grass.getDefaultState();
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        for (int i = 0; i < 128; ++i) {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.getBlockState(blockpos.down()) == grass) {
                worldIn.setBlockState(blockpos, plant);
                return true;
            }
        }
        return false;
    }
}
