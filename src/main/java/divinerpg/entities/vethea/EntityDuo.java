package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityDuo extends EntityDivineMonster {
	public boolean isFast = false;
    public int abilityCoolDown = 0;
    public EntityDuo(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.8F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public void tick() {
    	abilityCoolDown--;
    	if(abilityCoolDown < 1) {
    		isFast = !isFast;
            abilityCoolDown = 180;
            if(!(this instanceof EntityTwins)) {
            	if(isFast) addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 255, 3, true, false, false));
            	else removeEffect(MobEffects.MOVEMENT_SPEED);
            }
            playSound(SoundEvents.ZOMBIE_VILLAGER_CONVERTED, .6F, 1F / (this.random.nextFloat() * .4F + .8F));
    	}
    	super.tick();
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DUO.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DUO_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DUO_HURT.get();
    }
}