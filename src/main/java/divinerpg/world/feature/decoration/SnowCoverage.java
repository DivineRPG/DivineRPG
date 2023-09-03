package divinerpg.world.feature.decoration;

import divinerpg.DivineRPG;
import divinerpg.world.placement.Surface;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.DensityFunction.SinglePointContext;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.ForgeRegistries;

public class SnowCoverage extends Feature<NoneFeatureConfiguration> {
	public SnowCoverage() {super(NoneFeatureConfiguration.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		return place(null, context.level(), context.chunkGenerator(), context.random(), context.origin());
	}
	@Override
	public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		boolean success = false;
		if(level.getChunkSource() instanceof ServerChunkCache source) {
			double depth;
			MutableBlockPos position;
			BlockState state;
			NoiseRouter router = source.randomState().router();
			SinglePointContext context;
			Holder<Biome> biome;
			double humidity;
			for(int x = pos.getX(); x < pos.getX() + 16; x++) for(int z = pos.getZ(); z < pos.getZ() + 16; z++) {
				position = new MutableBlockPos(x, Surface.getSurface(Surface_Type.HIGHEST_GROUND, Mode.FULL, level.getMinBuildHeight(), level.getMaxBuildHeight(), 0, level, random, x, z), z);
				state = level.getBlockState(position);
				while(state.is(Blocks.WATER)) {
					position.move(0, 1, 0);
					state = level.getBlockState(position);
				}
				context = new SinglePointContext(position.getX(), position.getY(), position.getZ());
				depth = (((biome = level.getBiome(position)).get().getModifiedClimateSettings().downfall() + level.getBiome(position.north()).get().getModifiedClimateSettings().downfall() + level.getBiome(position.south()).get().getModifiedClimateSettings().downfall() + level.getBiome(position.east()).get().getModifiedClimateSettings().downfall() + level.getBiome(position.west()).get().getModifiedClimateSettings().downfall()) / 5D)
						* ((humidity = router.vegetation().compute(context)) + 1.1) + router.temperature().compute(context) + 1D;
				if(biome.is(new ResourceLocation(DivineRPG.MODID, "iceika/chill_passage")) && humidity < -0.45D && (state = level.getBlockState(position.below())).is(Blocks.SNOW) || state.is(Blocks.POWDER_SNOW) || state.is(Blocks.SNOW_BLOCK) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_grass")))) {
					level.setBlock(position.below(), Blocks.PACKED_ICE.defaultBlockState(), 3);
					success = true;
				} else if(depth >= .125) {
					state = level.getBlockState(position.below());
					if(state.is(Blocks.WATER) || state.is(Blocks.BUBBLE_COLUMN) || state.getOptionalValue(BlockStateProperties.WATERLOGGED).orElseGet(() -> false) || state.is(BlockTags.UNDERWATER_BONEMEALS) || state.is(Blocks.KELP)) level.setBlock(position.below(), Blocks.ICE.defaultBlockState(), 3);
					else if(state.is(Blocks.SNOW_BLOCK) || state.is(Blocks.SNOW) || state.is(Blocks.POWDER_SNOW) || state.is(BlockTags.ICE) || !state.isCollisionShapeFullBlock(level, pos)) continue;
					else {
						if(state.is(BlockTags.LEAVES)) depth -= .2;
						if(depth >= 1D) {
							state = depth >= 2D && random.nextFloat() >= .07F ? Blocks.POWDER_SNOW.defaultBlockState() : Blocks.SNOW_BLOCK.defaultBlockState();
							int i, k = (int) depth;
							for(i = 0; i < k; i++) if(level.getBlockState(position).isAir()) {
								level.setBlock(position, state, 3);
								position.move(0, 1, 0);
							}
							depth -= k;
						}
						if(depth >= .125 && !state.is(Blocks.POWDER_SNOW) && level.getBlockState(position).isAir()) level.setBlock(position, Blocks.SNOW.defaultBlockState().setValue(BlockStateProperties.LAYERS, (int) (depth * 8D)), 3);
					}
					success = true;
				}
			}
		} else DivineRPG.LOGGER.info("could not access server chunk cache");
		return success;
	}
}
