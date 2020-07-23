package divinerpg.dimensions.eden;

import java.util.Random;

import divinerpg.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * Created by LiteWolf101 on Feb /18/2019
 */
public class WorldGenConeUp extends WorldGenerator {
    private final Block block;
    private int height;

    public WorldGenConeUp(Block b) {
        block = b;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        int var2 = rand.nextInt(4) + height;
        if (world.getBlockState(pos.down()).getBlock() != BlockRegistry.edenGrass) {
            return false;
        }
        for (int i = 0; i < var2; i++) {
            this.placeBlockCircle(world, rand, x, y + i, z, var2 - i);
        }
        return true;
    }

    public boolean generate(World world, Random rand, BlockPos pos, int h) {
        height = h;
        return generate(world, rand, pos);
    }

    void placeBlockCircle(World world, Random rand, int x, int y, int z, int radius) {
        for (float i = 0; i < radius; i += 0.5) {
            for (float j = 0; j < 2 * Math.PI * i; j += 0.5) {
                world.setBlockState(
                        new BlockPos((int) Math.floor(x + Math.sin(j) * i), y, (int) Math.floor(z + Math.cos(j) * i)),
                        block.getDefaultState());
                if (rand.nextInt(6) == 0)
                    world.setBlockState(
                            new BlockPos((int) Math.floor(x + Math.sin(j) * i) + rand.nextInt(2) - rand.nextInt(2),
                                    y + 1, (int) Math.floor(z + Math.cos(j) * i) + rand.nextInt(2) - rand.nextInt(2)),
                            block.getDefaultState());
                if (rand.nextInt(6) == 0)
                    world.setBlockState(
                            new BlockPos((int) Math.floor(x + Math.sin(j) * i) + rand.nextInt(2) - rand.nextInt(2),
                                    y - 1, (int) Math.floor(z + Math.cos(j) * i) + rand.nextInt(2) - rand.nextInt(2)),
                            block.getDefaultState());
            }
        }
    }
}
