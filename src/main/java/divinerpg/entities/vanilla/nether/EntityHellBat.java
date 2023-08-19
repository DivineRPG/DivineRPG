package divinerpg.entities.vanilla.nether;

import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class EntityHellBat extends Bat {

    public EntityHellBat(EntityType<? extends Bat> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean fireImmune() {
    	return true;
    }

    @Override
    protected float getSoundVolume() {
        return 0.1F;
    }

    @Override
    public float getVoicePitch() {
        return super.getVoicePitch() * 0.95F;
    }

    @Nullable
    @Override
    public SoundEvent getAmbientSound() {
        return this.isResting() && this.random.nextInt(4) != 0 ? null : SoundEvents.BAT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.BAT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BAT_DEATH;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return sizeIn.height / 2.0F;
    }

    @Override
    public boolean removeWhenFarAway(double d) {
    	return true;
    }

    @Override
    public int getMaxSpawnClusterSize() {
    	return 1;
    }

    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 1;
    }
}
