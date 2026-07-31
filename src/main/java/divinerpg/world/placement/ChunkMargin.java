package divinerpg.world.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.registries.PlacementModifierRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class ChunkMargin extends PlacementFilter {
    public static final MapCodec<ChunkMargin> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(Codec.INT.fieldOf("margin").forGetter((config) -> config.margin)).apply(instance, ChunkMargin::new));
    public final int margin;
    public ChunkMargin(int margin){
        this.margin = margin;
    }
    @Override
    protected boolean shouldPlace(PlacementContext context, RandomSource source, BlockPos pos) {
        int x = pos.getX() & 0xF, y = pos.getY() & 0xF;
        return x >= margin && x < 16 - margin && y >= margin && y < 16 - margin;
    }
    @Override
    public PlacementModifierType<?> type() {
        return PlacementModifierRegistry.CHUNK_MARGIN.get();
    }
}