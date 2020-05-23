package divinerpg.utils.portals.description;

import com.google.common.collect.Sets;
import divinerpg.registry.DimensionRegistry;
import divinerpg.utils.PositionHelper;
import divinerpg.utils.portals.ServerPortal;
import divinerpg.utils.portals.WorkingPortalInfo;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

public class ArcanaTeleporter extends ServerPortal {
    public ArcanaTeleporter(int recheckDelay) {
        super(256, recheckDelay);
    }

    @Nullable
    @Override
    protected BlockPattern.PatternHelper findFromCache(World world, IPortalDescription description, List<WorkingPortalInfo> activePortals, BlockPos pos, int radius) {
        return super.findFromCache(world, description, activePortals, pos, 512);
    }

    @Nullable
    @Override
    protected BlockPattern.PatternHelper scanWorld(World world, IPortalDescription description, BlockPos min, BlockPos max) {
        Set<Block> set = Sets.newHashSet(description.getFrame(), description.getPortal());
        BlockPos portalSize = description.getMaxSize();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int x = min.getX(), xEnd = max.getX(); x < xEnd; x += portalSize.getX()) {
            for (int z = min.getZ(), zEnd = max.getZ(); z < zEnd; z += portalSize.getZ()) {
                for (int y = min.getY(), yEnd = max.getY(); y < yEnd; y += portalSize.getY()) {
                    pos.setPos(x, y, z);

                    if (set.contains(world.getBlockState(pos).getBlock())) {

                        BlockPattern.PatternHelper portal = description.matchWorkingPortal(world, pos);
                        if (portal != null)
                            return portal;
                    }
                }
            }
        }


        return null;
    }

    @Override
    protected BlockPos findSuitablePosition(World destination, IPortalDescription description, Entity e, int radius) {
        if (destination.provider.getDimensionType() == DimensionRegistry.arcanaDimension) {
            ChunkPos chunkPos = new ChunkPos(e.getPosition());

            // store here entity position
            BlockPos.MutableBlockPos result = new BlockPos.MutableBlockPos(chunkPos.getBlock(7, 8, 7));

            // use BlockPos as ChunkPos. I know it's awfull
            PositionHelper.searchInRadius(destination, new BlockPos(chunkPos.x, 8, chunkPos.z), radius / 16, x -> {
                BlockPos block = new ChunkPos(x.getX(), x.getZ()).getBlock(7, 8, 7);

                while (block.getY() < 40) {
                    if (!destination.isAirBlock(block) && !destination.isAirBlock(block.add(0, 0, 1))) {
                        result.setPos(block);
                        return true;
                    }

                    block = block.up(8);
                }

                return false;
            });

            return result;
        }


        return super.findSuitablePosition(destination, description, e, radius);
    }
}
