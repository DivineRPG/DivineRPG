package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.registries.SoundRegistry;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityAlicanto extends EntityDivineFlyingMob {

    public EntityAlicanto(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {
        super(type, worldIn, 18F);
        this.fallDistance = 0;
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
    }

    @Override
    public boolean isAggressive() {
        return true;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.05F;
    }

    @Override
    public int getMaxSpawnClusterSize() {
    	return 2;
    }

    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 2;
    }

    @Override
    public float getVoicePitch() {
        return super.getVoicePitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.random.nextInt(4) != 0 ? null : SoundRegistry.ALICANTO.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ALICANTO_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ALICANTO_HURT.get();
    }
}
