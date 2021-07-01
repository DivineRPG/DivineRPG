package divinerpg.entities.projectile;

import divinerpg.enums.BulletType;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class EntityShooterBullet extends DivineThrowable {
    private static final DataParameter<Byte> BULLET_ID = EntityDataManager.<Byte>defineId(EntityShooterBullet.class,
            DataSerializers.BYTE);
    private BulletType bulletType;

    public EntityShooterBullet(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityShooterBullet(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world, BulletType bulletType) {
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
    public void onHitEntity(EntityRayTraceResult result) {
        if (result.getEntity() != null) {
            Entity entity = result.getEntity();
            entity.hurt(DamageSource.thrown(this, this.getOwner()),
                    this.getBulletType().getDamage());
        }
        if (!this.level.isClientSide) {
            this.kill();
        }
    }


    @Override
    public boolean save(CompoundNBT compound) {
        super.save(compound);
        compound.putByte("projectileId", getBulletId());
        return false;
    }

    @Override
    public void load(CompoundNBT compound) {
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