package divinerpg.world.feature.pond;

import java.util.List;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.registries.BlockRegistry;
import divinerpg.world.config.tree.TreeConfig;
import divinerpg.world.feature.config.RuleTestConfig;
import divinerpg.world.feature.tree.ShiverspineTree;
import net.minecraft.core.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class MineralPond extends GlacialPond {
	public static final MapCodec<MineralPond> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(RuleTestConfig.CODEC.fieldOf("config").forGetter(f -> f.config)).apply(instance, MineralPond::new));
	private RuleTestConfig config;
	public MineralPond(RuleTestConfig config) {
		super(config);
		this.config = config;
	}

	@Override
	public MapCodec<? extends Feature> codec() {
		return CODEC;
	}

	@Override
	protected void genDeep(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		setBlock(level, pos, Blocks.WATER.defaultBlockState());
		pos = pos.below();
		genShallow(rules, level, random, pos);
	}
	@Override
	protected void genShallow(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		if(random.nextFloat() <= .3F) {
			boolean b = random.nextBoolean();
			setBlock(level, pos, (b ? Blocks.AMETHYST_CLUSTER.defaultBlockState() : BlockRegistry.olivineCluster.get().defaultBlockState()).setValue(BlockStateProperties.FACING, Direction.UP).setValue(BlockStateProperties.WATERLOGGED, true));
			if(random.nextBoolean()) {
				setBlock(level, pos.below(), (b ? Blocks.AMETHYST_BLOCK.defaultBlockState() : BlockRegistry.olivineBlock.get().defaultBlockState()));
				return;
			}
		} else if(random.nextFloat() <= .2F) {
			if(random.nextBoolean()) {
				setBlock(level, pos, Blocks.AMETHYST_CLUSTER.defaultBlockState().setValue(BlockStateProperties.FACING, Direction.UP).setValue(BlockStateProperties.WATERLOGGED, true));
				setBlock(level, pos.below(), Blocks.BUDDING_AMETHYST.defaultBlockState());
			} else {
				setBlock(level, pos, BlockRegistry.olivineCluster.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.UP).setValue(BlockStateProperties.WATERLOGGED, true));
				setBlock(level, pos.below(), BlockRegistry.buddingOlivine.get().defaultBlockState());
			} return;
		} else setBlock(level, pos, Blocks.WATER.defaultBlockState());
		pos = pos.below();
		setBlock(level, pos, random.nextFloat() <= .1F ? BlockRegistry.blueStone.get().defaultBlockState() : BlockRegistry.frozenGravel.get().defaultBlockState());
	}
	@Override
	protected void genEdge(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		if(random.nextFloat() <= .25F) {
			boolean b = random.nextBoolean();
			setBlock(level, pos.above(), (b ? Blocks.AMETHYST_CLUSTER.defaultBlockState() : BlockRegistry.olivineCluster.get().defaultBlockState()).setValue(BlockStateProperties.FACING, Direction.UP));
			if(random.nextBoolean()) {
				setBlock(level, pos, (b ? Blocks.AMETHYST_BLOCK.defaultBlockState() : BlockRegistry.olivineBlock.get().defaultBlockState()));
				return;
			}
		} else if(random.nextFloat() <= .2F) {
			if(random.nextBoolean()) {
				setBlock(level, pos.above(), Blocks.AMETHYST_CLUSTER.defaultBlockState().setValue(BlockStateProperties.FACING, Direction.UP));
				setBlock(level, pos, Blocks.BUDDING_AMETHYST.defaultBlockState());
			} else {
				setBlock(level, pos.above(), BlockRegistry.olivineCluster.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.UP));
				setBlock(level, pos, BlockRegistry.buddingOlivine.get().defaultBlockState());
			} return;
		} setBlock(level, pos, BlockRegistry.cobbledFrozenStone.get().defaultBlockState());
	}
}