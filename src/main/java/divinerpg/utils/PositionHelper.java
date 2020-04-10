package divinerpg.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class PositionHelper {
    public static RayTraceResult rayTrace(EntityPlayer player, double blockReachDistance, int partialTicks) {
        Vec3d vec3d = player.getPositionEyes(partialTicks);
        Vec3d vec3d1 = player.getLook(partialTicks);
        Vec3d vec3d2 = vec3d.addVector(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        return player.world.rayTraceBlocks(vec3d, vec3d2, false, false, true);
    }

    public static RayTraceResult rayTrace(EntityPlayer e, boolean stopOnLiquid) {
        Vec3d startVec = new Vec3d(e.posX, e.posY + (double) e.getEyeHeight(), e.posZ);
        Vec3d endVec = startVec.add(e.getLook(0).scale(getBlockReachDistance(e)));
        return e.world.rayTraceBlocks(startVec, endVec, stopOnLiquid, false, true);
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
}
