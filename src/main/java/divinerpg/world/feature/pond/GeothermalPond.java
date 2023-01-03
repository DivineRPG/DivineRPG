package divinerpg.world.feature.pond;

import divinerpg.DivineRPG;
import divinerpg.world.ConfiguredFeatureKeys;
import divinerpg.world.feature.config.RuleTestConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

import static divinerpg.world.placement.Surface.hasSpace;

public class GeothermalPond extends Feature<RuleTestConfig> {
	public GeothermalPond() {super(RuleTestConfig.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<RuleTestConfig> context) {
		return place(context.config(), context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(RuleTestConfig config, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		if(canSustain(config.rules, level, random, pos)) {
			ArrayList<BlockPos> list = new ArrayList<>();
			generate(list, config.rules, level, random, pos);
			if(list.isEmpty()) return false;
			for(BlockPos p : list) decorate(list, config.rules, level, random, p);
			return true;
		} return false;
	}
	public final boolean rule(List<RuleTest> rules, RandomSource random, BlockState state) {
		if(rules.isEmpty() && standardRule(state)) return true;
		for(RuleTest test : rules) if(test.test(state, random)) return true;
		return false;
	}
	public boolean standardRule(BlockState state) {
		return state.is(BlockTags.MOSS_REPLACEABLE) || state.is(BlockTags.SNOW) || state.is(BlockTags.ICE);
	}
	protected boolean canSustain(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		return hasSpace(level, pos.above()) && !hasSpace(level, pos.below()) && rule(rules, random, level.getBlockState(pos));
	}
	protected void generate(ArrayList<BlockPos> positions, List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		if((positions.isEmpty() || Math.sqrt(Math.pow(pos.getX() - positions.get(0).getX(), 2) + Math.pow(pos.getZ() - positions.get(0).getZ(), 2)) < 8) && random.nextFloat() < 0.8) {
			setBlock(level, pos, Blocks.WATER.defaultBlockState());
			positions.add(pos);
			BlockPos north = pos.north(), south = pos.south(), east = pos.east(), west = pos.west();
			if(!positions.contains(north) && canSustain(rules, level, random, north)) generate(positions, rules, level, random, north);
			if(!positions.contains(east) && canSustain(rules, level, random, east)) generate(positions, rules, level, random, east);
			if(!positions.contains(south) && canSustain(rules, level, random, south)) generate(positions, rules, level, random, south);
			if(!positions.contains(west) && canSustain(rules, level, random, west)) generate(positions, rules, level, random, west);
		}
	}
	protected void decorate(ArrayList<BlockPos> positions, List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		BlockPos north = pos.north(), south = pos.south(), east = pos.east(), west = pos.west();
		if(positions.contains(north) && positions.contains(east) && positions.contains(south) && positions.contains(west)) genDeep(rules, level, random, pos);
		else {
			genShallow(rules, level, random, pos);
			tryGenEdge(rules, level, random, north);
			tryGenEdge(rules, level, random, east);
			tryGenEdge(rules, level, random, south);
			tryGenEdge(rules, level, random, west);
		}
	}
	protected void tryGenEdge(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		BlockState state = level.getBlockState(pos);
		if(!state.getOptionalValue(BlockStateProperties.WATERLOGGED).orElseGet(() -> state.is(Blocks.WATER))) genEdge(rules, level, random, pos);
	}
	protected void genDeep(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		pos = pos.below();
		setBlock(level, pos, Blocks.WATER.defaultBlockState());
		if(random.nextFloat() < 0.1) ConfiguredFeatureKeys.getConfiguredFeature(level, ConfiguredFeatureKeys.THERMAL_VENT).value().place(level, null, random, pos);
		if(rule(rules, random, level.getBlockState(pos.below()))) {
			if(random.nextFloat() < 0.4F) setBlock(level, pos.below(), Blocks.GRAVEL.defaultBlockState());
			else if(random.nextFloat() < 0.3F) setBlock(level, pos.below(), Blocks.CLAY.defaultBlockState());
			else if(random.nextFloat() < 0.2F) {
				pos = pos.below();
				setBlock(level, pos, Blocks.MAGMA_BLOCK.defaultBlockState());
				pos = pos.below();
				if(hasSpace(level, pos) || rule(rules, random, level.getBlockState(pos))) setBlock(level, pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "coalstone")).defaultBlockState());
			}
			else if(random.nextFloat() < 0.2F) setBlock(level, pos.below(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "coalstone")).defaultBlockState());
			else if(random.nextFloat() < 0.05F) setBlock(level, pos.below(), Blocks.OBSIDIAN.defaultBlockState());
			else setBlock(level, pos.below(), Blocks.STONE.defaultBlockState());
		}
	}
	protected void genShallow(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		pos = pos.below();
		if(random.nextFloat() < 0.3F) setBlock(level, pos, Blocks.CLAY.defaultBlockState());
		else if(random.nextFloat() < 0.4F) setBlock(level, pos, Blocks.GRAVEL.defaultBlockState());
		else setBlock(level, pos, Blocks.STONE.defaultBlockState());
	}
	protected void genEdge(List<RuleTest> rules, WorldGenLevel level, RandomSource random, BlockPos pos) {
		if(random.nextFloat() < 0.4F) setBlock(level, pos, Blocks.CLAY.defaultBlockState());
		else if(random.nextFloat() < 0.3F) setBlock(level, pos, Blocks.GRAVEL.defaultBlockState());
		else if(random.nextFloat() < 0.1F) setBlock(level, pos, Blocks.STONE.defaultBlockState());
		else setBlock(level, pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_stone")).defaultBlockState());
	}
}