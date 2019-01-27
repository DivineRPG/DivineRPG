package naturix.divinerpg.world.structures;

import naturix.divinerpg.dimensions.iceika.WorldProviderIceika;
import naturix.divinerpg.registry.ModDimensions;
import naturix.divinerpg.utils.DRPGStructureHandler;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by LiteWolf101 on Jan
 * /27/2019
 */
public class WorldGenCustomStructures implements IWorldGenerator {
    public static final DRPGStructureHandler ICEIKA_DUNGEON = new DRPGStructureHandler("iceika_dungeon");

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimensionType() == ModDimensions.iceikaDimension) {
            generateStructure(ICEIKA_DUNGEON, world, random, chunkX, chunkZ, 50);
        }
    }

    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance) {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        int y = random.nextInt(53) + 13;
        BlockPos pos = new BlockPos(x, y, z);
        if (random.nextInt(chance) == 0) {
            generator.generate(world, random, pos);
        }
    }
}