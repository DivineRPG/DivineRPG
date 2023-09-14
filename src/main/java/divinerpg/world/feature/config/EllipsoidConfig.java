package divinerpg.world.feature.config;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class EllipsoidConfig implements FeatureConfiguration {
	public static final Codec<EllipsoidConfig> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(BlockStateProvider.CODEC.fieldOf("block").forGetter((config) -> {
	           return config.block;
        }), Codec.intRange(1, 16).fieldOf("min_size").forGetter((config) -> {
	        return config.minSize;
        }), Codec.intRange(1, 16).fieldOf("max_size").forGetter((config) -> {
	        return config.maxSize;
        }),  Codec.list(RuleTest.CODEC).fieldOf("replace").forGetter((config) -> {
            return config.replace;
         })).apply(instance, EllipsoidConfig::new);
	});
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
}
