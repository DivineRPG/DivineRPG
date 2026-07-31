package divinerpg.entities.projectile.fireball;

import divinerpg.entities.projectile.DivineFireball;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;

import static divinerpg.registries.EntityRegistry.FROST_SHOT;
import static divinerpg.registries.ParticleRegistry.FROST;
import static net.minecraft.world.phys.HitResult.Type.MISS;

public class EntityFrostShot extends DivineFireball {
    public EntityFrostShot(EntityType<? extends DivineFireball> type, Level world) {super(type, world);}
    public EntityFrostShot(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(FROST_SHOT.get(), world, shooter, accelX, accelY, accelZ);
    }

    @Override public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {return false;}
    @Override public boolean canCollideWith(Entity entity) {return false;}
    @Override public boolean isOnFire() {return false;}
    @Override protected void onHit(HitResult result) {
        super.onHit(result);
        if(result.getType() != MISS) {
            if(!level().isClientSide()) {
                level().explode(this, getX(), getY(), getZ(), 1.3F, false, Level.ExplosionInteraction.NONE); //TODO - Warmth
                for(Entity entity : level().getEntities(getOwner(), new AABB(position().add(-3, -3, -3), position().add(3, 3, 3)))) if(entity instanceof  LivingEntity l && l.canFreeze() && !l.hasEffect(/*WARMTH*/MobEffects.INVISIBILITY)) l.setTicksFrozen(l.getTicksRequiredToFreeze() + 50);
            } discard();
        }
    }
    @Override public void tick() {
        if(tickCount > 400) discard();
        super.tick();
        level().addParticle(FROST.get(), xo + (random.nextFloat() * 2), yo + (random.nextFloat() * 2), zo + (random.nextFloat() * 2), 0, 1, 0);
    }
}