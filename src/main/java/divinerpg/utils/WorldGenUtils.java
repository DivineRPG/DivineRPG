package divinerpg.utils;

import net.minecraft.util.Rotation;
import net.minecraft.world.World;

import java.util.Random;

public class WorldGenUtils {

    /*
        Arbitrary random number offsets for each structure to ensure that MapGenStructure#canSpawnStructureAtCoords
        results are independent from each other, which is necessary as MapGenStructure reseeds the random number generator
        right before calling that method. Somewhat hacky
     */
    public static final long ARCHER_DUNGEON_OFFSET = 103853273;
    public static final long ROLLUM_DUNGEON_OFFSET = 167146303;

    /**
     * Given a world and chunk positions, seeds a random number generator with a seed unique to that chunk in the world.
     * Guarantees that the resulting random number generator will always generate the same result in the same place in two worlds with the same seed.
     * Taken from the vanilla Minecraft chunk generator.
     *
     * @param random the random to seed
     * @param world the world
     * @param chunkX the x-position of the chunk
     * @param chunkZ the z-position of the chunk
     */
    public static void seedRandomWithWorldAndChunks(Random random, World world, int chunkX, int chunkZ) {
        long seed = world.getSeed();
        random.setSeed(seed);
        long k = random.nextLong() / 2L * 2L + 1L;
        long l = random.nextLong() / 2L * 2L + 1L;
        random.setSeed(chunkX * k + chunkZ * l ^ seed);
    }

    /**
     * Similar to the above, but with an arbitrary offset. See description at the top where the offsets are declared
     *
     * @param random the random to seed
     * @param offset the offset to seed with
     * @param world the world
     * @param chunkX the x-position of the chunk
     * @param chunkZ the z-position of the chunk
     */
    public static void seedRandomWithOffset(Random random, long offset, World world, int chunkX, int chunkZ) {
        long seed = world.getSeed();
        random.setSeed(seed);
        long k = random.nextLong() / 2L * 2L + 1L;
        long l = random.nextLong() / 2L * 2L + 1L;
        random.setSeed(chunkX * k ^ offset + chunkZ * l ^ seed);
    }


    /**
     * Gets a random rotation, preferably seeded with the above method.
     * Kept separate from the seeding method for flexibility and debugging purposes
     *
     * @param random the preferably seeded random
     * @return a rotation determined by the seed
     */
    public static Rotation getRandomRotation(Random random) {
        Rotation[] rotations = Rotation.values();
        return rotations[random.nextInt(rotations.length)];
    }
}
