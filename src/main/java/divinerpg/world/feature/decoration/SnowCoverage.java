package divinerpg.world.feature.decoration;

import divinerpg.DivineRPG;
import divinerpg.world.placement.Surface;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.DensityFunction.SinglePointContext;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SnowCoverage extends Feature<NoneFeatureConfiguration> {
	public SnowCoverage() {super(NoneFeatureConfiguration.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		return place(null, context.level(), context.chunkGenerator(), context.random(), context.origin());
	}
	@Override
	public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		byte i = 0;
		for(int x = pos.getX(); x < pos.getX() + 16; x++) for(int z = pos.getZ(); z < pos.getZ() + 16; z++) i += snow(level, random, new MutableBlockPos(x, Surface.getSurface(Surface_Type.HIGHEST_GROUND, Mode.FULL, level.getMinBuildHeight(), level.getMaxBuildHeight(), 0, level, random, x, z), z));
		return i > 0;
	}
	public static boolean isWaterBlock(BlockState state) {
		return state.is(Blocks.WATER) || state.is(Blocks.BUBBLE_COLUMN) || state.getOptionalValue(BlockStateProperties.WATERLOGGED).orElseGet(() -> false) || state.is(BlockTags.UNDERWATER_BONEMEALS) || state.is(Blocks.KELP) || state.is(Blocks.TALL_SEAGRASS);
	}
	public static byte snow(WorldGenLevel level, RandomSource random, MutableBlockPos position) {
		if(level.getChunkSource() instanceof ServerChunkCache source) {
			while(isWaterBlock(level.getBlockState(position))) position.move(0, 1, 0);
			SinglePointContext context = new SinglePointContext(position.getX(), position.getY(), position.getZ());
			NoiseRouter router = source.randomState().router();
			double depth = ((level.getBiome(position).get().getModifiedClimateSettings().downfall() + level.getBiome(position.north()).get().getModifiedClimateSettings().downfall() + level.getBiome(position.south()).get().getModifiedClimateSettings().downfall() + level.getBiome(position.east()).get().getModifiedClimateSettings().downfall() + level.getBiome(position.west()).get().getModifiedClimateSettings().downfall()) / 5D)
					* (router.vegetation().compute(context) + 1.1) + router.temperature().compute(context) + 1D;
			if(depth >= .125) {
				BlockPos below = position.below();
				BlockState state = level.getBlockState(below);
				if(isWaterBlock(state)) level.setBlock(below, Blocks.ICE.defaultBlockState(), 3);
				else if(state.is(Blocks.SNOW_BLOCK) || state.is(Blocks.SNOW) || state.is(Blocks.POWDER_SNOW) || state.is(BlockTags.ICE) || !state.isCollisionShapeFullBlock(level, below)) return 0;
				else {
					if(state.is(BlockTags.LEAVES)) depth -= .2;
					if(state.hasProperty(BlockStateProperties.SNOWY)) {
						MutableBlockPos p = below.mutable();
						snowLog(level, p, state.setValue(BlockStateProperties.SNOWY, true), new boolean[]{level.getBlockState(p.north()).isAir(), level.getBlockState(p.south()).isAir(), level.getBlockState(p.east()).isAir(), level.getBlockState(p.west()).isAir()});
					}
					if(depth >= 1D) {
						if(depth >= 2D) {
							depth = Math.floor(depth);
							state = random.nextFloat() >= .05F ? Blocks.POWDER_SNOW.defaultBlockState() : Blocks.SNOW_BLOCK.defaultBlockState();
						} else state = Blocks.SNOW_BLOCK.defaultBlockState();
						int i, k = (int) depth;
						for(i = 0; i < k; i++) if(level.getBlockState(position).isAir()) {
							level.setBlock(position, state, 3);
							position.move(0, 1, 0);
						}
						depth -= k;
					}
					if(depth >= .125 && !state.is(Blocks.POWDER_SNOW) && level.getBlockState(position).isAir()) level.setBlock(position, Blocks.SNOW.defaultBlockState().setValue(BlockStateProperties.LAYERS, (int) (depth * 8D)), 3);
				}
				return 1;
			}
		} else DivineRPG.LOGGER.info("could not access server chunk cache");
		return 0;
	}
	static void snowLog(WorldGenLevel level, MutableBlockPos pos, BlockState snowyBlock, boolean[] space) {
		level.setBlock(pos, snowyBlock, 2);
		pos.move(0, -1, 0);
		if(space[0] && !level.getBlockState(pos.north()).isAir()) space[0] = false;
		if(space[1] && !level.getBlockState(pos.south()).isAir()) space[1] = false;
		if(space[2] && !level.getBlockState(pos.east()).isAir()) space[2] = false;
		if(space[3] && !level.getBlockState(pos.west()).isAir()) space[3] = false;
		if(space[0] || space[1] || space[2] || space[3]) {
			BlockState nextState = level.getBlockState(pos);
			if(nextState.is(snowyBlock.getBlock())) snowLog(level, pos, nextState.setValue(BlockStateProperties.SNOWY, true), space);
		}
	}
}
