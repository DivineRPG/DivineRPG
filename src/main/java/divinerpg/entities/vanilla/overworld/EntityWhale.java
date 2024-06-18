package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.level.Level;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;

public class EntityWhale extends EntityDivineWaterMob {

    public EntityWhale(EntityType<? extends EntityWhale> type, Level worldIn) {
        super(type, worldIn);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.25F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 20);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.125F;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.WHALE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.WHALE_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.WHALE_HURT.get();
    }

    @Override
    public void tick() {
        super.tick();
        if(isUnderWater()) for(int i = 0; i < 5; i++) level().addParticle(ParticleTypes.BUBBLE, getX() + random.nextDouble() - .5, getY() + random.nextDouble() * getBbHeight() + .2, getZ() + random.nextDouble() - .5, 0D, 0D, 0D);
        else if(isInWaterOrBubble()) for(int i = 0; i < 5; i++) level().addParticle(ParticleRegistry.SPLASH.get(), getX() + random.nextDouble() * .1 - .05, getY(), getZ() + random.nextDouble() * .1 - .05, random.nextDouble() * .5 - .25, random.nextDouble() * 2D + .5, random.nextDouble() * .5 - .25);
    }
}