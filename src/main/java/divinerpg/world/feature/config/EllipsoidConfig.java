package divinerpg.world.feature.config;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockStateMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class EllipsoidConfig implements FeatureConfiguration {
    public static final Codec<EllipsoidConfig> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(BlockStateProvider.CODEC.fieldOf("block").forGetter((config) -> config.block),
                    Codec.intRange(1, 16).fieldOf("min_size").forGetter((config) -> config.minSize),
                    Codec.intRange(1, 16).fieldOf("max_size").forGetter((config) -> config.maxSize),
                    Codec.list(RuleTest.CODEC).fieldOf("replace").forGetter((config) -> config.replace)).apply(instance, EllipsoidConfig::new)
    );
    public final BlockStateProvider block;
    public final List<RuleTest> replace;
    public final int minSize, maxSize;
    public EllipsoidConfig(BlockStateProvider block, int minSize, int maxSize, List<RuleTest> replace) {
        this.block = block;
        this.replace = replace;
        this.minSize = minSize;
        this.maxSize = maxSize;
    }
    public EllipsoidConfig(BlockStateProvider block, int minSize, int maxSize, RuleTest growableOn) {
        this(block, minSize, maxSize, ImmutableList.of(growableOn));
    }

    public EllipsoidConfig(BlockStateProvider state, BlockStateProvider target, IntProvider radius) {
        this.block = state;
        this.replace = ImmutableList.of(new BlockStateMatchTest(target.getState(null, null, null)));
        this.maxSize = radius.maxInclusive();
        this.minSize = radius.minInclusive();
    }
}