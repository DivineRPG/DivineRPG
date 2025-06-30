package divinerpg.entities.projectile.bullet;

import divinerpg.entities.projectile.magic.DivineParticleProjectile;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

import static divinerpg.registries.DamageRegistry.ARCANA;
import static divinerpg.registries.EntityRegistry.GENERALS_SHOT;
import static divinerpg.registries.ParticleRegistry.WILDWOOD_PORTAL;

public class GeneralsShot extends DivineParticleProjectile {
    public boolean shouldSpray = true;
    public GeneralsShot(EntityType<? extends ThrowableProjectile> entityType, Level level) {
        super(entityType, level, 4.3F, WILDWOOD_PORTAL::value);
    }
    @Override public DamageSource getDamageSource(EntityHitResult result) {return damageSources().source(ARCANA.getKey(), this);}
    @Override protected void onHitBlock(BlockHitResult result) {
        hitBlockNoDiscard(result);
        if(shouldSpray) {
            EntityType<GeneralsShot> type = GENERALS_SHOT.get();
            Vec3 pos = position().add(0, .01, 0);
            GeneralsShot shot = type.create(level());
            shot.shouldSpray = false;
            shot.setPos(pos);
            shot.shoot(0, 1, 0, .5F, 1);
            level().addFreshEntity(shot);
            shot = type.create(level());
            shot.shouldSpray = false;
            shot.setPos(pos);
            shot.shoot(1, 1, 0, .5F, 1);
            level().addFreshEntity(shot);
            shot = type.create(level());
            shot.shouldSpray = false;
            shot.setPos(pos);
            shot.shoot(-1, 1, 0, .5F, 1);
            level().addFreshEntity(shot);
            shot = type.create(level());
            shot.shouldSpray = false;
            shot.setPos(pos);
            shot.shoot(0, 1, 1, .5F, 1);
            level().addFreshEntity(shot);
            shot = type.create(level());
            shot.shouldSpray = false;
            shot.setPos(pos);
            shot.shoot(0, 1, -1, .5F, 1);
            level().addFreshEntity(shot);
        } discard();
    }
    @Override protected void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("spray", shouldSpray);
    }
    @Override protected void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        shouldSpray = compound.getBoolean("spray");
    }
}