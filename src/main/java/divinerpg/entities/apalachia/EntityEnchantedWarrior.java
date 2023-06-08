package divinerpg.entities.apalachia;

import divinerpg.entities.base.*;
import divinerpg.registries.*;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityEnchantedWarrior extends EntityDivineMonster {

    public EntityEnchantedWarrior(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.98F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public void tick() {
        if (this.level().isDay() && !this.level().isClientSide) {
            float lightLevel = level().getLightEmission(this.blockPosition());
            if (lightLevel > 0.5F
                    && this.level().canSeeSky(new BlockPos(Mth.floor(this.getX()), Mth.floor(this.getY()),
                            Mth.floor(this.getZ())))
                    && this.random.nextFloat() * 30.0F < (lightLevel - 0.4F) * 2.0F) {
                this.setSecondsOnFire(8);
            }
        }
        super.tick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HISS.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT.get();
    }

}
