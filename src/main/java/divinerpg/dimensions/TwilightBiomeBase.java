package divinerpg.dimensions;

import divinerpg.DivineRPG;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class TwilightBiomeBase extends Biome {

    // using it to prevent creating new instances
    private final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
    protected WorldGenerator genTree;
    protected WorldGenerator genLargeTree;
    protected WorldGenerator genConeUp;
    protected WorldGenerator genLakes;
    protected WorldGenerator brush;
    protected WorldGenerator bloom;
    protected WorldGenerator blossom;
    /**
     * Contains reference on current chunk
     */
    protected Chunk chunk;

    public TwilightBiomeBase(BiomeProperties properties, String name) {
        super(properties);
        setRegistryName(DivineRPG.MODID, name);
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {

        this.chunk = worldIn.getChunkFromBlockCoords(pos);

        generate(worldIn, rand, chunk.x, chunk.z, 4, 13, 80 + 13,
                bloom, genLargeTree);

        generate(worldIn, rand, chunk.x, chunk.z, 10, 13, 80 + 13,
                brush, blossom);

        generate(worldIn, rand, chunk.x, chunk.z, 100, 13, 80 + 13,
                brush);

        generate(worldIn, rand, chunk.x, chunk.z, 10, 55, 55 + 20,
                genTree);

        generate(worldIn, rand, chunk.x, chunk.z, 1, 55, 55 + 20,
                genLakes, genConeUp);
    }

    protected void generate(World world, Random random, int chunkX, int chunkZ, int tries, int minY, int maxY,
                            WorldGenerator... generators) {
        random = world.setRandomSeed(chunkX, chunkZ, 10387313);

        if (generators != null && generators.length > 0) {
            int height = getHeightOrThrow(minY, maxY);

            for (int i = 0; i < tries; i++) {
                for (WorldGenerator generator : generators) {
                    if (generator != null) {
                        // preventing from creating new instance
                        pos.setPos(
                                chunkX * 16 + random.nextInt(16) + 8,
                                minY + random.nextInt(height + 1),
                                chunkZ * 16 + random.nextInt(16) + 8);

                        generator.generate(world, random, pos);
                    }
                }
            }
        }
    }

    /**
     * Gets height difference and throw in case of errors
     */
    private int getHeightOrThrow(int minY, int maxY) {
        int height = maxY - minY;
        if (height <= 0) {
            throw new IllegalArgumentException("Max Y equals or less min Y");
        }
        if (minY < 0 || maxY > 256)
            throw new IllegalArgumentException("Ore Generated Out of Bounds");

        return height;
    }
}
