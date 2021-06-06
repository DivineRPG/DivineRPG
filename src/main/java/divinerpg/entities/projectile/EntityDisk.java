package divinerpg.entities.projectile;

import divinerpg.enums.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityDisk extends DivineThrowable {
    private static final DataParameter<Byte> DISK_ID = EntityDataManager.<Byte>defineId(EntityDisk.class,
            DataSerializers.BYTE);
    private DiskType diskType;
    public float damage;
    public int counter;
    public int icon;
    public Item item;
    private int bounces;

    public EntityDisk(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityDisk(EntityType<? extends ThrowableEntity> type, World world, LivingEntity entity) {
        super(type, entity, world);
        this.diskType = diskType;
        setDiskId((byte) diskType.ordinal());
        this.damage = diskType.getDamage();
        this.counter = 30;
        this.item = item;
    }


    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DISK_ID, (byte) 0);
    }

    @Override
    public void tick() {
        super.tick();
        setDeltaMovement(getDeltaMovement().x / 0.99D, getDeltaMovement().y / 0.99D, getDeltaMovement().z / 0.99D);
        if (this.counter == 0 && this.getOwner() != null) {
            setDeltaMovement(getDeltaMovement().x * -1, getDeltaMovement().y * -1, getDeltaMovement().z * -1);
            this.bounces++;
            this.counter = 30;
        } else if (this.counter > 0) {
            this.counter--;
        }
        if (this.bounces >= 12 && !this.level.isClientSide) {
            this.kill();
        }
    }

    @Override
    public void onHit(RayTraceResult result) {
        if (this.getOwner() != null) {
            if (result.hitInfo != null && result.hitInfo != this.getOwner() && result.hitInfo instanceof Entity) {
                ((Entity) result.hitInfo).hurt(DamageSource.thrown(this, this.getOwner()), this.damage);
            } else if (result.hitInfo == this.getOwner() && this.getOwner() instanceof PlayerEntity
                    && this.bounces > 0) {
                if (!((PlayerEntity) this.getOwner()).isCreative()) {
                    ((PlayerEntity) this.getOwner()).inventory.add(new ItemStack(this.item));
                }
                if (!this.level.isClientSide) {
                    this.kill();
                }
            }
            if (this.bounces == 0) {
                this.counter = 0;
                this.bounces++;
            }
        } else if (!this.level.isClientSide) {
            this.kill();
        }
    }

    @Override
    protected float getGravity() {
        return 0F;
    }

    @Override
    public boolean save(CompoundNBT compound) {
        super.save(compound);
        compound.putByte("projectileId", getDiskId());
        return false;
    }

    @Override
    public void load(CompoundNBT compound) {
        super.load(compound);
        setDiskId(compound.getByte("projectileId"));
        this.diskType = DiskType.getDiskFromOrdinal(getDiskId());
    }

    private byte getDiskId() {
        return ((Byte) this.entityData.get(DISK_ID)).byteValue();
    }

    private void setDiskId(byte projectileId) {
        entityData.set(DISK_ID, Byte.valueOf(projectileId));
    }

    public DiskType getDiskType() {
        if (diskType == null) {
            diskType = DiskType.getDiskFromOrdinal(getDiskId());
        }
        return diskType;
    }

    public ResourceLocation getTexture() {
        return getDiskType().getTexture();
    }
}