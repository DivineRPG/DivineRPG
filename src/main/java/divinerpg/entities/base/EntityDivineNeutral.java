package divinerpg.entities.base;

import divinerpg.registries.AttachmentRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;

import javax.annotation.Nullable;
import java.util.UUID;

public abstract class EntityDivineNeutral extends EntityDivineMonster implements NeutralMob {
    private UUID angry_at;
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    public EntityDivineNeutral(EntityType<? extends EntityDivineNeutral> type, Level worldIn) {super(type, worldIn);}
    @Override public void onAddedToLevel() {
        super.onAddedToLevel();
        if(level().isClientSide()) AttachmentRegistry.ANGRY.requestAttachment(this, null);
    }
    @Override protected void registerGoals() {
        targetSelector.addGoal(0, new HurtByTargetGoal(this).setAlertOthers());
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        targetSelector.addGoal(2, new ResetUniversalAngerTargetGoal<>(this, true));
        super.registerGoals();
    }
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override public boolean isPreventingPlayerRest(Player player) {return isAngryAt(player);}
    @Override public void aiStep() {
        super.aiStep();
        if(!level().isClientSide) updatePersistentAnger((ServerLevel) level(), true);
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
    @Override public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if(compound.contains("angryAt")) angry_at = compound.getUUID("angryAt");
    }
    @Override public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        UUID angry_at = getPersistentAngerTarget();
        if(angry_at != null) compound.putUUID("angryAt", angry_at);
    }
}