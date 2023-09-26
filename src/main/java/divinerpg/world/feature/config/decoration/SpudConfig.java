package divinerpg.world.feature.config.decoration;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class SpudConfig implements FeatureConfiguration {
	public static final Codec<SpudConfig> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(BlockState.CODEC.fieldOf("center").forGetter((config) -> {
	           return config.center;
	        }), BlockState.CODEC.optionalFieldOf("edge").forGetter((config) -> {
	            return config.edge;
	        }),  Codec.list(RuleTest.CODEC).fieldOf("rules").forGetter((config) -> {
	            return config.rules;
	        })).apply(instance, SpudConfig::new);
	});
	public final List<RuleTest> rules;
	public final BlockState center;
	public final Optional<BlockState> edge;
	public SpudConfig(BlockState center, Optional<BlockState> edge, List<RuleTest> rules) {
		this.rules = rules;
		this.center = center;
		this.edge = edge;
	}
	public SpudConfig(BlockState center, Optional<BlockState> edge) {
		this.rules = ImmutableList.of();
		this.center = center;
		this.edge = edge;
	}
}