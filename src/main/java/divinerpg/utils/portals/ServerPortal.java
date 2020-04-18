package divinerpg.utils.portals;

import divinerpg.events.TeleporterEvents;
import divinerpg.utils.Utils;
import divinerpg.utils.portals.description.IPortalDescription;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

public class ServerPortal implements ITeleporter, ITickListener {
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
    public void tick(MinecraftServer server) {
        if (nextTickTime > 0) {
            nextTickTime--;
            return;
        }

        if (server == null)
            return;

        nextTickTime = recheckDelay;

        checkMap(activePortals, x -> server.getWorld(x.getId()));
        checkMap(activeOverworldPortals, x -> server.getWorld(DimensionType.OVERWORLD.getId()));
    }

    /**
     * Check single map for active portals
     *
     * @param map          - map with active portals
     * @param getWorldFunc - get world func where portals live
     */
    private void checkMap(Map<DimensionType, Map<BlockPos, BlockPattern.PatternHelper>> map,
                          Function<DimensionType, World> getWorldFunc) {
        if (map.isEmpty())
            return;

        map.forEach((dimensionType, blockPosPatternHelperMap) -> {
            if (blockPosPatternHelperMap == null || blockPosPatternHelperMap.isEmpty())
                return;


            World world = getWorldFunc.apply(dimensionType);
            IPortalDescription description = TeleporterEvents.descriptionsByDimension.get(dimensionType);

            if (world == null || description == null)
                return;

            new ArrayList<>(blockPosPatternHelperMap.keySet())
                    .forEach(x -> {
                        // do not need to check not loaded portals
                        if (!world.isBlockLoaded(x))
                            return;

                        BlockPattern.PatternHelper working = description.matchWorkingPortal(world, x);
                        if (working == null) {
                            blockPosPatternHelperMap.remove(x);
                        } else {
                            blockPosPatternHelperMap.put(x, working);
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
        BlockPattern.PatternHelper portalMatch = findFromCache(cache, entityPosition, radius * 2);

        if (portalMatch == null) {
            portalMatch = scanWorld(world, description, entityPosition.add(-radius, -radius, -radius), entityPosition.add(radius, radius, radius));

            if (portalMatch == null) {
                entityPosition = findSuitablePosition(world, description, entity,
                        entityPosition.add(-radius, -radius, -radius),
                        entityPosition.add(radius, 256 - entityPosition.getY(), radius));
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

        entity.timeUntilPortal = entity.getPortalCooldown();
    }

    /**
     * Find nearest cached portal position
     *
     * @param pos - player pos
     * @return
     */
    @Nullable
    protected BlockPattern.PatternHelper findFromCache(Map<BlockPos, BlockPattern.PatternHelper> activePortals, BlockPos pos, int radius) {
        BlockPos min = pos.add(-radius, -radius, -radius);
        AxisAlignedBB size = new AxisAlignedBB(min, pos.add(radius, radius, radius));

        for (Map.Entry<BlockPos, BlockPattern.PatternHelper> entry : activePortals.entrySet()) {
            BlockPos possiblePos = entry.getKey();

            if (size.minX <= possiblePos.getX() && possiblePos.getX() <= size.maxX
                    &&
                    size.minY <= possiblePos.getY() && possiblePos.getY() <= size.maxY
                    &&
                    size.minZ <= possiblePos.getZ() && possiblePos.getZ() <= size.maxZ
            ) {
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
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        BlockPos portalSize = description.getMaxSize();

        if (max.getY() > world.getHeight()) {
            max = new BlockPos(max.getX(), world.getHeight(), max.getZ());
        }

        if (min.getY() < 0) {
            min = new BlockPos(min.getX(), 0, min.getZ());
        }


        for (int x = min.getX(); x <= max.getX(); x += portalSize.getX()) {
            for (int z = min.getZ(); z <= max.getZ(); z += portalSize.getZ()) {
                for (int y = max.getY(); y >= min.getY(); y -= portalSize.getY()) {
                    pos.setPos(x, y, z);

                    if (world.isOutsideBuildHeight(pos))
                        continue;

                    for (BlockPos blockPos : description.checkChunk(world, pos, pos.add(portalSize))) {
                        BlockPattern.PatternHelper match = description.matchWorkingPortal(world, blockPos);

                        if (match != null)
                            return match;
                    }
                }

            }
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

        if (min.getY() < 1) {
            min = new BlockPos(min.getX(), 1, min.getZ());
        }

        int seaLevel = destination.getSeaLevel();

        if (max.getY() > seaLevel) {
            max = max.add(0, seaLevel - max.getY(), 0);
        }

        for (int x = min.getX(); x <= max.getX(); x++) {
            for (int z = min.getX(); z <= max.getX(); z++) {

                pos.setPos(x, Utils.getSurfaceBlockY(destination, x, z) + 1, z);

                if (pos.getY() == 0)
                    continue;

                if (isAirBlocks(destination, new AxisAlignedBB(pos, pos.add(size)))) {
                    return pos.toImmutable();
                }
            }
        }

        BlockPos.getAllInBoxMutable(pos, pos.add(size)).forEach(destination::setBlockToAir);

        return e.getPosition();
    }

    protected boolean isAirBlocks(World world, AxisAlignedBB size) {
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


