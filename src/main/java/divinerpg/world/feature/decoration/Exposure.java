package divinerpg.world.feature.decoration;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.List;
import java.util.function.Supplier;

public class Exposure extends Feature<NoneFeatureConfiguration> {
    public static final BlockState
        exposedScorchalt = BlockRegistry.exposedScorchalt.get().defaultBlockState(),
        rayStone = BlockRegistry.rayStone.get().defaultBlockState();
    public Exposure() {super(NoneFeatureConfiguration.CODEC);}
    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        return place(null, context.level(), null, context.random(), context.origin());
    }
    @Override
    public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator gen, RandomSource random, BlockPos origin) {
        origin = new BlockPos(origin.getX() & 0xFFFF_FFF0, 0, origin.getZ() & 0xFFFF_FFF0);
        BlockPos.MutableBlockPos pos;
        BlockState state = rayStone;
        for(int x = 0; x < 16; x++) for(int z = 0; z < 16; z++) {
            pos = new BlockPos.MutableBlockPos(origin.getX() | x, level.getMaxY(), origin.getZ() | z);
            while(pos.getY() > 127 && (state = level.getBlockState(pos)).isAir()) pos.move(0, -1, 0);
            if(state.is(BlockRegistry.scorchalt)) expose(level, pos);
        } return true;
    }
    public static void expose(WorldGenLevel level, final BlockPos pos) {
        List<Supplier<BlockPos>> positions = List.of(
                () -> pos.offset(1, 2, 0),
                () -> pos.offset(-1, 2, 0),
                () -> pos.offset(0, 2, 1),
                () -> pos.offset(0, 2, -1),
                () -> pos.offset(1, 2, 1),
                () -> pos.offset(-1, 2, -1),
                () -> pos.offset(-1, 2, 1),
                () -> pos.offset(1, 2, -1),
                () -> pos.offset(2, 2, 0),
                () -> pos.offset(-2, 2, 0),
                () -> pos.offset(0, 2, 2),
                () -> pos.offset(0, 2, -2)
        );
        for(Supplier<BlockPos> p : positions) if(!level.isEmptyBlock(p.get())) return;
        boolean b = true;
        positions = List.of(
                () -> pos.offset(3, 2, 0),
                () -> pos.offset(-3, 2, 0),
                () -> pos.offset(0, 2, 3),
                () -> pos.offset(0, 2, -3),
                () -> pos.offset(2, 2, 1),
                () -> pos.offset(2, 2, -1),
                () -> pos.offset(-2, 2, -1),
                () -> pos.offset(-2, 2, 1),
                () -> pos.offset(1, 2, 2),
                () -> pos.offset(1, 2, -2),
                () -> pos.offset(-1, 2, -2),
                () -> pos.offset(-1, 2, 2)
        );
        for(Supplier<BlockPos> p : positions) if(!level.isEmptyBlock(p.get())) {
            b = false;
            break;
        } if(b) {
            level.setBlock(pos, rayStone, 2);
            level.setBlock(pos.below(), exposedScorchalt, 2);
        } else level.setBlock(pos, exposedScorchalt, 2);
    }
}
