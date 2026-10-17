package divinerpg.world.feature.decoration;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.world.feature.config.decoration.SpudConfig;
import net.minecraft.core.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class HorizontalSpud extends Spud {
    public static final MapCodec<HorizontalSpud> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(SpudConfig.CODEC.fieldOf("config").forGetter(f -> f.config)).apply(instance, HorizontalSpud::new));
    private final SpudConfig config;
    public HorizontalSpud(SpudConfig config) {
        super(config);
        this.config = config;
    }

    @Override
    public boolean place(SpudConfig config, WorldGenLevel level, ChunkGenerator c, RandomSource random, BlockPos pos) {
        if(level.ensureCanWrite(pos) && canBeHere(level, random, pos, config.rules())) {
            config.center().ifPresent(s -> setBlock(level, pos, s));
            if(config.edge().isPresent()) {
                List<RuleTest> rules = config.edgerules().orElse(config.rules());
                BlockState edge = config.edge().get();
                if(GemCluster.rule(rules, random, level.getBlockState(pos.north()), pos)) setBlock(level, pos.north(), edge.setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH));
                if(GemCluster.rule(rules, random, level.getBlockState(pos.east()), pos)) setBlock(level, pos.east(), edge.setValue(HorizontalDirectionalBlock.FACING, Direction.EAST));
                if(GemCluster.rule(rules, random, level.getBlockState(pos.south()), pos)) setBlock(level, pos.south(), edge.setValue(HorizontalDirectionalBlock.FACING, Direction.SOUTH));
                if(GemCluster.rule(rules, random, level.getBlockState(pos.west()), pos)) setBlock(level, pos.west(), edge.setValue(HorizontalDirectionalBlock.FACING, Direction.WEST));
            } return true;
        } return false;
    }
    public static boolean canBeHere(WorldGenLevel level, RandomSource random, BlockPos pos, List<RuleTest> rules) {
        return GemCluster.rule(rules, random, level.getBlockState(pos), pos) && (level.getBlockState(pos.north()).isAir() || level.getBlockState(pos.east()).isAir() || level.getBlockState(pos.south()).isAir() || level.getBlockState(pos.west()).isAir());
    }
}