package divinerpg.world.feature.config.tree;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class TreeConfig implements FeatureConfiguration {
	public static final Codec<TreeConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(BlockState.CODEC.fieldOf("log").forGetter((config) -> {
           return config.log;
        }), BlockState.CODEC.fieldOf("leaves").forGetter((config) -> {
            return config.leaves;
        }),  Codec.list(RuleTest.CODEC).fieldOf("can_grow_on").forGetter((config) -> {
            return config.growableOn;
         })).apply(instance, TreeConfig::new);
     });
	public final List<RuleTest> growableOn;
	public final BlockState log, leaves;
	public TreeConfig(BlockState log, BlockState leaves, List<RuleTest> growableOn) {
		this.log = log;
		this.leaves = leaves;
		this.growableOn = growableOn;
	}
	public TreeConfig(BlockState log, BlockState leaves, RuleTest growableOn) {
		this(log, leaves, ImmutableList.of(growableOn));
	}
}