package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.util.*;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityGreenfeet extends EntityDivineMonster {

    public EntityGreenfeet(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.75F;
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return 0.0F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public void tick() {
        if (this.level().isDay() && !this.level().isClientSide) {
            float lightLevel = this.level().getLightEmission(blockPosition());
            if (lightLevel > 0.5F
                    && this.level().canSeeSky(new BlockPos(Mth.floor(this.getX()), Mth.floor(this.getY()),
                    Mth.floor(this.getZ())))
                    && this.random.nextFloat() * 30.0F < (lightLevel - 0.4F) * 2.0F) {
                this.setRemainingFireTicks(8);
            }
        }
        super.tick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.NESRO.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.NESRO_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.NESRO_HURT.get();
    }

}
