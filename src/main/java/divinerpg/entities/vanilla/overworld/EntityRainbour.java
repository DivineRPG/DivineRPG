package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineFlyingMonster;
import divinerpg.registries.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.UUID;

public class EntityRainbour extends EntityDivineFlyingMonster implements NeutralMob {
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    private UUID angry_at;
    public EntityRainbour(EntityType<? extends EntityRainbour> type, Level worldIn) {
        super(type, worldIn);
        xpReward = XP_REWARD_LARGE;
    }
    @Override protected void registerGoals() {
        targetSelector.addGoal(0, new HurtByTargetGoal(this).setAlertOthers());
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        targetSelector.addGoal(2, new ResetUniversalAngerTargetGoal<>(this, true));
        super.registerGoals();
    }
    @Override public boolean isPreventingPlayerRest(Player player) {return this.isAngryAt(player);}
    @Override public void aiStep() {
        super.aiStep();
        if(!level().isClientSide) updatePersistentAnger((ServerLevel) level(), true);
    }
    @Override public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        UUID angry_at = getPersistentAngerTarget();
        if(angry_at != null) compound.putUUID("angryAt", angry_at);
    }
    @Override public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if(compound.contains("angryAt")) angry_at = compound.getUUID("angryAt");
    }
    @Override public void startPersistentAngerTimer() {setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(random));}
    @Override public void setRemainingPersistentAngerTime(int time) {AttachmentRegistry.ANGER_TIME.set(this, time);}
    @Override public int getRemainingPersistentAngerTime() {return AttachmentRegistry.ANGER_TIME.get(this);}
    @Override public void setPersistentAngerTarget(@Nullable UUID target) {
        angry_at = target;
        AttachmentRegistry.ANGRY.set(this, target != null);
    }
    @Nullable
    @Override public UUID getPersistentAngerTarget() {
        if(AttachmentRegistry.ANGRY.get(this)) return angry_at;
        return null;
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void tick() {
        super.tick();
        for(int var3 = 0; var3 < 8; ++var3) {
            double d15 = getX() + random.nextDouble() * .6 + .2;
            double d20 = getY() + random.nextDouble() * .6 + .2;
            double d26 = getZ() + random.nextDouble() * .6 + .2;
            level().addParticle(ParticleRegistry.SPARKLER.get(),d15 * (double)getBbWidth() - .5,d20 + random.nextDouble() * (double)getBbHeight() - .25,
                    d26 * (double)getBbWidth() - .5, (random.nextDouble() - .5) * 2, - random.nextDouble(), (random.nextDouble() - .5) * 2);
        }
    }
    @Override public boolean isIgnoringBlockTriggers() {return true;}
    @Override public boolean isMaxGroupSizeReached(int i) {return i > 1;}
    @Override public int getMaxSpawnClusterSize() {return 1;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.RAINBOUR.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.RAINBOUR_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.RAINBOUR_HURT.get();}
}