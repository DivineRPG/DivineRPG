package divinerpg.world.vethea;

import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.*;

import java.util.*;
import java.util.concurrent.atomic.*;

public class TemplatePlacer extends Feature {
    private final ResourceLocation location;
    private final BlockPos possibleSize;

    /**
     * world generator populating template. For sure will generate template on current position
     *
     * @param location - template location
     */
    public TemplatePlacer(ResourceLocation location) {
        this(location, null);
    }

    /**
     * world generator populating template.
     *
     * @param location      - template location
     * @param checkCanPlace - check size on positioning?
     *                      If true was passed, generator will check wherever template can spawn there
     *                      Otherwise
     */
    public TemplatePlacer(ResourceLocation location, boolean checkCanPlace) {
        this(location, checkCanPlace ? BlockPos.ZERO : null);
    }

    /**
     * world generator populating template
     *
     * @param location     - template location
     * @param possibleSize - possible random offset from initial size. If not null,
     *                     generator will check if structure can spawn in current postiion.
     *                     If not algorithm will try to offset spawn position 5 times
     */
    public TemplatePlacer(ResourceLocation location, BlockPos possibleSize) {
        super(BlockStateFeatureConfig.CODEC);
        this.location = location;
        this.possibleSize = possibleSize;
    }

    private Template getTemplate(World world) {
        TemplateManager manager = world.getServer().getStructureManager();
        Template template = manager.get(location);
        return template;
    }



    public boolean canPlace(IServerWorld world, BlockPos pos) {
        Template template = getTemplate(world.getLevel());
        BlockPos size = template.getSize();
        AtomicBoolean canPlace = new AtomicBoolean(true);

        BlockPos.betweenClosed(pos.offset(0, 1, 0), pos.offset(size)).forEach(x -> {
            if (canPlace.get() && !world.getBlockState(x).isAir() && !world.getBlockState(x).getBlock().canBeReplacedByLeaves(world.getBlockState(x), world, x)) {
                canPlace.set(false);
            }
        });

        return canPlace.get();
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, IFeatureConfig config) {
        if (possibleSize != null && !canPlace(world, blockPos)) {

            // creating cope here
            final BlockPos innerCopy = new BlockPos(blockPos);
            // clear position, cant spawn structure
            blockPos = null;

            int x = Math.max(1, possibleSize.getX());
            int y = Math.max(1, possibleSize.getY());
            int z = Math.max(1, possibleSize.getZ());

            for (int i = 0; i < 5; i++) {
                // find random position
                BlockPos pos = innerCopy.offset(random.nextInt(x), random.nextInt(y), random.nextInt(z));

                // if can place, set correct pos reference
                if (canPlace(world, pos)) {
                    blockPos = pos;
                    break;
                }
            }
        }

        // cant spawn structure
        if (blockPos == null) {
            return false;
        }

        getTemplate(world.getLevel()).placeInWorld(world, blockPos, new PlacementSettings(), random);
        return true;
    }
}
