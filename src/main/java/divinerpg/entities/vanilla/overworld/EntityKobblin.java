package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

import javax.annotation.Nullable;

public class EntityKobblin extends EntityDivineMob {
    private static final DataParameter<Boolean> PROVOKED = EntityDataManager.defineId(EntityKobblin.class, DataSerializers.BOOLEAN);

    public EntityKobblin(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        BlockPos pos = new BlockPos(getX(), getY(), getZ());
        return this.level.getBlockState(pos.below()).getBlock() == Blocks.GRASS
                && this.level.getBlockState(pos.below(2)).getBlock() != Blocks.AIR && super.canSpawn(worldIn, spawnReasonIn) && level.dimension() == World.OVERWORLD;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.9F;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(PROVOKED, Boolean.valueOf(false));
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.kobblinHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.kobblinDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.kobblinSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.kobblinFollowRange);
    }

    @Override
    public int getMaxSpawnClusterSize() {return 1;
    }

    @Override
    public void setDeltaMovement(double x, double y, double z) {
        if (this.getProvoked())
            super.setDeltaMovement(x, y, z);
    }

    @Override
    public void tick() {
        super.tick();
        if (!getProvoked()) {
            this.xRotO = 0;
            PlayerEntity player = this.level.getNearestPlayer(this, 4.0D);
            if (player != null) {
                this.setProvoked(player);
                this.setDeltaMovement(0, 0.6, 0);
            }
        }
    }
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        if (tag.getBoolean("Provoked"))
            setProvoked(null);
    }

    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Provoked", this.getProvoked());
    }

    public boolean getProvoked() {
        return entityData.get(PROVOKED).booleanValue();
    }

    @Nullable
    public void setProvoked(PlayerEntity player) {
        entityData.set(PROVOKED, Boolean.valueOf(true));
        addBasicAI();
        addAttackingAI();
        if (player != null && !player.isCreative()) {
            this.setTarget(player);
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        Entity entity = source.getDirectEntity();
        if (entity instanceof PlayerEntity && !getProvoked()) {
            PlayerEntity player = (PlayerEntity) entity;
            this.setProvoked(player);
            this.setDeltaMovement(0, 0.6, 0);
        }
        return super.hurt(source, amount);
    }
    public boolean needsSpecialAI() {
        return true;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.KOBBLIN;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.KOBBLIN;
    }

}