package naturix.divinerpg.entities.entity.projectiles;

import java.util.List;

import naturix.divinerpg.particle.ParticleFrost;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFrostShot extends EntityFireball {
    public EntityFrostShot(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 1.0F);
    }

    @SideOnly(Side.CLIENT)
    public EntityFrostShot(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
        this.setSize(1.0F, 1.0F);
    }

    @Override
    public void onEntityUpdate() {
        if (this.world.isRemote)
        {
            
        }
    }

    public EntityFrostShot(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
        this.setSize(1.0F, 1.0F);
    }

    public static void registerFixesDragonFireball(DataFixer fixer) {
        EntityFireball.registerFixesFireball(fixer, "FrostShot");
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    protected void onImpact(RayTraceResult result) {
        if (result.entityHit == null || !result.entityHit.isEntityEqual(this.shootingEntity)) {
            if (!this.world.isRemote) {
                List<EntityLivingBase> list = this.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class,
                        this.getEntityBoundingBox().grow(4.0D, 2.0D, 4.0D));
                EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(this.world, this.posX,
                        this.posY, this.posZ);

                entityareaeffectcloud.setOwner(this.shootingEntity);
                entityareaeffectcloud.setParticle(EnumParticleTypes.SNOWBALL);
                entityareaeffectcloud.setWaitTime(0);
                entityareaeffectcloud.setRadius(3.0F);
                entityareaeffectcloud.setDuration(50);
                entityareaeffectcloud.setRadiusPerTick(
                        (0.0F - entityareaeffectcloud.getRadius()) / (float) entityareaeffectcloud.getDuration());
                // entityareaeffectcloud.addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE,
                // 1, 1));

                if (!list.isEmpty()) {
                    for (EntityLivingBase entitylivingbase : list) {
                        double d0 = this.getDistanceSq(entitylivingbase);

                        if (d0 < 16.0D) {
                            entityareaeffectcloud.setPosition(entitylivingbase.posX, entitylivingbase.posY,
                                    entitylivingbase.posZ);
                            break;
                        }
                    }
                }

                this.world.playEvent(2006, new BlockPos(this.posX, this.posY, this.posZ), 0);
                this.world.spawnEntity(entityareaeffectcloud);
                this.setDead();
            }
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    protected boolean isFireballFiery() {
        return false;
    }
}
