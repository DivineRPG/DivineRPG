package divinerpg.world.feature.decoration;

import static divinerpg.world.placement.Surface.hasSpace;

import java.util.List;

import divinerpg.DivineRPG;
import divinerpg.world.feature.config.decoration.GemClusterConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.registries.ForgeRegistries;

public class GemCluster extends Feature<GemClusterConfig> {
	public GemCluster() {super(GemClusterConfig.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<GemClusterConfig> context) {
		return place(context.config(), context.level(), context.chunkGenerator(), context.random(), context.origin());
	}
	@Override
	public boolean place(GemClusterConfig config, WorldGenLevel level, ChunkGenerator c, RandomSource random, BlockPos origin) {
		if(canBeHere(level, random, origin, config.rules)) {
			if(random.nextFloat() <= .2F) {
				setBlock(level, origin, config.buddingBlock);
				populateWithClusters(level, random, origin, config.cluster, 1F);
			} else if(random.nextFloat() <= .25F) {
				BlockState state;
				if(hasSpace(state = level.getBlockState(origin.above()))) setBlock(level, origin.above(), config.cluster.setValue(BlockStateProperties.FACING, Direction.UP).setValue(BlockStateProperties.WATERLOGGED, state.is(Blocks.WATER)));
				else if(hasSpace(state = level.getBlockState(origin.below()))) setBlock(level, origin.below(), config.cluster.setValue(BlockStateProperties.FACING, Direction.DOWN).setValue(BlockStateProperties.WATERLOGGED, state.is(Blocks.WATER)));
				else if(hasSpace(state = level.getBlockState(origin.north()))) setBlock(level, origin.north(), config.cluster.setValue(BlockStateProperties.FACING, Direction.NORTH).setValue(BlockStateProperties.WATERLOGGED, state.is(Blocks.WATER)));
				else if(hasSpace(state = level.getBlockState(origin.south()))) setBlock(level, origin.south(), config.cluster.setValue(BlockStateProperties.FACING, Direction.SOUTH).setValue(BlockStateProperties.WATERLOGGED, state.is(Blocks.WATER)));
				else if(hasSpace(state = level.getBlockState(origin.east()))) setBlock(level, origin.east(), config.cluster.setValue(BlockStateProperties.FACING, Direction.EAST).setValue(BlockStateProperties.WATERLOGGED, state.is(Blocks.WATER)));
				else if(hasSpace(state = level.getBlockState(origin.west()))) setBlock(level, origin.west(), config.cluster.setValue(BlockStateProperties.FACING, Direction.WEST).setValue(BlockStateProperties.WATERLOGGED, state.is(Blocks.WATER)));
			} else {
				setBlock(level, origin, config.block);
				populateWithClusters(level, random, origin, config.cluster, .2F);
			} return true;
		} return false;
	}
	protected void populateWithClusters(WorldGenLevel level, RandomSource random, BlockPos pos, BlockState cluster, float chance) {
		BlockState state;
		if(hasSpace(state = level.getBlockState(pos.above())) && (chance == 1F || random.nextFloat() <= chance)) setBlock(level, pos.above(), cluster.setValue(BlockStateProperties.FACING, Direction.UP).setValue(BlockStateProperties.WATERLOGGED, state.is(Blocks.WATER)));
		if(hasSpace(state = level.getBlockState(pos.below())) && (chance == 1F || random.nextFloat() <= chance)) setBlock(level, pos.below(), cluster.setValue(BlockStateProperties.FACING, Direction.DOWN).setValue(BlockStateProperties.WATERLOGGED, state.is(Blocks.WATER)));
		if(hasSpace(state = level.getBlockState(pos.north())) && (chance == 1F || random.nextFloat() <= chance)) setBlock(level, pos.north(), cluster.setValue(BlockStateProperties.FACING, Direction.NORTH).setValue(BlockStateProperties.WATERLOGGED, state.is(Blocks.WATER)));
		if(hasSpace(state = level.getBlockState(pos.south())) && (chance == 1F || random.nextFloat() <= chance)) setBlock(level, pos.south(), cluster.setValue(BlockStateProperties.FACING, Direction.SOUTH).setValue(BlockStateProperties.WATERLOGGED, state.is(Blocks.WATER)));
		if(hasSpace(state = level.getBlockState(pos.east())) && (chance == 1F || random.nextFloat() <= chance)) setBlock(level, pos.east(), cluster.setValue(BlockStateProperties.FACING, Direction.EAST).setValue(BlockStateProperties.WATERLOGGED, state.is(Blocks.WATER)));
		if(hasSpace(state = level.getBlockState(pos.west())) && (chance == 1F || random.nextFloat() <= chance)) setBlock(level, pos.west(), cluster.setValue(BlockStateProperties.FACING, Direction.WEST).setValue(BlockStateProperties.WATERLOGGED, state.is(Blocks.WATER)));
	}
	public static boolean canBeHere(WorldGenLevel level, RandomSource random, BlockPos pos, List<RuleTest> rules) {
		return rule(rules, random, level.getBlockState(pos)) && (hasSpace(level, pos.above()) || hasSpace(level, pos.below()) || hasSpace(level, pos.north()) || hasSpace(level, pos.east()) || hasSpace(level, pos.south()) || hasSpace(level, pos.west()));
	}
	public static boolean rule(List<RuleTest> rules, RandomSource random, BlockState state) {
		if(rules.isEmpty() && standardRule(state)) return true;
		for(RuleTest test : rules) if(test.test(state, random)) return true;
		return false;
	}
	public static boolean standardRule(BlockState state) {
		return state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_stone"))) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "cobbled_frozen_stone"))) || state.is(BlockTags.ICE);
	}
}