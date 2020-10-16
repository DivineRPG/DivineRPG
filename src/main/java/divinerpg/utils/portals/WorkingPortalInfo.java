package divinerpg.utils.portals;

import divinerpg.utils.portals.description.IPortalDescription;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class WorkingPortalInfo {
    private final BlockPos pos;
    // re-check cooldown - 20 sec
    private final int reCheck = 20 * 20;
    private BlockPattern.PatternHelper match;
    private long lastUpdTick;

    public WorkingPortalInfo(World world, BlockPos pos, BlockPattern.PatternHelper match) {
        this.pos = pos;
        this.match = match;
        lastUpdTick = world.getTotalWorldTime() + reCheck;
    }

    /**
     * Check wherever portal is working still
     *
     * @param world       - world
     * @param description - portal description
     * @return
     */
    public boolean isWorking(World world, IPortalDescription description) {

        if (match != null) {
            long time = world.getTotalWorldTime();
            if (time > lastUpdTick) {
                lastUpdTick = time + reCheck;
                match = description.matchWorkingPortal(world, pos);
            }
        }

        return match != null;
    }

    /**
     * Check if current pos is near radius
     *
     * @param pos      - player pos
     * @param distance - distanse to pos
     * @return
     */
    public boolean canUse(BlockPos pos, int distance) {
        return Math.sqrt(pos.distanceSq(pos)) <= distance;
    }

    /**
     * Gets portal match
     *
     * @return
     */
    @Nullable
    public BlockPattern.PatternHelper getMatch() {
        return match;
    }
}
