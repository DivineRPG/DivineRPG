package divinerpg.world.arcana;

import com.mojang.serialization.*;
import divinerpg.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.jigsaw.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.*;

public class ArcanaStructure extends Structure<NoFeatureConfig>
{
    ResourceLocation location;
    public ArcanaStructure(Codec<NoFeatureConfig> codec, String location)
    {
        super(codec);
        this.location=new ResourceLocation(DivineRPG.MODID, location);
    }

    public ResourceLocation getLocation() {
        return location;
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory()
    {
        return ArcanaStructure.Start::new;
    }

    @Override
    public GenerationStage.Decoration step()
    {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }

    public static class Start extends StructureStart<NoFeatureConfig>
    {
        Structure<NoFeatureConfig> structure;
        long seed;
        public Start(Structure<NoFeatureConfig> structure, int x, int z, MutableBoundingBox box, int i3, long seed)
        {
            super(structure, x, z, box, i3, seed);
            this.structure=structure;
        this.seed=seed;
        }

        @Override
        public void generatePieces(DynamicRegistries registries, ChunkGenerator generator, TemplateManager manager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig config)
        {
            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;

            BlockPos blockpos = new BlockPos(x, 0, z);

            JigsawManager.addPieces(
                    registries,
                    new VillageConfig(() -> registries.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY)
                            .get(structure.getRegistryName()), 10),
                    AbstractVillagePiece::new,
                    generator,
                    manager,
                    blockpos,
                    this.pieces,
                    this.random,
                    false,
                    true);
            this.calculateBoundingBox();
        }


    }
}
