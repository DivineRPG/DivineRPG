package divinerpg.objects.entities.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

@FunctionalInterface
public interface ILaunchArrow {
    /**
     * Creates arrow to shoot
     *
     * @param world          - current world
     * @param shooter        - arrow creater
     * @param distanceFactor - distance multiplier
     * @param x              - x pos
     * @param y              - y pos
     * @param z              - z pos
     * @param velocity       - arrow velocity
     * @param inaccuracy     - shooter inacuracy
     * @return
     */
    Entity createArrow(World world, EntityLivingBase shooter, float distanceFactor, double x, double y, double z, float velocity, float inaccuracy);

    /**
     * Is taken from EntityAIAttackRanged
     *
     * @return
     */
    default Entity createArrow(EntityLivingBase shooter, Entity target, float attackRadius) {
        double distanceSq = shooter.getDistanceSq(target.posX, target.getEntityBoundingBox().minY, target.posZ);

        float f = MathHelper.sqrt(distanceSq) / attackRadius;
        float distanceFactor = MathHelper.clamp(f, 0.1F, 1.0F);

        double d0 = target.posX - shooter.posX;
        double d1 = target.getEntityBoundingBox().minY + (double) (target.height / 3.0F) - shooter.getEyeHeight();
        double d2 = target.posZ - shooter.posZ;

        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);

        return createArrow(shooter.world, shooter, distanceFactor, d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, (float) (14 - shooter.world.getDifficulty().getDifficultyId() * 4));
    }
}
