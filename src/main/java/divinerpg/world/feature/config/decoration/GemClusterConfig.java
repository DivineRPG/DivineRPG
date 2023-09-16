package divinerpg.world.feature.config.decoration;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class GemClusterConfig implements FeatureConfiguration {
	public static final Codec<GemClusterConfig> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(BlockState.CODEC.fieldOf("block").forGetter((config) -> {
	           return config.block;
	        }), BlockState.CODEC.fieldOf("budding_block").forGetter((config) -> {
	            return config.buddingBlock;
	        }), BlockState.CODEC.fieldOf("cluster").forGetter((config) -> {
	            return config.cluster;
	        }),  Codec.list(RuleTest.CODEC).fieldOf("rules").forGetter((config) -> {
	            return config.rules;
	        })).apply(instance, GemClusterConfig::new);
	});
	public final List<RuleTest> rules;
	public final BlockState block, buddingBlock, cluster;
	public GemClusterConfig(BlockState block, BlockState buddingBlock, BlockState cluster, List<RuleTest> rules) {
		this.rules = rules;
		this.block = block;
		this.buddingBlock = buddingBlock;
		this.cluster = cluster;
	}
	public GemClusterConfig(BlockState block, BlockState buddingBlock, BlockState cluster) {
		this.rules = ImmutableList.of();
		this.block = block;
		this.buddingBlock = buddingBlock;
		this.cluster = cluster;
	}
}