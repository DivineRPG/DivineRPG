package divinerpg.entities.projectile;

import com.google.common.collect.Maps;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.*;

public class EntityFrostCloud extends Entity {
    private static final EntityDataAccessor<Float> RADIUS = SynchedEntityData.defineId(EntityFrostCloud.class, EntityDataSerializers.FLOAT);
    private final Map<Entity, Integer> reapplicationDelayMap;
    private int duration, reapplicationDelay;
    private float radiusPerTick;
    private LivingEntity owner;
    private UUID ownerUniqueId;
    public EntityFrostCloud(EntityType<EntityFrostCloud> type, Level world) {
        super(type, world);
        reapplicationDelayMap = Maps.newHashMap();
        duration = 600;
        reapplicationDelay = 10;
        noPhysics = true;
    }
    public EntityFrostCloud(EntityType<EntityFrostCloud> type, Level world, double x, double y, double z) {
        this(type, world);
        setPos(x, y, z);
    }
    @Override
    public boolean fireImmune() {
        return true;
    }
    @Override
    public float getPickRadius() {
        return 3F;
    }
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
    	builder.define(RADIUS, Float.valueOf(3F));
    }
    public int getDuration(){
        return duration;
    }
    @Nullable
    public LivingEntity getOwner() {
        if(owner == null && ownerUniqueId != null && level() instanceof ServerLevel world && world.getEntity(ownerUniqueId) instanceof LivingEntity living) owner = living;
        return owner;
    }
    public float getRadius() {
        return entityData.get(RADIUS).floatValue();
    }
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        if(RADIUS.equals(key)) setRadius(getRadius());
        super.onSyncedDataUpdated(key);
    }
    @Override
    public void tick() {
        super.tick();
        float f = getRadius();
        if(level().isClientSide()) {
            float f5 = (float) Math.PI * f * f;
            for(float k1 = 0; k1 < f5; ++k1) {
                float f6 = random.nextFloat() * ((float) Math.PI * 2F), f7 = Mth.sqrt(random.nextFloat()) * f, f8 = Mth.cos(f6) * f7, f9 = Mth.sin(f6) * f7;
                level().addParticle(ParticleRegistry.FROST.get(), xo + f8, yo, zo + f9, (.5 - random.nextDouble()) * .15, .009999999776482582, (.5 - random.nextDouble()) * .15);
            }
        } else {
            if(tickCount >= duration) {
                kill();
                return;
            }
            if(radiusPerTick != 0F) {
                f += radiusPerTick;
                if(f < .5F) {
                    kill();
                    return;
                }
                setRadius(f);
            }
            if(tickCount % 5 == 0) {
                Iterator<Map.Entry<Entity, Integer>> iterator = reapplicationDelayMap.entrySet().iterator();
                while(iterator.hasNext()) {
                    Map.Entry<Entity, Integer> entry = iterator.next();
                    if(tickCount >= entry.getValue().intValue()) iterator.remove();
                }
                List<LivingEntity> list = level().getEntitiesOfClass(LivingEntity.class, getBoundingBox().inflate(f));
                if(!list.isEmpty()) for(LivingEntity entity : list) if(!reapplicationDelayMap.containsKey(entity) && entity.isAffectedByPotions()) {
                    double d0 = entity.xo - xo, d1 = entity.zo - zo, d2 = d0 * d0 + d1 * d1;
                    if(d2 <= f * f) {
                        reapplicationDelayMap.put(entity, Integer.valueOf(tickCount + reapplicationDelay));
                        if(!entity.isDeadOrDying() && entity.canFreeze()) {
                            entity.hurt(entity.level().damageSources().magic(), 1.5F);
                            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 0, false, false, false));
                        }
                    }
                }
            }
        }
    }
    public void setDuration(int durationIn) {
        duration = durationIn;
    }
    public void setOwner(@Nullable LivingEntity ownerIn) {
        owner = ownerIn;
        ownerUniqueId = ownerIn == null ? null : ownerIn.getUUID();
    }
    public void setRadius(float radiusIn) {
        setPos(xo, yo, zo);
        if(!level().isClientSide()) entityData.set(RADIUS, radiusIn);
    }
    public void setRadiusPerTick(float radiusPerTickIn) {
        radiusPerTick = radiusPerTickIn;
    }
    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        tickCount = compound.getInt("Age");
        duration = compound.getInt("Duration");
        reapplicationDelay = compound.getInt("ReapplicationDelay");
        radiusPerTick = compound.getFloat("RadiusPerTick");
        setRadius(compound.getFloat("Radius"));
        ownerUniqueId = compound.getUUID("OwnerUUID");
    }
    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Age", tickCount);
        compound.putInt("Duration", duration);
        compound.putInt("ReapplicationDelay", reapplicationDelay);
        compound.putFloat("RadiusPerTick", radiusPerTick);
        compound.putFloat("Radius", getRadius());
        if(ownerUniqueId != null) compound.putUUID("OwnerUUID", ownerUniqueId);
    }
}