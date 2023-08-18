package divinerpg.entities.projectile;

import divinerpg.registries.*;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;

import java.util.*;

public class EntityFrostShot extends DivineFireball {
    public EntityFrostShot(EntityType<? extends DivineFireball> type, Level world) {
        super(type, world);
    }
    public EntityFrostShot(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(EntityRegistry.FROST_SHOT.get(), world, shooter, accelX, accelY, accelZ);
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
    protected void onHitEntity(EntityHitResult result) {
        if(!level().isClientSide() && tickCount > 1 && (result.getEntity() == null || !result.getEntity().equals(shootingEntity))) {
            List<LivingEntity> list = level().<LivingEntity>getEntitiesOfClass(LivingEntity.class, getBoundingBox().inflate(4D, 2D, 4D));
            if(!list.isEmpty()) for(LivingEntity entitylivingbase : list) if(distanceTo(entitylivingbase) < 16D) {
            	EntityFrostCloud frostCloud = new EntityFrostCloud(EntityRegistry.FROST_CLOUD.get(), level(), xo, yo, zo);
                frostCloud.setOwner(shootingEntity);
                frostCloud.setRadius(3F);
                frostCloud.setDuration(50);
                frostCloud.setRadiusPerTick((0F - frostCloud.getRadius()) / frostCloud.getDuration());
                frostCloud.setPos(entitylivingbase.xo, entitylivingbase.yo, entitylivingbase.zo);
                level().addFreshEntity(frostCloud);
            }
            playSound(SoundEvents.GENERIC_EXPLODE);
            discard();
        }
    }
    @Override
    public void tick() {
        if(tickCount > 400) discard();
        super.tick();
        level().addParticle(ParticleRegistry.FROST.get(), xo + (random.nextFloat() * 2F), yo + (random.nextFloat() * 2F), zo + (random.nextFloat() * 2F), 0, 1, 0);
    }
}