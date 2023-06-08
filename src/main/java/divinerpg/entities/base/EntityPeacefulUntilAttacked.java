package divinerpg.entities.base;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.UUID;

public abstract class EntityPeacefulUntilAttacked extends EntityDivineMonster {
    protected static final EntityDataAccessor<Integer> ANGER = SynchedEntityData.defineId(EntityPeacefulUntilAttacked.class, EntityDataSerializers.INT);
    private int angerLevel;
    private UUID angerTargetUUID;
    public EntityPeacefulUntilAttacked(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(ANGER, 0);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Anger", (short)angerLevel);
        if(angerTargetUUID != null) compound.putString("HurtBy", angerTargetUUID.toString());
        else compound.putString("HurtBy", "");
    }
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.angerLevel = compound.getShort("Anger");
        String s = compound.getString("HurtBy");
        if(!s.isEmpty()) {
            angerTargetUUID = UUID.fromString(s);
            Player entityplayer = level().getPlayerByUUID(angerTargetUUID);
            setTarget(entityplayer);
            if(entityplayer != null) {
                setTarget(entityplayer);
                lastHurt = getLastHurtByMobTimestamp();
                goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, true));
                targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
            }
        }
    }
    @Override
    public void setTarget(@Nullable LivingEntity livingBase) {
        super.setTarget(livingBase);
        if(livingBase != null && livingBase instanceof Player) angerTargetUUID = livingBase.getUUID();
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        angerLevel = 400 + random.nextInt(400);
        return super.hurt(source, amount);
    }

    @Override
    public void tick() {
        super.tick();
        angerLevel--;
        if(lastHurtByPlayer != null){
            if(isAggressive()) {
                setTarget(lastHurtByPlayer);
                setAggressive(true);
                goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, true));
                targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
            }
        }
        if(!isAggressive()) {
            setTarget(null);
            setAggressive(false);
            goalSelector.removeGoal(new MeleeAttackGoal(this, 1, true));
            targetSelector.removeGoal(new NearestAttackableTargetGoal<>(this, Player.class, true));
        }
    }

    @Override
    public boolean isAggressive() {
        return angerLevel > 0;
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        if(angerLevel > 0) return super.doHurtTarget(entity);
        return false;
    }
}