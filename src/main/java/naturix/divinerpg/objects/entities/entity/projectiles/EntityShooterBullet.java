package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.enums.ProjectileType;
import naturix.divinerpg.objects.entities.assets.render.projectile.RenderShooterBullet;
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
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityShooterBullet extends EntityThrowable {
    private static final DataParameter<Byte> PROJECTILE_ID = EntityDataManager
            .<Byte>createKey(EntityShooterBullet.class, DataSerializers.BYTE);
    private ProjectileType projectileType;

    public EntityShooterBullet(World world) {
        super(world);
    }

    public EntityShooterBullet(World world, EntityLivingBase entity, ProjectileType projectileType) {
        super(world, entity);
        this.projectileType = projectileType;
        setProjectileId((byte) projectileType.getProjectileId());
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(PROJECTILE_ID, (byte) 0);
    }

    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityShooterBullet.class,
                manager -> new RenderShooterBullet(manager));
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()),
                    this.getProjectileType().getDamage());
        }
        if (!this.world.isRemote) {
            this.setDead();
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setByte("projectileId", getProjectileId());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        setProjectileId(compound.getByte("projectileId"));
        this.projectileType = ProjectileType.getProjectileFromId(getProjectileId());
    }

    private byte getProjectileId() {
        return ((Byte) this.dataManager.get(PROJECTILE_ID)).byteValue();
    }

    private void setProjectileId(byte projectileId) {
        dataManager.set(PROJECTILE_ID, Byte.valueOf(projectileId));
    }

    public ProjectileType getProjectileType() {
        if (projectileType == null) {
            projectileType = ProjectileType.getProjectileFromId(getProjectileId());
        }
        return projectileType;
    }

    public ResourceLocation getTexture() {
        return getProjectileType().getTexture();
    }
}