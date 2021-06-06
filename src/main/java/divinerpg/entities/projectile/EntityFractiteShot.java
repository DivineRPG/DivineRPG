package divinerpg.entities.projectile;

import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

public class EntityFractiteShot extends DivineFireball {
    public EntityFractiteShot(EntityType<? extends FireballEntity> type, World world) {
        super(type, world);
    }

    public EntityFractiteShot(World world, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(world, x, y, z, accelX, accelY, accelZ);
    }

    public EntityFractiteShot(World world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(world, shooter, accelX, accelY, accelZ);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    @Override
    protected void onHit(RayTraceResult result) {
        if (result.hitInfo != null && result.hitInfo instanceof Entity && shootingEntity != null) {
            Entity entity = (Entity) result.hitInfo;
            entity.hurt(DamageSource.fireball(this, this.shootingEntity), 12.0F);
        }

        this.level.explode(null, this.xo, this.yo, this.zo, 3.0F, false, Explosion.Mode.BREAK);
        this.kill();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void tick() {
        super.tick();
        for (int i = 0; i < 5; i++) {
            level.addParticle(ParticleRegistry.FROST.get(), xo, yo, zo, 0, 1, 0);
        }
    }
}
