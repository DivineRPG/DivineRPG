package divinerpg.objects.entities.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

@FunctionalInterface
public interface ILaunchThrowable {

    /**
     * Creates thowable entity. Need only to create instnace, algoruthm will shot it
     *
     * @param world  - current world
     * @param parent - thrower
     * @param x      - thrower x pos
     * @param y      - thrower y pos
     * @param z      - thrower z pos
     * @return
     */
    EntityThrowable createThowable(World world, EntityLivingBase parent, double x, double y, double z);

    /**
     * Regular velocity
     *
     * @return
     */
    default float getVelocity() {
        return 1.6F;
    }

    /**
     * Gets shoot inccuracy
     *
     * @param world
     * @return
     */
    default float getInaccuracy(World world) {
        return world.getDifficulty().getDifficultyId() * 4;
    }

    /**
     * Is taken from ghast shoot task
     */
    default Entity createFireball(EntityLivingBase parent, Entity target) {
        // taken from snowman
        EntityThrowable fireball = createThowable(parent.world, parent, parent.posX, parent.posY, parent.posZ);

        double d0 = target.posY + (double) target.getEyeHeight() - 1.100000023841858D;
        double d1 = target.posX - parent.posX;
        double d2 = d0 - fireball.posY;
        double d3 = target.posZ - parent.posZ;
        float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;

        fireball.shoot(d1, d2 + (double) f, d3, getVelocity(), getInaccuracy(parent.world));
        return fireball;
    }
}
