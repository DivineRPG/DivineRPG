package divinerpg.world.feature.decoration;

import divinerpg.DivineRPG;
import divinerpg.world.feature.config.RuleTestConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

import static divinerpg.world.placement.Surface.hasSpace;

public class FrozenLight extends Feature<RuleTestConfig> {
	public FrozenLight() {super(RuleTestConfig.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<RuleTestConfig> context) {
		return place(context.config(), context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(RuleTestConfig config, WorldGenLevel level, ChunkGenerator c, RandomSource random, BlockPos pos) {
		if(rule(config.rules, random, level.getBlockState(pos)) && (hasSpace(level, pos.above()) || hasSpace(level, pos.below()) || hasSpace(level, pos.north()) || hasSpace(level, pos.east()) || hasSpace(level, pos.south()) || hasSpace(level, pos.west()))) {
			setBlock(level, pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_stone")).defaultBlockState());
			BlockState stone = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icy_stone")).defaultBlockState();
			if(!hasSpace(level, pos.above())) setBlock(level, pos.above(), stone);
			if(!hasSpace(level, pos.below())) setBlock(level, pos.below(), stone);
			if(!hasSpace(level, pos.north())) setBlock(level, pos.north(), stone);
			if(!hasSpace(level, pos.east())) setBlock(level, pos.east(), stone);
			if(!hasSpace(level, pos.south())) setBlock(level, pos.south(), stone);
			if(!hasSpace(level, pos.west())) setBlock(level, pos.west(), stone);
			return true;
		} return false;
	}
	public static boolean rule(List<RuleTest> rules, RandomSource random, BlockState state) {
		if(rules.isEmpty() && standardRule(state)) return true;
		for(RuleTest test : rules) if(test.test(state, random)) return true;
		return false;
	}
	public static boolean standardRule(BlockState state) {
		return state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_stone"))) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_dirt")));
	}
}