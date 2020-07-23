package divinerpg.dimensions.vethea;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Wrapper for WorldGenerator
 * Customize possibility of generations
 * Customize random height offset
 */
public class WorldGenEnhanced extends WorldGenerator {

    private final int possibility;
    private final int minHeight;
    private final int maxHeight;
    private WorldGenerator source;

    /**
     * Structure will spawn on strict Y level
     *
     * @param source      - main worlgen
     * @param possibility - parameter will pass to rand.Next() to detect if structure can spawn
     * @param minHeight   - min height for structure (inclisive)
     */
    public WorldGenEnhanced(WorldGenerator source, int possibility, int minHeight) {
        this(source, possibility, minHeight, minHeight + 1);
    }

    /**
     * Decorator for customizing world gen
     *
     * @param source      - main worlgen
     * @param possibility - parameter will pass to rand.Next() to detect if structure can spawn
     * @param minHeight   - min height for structure (inclisive)
     * @param maxHeight-  max height for structure (exclusive)
     */
    public WorldGenEnhanced(WorldGenerator source, int possibility, int minHeight, int maxHeight) {
        this.source = source;
        this.possibility = possibility;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;

        if (maxHeight - minHeight < 1) {
            throw new RuntimeException(String.format("Max height (%s) should be more than min height (%s)", maxHeight, minHeight));
        }
    }

    @Override
    public boolean generate(World world, Random random, BlockPos blockPos) {
        if (random.nextInt(possibility) != 0)
            return false;

        blockPos = new BlockPos(blockPos.getX(), random.nextInt(maxHeight - minHeight) + minHeight, blockPos.getZ());
        return source.generate(world, random, blockPos);
    }
}
