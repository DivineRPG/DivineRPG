package divinerpg.objects.entities.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface ILaunchFireBall {

    /**
     * Creates fireball
     *
     * @param world            - current world
     * @param parent           - parent entity
     * @param x                - x velocity
     * @param y                - y velocity
     * @param z                - z velocity
     * @param fireballStrength - strength of fireball (random value 0..5)
     * @return
     */
    @Nonnull
    Entity createFireball(World world, EntityLivingBase parent, double x, double y, double z, int fireballStrength);


    /**
     * Is taken from ghast shoot task
     */
    default Entity createFireball(EntityLivingBase parent, Entity target) {
        Vec3d vec3d = parent.getLook(1.0F);

        double d2 = target.posX - (parent.posX + vec3d.x * 4.0D);
        double d3 = target.getEntityBoundingBox().minY + (double) (target.height / 2.0F) - (0.5D + parent.posY + (double) (parent.height / 2.0F));
        double d4 = target.posZ - (parent.posZ + vec3d.z * 4.0D);

        Entity fireball = createFireball(parent.world, parent, d2, d3, d4, parent.getRNG().nextInt(6));

        fireball.posX = parent.posX + vec3d.x * 4.0D;
        fireball.posY = parent.posY + (double) (parent.height / 2.0F) + 0.5D;
        fireball.posZ = parent.posZ + vec3d.z * 4.0D;

        return fireball;
    }
}
