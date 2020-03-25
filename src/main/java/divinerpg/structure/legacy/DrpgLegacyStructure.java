package divinerpg.structure.legacy;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

import javax.annotation.Nullable;
import java.util.Random;

public class DrpgLegacyStructure extends MapGenStructure {
    private final String name;
    private final int chunkDistance;
    private final WorldGenerator largeGenerator;
    private int min;
    private int max;


    public DrpgLegacyStructure(String name, int chunkDistance, WorldGenerator largeGenerator) {
        this(name, chunkDistance, largeGenerator, 0, 256);
    }

    public DrpgLegacyStructure(String name, int chunkDistance, WorldGenerator largeGenerator, int height) {
        this(name, chunkDistance, largeGenerator, height, height + 1);
    }

    /**
     * Wraps large structure to non cascading world generation
     *
     * @param name           - name of structure
     * @param chunkDistance  - distanse in chunks beetween structures
     * @param largeGenerator - unoptimized world generation
     * @param min            - min height (inclusive)
     * @param max            - max height (exclusive)
     */
    public DrpgLegacyStructure(String name, int chunkDistance, WorldGenerator largeGenerator, int min, int max) {
        this.name = name;
        this.chunkDistance = chunkDistance;
        this.largeGenerator = largeGenerator;
        this.min = MathHelper.clamp(0, min, 256);
        this.max = MathHelper.clamp(0, max, 256);

        if (min >= max) {
            throw new RuntimeException(String.format("Min height (%s) can't be equal or more than max height (%s)", min, max));
        }
    }

    @Override
    public String getStructureName() {
        return name;
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World world, BlockPos blockPos, boolean findUnexplored) {
        this.world = world;

        // todo think about step by structure size
        return findNearestStructurePosBySpacing(world, this, blockPos, this.chunkDistance, 8, 10387312, false, 100, findUnexplored);
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        int i = chunkX;
        int j = chunkZ;
        if (chunkX < 0) {
            i = chunkX - chunkDistance - 1;
        }

        if (chunkZ < 0) {
            j = chunkZ - chunkDistance - 1;
        }

        int k = i / chunkDistance;
        int l = j / chunkDistance;

        int folderHash = name.hashCode();

        Random random = this.world.setRandomSeed(k, l, folderHash);
        k *= chunkDistance;
        l *= chunkDistance;

        int smallerParameter = (int) (chunkDistance * 0.75);

        k += (random.nextInt(smallerParameter) + random.nextInt(smallerParameter)) / 2;
        l += (random.nextInt(smallerParameter) + random.nextInt(smallerParameter)) / 2;
        return chunkX == k && chunkZ == l;
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        Random random = world.setRandomSeed(x, z, 10387313);
        int y = random.nextInt(max - min) + min;

        return new DivineLegacyStructureStart(largeGenerator, x, y, z);
    }
}
