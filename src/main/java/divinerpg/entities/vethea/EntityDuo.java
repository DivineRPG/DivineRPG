package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityDuo extends EntityDivineMonster {
	public boolean isFast = false;
    public int abilityCoolDown = 0;
    public EntityDuo(EntityType<? extends EntityDuo> type, Level worldIn) {super(type, worldIn);}
    @Override public void tick() {
    	abilityCoolDown--;
    	if(abilityCoolDown < 1) {
    		isFast = !isFast;
            abilityCoolDown = 180;
            if(!(this instanceof EntityTwins)) {
            	if(isFast) addEffect(new MobEffectInstance(MobEffects.SPEED, 13 * 20, 3, true, false, false));
            	else removeEffect(MobEffects.SPEED);
            } playSound(SoundEvents.ZOMBIE_VILLAGER_CONVERTED, .6F, 1 / (this.random.nextFloat() * .4F + .8F));
    	} super.tick();
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.DUO.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.DUO_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.DUO_HURT.get();}
}