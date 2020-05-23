package divinerpg.dimensions.vethea;

import divinerpg.registry.BlockRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenVetheanPillarNew extends WorldGenerator {
    private int height;
    private int maxRadius = 8;

    public WorldGenVetheanPillarNew(int height) {
        this.height = height;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int additionalWidth = rand.nextInt(4) + 3;

        // Fixing cascading offset
        position = position.add(maxRadius, 0, maxRadius);

        for (int i = 0; i < height; i++) {
            this.placeBlockCircle(worldIn, position.add(0, i, 0), Math.abs(((height / 2) - i)) / 5 + additionalWidth);
        }

        return false;
    }

    private void placeBlockCircle(World worldIn, BlockPos pos, int radius) {
        if (radius > maxRadius)
            radius = maxRadius;

        for (float i = 0; i < radius; i += 0.5) {
            for (float j = 0; j < 2 * Math.PI * i; j += 0.5) {
                BlockPos position = pos.add(
                        Math.sin(j) * i,
                        0,
                        Math.cos(j) * i);

                worldIn.setBlockState(position, BlockRegistry.dreamStone.getDefaultState());
            }
        }
    }
}
