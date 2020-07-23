package divinerpg.utils.portals;

import com.google.common.collect.Lists;
import divinerpg.DivineRPG;
import divinerpg.events.DimensionHelper;
import divinerpg.utils.PositionHelper;
import divinerpg.utils.Utils;
import divinerpg.utils.portals.description.IPortalDescription;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerPortal implements ITeleporter {
    /**
     * Searching XZ portal radius
     */
    protected final int radius;

    private final Map<DimensionType, List<WorkingPortalInfo>> activePortals;
    private final Map<DimensionType, List<WorkingPortalInfo>> activeOverworldPortals;
    /**
     * delay between portal recheck
     */
    protected int recheckDelay;

    public ServerPortal(int radius, int recheckDelay) {
        this.radius = radius;
        this.recheckDelay = recheckDelay;

        activePortals = new HashMap<>();
        activeOverworldPortals = new HashMap<>();
    }

    @Override
    public void placeEntity(World world, Entity entity, float yaw) {
        BlockPos entityPosition = entity.getPosition();

        DimensionType current = entity.getEntityWorld().provider.getDimensionType();
        DimensionType destination = world.provider.getDimensionType();

        // non vanilla mod dimension
        DimensionType modDimension = destination;
        List<WorkingPortalInfo> cache = activePortals.computeIfAbsent(modDimension, x -> Lists.newArrayList());

        IPortalDescription description = DimensionHelper.descriptionsByDimension.get(destination);

        // returning home
        if (description == null) {
            description = DimensionHelper.descriptionsByDimension.get(current);
            modDimension = current;
            cache = activeOverworldPortals.computeIfAbsent(modDimension, x -> Lists.newArrayList());
        }

        if (description == null)
            return;

        // search in cache
        BlockPattern.PatternHelper portalMatch = findFromCache(world, description, cache, entityPosition, radius * 2);

        if (portalMatch == null) {
            portalMatch = scanWorld(world, description, entityPosition.add(-radius, -radius, -radius), entityPosition.add(radius, radius, radius));

            if (portalMatch == null) {
                entityPosition = findSuitablePosition(world, description, entity, radius);
                portalMatch = description.createPortal(world, entityPosition);
            }

            if (portalMatch != null)
                cache.add(new WorkingPortalInfo(world, entityPosition, portalMatch));
        }

        if (portalMatch != null) {
            entityPosition = description.getPlayerPortalPosition(world, entity, portalMatch);
        } else {
            DivineRPG.logger.warn("Can't match portal on that cords: " + entityPosition.toString());
        }

        entity.setLocationAndAngles(entityPosition.getX(), entityPosition.getY(), entityPosition.getZ(), entity.rotationYaw, entity.rotationPitch);

        if (entity instanceof EntityPlayerMP) {
            ((EntityPlayerMP) entity).connection.setPlayerLocation(entityPosition.getX(), entityPosition.getY(), entityPosition.getZ(), entity.rotationYaw, entity.rotationPitch);
        }

        entity.timeUntilPortal = entity.getPortalCooldown();
    }

    /**
     * Find nearest cached portal position
     *
     * @param world         - world
     * @param description   - current portal info
     * @param activePortals - list of cached portals
     * @param pos           - entity pos
     * @param radius        - search radius, not diameter!
     * @return
     */
    @Nullable
    protected BlockPattern.PatternHelper findFromCache(World world,
                                                       IPortalDescription description,
                                                       List<WorkingPortalInfo> activePortals,
                                                       BlockPos pos,
                                                       int radius) {
        // remove all portals not working
        activePortals.removeIf(x -> !x.isWorking(world, description));

        WorkingPortalInfo info = activePortals.stream()
                .filter(x -> x.canUse(pos, radius * 2))
                .findFirst().orElse(null);

        return info == null
                ? null
                : info.getMatch();
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
     * @param destination - destination world
     * @param description - portal description
     * @param e           - entity to place
     * @param radius      - search radius
     * @return
     */
    protected BlockPos findSuitablePosition(World destination, IPortalDescription description, Entity e, int radius) {
        final BlockPos entityPosition = e.getPosition();

        BlockPos firstSolidBlock = PositionHelper.searchInRadius(destination, entityPosition, radius, blockPos -> {
            int y = Utils.getSurfaceBlockY(destination, blockPos.getX(), blockPos.getX());

            if (y < 0)
                return false;

            if (y != blockPos.getY()) {
                blockPos = new BlockPos(blockPos.getX(), y, blockPos.getZ());
            }

            return destination.getBlockState(blockPos).isSideSolid(destination, blockPos, EnumFacing.UP);
        });

        int possiblePosesCount = destination.rand.nextInt(60) + 10;
        ArrayList<BlockPos> possiblePlaces = new ArrayList<>();

        BlockPos size = description.getMaxSize().add(2, 2, 2);

        // search while find exactly places count
        PositionHelper.searchInRadius(destination, firstSolidBlock, radius, blockPos -> {
            int y = Utils.getSurfaceBlockY(destination, blockPos.getX(), blockPos.getX());

            if (y <= 0)
                return false;

            if (y != blockPos.getY()) {
                blockPos = new BlockPos(blockPos.getX(), y, blockPos.getZ());
            }

            if (destination.getBlockState(blockPos).isSideSolid(destination, blockPos, EnumFacing.UP)
                    // have free space
                    && isAirBlocks(destination, new AxisAlignedBB(blockPos, blockPos.add(size)))) {
                possiblePlaces.add(blockPos.toImmutable());
            }

            return possiblePlaces.size() < possiblePosesCount;
        });

        if (!possiblePlaces.isEmpty()) {
            return possiblePlaces.get(destination.rand.nextInt(possiblePlaces.size()));
        }

        BlockPos.getAllInBox(entityPosition.add(-3, 0, -3), entityPosition.add(3, 5, 3))
                .forEach(destination::setBlockToAir);
        return entityPosition;
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


