package divinerpg.world.feature;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.world.feature.config.NBTFeatureConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

import static divinerpg.registries.StructureRegistry.placeStructure;

public class NBTFeature implements Feature {
	public static final MapCodec<NBTFeature> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(NBTFeatureConfig.CODEC.fieldOf("config").forGetter(f -> f.config)).apply(instance, NBTFeature::new));
	private final NBTFeatureConfig config;
	public NBTFeature(NBTFeatureConfig config) {this.config = config;}

	@Override
	public MapCodec<? extends Feature> codec() {
		return CODEC;
	}

	@Override
	public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos pos) {
		return place(config, level, chunkGenerator, random, pos);
	}

	public boolean place(NBTFeatureConfig config, WorldGenLevel level, ChunkGenerator c, RandomSource random, BlockPos pos) {
		if(config.locations.isEmpty()) return false;
		placeStructure(level.getLevel().getServer().getStructureTemplateManager().getOrCreate(config.locations.get(random.nextInt(config.locations.size()))), level, random, pos, Rotation.getRandom(random));
		return true;
	}
}