package divinerpg.world.placement;

import com.mojang.serialization.*;
import net.minecraft.util.math.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

import java.util.*;
import java.util.stream.*;

public class TarLake extends Placement<ChanceConfig> {
    public TarLake(Codec<ChanceConfig> codec) {
        super(codec);
    }

    @Override
    public Stream<BlockPos> getPositions(WorldDecoratingHelper helper, Random rand, ChanceConfig chanceConfig, BlockPos pos) {
        if (rand.nextInt(100) < chanceConfig.chance) {
            int x = rand.nextInt(16) + pos.getX();
            int z = rand.nextInt(16) + pos.getZ();
            int y = rand.nextInt(rand.nextInt(helper.getGenDepth() - 8) + 8);
            if (y < helper.getSeaLevel() || rand.nextInt(100) < 50) {
                return Stream.of(new BlockPos(x, y, z));
            }
        }

        return Stream.empty();
    }
}
