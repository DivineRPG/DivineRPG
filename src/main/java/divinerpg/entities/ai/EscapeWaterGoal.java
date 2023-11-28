package divinerpg.entities.ai;


import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.*;
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
        // Check if the entity is in water
        if (entity.isInWater()) {
            // Get the position of the nearest land above the water
            BlockPos.MutableBlockPos pos = entity.level.getHeightmapPos(Heightmap.Types.WORLD_SURFACE_WG, entity.blockPosition()).mutable();
            targetPos = new Vec3(pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
        return false;
    }

    @Override
    public void start() {
        // Move the entity towards the nearest land above the water
        if (targetPos != null) {
            ((Mob) entity).getNavigation().moveTo(targetPos.x, targetPos.y, targetPos.z, 1.0);
        }
    }

    @Override
    public boolean canContinueToUse() {
        // Keep using this goal until the entity is no longer in water
        return entity.isInWater();
    }

    @Override
    public void stop() {
        // Stop the entity's movement when it reaches land
        (((Mob) entity).getNavigation()).stop();
    }
}