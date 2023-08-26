package divinerpg.world.feature.decoration;

import divinerpg.world.placement.Surface;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SnowSpreader extends Feature<NoneFeatureConfiguration> {
	public SnowSpreader() {super(NoneFeatureConfiguration.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		return place(null, context.level(), context.chunkGenerator(), context.random(), context.origin());
	}
	@Override
	public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		MutableBlockPos position;
		double depth;
		for(int x = pos.getX(); x < pos.getX() + 16; x++) for(int z = pos.getZ(); z < pos.getZ() + 16; z++) {
			position = new MutableBlockPos(x, Surface.getSurface(Surface_Type.HIGHEST_GROUND, Mode.FULL, level.getMinBuildHeight(), level.getMaxBuildHeight(), 1, level, random, x, z), z);
			BlockState state = level.getBlockState(position);
			depth = 0D;
			if(state.is(Blocks.SNOW)) {
				depth += state.getValue(BlockStateProperties.LAYERS) * .125;
				position.move(0, -1, 0);
				state = level.getBlockState(position);
			}
			while(state.is(Blocks.SNOW_BLOCK) || state.is(Blocks.POWDER_SNOW)) {
				depth += 1D;
				position.move(0, -1, 0);
				state = level.getBlockState(position);
			}
			position.move(0, 1, 0);
			depth /= 2.1D;
			if(depth >= .125) {
				trySnow(level, random, pos, position.north().mutable(), depth);
				trySnow(level, random, pos, position.south().mutable(), depth);
				trySnow(level, random, pos, position.east().mutable(), depth);
				trySnow(level, random, pos, position.west().mutable(), depth);
			}
		}
		return true;
	}
	protected void trySnow(WorldGenLevel level, RandomSource random, BlockPos origin, MutableBlockPos pos, double depth) {
		if(pos.getX() >> 4 == origin.getX() >> 4 && pos.getZ() >> 4 == origin.getZ() >> 4 && level.hasChunk(SectionPos.blockToSectionCoord(pos.getX()), SectionPos.blockToSectionCoord(pos.getZ()))) {
			BlockState state;
			if((state = level.getBlockState(pos)).is(Blocks.AIR)) {
				while((state = level.getBlockState(pos.move(0, -1, 0))).isAir());
				if(state.is(Blocks.WATER) || state.is(Blocks.BUBBLE_COLUMN) || state.getOptionalValue(BlockStateProperties.WATERLOGGED).orElseGet(() -> false) || state.is(BlockTags.UNDERWATER_BONEMEALS) || state.is(Blocks.KELP)) level.setBlock(pos, Blocks.ICE.defaultBlockState(), 3);
				else if(state.is(Blocks.ICE) || !state.isCollisionShapeFullBlock(level, pos) && !state.is(Blocks.SNOW)) return;
				else {
					if(state.is(BlockTags.LEAVES)) depth -= .2;
					if(state.is(Blocks.SNOW)) {
						depth += .125 * state.getValue(BlockStateProperties.LAYERS);
						if(depth >= 1D) {
							state = depth >= 2D && random.nextFloat() >= .07F ? Blocks.POWDER_SNOW.defaultBlockState() : Blocks.SNOW_BLOCK.defaultBlockState();
							level.setBlock(pos, state, 3);
							depth -= 1D;
						} else {
							level.setBlock(pos, state.setValue(BlockStateProperties.LAYERS, (int) (depth * 8D)), 3);
							return;
						}
					}
					pos.move(0, 1, 0);
					if(depth >= 1D) {
						state = depth >= 2D && random.nextFloat() >= .07F ? Blocks.POWDER_SNOW.defaultBlockState() : Blocks.SNOW_BLOCK.defaultBlockState();
						int i, k = (int) depth;
						for(i = 0; i < k; i++) if(level.getBlockState(pos).isAir()) {
							level.setBlock(pos, state, 3);
							pos.move(0, 1, 0);
						}
						depth -= k;
					}
					if(depth >= .125 && !state.is(Blocks.POWDER_SNOW) && level.getBlockState(pos).isAir()) level.setBlock(pos, Blocks.SNOW.defaultBlockState().setValue(BlockStateProperties.LAYERS, (int) (depth * 8D)), 3);
				}
			}
		}
	}
}