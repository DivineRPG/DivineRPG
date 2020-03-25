package divinerpg.dimensions.vethea_new;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class TempleWorldGenerator extends WorldGenerator {
    private final ResourceLocation location;
    private final BlockPos possibleSize;

    /**
     * world generator populating template. For sure will generate template on current position
     *
     * @param location - template location
     */
    public TempleWorldGenerator(ResourceLocation location) {
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
    public TempleWorldGenerator(ResourceLocation location, boolean checkCanPlace) {
        this(location, checkCanPlace ? BlockPos.ORIGIN : null);
    }

    /**
     * world generator populating template
     *
     * @param location     - template location
     * @param possibleSize - possible random offset from initial size. If not null,
     *                     generator will check if structure can spawn in current postiion.
     *                     If not algorithm will try to offset spawn position 5 times
     */
    public TempleWorldGenerator(ResourceLocation location, BlockPos possibleSize) {
        this.location = location;
        this.possibleSize = possibleSize;
    }

    private Template getTemplate(World world) {
        TemplateManager manager = world.getSaveHandler().getStructureTemplateManager();
        Template template = manager.getTemplate(null, location);
        return template;
    }

    @Override
    public boolean generate(World world, Random random, BlockPos blockPos) {
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
                BlockPos pos = innerCopy.add(random.nextInt(x), random.nextInt(y), random.nextInt(z));

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

        getTemplate(world).addBlocksToWorldChunk(world, blockPos, new PlacementSettings());
        return true;
    }

    public boolean canPlace(World world, BlockPos pos) {
        Template template = getTemplate(world);
        BlockPos size = template.getSize();
        AtomicBoolean canPlace = new AtomicBoolean(true);

        BlockPos.getAllInBox(pos.add(0, 1, 0), pos.add(size)).forEach(x -> {
            if (canPlace.get() && !world.isAirBlock(x) && !world.getBlockState(x).getBlock().isReplaceable(world, x)) {
                canPlace.set(false);
            }
        });

        return canPlace.get();
    }
}
