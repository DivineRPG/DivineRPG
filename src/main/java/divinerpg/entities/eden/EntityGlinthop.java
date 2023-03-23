package divinerpg.entities.eden;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityGlinthop extends EntityDivineTameable {
    private static final EntityDataAccessor<Boolean> TAMED_AND_ANGRY = SynchedEntityData.defineId(EntityGlinthop.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SPECIAL = SynchedEntityData.defineId(EntityGlinthop.class, EntityDataSerializers.BOOLEAN);
    public EntityGlinthop(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 40;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance p_146747_, MobSpawnType p_146748_, @org.jetbrains.annotations.Nullable SpawnGroupData p_146749_, @org.jetbrains.annotations.Nullable CompoundTag p_146750_) {
        if(random.nextInt(50) == 1){
            entityData.set(SPECIAL, true);
        }
        return super.finalizeSpawn(level, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.5F;
    }

    public static boolean canSpawnOn(EntityType<? extends Mob> typeIn, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random randomIn) {
        return true;
    }
    @Override
    public float getWalkTargetValue(BlockPos p_205022_1_, LevelReader p_205022_2_) {
        return 0.0F;
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TAMED_AND_ANGRY, false);
        this.entityData.define(SPECIAL, false);
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
            return !this.isTame();
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        if (!this.level.isClientSide && !this.isTame()) {
            this.transform();
        }
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        if (this.isTame()) {
            this.entityData.set(TAMED_AND_ANGRY, true);
        }

        return super.doHurtTarget(target);
    }

    public boolean isTamedAndAngry() {
        return this.entityData.get(TAMED_AND_ANGRY);
    }

    public boolean isSpecialAlt() {
        return this.entityData.get(SPECIAL);
    }

    @Nullable
    @Override
    public LivingEntity getTarget() {
        LivingEntity entity = super.getTarget();
        if (entity != null && ((this.isTame() && this.distanceToSqr(entity) < 144) || !this.isTame()))
            return entity;
        return null;
    }


    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            if (this.isTame() && this.getTarget() == null) {
                this.entityData.set(TAMED_AND_ANGRY, false);
            }
        }
    }

    private void transform() {
        if (!this.level.isClientSide) {
            EntityRegistry.ANGRY_GLINTHOP.get().spawn((ServerLevel) level, ItemStack.EMPTY, null, blockPosition(), MobSpawnType.MOB_SUMMONED, true, false);
            this.remove(RemovalReason.KILLED);
        }
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack held = player.getItemInHand(hand);
        if (this.isTame()) {
            if (held != null && held.isEdible()) {
                Item food = held.getItem();
                if (food.getFoodProperties(held, null).isMeat() && this.getHealth() < 20) {
                    if (!player.isCreative()) {
                        held.shrink(1);
                    }
                    this.heal((float) food.getFoodProperties(held, null).getNutrition());
                    return InteractionResult.PASS;
                }
            } else if (isOwnedBy(player)) {
                if (!this.level.isClientSide) {
                    this.setOrderedToSit(!this.isOrderedToSit());
                    this.jumping = false;
                }
                return InteractionResult.PASS;
            }
        } else if (held != null && held.getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_sparkles"))) {
            if (!player.isCreative()) {
                held.shrink(1);
            }
            if (!this.level.isClientSide) {
                if (this.random.nextInt(3) == 0) {
                    tame(player);
                    this.setTarget(null);
                    this.setOrderedToSit(true);

                    this.setHealth(20);
                    this.level.broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level.broadcastEntityEvent(this, (byte) 6);
                }
            }
            return InteractionResult.PASS;
        }
            return InteractionResult.FAIL;
        }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GLINTHOP.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GLINTHOP_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GLINTHOP_HURT.get();
    }

}
