package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.events.SpawnEvents;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;
import net.minecraftforge.api.distmarker.*;

public class EntityRainbour extends EntityDivineFlyingMob {
    public EntityRainbour(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {
        super(type, worldIn);
    }
    public static boolean rainbourSpawnRule(EntityType<? extends Mob> typeIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
        return SpawnEvents.checkDarknessSpawnRules(typeIn, worldIn, reason, pos, randomIn) && !worldIn.canSeeSky(pos);
    }
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.72F;
    }
    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 1;
    }
    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }
    @OnlyIn(Dist.CLIENT)
    public void tick() {
        super.tick();
        for (int var3 = 0; var3 < 8; ++var3) {
            double d15 = getX() + random.nextDouble() * 0.6D + 0.2D;
            double d20 = getY() + random.nextDouble() * 0.6D + 0.2D;
            double d26 = getZ() + random.nextDouble() * 0.6D + 0.2D;

            level().addParticle(ParticleRegistry.SPARKLER.get(),d15 * (double) this.getBbWidth() - 0.5F,d20 + this.random.nextDouble() * (double) this.getBbHeight() - 0.25D,
                    d26 * (double) this.getBbWidth() - 0.5F, (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
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
