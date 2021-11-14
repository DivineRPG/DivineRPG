package divinerpg.world.arcana;

import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import divinerpg.world.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.settings.*;

import java.util.*;

public class ArcanaChunkGenerator extends DivineChunkGenerator {
    public static final Codec<ArcanaChunkGenerator> CODEC = RecordCodecBuilder.create(
            (instance) -> instance.group(
                    BiomeProvider.CODEC.fieldOf("biome_source").forGetter((surfaceChunkGenerator) -> surfaceChunkGenerator.biomeSource),
                    DimensionStructuresSettings.CODEC.fieldOf("structures").forGetter((ChunkGenerator::getSettings))
            ).apply(instance, instance.stable(ArcanaChunkGenerator::new)));

    public ArcanaChunkGenerator(BiomeProvider provider, DimensionStructuresSettings settings) {
        super(provider, settings);
    }

    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return CODEC;
    }


    @Override
    public void applyBiomeDecoration(WorldGenRegion region, StructureManager structureManager) {
        //TODO - get maze to generate/add velocitys changes/loot chests
        int chunkX = region.getCenterX(), chunkZ = region.getCenterZ();
        int x = chunkX * 16;
        int z = chunkZ * 16;
        BlockPos pos = new BlockPos(x, 0, z);
        Biome biome = region.getBiome(pos.offset(16, 0, 16));

        region.getRandom().setSeed(region.getSeed());
        long k = region.getRandom().nextLong() / 2L * 2L + 1L;
        long l = region.getRandom().nextLong() / 2L * 2L + 1L;
        region.getRandom().setSeed((long) chunkX * k + (long) chunkZ * l ^ region.getSeed());

        //this.rand is not used for overall maze generation which is specific to the region root instead of the specific chunk
        //However, it will be used to determine per-chunk things like the specific room variant picked, as well as randomize specific things within a chunk

        if(region.getBlockState(new BlockPos(x + 8, 8, z + 8)).getBlock() == Blocks.AIR) {
            long worldSeed = region.getSeed();
            Cell cell = ArcanaMazeGenerator.obtainMazePiece(chunkX, chunkZ, worldSeed);

            Structure<?> toGenerate = ArcanaRooms.getRandomStructureByType(region.getRandom(), cell.getPieceType());
            Rotation rotation;
            if(cell.getPieceType() == Cell.PieceType.CROSSROADS) {
                rotation = Rotation.values()[region.getRandom().nextInt(4)];
            } else {
                rotation = cell.getRotation();
            }
            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(region.getLevel().getChunkSource().generator.getSettings().structureConfig());
            tempMap.put(toGenerate, DimensionStructuresSettings.DEFAULTS.get(toGenerate));
            region.getLevel().getChunkSource().generator.getSettings().structureConfig = tempMap;
        }
    }


}
