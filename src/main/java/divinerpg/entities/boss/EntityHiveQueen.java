package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.registries.*;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityHiveQueen extends EntityDivineBoss {

    private int spawnTick;
    //private int deathTicks;

    public EntityHiveQueen(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        spawnTick=80;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.3125F;
    }

    @Override
    public BossBarColor getBarColor() {
        return BossBarColor.YELLOW;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getHealth() > 0) {
            if (this.spawnTick % 40 == 0 && !this.level().isClientSide && this.level().getNearestPlayer(this, 20) != null) {
                if (this.random.nextBoolean()) {
                    EntityRegistry.HOVER_STINGER.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition(), MobSpawnType.MOB_SUMMONED, true, false);
                    this.level().addParticle(DustParticleOptions.REDSTONE, xo, yo, zo, random.nextGaussian() * 2 - 1, random.nextGaussian() * 2 - 1, random.nextGaussian() * 2 - 1);
                } else {
                    EntityRegistry.HIVE_SOLDIER.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition(), MobSpawnType.MOB_SUMMONED, true, false);
                    this.level().addParticle(DustParticleOptions.REDSTONE, xo, yo, zo, random.nextGaussian() * 2 - 1, random.nextGaussian() * 2 - 1, random.nextGaussian() * 2 - 1);
                }
                spawnTick = 80;
            }

            this.spawnTick--;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HIVE_QUEEN.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HIVE_QUEEN_HURT.get();
    }
}
