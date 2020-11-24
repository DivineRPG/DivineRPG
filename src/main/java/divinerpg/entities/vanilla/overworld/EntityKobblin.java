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
    private static final DataParameter<Boolean> PROVOKED = EntityDataManager.createKey(EntityKobblin.class, DataSerializers.BOOLEAN);

    public EntityKobblin(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        BlockPos pos = new BlockPos(getPosX(), getPosY(), getPosZ());
        return this.world.getBlockState(pos.down()).getBlock() == Blocks.GRASS
                && this.world.getBlockState(pos.down(2)).getBlock() != Blocks.AIR && super.canSpawn(worldIn, spawnReasonIn) && world.getDimensionKey() == World.OVERWORLD;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.9F;
    }

    protected void registerData() {
        super.registerData();
        dataManager.register(PROVOKED, Boolean.valueOf(false));
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.kobblinHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.kobblinDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.kobblinSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.kobblinFollowRange);
    }
    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public void addVelocity(double x, double y, double z) {
        if (this.getProvoked())
            super.addVelocity(x, y, z);
    }

    @Override
    public void tick() {
        super.tick();
        if (!getProvoked()) {
            this.renderYawOffset = 0;
            PlayerEntity player = this.world.getClosestPlayer(this, 4.0D);
            if (player != null) {
                this.setProvoked(player);
                this.addVelocity(0, 0.6, 0);
            }
        }
    }
    public void readAdditional(CompoundNBT tag) {
        super.readAdditional(tag);
        if (tag.getBoolean("Provoked"))
            setProvoked(null);
    }

    public void writeAdditional(CompoundNBT tag) {
        super.writeAdditional(tag);
        tag.putBoolean("Provoked", this.getProvoked());
    }

    public boolean getProvoked() {
        return dataManager.get(PROVOKED).booleanValue();
    }

    @Nullable
    public void setProvoked(PlayerEntity player) {
        dataManager.set(PROVOKED, Boolean.valueOf(true));
        addBasicAI();
        addAttackingAI();
        if (player != null && !player.isCreative()) {
            this.setAttackTarget(player);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        Entity entity = source.getTrueSource();
        if (entity instanceof PlayerEntity && !getProvoked()) {
            PlayerEntity player = (PlayerEntity) entity;
            this.setProvoked(player);
            this.addVelocity(0, 0.6, 0);
        }
        return super.attackEntityFrom(source, amount);
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

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_KOBBLIN;
    }

}