package divinerpg.entities.projectile.bullet;

import divinerpg.entities.projectile.magic.DivineParticleProjectile;
import divinerpg.registries.*;
import divinerpg.registries.DamageRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

public class GeneralsShot extends DivineParticleProjectile {
    public boolean shouldSpray = true;
    public GeneralsShot(EntityType<? extends ThrowableProjectile> entityType, Level level) {
        super(entityType, level, 4.3F, ParticleRegistry.WILDWOOD_PORTAL::value);
    }
    @Override
    public DamageSource getDamageSource(EntityHitResult result) {
        return damageSources().source(DamageRegistry.ARCANA.getKey(), this);
    }
    @Override
    protected void onHitBlock(BlockHitResult result) {
        hitBlockNoDiscard(result);
        if(shouldSpray) {
            EntityType<GeneralsShot> type = EntityRegistry.GENERALS_SHOT.get();
            Vec3 pos = position().add(0D, .01D, 0D);
            GeneralsShot shot = type.create(level());
            shot.shouldSpray = false;
            shot.setPos(pos);
            shot.shoot(0D, 1D, 0D, 0.5F, 1F);
            level().addFreshEntity(shot);
            shot = type.create(level());
            shot.shouldSpray = false;
            shot.setPos(pos);
            shot.shoot(1D, 1D, 0D, 0.5F, 1F);
            level().addFreshEntity(shot);
            shot = type.create(level());
            shot.shouldSpray = false;
            shot.setPos(pos);
            shot.shoot(-1D, 1D, 0D, 0.5F, 1F);
            level().addFreshEntity(shot);
            shot = type.create(level());
            shot.shouldSpray = false;
            shot.setPos(pos);
            shot.shoot(0D, 1D, 1D, 0.5F, 1F);
            level().addFreshEntity(shot);
            shot = type.create(level());
            shot.shouldSpray = false;
            shot.setPos(pos);
            shot.shoot(0D, 1D, -1D, 0.5F, 1F);
            level().addFreshEntity(shot);
        } discard();
    }
    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("spray", shouldSpray);
    }
    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        shouldSpray = compound.getBoolean("spray");
    }
}
