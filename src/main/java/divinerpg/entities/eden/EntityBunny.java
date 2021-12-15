package divinerpg.entities.eden;

import divinerpg.entities.base.*;
import divinerpg.entities.mortum.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class EntityBunny extends EntityDivineTameable {
    private static final DataParameter<Boolean> TAMED_AND_ANGRY = EntityDataManager.defineId(EntityBunny.class, DataSerializers.BOOLEAN);
    public EntityBunny(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 40;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.5F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.bunnyHealth).add(Attributes.MOVEMENT_SPEED, EntityStats.bunnySpeed).add(Attributes.FOLLOW_RANGE, EntityStats.bunnyFollowRange);
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }
    @Override
    public float getWalkTargetValue(BlockPos p_205022_1_, IWorldReader p_205022_2_) {
        return 0.0F;
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TAMED_AND_ANGRY, false);
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
            EntityAngryBunny e = new EntityAngryBunny(EntityRegistry.ANGRY_BUNNY, level);
            e.moveTo(getX(), getY(), getZ(), xRot, yRot);
            this.level.addFreshEntity(e);
            this.remove();
        }
    }

    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack held = player.getItemInHand(hand);
        if (this.isTame()) {
            if (held != null && held.isEdible()) {
                Item food = held.getItem();
                if (food.getFoodProperties().isMeat() && this.getHealth() < 20) {
                    if (!player.isCreative()) {
                        held.shrink(1);
                    }
                    this.heal((float) food.getFoodProperties().getNutrition());
                    return ActionResultType.PASS;
                }
            } else if (isOwnedBy(player)) {
                if (!this.level.isClientSide) {
                    this.setOrderedToSit(!this.isOrderedToSit());
                    this.jumping = false;
                }
                return ActionResultType.PASS;
            }
        } else if (held != null && held.getItem() == ItemRegistry.edenSparkles) {
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
            return ActionResultType.PASS;
        }
            return super.mobInteract(player, hand);
        }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.BUNNY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.BUNNY_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.BUNNY_HURT;
    }

}
