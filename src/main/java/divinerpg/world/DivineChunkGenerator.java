package divinerpg.world;

import com.mojang.serialization.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.settings.*;

public class DivineChunkGenerator extends ChunkGenerator {
    private Codec<? extends ChunkGenerator> codec;

    public DivineChunkGenerator(BiomeProvider provider, DimensionStructuresSettings settings) {
        super(provider, settings);
    }

    public DivineChunkGenerator(BiomeProvider biomeProvider1, BiomeProvider biomeProvider2, DimensionStructuresSettings settings, long seed) {
        super(biomeProvider1, biomeProvider2, settings, seed);
    }

    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return codec;
    }

    @Override
    public ChunkGenerator withSeed(long seed) {
        return this;
    }

    @Override
    public void buildSurfaceAndBedrock(WorldGenRegion region, IChunk chunk) {

    }

    @Override
    public void fillFromNoise(IWorld world, StructureManager manager, IChunk chunk) {

    }

    @Override
    public int getBaseHeight(int x, int y, Heightmap.Type type) {
        return 0;
    }

    @Override
    public IBlockReader getBaseColumn(int x, int y) {
        return null;
    }
}
