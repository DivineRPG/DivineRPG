package divinerpg.world.arcana;

import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import divinerpg.*;
import divinerpg.world.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.*;
import net.minecraft.world.gen.settings.*;

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
        int x = region.getCenterX() * 16;
        int z = region.getCenterZ() * 16;
        BlockPos pos = new BlockPos(x, 0, z);
        long worldSeed = region.getSeed();
        Cell cell = ArcanaMazeGenerator.obtainMazePiece(region.getCenterX(), region.getCenterZ(), worldSeed);
        ArcanaStructureHandler toGenerate = ArcanaRooms.getRandomStructureByType(region.getRandom(), cell.getPieceType());
        Rotation rotation;
        Template template = region.getLevel().getStructureManager().get(new ResourceLocation(DivineRPG.MODID, toGenerate.getName()));

        region.getRandom().setSeed(region.getSeed());
        long k = region.getRandom().nextLong() / 2L * 2L + 1L;
        long l = region.getRandom().nextLong() / 2L * 2L + 1L;
        region.getRandom().setSeed((long) region.getCenterX() * k + (long) region.getCenterZ() * l ^ region.getSeed());


        if(region.getBlockState(new BlockPos(x + 8, 8, z + 8)).getBlock() == Blocks.AIR) {
            if(cell.getPieceType() == Cell.PieceType.CROSSROADS) {
                rotation = Rotation.values()[region.getRandom().nextInt(4)];
            } else {
                rotation = cell.getRotation();
            }

            BlockPos adjustedPosition = adjustForRotation(pos, template.getSize(), rotation);
            if (template != null && toGenerate.getName() != null ) {
                template.placeInWorld(region,
                        adjustedPosition,
                        new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).setRotation(rotation).addProcessor(DivineStructureBlockProcessor.INSTANCE).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK), region.getRandom());
            }
        }
    }
    private BlockPos adjustForRotation(BlockPos position, BlockPos size, Rotation rotation) {
        switch(rotation) {
            case NONE:
                return position;
            case CLOCKWISE_90:
                return position.offset(size.getZ() - 1, 0, 0);
            case CLOCKWISE_180:
                return position.offset(size.getX() - 1, 0, size.getZ() - 1);
            case COUNTERCLOCKWISE_90:
                return position.offset(0, 0, size.getX() - 1);
            default:
                DivineRPG.LOGGER.warn("Invalid structure rotation passed in somehow, please report this.");
                return position;
        }
    }

}
