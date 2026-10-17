package divinerpg.world.feature.pond;

import static divinerpg.world.placement.Surface.hasSpace;

import java.util.List;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.registries.BlockRegistry;
import divinerpg.world.feature.config.RuleTestConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class GlacialPond extends GeothermalPond {
	public static final MapCodec<GlacialPond> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(RuleTestConfig.CODEC.fieldOf("config").forGetter(f -> f.config)).apply(instance, GlacialPond::new));
	RuleTestConfig config;
	public GlacialPond(RuleTestConfig config) {
		super(config);
		this.config = config;
	}

	@Override
	public MapCodec<? extends Feature> codec() {
		return CODEC;
	}

	@Override
	protected void genDeep(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		if(random.nextFloat() < 0.3F) setBlock(level, pos, Blocks.ICE.defaultBlockState());
		pos = pos.below();
		setBlock(level, pos, Blocks.WATER.defaultBlockState());
		genShallow(rules, level, random, pos);
	}
	@Override
	protected void genShallow(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		pos = pos.below();
		setBlock(level, pos, random.nextFloat() < 0.8F && !hasSpace(level, pos.below()) ? BlockRegistry.frozenGravel.get().defaultBlockState() : BlockRegistry.cobbledFrozenStone.get().defaultBlockState());
	}
	@Override
	protected void genEdge(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		if(random.nextFloat() < 0.07F) {
			setBlock(level, pos, Blocks.WATER.defaultBlockState());
			pos = pos.below();
		}
		setBlock(level, pos, BlockRegistry.frozenGravel.get().defaultBlockState());
	}
	@Override
	protected boolean canSustain(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		return rule(rules, random, level.getBlockState(pos), pos) && level.getBlockState(pos.above()).isAir() && !hasSpace(level.getBlockState(pos.below()));
	}
}