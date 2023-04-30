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
        if (!this.isInWater()) {
            if (random.nextInt(2) == 0) {

                for (float x = -0.25F; x <= 0.25F; x += 0.125F) {
                    for (float z = -0.25F; z <= 0.25F; z += 0.125F) {
                        level.addParticle(ParticleTypes.DRIPPING_WATER, getX() + x, getY(), getZ() + z, 0, 0.4, 0);
                    }
                }
            }
        }
        if (this.isInWater()) {
            for (int i = 0; i < 5; i++) {
                double bubbleX = this.getX() + (this.random.nextFloat() - 0.5F) * this.getBbWidth();
                double bubbleY = this.getY() + this.random.nextFloat() * this.getBbHeight();
                double bubbleZ = this.getZ() + (this.random.nextFloat() - 0.5F) * this.getBbWidth();
                this.level.addParticle(ParticleTypes.BUBBLE, bubbleX, bubbleY, bubbleZ, 0.0D, 0.0D, 0.0D);
            }
        }


    }
}