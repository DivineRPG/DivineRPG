package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityHelio extends EntityDivineMonster {
    public EntityHelio(EntityType<? extends EntityHelio> type, Level worldIn) {super(type, worldIn);}
    @Override public boolean canAttack(LivingEntity target) {
        if(super.canAttack(target)) {
            target.setDeltaMovement(getDeltaMovement().x + Mth.sin(getXRot() * Mth.DEG_TO_RAD) * 3.5, getDeltaMovement().y + .4, getDeltaMovement().z + Mth.cos(getXRot() * Mth.DEG_TO_RAD) * 3.5);
            //this.motionX *= 0.6D;
            //this.motionZ *= 0.6D;
            return true;
        } else return false;
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.HELIO.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.HELIO_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.HELIO_HURT.get();}
}