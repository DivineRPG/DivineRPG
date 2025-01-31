package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityDreamwrecker extends EntityDivineMonster {
    public EntityDreamwrecker(EntityType<? extends EntityDreamwrecker> type, Level worldIn) {super(type, worldIn);}
    @Override public void tick() {
        super.tick();
        Player player = level().getNearestPlayer(this, 64);
        if(player != null && !player.isCreative() && player.distanceTo(this) < 20) setTarget(player);
        Entity attackTarget = getTarget();
        if(attackTarget instanceof Player && !((Player)attackTarget).isCreative() && attackTarget.isAlive() && this.hasLineOfSight(attackTarget)) {
            double distanceToTarget = distanceToSqr(attackTarget);
            if(distanceToTarget < 100 && attackTarget.getY() - getY() <= 10)
                attackTarget.setDeltaMovement(Math.signum(xo - attackTarget.xo) * .029, attackTarget.getDeltaMovement().y, Math.signum(zo - attackTarget.zo) * .029);
        } else setTarget(null);
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.DREAMWRECKER.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.DREAMWRECKER_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.DREAMWRECKER_HURT.get();}
}