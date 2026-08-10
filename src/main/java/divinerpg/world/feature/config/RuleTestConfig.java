package divinerpg.world.feature.config;

import java.util.List;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class RuleTestConfig implements FeatureConfiguration {
	public static final Codec<RuleTestConfig> CODEC = Codec.list(RuleTest.CODEC).fieldOf("rules").xmap(RuleTestConfig::new, (config) -> {
		return config.rules;
	}).codec();
	public final List<RuleTest> rules;
	public RuleTestConfig(List<RuleTest> rules) {
		this.rules = rules;
	}
}