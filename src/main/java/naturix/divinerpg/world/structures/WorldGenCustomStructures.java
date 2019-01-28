package naturix.divinerpg.world.structures;

import naturix.divinerpg.registry.ModDimensions;
import naturix.divinerpg.utils.DRPGStructureHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
    public static final DRPGStructureHandler ICEIKA_DUNGEON_ROLLUM = new DRPGStructureHandler("iceika_dungeon_rollum");

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimensionType() == ModDimensions.iceikaDimension) {
            generateStructure(ICEIKA_DUNGEON, world, random, chunkX, chunkZ, 50);
            generateStructure(ICEIKA_DUNGEON_ROLLUM, world, random, chunkX, chunkZ, 50);
        }
    }

    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance) {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        int y = random.nextInt(43) + 13; //Structures can spawn anywhere between y=13 and y=56
        BlockPos pos = new BlockPos(x, y, z);
        if (random.nextInt(chance) == 0) {
            generator.generate(world, random, pos);
        }
    }
    //TODO Make structures spawn loot chests -LiteWolf101
}