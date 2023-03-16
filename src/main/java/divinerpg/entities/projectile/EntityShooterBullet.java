package divinerpg.entities.projectile;

import divinerpg.enums.BulletType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityShooterBullet extends DivineThrowable {
    private static final EntityDataAccessor<Byte> BULLET_ID = SynchedEntityData.<Byte>defineId(EntityShooterBullet.class,
            EntityDataSerializers.BYTE);
    private BulletType bulletType;

    public EntityShooterBullet(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityShooterBullet(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world, BulletType bulletType) {
        super(type, entity, world);
        this.bulletType = bulletType;
        setBulletId((byte) bulletType.ordinal());
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(BULLET_ID, (byte) 0);
    }

    @Override
    public void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null) {
                Entity entity = result.getEntity();
                entity.hurt(entity.level.damageSources().thrown(this, this.getOwner()),
                        this.getBulletType().getDamage());
            }
            if (!this.level.isClientSide) {
                this.kill();
            }
        }
    }


    @Override
    public boolean save(CompoundTag compound) {
        super.save(compound);
        compound.putByte("projectileId", getBulletId());
        return false;
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        setBulletId(compound.getByte("projectileId"));
        this.bulletType = BulletType.getBulletFromOrdinal(getBulletId());
    }

    private byte getBulletId() {
        return ((Byte) this.entityData.get(BULLET_ID)).byteValue();
    }

    private void setBulletId(byte projectileId) {
        entityData.set(BULLET_ID, Byte.valueOf(projectileId));
    }

    public BulletType getBulletType() {
        if (bulletType == null) {
            bulletType = BulletType.getBulletFromOrdinal(getBulletId());
        }
        return bulletType;
    }

    public ResourceLocation getTexture() {
        return getBulletType().getTexture();
    }
}