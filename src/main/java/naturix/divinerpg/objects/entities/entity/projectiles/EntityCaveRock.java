package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.objects.entities.assets.render.projectile.RenderCaveRock;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCaveRock extends EntityThrowable {

    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCaveRock.class,
                manager -> new RenderCaveRock(manager, 1f));
    }

    public EntityCaveRock(World var1) {
        super(var1);
    }

    public EntityCaveRock(World var1, EntityLivingBase var2) {
        super(var1, var2);
    }

    public EntityCaveRock(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 6.0F);
        }
        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}