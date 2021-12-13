package divinerpg.world.gen.structure.structures;

import com.google.common.collect.*;
import com.mojang.serialization.*;
import divinerpg.world.gen.piece.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.*;

import java.util.*;

public class IceikaDungeonStructures extends Structure<NoFeatureConfig> {
    public IceikaDungeonStructures(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public  IStartFactory<NoFeatureConfig> getStartFactory() {
        return IceikaDungeonStructures.Start::new;
    }

    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.UNDERGROUND_STRUCTURES;
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
        BlockPos centerOfChunk = new BlockPos((chunkX << 4)+7, 0, (chunkZ<<4)+7);

        int landHeight = chunkGenerator.getFirstOccupiedHeight(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Type.WORLD_SURFACE_WG);
        IBlockReader columnOfBlocks = chunkGenerator.getBaseColumn(centerOfChunk.getX(), centerOfChunk.getZ());
        BlockState topBlock = columnOfBlocks.getBlockState(centerOfChunk.above(landHeight));
        return topBlock.getFluidState().isEmpty();
    }

    public static class Start extends StructureStart<NoFeatureConfig>  {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }


        @Override
        public void placeInChunk(ISeedReader reader, StructureManager structureManager, ChunkGenerator generator, Random random, MutableBoundingBox box, ChunkPos chunkPos) {
            super.placeInChunk(reader, structureManager, generator, random, box, chunkPos);
        }

        @Override
        public void generatePieces(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig config) {
            ChunkPos chunkpos = new ChunkPos(chunkX, chunkZ);
            int structureX = chunkpos.getMinBlockX() + this.random.nextInt(16);
            int structureZ = chunkpos.getMinBlockZ() + this.random.nextInt(16);
            int seaLevel = chunkGenerator.getSeaLevel();
            int structureY = seaLevel + this.random.nextInt(chunkGenerator.getGenDepth() - seaLevel);
            IBlockReader reader = chunkGenerator.getBaseColumn(structureX, structureZ);

            for (BlockPos.Mutable pos = new BlockPos.Mutable(structureX, structureY, structureZ); structureY > seaLevel; --structureY) {
                BlockState blockstate = reader.getBlockState(pos);
                pos.move(Direction.DOWN);
                BlockState state = reader.getBlockState(pos);
                if (blockstate.isAir() && state.isFaceSturdy(reader, pos, Direction.UP)) {
                    break;
                }
            }

            if (structureY > seaLevel) {
                Rotation rotation = Rotation.getRandom(this.random);
                this.pieces.add(new IceikaDungeonPiece.Piece(templateManagerIn, new BlockPos(structureX, structureY - random.nextInt(20) - 15, structureZ), rotation));
                this.calculateBoundingBox();
            }
        }
    }
}