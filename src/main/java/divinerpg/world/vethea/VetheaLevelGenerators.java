package divinerpg.world.vethea;

import divinerpg.registries.*;
import net.minecraft.util.math.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;

import java.util.*;

public class VetheaLevelGenerators {

    private List<Feature> generators = new ArrayList<>();

    /**
     * Height of Vethea Level
     */
    private int startHeight;
    private int roofHeight;

    public VetheaLevelGenerators(int startHeight, int roofHeight) {
        this.startHeight = startHeight;
        this.roofHeight = roofHeight;
    }

    public void addWorldGen(Feature generator) {
        addWorldGen(generator, false);
    }

    /**
     * Adding worlgen to list.
     *
     * @param generator - world generator
     * @param forced    - should execute at the first time
     */
    public void addWorldGen(Feature generator, boolean forced) {
        if (forced) {
            generators.add(0, generator);
        } else {
            generators.add(generator);
        }
    }

        public void populate(WorldGenRegion world, Random random, int chunkX, int chunkZ) {
        generateFloors(world.getChunk(chunkX, chunkZ));
    }

    private void generateFloors(IChunk region) {
        int earthLevel = startHeight + roofHeight;
        int dirtLevel = earthLevel - 1;
        int maxStoneLevel = dirtLevel - 1;

        int maxWidth = 15;

        // stone levels
        BlockPos.betweenClosed(0, startHeight, 0, maxWidth, maxStoneLevel, maxWidth)
                .forEach(pos -> {
                        if(region.getBlockState(pos).isAir()) {
                            region.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()).mutable(), BlockRegistry.dreamStone.defaultBlockState(), false);
                        }
                        });

        // dirt level (1)
        BlockPos.betweenClosed(0, dirtLevel, 0, maxWidth, dirtLevel, maxWidth)
                .forEach(pos -> {
                    if(region.getBlockState(pos).isAir()) {
                        region.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()).mutable(), BlockRegistry.dreamDirt.defaultBlockState(), false);
                    }
                });


        // earth level (1)
        BlockPos.betweenClosed(0, earthLevel, 0, maxWidth, earthLevel, maxWidth)
                .forEach(pos -> {
                    if(region.getBlockState(pos).isAir()) {
                        region.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()).mutable(), BlockRegistry.dreamGrass.defaultBlockState(), false);
                    }
                });

    }
}
