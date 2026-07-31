package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineFlyingMonster;
import divinerpg.entities.projectile.Bomb;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

import static divinerpg.registries.EntityRegistry.ZORAGON_BOMB;

public class EntityZoragon extends EntityDivineFlyingMonster implements RangedAttackMob {
    public EntityZoragon(EntityType<? extends EntityZoragon> type, Level worldIn) {super(type, worldIn, 20);}
    @Override protected void registerGoals() {
        goalSelector.addGoal(1, new RangedAttackGoal(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 40, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
        super.registerGoals();
    }
    @Override public void performRangedAttack(LivingEntity entity, float range) {
        if(isAlive() && getTarget() != null && !level().isClientSide()) {
            ThrowableProjectile projectile = new Bomb(ZORAGON_BOMB.get(), level());
            projectile.setOwner(this);
            projectile.setPos(getEyePosition());
            double d0 = getTarget().getX() - getX();
            double d1 = getTarget().getY(.3333333333333333) - projectile.getY();
            double d2 = getTarget().getZ() - getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            projectile.shoot(d0, d1 + d3 * .2, d2, 1.6F, .8F);
            level().addFreshEntity(projectile);
        }
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.ZORAGON.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.ZORAGON_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.ZORAGON_HURT.get();}
}