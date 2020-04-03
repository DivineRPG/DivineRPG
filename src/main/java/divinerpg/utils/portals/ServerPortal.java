package divinerpg.utils.portals;

import divinerpg.utils.portals.description.IPortalDescription;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServerPortal {
    private final WorldServer world;
    private final IPortalDescription description;
    /**
     * Searching XZ portal radius
     */
    protected int radius = 32;
    /**
     * delay between portal recheck
     */
    protected int recheckDelay = 20 * 60;
    private Map<BlockPos, BlockPattern.PatternHelper> activePortals;
    private long nextTickTime;


    public ServerPortal(WorldServer world,
                        IPortalDescription description) {
        this.world = world;
        this.description = description;

        activePortals = new HashMap<>();
    }

    /**
     * Can call every tick.
     */
    public void recheckPortals() {
        if (world.getTotalWorldTime() > nextTickTime) {
            nextTickTime = world.getTotalWorldTime() + recheckDelay;

            ArrayList<BlockPos> poses = new ArrayList<>(activePortals.keySet());

            poses.forEach(x -> {
                BlockPattern.PatternHelper portal = description.matchWorkingPortal(world, x);
                if (portal == null)
                    activePortals.remove(x);
                else
                    activePortals.put(x, portal);
            });
        }
    }

    /**
     * Find nearest cached portal position or scan the world
     *
     * @param pos - player pos
     * @return
     */
    @Nullable
    public BlockPattern.PatternHelper findNearest(BlockPos pos) {
        for (Map.Entry<BlockPos, BlockPattern.PatternHelper> entry : activePortals.entrySet()) {
            if (isRadius(entry.getKey(), pos, radius)) {
                return entry.getValue();
            }
        }

        return scanWorld(pos, radius / 2);
    }

    /**
     * Scan world for working portals.
     *
     * @param center - player position
     * @param radius - searching radius
     * @return
     */
    private BlockPattern.PatternHelper scanWorld(BlockPos center, int radius) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int x = center.getX() - radius, xEnd = x + radius * 2; x < xEnd; x++) {
            for (int y = world.getHeight(); y >= 0; y--) {
                for (int z = center.getZ() - radius, zEnd = z + radius * 2; z < zEnd; z++) {
                    pos.setPos(x, y, z);

                    if (world.getBlockState(pos).getBlock().equals(description.getFrame())) {
                        BlockPattern.PatternHelper workingPortal = description.matchWorkingPortal(world, pos);
                        if (workingPortal != null)
                            return workingPortal;
                    }
                }
            }
        }

        return null;
    }

    /**
     * Ignoring Y cord
     *
     * @param central - portal position
     * @param player  - player position
     * @param radius  - radius of search
     * @return
     */
    private boolean isRadius(BlockPos central, BlockPos player, int radius) {
        int minX = central.getX() - radius;
        int maxX = central.getX() + radius;

        int minZ = central.getZ() - radius;
        int maxZ = central.getZ() + radius;

        return (minX <= player.getX() && player.getX() <= maxX
                &&
                minZ <= player.getZ() && player.getZ() <= maxZ);
    }

}
