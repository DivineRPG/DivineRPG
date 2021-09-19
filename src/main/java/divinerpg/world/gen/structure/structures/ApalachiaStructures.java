package divinerpg.world.gen.structure.structures;

import com.google.common.collect.*;
import com.mojang.serialization.*;
import divinerpg.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.jigsaw.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.*;

import java.util.*;

public class ApalachiaStructures extends Structure<NoFeatureConfig> {
    public ApalachiaStructures(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public  IStartFactory<NoFeatureConfig> getStartFactory() {
        return Start::new;
    }

    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }

    private static final List<MobSpawnInfo.Spawners> STRUCTURE_MONSTERS = ImmutableList.of(
    );
    @Override
    public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
        return STRUCTURE_MONSTERS;
    }

    private static final List<MobSpawnInfo.Spawners> STRUCTURE_CREATURES = ImmutableList.of(
    );
    @Override
    public List<MobSpawnInfo.Spawners> getDefaultCreatureSpawnList() {
        return STRUCTURE_CREATURES;
    }




    @Override
    protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeProvider biomeSource, long seed, SharedSeedRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, NoFeatureConfig featureConfig) {
        return getYPositionForFeature(chunkX, chunkZ, chunkGenerator) >= 60;
    }
    private static int getYPositionForFeature(final int xChunk, final int zChunk, final ChunkGenerator chunkGen) {
        final Random random4 = new Random((long)(xChunk + zChunk * 10387313));
        final Rotation bzj5 = Rotation.getRandom(random4);
        int integer3 = 5;
        int integer4 = 5;
        if (bzj5 == Rotation.CLOCKWISE_90) {
            integer3 = -5;
        }
        else if (bzj5 == Rotation.CLOCKWISE_180) {
            integer3 = -5;
            integer4 = -5;
        }
        else if (bzj5 == Rotation.COUNTERCLOCKWISE_90) {
            integer4 = -5;
        }
        final int integer5 = (xChunk << 4) + 7;
        final int integer6 = (zChunk << 4) + 7;
        final int integer7 = chunkGen.getFirstOccupiedHeight(integer5, integer6, Heightmap.Type.WORLD_SURFACE_WG);
        final int integer8 = chunkGen.getFirstOccupiedHeight(integer5, integer6 + integer4, Heightmap.Type.WORLD_SURFACE_WG);
        final int integer9 = chunkGen.getFirstOccupiedHeight(integer5 + integer3, integer6, Heightmap.Type.WORLD_SURFACE_WG);
        final int integer10 = chunkGen.getFirstOccupiedHeight(integer5 + integer3, integer6 + integer4, Heightmap.Type.WORLD_SURFACE_WG);
        return Math.min(Math.min(integer7, integer8), Math.min(integer9, integer10));
    }

    public static class Start extends StructureStart<NoFeatureConfig>  {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }



        @Override
        public void generatePieces(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig config) {
            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;

            BlockPos blockpos = new BlockPos(x, 0, z);

            JigsawManager.addPieces(
                    dynamicRegistryManager,
                    new VillageConfig(() -> dynamicRegistryManager.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY)
                            .get(new ResourceLocation(DivineRPG.MODID, "twilight/apalachia")), 10),
                    AbstractVillagePiece::new,
                    chunkGenerator,
                    templateManagerIn,
                    blockpos,
                    this.pieces,
                    this.random,
                    false,
                    true);

            this.calculateBoundingBox();
        }
    }
}