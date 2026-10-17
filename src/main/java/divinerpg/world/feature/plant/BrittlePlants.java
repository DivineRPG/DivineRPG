package divinerpg.world.feature.plant;

import com.mojang.serialization.MapCodec;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;

public class BrittlePlants implements Feature {
	public static final MapCodec<BrittlePlants> CODEC = MapCodec.unit(BrittlePlants::new);

	@Override
	public MapCodec<BrittlePlants> codec() {
		return CODEC;
	}

	@Override
	public boolean place(WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		if(level.getBlockState(pos).is(BlockRegistry.brittleMoss.get())) {
			BlockPos p;
			if(level.getBlockState(p = pos.above()).isAir() && random.nextBoolean()) {
				setBlock(level, p, random.nextBoolean() ? BlockRegistry.winterberryBush.get().defaultBlockState() : BlockRegistry.brittleGrass.get().defaultBlockState());
			} else if(level.getBlockState(p = pos.below()).isAir()) {
				if(random.nextBoolean()) {
					int length = random.nextInt(4);
					for(int i = 0; i < length && level.getBlockState(p.below()).isAir(); i++) {
						setBlock(level, p, BlockRegistry.winterberryVinesBody.get().defaultBlockState());
						p = p.below();
					}
					setBlock(level, p, BlockRegistry.winterberryVinesHead.get().defaultBlockState());
				}
			} else {
				return false;
			}
			return true;
		}
		return false;
	}
}