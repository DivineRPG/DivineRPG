package divinerpg.entities.base;

import divinerpg.entities.projectile.EntityParticleBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.*;

public abstract class EntityMageBase extends EntityDivineMonster {
    private final BulletType bullet;
    public EntityMageBase(EntityType<? extends Monster> type, Level worldIn, BulletType bullet) {
        super(type, worldIn);
        this.bullet = bullet;
    }
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 2F;
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, false, null));
    }
    @Override
    public void tick() {
        super.tick();
        if(tickCount % 19 == 0 && isAlive() && getTarget() != null && !level().isClientSide) {
            double tx = getTarget().getX() - getX(), ty = getTarget().getBoundingBox().minY - getY() - 0.1, tz = getTarget().getZ() - getZ();
            ThrowableProjectile e = new EntityParticleBullet(EntityRegistry.PARTICLE_BULLET.get(), level(), this, bullet != null ? bullet : BulletType.SPELLBINDER_SHOT);
            e.shoot(tx, ty, tz, 1.6F, 0);
            level().addFreshEntity(e);
            playSound(SoundRegistry.MAGE_FIRE.get());
        }
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.INSECT.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.INSECT.get();
    }
    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader world) {
        return 0F;
    }
}