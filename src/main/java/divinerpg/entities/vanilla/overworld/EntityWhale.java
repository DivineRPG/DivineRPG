package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ParticleRegistry.SPLASH;

public class EntityWhale extends EntityDivineWaterMob {
    public EntityWhale(EntityType<? extends EntityWhale> type, Level worldIn) {
        super(type, worldIn);
        moveControl = new SmoothSwimmingMoveControl(this, 85, 10, .25F, .1F, true);
        lookControl = new SmoothSwimmingLookControl(this, 20);
    }
    @Override public void tick() {
        super.tick();
        if(isUnderWater()) for(int i = 0; i < 5; i++) level().addParticle(ParticleTypes.BUBBLE, getX() + random.nextDouble() - .5, getY() + random.nextDouble() * getBbHeight() + .2, getZ() + random.nextDouble() - .5, 0, 0, 0);
        else if(isInWater()) for(int i = 0; i < 5; i++) level().addParticle(SPLASH.get(), getX() + random.nextDouble() * .1 - .05, getY(), getZ() + random.nextDouble() * .1 - .05, random.nextDouble() * .5 - .25, random.nextDouble() * 2 + .5, random.nextDouble() * .5 - .25);
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.WHALE.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.WHALE_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.WHALE_HURT.get();}
}