package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityTocaxin extends EntityDivineMonster {
    private int hurtTimer;
    public EntityTocaxin(EntityType<? extends EntityTocaxin> type, Level worldIn) {
		super(type, worldIn);
		hurtTimer = 10;
    }
    @Override public void tick() {
        super.tick();
        LivingEntity var1 = getTarget();
        if(var1 != null) {
            if(distanceTo(var1) > 8 || hurtTimer != 0) hurtTimer--;
            else {
                hurtTimer = 10;
                var1.hurt(damageSources().mobAttack(this), (int) (8 - distanceTo(var1)));
            }
        }
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.TOCAXIN.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.TOCAXIN_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.TOCAXIN_HURT.get();}
}