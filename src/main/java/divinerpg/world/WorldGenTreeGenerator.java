package divinerpg.world;

import java.util.Random;

import divinerpg.Config;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenTreeGenerator implements IWorldGenerator {
    //private int min=-1,max=-1,numTrees=-1,

    private void makeTree(WorldGenAbstractTree tree, int chunkX, int chunkZ, Random random, World world, int min,
            int max) {

        int num = min + random.nextInt(max - min);
        for (int i = 0; i < num; i++) {
            int randX = chunkX * 16 + 8 + random.nextInt(16);
            int randZ = chunkZ * 16 + 8 + random.nextInt(16);
            tree.generate(world, random, world.getHeight(new BlockPos(randX, 0, randZ)));
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
            IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) {

            WorldGenAbstractTree divineTree = new DivineTree(false);

            // get the biome
            Biome biome = world.getBiome(new BlockPos(chunkX * 16, 64, chunkZ * 16));
            if (Config.generateTrees && BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST)
                    && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.CONIFEROUS)
                    && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE)
                    && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP)
                    && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.DENSE) && Biome.getIdForBiome(biome) != 27
                    && Biome.getIdForBiome(biome) != 28) {
                if (random.nextInt(12) == 0) {
                    makeTree(divineTree, chunkX, chunkZ, random, world, 1, 2);
                }

            }
        }
    }
}