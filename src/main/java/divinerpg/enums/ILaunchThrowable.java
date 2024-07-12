package divinerpg.enums;

import net.minecraft.util.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.level.*;

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
    ThrowableProjectile createThowable(Level world, LivingEntity parent, double x, double y, double z);

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
    default float getInaccuracy(Level world) {
        return world.getDifficulty().getId() * 4;
    }

    /**
     * Is taken from ghast shoot task
     */
    default Entity createFireball(LivingEntity parent, Entity target) {
        // taken from snowman
        ThrowableProjectile fireball = createThowable(parent.level(), parent, parent.getX(), parent.getY(), parent.getZ());

        double d0 = target.getY() + (double) target.getEyeHeight() - 1.1;
        double d1 = target.getX() - parent.getX();
        double d2 = d0 - fireball.getY();
        double d3 = target.getZ() - parent.getZ();
        float f = Mth.sqrt((float) (d1 * d1 + d3 * d3)) * 0.2F;

        fireball.shoot(d1, d2 + (double) f, d3, getVelocity(), getInaccuracy(parent.level()));
        return fireball;
    }
}