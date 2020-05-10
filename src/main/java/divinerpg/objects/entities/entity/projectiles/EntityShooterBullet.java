package divinerpg.objects.entities.entity.projectiles;

import divinerpg.enums.BulletType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityShooterBullet extends EntityThrowable {
    private static final DataParameter<Byte> BULLET_ID = EntityDataManager.<Byte>createKey(EntityShooterBullet.class,
            DataSerializers.BYTE);
    private BulletType bulletType;

    public EntityShooterBullet(World world) {
        super(world);
    }

    public EntityShooterBullet(World world, EntityLivingBase entity, BulletType bulletType) {
        super(world, entity);
        this.bulletType = bulletType;
        setBulletId((byte) bulletType.ordinal());
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(BULLET_ID, (byte) 0);
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()),
                    this.getBulletType().getDamage());
        }
        if (!this.world.isRemote) {
            this.setDead();
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setByte("projectileId", getBulletId());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        setBulletId(compound.getByte("projectileId"));
        this.bulletType = BulletType.getBulletFromOrdinal(getBulletId());
    }

    private byte getBulletId() {
        return ((Byte) this.dataManager.get(BULLET_ID)).byteValue();
    }

    private void setBulletId(byte projectileId) {
        dataManager.set(BULLET_ID, Byte.valueOf(projectileId));
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