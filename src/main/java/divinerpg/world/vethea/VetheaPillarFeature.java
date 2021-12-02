package divinerpg.world.vethea;

import com.mojang.serialization.*;
import divinerpg.registries.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;

import java.util.*;

public class VetheaPillarFeature extends Feature<BlockStateFeatureConfig> {
    private int height;
    private int maxRadius = 8;

    public VetheaPillarFeature(Codec<BlockStateFeatureConfig> codec, int height) {
        super(codec);
        this.height = height;
    }

    @Override
    public boolean place(ISeedReader reader, ChunkGenerator chunkGenerator, Random random, BlockPos pos, BlockStateFeatureConfig config) {
        int additionalWidth = random.nextInt(4) + 3;

        // Fixing cascading offset
        pos = pos.offset(maxRadius, 0, maxRadius);

        for (int i = 0; i < height; i++) {
            this.placeBlockCircle(reader, pos.offset(0, i, 0), Math.abs(((height / 2) - i)) / 5 + additionalWidth);
        }

        return false;
    }

    private void placeBlockCircle(ISeedReader worldIn, BlockPos pos, int radius) {
        if (radius > maxRadius)
            radius = maxRadius;

        for (float i = 0; i < radius; i += 0.5) {
            for (float j = 0; j < 2 * Math.PI * i; j += 0.5) {
                BlockPos position = pos.offset(
                        Math.sin(j) * i,
                        0,
                        Math.cos(j) * i);

                worldIn.setBlock(position, BlockRegistry.dreamStone.defaultBlockState(), 0);
            }
        }
    }
}
