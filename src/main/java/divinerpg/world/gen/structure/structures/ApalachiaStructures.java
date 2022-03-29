package divinerpg.world.gen.structure.structures;

import com.google.common.collect.*;
import com.mojang.serialization.*;
import divinerpg.world.gen.piece.*;
import divinerpg.world.gen.structure.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
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
    public static class Start extends StructureStart<NoFeatureConfig>  {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }
        @Override
        public void generatePieces(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig config) {
            chunkX = chunkX * 16 + random.nextInt(16);
            chunkZ = chunkZ * 16 + random.nextInt(16);
            if(!chunkGenerator.getBaseColumn(chunkX, chunkZ).getBlockState(new BlockPos(chunkX, DivineStructures.getYPositionForFeature(chunkX, chunkZ, chunkGenerator) - 2, chunkZ)).isAir()) {
                this.pieces.add(new ApalachiaPiece.Piece(templateManagerIn, new BlockPos(chunkX, DivineStructures.getYPositionForFeature(chunkX, chunkZ, chunkGenerator) - 1, chunkZ), Rotation.getRandom(this.random)));
                this.calculateBoundingBox();
            }
        }
    }
}