package divinerpg.entities.projectile;

import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import java.util.Random;

public class EntityShooterBullet extends DivineThrowable {
    private static final EntityDataAccessor<Byte> BULLET_ID = SynchedEntityData.defineId(EntityShooterBullet.class, EntityDataSerializers.BYTE);
    public BulletType bulletType;
    public int bounces;
    public int color = new Random().nextInt(25);
    public LivingEntity thrower;
    public EntityShooterBullet(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    public EntityShooterBullet(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world, BulletType bulletType) {
        super(type, entity, world);
        this.bulletType = bulletType;
        thrower = entity;
        setBulletId((byte)bulletType.ordinal());
    }
    @Override public void tick() {
        super.tick();
        if(bulletType == BulletType.CAPTAINS_SPARKLER_SHOT) {
            for(int var3 = 0; var3 < 8; ++var3) level().addParticle(ParticleRegistry.SPARKLER.get(), xo, yo, zo, .25 * random.nextGaussian(), 0.25 * random.nextGaussian(), 0.25 * random.nextGaussian());
        }
        if(color >= 24) color = 0;
        else color++;
        if(bulletType == BulletType.SOUND_OF_MUSIC_SHOT || bulletType ==  BulletType.SOUND_OF_CAROLS_SHOT || bulletType == BulletType.SOUND_OF_WHALES_SHOT) level().addParticle(ParticleTypes.NOTE, xo, yo, zo, (double)color / 24, 0, 0);
    }
    @Override public void onHit(HitResult result) {
        super.onHit(result);
        if(!level().isClientSide()) {
            if(bulletType == BulletType.GRENADE) level().explode(this, xo, yo, zo, 3, false, Level.ExplosionInteraction.TNT);
            //TODO: to add proper snowball-like particles for tomato shot
            level().broadcastEntityEvent(this, (byte)3);
        }
    }
    @Override public void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        if(!(this instanceof EntityBouncingProjectile)) entity.hurt(damageSources().thrown(this, thrower), getBulletType().getDamage());
        if(entity instanceof LivingEntity livingEntity && !(entity instanceof EnderMan)) {
            if(bulletType == BulletType.SNOWFLAKE_SHURIKEN_SHOT) livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 3));
            if(bulletType == BulletType.VILE_STORM_SHOT || bulletType == BulletType.SERENADE_OF_DEATH_SHOT) livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 40, 3));
        }
    }
    @Override protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if(!level().isClientSide()) {
            if(bulletType == BulletType.SHURIKEN_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ItemRegistry.shuriken.get())));
            if(bulletType == BulletType.VILE_STORM_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ItemRegistry.vile_storm.get())));
            if(bulletType == BulletType.SNOWFLAKE_SHURIKEN_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ItemRegistry.snowflake_shuriken.get())));
            if(bulletType == BulletType.EDEN_SLICER_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ItemRegistry.eden_slicer.get())));
            if(bulletType == BulletType.WILDWOOD_SLICER_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ItemRegistry.wildwood_slicer.get())));
            if(bulletType == BulletType.APALACHIA_SLICER_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ItemRegistry.apalachia_slicer.get())));
            if(bulletType == BulletType.SKYTHERN_SLICER_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ItemRegistry.skythern_slicer.get())));
            if(bulletType == BulletType.MORTUM_SLICER_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ItemRegistry.mortum_slicer.get())));
            if(bulletType == BulletType.HALITE_SLICER_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ItemRegistry.halite_slicer.get())));
            level().broadcastEntityEvent(this, (byte)3);
        }
    }
    @Override public void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(BULLET_ID, (byte)0);
    }
    @Override public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putByte("projectileId", getBulletId());
    }
    @Override public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setBulletId(compound.getByte("projectileId"));
        bulletType = BulletType.getBulletFromOrdinal(getBulletId());
    }
    private byte getBulletId() {return entityData.get(BULLET_ID);}
    private void setBulletId(byte projectileId) {entityData.set(BULLET_ID, projectileId);}
    public BulletType getBulletType() {
        if(bulletType == null) bulletType = BulletType.getBulletFromOrdinal(getBulletId());
        return bulletType;
    }
    public ResourceLocation getTexture() {return getBulletType().getTexture();}
}