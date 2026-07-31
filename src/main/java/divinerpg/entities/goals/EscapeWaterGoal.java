package divinerpg.entities.goals;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;

public class EscapeWaterGoal extends Goal {
    private final LivingEntity entity;
    private Vec3 targetPos;

    public EscapeWaterGoal(LivingEntity entity) {
        this.entity = entity;
    }

    @Override
    public boolean canUse() {
        if (entity.isInWater()) {
            BlockPos.MutableBlockPos pos = entity.level().getHeightmapPos(Heightmap.Types.WORLD_SURFACE_WG, entity.blockPosition()).mutable();
            targetPos = new Vec3(pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
        return false;
    }

    @Override
    public void start() {
        if (targetPos != null) {
            ((Mob) entity).getNavigation().moveTo(targetPos.x, targetPos.y, targetPos.z, 1.0);
        }
    }

    @Override
    public boolean canContinueToUse() {
        return entity.isInWater();
    }

    @Override
    public void stop() {
        (((Mob) entity).getNavigation()).stop();
    }
}
