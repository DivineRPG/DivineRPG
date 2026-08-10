package divinerpg.world.feature.config.decoration;

import java.util.List;
import java.util.Optional;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public record SpudConfig(Optional<BlockState> center, Optional<BlockState> edge, List<RuleTest> rules, Optional<List<RuleTest>> edgerules) implements FeatureConfiguration {
    public static final Codec<SpudConfig> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(BlockState.CODEC.optionalFieldOf("center").forGetter((config) ->
                    config.center
            ), BlockState.CODEC.optionalFieldOf("edge").forGetter((config) ->
                    config.edge
            ), Codec.list(RuleTest.CODEC).fieldOf("rules").forGetter((config) ->
                    config.rules
            ), Codec.list(RuleTest.CODEC).optionalFieldOf("edge_rules").forGetter((config) ->
                    config.edgerules
            )).apply(instance, SpudConfig::new)
    );
}