package divinerpg.entities.eden;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nullable;

public class EntityGlinthop extends EntityDivineTameable {
    private static final EntityDataAccessor<Boolean> TAMED_AND_ANGRY = SynchedEntityData.defineId(EntityGlinthop.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SPECIAL = SynchedEntityData.defineId(EntityGlinthop.class, EntityDataSerializers.BOOLEAN);
    public EntityGlinthop(EntityType<? extends TamableAnimal> type, Level worldIn) {super(type, worldIn, 1.5F);}
    @Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficultyInstance, MobSpawnType type, @Nullable SpawnGroupData data, @Nullable CompoundTag tag) {
        if(random.nextInt(50) == 1) entityData.set(SPECIAL, true);
        return super.finalizeSpawn(level, difficultyInstance, type, data, tag);
    }
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return .6875F;}
    @Override protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(TAMED_AND_ANGRY, false);
        entityData.define(SPECIAL, false);
    }
    @Override public void die(DamageSource source) {
        super.die(source);
        if(!level().isClientSide() && !isTame()) transform();
    }
    @Override public void setTarget(LivingEntity e) {
    	super.setTarget(e);
    	if(isTame()) entityData.set(TAMED_AND_ANGRY, e != null);
    }
    public boolean isSpecialAlt() {return this.entityData.get(SPECIAL);}
    @Nullable @Override public LivingEntity getTarget() {
        LivingEntity entity = super.getTarget();
        if(entity != null && ((isTame() && distanceToSqr(entity) < 144) || !isTame())) return entity;
        return null;
    }
    private void transform() {
        if(!level().isClientSide()) {
            EntityRegistry.ANGRY_GLINTHOP.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition(), MobSpawnType.MOB_SUMMONED, true, false);
            remove(RemovalReason.KILLED);
        }
    }
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_sparkles")));}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.GLINTHOP.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GLINTHOP_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GLINTHOP_HURT.get();}
    @Override public void addAdditionalSaveData(CompoundTag tag) {
    	super.addAdditionalSaveData(tag);
    	boolean special = entityData.get(SPECIAL);
    	if(special) tag.putBoolean("Special", true);
    }
    @Override public void readAdditionalSaveData(CompoundTag tag) {
    	super.readAdditionalSaveData(tag);
    	if(tag.contains("Special")) entityData.set(SPECIAL, tag.getBoolean("Special"));
    }
}