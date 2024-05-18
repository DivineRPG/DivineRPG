package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

public class EntityMandragora extends EntityDivineMonster {

    public EntityMandragora(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.8F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }
    
    @Override
    public void tick() {
        super.tick();
        Player target = this.level().getNearestPlayer(this, 16);
        if(!level().isClientSide() && target != null && this.tickCount%20 == 0) attackEntity(target);
    }

    public void attackEntity(LivingEntity e) {
        if (isAlive() && getTarget() != null && !level().isClientSide) {
            ThrowableProjectile projectile = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.MANDRAGORA_SHOT);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.8F);
            this.level().addFreshEntity(projectile);
        }
    }   
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.MANDRAGORA.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.MANDRAGORA.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.MANDRAGORA.get();
    }
}