package divinerpg.world.vethea;

import com.mojang.serialization.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;

import java.util.*;

public class FeatureEnhanced extends Feature<BlockStateFeatureConfig> {
    private final int possibility;
    private final int minHeight;
    private final int maxHeight;
    private Feature source;

    /**
     * Structure will spawn on strict Y level
     *
     * @param source      - main worlgen
     * @param possibility - parameter will pass to rand.Next() to detect if structure can spawn
     * @param minHeight   - min height for structure (inclisive)
     */
    public FeatureEnhanced(Feature source, int possibility, int minHeight) {
        this(BlockStateFeatureConfig.CODEC, source, possibility, minHeight, minHeight + 1);
    }

    /**
     * Decorator for customizing world gen
     *
     * @param source      - main worlgen
     * @param possibility - parameter will pass to rand.Next() to detect if structure can spawn
     * @param minHeight   - min height for structure (inclisive)
     * @param maxHeight-  max height for structure (exclusive)
     */
    public FeatureEnhanced(Codec codec, Feature source, int possibility, int minHeight, int maxHeight) {
        super(codec);
        this.source = source;
        this.possibility = possibility;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;

        if (maxHeight - minHeight < 1) {
            throw new RuntimeException(String.format("Max height (%s) should be more than min height (%s)", maxHeight, minHeight));
        }
    }


    @Override
    public boolean place(ISeedReader reader, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, BlockStateFeatureConfig config) {
        if (random.nextInt(possibility) != 0)
            return false;

        blockPos = new BlockPos(blockPos.getX(), random.nextInt(maxHeight - minHeight) + minHeight, blockPos.getZ());
        return source.place(reader, chunkGenerator, random, blockPos, config);
    }

}
