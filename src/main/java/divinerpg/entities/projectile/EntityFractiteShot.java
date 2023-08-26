package divinerpg.entities.projectile;

import divinerpg.registries.EntityRegistry;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;
import net.minecraftforge.api.distmarker.*;

public class EntityFractiteShot extends DivineFireball {
    public EntityFractiteShot(EntityType<? extends DivineFireball> type, Level world) {
        super(type, world);
        explosionPower = 1;
    }
    public EntityFractiteShot(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(EntityRegistry.FRACTITE_SHOT.get(), world, shooter, accelX, accelY, accelZ, (byte)1);
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
    @Override
    @OnlyIn(Dist.CLIENT)
    public void tick() {
        super.tick();
        for(int i = 0; i < 5; i++) {
            level().addParticle(ParticleRegistry.FROST.get(), xo, yo, zo, 0, 1, 0);
            if((tickCount > 40)) {
                kill();
            }
        }
    }
}
