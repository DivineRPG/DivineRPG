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
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.*;

import java.util.*;

public class IceikaStructures extends Structure<NoFeatureConfig> {
    public IceikaStructures(Codec<NoFeatureConfig> codec) {
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
            if(random.nextInt(5) != 0) {
            	return;
            }
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
                if (blockstate.is(Blocks.AIR) && state.isFaceSturdy(reader, pos, Direction.UP)) {
                    break;
                }
            }

            if (structureY > seaLevel) {
                Rotation rotation = Rotation.getRandom(this.random);
                pieces.add(new IceikaHousePiece.Piece(templateManagerIn, new BlockPos(structureX, structureY - 1, structureZ), rotation));
                this.calculateBoundingBox();
            }
        }
    }
}