package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class EntityKarot extends EntityDivineBoss {

    private int spawnTick;

    public EntityKarot(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        spawnTick=240;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 3.4375F;
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public void tick() {
        if (this.spawnTick == 0 && !this.level().isClientSide) {
            EntityRegistry.ANGRY_GLINTHOP.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition(), MobSpawnType.MOB_SUMMONED, true, false);
            this.level().addParticle(ParticleTypes.FLASH, getX(), getY() + 0.5D,
                    getZ(), this.random.nextGaussian() * 2.0D - 1.0D, this.random.nextGaussian() * 2.0D - 1.0D,
                    this.random.nextGaussian() * 2.0D - 1.0D);
            this.spawnTick = 240;
        }

        this.spawnTick--;
        super.tick();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        if (!this.level().isClientSide()) {
            for (int i = 0; i < 5; i++) {
                EntityRegistry.ANGRY_GLINTHOP.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition(), MobSpawnType.MOB_SUMMONED, true, false);
            }
        }
        super.kill();
    }

    @Override
    public BossBarColor getBarColor() {
        return BossBarColor.WHITE;
    }
}
