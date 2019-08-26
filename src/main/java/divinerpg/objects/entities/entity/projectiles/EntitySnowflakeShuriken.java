package divinerpg.objects.entities.entity.projectiles;

import divinerpg.objects.entities.assets.render.projectile.RenderSnowShuriken;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySnowflakeShuriken extends EntityThrowable {

    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySnowflakeShuriken.class,
                manager -> new RenderSnowShuriken(manager, 1f));
    }

    public EntitySnowflakeShuriken(World worldIn) {
        super(worldIn);
    }

    public EntitySnowflakeShuriken(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public EntitySnowflakeShuriken(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 7.0F);
        }
        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}