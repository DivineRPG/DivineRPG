package divinerpg.dimensions.vethea;

import divinerpg.registry.BlockRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.MapGenStructure;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Representing single level in Vethea
 */
public class VetheaLevelGenerators {

    /**
     * List of structures
     */
    private List<MapGenStructure> structures = new ArrayList<>();
    private List<WorldGenerator> generators = new ArrayList<>();

    /**
     * Height of Vethea Level
     */
    private int startHeight;
    private int roofHeight;

    public VetheaLevelGenerators(int startHeight, int roofHeight) {
        this.startHeight = startHeight;
        this.roofHeight = roofHeight;
    }

    public void addWorldGen(WorldGenerator generator) {
        addWorldGen(generator, false);
    }

    /**
     * Adding worlgen to list.
     *
     * @param generator - world generator
     * @param forced    - should execute at the first time
     */
    public void addWorldGen(WorldGenerator generator, boolean forced) {
        if (forced) {
            generators.add(0, generator);
        } else {
            generators.add(generator);
        }
    }


    /**
     * Add structure spawn
     *
     * @param structure - structure to spawn
     */
    public void addStructure(MapGenStructure structure) {
        structures.add(structure);
    }

    @Nullable
    public MapGenStructure findStructure(String name) {
        return structures.stream().filter(x -> x.getStructureName().equals(name)).findFirst().orElse(null);
    }

    public void generateChunk(World world, ChunkPrimer chunkPrimer, int x, int z) {
        generateFloors(chunkPrimer);
        //System.out.println("Floor generated");
        structures.forEach(gen -> gen.generate(world, x, z, chunkPrimer));
    }

    public void populate(World world, Random random, int chunkX, int chunkZ) {
        ChunkPos chunkPos = new ChunkPos(chunkX, chunkZ);

        // adding offset to prevent neighbour block updates
        // causing cascading chunk load
        BlockPos block = chunkPos.getBlock(1, startHeight + roofHeight, 1);

        // structures has the most priority
        if (!structures.stream()
                .map(x -> x.generateStructure(world, random, chunkPos))
                .filter(x -> x).findFirst().orElse(false)) {
            generators.forEach(x -> x.generate(world, random, block));
        }
    }

    private void generateFloors(ChunkPrimer chunkPrimer) {
        int earthLevel = startHeight + roofHeight;
        int dirtLevel = earthLevel - 1;
        int maxStoneLevel = dirtLevel - 1;

        int maxWidth = 15;

        // stone levels
        BlockPos.getAllInBoxMutable(0, startHeight, 0, maxWidth, maxStoneLevel, maxWidth)
                .forEach(x -> chunkPrimer.setBlockState(x.getX(), x.getY(), x.getZ(), BlockRegistry.dreamStone.getDefaultState()));

        // dirt level (1)
        BlockPos.getAllInBoxMutable(0, dirtLevel, 0, maxWidth, dirtLevel, maxWidth)
                .forEach(x -> chunkPrimer.setBlockState(x.getX(), x.getY(), x.getZ(), BlockRegistry.dreamDirt.getDefaultState()));


        // earth level (1)
        BlockPos.getAllInBoxMutable(0, earthLevel, 0, maxWidth, earthLevel, maxWidth)
                .forEach(x -> chunkPrimer.setBlockState(x.getX(), x.getY(), x.getZ(), BlockRegistry.dreamGrass.getDefaultState()));
    }
}
