package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.events.SpawnEvents;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.syncher.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.api.distmarker.*;

public class EntityRainbour extends EntityDivineFlyingMob {
    public EntityRainbour(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {
        super(type, worldIn);
    }
    public static boolean rainbourSpawnRule(EntityType<? extends Mob> typeIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
        return SpawnEvents.checkDarknessSpawnRules(typeIn, worldIn, reason, pos, randomIn) && !worldIn.canSeeSky(pos);
    }

    @Override
    public float getEyeHeight(Pose pose) {
        return 0.6875F;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.6875F;
    }
    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 1;
    }
    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }
    public ParticleOptions getParticleData() {
        return this.getEntityData().get(PARTICLE);
    }
    private static final EntityDataAccessor<ParticleOptions> PARTICLE = SynchedEntityData.defineId(EntityRainbour.class, EntityDataSerializers.PARTICLE);
    @OnlyIn(Dist.CLIENT)
    public void tick() {
        super.tick();
        for (int var3 = 0; var3 < 8; ++var3) {
            double d15 = getX() + random.nextDouble() * 0.6D + 0.2D;
            double d20 = getY() + random.nextDouble() * 0.6D + 0.2D;
            double d26 = getZ() + random.nextDouble() * 0.6D + 0.2D;

            if(level().isClientSide())
            level().addParticle(ParticleRegistry.SPARKLER.get(),d15 * (double) this.getBbWidth(),d20 + this.random.nextDouble() * (double) this.getBbHeight() - 0.25D,
                    d26 * (double) this.getBbWidth(), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
        }
    }
    @Override
    public boolean isIgnoringBlockTriggers() {
        return true;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.RAINBOUR.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.RAINBOUR_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.RAINBOUR_HURT.get();
    }
}