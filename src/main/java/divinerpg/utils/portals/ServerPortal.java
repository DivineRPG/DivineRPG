package divinerpg.utils.portals;

import divinerpg.events.TeleporterEvents;
import divinerpg.utils.portals.description.IPortalDescription;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerPortal implements ITeleporter {
    /**
     * Searching XZ portal radius
     */
    protected final int radius;
    private final Map<DimensionType, Map<BlockPos, BlockPattern.PatternHelper>> activePortals;
    private final Map<DimensionType, Map<BlockPos, BlockPattern.PatternHelper>> activeOverworldPortals;
    /**
     * delay between portal recheck
     */
    protected int recheckDelay;

    private long nextTickTime;

    public ServerPortal(int radius, int recheckDelay) {
        this.radius = radius;
        this.recheckDelay = recheckDelay;

        activePortals = new HashMap<>();
        activeOverworldPortals = new HashMap<>();
    }

    /**
     * Can call every tick.
     */
    public void recheckPortals(MinecraftServer server) {
        if (nextTickTime > 0) {
            nextTickTime--;
        }

        if (server == null || activePortals.isEmpty())
            return;

        nextTickTime = recheckDelay;

        activePortals.forEach((dimensionType, portalsMap) -> {
            if (portalsMap == null || portalsMap.isEmpty())
                return;

            WorldServer world = server.getWorld(dimensionType.getId());
            IPortalDescription description = TeleporterEvents.descriptionsByDimension.get(dimensionType);

            if (world == null || description == null)
                return;

            new ArrayList<>(portalsMap.keySet())
                    .forEach(x -> {
                        BlockPattern.PatternHelper working = description.matchWorkingPortal(world, x);
                        if (working == null) {
                            portalsMap.remove(x);
                        } else {
                            portalsMap.put(x, working);
                        }
                    });
        });
    }

    @Override
    public void placeEntity(World world, Entity entity, float yaw) {
        BlockPos entityPosition = entity.getPosition();

        DimensionType current = entity.getEntityWorld().provider.getDimensionType();
        DimensionType destination = world.provider.getDimensionType();

        // non vanilla mod dimension
        DimensionType modDimension = destination;
        Map<BlockPos, BlockPattern.PatternHelper> cache = activePortals.computeIfAbsent(modDimension, x -> new HashMap<>());

        IPortalDescription description = TeleporterEvents.descriptionsByDimension.get(destination);

        // returning home
        if (description == null) {
            description = TeleporterEvents.descriptionsByDimension.get(current);
            modDimension = current;
            cache = activeOverworldPortals.computeIfAbsent(modDimension, x -> new HashMap<>());
        }

        if (description == null)
            return;

        // search in cache
        BlockPattern.PatternHelper portalMatch = findFromCache(cache, entityPosition);

        if (portalMatch == null) {
            portalMatch = scanWorld(world, description, entityPosition.add(-radius, -radius, -radius), entityPosition.add(radius, radius, radius));

            if (portalMatch == null) {
                entityPosition = findSuitablePosition(world, description, entity, entityPosition.add(-radius, -radius, -radius), entityPosition.add(radius, 256 - entityPosition.getY(), radius));
                portalMatch = description.createPortal(world, entityPosition);
            }

            if (portalMatch == null)
                return;

            cache.put(entityPosition, portalMatch);
        }

        BlockPos position = description.getPlayerPortalPosition(world, portalMatch);
        entity.setLocationAndAngles(position.getX(), position.getY(), position.getZ(), entity.rotationYaw, entity.rotationPitch);

        if (entity instanceof EntityPlayerMP) {
            ((EntityPlayerMP) entity).connection.setPlayerLocation(position.getX(), position.getY(), position.getZ(), entity.rotationYaw, entity.rotationPitch);
        }
    }

    /**
     * Find nearest cached portal position
     *
     * @param pos - player pos
     * @return
     */
    @Nullable
    protected BlockPattern.PatternHelper findFromCache(Map<BlockPos, BlockPattern.PatternHelper> activePortals, BlockPos pos) {
        int radius = 128;
        AxisAlignedBB searchRadius = new AxisAlignedBB(pos.add(-radius, -radius, -radius), pos.add(radius, radius, radius));

        for (Map.Entry<BlockPos, BlockPattern.PatternHelper> entry : activePortals.entrySet()) {
            if (searchRadius.contains(new Vec3d(entry.getKey()))) {
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * Scan world for working portals.
     *
     * @param min - min searching blockpos
     * @param max - max searching blockpos
     * @return
     */
    @Nullable
    protected BlockPattern.PatternHelper scanWorld(World world, IPortalDescription description, BlockPos min, BlockPos max) {
        AxisAlignedBB range = new AxisAlignedBB(min, max);
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(min);
        BlockPos portalSize = description.getMaxSize();

        while (range.intersects(new Vec3d(pos), new Vec3d(max))) {
            for (BlockPos blockPos : description.checkChunk(world, pos, pos.add(portalSize))) {
                BlockPattern.PatternHelper match = description.matchFrame(world, blockPos);

                if (match != null)
                    return match;
            }

            pos.setPos(pos.getX() + 1 + portalSize.getX(), pos.getY() + 1 + portalSize.getY(), pos.getZ() + 1 + portalSize.getZ());
        }


        return null;
    }

    /**
     * Searches for nearest suitable portal spawn position
     *
     * @param min - min radius search
     * @param max - max radius search
     * @return
     */
    protected BlockPos findSuitablePosition(World destination, IPortalDescription description, Entity e, BlockPos min, BlockPos max) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        BlockPos size = description.getMaxSize().add(2, 2, 2);

        if (min.getY() < 5 + size.getY()) {
            min = min.add(0, 5 + size.getY() - min.getY(), 0);
        }

        if (max.getY() > destination.getHeight() - 5 - size.getY()) {
            max = max.add(0, max.getY() - destination.getHeight() - 5 - size.getY(), 0);
        }

        for (int x = min.getX(); x <= max.getX(); x++) {
            for (int z = min.getX(); z <= max.getX(); z++) {
                for (int y = max.getY(); y > min.getY(); y--) {
                    pos.setPos(x, y, z);

                    BlockPos topSurfacePos = findTopSurfacePos(destination, pos, pos.add(size), min.getY());
                    if (topSurfacePos != null)
                        return topSurfacePos;
                }
            }
        }

        BlockPos.getAllInBoxMutable(pos, pos.add(size)).forEach(destination::setBlockToAir);

        return e.getPosition();
    }

    /**
     * Find nearest surface position
     *
     * @param start
     * @param end
     * @return
     */
    @Nullable
    private BlockPos findTopSurfacePos(World destination, BlockPos start, BlockPos end, int minY) {
        AxisAlignedBB size = new AxisAlignedBB(start, end);

        if (size.minY < minY) {
            size = size.offset(0, minY - size.minY, 0);
        }

        if (size.maxY > destination.getHeight()) {
            size = size.offset(0, destination.getHeight() - size.maxY, 0);
        }

        if (isAirBlocks(destination, size) && size.minY > minY) {
            AxisAlignedBB temp = size.offset(0, -1, 0);

            while (isAirBlocks(destination, temp) && temp.minY > minY) {
                size = temp;
                temp = temp.offset(0, -1, 0);
            }

            return new BlockPos(size.minX, size.minY, size.minZ);
        }


        return null;
    }

    private boolean isAirBlocks(World world, AxisAlignedBB size) {
        AtomicBoolean result = new AtomicBoolean(true);

        BlockPos.getAllInBoxMutable(
                (int) size.minX,
                (int) size.minY,
                (int) size.minZ,
                (int) size.maxX,
                (int) size.maxY,
                (int) size.maxZ).forEach(x -> {
            if (result.get() && !world.isAirBlock(x)) {
                result.set(false);
            }
        });

        return result.get();
    }
}


