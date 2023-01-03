package divinerpg.world.feature;

import static divinerpg.registries.StructureRegistry.placeStructure;

import divinerpg.world.feature.config.NBTFeatureConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class NBTFeature extends Feature<NBTFeatureConfig> {
	public NBTFeature() {super(NBTFeatureConfig.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NBTFeatureConfig> context) {
		return place(context.config(), context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(NBTFeatureConfig config, WorldGenLevel level, ChunkGenerator c, RandomSource random, BlockPos pos) {
		placeStructure(level.getLevel().getServer().getStructureManager().getOrCreate(config.location), level, random, pos, Rotation.getRandom(random));
		return true;
	}
}