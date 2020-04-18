package divinerpg.utils.portals.description;

import com.google.common.collect.Sets;
import divinerpg.registry.ModDimensions;
import divinerpg.utils.portals.ServerPortal;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Set;

public class ArcanaTeleporter extends ServerPortal {
    public ArcanaTeleporter(int recheckDelay) {
        super(256, recheckDelay);
    }

    @Nullable
    @Override
    protected BlockPattern.PatternHelper findFromCache(Map<BlockPos, BlockPattern.PatternHelper> activePortals, BlockPos pos, int radius) {
        return super.findFromCache(activePortals, pos, 512);
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
    protected BlockPos findSuitablePosition(World destination, IPortalDescription description, Entity e, BlockPos min, BlockPos max) {
        if (destination.provider.getDimensionType() == ModDimensions.arcanaDimension) {
            ChunkPos chunkPos = new ChunkPos(e.getPosition());

            for (int x = 0; x < 2; x++) {
                for (int z = 0; z < 2; z++) {
                    chunkPos = new ChunkPos(chunkPos.x + x, chunkPos.z + z);

                    BlockPos pos = chunkPos.getBlock(7, 8, 7);

                    while (pos.getY() <= 40) {
                        // avoiding double high rooms
                        if (!destination.isAirBlock(pos) && !destination.isAirBlock(pos.add(0, 0, 1))) {
                            return chunkPos.getBlock(0, pos.getY(), 0);
                        }
                    }
                }
            }


            return new ChunkPos(e.getPosition()).getBlock(0, 8, 0);
        }

        return super.findSuitablePosition(destination, description, e, min, max);
    }
}
