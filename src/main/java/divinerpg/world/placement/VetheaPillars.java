package divinerpg.world.placement;

import com.mojang.serialization.*;
import net.minecraft.util.math.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

import java.util.*;
import java.util.stream.*;

public class VetheaPillars extends Placement<ChanceConfig> {
    public VetheaPillars(Codec<ChanceConfig> codec) {
        super(codec);
    }

    @Override
    public Stream<BlockPos> getPositions(WorldDecoratingHelper decoratingHelper, Random random, ChanceConfig config, BlockPos pos) {
        int level = random.nextInt(3);
        if (random.nextInt(8) == 0) {
            switch (level) {
                case 0:
                    return Stream.of(new BlockPos(pos.getX(), 16, pos.getZ()));
                case 1:
                    return Stream.of(new BlockPos(pos.getX(), 64, pos.getZ()));
                case 2:
                    return Stream.of(new BlockPos(pos.getX(), 112, pos.getZ()));
                default:
                    return Stream.empty();
            }
        }
        return Stream.empty();
    }
}
