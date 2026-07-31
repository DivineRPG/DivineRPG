package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineFlyingMonster;
import divinerpg.registries.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityReference;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
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
    @Override public boolean isPreventingPlayerRest(ServerLevel level, Player player) {return this.isAngryAt(player, level);}
    @Override public void aiStep() {
        super.aiStep();
        if(!level().isClientSide()) updatePersistentAnger((ServerLevel) level(), true);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        this.addPersistentAngerSaveData(output);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.readPersistentAngerSaveData(this.level(), input);
    }
    @Override public void startPersistentAngerTimer() {setPersistentAngerEndTime(PERSISTENT_ANGER_TIME.sample(random));}

    @Override
    public long getPersistentAngerEndTime() {
        return AttachmentRegistry.ANGER_TIME.get(this);
    }

    @Override
    public void setTimeToRemainAngry(long remainingTime) {
        AttachmentRegistry.ANGER_TIME.set(this, (int)remainingTime);
    }

    @Override
    public void setPersistentAngerEndTime(long l) {
        AttachmentRegistry.ANGER_TIME.set(this, (int)l);
    }

    @Override
    public @Nullable EntityReference<LivingEntity> getPersistentAngerTarget() {
        return angry_at != null ? EntityReference.of(angry_at) : null;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable EntityReference<LivingEntity> target) {
        if (target != null) {
            angry_at = target.getUUID();
            AttachmentRegistry.ANGRY.set(this, true);
        } else {
            angry_at = null;
            AttachmentRegistry.ANGRY.set(this, false);
        }
    }

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