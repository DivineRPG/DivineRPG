package divinerpg.world.feature.config;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class EllipsoidConfig {
    public static final Codec<EllipsoidConfig> CODEC = RecordCodecBuilder.create((instance) -> instance.group(BlockStateProvider.CODEC.fieldOf("block").forGetter((config) -> config.block), Codec.INT.fieldOf("min_size").forGetter((config) -> config.minSize), Codec.INT.fieldOf("max_size").forGetter((config) -> config.maxSize), RuleTest.CODEC.listOf().fieldOf("replace").forGetter((config) -> config.replace)).apply(instance, (block, minSize, maxSize, replace) -> new EllipsoidConfig(block, minSize, maxSize, replace)));

    public final Holder<BlockStateProvider> block;
    public final int minSize;
    public final int maxSize;
    public final List<RuleTest> replace;

    public EllipsoidConfig(Holder<BlockStateProvider> block, int minSize, int maxSize, List<RuleTest> replace) {
        this.block = block;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.replace = replace;
    }

    public EllipsoidConfig(Holder<BlockStateProvider> block, int minSize, int maxSize, RuleTest growableOn) {
        this(block, minSize, maxSize, ImmutableList.of(growableOn));
    }

    public EllipsoidConfig(Holder<BlockStateProvider> state, Holder<BlockStateProvider> target, IntProvider radius) {
        this.block = state;
        this.minSize = radius.minInclusive();
        this.maxSize = radius.maxInclusive();
        this.replace = ImmutableList.of();
    }
}