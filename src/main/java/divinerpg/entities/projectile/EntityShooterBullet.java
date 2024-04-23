package divinerpg.entities.projectile;

import divinerpg.DivineRPG;
import divinerpg.enums.BulletType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityShooterBullet extends DivineThrowable {
    private static final EntityDataAccessor<Byte> BULLET_ID = SynchedEntityData.defineId(EntityShooterBullet.class, EntityDataSerializers.BYTE);
    private BulletType bulletType;
    public EntityShooterBullet(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    public EntityShooterBullet(EntityType<? extends ThrowableProjectile> type, Player player, Level level) {super(type, player, level);}
    public EntityShooterBullet(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world, BulletType bulletType) {
        super(type, entity, world);
        this.bulletType = bulletType;
        setBulletId((byte)bulletType.ordinal());
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
        entity.hurt(damageSources().thrown(this, getOwner()), getBulletType().getDamage());
        if(entity instanceof LivingEntity && !(entity instanceof EnderMan)) {
            if(bulletType == BulletType.SNOWFLAKE_SHURIKEN_SHOT) ((LivingEntity)result.getEntity()).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 3));
            if(bulletType == BulletType.VILE_STORM_SHOT || bulletType == BulletType.SERENADE_OF_DEATH_SHOT) ((LivingEntity)result.getEntity()).addEffect(new MobEffectInstance(MobEffects.POISON, 40, 3));
        }
    }
    @Override protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if(!level().isClientSide()) {
            if(bulletType == BulletType.SHURIKEN_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shuriken")))));
            if(bulletType == BulletType.VILE_STORM_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vile_storm")))));
            if(bulletType == BulletType.SNOWFLAKE_SHURIKEN_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "snowflake_shuriken")))));
            if(bulletType == BulletType.EDEN_SLICER_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_slicer")))));
            if(bulletType == BulletType.WILDWOOD_SLICER_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_slicer")))));
            if(bulletType == BulletType.APALACHIA_SLICER_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_slicer")))));
            if(bulletType == BulletType.SKYTHERN_SLICER_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_slicer")))));
            if(bulletType == BulletType.MORTUM_SLICER_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_slicer")))));
            if(bulletType == BulletType.HALITE_SLICER_SHOT) level().addFreshEntity(new ItemEntity(level(), xo, yo, zo, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "halite_slicer")))));
            level().broadcastEntityEvent(this, (byte)3);
        }
    }
    @Override public void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(BULLET_ID, (byte)0);
    }
    @Override public boolean save(CompoundTag compound) {
        super.save(compound);
        compound.putByte("projectileId", getBulletId());
        return false;
    }
    @Override public void load(CompoundTag compound) {
        super.load(compound);
        setBulletId(compound.getByte("projectileId"));
        bulletType = BulletType.getBulletFromOrdinal(getBulletId());
    }
    private byte getBulletId() {return entityData.get(BULLET_ID).byteValue();}
    private void setBulletId(byte projectileId) {entityData.set(BULLET_ID, Byte.valueOf(projectileId));}
    public BulletType getBulletType() {
        if(bulletType == null) bulletType = BulletType.getBulletFromOrdinal(getBulletId());
        return bulletType;
    }
    public ResourceLocation getTexture() {return getBulletType().getTexture();}
}