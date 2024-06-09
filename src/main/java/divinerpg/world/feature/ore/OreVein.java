package divinerpg.world.feature.ore;

import java.util.List;

import divinerpg.world.feature.config.ore.OreVeinConfig;
import net.minecraft.core.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;

public class OreVein extends Feature<OreVeinConfig> {
	public OreVein() {
		super(OreVeinConfig.CODEC);
	}
	@Override
	public boolean place(OreVeinConfig config, WorldGenLevel level, ChunkGenerator generator, RandomSource random, BlockPos origin) {
		List<OreVeinConfig.TargetBlockState> states = config.targetStates;
		if(VeinArm.canBeHere(level, origin, states, random)) {
			new VeinArm(origin, Direction.getRandom(random)).run(level, random, origin, config.cutoffChance, config.straightness, config.branchingChance, states);
			return true;
		} return false;
	}
	@Override
	public boolean place(FeaturePlaceContext<OreVeinConfig> context) {
		return place(context.config(), context.level(), context.chunkGenerator(), context.random(), context.origin());
	}
	public static class VeinArm {
		Direction direction;
		BlockPos pos;
		public VeinArm(BlockPos p, Direction dir){
			pos = p;
			direction = dir;
		}
		public static boolean canBeHere(WorldGenLevel level, BlockPos pos, List<OreVeinConfig.TargetBlockState> states, RandomSource random) {
			BlockState state = level.getBlockState(pos);
			for(OreVeinConfig.TargetBlockState targetState : states) {
				if(targetState.state.is(state.getBlock())) return true;
				if(targetState.target.test(state, random)) return true;
			}
			return false;
		}
		public void run(WorldGenLevel level, RandomSource random, BlockPos origin, float cutoffChance, float straightness, float branchingChance, List<OreVeinConfig.TargetBlockState> states) {
			while(level.getChunk(origin) == level.getChunk(pos)  && canBeHere(level, pos, states, random) && random.nextFloat() > cutoffChance) {
				setVeinPart(level, random, pos, states);
				setVeinPart(level, random, pos.above(), states);
				setVeinPart(level, random, pos.below(), states);
				setVeinPart(level, random, pos.north(), states);
				setVeinPart(level, random, pos.east(), states);
				setVeinPart(level, random, pos.west(), states);
				setVeinPart(level, random, pos.south(), states);
				pos = pos.relative(direction);
				if(random.nextFloat() > straightness) direction = Direction.getRandom(random);
				if(random.nextFloat() <= branchingChance) new VeinArm(pos, Direction.getRandom(random)).run(level, random, origin, cutoffChance, straightness, branchingChance, states);
			}
		}
		public void setVeinPart(WorldGenLevel level, RandomSource random, BlockPos pos, List<OreVeinConfig.TargetBlockState> states) {
			if(random.nextBoolean()) pos = pos.relative(Direction.getRandom(random));
			OreVeinConfig.TargetBlockState targetState = states.get(random.nextInt(states.size()));
			if(random.nextFloat() <= targetState.chance
					&& targetState.target.test(level.getBlockState(pos), random)
					&& (random.nextFloat() > targetState.discardChanceOnAirExposure || !checkForAir(level, pos)))
				level.setBlock(pos, targetState.state, 3);
		}
		public boolean checkForAir(WorldGenLevel level, BlockPos pos) {
			return level.isEmptyBlock(pos.above()) || level.isEmptyBlock(pos.below()) || level.isEmptyBlock(pos.north()) || level.isEmptyBlock(pos.south()) || level.isEmptyBlock(pos.east()) || level.isEmptyBlock(pos.west());
		}
	}
}