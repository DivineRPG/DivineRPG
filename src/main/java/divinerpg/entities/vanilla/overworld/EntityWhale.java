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
        if(isUnderWater()) for(int i = 0; i < 5; i++) level().addParticle(ParticleTypes.BUBBLE, getX() + (random.nextFloat() - .5F) * getBbWidth(), getY() + random.nextFloat() * getBbHeight() + .2, getZ() + (random.nextFloat() - .5F) * getBbWidth(), 0D, 0D, 0D);
        else if(isInWaterOrBubble() && random.nextBoolean()) level().addParticle(ParticleTypes.FALLING_WATER, getX(), getY() + 2D, getZ(), random.nextDouble() - .5, random.nextDouble() * 3D + 4D, random.nextDouble() - .5);
    }
}