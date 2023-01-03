package divinerpg.world.feature.plant;

import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.ForgeRegistries;

public class GemOfTheDunes extends Feature<NoneFeatureConfiguration> {
	public GemOfTheDunes() {super(NoneFeatureConfiguration.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		return place(null, context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos origin) {
		if(level.canSeeSky(origin)) return false;
		setBlock(level, origin, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "gem_of_the_dunes")).defaultBlockState());
		return true;
	}
}