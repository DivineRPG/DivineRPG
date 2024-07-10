package divinerpg.world.feature.plant;

import divinerpg.blocks.iceika.BlockBrittleGrass;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class BrittlePlants extends Feature<NoneFeatureConfiguration> {
	public BrittlePlants() {super(NoneFeatureConfiguration.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		return place(null, context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		if(level.getBlockState(pos).is(BlockRegistry.brittleMoss.get())) {
			BlockPos p;
			if(level.getBlockState(p = pos.above()).isAir() && random.nextBoolean()) setBlock(level, p, random.nextBoolean() ? BlockRegistry.winterberryBush.get().defaultBlockState() : BlockRegistry.brittleGrass.get().defaultBlockState());
			else if(level.getBlockState(p = pos.below()).isAir()) {
				if(random.nextBoolean()) {
					int length = random.nextInt(4);
					for(int i = 0; i < length && level.getBlockState(p.below()).isAir(); i++) {
						setBlock(level, p, BlockRegistry.winterberryVinesBody.get().defaultBlockState());
						p = p.below();
					}
					setBlock(level, p, BlockRegistry.winterberryVinesHead.get().defaultBlockState());
				} else setBlock(level, p, BlockRegistry.brittleGrass.get().defaultBlockState().setValue(BlockBrittleGrass.HANGING, true));
			} else return false;
			return true;
		} return false;
	}
}