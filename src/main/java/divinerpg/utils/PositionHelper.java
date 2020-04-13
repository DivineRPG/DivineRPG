package divinerpg.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

import javax.annotation.Nullable;

public class PositionHelper {
    public static RayTraceResult rayTrace(EntityPlayer player, double blockReachDistance, int partialTicks) {
        Vec3d vec3d = player.getPositionEyes(partialTicks);
        Vec3d vec3d1 = player.getLook(partialTicks);
        Vec3d vec3d2 = vec3d.addVector(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        return player.world.rayTraceBlocks(vec3d, vec3d2, false, false, true);
    }

    /**
     * Returns correct poses to perform ray trace
     *
     * @param player             - shooter
     * @param blockReachDistance - rich distance
     * @return
     */
    public static Tuple<Vec3d, Vec3d> getRayTraceVecs(Entity player, double blockReachDistance) {
        Vec3d startVec = new Vec3d(player.posX, player.posY + (double) player.getEyeHeight(), player.posZ);
        Vec3d endVec = startVec.add(player.getLook(0).scale(blockReachDistance));

        return new Tuple<>(startVec, endVec);
    }

    public static RayTraceResult rayTrace(EntityPlayer e, boolean stopOnLiquid) {
        Tuple<Vec3d, Vec3d> vecs = getRayTraceVecs(e, getBlockReachDistance(e));

        return e.world.rayTraceBlocks(vecs.getFirst(),
                vecs.getSecond(),
                stopOnLiquid,
                false,
                true);
    }

    public static double getBlockReachDistance(EntityPlayer player) {
        if (player.world.isRemote) {
            return net.minecraft.client.Minecraft.getMinecraft().playerController.getBlockReachDistance();
        }

        return player.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue();
    }

    public static void moveBullet(EntityPlayer player, EntityThrowable bullet) {
        if (player == null || bullet == null)
            return;

        Vec3d vector = player.getLookVec().scale(2).add(bullet.getPositionVector());
        bullet.setPosition(vector.x, vector.y, vector.z);
    }

    /**
     * Performs ray trace and return hitted entity
     *
     * @param player - shooter
     * @param range  - block range distance
     * @return
     */
    @Nullable
    public static Entity rayTrace(Entity player, float range) {
        // Some magic number
        double fix = 0.3;

        Tuple<Vec3d, Vec3d> vecs = getRayTraceVecs(player, range);

        Vec3d start = vecs.getFirst();
        Vec3d end = vecs.getSecond();

        AxisAlignedBB cube = new AxisAlignedBB(start, end);

        for (Entity entity : player.getEntityWorld().getEntitiesWithinAABBExcludingEntity(player, cube)) {
            RayTraceResult optional = entity.getEntityBoundingBox().grow(1).calculateIntercept(start, end);
            if (optional != null && start.distanceTo(optional.hitVec) <= range) {
                return entity;
            }
        }

        return null;
    }
}
