package divinerpg.objects.entities.entity.projectiles;

import divinerpg.enums.DiskType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityDisk extends EntityThrowable {
    private static final DataParameter<Byte> DISK_ID = EntityDataManager.<Byte>createKey(EntityDisk.class,
            DataSerializers.BYTE);
    private DiskType diskType;
    public float damage;
    public int counter;
    public int icon;
    public Item item;
    private int bounces;

    public EntityDisk(World world) {
        super(world);
    }

    public EntityDisk(World world, EntityLivingBase entity, DiskType diskType, Item item) {
        super(world, entity);
        this.diskType = diskType;
        setDiskId((byte) diskType.ordinal());
        this.damage = diskType.getDamage();
        this.counter = 30;
        this.item = item;
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(DISK_ID, (byte) 0);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.motionX = this.motionX / 0.99D;
        this.motionY = this.motionY / 0.99D;
        this.motionZ = this.motionZ / 0.99D;
        if (this.counter == 0 && this.getThrower() != null) {
            this.motionX *= -1;
            this.motionY *= -1;
            this.motionZ *= -1;
            this.bounces++;
            this.counter = 30;
        } else if (this.counter > 0) {
            this.counter--;
        }
        if (this.bounces >= 12 && !this.world.isRemote) {
            this.setDead();
        }
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (this.getThrower() != null) {
            if (result.entityHit != null && result.entityHit != this.getThrower()) {
                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.damage);
            } else if (result.entityHit == this.getThrower() && this.getThrower() instanceof EntityPlayer
                    && this.bounces > 0) {
                if (!((EntityPlayer) this.getThrower()).capabilities.isCreativeMode) {
                    ((EntityPlayer) this.getThrower()).inventory.addItemStackToInventory(new ItemStack(this.item));
                }
                if (!this.world.isRemote) {
                    this.setDead();
                }
            }
            if (this.bounces == 0) {
                this.counter = 0;
                this.bounces++;
            }
        } else if (!this.world.isRemote) {
            this.setDead();
        }
    }

    @Override
    public float getGravityVelocity() {
        return 0F;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setByte("projectileId", getDiskId());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        setDiskId(compound.getByte("projectileId"));
        this.diskType = DiskType.getDiskFromOrdinal(getDiskId());
    }

    private byte getDiskId() {
        return ((Byte) this.dataManager.get(DISK_ID)).byteValue();
    }

    private void setDiskId(byte projectileId) {
        dataManager.set(DISK_ID, Byte.valueOf(projectileId));
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