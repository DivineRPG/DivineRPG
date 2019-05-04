package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.objects.entities.assets.render.projectile.RenderCoriShot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCoriShot extends EntityThrowable {
    private float damage;

    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCoriShot.class,
                manager -> new RenderCoriShot(manager, 1f));
    }

    public EntityCoriShot(World worldIn) {
        super(worldIn);
    }

    public EntityCoriShot(World worldIn, EntityLivingBase entity, float damage) {
        super(worldIn, entity);
        this.damage = damage;
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
        }
        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}