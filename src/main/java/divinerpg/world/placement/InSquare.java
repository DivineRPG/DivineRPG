package divinerpg.world.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.registries.PlacementModifierRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.stream.Stream;

public class InSquare extends PlacementModifier {
    public static final MapCodec<InSquare> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(Codec.INT.fieldOf("margin").forGetter((config) -> config.margin)).apply(instance, InSquare::new));
    public final int margin;
    public InSquare(int margin) {
        this.margin = margin;
    }
    @Override
    public Stream<BlockPos> getPositions(PlacementContext context, RandomSource random, BlockPos pos) {
        int x = (pos.getX() & 0xFFFFFFF0) | (random.nextInt(16 - (margin << 1)) + margin);
        int z = (pos.getZ() & 0xFFFFFFF0) | (random.nextInt(16 - (margin << 1)) + margin);
        return Stream.of(new BlockPos(x, pos.getY(), z));
    }
    @Override
    public PlacementModifierType<?> type() {
        return PlacementModifierRegistry.IN_SQUARE.get();
    }
}