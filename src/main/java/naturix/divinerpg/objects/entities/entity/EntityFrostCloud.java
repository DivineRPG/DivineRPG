package naturix.divinerpg.objects.entities.entity;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.assets.render.iceika.RenderFrostCloud;
import naturix.divinerpg.objects.entities.entity.iceika.Alicanto;
import naturix.divinerpg.objects.entities.entity.iceika.Fractite;
import naturix.divinerpg.objects.entities.entity.iceika.FrostArcher;
import naturix.divinerpg.objects.entities.entity.iceika.Frosty;
import naturix.divinerpg.objects.entities.entity.iceika.Glacide;
import naturix.divinerpg.objects.entities.entity.iceika.Hastreus;
import naturix.divinerpg.objects.entities.entity.iceika.Rollum;
import naturix.divinerpg.objects.entities.entity.vanilla.Frost;
import naturix.divinerpg.objects.entities.entity.vanilla.Glacon;
import naturix.divinerpg.utils.DRPGParticleTypes;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFrostCloud extends Entity {
    private static final DataParameter<Float> RADIUS = EntityDataManager.<Float>createKey(EntityFrostCloud.class,
            DataSerializers.FLOAT);
    private final Map<Entity, Integer> reapplicationDelayMap;
    private int duration;
    private int reapplicationDelay;
    private float radiusPerTick;
    private EntityLivingBase owner;
    private UUID ownerUniqueId;
    private EntityPlayer player;

    public EntityFrostCloud(World worldIn) {
        super(worldIn);
        this.reapplicationDelayMap = Maps.<Entity, Integer>newHashMap();
        this.duration = 600;
        this.reapplicationDelay = 10;
        this.noClip = true;
        this.isImmuneToFire = true;
        this.setRadius(3.0F);
    }

    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFrostCloud.class,
                manager -> new RenderFrostCloud(manager));
    }

    public EntityFrostCloud(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }

    @Override
    protected void entityInit() {
        this.getDataManager().register(RADIUS, Float.valueOf(3.0F));
    }

    public int getDuration() {
        return this.duration;
    }

    @Nullable
    public EntityLivingBase getOwner() {
        if (this.owner == null && this.ownerUniqueId != null && this.world instanceof WorldServer) {
            Entity entity = ((WorldServer) this.world).getEntityFromUuid(this.ownerUniqueId);
            if (entity instanceof EntityLivingBase) {
                this.owner = (EntityLivingBase) entity;
            }
        }
        return this.owner;
    }

    @Override
    public EnumPushReaction getPushReaction() {
        return EnumPushReaction.IGNORE;
    }

    public float getRadius() {
        return this.getDataManager().get(RADIUS).floatValue();
    }

    @Override
    public void notifyDataManagerChange(DataParameter<?> key) {
        if (RADIUS.equals(key)) {
            this.setRadius(this.getRadius());
        }
        super.notifyDataManagerChange(key);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        float f = this.getRadius();

        if (this.world.isRemote) {
            float f5 = (float) Math.PI * f * f;

            for (int k1 = 0; k1 < f5; ++k1) {
                float f6 = this.rand.nextFloat() * ((float) Math.PI * 2F);
                float f7 = MathHelper.sqrt(this.rand.nextFloat()) * f;
                float f8 = MathHelper.cos(f6) * f7;
                float f9 = MathHelper.sin(f6) * f7;

                DivineRPG.proxy.spawnParticle(world, DRPGParticleTypes.FROST, this.posX + f8, this.posY, this.posZ + f9,
                        (0.5D - this.rand.nextDouble()) * 0.15D, 0.009999999776482582D,
                        (0.5D - this.rand.nextDouble()) * 0.15D);
            }
        } else {
            if (this.ticksExisted >= this.duration) {
                this.setDead();
                return;
            }

            if (this.radiusPerTick != 0.0F) {
                f += this.radiusPerTick;

                if (f < 0.5F) {
                    this.setDead();
                    return;
                }

                this.setRadius(f);
            }

            if (this.ticksExisted % 5 == 0) {
                Iterator<Entry<Entity, Integer>> iterator = this.reapplicationDelayMap.entrySet().iterator();

                while (iterator.hasNext()) {
                    Entry<Entity, Integer> entry = iterator.next();

                    if (this.ticksExisted >= entry.getValue().intValue()) {
                        iterator.remove();
                    }
                }

                List<EntityLivingBase> list = this.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class,
                        this.getEntityBoundingBox());

                if (!list.isEmpty()) {
                    for (EntityLivingBase entity : list) {
                        if (!this.reapplicationDelayMap.containsKey(entity) && entity.canBeHitWithPotion()) {
                            double d0 = entity.posX - this.posX;
                            double d1 = entity.posZ - this.posZ;
                            double d2 = d0 * d0 + d1 * d1;
                            if (d2 <= f * f) {
                                this.reapplicationDelayMap.put(entity,
                                        Integer.valueOf(this.ticksExisted + this.reapplicationDelay));
                                if (!(entity.isEntityUndead() || entity instanceof EntitySnowman
                                        || entity instanceof Glacon || entity instanceof Frost
                                        || entity instanceof Alicanto || entity instanceof Fractite
                                        || entity instanceof FrostArcher || entity instanceof Frosty
                                        || entity instanceof Glacide || entity instanceof Hastreus
                                        || entity instanceof Rollum)) {
                                    entity.attackEntityFrom(DamageSource.MAGIC, 1.0F);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {
        this.ticksExisted = compound.getInteger("Age");
        this.duration = compound.getInteger("Duration");
        this.reapplicationDelay = compound.getInteger("ReapplicationDelay");
        this.radiusPerTick = compound.getFloat("RadiusPerTick");
        this.setRadius(compound.getFloat("Radius"));
        this.ownerUniqueId = compound.getUniqueId("OwnerUUID");
    }

    public void setDuration(int durationIn) {
        this.duration = durationIn;
    }

    public void setOwner(@Nullable EntityLivingBase ownerIn) {
        this.owner = ownerIn;
        this.ownerUniqueId = ownerIn == null ? null : ownerIn.getUniqueID();
    }

    public void setRadius(float radiusIn) {
        double d0 = this.posX;
        double d1 = this.posY;
        double d2 = this.posZ;
        this.setSize(radiusIn * 2.0F, 0.5F);
        this.setPosition(d0, d1, d2);

        if (!this.world.isRemote) {
            this.getDataManager().set(RADIUS, Float.valueOf(radiusIn));
        }
    }

    public void setRadiusPerTick(float radiusPerTickIn) {
        this.radiusPerTick = radiusPerTickIn;
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {
        compound.setInteger("Age", this.ticksExisted);
        compound.setInteger("Duration", this.duration);
        compound.setInteger("ReapplicationDelay", this.reapplicationDelay);
        compound.setFloat("RadiusPerTick", this.radiusPerTick);
        compound.setFloat("Radius", this.getRadius());
        if (this.ownerUniqueId != null) {
            compound.setUniqueId("OwnerUUID", this.ownerUniqueId);
        }
    }
}