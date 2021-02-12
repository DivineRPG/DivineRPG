package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.entities.mortum.EntityAngryBunny;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityBunny extends EntityDivineTameable {
    private static final DataParameter<Boolean> TAMED_AND_ANGRY = EntityDataManager.createKey(EntityBunny.class, DataSerializers.BOOLEAN);
    public EntityBunny(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
        this.experienceValue = 40;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.5F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.bunnyHealth).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.bunnySpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.bunnyFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
    return true;
    }
    public void func_242340_t(boolean p_242340_1_) {
        this.getDataManager().set(TAMED_AND_ANGRY, p_242340_1_);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(TAMED_AND_ANGRY, false);
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
            return !this.isTamed();
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        if (!this.world.isRemote && !this.isTamed()) {
            this.transform();
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity target) {
        if (this.isTamed()) {
            this.dataManager.set(TAMED_AND_ANGRY, true);
        }

        return super.attackEntityAsMob(target);
    }

    public boolean isTamedAndAngry() {
        return this.dataManager.get(TAMED_AND_ANGRY);
    }

    @Override
    public LivingEntity getAttackTarget() {
        LivingEntity entity = super.getAttackTarget();
        if (entity != null && ((this.isTamed() && this.getDistanceSq(entity) < 144) || !this.isTamed()))
            return entity;
        return null;
    }


    @Override
    public void tick() {
        super.tick();
        if (!this.world.isRemote) {
            if (this.isTamed() && this.getAttackTarget() == null) {
                this.dataManager.set(TAMED_AND_ANGRY, false);
            }
        }
    }

    private void transform() {
        if (!this.world.isRemote) {
            EntityAngryBunny e = new EntityAngryBunny(EntityRegistry.ANGRY_BUNNY, world);
            e.setLocationAndAngles(getPosX(), getPosY(), getPosZ(), rotationYaw, rotationPitch);
            this.world.addEntity(e);
            this.setDead();
        }
    }

    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack held = player.inventory.getCurrentItem();
        if (this.isTamed()) {
            if (held != null && held.isFood()) {
                Item food = held.getItem();
                if (food.getFood().isMeat() && this.getHealth() < 20) {
                    if (!player.isCreative()) {
                        held.shrink(1);
                    }
                    this.heal((float) food.getFood().getHealing());
                    return ActionResultType.PASS;
                }
            } else if (isOwner(player)) {
                if (!this.world.isRemote) {
                    this.func_233687_w_(!this.isSitting());
                    this.isJumping = false;
                }
                return ActionResultType.PASS;
            }
        } else if (held != null && held.getItem() == ItemRegistry.edenSparkles) {
            if (!player.isCreative()) {
                held.shrink(1);
            }
            if (!this.world.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    setTamedBy(player);
                    this.setAttackTarget(null);
                    this.func_233687_w_(true);

                    this.setHealth(20);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte) 6);
                }
            }
            return ActionResultType.PASS;
        }
            return super.func_230254_b_(player, hand);
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

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_BUNNY;
    }
}
