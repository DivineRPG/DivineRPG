package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.entities.projectile.EntityFyracryxFireball;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;

public class EntityFyracryx extends EntityDivineTameable implements RangedAttackMob {
    public EntityFyracryx(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DEATHCRYX.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DEATHCRYX_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DEATHCRYX.get();
    }
    @Override
    public void tick() {
        super.tick();
        if(getTarget() != null && !level().isClientSide && tickCount % 20 == 0) performRangedAttack(getTarget(), 0);
    }
    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (isAlive() && getTarget() != null && !level().isClientSide) {
            EntityFyracryxFireball projectile = new EntityFyracryxFireball(level(), this, target.xo - xo + random.nextGaussian() * Mth.sqrt(this.distanceTo(this)) * 0.5F, target.getBoundingBox().minY - this.xo,
                target.zo - zo + random.nextGaussian() * Mth.sqrt(distanceTo(this)) * 0.5F);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.8F);
            this.level().addFreshEntity(projectile);
        }
    }
}
