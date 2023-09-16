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
import net.minecraftforge.registries.ForgeRegistries;

public class FrozenLight extends Feature<RuleTestConfig> {
	public FrozenLight() {super(RuleTestConfig.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<RuleTestConfig> context) {
		return place(context.config(), context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(RuleTestConfig config, WorldGenLevel level, ChunkGenerator c, RandomSource random, BlockPos pos) {
		if(GemCluster.canBeHere(level, random, pos, config.rules)) {
			setBlock(level, pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_stone")).defaultBlockState());
			BlockState stone = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icy_stone")).defaultBlockState();
			if(GemCluster.rule(config.rules, random, level.getBlockState(pos.above()))) setBlock(level, pos.above(), stone);
			if(GemCluster.rule(config.rules, random, level.getBlockState(pos.below()))) setBlock(level, pos.below(), stone);
			if(GemCluster.rule(config.rules, random, level.getBlockState(pos.north()))) setBlock(level, pos.north(), stone);
			if(GemCluster.rule(config.rules, random, level.getBlockState(pos.east()))) setBlock(level, pos.east(), stone);
			if(GemCluster.rule(config.rules, random, level.getBlockState(pos.south()))) setBlock(level, pos.south(), stone);
			if(GemCluster.rule(config.rules, random, level.getBlockState(pos.west()))) setBlock(level, pos.west(), stone);
			return true;
		} return false;
	}
}