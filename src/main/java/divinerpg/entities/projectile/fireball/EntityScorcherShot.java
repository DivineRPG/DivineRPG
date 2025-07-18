package divinerpg.entities.projectile.fireball;

import divinerpg.entities.projectile.DivineFireball;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import static divinerpg.registries.EntityRegistry.SCORCHER_SHOT;
import static net.minecraft.core.particles.ParticleTypes.PORTAL;

public class EntityScorcherShot extends DivineFireball {
    public EntityScorcherShot(EntityType<? extends DivineFireball> type, Level world) {super(type, world);}
    public EntityScorcherShot(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(SCORCHER_SHOT.get(), world, shooter, accelX, accelY, accelZ);
        moveTo(shooter.xo, shooter.yo, shooter.zo, shooter.getXRot(), shooter.getYRot());
        setPos(shooter.xo, shooter.yo, shooter.zo);
        double d = Math.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
        setDeltaMovement(accelX / d * .1, accelY / d * .1, accelZ / d * .1);
        setOwner(shooter);
    }
    @Override public boolean hurt(DamageSource source, float amount) {return false;}
    @Override public boolean canBeCollidedWith() {return false;}
    @Override protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if(tickCount > 1 && level() instanceof ServerLevel level) {
            Entity entity = result.getEntity();
            if(!entity.fireImmune()) {
                Entity owner = getOwner();
                int i = entity.getRemainingFireTicks();
                entity.igniteForSeconds(5);
                DamageSource source = damageSources().fireball(this, owner);
                boolean flag = entity.hurt(source, 5);
                if(!flag) entity.setRemainingFireTicks(i);
                else if(owner instanceof LivingEntity) EnchantmentHelper.doPostAttackEffects(level, owner, source);
            }
        }
    }
    @Override public void tick() {
        super.tick();
        if(!level().isClientSide) {
            xo += (random.nextDouble() - random.nextDouble()) / 3;
            yo += (random.nextDouble() - random.nextDouble()) / 3;
            zo += (random.nextDouble() - random.nextDouble()) / 3;
        } if(level().isClientSide) for(int i = 0; i < 3; i++) level().addParticle(PORTAL,
                getX() + (random.nextDouble() - random.nextDouble()) / 5,
                getY() + .5 + (random.nextDouble() - random.nextDouble()) / 5,
                getZ() + (random.nextDouble() - random.nextDouble()) / 5, 0, 0, 0);
    }
    @Override
    public boolean deflect(@NotNull ProjectileDeflection deflection, @Nullable Entity entity, @Nullable Entity owner, boolean deflectedByPlayer) {
        return false;
    }
}