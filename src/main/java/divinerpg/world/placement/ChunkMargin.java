package divinerpg.world.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;

public class ChunkMargin implements PlacementFilter {
    public static final MapCodec<ChunkMargin> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(Codec.INT.fieldOf("margin").forGetter((config) -> config.margin)).apply(instance, ChunkMargin::new));
    public final int margin;
    public ChunkMargin(int margin){
        this.margin = margin;
    }
    @Override
    public boolean shouldPlace(PlacementContext context, RandomSource source, BlockPos pos) {
        int x = pos.getX() & 0xF, z = pos.getZ() & 0xF;
        return x >= margin && x < 16 - margin && z >= margin && z < 16 - margin;
    }
    @Override
    public MapCodec<? extends PlacementFilter> codec() {
        return CODEC;
    }
}