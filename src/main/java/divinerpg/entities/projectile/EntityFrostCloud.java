package divinerpg.entities.projectile;


import com.google.common.collect.*;
import divinerpg.entities.iceika.*;
import divinerpg.entities.vanilla.overworld.*;
import divinerpg.registries.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import javax.annotation.*;
import java.util.*;

public class EntityFrostCloud extends Entity {
    private static final DataParameter<Float> RADIUS = EntityDataManager.defineId(EntityFrostCloud.class,
            DataSerializers.FLOAT);
    private final Map<Entity, Integer> reapplicationDelayMap;
    private int duration;
    private int reapplicationDelay;
    private float radiusPerTick;
    private LivingEntity owner;
    private UUID ownerUniqueId;
    private PlayerEntity player;

    public EntityFrostCloud(EntityType<?> type, World world) {
        super(type, world);
        this.reapplicationDelayMap = Maps.newHashMap();
        this.duration = 600;
        this.reapplicationDelay = 10;
        this.noPhysics = true;
        }
    public EntityFrostCloud(EntityType<?> type, World world, double x, double y, double z) {
        this(type, world);
        setPos(x, y, z);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public float getPickRadius() {
        return 3.0F;
    }

    @Override
    protected void defineSynchedData() {
    entityData.define(RADIUS, Float.valueOf(3.0F));
    }

    public int getDuration(){
        return this.duration;
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && this.ownerUniqueId != null && this.level instanceof ServerWorld) {
            Entity entity = ((ServerWorld) this.level).getEntity(this.ownerUniqueId);
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity) entity;
            }
        }
        return this.owner;
    }

    @Override
    public PushReaction getPistonPushReaction() {
        return PushReaction.IGNORE;
    }

    public float getRadius() {
        return this.entityData.get(RADIUS).floatValue();
    }

    @Override
    public void onSyncedDataUpdated(DataParameter<?> key) {
        if(RADIUS.equals(key)) {
        setRadius(getRadius());
        }
        super.onSyncedDataUpdated(key);
    }


    @Override
    public void tick() {
        super.tick();
        float f = this.getRadius();

        if (this.level.isClientSide) {
            float f5 = (float) Math.PI * f * f;

            for (int k1 = 0; k1 < f5; ++k1) {
                float f6 = this.random.nextFloat() * ((float) Math.PI * 2F);
                float f7 = MathHelper.sqrt(this.random.nextFloat()) * f;
                float f8 = MathHelper.cos(f6) * f7;
                float f9 = MathHelper.sin(f6) * f7;

                level.addParticle(ParticleRegistry.FROST.get(), this.xo + f8, this.yo, this.zo + f9,
                        (0.5D - this.random.nextDouble()) * 0.15D, 0.009999999776482582D,
                        (0.5D - this.random.nextDouble()) * 0.15D);
            }
        } else {
            if (this.tickCount >= this.duration) {
                this.kill();
                return;
            }

            if (this.radiusPerTick != 0.0F) {
                f += this.radiusPerTick;

                if (f < 0.5F) {
                    this.kill();
                    return;
                }

                this.setRadius(f);
            }

            if (this.tickCount % 5 == 0) {
                Iterator<Map.Entry<Entity, Integer>> iterator = this.reapplicationDelayMap.entrySet().iterator();

                while (iterator.hasNext()) {
                    Map.Entry<Entity, Integer> entry = iterator.next();

                    if (this.tickCount >= entry.getValue().intValue()) {
                        iterator.remove();
                    }
                }

                List<LivingEntity> list = this.level.getEntitiesOfClass(LivingEntity.class,
                        this.getBoundingBox());

                if (!list.isEmpty()) {
                    for (LivingEntity entity : list) {
                        if (!this.reapplicationDelayMap.containsKey(entity) && entity.isAffectedByPotions()) {
                            double d0 = entity.xo - this.xo;
                            double d1 = entity.zo - this.zo;
                            double d2 = d0 * d0 + d1 * d1;
                            if (d2 <= f * f) {
                                this.reapplicationDelayMap.put(entity,
                                        Integer.valueOf(this.tickCount + this.reapplicationDelay));
                                if (!(entity.isDeadOrDying() || entity instanceof SnowGolemEntity
                                        || entity instanceof EntityGlacon || entity instanceof EntityFrost
                                        || entity instanceof EntityAlicanto || entity instanceof EntityFractite
                                        || entity instanceof EntityFrostArcher || entity instanceof EntityFrosty
                                        || entity instanceof EntityGlacide || entity instanceof EntityHastreus
                                        || entity instanceof EntityRollum)) {
                                    entity.hurt(DamageSource.MAGIC, 1.0F);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void setDuration(int durationIn) {
        this.duration = durationIn;
    }

    public void setOwner(@Nullable LivingEntity ownerIn) {
        this.owner = ownerIn;
        this.ownerUniqueId = ownerIn == null ? null : ownerIn.getUUID();
    }

    public void setRadius(float radiusIn) {
        double d0 = this.xo;
        double d1 = this.yo;
        double d2 = this.zo;
//        this.setSize(radiusIn * 2.0F, 0.5F);
        this.setPos(d0, d1, d2);

        if (!this.level.isClientSide) {
            this.entityData.set(RADIUS, Float.valueOf(radiusIn));
        }
    }

    public void setRadiusPerTick(float radiusPerTickIn) {
        this.radiusPerTick = radiusPerTickIn;
    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT compound) {
        this.tickCount = compound.getInt("Age");
        this.duration = compound.getInt("Duration");
        this.reapplicationDelay = compound.getInt("ReapplicationDelay");
        this.radiusPerTick = compound.getFloat("RadiusPerTick");
        this.setRadius(compound.getFloat("Radius"));
        this.ownerUniqueId = compound.getUUID("OwnerUUID");
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT compound) {
        compound.putInt("Age", this.tickCount);
        compound.putInt("Duration", this.duration);
        compound.putInt("ReapplicationDelay", this.reapplicationDelay);
        compound.putFloat("RadiusPerTick", this.radiusPerTick);
        compound.putFloat("Radius", this.getRadius());
        if (this.ownerUniqueId != null) {
            compound.putUUID("OwnerUUID", this.ownerUniqueId);
        }
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return null;
    }
}
