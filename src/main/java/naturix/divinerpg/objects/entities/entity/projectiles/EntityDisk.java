package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.enums.BulletType;
import naturix.divinerpg.enums.DiskType;
import naturix.divinerpg.objects.entities.assets.render.projectile.RenderDisk;
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
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly; 

public class EntityDisk extends EntityThrowable {
    private static final DataParameter<Byte> BULLET_ID = EntityDataManager.<Byte>createKey(EntityDisk.class,
            DataSerializers.BYTE);
    private DiskType bulletType;
    public float damage;
    public int counter;
    public int icon;
    public Item item;
    private int bounces;
    public EntityDisk(World world) {
        super(world);
    }

    public EntityDisk(World world, EntityLivingBase entity, DiskType bulletType, Item i) {
        super(world, entity);
        this.bulletType = bulletType;
        setBulletId((byte) bulletType.ordinal());
        this.damage = bulletType.getDamage();
        this.counter = 30;
        this.item = i;
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(BULLET_ID, (byte) 0);
    }

    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityDisk.class,
                manager -> new RenderDisk(manager));
    }
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.motionX  = this.motionX / 0.99D;
        this.motionY  = this.motionY / 0.99D;
        this.motionZ  = this.motionZ / 0.99D;
        if (this.counter == 0 && this.getThrower() != null)
        {
            this.motionX *= -1;
            this.motionY *= -1;
            this.motionZ *= -1;
            this.bounces++;
            this.counter = 30;
        }
        else if (this.counter > 0)
        {
            this.counter--;
        }
        if (this.bounces == 12 && !this.world.isRemote) {
                this.setDead();
        }
    }

    @Override
    public void onImpact(RayTraceResult par1MovingObjectPosition) {
        if (this.getThrower() != null)
        {
            if (par1MovingObjectPosition.entityHit != null && par1MovingObjectPosition.entityHit != this.getThrower())
            {
                par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.damage);
            }
            else if (par1MovingObjectPosition.entityHit == this.getThrower() && this.getThrower() instanceof EntityPlayer && this.bounces > 0)
            {
                if (!((EntityPlayer)this.getThrower()).capabilities.isCreativeMode)
                {
                    ((EntityPlayer)this.getThrower()).inventory.addItemStackToInventory(new ItemStack(this.item));
                }
                if (!this.world.isRemote)
                {
                    this.setDead();
                }
            }

            if (this.bounces == 0)
            {
                this.counter = 0;

                this.bounces++;
            }
        }
        else if (!this.world.isRemote)
        {
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
        this.bulletType = DiskType.getBulletFromOrdinal(getBulletId());
    }

    private byte getBulletId() {
        return ((Byte) this.dataManager.get(BULLET_ID)).byteValue();
    }

    private void setBulletId(byte projectileId) {
        dataManager.set(BULLET_ID, Byte.valueOf(projectileId));
    }

    public DiskType getBulletType() {
        if (bulletType == null) {
            bulletType = DiskType.getBulletFromOrdinal(getBulletId());
        }
        return bulletType;
    }

    public ResourceLocation getTexture() {
        return getBulletType().getTexture();
    }
    @Override
    public float getGravityVelocity()
    {
        return 0F;
    }
}