package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityTocaxin extends EntityDivineMonster {

    private int hurtTimer;

    public EntityTocaxin(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
		this.hurtTimer = 10;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public void tick() {
        super.tick();
        LivingEntity var1 = this.getTarget();
        if(var1 != null) {
            if(this.distanceTo(var1) > 8 || this.hurtTimer != 0) {
                this.hurtTimer--;
            }
            else {
                this.hurtTimer = 10;
                var1.hurt(damageSources().mobAttack(this), (int) (8 - this.distanceTo(var1)));
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.TOCAXIN.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.TOCAXIN_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.TOCAXIN_HURT.get();
    }
}