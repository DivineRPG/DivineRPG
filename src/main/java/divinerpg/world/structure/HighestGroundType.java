package divinerpg.world.structure;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.registries.StructureRegistry;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraft.world.level.levelgen.structure.pools.*;

import java.util.*;

public final class HighestGroundType extends Structure {
    public static final Codec<HighestGroundType> CODEC = RecordCodecBuilder.<HighestGroundType>mapCodec(instance ->
            instance.group(HighestGroundType.settingsCodec(instance),
                    StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                    ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                    Codec.intRange(0, 30).fieldOf("size").forGetter(structure -> structure.size),
                    Codec.INT.fieldOf("min_height").forGetter(structure -> structure.minHeight),
                    Codec.INT.fieldOf("max_height").forGetter(structure -> structure.maxHeight),
                    Codec.INT.fieldOf("bury").forGetter(structure -> structure.bury),
                    Codec.STRING.optionalFieldOf("mode", "full").forGetter(structure -> structure.mode),
                    Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter)
            ).apply(instance, HighestGroundType::new)).codec();

    private final Holder<StructureTemplatePool> startPool;
    private final Optional<ResourceLocation> startJigsawName;
    private final String mode;
    private final int size, minHeight, maxHeight, bury, maxDistanceFromCenter;

    public HighestGroundType(Structure.StructureSettings config,
                                      Holder<StructureTemplatePool> startPool,
                                      Optional<ResourceLocation> startJigsawName,
                                      int size, int minHeight, int maxHeight, int bury,
                                      String mode,
                                      int maxDistanceFromCenter)
    {
        super(config);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.size = size;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.bury = bury;
        this.mode = mode;
        this.maxDistanceFromCenter = maxDistanceFromCenter;
    }

    @Override
    public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext context) {
        WorldgenRandom worldgenrandom = context.random();
        int x = context.chunkPos().getMinBlockX() + worldgenrandom.nextInt(16);
        int z = context.chunkPos().getMinBlockZ() + worldgenrandom.nextInt(16);
    	NoiseColumn column = context.chunkGenerator().getBaseColumn(x, z, context.heightAccessor(), context.randomState());
    	final int minY = mode.equals("random_section") ? context.random().nextInt(minHeight, maxHeight + 1) : minHeight;
    	int y = mode.equals("full") ? maxHeight : context.random().nextInt(minY, maxHeight + 1);
    	if(!column.getBlock(y).isAir()) do{y--;} while(y > minY - 2 && !column.getBlock(y).isAir());
    	while(y > minY - 2 && column.getBlock(y).isAir()) y--;
    	if(y < minY) return Optional.empty();
    	else y -= bury + 1;
        Optional<Structure.GenerationStub> structurePiecesGenerator =
                JigsawPlacement.addPieces(
                        context,
                        this.startPool,
                        this.startJigsawName,
                        this.size,
                        new BlockPos(x, y, z),
                        false,
                        Optional.empty(),
                        this.maxDistanceFromCenter);

        return structurePiecesGenerator;
    }

    public StructureType<?> type() {
        return StructureRegistry.HIGHEST_GROUND.get();
    }
}