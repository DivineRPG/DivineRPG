package divinerpg.entities.projectile;

import divinerpg.enums.DiskType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityDisk extends DivineThrowable {
    private static final EntityDataAccessor<Byte> DISK_ID = SynchedEntityData.<Byte>defineId(EntityDisk.class,
            EntityDataSerializers.BYTE);
    private DiskType diskType;
    public float damage;
    public int counter;
    public int icon;
    public Item item;
    private int bounces;

    public EntityDisk(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityDisk(EntityType<? extends ThrowableProjectile> type, Level world, LivingEntity entity, DiskType diskType, Item item) {
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
        lerpMotion(getDeltaMovement().x / 0.99, getDeltaMovement().y / 0.99, getDeltaMovement().z / 0.99);
        if (this.counter == 0 && this.getOwner() != null)
        {
            lerpMotion(getDeltaMovement().x * -1, getDeltaMovement().y * -1, getDeltaMovement().z * -1);
            this.bounces++;
            this.counter = 30;
        }
        else if (this.counter > 0)
        {
            this.counter--;
        }
        if (this.bounces >= 12 && !this.level.isClientSide) {
            this.kill();
        }
    }

    @Override
    public void onHitEntity(EntityHitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            if (this.getOwner() != null) {
                if (result.getEntity() != null && result.getEntity() != this.getOwner()) {
                    result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), this.damage);
                } else if (result.getEntity() == this.getOwner() && this.getOwner() instanceof Player
                        && this.bounces > 0) {
                    if (!((Player) this.getOwner()).isCreative()) {
                        ((Player) this.getOwner()).inventory.add(new ItemStack(this.item));
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
    }

    @Override
    protected float getGravity() {
        return 0F;
    }

    @Override
    public boolean save(CompoundTag compound) {
        super.save(compound);
        compound.putByte("projectileId", getDiskId());
        return false;
    }

    @Override
    public void load(CompoundTag compound) {
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